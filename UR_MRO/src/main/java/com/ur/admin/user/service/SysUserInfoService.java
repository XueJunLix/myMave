package com.ur.admin.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.user.mappers.SysUserInfoMapper;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.common.Constants;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class SysUserInfoService {
    @Autowired
    SysUserInfoMapper sysUserInfoMapper;
    
    @Autowired
	RedisMessageBOService redisService;

    public SysUserInfo getSysUserInfoByPK(Integer pkId) {
        return sysUserInfoMapper.getSysUserInfoByPK(pkId);
    }

    @Transactional
    public Integer insertSysUserInfo(SysUserInfo sysUserInfo) {
        
        //TODO handle date columns here
        //sysUserInfo.setCreatedTime(new Date());
        //sysUserInfo.setLastUpdatedTime(new Date());
        
        sysUserInfoMapper.insertSysUserInfo(sysUserInfo);
      //修改成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_USER_KEY);
        return sysUserInfo.getId();
    }

    @Transactional
    public int updateSysUserInfoByPKSelective(SysUserInfo sysUserInfo) {
        
        //TODO handle date columns here
        //sysUserInfo.setCreatedTime(new Date());
        //sysUserInfo.setLastUpdatedTime(new Date());
        
        int result = sysUserInfoMapper.updateSysUserInfoByPKSelective(sysUserInfo);
      //修改成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_USER_KEY);
        
        return result;
    }

    public PagingRestResponse searchSysUserInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = sysUserInfoMapper.searchSysUserInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SysUserInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = sysUserInfoMapper.searchSysUserInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    public List<SysUserInfo> searchSysUserInfo(List<CommonSearchCondition> condList, List<String> orderByList){
    	return sysUserInfoMapper.searchSysUserInfo(null, condList, orderByList, null);
    }
    
    @SuppressWarnings("unchecked")
    public List<SysUserInfo> searchSysUserInfoAll(){
    	List<SysUserInfo> resultList = null;
    	
    	try {
    		Object list = redisService.getFromRedis(Constants.SYSTEM_USER_KEY);
    		if(list == null || (list != null && ((List<SysUserInfo>)list).size() <= 0 )) {
    			resultList = sysUserInfoMapper.searchSysUserInfo(null, null, null, null);
    			redisService.addRedis(Constants.SYSTEM_USER_KEY, resultList);
    		} else {
    			resultList = (List<SysUserInfo>)list;
    		}
    	} catch (Exception e) {
    		System.err.println("==获取所有用户方法：searchSysUserInfoAll 异常==");
    		e.printStackTrace();
    	}
        return resultList;
    }
    
}