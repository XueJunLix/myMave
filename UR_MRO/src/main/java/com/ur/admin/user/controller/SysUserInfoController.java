package com.ur.admin.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.security.MD5Encoder;
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
import com.ur.admin.menu.service.AdminMenuInfoService;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.admin.role.model.AdminRoleInfo;
import com.ur.admin.role.service.AdminRoleInfoService;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.admin.usergroup.model.AdminUserGroup;
import com.ur.admin.usergroup.service.AdminUserGroupService;
import com.ur.common.service.BaseService;
import com.ur.common.service.RedisMessageBOService;
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
@RequestMapping(value = "/user")
@Api(description = "SysUserInfoController的注释")
public class SysUserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(SysUserInfoController.class);
    
    private final String MAPPINGURL = "/AdminUserInfoList";
    
    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    SysUserInfoService sysUserInfoService;
    
    @Autowired
    AdminRoleInfoService roleService;
    
    @Autowired
    AdminUserGroupService usergroupServcie;
    
    @Autowired
    AdminRightshareService rightService;
    
    @Autowired
    BaseService baseService;
    
    @Autowired
    AdminMenuInfoService menuService;
    
    @Autowired
	RedisMessageBOService redisService;

    @RequestMapping(value="/AdminUserInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminUserInfoList默认页面模板", notes = "AdminUserInfoList默认页面模板")
    public String SysUserInfoList(Model model) {
    	logger.debug("用户管理页面....");
    	List<AdminRoleInfo> roles = roleService.searchAdminRoleInfoAll();
    	JSONArray roleArray = null;
    	if(roles != null && roles.size() > 0) {
    		roleArray = new JSONArray();
    		for (AdminRoleInfo role : roles) {
				JSONObject o = new JSONObject();
				o.put("id", String.valueOf(role.getId()));
				o.put("name", role.getRoleName());
				roleArray.add(o);
			}
    	}
    	model.addAttribute("userRoleMap", roleArray);
    	
    	List<AdminUserGroup> usergroups = usergroupServcie.searchAdminUserGroupAll();
    	JSONArray usergroupArray = null;
    	if(usergroups != null && usergroups.size()> 0) {
    		usergroupArray = new JSONArray();
    		for (AdminUserGroup usergroup : usergroups) {
				JSONObject o = new JSONObject();
				o.put("id", String.valueOf(usergroup.getId()));
				o.put("name", String.valueOf(usergroup.getGroupName()));
				usergroupArray.add(o);
			}
    	}
    	model.addAttribute("userGroupMap", usergroupArray);
    	
    	// 根据路径获取菜单ID，用于配置连接内容展示的按钮权限控制
    	int menuId = menuService.getAdminMenuIdByMappingUrl(MAPPINGURL);
    	List<AdminButtonInfo> buttons = rightService.getOperateBtnByCurrUser("L", menuId);
    	System.err.println(buttons.size() + "====usermanager menuId=" + menuId);
    	model.addAttribute("buttons", buttons);
    	
        return "admin/AdminUserInfoList";
    }
     
    @RequestMapping(value = "/SysUserInfo/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "SysUserInfo通用查询方法", notes = "SysUserInfo通用查询方法",response = SysUserInfo.class, responseContainer="List")
    public CommonRestResponse searchSysUserInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            
            List<CommonSearchCondition> currCond = request.getCondList();
            if(currCond != null && currCond.size() > 0) {
            	for (CommonSearchCondition c : currCond) {
            		String beanName = c.getBeanName();
            		String columnName = c.getColumnName();
            		//System.err.println("=====beanname=" + beanName + "=======columnName="+columnName + "===c.getOperator()="+c.getOperator()+"===c.getValue()=" + c.getValue());
					if(("roleId".equals(beanName)||"roleId".equals(columnName))) {
						CommonSearchCondition cnew = new CommonSearchCondition();
						cnew.setBeanName("id");
						cnew.setColumnName("ID");
						cnew.setOperator("in");
						String value = "".equals(Util.null2String(c.getValue())) ? "-1" : Util.null2String(c.getValue());
						List<String> userIds = rightService.getUserIdByRoleId(value);
						String tmpIds = "-1";
						if(userIds != null && userIds.size() > 0) {
							for (String userId : userIds) {
								tmpIds += "," + userId;
							}
						}
						cnew.setValue(tmpIds);
						condList.add(cnew);
					} else if(("groupId".equals(beanName)||"groupId".equals(columnName))) {
						CommonSearchCondition cnew = new CommonSearchCondition();
						cnew.setBeanName("id");
						cnew.setColumnName("ID");
						cnew.setOperator("in");
						String value = "".equals(Util.null2String(c.getValue())) ? "-1" : Util.null2String(c.getValue());
						String userIds = rightService.getUserIdByUserGroupId(value);
						
						cnew.setValue(userIds);
						
						condList.add(cnew);
					} else {
						condList.add(c);
					}
				}
            }
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(SysUserInfo.class);
            
            List<String> orderBy = new ArrayList<String>();
            orderBy.add(" LAST_UPDATED_TIME desc ");
            
            PagingRestResponse response = sysUserInfoService.searchSysUserInfo(request.getSelectFields(),condList,orderBy,pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/AdminUserInfoManage", method = RequestMethod.GET)
    @ApiOperation(value = "AdminUserInfoManage默认页面模板", notes = "AdminUserInfoManage默认页面模板")
    public String SysUserInfoEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String userId = httpRequest.getParameter("userId");
        logger.debug("用户管理：新增、修改...." + userId);
        SysUserInfo sysUserInfo = new SysUserInfo();
        boolean isUpdate = false;
        if(userId != null && !userId.equals("")){
            sysUserInfo = sysUserInfoService.getSysUserInfoByPK(Integer.valueOf(userId));
            sysUserInfo.setPassword(null);
            sysUserInfo.setPasswordconfirm(null);
            
            isUpdate = true;
            
            List<CommonSearchCondition> condList = null;
	    	 CommonSearchCondition cond = null;
	    	 
            /* **begin 获取已授权角色列表********************************************** */
	    	 condList = new ArrayList<CommonSearchCondition>();
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("rightType");
	    	 cond.setColumnName("RIGHT_TYPE");
	    	 cond.setOperator("eq");
	    	 cond.setValue("R");
	    	 condList.add(cond);
	    	 
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("resourceType");
	    	 cond.setColumnName("RESOURCE_TYPE");
	    	 cond.setOperator("eq");
	    	 cond.setValue("2");
	    	 condList.add(cond);
	    	 
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("resourceId");
	    	 cond.setColumnName("RESOURCE_ID");
	    	 cond.setOperator("eq");
	    	 cond.setValue(userId);
	    	 condList.add(cond);
	    	 
	    	 List<AdminRightshare> checkedRoles = rightService.searchAdminRightshareDef(condList);
	    	 JSONArray checkedRolesArray = new JSONArray();
	    	 if(checkedRoles.size() > 0) {
	    		 for (AdminRightshare ar : checkedRoles) {
					checkedRolesArray.add(ar.getRightSourceId());
				}
	    	 }
	    	 sysUserInfo.setCheckedRoles(checkedRolesArray);
	    	 /* **end** 获取已授权角色列表********************************************** */
	    	 
	    	 /* **begin 获取已授权用户组列表********************************************** */
	    	 condList = new ArrayList<CommonSearchCondition>();
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("rightType");
	    	 cond.setColumnName("RIGHT_TYPE");
	    	 cond.setOperator("eq");
	    	 cond.setValue("U");
	    	 condList.add(cond);
	    	 
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("resourceType");
	    	 cond.setColumnName("RESOURCE_TYPE");
	    	 cond.setOperator("eq");
	    	 cond.setValue("2");
	    	 condList.add(cond);
	    	 
	    	 cond = new CommonSearchCondition();
	    	 cond.setBeanName("resourceId");
	    	 cond.setColumnName("RESOURCE_ID");
	    	 cond.setOperator("eq");
	    	 cond.setValue(userId);
	    	 condList.add(cond);
	    	 
	    	 List<AdminRightshare> checkedUserGroup = rightService.searchAdminRightshareDef(condList);
	    	 JSONArray checkedUserGroupArray = new JSONArray();
	    	 if(checkedUserGroup.size() > 0) {
	    		 for (AdminRightshare ar : checkedUserGroup) {
	    			 checkedUserGroupArray.add(ar.getRightSourceId());
				}
	    	 }
	    	 sysUserInfo.setCheckedUserGroups(checkedUserGroupArray);
	    	 /* **end** 获取已授权用户组列表********************************************** */
            
            
            /* **begin 获取所有角色列表********************************************** */
	    	 List<AdminRoleInfo> currAllroles = roleService.searchAdminRoleInfoAll();
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
	    	 List<AdminUserGroup> currAllUserGroup = usergroupServcie.searchAdminUserGroupAll();
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
            
            
        } else {
        	sysUserInfo.setStatus(0);
        }
        model.addAttribute("sysUserInfo",sysUserInfo);
        model.addAttribute("isUpdate",isUpdate);
        
     // 根据路径获取菜单ID，用于配置连接内容展示的按钮权限控制
    	int menuId = menuService.getAdminMenuIdByMappingUrl(MAPPINGURL);
    	List<AdminButtonInfo> buttons = rightService.getOperateBtnByCurrUser("D", menuId);
    	System.err.println(buttons.size() + "====usermanager menuId=" + menuId);
    	model.addAttribute("buttons", buttons);
        
        return "admin/AdminUserInfoManage";
    }
    
    @RequestMapping(value = "/SysUserInfo/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入SysUserInfo对象", notes = "插入SysUserInfo对象")
    public CommonRestResponse insertSysUserInfo(HttpServletRequest httpRequest, @RequestBody SysUserInfo sysUserInfo) {
        try {
        	String errMsg = "";
        	
        	String loginId = sysUserInfo.getLoginName();
        	
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
        	CommonSearchCondition cond = new CommonSearchCondition();
        	cond.setBeanName("loginName");
        	cond.setColumnName("LOGIN_NAME");
        	cond.setOperator("eq");
        	cond.setValue(loginId);
        	condList.add(cond);
        	
        	List<SysUserInfo> userList = sysUserInfoService.searchSysUserInfo(condList, null);
            if(userList != null && userList.size() > 0) {
            	errMsg += "该登录ID已存在!";
            }
			
        	if("".equals(errMsg)) {
	            //明文密码转换成MD5密文
	        	String pwdMd5 = MD5Encoder.encode(sysUserInfo.getPassword().getBytes());
	        	sysUserInfo.setPassword(pwdMd5);
	        	
	        	sysUserInfo.setCreatedBy(baseService.getUserName());
	        	sysUserInfo.setCreatedTime(new Date());
	        	sysUserInfo.setLastUpdatedBy(baseService.getUserName());
	        	sysUserInfo.setLastUpdatedTime(new Date());
	            sysUserInfoService.insertSysUserInfo(sysUserInfo);
	            
	            int userId = sysUserInfo.getId();
	            
	            List<AdminRightshare> rights = null;
	            JSONArray checkedRoles = sysUserInfo.getCheckedRoles();
	        	// 保存菜单-角色对应关系
	        	if(checkedRoles != null && checkedRoles.size() > 0) {
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object roleId : checkedRoles) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("R");
        				ar.setRightSourceId(Integer.valueOf(String.valueOf(roleId)));
        				ar.setResourceType("2");
        				ar.setResourceId(userId);
        				rights.add(ar);
	        		}
	        		rightService.insertOrUpdateBetch(rights);
	        	}
	        	
	        	JSONArray checkedUserGroups = sysUserInfo.getCheckedUserGroups();
	        	// 保存菜单-用户组角色对应关系
	        	if(checkedUserGroups != null && checkedUserGroups.size() > 0) {
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object userGroupId : checkedUserGroups) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("U");
        				ar.setRightSourceId(Integer.valueOf(String.valueOf(userGroupId)));
        				ar.setResourceType("2");
        				ar.setResourceId(userId);
        				rights.add(ar);
	        		}
	        		rightService.insertOrUpdateBetch(rights);
	        	}
	            
	            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        	} else {
        		return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"该用户登录ID已经存在!",null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/SysUserInfo/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新SysUserInfo", notes = "根据pkId更新SysUserInfo")
    public CommonRestResponse updateSysUserInfoByPKSelective(HttpServletRequest httpRequest, @RequestBody SysUserInfo sysUserInfo) {
        try {
            String errMsg = "";
        	
            String loginId = sysUserInfo.getLoginName();
            int id = sysUserInfo.getId();
            
            List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
            CommonSearchCondition cond = new CommonSearchCondition();
            cond.setBeanName("loginName");
            cond.setColumnName("LOGIN_NAME");
            cond.setOperator("eq");
            cond.setValue(loginId);
            condList.add(cond);
            
            cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(id));
            condList.add(cond);
            
            List<SysUserInfo> userList = sysUserInfoService.searchSysUserInfo(condList, null);
            if(userList != null && userList.size() > 0) {
            	errMsg += "该登录ID已存在!";
            }
            
        	if("".equals(errMsg)) {
	        	//明文密码转换成MD5密文
	        	if(sysUserInfo.getPassword() != null && !"".equals(sysUserInfo.getPassword())) {
	        		String pwdMd5 = MD5Encoder.encode(sysUserInfo.getPassword().getBytes());
	        		sysUserInfo.setPassword(pwdMd5);
	        	}
	        	sysUserInfo.setLastUpdatedBy(baseService.getUserName());
	        	sysUserInfo.setLastUpdatedTime(new Date());
	            sysUserInfoService.updateSysUserInfoByPKSelective(sysUserInfo);
	            
	            JSONArray checkedRoles = sysUserInfo.getCheckedRoles();
	            //System.err.println("====checkedRoles=" + checkedRoles);
	            List<AdminRightshare> rights = null;
	        	// 保存菜单-角色对应关系
	        	if(checkedRoles != null && checkedRoles.size() > 0) {
	        		//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("R");
	        		arDel.setResourceType("2");
	        		arDel.setResourceId(id);
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	        		
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object roleId : checkedRoles) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("R");
        				ar.setRightSourceId(Integer.valueOf(String.valueOf(roleId)));
        				ar.setResourceType("2");
        				ar.setResourceId(id);
        				rights.add(ar);
	        		}
	        		rightService.insertOrUpdateBetch(rights);
	        	}
	        	
	        	JSONArray checkedUserGroups = sysUserInfo.getCheckedUserGroups();
	        	System.err.println("====checkedUserGroups=" + checkedUserGroups);
	        	// 保存菜单-用户组角色对应关系
	        	if(checkedUserGroups != null && checkedUserGroups.size() > 0) {
	        		//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("U");
	        		arDel.setResourceType("2");
	        		arDel.setResourceId(id);
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	        		
	        		rights = new ArrayList<AdminRightshare>();
	        		for(Object userGroupId : checkedUserGroups) {
	        			AdminRightshare ar = new AdminRightshare();
        				ar.setRightType("U");
        				ar.setRightSourceId(Integer.valueOf(String.valueOf(userGroupId)));
        				ar.setResourceType("2");
        				ar.setResourceId(id);
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
    
    
    @RequestMapping(value="/UserListForRight/rightId={rightId}&rightTag={rightTag}",method = RequestMethod.GET)
    @ApiOperation(value = "UserListForRight默认页面模板", notes = "UserListForRight默认页面模板")
    public String UserListForRight(@PathVariable String rightId, @PathVariable String rightTag, Model model) {
    	
    	model.addAttribute("rightId", rightId);
    	model.addAttribute("rightTag", rightTag);
    	
        return "admin/AdminUserInfoListForRoleGroup";
    }
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value="SysUserInfo",method = RequestMethod.GET)
    @ApiOperation(value = "SysUserInfo默认页面模板", notes = "SysUserInfo默认页面模板")
    public String SysUserInfoTemplate() {
        return "SysUserInfo";
    }

    @RequestMapping(value = "SysUserInfo/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取SysUserInfo", notes = "根据pkId获取SysUserInfo",response = SysUserInfo.class)
    public CommonRestResponse getSysUserInfoByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            SysUserInfo sysUserInfo = sysUserInfoService.getSysUserInfoByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,sysUserInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    


    @RequestMapping(value = "SysUserInfo/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "SysUserInfo导出接口，返回待下载的Excel文件名", notes = "SysUserInfo导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportSysUserInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(SysUserInfo.class);
            PagingRestResponse response = sysUserInfoService.searchSysUserInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<SysUserInfo> resultList = (List<SysUserInfo>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("loginName");
                headerList.add("name");
                headerList.add("password");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("role");
                headerList.add("jobNumber");
                headerList.add("email");
                headerList.add("状态：0启用，1禁用");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(SysUserInfo row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getLoginName());
                    rowList.add(row.getName());
                    rowList.add(row.getPassword());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getRole());
                    rowList.add(row.getJobNumber());
                    rowList.add(row.getEmail());
                    rowList.add(row.getStatus());
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