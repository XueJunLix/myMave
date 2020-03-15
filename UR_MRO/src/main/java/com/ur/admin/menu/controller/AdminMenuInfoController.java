package com.ur.admin.menu.controller;

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
import com.ur.admin.role.model.AdminRoleInfo;
import com.ur.admin.role.service.AdminRoleInfoService;
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
@RequestMapping(value = "/menu")
@Api(description = "AdminMenuInfoController的注释")
public class AdminMenuInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AdminMenuInfoController.class);
    
    private final String MAPPINGURL = "/AdminMenuInfoList";

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AdminMenuInfoService adminMenuInfoService;
    
    @Autowired
    BaseService baseService;
    
    @Autowired
    AdminRoleInfoService adminRoleInfoService;
    
    @Autowired
    AdminUserGroupService adminUserGroupService;
    
    @Autowired
    AdminRightshareService adminRightshareService;
    
    @Autowired
    AdminButtonInfoService buttonService;
    
    @RequestMapping(value="/AdminMenuInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminMenuInfoList默认页面模板", notes = "AdminMenuInfoList默认页面模板")
    public String AdminMenuInfoList(Model model) {
    	logger.debug("进入菜单管理....");
    	JSONObject status = new JSONObject();
    	status.put("0", "失效");
    	status.put("1", "正常");
    	model.addAttribute("status", status);
    	
    	JSONObject level = new JSONObject();
    	level.put("1", "一级");
    	level.put("2", "二级");
    	level.put("3", "三级");
    	model.addAttribute("level", level);
    	
    	
        return "admin/AdminMenuInfoList";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/AdminMenuInfo/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminMenuInfo通用查询方法", notes = "AdminMenuInfo通用查询方法",response = AdminMenuInfo.class, responseContainer="List")
    public CommonRestResponse searchAdminMenuInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminMenuInfo.class);
            PagingRestResponse response = adminMenuInfoService.searchAdminMenuInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            if(response.getData() != null) {
	            List<AdminMenuInfo> newDatas = new ArrayList<AdminMenuInfo>();
	            List<AdminMenuInfo> datas = (List<AdminMenuInfo>)response.getData();
	            
	            for(AdminMenuInfo m : datas) {
	            	StringBuffer parentMenuNames = new StringBuffer();
	            	
	            	int level = m.getMenuLevel();
	            	if(level == 3) {
	            		AdminMenuInfo m2 = adminMenuInfoService.getAdminMenuInfoByPK(m.getParentMenuId());
	            		AdminMenuInfo m1 = adminMenuInfoService.getAdminMenuInfoByPK(m2.getParentMenuId());
	            		parentMenuNames.append(m1.getMenuName() + "/" + m2.getMenuName());
	            	} else if(level == 2) {
	            		AdminMenuInfo m1 = adminMenuInfoService.getAdminMenuInfoByPK(m.getParentMenuId());
	            		parentMenuNames.append(m1.getMenuName());
	            	}
	            	m.setParentMenuNames(parentMenuNames.toString());
	            	
	            	newDatas.add(m);
	            }
	            response.setData(newDatas);
        	}
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value="/AdminMenuInfoManage/menuId={menuId}",method = RequestMethod.GET)
    @ApiOperation(value = "AdminMenuInfoManage默认页面模板", notes = "AdminMenuInfoManage默认页面模板")
    public String AdminMenuInfoTemplate(Model model,@PathVariable Integer menuId) {
    	try {
	    	 AdminMenuInfo adminMenuInfo = new AdminMenuInfo();
	    	 
	    	 /* ***begin**获取当前菜单的所有上级 begin********* */
	    	 if(menuId != -1) {
	    		 JSONArray parentMenuItemsShow = new JSONArray();
	    		 
	    		 adminMenuInfo = adminMenuInfoService.getAdminMenuInfoByPK(menuId);
	    		 int menuLevel = adminMenuInfo.getMenuLevel();
	    		 if(menuLevel == 3) {
	    			 String parentMenuId = Util.null2String(adminMenuInfo.getParentMenuId());
	    			 if(!"".equals(parentMenuId)) {
		    			 AdminMenuInfo MenuInfo2 = adminMenuInfoService.getAdminMenuInfoByPK(adminMenuInfo.getParentMenuId());
		    			 
		    			 parentMenuItemsShow.add(MenuInfo2.getParentMenuId() + "");
		    			 parentMenuItemsShow.add(parentMenuId + "");
	    			 }
	    		 } else if(menuLevel == 2) {
	    			 String parentMenuId = Util.null2String(adminMenuInfo.getParentMenuId());
	    			 parentMenuItemsShow.add(parentMenuId + "");
	    		 }
	    		 adminMenuInfo.setParentMenuItemsShow(parentMenuItemsShow);
	    		 
	    	 }else {
	    		 adminMenuInfo.setStatus(1);
	    		 adminMenuInfo.setId(menuId);
	    	 }
	    	 /* ***end**获取当前菜单的所有上级 end********* */
	    	 
	    	 
	    	 /* begin 拼接菜单明细表里面的上级菜单*****************begin**************** */
	    	 List<AdminMenuInfo> menus = new ArrayList<AdminMenuInfo>();
	    	 
	    	 List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
	    	 
	    	 //一级菜单
	    	 CommonSearchCondition bsc = new CommonSearchCondition();
	    	 bsc.setBeanName("menuLevel");
	    	 bsc.setColumnName("MENU_LEVEL");
	    	 bsc.setOperator("eq");
	    	 bsc.setValue("1");
	    	 condList.add(bsc);
	    	 if(menuId != -1) {
		    	 bsc = new CommonSearchCondition();
		    	 bsc.setBeanName("id");
		    	 bsc.setColumnName("ID");
		    	 bsc.setOperator("ne");
		    	 bsc.setValue(String.valueOf(menuId));
		    	 condList.add(bsc);
	    	 }
	    	 
	    	 menus = adminMenuInfoService.searchAdminMenuInfo(condList, null);
	    	 
	    	 JSONArray parentMenus = null;
	    	 if(menus != null && menus.size() > 0) {
	    		 parentMenus = new JSONArray();
	    		 for (AdminMenuInfo m : menus) {
					JSONObject menu1 = new JSONObject();
					menu1.put("value", m.getId() + "");
					menu1.put("label", m.getMenuName());
					
					//二级菜单
					List<AdminMenuInfo> menus2 = new ArrayList<AdminMenuInfo>();
					List<CommonSearchCondition> condList2 = new ArrayList<CommonSearchCondition>();
			    	CommonSearchCondition bsc2 = new CommonSearchCondition();
			    	bsc2.setBeanName("menuLevel");
			    	bsc2.setColumnName("MENU_LEVEL");
			    	bsc2.setOperator("eq");
			    	bsc2.setValue("2");
			    	condList2.add(bsc2);
			    	
			    	if(menuId != -1) {
				    	 bsc2 = new CommonSearchCondition();
				    	 bsc2.setBeanName("id");
				    	 bsc2.setColumnName("ID");
				    	 bsc2.setOperator("ne");
				    	 bsc2.setValue(String.valueOf(menuId));
				    	 condList2.add(bsc2);
			    	 }
			    	
			    	bsc2 = new CommonSearchCondition();
			    	bsc2.setBeanName("parentMenuId");
			    	bsc2.setColumnName("PARENT_MENU_ID");
			    	bsc2.setOperator("eq");
			    	bsc2.setValue(m.getId().toString());
			    	condList2.add(bsc2);
			    	
			    	menus2 = adminMenuInfoService.searchAdminMenuInfo(condList2, null);
			    	if(menus2 != null && menus2.size() > 0) {
			    		JSONArray menu2Array = new JSONArray();
			    		for (AdminMenuInfo m2 : menus2) {
				    		JSONObject menu2 = new JSONObject();
							menu2.put("value", m2.getId() + "");
							menu2.put("label", m2.getMenuName());
							menu2Array.add(menu2);
							
							//三级菜单
							List<AdminMenuInfo> menus3 = new ArrayList<AdminMenuInfo>();
							List<CommonSearchCondition> condList3 = new ArrayList<CommonSearchCondition>();
					    	CommonSearchCondition bsc3 = new CommonSearchCondition();
					    	bsc3.setBeanName("menuLevel");
					    	bsc3.setColumnName("MENU_LEVEL");
					    	bsc3.setOperator("eq");
					    	bsc3.setValue("3");
					    	condList3.add(bsc3);
					    	
					    	if(menuId != -1) {
						    	 bsc3 = new CommonSearchCondition();
						    	 bsc3.setBeanName("id");
						    	 bsc3.setColumnName("ID");
						    	 bsc3.setOperator("ne");
						    	 bsc3.setValue(String.valueOf(menuId));
						    	 condList3.add(bsc3);
					    	 }
					    	
					    	bsc3 = new CommonSearchCondition();
					    	bsc3.setBeanName("parentMenuId");
					    	bsc3.setColumnName("PARENT_MENU_ID");
					    	bsc3.setOperator("eq");
					    	bsc3.setValue(m2.getId().toString());
					    	condList3.add(bsc3);
					    	
					    	menus3 = adminMenuInfoService.searchAdminMenuInfo(condList3, null);
					    	if(menus3 != null && menus3.size() > 0) {
					    		JSONArray menu3Array = new JSONArray();
					    		for (AdminMenuInfo m3 : menus3) {
						    		JSONObject menu3 = new JSONObject();
						    		menu3.put("value", m3.getId() + "");
									menu3.put("label", m3.getMenuName());
						    		menu3Array.add(menu3);
					    		}
					    		menu2.put("children", menu3Array);
					    	}
			    		}
			    		menu1.put("children", menu2Array);
			    	}
			    	parentMenus.add(menu1);
				}
	    	 }
			adminMenuInfo.setParentMenus(parentMenus);
			/* end 拼接菜单明细表里面的上级菜单*****************end **************** */
			
			
			JSONArray checkButtons = new JSONArray();
			JSONArray checkedRolesArray = new JSONArray();
			JSONArray checkedUserGroupArray = new JSONArray();
			

			/* begin 拼接菜单对应的操作按钮 *****************begin**************** */
			
	    	List<AdminRightshare> checkedButtons = adminRightshareService.searchAdminRightshareAll("M", "3");
		    if(checkedButtons.size() > 0) {
		    	for (AdminRightshare ar : checkedButtons) {
		    		if(ar.getRightSourceId() == menuId) {
		    			checkButtons.add(ar.getResourceId());
		    		}
		    	}
	    	}
			adminMenuInfo.setCheckedButtons(checkButtons);
			/* end 拼接菜单对应的操作按钮 ***************** end **************** */
	    	 
	    	 
	    	 /* **begin 获取已授权角色列表	********************************************** */
	    	 List<AdminRightshare> checkedRoles = adminRightshareService.searchAdminRightshareAll("M", "0");
	    	 if(checkedRoles.size() > 0) {
	    		 for (AdminRightshare ar : checkedRoles) {
	    			 if(ar.getRightSourceId() == menuId) {
	    				 checkedRolesArray.add(ar.getResourceId());
	    			 }
				}
	    	 }
	    	 adminMenuInfo.setCheckedRoles(checkedRolesArray);
	    	 /* **end** 获取已授权角色列表	********************************************** */
	    	 
	    	 /* **begin 获取已授权用户组列表	********************************************** */
	    	 List<AdminRightshare> checkedUserGroup = adminRightshareService.searchAdminRightshareAll("M", "1");
	    	 if(checkedUserGroup.size() > 0) {
	    		 for (AdminRightshare ar : checkedUserGroup) {
	    			 if(ar.getRightSourceId() == menuId) {
	    				 checkedUserGroupArray.add(ar.getResourceId());
	    			 }
				}
	    	 }
	    	 adminMenuInfo.setCheckedUserGroups(checkedUserGroupArray);
	    	 /* **end** 获取已授权用户组列表********************************************** */
	    	 
	    	 model.addAttribute("adminMenuInfo",adminMenuInfo);
	    	 
	    	 /* **begin 获取所有按钮角色列表********************************************** */
	    	 List<AdminButtonInfo> buttons = buttonService.searchAdminButtonInfoAll();
	    	 JSONArray currAllbuttonsArray = new JSONArray();
	    	 JSONArray currAllbuttonsInitArray = new JSONArray();
	    	 if(buttons.size() > 0) {
	    		 for (AdminButtonInfo button : buttons) {
					JSONObject o = new JSONObject();
					o.put("id", button.getId());
					o.put("buttonCode", button.getButtonCode());
					o.put("buttonName", button.getButtonName());
					currAllbuttonsInitArray.add(button.getId());
					currAllbuttonsArray.add(o);
				}
	    	 }
	    	 model.addAttribute("currAllbuttonsInitArray",currAllbuttonsInitArray);
	    	 model.addAttribute("currAllbuttonsArray",currAllbuttonsArray);
	    	 /* **end** 获取所有按钮列表********************************************** */
	    	 
	    	 /* **begin 获取所有角色列表********************************************** */
	    	 List<AdminRoleInfo> currAllroles = adminRoleInfoService.searchAdminRoleInfoAll();
	    	 JSONArray currAllrolesArray = new JSONArray();
	    	 JSONArray currAllrolesInitArray = new JSONArray();
	    	 if(currAllroles.size() > 0) {
	    		 for (AdminRoleInfo role : currAllroles) {
					JSONObject o = new JSONObject();
					o.put("id", role.getId());
					o.put("roleName", role.getRoleName());
					currAllrolesInitArray.add(role.getId());
					currAllrolesArray.add(o);
				}
	    	 }
	    	 model.addAttribute("currAllrolesInitArray",currAllrolesInitArray);
	    	 model.addAttribute("currAllroles",currAllrolesArray);
	    	 /* **end** 获取所有角色列表********************************************** */
	    	 
	    	 /* **begin 获取所有用户组角色列表********************************************** */
	    	 List<AdminUserGroup> currAllUserGroup = adminUserGroupService.searchAdminUserGroupAll();
	    	 JSONArray currAllUserGroupArray = new JSONArray();
	    	 JSONArray currAllUserGroupInitArray = new JSONArray();
	    	 if(currAllUserGroup.size() > 0) {
	    		 for (AdminUserGroup ug : currAllUserGroup) {
					JSONObject o = new JSONObject();
					o.put("id", ug.getId());
					o.put("groupName", ug.getGroupName());
					
					currAllUserGroupInitArray.add(ug.getId());
					currAllUserGroupArray.add(o);
				}
	    	 }
	    	 model.addAttribute("currAllUserGroupInitArray",currAllUserGroupInitArray);
	    	 model.addAttribute("currAllUserGroupArray",currAllUserGroupArray);
	    	 /* **end** 获取所有用户组列表********************************************** */
	    	
	    	 
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
        return "admin/AdminMenuInfoManage";
    }
    
    @RequestMapping(value = "/AdminMenuInfo/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入AdminMenuInfo对象", notes = "插入AdminMenuInfo对象")
    public CommonRestResponse insertAdminMenuInfo(HttpServletRequest httpRequest, @RequestBody AdminMenuInfo adminMenuInfo) {
        try {
            String errMsg = "";
            
            String menuCode = adminMenuInfo.getMenuCode();
            String menuName = adminMenuInfo.getMenuName();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("menuCode");
            cond.setColumnName("MENU_CODE");
            cond.setOperator("eq");
            cond.setValue(menuCode);
            condList.add(cond);
            List<AdminMenuInfo> menuList = adminMenuInfoService.searchAdminMenuInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该菜单编码已存在!";
            }
            
            condList = new ArrayList<CommonSearchCondition>();
            cond = new CommonSearchCondition();
            cond.setBeanName("menuName");
            cond.setColumnName("MENU_NAME");
            cond.setOperator("eq");
            cond.setValue(menuName);
            condList.add(cond);
            menuList = adminMenuInfoService.searchAdminMenuInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该菜单名称已存在!";
            }
            
        	if("".equals(errMsg)) {
	        	adminMenuInfo.setId(null);
	        	adminMenuInfo.setCreatedBy(baseService.getUserName());
	        	adminMenuInfo.setCreatedTime(new Date());
	        	adminMenuInfo.setLastUpdatedBy(baseService.getUserName());
	        	adminMenuInfo.setLastUpdatedTime(new Date());
	        	
	        	if(adminMenuInfo.getParentMenuItemsShow() != null && adminMenuInfo.getParentMenuItemsShow().size() > 0) {
	        		adminMenuInfo.setParentMenuId(Integer.valueOf(adminMenuInfo.getParentMenuItemsShow().getString(adminMenuInfo.getParentMenuItemsShow().size() - 1)));
	        	}
	        	
	            int menuId = adminMenuInfoService.insertAdminMenuInfo(adminMenuInfo);
	            List<AdminRightshare> rights = null;
	            
	            JSONArray checkedButtons = adminMenuInfo.getCheckedButtons();
	        	// 保存菜单-操作按钮对应关系
	        	if(checkedButtons != null && checkedButtons.size() > 0) {
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object buttonId : checkedButtons) {
	    				AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(menuId);
	    				ar.setResourceType("3");
	    				ar.setResourceId(Integer.valueOf(String.valueOf(buttonId)));
	    				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
	        	}
	            
	            JSONArray checkedUserGroups = adminMenuInfo.getCheckedUserGroups();
	        	// 保存菜单-用户组对应关系
	        	if(checkedUserGroups != null && checkedUserGroups.size() > 0) {
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object userGroupId : checkedUserGroups) {
	    				AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(menuId);
	    				ar.setResourceType("1");
	    				ar.setResourceId(Integer.valueOf(String.valueOf(userGroupId)));
	    				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
	        	}
	        	
	        	JSONArray checkedRoles = adminMenuInfo.getCheckedRoles();
	        	// 保存菜单-角色对应关系
	        	if(checkedRoles != null && checkedRoles.size() > 0) {
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object roleId : checkedRoles) {
	    				AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(menuId);
	    				ar.setResourceType("0");
	    				ar.setResourceId(Integer.valueOf(String.valueOf(roleId)));
	    				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
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
    
    @RequestMapping(value = "/AdminMenuInfo/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新AdminMenuInfo", notes = "根据pkId更新AdminMenuInfo")
    public CommonRestResponse updateAdminMenuInfoByPKSelective(HttpServletRequest httpRequest, @RequestBody AdminMenuInfo adminMenuInfo) {
        try {
        	String errMsg = "";
            
            String menuCode = adminMenuInfo.getMenuCode();
            String menuName = adminMenuInfo.getMenuName();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("menuCode");
            cond.setColumnName("MENU_CODE");
            cond.setOperator("eq");
            cond.setValue(menuCode);
            condList.add(cond);
            
            cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(adminMenuInfo.getId()));
            condList.add(cond);
            
            List<AdminMenuInfo> menuList = adminMenuInfoService.searchAdminMenuInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该菜单编码已存在!";
            }
            
            condList = new ArrayList<CommonSearchCondition>();
            cond = new CommonSearchCondition();
            cond.setBeanName("menuName");
            cond.setColumnName("MENU_NAME");
            cond.setOperator("eq");
            cond.setValue(menuName);
            condList.add(cond);

            cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(adminMenuInfo.getId()));
            condList.add(cond);
            
            menuList = adminMenuInfoService.searchAdminMenuInfo(condList, null);
            if(menuList != null && menuList.size() > 0) {
            	errMsg += "该菜单名称已存在!";
            }
        	
        	if("".equals(errMsg)) {
        		if(adminMenuInfo.getParentMenuItemsShow() != null && adminMenuInfo.getParentMenuItemsShow().size() > 0) {
	        		adminMenuInfo.setParentMenuId(Integer.valueOf(adminMenuInfo.getParentMenuItemsShow().getString(adminMenuInfo.getParentMenuItemsShow().size() - 1)));
	        	}
	        	
	        	adminMenuInfoService.updateAdminMenuInfoByPKSelective(adminMenuInfo);
	        	List<AdminRightshare> rights = null;

	        	JSONArray checkedButtons = adminMenuInfo.getCheckedButtons();
	        	// 保存菜单-操作按钮对应关系
	        	if(checkedButtons != null && checkedButtons.size() > 0) {
	        		//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("M");
	        		arDel.setRightSourceId(adminMenuInfo.getId());
	        		arDel.setResourceType("3");
	        		adminRightshareService.deleteAdminRightshareByPKSelective(arDel);
	        		
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object buttonId : checkedButtons) {
	    				AdminRightshare ar = new AdminRightshare();
	    				ar.setRightType("M");
	    				ar.setRightSourceId(adminMenuInfo.getId());
	    				ar.setResourceType("3");
	    				ar.setResourceId(Integer.valueOf(String.valueOf(buttonId)));
	    				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
	        	}
	        	
	        	JSONArray checkedRoles = adminMenuInfo.getCheckedRoles();
	        	// 保存菜单-角色对应关系
	        	if(checkedRoles != null && checkedRoles.size() > 0) {
	        		//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("M");
	        		arDel.setRightSourceId(adminMenuInfo.getId());
	        		arDel.setResourceType("0");
	        		adminRightshareService.deleteAdminRightshareByPKSelective(arDel);
	        		
	        		rights = new ArrayList<AdminRightshare>();
	        		
	        		for(Object roleId : checkedRoles) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("M");
        				ar.setRightSourceId(adminMenuInfo.getId());
        				ar.setResourceType("0");
        				ar.setResourceId(Integer.valueOf(String.valueOf(roleId)));
        				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
	        	}
	        	
	        	JSONArray checkedUserGroups = adminMenuInfo.getCheckedUserGroups();
	        	// 保存菜单-用户组角色对应关系
	        	if(checkedUserGroups != null && checkedUserGroups.size() > 0) {
	        		//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("M");
	        		arDel.setRightSourceId(adminMenuInfo.getId());
	        		arDel.setResourceType("1");
	        		adminRightshareService.deleteAdminRightshareByPKSelective(arDel);
	        		
	        		rights = new ArrayList<AdminRightshare>();
	        		
	        		for(Object userGroupId : checkedUserGroups) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("M");
        				ar.setRightSourceId(adminMenuInfo.getId());
        				ar.setResourceType("1");
        				ar.setResourceId(Integer.valueOf(String.valueOf(userGroupId)));
        				rights.add(ar);
	        		}
	        		adminRightshareService.insertOrUpdateBetch(rights);
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @RequestMapping(value = "AdminMenuInfo/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取AdminMenuInfo", notes = "根据pkId获取AdminMenuInfo",response = AdminMenuInfo.class)
    public CommonRestResponse getAdminMenuInfoByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            AdminMenuInfo adminMenuInfo = adminMenuInfoService.getAdminMenuInfoByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminMenuInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "AdminMenuInfo/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminMenuInfo导出接口，返回待下载的Excel文件名", notes = "AdminMenuInfo导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAdminMenuInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminMenuInfo.class);
            PagingRestResponse response = adminMenuInfoService.searchAdminMenuInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<AdminMenuInfo> resultList = (List<AdminMenuInfo>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("menuCode");
                headerList.add("menuName");
                headerList.add("parentMenuId");
                headerList.add("menuUrl");
                headerList.add("menuLevel");
                headerList.add("状态：0启用，1禁用");
                headerList.add("menuDesc");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(AdminMenuInfo row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getMenuCode());
                    rowList.add(row.getMenuName());
                    rowList.add(row.getParentMenuId());
                    rowList.add(row.getMenuUrl());
                    rowList.add(row.getMenuLevel());
                    rowList.add(row.getStatus());
                    rowList.add(row.getMenuDesc());
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

    

    @RequestMapping(value = "AdminMenuInfoEdit", method = RequestMethod.GET)
    @ApiOperation(value = "AdminMenuInfoEdit默认页面模板", notes = "AdminMenuInfoEdit默认页面模板")
    public String AdminMenuInfoEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        AdminMenuInfo adminMenuInfo = new AdminMenuInfo();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            adminMenuInfo = adminMenuInfoService.getAdminMenuInfoByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("adminMenuInfo",adminMenuInfo);
        model.addAttribute("isUpdate",isUpdate);
        return "AdminMenuInfoEdit";
    }
}