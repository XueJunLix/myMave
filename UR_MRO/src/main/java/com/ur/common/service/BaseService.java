package com.ur.common.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import com.ur.admin.user.mappers.SysUserInfoMapper;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.mro.dic.mappers.DictionaryMapper;
import com.ur.mro.dic.model.Dictionary;
import com.ur.mro.pic.mappers.AttachmentMapper;
import com.ur.mro.pic.model.Attachment;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ur.admin.service.AdminUserInfoService;
import com.ur.common.UserInfo;

@Service
public class BaseService {

	private static Logger log = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    AdminUserInfoService adminUserInfoService;

	@Autowired
	DictionaryMapper dictionaryMapper;

	@Autowired
	AttachmentMapper attachmentMapper;

	private final String SYSTEM_USER_MAP = "SYSTEM_USER_MAP";	//用于在redis上用map存储所有用户

	@Autowired
	SysUserInfoMapper sysUserInfoMapper;

	@Autowired
	RedisMessageBOService redisService;

	public UserInfo getCurrentLoginUserInfo() {
		return adminUserInfoService.getCurrentLoginUserInfo();
	}
	
	public String getUserName() {
		return adminUserInfoService.getCurrentLoginUserName();
	}

    public void setCreateFields(Object obj) {
		this.setCreateFields(obj, this.getUserName());
    }

    public void setUpdateFields(Object obj) {
		this.setUpdateFields(obj, this.getUserName());
    }
    
	public void setCreateFields(Object obj,String userName) {
		Method setMethod = null;
		try {
			log.debug("[setCreateFields]luserName=" + userName);

			setMethod = obj.getClass().getMethod("setCreatedBy", String.class);
			setMethod.invoke(obj, StringUtils.isEmpty(userName) ? "system"
					: userName);

			setMethod = obj.getClass().getMethod("setCreatedTime", Date.class);
			setMethod.invoke(obj, Calendar.getInstance().getTime());
					
			setUpdateFields(obj,userName);
		} catch (InvocationTargetException ite) {
			log.error("[setCreateCommonFields] Invocation Target:" + ite.getStackTrace());
		} catch (IllegalAccessException iae) {
			log.error("[setCreateCommonFields] Illegal Access:" + iae.getStackTrace());
		} catch (java.lang.NoSuchMethodException nsme) {
			log.error("[setCreateCommonFields] No Such Method:" + nsme.getStackTrace());
		}
	}

	public void setUpdateFields(Object obj,String userName) {
		Method setMethod = null;
		try {
			setMethod = obj.getClass().getMethod("setLastUpdatedBy", String.class);
			setMethod.invoke(obj, StringUtils.isEmpty(userName) ? "system"
						: userName);

			setMethod = obj.getClass().getMethod("setLastUpdatedTime", Date.class);
			setMethod.invoke(obj, Calendar.getInstance().getTime());	
		} catch (InvocationTargetException ite) {
			log.error("[setCreateCommonFields] Invocation Target:" + ite.getStackTrace());
		} catch (IllegalAccessException iae) {
			log.error("[setCreateCommonFields] Illegal Access:" + iae.getStackTrace());
		} catch (java.lang.NoSuchMethodException nsme) {
			log.error("[setCreateCommonFields] No Such Method:" + nsme.getStackTrace());
		}
	}

	/**
	 * 通過Sgroup and skey找到对应的值
	 * @param sgroup
	 * @param skey
	 * @return
	 */
	public String getDicSvalue(String sgroup,String skey){

		return dictionaryMapper.getSvalueBySgoupandSkey(sgroup,skey);

	}


	/**
	 * 通过sgroup找到相对应的数据集
	 * @param sgroup
	 * @return
	 */
	public Map<String,String> getMapBySgroup (String sgroup){
		List<Dictionary> dicList = dictionaryMapper.getListBySgroup(sgroup);
		Map<String,String> dicMap = new HashMap<String,String>();
		for(int i = 0;i<dicList.size();i++){
			Dictionary dictionary = dicList.get(i);
			String skey = dictionary.getSkey();
			String svalue = dictionary.getSvalue();
			dicMap.put(skey,svalue);

		}
		return  dicMap;
	}

	/**
	 * 通过svalue找到skey
	 * @param sgroup
	 * @return
	 */
	public Map<String,String> getMapBygetSkeyByValue (String sgroup){
		List<Dictionary> dicList = dictionaryMapper.getListBySgroup(sgroup);
		Map<String,String> dicMap = new HashMap<String,String>();
		for(int i = 0;i<dicList.size();i++){
			Dictionary dictionary = dicList.get(i);
			String skey = dictionary.getSkey();
			String svalue = dictionary.getSvalue();
			dicMap.put(svalue,skey);

		}
		return  dicMap;
	}


	public String select(T object) {
		return new SQL() {
			{
				SELECT("*");
				FROM(object.getClass().getSimpleName());
				try {
					Field[] fields = object.getClass().getDeclaredFields();
					for (Field field : fields) {
						field.setAccessible(true);
						Object v = field.get(object);
						if (v != null) {
							String fieldName = field.getName();
							if (v instanceof String && ((String)v).contains("%")) {
								WHERE(fieldName + " like '"+v+"'" );
							} else {
								WHERE(fieldName + "=#{" + fieldName + "}");
							}

						}
					}
				} catch (Exception e) {
				}

			}
		}.toString();
	}

	public List<Attachment> getAttachmentList(Integer rowId,String classname){

		return attachmentMapper.getPicByRowIdAndClassName(rowId, classname);
	}


	/**
	 * 获取所有的用户数据，存进map里面，然后丢到redis.
	 * @return
	 */
	public Map<String,String> getAllSysUserInfo(){

		Map<String,String> userMap = new HashMap<String,String>();
		Object map = redisService.getFromRedis(SYSTEM_USER_MAP);

		if(map==null){
			List<SysUserInfo> sysUserInfoList = sysUserInfoMapper.getAllSysUserInfo();
			for(int i = 0;i<sysUserInfoList.size();i++){
				SysUserInfo sysUserInfo = sysUserInfoList.get(i);
				String loginName = sysUserInfo.getLoginName();
				String name = sysUserInfo.getName();
				userMap.put(loginName,name);
			}
			redisService.addRedis(SYSTEM_USER_MAP, userMap);
		}else{
			userMap  =(Map<String,String>) map;
		}
		return userMap;
	}

	public void saveFj(List<Attachment> fjids,String className,Integer id) {
		if (fjids == null || fjids.size() == 0) {
			return;
		} else {
			for (int i = 0; i < fjids.size(); i++) {
				Attachment attachmentVO = fjids.get(i);
				attachmentVO.setClassname(className);
				 attachmentVO.setId(id);
			}

		  	attachmentMapper.insertBatchAttachment(fjids);
		}
	}

	public static void main(String[] args) {

	}

}
