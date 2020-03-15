package com.ur.common.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ur.common.UserInfo;

@Service
@Slf4j
public class BaseService {

    private final UserInfoService userInfoService;

	@Autowired
	public BaseService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public UserInfo getCurrentLoginUserInfo() {
		return userInfoService.getCurrentLoginUserInfo();
	}
	
	public String getUserName() {
		return userInfoService.getCurrentLoginUserName();
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

			setMethod = obj.getClass().getMethod("setCreateBy", String.class);
			setMethod.invoke(obj, StringUtils.isEmpty(userName) ? "system"
					: userName);

			setMethod = obj.getClass().getMethod("setCreateTime", Date.class);
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
			setMethod = obj.getClass().getMethod("setModifyBy", String.class);
			setMethod.invoke(obj, StringUtils.isEmpty(userName) ? "system"
						: userName);

			setMethod = obj.getClass().getMethod("setModifyTime", Date.class);
			setMethod.invoke(obj, Calendar.getInstance().getTime());	
		} catch (InvocationTargetException ite) {
			log.error("[setCreateCommonFields] Invocation Target:" + ite.getStackTrace());
		} catch (IllegalAccessException iae) {
			log.error("[setCreateCommonFields] Illegal Access:" + iae.getStackTrace());
		} catch (java.lang.NoSuchMethodException nsme) {
			log.error("[setCreateCommonFields] No Such Method:" + nsme.getStackTrace());
		}
	}


}
