package com.ur.admin.usergroup.controller;

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

import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.admin.usergroup.model.AdminUserGroup;
import com.ur.admin.usergroup.service.AdminUserGroupService;
import com.ur.common.service.BaseService;
import com.ur.common.util.Util;
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
@RequestMapping(value = "/usergroup")
@Api(description = "AdminUserGroupController的注释")
public class AdminUserGroupController {
    private static final Logger logger = LoggerFactory.getLogger(AdminUserGroupController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AdminUserGroupService adminUserGroupService;
    
    @Autowired
    AdminRightshareService rightService;
    
    @Autowired
    SysUserInfoService userService;
    
    @Autowired
    BaseService baseService;
    
    @RequestMapping(value="/AdminUserGroupList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminUserGroupList默认页面模板", notes = "AdminUserGroupList默认页面模板")
    public String AdminUserGroupList() {
    	logger.debug("用户组列表进入...");
        return "admin/AdminGroupInfoList";
    }
    
    @RequestMapping(value = "/AdminUserGroup/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "/AdminUserGroup通用查询方法", notes = "AdminUserGroup通用查询方法",response = AdminUserGroup.class, responseContainer="List")
    public CommonRestResponse searchAdminUserGroup(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
    	logger.debug("用户组搜索...");
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminUserGroup.class);
            PagingRestResponse response = adminUserGroupService.searchAdminUserGroup(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/AdminUserGroupEdit", method = RequestMethod.GET)
    @ApiOperation(value = "AdminUserGroupEdit默认页面模板", notes = "AdminUserGroupEdit默认页面模板")
    public String AdminUserGroupEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String groupId = httpRequest.getParameter("groupId");
        AdminUserGroup adminUserGroup = new AdminUserGroup();
        boolean isUpdate = false;
        
        JSONArray currUserArray = new JSONArray();
        
        //	transfer已选用户数据
        JSONArray selectUsers = new JSONArray();
        
        if(groupId != null && !groupId.equals("")){
        	adminUserGroup = adminUserGroupService.getAdminUserGroupByPK(Integer.valueOf(groupId));
            isUpdate = true;
            
            //获取该用户组下所有的成员
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
        	CommonSearchCondition cond = new CommonSearchCondition();
        	cond.setBeanName("rightType");
        	cond.setColumnName("RIGHT_TYPE");
        	cond.setOperator("eq");
        	cond.setValue("U");
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
        	cond.setBeanName("rightSourceId");
        	cond.setColumnName("RIGHT_SOURCE_ID");
        	cond.setOperator("eq");
        	cond.setValue(groupId);
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
        	cond.setBeanName("resourceType");
        	cond.setColumnName("RESOURCE_TYPE");
        	cond.setOperator("eq");
        	cond.setValue("2");
        	condList.add(cond);
        	
        	List<AdminRightshare> rightShares = rightService.searchAdminRightshareDef(condList);
        	if(rightShares != null && rightShares.size() > 0) {
        		for (AdminRightshare ar : rightShares) {
        			int userId = ar.getResourceId();
        			
        			SysUserInfo u = userService.getSysUserInfoByPK(userId);
        			
        			String key = String.valueOf(u.getId());
        			String label = u.getLoginName() + "_" + u.getName();
        			
        			JSONObject obj = new JSONObject();
        			obj.put("key", key);
        			obj.put("label", label);
        			currUserArray.add(obj);
        			
        			selectUsers.add(u.getId());
				}
        	}
        } else {
        	adminUserGroup.setStatus(1);
        }
        adminUserGroup.setCurrUserArray(currUserArray);
        
        model.addAttribute("adminUserGroup",adminUserGroup);
        
        //	组件transfer数据
        JSONArray allUserArray = new JSONArray();
        List<SysUserInfo> allUsers = userService.searchSysUserInfoAll();
        if(allUsers != null && allUsers.size() > 0) {
        	for (SysUserInfo u : allUsers) {
				JSONObject userObj = new JSONObject();
				userObj.put("key", u.getId());
				userObj.put("label", u.getLoginName() + "_" + u.getName());
				allUserArray.add(userObj);
			}
        }
        model.addAttribute("allUserArray",allUserArray);
        model.addAttribute("selectUsers", selectUsers);
        
        
        model.addAttribute("isUpdate",isUpdate);
        return "admin/AdminGroupInfoManage";
    }
    
    @RequestMapping(value = "/AdminUserGroup/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入AdminUserGroup对象", notes = "插入AdminUserGroup对象")
    public CommonRestResponse insertAdminUserGroup(HttpServletRequest httpRequest, @RequestBody AdminUserGroup adminUserGroup) {
        try {
        	String errMsg = "";
        	
        	String userGroupCode = adminUserGroup.getGroupCode();
        	String userGroupName = adminUserGroup.getGroupName();
        	
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("groupCode");
            cond.setColumnName("GROUP_CODE");
            cond.setOperator("eq");
            cond.setValue(userGroupCode);
        	condList.add(cond);
        	List<AdminUserGroup> groupList = adminUserGroupService.searchAdminUserGroup(condList, null);
        	if(groupList != null && groupList.size() > 0) {
        		errMsg += "该用户组编码已经存在!";
        	}
        	
        	condList = new ArrayList<CommonSearchCondition>();
            cond = new CommonSearchCondition();
            cond.setBeanName("groupName");
            cond.setColumnName("GROUP_NAME");
            cond.setOperator("eq");
            cond.setValue(userGroupName);
        	condList.add(cond);
        	groupList = adminUserGroupService.searchAdminUserGroup(condList, null);
        	if(groupList != null && groupList.size() > 0) {
        		errMsg += "该用户组名称已经存在!";
        	}
        	
        	if("".equals(errMsg)) {
	        	adminUserGroup.setCreatedBy(baseService.getUserName());
	        	adminUserGroup.setCreatedTime(new Date());
	        	adminUserGroup.setLastUpdatedBy(baseService.getUserName());
	        	adminUserGroup.setLastUpdatedTime(new Date());
	            int userGroupId = adminUserGroupService.insertAdminUserGroup(adminUserGroup);
	            
	            JSONArray userArray = adminUserGroup.getCurrUserArray();
	            //System.err.println("=====userIDS size=" + users.size());
	            List<AdminRightshare> rights = null;
	            if(userArray != null && userArray.size() > 0) {
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object userObj : userArray) {
						AdminRightshare ar = new AdminRightshare();
						ar.setRightType("U");
						ar.setRightSourceId(userGroupId);
						ar.setResourceType("2");
						ar.setResourceId(Integer.valueOf(JSONObject.fromObject(userObj).getString("key")));
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
    
    @RequestMapping(value = "/AdminUserGroup/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新AdminUserGroup", notes = "根据pkId更新AdminUserGroup")
    public CommonRestResponse updateAdminUserGroupByPKSelective(HttpServletRequest httpRequest, @RequestBody AdminUserGroup adminUserGroup) {
        try {
        	String errMsg = "";
        	
        	String userGroupId = Util.null2String(adminUserGroup.getId());
        	String userGroupCode = adminUserGroup.getGroupCode();
        	String userGroupName = adminUserGroup.getGroupName();
        	
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("groupCode");
            cond.setColumnName("GROUP_CODE");
            cond.setOperator("eq");
            cond.setValue(userGroupCode);
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(userGroupId);
        	condList.add(cond);
        	
        	List<AdminUserGroup> groupList = adminUserGroupService.searchAdminUserGroup(condList, null);
        	if(groupList != null && groupList.size() > 0) {
        		errMsg += "该用户组编码已经存在!";
        	}
        	
        	condList = new ArrayList<CommonSearchCondition>();
            cond = new CommonSearchCondition();
            cond.setBeanName("groupName");
            cond.setColumnName("GROUP_NAME");
            cond.setOperator("eq");
            cond.setValue(userGroupName);
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(userGroupId);
        	condList.add(cond);
        	
        	groupList = adminUserGroupService.searchAdminUserGroup(condList, null);
        	if(groupList != null && groupList.size() > 0) {
        		errMsg += "该用户组名称已经存在!";
        	}
        	
        	if("".equals(errMsg)) {
	        	adminUserGroup.setLastUpdatedBy(baseService.getUserName());
	        	adminUserGroup.setLastUpdatedTime(new Date());
	            adminUserGroupService.updateAdminUserGroupByPKSelective(adminUserGroup);
	            
	            JSONArray userArray = adminUserGroup.getCurrUserArray();
	            List<AdminRightshare> rights = null;
	            if(userArray != null && userArray.size() > 0) {
	            	//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("U");
	        		arDel.setRightSourceId(adminUserGroup.getId());
	        		arDel.setResourceType("2");
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	            	
	        		rights = new ArrayList<AdminRightshare>();
	            	for (Object userObj : userArray) {
						AdminRightshare ar = new AdminRightshare();
						ar.setRightType("U");
						ar.setRightSourceId(adminUserGroup.getId());
						ar.setResourceType("2");
						ar.setResourceId(Integer.valueOf(JSONObject.fromObject(userObj).getString("key")));
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
    
    
    
    
    
    
    
    
    
    
    
    
    

    @RequestMapping(value="AdminUserGroup",method = RequestMethod.GET)
    @ApiOperation(value = "AdminUserGroup默认页面模板", notes = "AdminUserGroup默认页面模板")
    public String AdminUserGroupTemplate() {
        return "AdminUserGroup";
    }

    @RequestMapping(value = "AdminUserGroup/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取AdminUserGroup", notes = "根据pkId获取AdminUserGroup",response = AdminUserGroup.class)
    public CommonRestResponse getAdminUserGroupByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            AdminUserGroup adminUserGroup = adminUserGroupService.getAdminUserGroupByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminUserGroup);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    

   

    

    @RequestMapping(value = "AdminUserGroup/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminUserGroup导出接口，返回待下载的Excel文件名", notes = "AdminUserGroup导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAdminUserGroup(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminUserGroup.class);
            PagingRestResponse response = adminUserGroupService.searchAdminUserGroup(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<AdminUserGroup> resultList = (List<AdminUserGroup>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("groupCode");
                headerList.add("groupName");
                headerList.add("memo");
                headerList.add("状态：0启用，1禁用");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(AdminUserGroup row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getGroupCode());
                    rowList.add(row.getGroupName());
                    rowList.add(row.getMemo());
                    rowList.add(row.getStatus());
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