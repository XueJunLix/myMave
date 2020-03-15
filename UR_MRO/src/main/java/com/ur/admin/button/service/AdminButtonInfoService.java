package com.ur.admin.button.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.button.mappers.AdminButtonInfoMapper;
import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.common.Constants;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class AdminButtonInfoService {
		
    @Autowired
    AdminButtonInfoMapper adminButtonInfoMapper;
    
    @Autowired
    RedisMessageBOService redisService;

    public AdminButtonInfo getAdminButtonInfoByPK(Integer pkId) {
        return adminButtonInfoMapper.getAdminButtonInfoByPK(pkId);
    }

    @Transactional
    public Integer insertAdminButtonInfo(AdminButtonInfo adminButtonInfo) {
        
        //TODO handle date columns here
        //adminButtonInfo.setCreatedTime(new Date());
        //adminButtonInfo.setLastUpdatedTime(new Date());
        
        adminButtonInfoMapper.insertAdminButtonInfo(adminButtonInfo);
      //新增成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_BUTTON_KEY);
        return adminButtonInfo.getId();
    }

    @Transactional
    public int updateAdminButtonInfoByPKSelective(AdminButtonInfo adminButtonInfo) {
        
        //TODO handle date columns here
        //adminButtonInfo.setCreatedTime(new Date());
        //adminButtonInfo.setLastUpdatedTime(new Date());
        
        int result = adminButtonInfoMapper.updateAdminButtonInfoByPKSelective(adminButtonInfo);
      //新增成功：删除redis key，在查询时重新加载在redis
        redisService.delRedis(Constants.SYSTEM_BUTTON_KEY);
        return result;
    }

    public PagingRestResponse searchAdminButtonInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = adminButtonInfoMapper.searchAdminButtonInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<AdminButtonInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = adminButtonInfoMapper.searchAdminButtonInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    @SuppressWarnings("unchecked")
	public List<AdminButtonInfo> searchAdminButtonInfoAll(){
    	List<AdminButtonInfo> resultList = null;
    	try {
    		Object list = redisService.getFromRedis(Constants.SYSTEM_BUTTON_KEY);
    		if(list == null || (list != null && ((List<AdminRightshare>)list).size() <= 0 )) {
    			resultList = adminButtonInfoMapper.searchAdminButtonInfo(null, null, null, null);
    			redisService.addRedis(Constants.SYSTEM_BUTTON_KEY, resultList);
    		} else {
    			resultList = (List<AdminButtonInfo>)list;
    		}
		} catch (Exception e) {
			System.err.println("获取所有操作按钮异常-searchAdminButtonInfoAll：");
			e.printStackTrace();
		}
    	return resultList;
    }
    
    public List<AdminButtonInfo> searchAdminButtonInfo(List<CommonSearchCondition> condList, List<String> orderByList) {
        List<AdminButtonInfo> resultList = adminButtonInfoMapper.searchAdminButtonInfo(null, condList, orderByList, null);
        return resultList;
    }
}