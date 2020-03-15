package com.ur.admin.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.role.mappers.AdminRoleInfoMapper;
import com.ur.admin.role.model.AdminRoleInfo;
import com.ur.common.Constants;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class AdminRoleInfoService {
	
    @Autowired
    AdminRoleInfoMapper adminRoleInfoMapper;
    
    @Autowired
	RedisMessageBOService redisService;

    public AdminRoleInfo getAdminRoleInfoByPK(Integer pkId) {
        return adminRoleInfoMapper.getAdminRoleInfoByPK(pkId);
    }

    @Transactional
    public Integer insertAdminRoleInfo(AdminRoleInfo adminRoleInfo) {
        
        //TODO handle date columns here
        //adminRoleInfo.setCreatedTime(new Date());
        //adminRoleInfo.setLastUpdatedTime(new Date());
        
        adminRoleInfoMapper.insertAdminRoleInfo(adminRoleInfo);
        //新增成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_ROLES_KEY);
        return adminRoleInfo.getId();
    }

    @Transactional
    public int updateAdminRoleInfoByPKSelective(AdminRoleInfo adminRoleInfo) {
        
        //TODO handle date columns here
        //adminRoleInfo.setCreatedTime(new Date());
        //adminRoleInfo.setLastUpdatedTime(new Date());
        
        int result = adminRoleInfoMapper.updateAdminRoleInfoByPKSelective(adminRoleInfo);
        //修改成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_ROLES_KEY);
        
        return result;
    }

    public PagingRestResponse searchAdminRoleInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = adminRoleInfoMapper.searchAdminRoleInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<AdminRoleInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = adminRoleInfoMapper.searchAdminRoleInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    public List<AdminRoleInfo> searchAdminRoleInfo(List<CommonSearchCondition> condList, List<String> orderByList) {
        return adminRoleInfoMapper.searchAdminRoleInfo(null, condList, orderByList, null);
    }
    
    @SuppressWarnings("unchecked")
	public List<AdminRoleInfo> searchAdminRoleInfoAll() {
    	List<AdminRoleInfo> resultList = null;
    	
    	try {
    		Object list = redisService.getFromRedis(Constants.SYSTEM_ROLES_KEY);
    		if(list == null || (list != null && ((List<AdminRightshare>)list).size() <= 0 )) {
    			resultList = adminRoleInfoMapper.searchAdminRoleInfo(null, null, null, null);
    			redisService.addRedis(Constants.SYSTEM_ROLES_KEY, resultList);
    		} else {
    			resultList = (List<AdminRoleInfo>)list;
    		}
    	} catch (Exception e) {
    		System.err.println("==获取所有角色方法：searchAdminRoleInfoDef 异常==");
    		e.printStackTrace();
    	}
	    return resultList;
    }
}