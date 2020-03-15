package com.ur.admin.usergroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.usergroup.mappers.AdminUserGroupMapper;
import com.ur.admin.usergroup.model.AdminUserGroup;
import com.ur.common.Constants;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class AdminUserGroupService {
	
    @Autowired
    AdminUserGroupMapper adminUserGroupMapper;
    
    @Autowired
	RedisMessageBOService redisService;

    public AdminUserGroup getAdminUserGroupByPK(Integer pkId) {
        return adminUserGroupMapper.getAdminUserGroupByPK(pkId);
    }

    @Transactional
    public Integer insertAdminUserGroup(AdminUserGroup adminUserGroup) {
        
        //TODO handle date columns here
        //adminUserGroup.setCreatedTime(new Date());
        //adminUserGroup.setLastUpdatedTime(new Date());
    	adminUserGroupMapper.insertAdminUserGroup(adminUserGroup);
        int userGroupId = adminUserGroup.getId();
        //新增成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_USERGROUP_KEY);
        return userGroupId;
    }

    @Transactional
    public int updateAdminUserGroupByPKSelective(AdminUserGroup adminUserGroup) {
        
        //TODO handle date columns here
        //adminUserGroup.setCreatedTime(new Date());
        //adminUserGroup.setLastUpdatedTime(new Date());
        
        int result = adminUserGroupMapper.updateAdminUserGroupByPKSelective(adminUserGroup);
        //修改成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_USERGROUP_KEY);
        return result;
    }

    public PagingRestResponse searchAdminUserGroup(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = adminUserGroupMapper.searchAdminUserGroupCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<AdminUserGroup> resultList = null;
        if(totalRecordNum>0){
            resultList = adminUserGroupMapper.searchAdminUserGroup(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    public List<AdminUserGroup> searchAdminUserGroup(List<CommonSearchCondition> condList, List<String> orderByList) {
        return adminUserGroupMapper.searchAdminUserGroup(null, condList, orderByList, null);
    }
    
    @SuppressWarnings("unchecked")
	public List<AdminUserGroup> searchAdminUserGroupAll() {
    	List<AdminUserGroup> resultList = null;
    	
    	try {
    		Object list = redisService.getFromRedis(Constants.SYSTEM_USERGROUP_KEY);
    		if(list == null || (list != null && ((List<AdminRightshare>)list).size() <= 0 )) {
    			resultList = adminUserGroupMapper.searchAdminUserGroup(null, null, null, null);
    			redisService.addRedis(Constants.SYSTEM_USERGROUP_KEY, resultList);
    		} else {
    			resultList = (List<AdminUserGroup>)list;
    		}
    	} catch (Exception e) {
    		System.err.println("==获取所有用户组方法：searchAdminUserGroupAll 异常==");
    		e.printStackTrace();
    	}
        return resultList;
    }
}