package com.ur.admin.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.menu.mappers.AdminMenuInfoMapper;
import com.ur.admin.menu.model.AdminMenuInfo;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.common.Constants;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class AdminMenuInfoService {	
    @Autowired
    AdminMenuInfoMapper adminMenuInfoMapper;
    
    @Autowired
    RedisMessageBOService redisService;

    public AdminMenuInfo getAdminMenuInfoByPK(Integer pkId) {
        return adminMenuInfoMapper.getAdminMenuInfoByPK(pkId);
    }

    @Transactional
    public Integer insertAdminMenuInfo(AdminMenuInfo adminMenuInfo) {
        
        //TODO handle date columns here
        //adminMenuInfo.setCreatedTime(new Date());
        //adminMenuInfo.setLastUpdatedTime(new Date());
        
        adminMenuInfoMapper.insertAdminMenuInfo(adminMenuInfo);
        redisService.delRedis(Constants.SYSTEM_MENUS_KEY);
        return adminMenuInfo.getId();
    }

    @Transactional
    public int updateAdminMenuInfoByPKSelective(AdminMenuInfo adminMenuInfo) {
        
        //TODO handle date columns here
        //adminMenuInfo.setCreatedTime(new Date());
        //adminMenuInfo.setLastUpdatedTime(new Date());
        
        int result = adminMenuInfoMapper.updateAdminMenuInfoByPKSelective(adminMenuInfo);
        redisService.delRedis(Constants.SYSTEM_MENUS_KEY);
        return result;
    }

    public PagingRestResponse searchAdminMenuInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = adminMenuInfoMapper.searchAdminMenuInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<AdminMenuInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = adminMenuInfoMapper.searchAdminMenuInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    public List<AdminMenuInfo> searchAdminMenuInfo(List<CommonSearchCondition> condList, List<String> orderByList) {
        
        List<AdminMenuInfo> resultList = adminMenuInfoMapper.searchAdminMenuInfo(null,condList, orderByList,null);
        
        return resultList;
    }
    
    @SuppressWarnings("unchecked")
	public List<AdminMenuInfo> searchAdminMenuInfoAll() {
        
        List<AdminMenuInfo> resultList = null;
        try {
        	Object list = redisService.getFromRedis(Constants.SYSTEM_MENUS_KEY);
    		if(list == null || (list != null && ((List<AdminRightshare>)list).size() <= 0 )) {
    			List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
    			CommonSearchCondition cond = new CommonSearchCondition();
    			cond.setBeanName("status");
    			cond.setColumnName("STATUS");
    			cond.setOperator("eq");
    			cond.setValue("1");
    			condList.add(cond);
    			
    			List<String> orderByList = new ArrayList<String>();
    			orderByList.add(" PARENT_MENU_ID asc, ORDERBY asc ");
    			
    			resultList = adminMenuInfoMapper.searchAdminMenuInfo(null, condList, null,null);
    			redisService.addRedis(Constants.SYSTEM_MENUS_KEY, resultList);
    		} else {
    			resultList = (List<AdminMenuInfo>)list;
    		}
        } catch(Exception e) {
        	System.err.println("==获取所有菜单方法：searchAdminMenuInfoAll 异常==");
    		e.printStackTrace();
        }
        return resultList;
    }
    
    
    public int getAdminMenuIdByMappingUrl(String mapUrl) {
        int menuId = -1;
        try {
    		if(mapUrl == null || !"".equals(mapUrl)) {
    			List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
    			CommonSearchCondition cond = new CommonSearchCondition();
    			cond.setBeanName("menuUrl");
    			cond.setColumnName("MENU_URL");
    			cond.setOperator("like");
    			cond.setValue(mapUrl);
    			condList.add(cond);
    			    			
    			List<AdminMenuInfo> menus = adminMenuInfoMapper.searchAdminMenuInfo(null, condList, null,null);
    			if(menus != null && menus.size() > 0) {
    				menuId = menus.get(0).getId();
    			}
    		}
        } catch(Exception e) {
        	System.err.println("==根据菜单URL获取菜单ID方法：getAdminMenuIdByMappingUrl 异常==");
    		e.printStackTrace();
        }
        return menuId;
    }
}