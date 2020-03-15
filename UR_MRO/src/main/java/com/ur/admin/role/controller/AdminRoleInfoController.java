package com.ur.admin.role.controller;

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
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
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
@RequestMapping(value = "/role")
@Api(description = "AdminRoleInfoController的注释")
public class AdminRoleInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AdminRoleInfoController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AdminRoleInfoService adminRoleInfoService;
    
    @Autowired
    AdminRightshareService rightService;
    
    @Autowired
    SysUserInfoService userService;
    
    @Autowired
    BaseService baseService;
    
    @Autowired
    AdminMenuInfoService adminMenuInfoService;
    
    @Autowired
    AdminButtonInfoService buttonService;

    
    @RequestMapping(value="/AdminRoleInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminRoleInfoList默认页面模板", notes = "AdminRoleInfoList默认页面模板")
    public String AdminRoleInfoList(Model model) {
    	JSONObject statusMod = new JSONObject();
    	statusMod.put("0", "失效");
    	statusMod.put("1", "正常");
    	model.addAttribute("statusMod",statusMod);
        return "admin/AdminRoleInfoList";
    }
    
    @RequestMapping(value = "/AdminRoleInfo/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminRoleInfo通用查询方法", notes = "AdminRoleInfo通用查询方法",response = AdminRoleInfo.class, responseContainer="List")
    public CommonRestResponse searchAdminRoleInfo(Model model, HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
    	logger.debug("数据查询..." + request.getCurrPage());
        try {
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
                        
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminRoleInfo.class);
            PagingRestResponse response = adminRoleInfoService.searchAdminRoleInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            //System.err.println(response.getData() + "\n===code=:" + response.getCode());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/AdminRoleInfoManage", method = RequestMethod.GET)
    @ApiOperation(value = "AdminRoleInfoManage默认页面模板", notes = "AdminRoleInfoManage默认页面模板")
	public String AdminRoleInfoEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		String id = httpRequest.getParameter("id");
		AdminRoleInfo adminRoleInfo = new AdminRoleInfo();
		boolean isUpdate = false;

		JSONArray currUserArray = new JSONArray();
		// transfer已选用户数据
		JSONArray selectUsers = new JSONArray();

		JSONArray checkedMenusArray = new JSONArray();
		JSONArray checkedButtonArray = new JSONArray();

		if (id != null && !id.equals("")) {
			int roleId = Integer.valueOf(id);
			adminRoleInfo = adminRoleInfoService.getAdminRoleInfoByPK(roleId);
			isUpdate = true;

			// 获取该角色下所有的成员
			List<String> userids = rightService.getUserIdByRoleId(id);
			if (userids != null && userids.size() > 0) {
				for (String userId : userids) {
					SysUserInfo u = userService.getSysUserInfoByPK(Integer.valueOf(userId));
					if (u != null) {
						String key = String.valueOf(u.getId());
						String label = u.getLoginName() + "_" + u.getName();

						JSONObject obj = new JSONObject();
						obj.put("key", key);
						obj.put("label", label);
						currUserArray.add(obj);

						selectUsers.add(u.getId());
					}
				}
			}

			/*
			 * 角色中的菜单树由 菜单和按钮组成，获取已经被授权的节点应由被选菜单+被选按钮组成
			 */
			/* **begin 获取已分配菜单列表 ********************************************** */
			List<AdminRightshare> checkedMenus = rightService.searchAdminRightshareAll("M", "0");

			if (checkedMenus.size() > 0) {
				for (AdminRightshare ar : checkedMenus) {
					int menuId = ar.getRightSourceId(); // 菜单ID
					int roleMId = ar.getResourceId(); // 角色ID
					if (roleMId == roleId) {
						checkedMenusArray.add(menuId); // 初始化树-菜单选中
					}
				}
			}
			/* **end** 获取已分配菜单列表 ********************************************** */

			/* **begin 获取已授权按钮 ********************************************** */
			List<AdminRightshare> checkedButtons = rightService.searchAdminRightshareAll("RM", "3M");

			if (checkedButtons.size() > 0) {
				for (AdminRightshare ar : checkedButtons) {
					int roleBId = ar.getRightSourceId(); // 角色ID
					int buttonMId = ar.getResourceId(); // 角色对应按钮菜单组合ID
					if (roleBId == roleId) {
						checkedButtonArray.add(buttonMId); // 初始化树-按钮选中
					}
				}
			}
			/* **end** 获取已授权按钮 ********************************************** */
		} else {
			adminRoleInfo.setStatus(1);
		}
		System.err.println("===checkedMenusArray=" + checkedMenusArray);
		adminRoleInfo.setCheckedMenus(checkedMenusArray);
		adminRoleInfo.setCheckedButtons(checkedButtonArray);

		/* **begin 获取所有菜单列表 ********************************************** */

		// 获取菜单-操作按钮 关联数据
		List<AdminButtonInfo> menu_buttons = buttonService.searchAdminButtonInfoAll();
		List<AdminRightshare> menu_button_rights = rightService.searchAdminRightshareAll("M", "3");

		System.err.println("--------:" + menu_button_rights.size());

		List<AdminMenuInfo> currAllmenus = adminMenuInfoService.searchAdminMenuInfoAll();
		JSONArray currAllmenusArray = new JSONArray();

		List<AdminMenuInfo> l1 = new ArrayList<AdminMenuInfo>();
		List<AdminMenuInfo> l2 = new ArrayList<AdminMenuInfo>();
		List<AdminMenuInfo> l3 = new ArrayList<AdminMenuInfo>();

		if (currAllmenus.size() > 0) {
			for (AdminMenuInfo menu : currAllmenus) {
				int level = menu.getMenuLevel();
				if (level == 1) {
					l1.add(menu);
				} else if (level == 2) {
					l2.add(menu);
				} else if (level == 3) {
					l3.add(menu);
				}
			}

			for (AdminMenuInfo m1 : l1) {
				int menuId1 = m1.getId();
				String manuName1 = m1.getMenuName();

				JSONObject o1 = new JSONObject();
				o1.put("id", menuId1);
				o1.put("label", manuName1);
				o1.put("type", "menu");
				o1.put("parentId", "");

				JSONArray children2 = new JSONArray();

				for (AdminMenuInfo m2 : l2) {
					int menuId2 = m2.getId();
					String manuName2 = m2.getMenuName();
					int menuParentId2 = m2.getParentMenuId();

					if (menuParentId2 == menuId1) {
						JSONObject o2 = new JSONObject();
						o2.put("id", menuId2);
						o2.put("label", manuName2);
						o2.put("type", "menu");
						o2.put("parentId", menuId1);

						JSONArray children3 = new JSONArray();
						for (AdminMenuInfo m3 : l3) {
							int menuId3 = m3.getId();
							String manuName3 = m3.getMenuName();
							int menuParentId3 = m3.getParentMenuId();

							if (menuParentId3 == menuId2) {
								JSONObject o3 = new JSONObject();
								o3.put("id", menuId3);
								o3.put("label", manuName3);
								o3.put("type", "menu");
								o3.put("parentId", menuId2);

								JSONArray btns = new JSONArray();
								if (menu_button_rights != null && menu_button_rights.size() > 0) {
									for (AdminRightshare ar : menu_button_rights) {
										int menuId_right = ar.getRightSourceId();
										int buttonId_right = ar.getResourceId();
										if (menuId3 == menuId_right) {
											for (AdminButtonInfo button : menu_buttons) {
												if (buttonId_right == button.getId()) {
													JSONObject btn = new JSONObject();
													btn.put("btnid", Integer.valueOf(button.getId() + "" + menuId3));
													btn.put("btnlabel", button.getButtonName());

													btns.add(btn);
												}
											}
										}
									}
								}
								o3.put("btns", btns);
								children3.add(o3);
							}
						}

						// 菜单下没有子级，则增加按钮
						if (children3.size() > 0) {
							o2.put("children", children3);
						}
						JSONArray btns = new JSONArray();
						if (menu_button_rights != null && menu_button_rights.size() > 0) {
							for (AdminRightshare ar : menu_button_rights) {
								int menuId_right = ar.getRightSourceId();
								int buttonId_right = ar.getResourceId();
								if (menuId2 == menuId_right) {
									for (AdminButtonInfo button : menu_buttons) {
										if (buttonId_right == button.getId()) {
											JSONObject btn = new JSONObject();

											btn.put("btnid", Integer.valueOf(button.getId() + "" + menuId2));
											btn.put("btnlabel", button.getButtonName());

											btns.add(btn);
										}
									}
								}
							}
						}

						o2.put("btns", btns);
						children2.add(o2);
					}
				}

				// 菜单下没有子级，则增加按钮
				if (children2.size() > 0) {
					o1.put("children", children2);
				}

				JSONArray btns = new JSONArray();
				if (menu_button_rights != null && menu_button_rights.size() > 0) {
					for (AdminRightshare ar : menu_button_rights) {
						int menuId_right = ar.getRightSourceId();
						int buttonId_right = ar.getResourceId();
						if (menuId_right == menuId1) {
							for (AdminButtonInfo button : menu_buttons) {
								if (buttonId_right == button.getId()) {
									JSONObject btn = new JSONObject();

									btn.put("btnid", Integer.valueOf(button.getId() + "" + menuId1));
									btn.put("btnlabel", button.getButtonName());

									btns.add(btn);
								}
							}
						}
					}
				}
				o1.put("btns", btns);
				currAllmenusArray.add(o1);
			}
		}
		
		System.err.println("===currAllmenusArray=" + currAllmenusArray);
		model.addAttribute("currAllmenusArray", currAllmenusArray);
		/* **end** 获取所有菜单列表********************************************** */

		adminRoleInfo.setCurrUserArray(currUserArray);

		// 组件transfer数据
		JSONArray allUserArray = new JSONArray();
		List<SysUserInfo> allUsers = userService.searchSysUserInfoAll();
		if (allUsers != null && allUsers.size() > 0) {
			for (SysUserInfo u : allUsers) {
				JSONObject userObj = new JSONObject();
				userObj.put("key", u.getId());
				userObj.put("label", u.getLoginName() + "_" + u.getName());
				allUserArray.add(userObj);
			}
		}
		model.addAttribute("allUserArray", allUserArray);
		model.addAttribute("selectUsers", selectUsers);

		model.addAttribute("adminRoleInfo", adminRoleInfo);
		model.addAttribute("isUpdate", isUpdate);
		return "admin/AdminRoleInfoManage";
	}
    
    @RequestMapping(value = "/InsertAdminRoleInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入AdminRoleInfo对象", notes = "插入AdminRoleInfo对象")
    public CommonRestResponse InsertAdminRoleInfo(HttpServletRequest httpRequest, @RequestBody AdminRoleInfo adminRoleInfo) {
        try {
        	String errMsg = "";
        	
        	String roleCode = adminRoleInfo.getRoleCode();
        	String roleName = adminRoleInfo.getRoleName();
        	
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
        	CommonSearchCondition cond = new CommonSearchCondition();
        	cond.setBeanName("roleCode");
        	cond.setColumnName("ROLE_CODE");
        	cond.setOperator("eq");
        	cond.setValue(roleCode);
        	condList.add(cond);
        	List<AdminRoleInfo> roleslist = adminRoleInfoService.searchAdminRoleInfo(condList, null);
        	if(roleslist != null && roleslist.size() > 0) {
        		errMsg += "该角色编码已存在!";
        	}
        	
        	condList = new ArrayList<CommonSearchCondition>();
        	cond = new CommonSearchCondition();
        	cond.setBeanName("roleName");
        	cond.setColumnName("ROLE_NAME");
        	cond.setOperator("eq");
        	cond.setValue(roleName);
        	condList.add(cond);
        	roleslist = adminRoleInfoService.searchAdminRoleInfo(condList, null);
        	if(roleslist != null && roleslist.size() > 0) {
        		errMsg += "该角色名称已存在!";
        	}
        	
        	if("".equals(errMsg)) {
	        	adminRoleInfo.setCreatedBy(baseService.getUserName());
	        	adminRoleInfo.setCreatedTime(new Date());
	        	adminRoleInfo.setLastUpdatedBy(baseService.getUserName());
	        	adminRoleInfo.setLastUpdatedTime(new Date());
	            int roleId = adminRoleInfoService.insertAdminRoleInfo(adminRoleInfo);
	            
	            List<AdminRightshare> rights = null;
	            //分配人员
	            JSONArray userArray = adminRoleInfo.getCurrUserArray();
	            if(userArray != null && userArray.size() > 0) {
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object userObj : userArray) {
						AdminRightshare ar = new AdminRightshare();
						ar.setRightType("R");
						ar.setRightSourceId(roleId);
						ar.setResourceType("2");
						ar.setResourceId(Integer.valueOf(JSONObject.fromObject(userObj).getString("key")));
						rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            //分配菜单
	            JSONArray menuIds = adminRoleInfo.getCheckedMenus();
	            if(menuIds != null && menuIds.size() > 0) {
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object o : menuIds) {
	            		AdminRightshare ar = new AdminRightshare();
						ar.setRightType("M");
						ar.setRightSourceId(Integer.valueOf(String.valueOf(o)));
						ar.setResourceType("0");
						ar.setResourceId(roleId);
						rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            //分配角色-菜单按钮
	            JSONArray buttons = adminRoleInfo.getCheckedButtons();
	            if(buttons != null && buttons.size() > 0) {
	            	rights = new ArrayList<AdminRightshare>();
	            	for (Object o : buttons) {
	            		AdminRightshare ar = new AdminRightshare();
						ar.setRightType("RM");
						ar.setRightSourceId(roleId);
						ar.setResourceType("3M");
						ar.setResourceId(Integer.valueOf(String.valueOf(o)));
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
    
    @RequestMapping(value = "/UpdateAdminRoleInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新AdminRoleInfo", notes = "根据pkId更新AdminRoleInfo")
    public CommonRestResponse updateAdminRoleInfoByPKSelective(HttpServletRequest httpRequest, @RequestBody AdminRoleInfo adminRoleInfo) {
        try {
        	String errMsg = "";
        	
        	String roleCode = adminRoleInfo.getRoleCode();
        	String roleName = adminRoleInfo.getRoleName();
        	int roleId = adminRoleInfo.getId();
        	
        	List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
        	CommonSearchCondition cond = new CommonSearchCondition();
        	cond.setBeanName("roleCode");
        	cond.setColumnName("ROLE_CODE");
        	cond.setOperator("eq");
        	cond.setValue(roleCode);
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(roleId));
        	condList.add(cond);
        	
        	List<AdminRoleInfo> roleslist = adminRoleInfoService.searchAdminRoleInfo(condList, null);
        	if(roleslist != null && roleslist.size() > 0) {
        		errMsg += "该角色编码已存在!";
        	}
        	
        	condList = new ArrayList<CommonSearchCondition>();
        	cond = new CommonSearchCondition();
        	cond.setBeanName("roleName");
        	cond.setColumnName("ROLE_NAME");
        	cond.setOperator("eq");
        	cond.setValue(roleName);
        	condList.add(cond);
        	
        	cond = new CommonSearchCondition();
            cond.setBeanName("id");
            cond.setColumnName("ID");
            cond.setOperator("ne");
            cond.setValue(String.valueOf(roleId));
        	condList.add(cond);
        	
        	roleslist = adminRoleInfoService.searchAdminRoleInfo(condList, null);
        	if(roleslist != null && roleslist.size() > 0) {
        		errMsg += "该角色名称已存在!";
        	}
        	
        	if("".equals(errMsg)) {
	        	adminRoleInfo.setLastUpdatedBy(baseService.getUserName());
	        	adminRoleInfo.setLastUpdatedTime(new Date());
	            adminRoleInfoService.updateAdminRoleInfoByPKSelective(adminRoleInfo);
	            
	            List<AdminRightshare> rights = null;
	            //分配人员
	            JSONArray userArray = adminRoleInfo.getCurrUserArray();
	            //System.err.println("=====userIDS size=" + users.size());
	            if(userArray != null && userArray.size() > 0) {
	            	//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("R");
	        		arDel.setRightSourceId(roleId);
	        		arDel.setResourceType("2");
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	            	
	        		rights = new ArrayList<AdminRightshare>();
	            	for (Object userObj : userArray) {
						AdminRightshare ar = new AdminRightshare();
						ar.setRightType("R");
						ar.setRightSourceId(roleId);
						ar.setResourceType("2");
						ar.setResourceId(Integer.valueOf(JSONObject.fromObject(userObj).getString("key")));
						rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            //分配菜单
	            JSONArray menuIds = adminRoleInfo.getCheckedMenus();
	            if(menuIds != null && menuIds.size() > 0) {
	            	//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("M");
	        		arDel.setResourceType("0");
	        		arDel.setResourceId(roleId);
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	            	
	        		rights = new ArrayList<AdminRightshare>();
	            	for (Object o : menuIds) {
	            		AdminRightshare ar = new AdminRightshare();
						ar.setRightType("M");
						ar.setRightSourceId(Integer.valueOf(String.valueOf(o)));
						ar.setResourceType("0");
						ar.setResourceId(roleId);
						rights.add(ar);
					}
	            	rightService.insertOrUpdateBetch(rights);
	            }
	            
	            //分配角色-菜单按钮
	            JSONArray buttons = adminRoleInfo.getCheckedButtons();
	            if(buttons != null && buttons.size() > 0) {
	            	//删除已存在授权后再保存
	        		AdminRightshare arDel = new AdminRightshare();
	        		arDel.setRightType("RM");
	        		arDel.setRightSourceId(roleId);
	        		arDel.setResourceType("3M");
	        		rightService.deleteAdminRightshareByPKSelective(arDel);
	            	
	        		rights = new ArrayList<AdminRightshare>();
	            	for (Object o : buttons) {
	            		AdminRightshare ar = new AdminRightshare();
						ar.setRightType("RM");
						ar.setRightSourceId(roleId);
						ar.setResourceType("3M");
						ar.setResourceId(Integer.valueOf(String.valueOf(o)));
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    @RequestMapping(value="AdminRoleInfo",method = RequestMethod.GET)
    @ApiOperation(value = "AdminRoleInfo默认页面模板", notes = "AdminRoleInfo默认页面模板")
    public String AdminRoleInfoTemplate() {
        return "adminRole/AdminRoleInfo";
    }

    @RequestMapping(value = "AdminRoleInfo/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取AdminRoleInfo", notes = "根据pkId获取AdminRoleInfo",response = AdminRoleInfo.class)
    public CommonRestResponse getAdminRoleInfoByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            AdminRoleInfo adminRoleInfo = adminRoleInfoService.getAdminRoleInfoByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminRoleInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "AdminRoleInfo/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入AdminRoleInfo对象", notes = "插入AdminRoleInfo对象")
    public CommonRestResponse insertAdminRoleInfo(HttpServletRequest httpRequest, @RequestBody AdminRoleInfo adminRoleInfo) {
        try {
            //TODO authentication to be done
            
            adminRoleInfoService.insertAdminRoleInfo(adminRoleInfo);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

      

    @RequestMapping(value = "AdminRoleInfo/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminRoleInfo导出接口，返回待下载的Excel文件名", notes = "AdminRoleInfo导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAdminRoleInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminRoleInfo.class);
            PagingRestResponse response = adminRoleInfoService.searchAdminRoleInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<AdminRoleInfo> resultList = (List<AdminRoleInfo>)response.getData();

				if(resultList!=null){
					List<String> headerList = new ArrayList<String>();
					headerList.add("id");
					headerList.add("roleCode");
					headerList.add("roleName");
					headerList.add("memo");
					headerList.add("状态：0启用，1禁用");
					headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(AdminRoleInfo row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getRoleCode());
                    rowList.add(row.getRoleName());
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
    @RequestMapping(value="/AdminRoleInfoNewJob",method = RequestMethod.GET)
    @ApiOperation(value = "AdminRoleInfoNewJob默认页面模板", notes = "AdminRoleInfoNewJob默认页面模板")
    public String AdminRoleInfoCreat(Model model) {
    	logger.debug("新建角色....");
    	AdminRoleInfo adminRoleInfo = new AdminRoleInfo();
        model.addAttribute("adminRoleInfo",adminRoleInfo);
        model.addAttribute("isUpdate",false);	//是否新增：false-新增	true-修改
        return "admin/AdminRoleInfoNewJob";
    }
   
}