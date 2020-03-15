package com.ur.admin.button.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.button.service.AdminButtonInfoService;
import com.ur.admin.menu.model.AdminMenuInfo;
import com.ur.admin.menu.service.AdminMenuInfoService;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.common.service.BaseService;
import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/button")
@Api(description = "AdminButtonInfoController的注释")
public class AdminButtonInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AdminButtonInfoController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AdminButtonInfoService adminButtonInfoService;
    
    @Autowired
    BaseService baseService;
    
    @Autowired
    AdminRightshareService rightService;
    
    @Autowired
    AdminMenuInfoService adminMenuInfoService;
    
    @RequestMapping(value="/AdminButtonInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminButtonInfoList默认页面模板", notes = "AdminButtonInfoList默认页面模板")
    public String AdminButtonInfoList() {
    	logger.debug("进入按钮查询页面....." + baseService.getUserName());
        return "admin/AdminButtonInfoList";
    }
    
    @RequestMapping(value = "/AdminButtonInfo/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminButtonInfo通用查询方法", notes = "AdminButtonInfo通用查询方法",response = AdminButtonInfo.class, responseContainer="List")
    public CommonRestResponse searchAdminButtonInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
        	logger.debug("进入按钮查询搜索页面....." + baseService.getUserName());
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminButtonInfo.class);
            PagingRestResponse response = adminButtonInfoService.searchAdminButtonInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/AdminButtonInfoEdit", method = RequestMethod.GET)
    @ApiOperation(value = "AdminButtonInfoEdit默认页面模板", notes = "AdminButtonInfoEdit默认页面模板")
    public String AdminButtonInfoEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("buttonId");
        AdminButtonInfo adminButtonInfo = new AdminButtonInfo();
        boolean isUpdate = false;
        JSONArray checkedMenus = new JSONArray();

        if(id!=null && !id.equals("")){
            adminButtonInfo = adminButtonInfoService.getAdminButtonInfoByPK(Integer.valueOf(id));
            isUpdate = true;
            
            //获取已分配的菜单
            List<AdminRightshare> rightList = rightService.searchAdminRightshareAll("M", "3");
            if(rightList != null && rightList.size() > 0) {
            	for (AdminRightshare ar : rightList) {
            		if(adminButtonInfo.getId() == ar.getResourceId()) {
            			checkedMenus.add(ar.getRightSourceId());
            		}
				}
            }
        }
        adminButtonInfo.setCheckedMenus(checkedMenus);
        
        /* **begin 获取所有菜单列表********************************************** */
	   	List<AdminMenuInfo> currAllmenus = adminMenuInfoService.searchAdminMenuInfoAll();
	   	JSONArray currAllmenusArray = new JSONArray();
	   	 
	   	List<AdminMenuInfo> l1 = new ArrayList<AdminMenuInfo>();
	   	List<AdminMenuInfo> l2 = new ArrayList<AdminMenuInfo>();
	   	List<AdminMenuInfo> l3 = new ArrayList<AdminMenuInfo>();
	   	 
	   	 if(currAllmenus.size() > 0) {
	   		 for (AdminMenuInfo menu : currAllmenus) {
	   			 int level = menu.getMenuLevel();
	   			 if(level == 1) {
	   				 l1.add(menu);
	   			 } else if(level == 2) {
	   				 l2.add(menu);
	   			 } else if(level == 3) {
	   				 l3.add(menu);
	   			 }
	   		 }
	   		 
	   		 for(AdminMenuInfo m1 : l1) {
	   			int menuId1 = m1.getId();
	   			String manuName1 = m1.getMenuName();
	   			
				JSONObject o1 = new JSONObject();
				o1.put("id", menuId1);
				o1.put("label", manuName1);
				
				JSONArray children2 = new JSONArray();
				
				for(AdminMenuInfo m2 : l2) {
					int menuId2 = m2.getId();
		   			String manuName2 = m2.getMenuName();
		   			int menuParentId2 = m2.getParentMenuId();
					
					JSONObject o2 = new JSONObject();
					o2.put("id", menuId2);
					o2.put("label", manuName2);
					
					JSONArray children3 = new JSONArray();
					for(AdminMenuInfo m3 : l3) {
						int menuId3 = m3.getId();
			   			String manuName3 = m3.getMenuName();
			   			int menuParentId3 = m3.getParentMenuId();
						
			   			if(menuParentId3 == menuId2) {
							JSONObject o3 = new JSONObject();
							o3.put("id", menuId3);
							o3.put("label", manuName3);
							
							children3.add(o3);
			   			}
					}
					if(children3.size() > 0) {
						o2.put("children", children3);
					}
					
					if(menuParentId2 == menuId1) {
						children2.add(o2);
					}
				}
				if(children2.size() > 0) {
					o1.put("children", children2);
				}
				currAllmenusArray.add(o1);
	   		 }
	   	 }
	   	 //System.err.println("===currAllmenusArray=" + currAllmenusArray);
	   	 model.addAttribute("currAllmenusArray",currAllmenusArray);
	   	 /* **end** 获取所有菜单列表********************************************** */
        
        model.addAttribute("adminButtonInfo",adminButtonInfo);
        model.addAttribute("isUpdate",isUpdate);
        return "admin/AdminButtonInfoManage";
    }
    
    @RequestMapping(value = "/AdminButtonInfo/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入AdminButtonInfo对象", notes = "插入AdminButtonInfo对象")
    public CommonRestResponse insertAdminButtonInfo(HttpServletRequest httpRequest, @RequestBody AdminButtonInfo adminButtonInfo) {
        try {
        	String errMsg = "";
            
            String buttonCode = adminButtonInfo.getButtonCode();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("buttonCode");
            cond.setColumnName("BUTTON_CODE");
            cond.setOperator("eq");
            cond.setValue(buttonCode);
            condList.add(cond);
            List<AdminButtonInfo> menuList = adminButtonInfoService.searchAdminButtonInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该按钮编码已存在!";
            }      	
        	
        	if("".equals(errMsg)) {
	        	adminButtonInfo.setCreatedBy(baseService.getUserName());
	        	adminButtonInfo.setCreatedTime(new Date());
	        	adminButtonInfo.setLastUpdatedBy(baseService.getUserName());
	        	adminButtonInfo.setLastUpdatedTime(new Date());
	        	
	            int buttonId = adminButtonInfoService.insertAdminButtonInfo(adminButtonInfo);
	            
	            //按钮授权授权
	            List<AdminRightshare> rights = null;
	            
	            JSONArray menuIds = adminButtonInfo.getCheckedMenus();
	            if(menuIds != null && menuIds.size() > 0) {
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object id : menuIds) {
	            		AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(Integer.valueOf(id.toString()));
	    				ar.setResourceType("3");
	    				ar.setResourceId(buttonId);
	    				rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        	} else {
        		return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,errMsg,null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/AdminButtonInfo/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新AdminButtonInfo", notes = "根据pkId更新AdminButtonInfo")
    public CommonRestResponse updateAdminButtonInfoByPKSelective(HttpServletRequest httpRequest, @RequestBody AdminButtonInfo adminButtonInfo) {
        try {
        	String errMsg = "";
            
            String buttonCode = adminButtonInfo.getButtonCode();
            int buttonId = adminButtonInfo.getId();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("buttonCode");
            cond.setColumnName("BUTTON_CODE");
            cond.setOperator("eq");
            cond.setValue(buttonCode);
            condList.add(cond);
            
            cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(adminButtonInfo.getId()));
            condList.add(cond);
            
            List<AdminButtonInfo> menuList = adminButtonInfoService.searchAdminButtonInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该按钮编码已存在!";
            }
        	
        	if("".equals(errMsg)) {
	        	adminButtonInfo.setLastUpdatedBy(baseService.getUserName());
	        	adminButtonInfo.setLastUpdatedTime(new Date());
	        	
	            adminButtonInfoService.updateAdminButtonInfoByPKSelective(adminButtonInfo);
	            
	          //按钮授权授权
	            List<AdminRightshare> rights = null;
	            
	            JSONArray menuIds = adminButtonInfo.getCheckedMenus();
	            System.err.println("====menuids=" + menuIds);
	            if(menuIds != null && menuIds.size() > 0) {
	            	//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("M");
	        		arDel.setResourceType("3");
	        		arDel.setResourceId(buttonId);
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	            	
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object id : menuIds) {
	            		AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(Integer.valueOf(id.toString()));
	    				ar.setResourceType("3");
	    				ar.setResourceId(buttonId);
	    				rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        	} else {
        		return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,errMsg,null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @RequestMapping(value="AdminButtonInfo",method = RequestMethod.GET)
    @ApiOperation(value = "AdminButtonInfo默认页面模板", notes = "AdminButtonInfo默认页面模板")
    public String AdminButtonInfoTemplate() {
        return "AdminButtonInfo";
    }

    @RequestMapping(value = "AdminButtonInfo/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取AdminButtonInfo", notes = "根据pkId获取AdminButtonInfo",response = AdminButtonInfo.class)
    public CommonRestResponse getAdminButtonInfoByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            AdminButtonInfo adminButtonInfo = adminButtonInfoService.getAdminButtonInfoByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminButtonInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    

    

    
    @RequestMapping(value = "AdminButtonInfo/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminButtonInfo导出接口，返回待下载的Excel文件名", notes = "AdminButtonInfo导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAdminButtonInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminButtonInfo.class);
            PagingRestResponse response = adminButtonInfoService.searchAdminButtonInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<AdminButtonInfo> resultList = (List<AdminButtonInfo>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("buttonCode");
                headerList.add("buttonName");
                headerList.add("buttonClick");
                headerList.add("buttonIcon");
                headerList.add("buttonClass");
                headerList.add("buttonStyle");
                headerList.add("orderby");
                headerList.add("memo");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(AdminButtonInfo row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getButtonCode());
                    rowList.add(row.getButtonName());
                    rowList.add(row.getButtonClick());
                    rowList.add(row.getButtonIcon());
                    rowList.add(row.getButtonClass());
                    rowList.add(row.getButtonStyle());
                    rowList.add(row.getOrderby());
                    rowList.add(row.getMemo());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    contentList.add(rowList);
                }
                
                String fileName = UuidKit.getUuid();
                
                ExcelWriteBean writeBean = new ExcelWriteBean();
                writeBean.setFileName(fileName);
                writeBean.setFileType(ExcelConfig.FT_XLSX);
                writeBean.setHeaderList(headerList);
                writeBean.setContentList(contentList);
                
                ExcelWriteKit kit = new ExcelWriteKit();
                kit.outputExcel(writeBean, tempFilePath,seperator);
                
                Map<String,String> returnObj = new HashMap<String,String>();
                returnObj.put("fileName", fileName);
                returnObj.put("extName", ExcelConfig.FT_XLSX);
                
                return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,returnObj);
            }else {
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"查询数据失败",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
}