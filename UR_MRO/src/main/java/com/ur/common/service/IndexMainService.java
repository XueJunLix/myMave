package com.ur.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ur.admin.menu.model.AdminMenuInfo;
import com.ur.admin.menu.service.AdminMenuInfoService;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.common.util.Util;
import com.ur.fw.common.rest.CommonSearchCondition;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class IndexMainService {
	
	private final String SYSTEM_ADMIN = "admin";

	private static Logger log = LoggerFactory.getLogger(IndexMainService.class);

	@Autowired
	BaseService baseService;
	
	@Autowired
	AdminRightshareService rightshareService;
	
	@Autowired
	AdminMenuInfoService menuService;
	
	/**
	 * 根据当前用户获取对应的菜单
	 * @param user	用户信息
	 * @return
	 */
	public JSONArray getMenusByCurrUser(SysUserInfo user) {
		log.debug("根据当前用户获取对应的菜单：getMenusByCurrUser......");
		JSONArray menuArray = null;
		try {
			List<AdminMenuInfo> menus = new ArrayList<AdminMenuInfo>();
			Set<Map<String, Object>> menuLevel1 = new HashSet<Map<String, Object>>();
			Set<Map<String, Object>> menuLevel2 = new HashSet<Map<String, Object>>();
			Set<Map<String, Object>> menuLevel3 = new HashSet<Map<String, Object>>();
			
			//System.err.println(user.getLoginName() + "========" + user.getName() + "=======" + user.getId());
			
			//根据系统用户ID，查找是否是-系统管理员角色成员
			boolean isSysRole = false;
			List<String> userIds = rightshareService.getUserIdByRoleId("1");
			if(userIds.contains(String.valueOf(user.getId())) || SYSTEM_ADMIN.equals(user.getLoginName())) {
				isSysRole = true;
			}
						
			if(isSysRole) {
				menus = menuService.searchAdminMenuInfo(null, null);
				if(menus != null && menus.size() > 0) {
					for(AdminMenuInfo m : menus) {
						int level = m.getMenuLevel();
						
						Map<String,Object> menuMap = new HashMap<String, Object>();
						menuMap.put("id", m.getId());
						menuMap.put("menucode", m.getMenuCode());
						menuMap.put("menuname", m.getMenuName());
						menuMap.put("menuparentid", m.getParentMenuId());
						menuMap.put("menuurl", m.getMenuUrl());
						menuMap.put("orderby", m.getOrderBy());
						
						if(level == 1) {
							menuLevel1.add(menuMap);
						} else if(level == 2) {
							menuLevel2.add(menuMap);
						} else  if(level == 3){
							menuLevel3.add(menuMap);
						}
					}
					menuArray = buildMenu(isSysRole,menuLevel1,menuLevel2,menuLevel3);
				}
			} 
			
			//非管理员根据授权角色获取菜单列表
			else {
				List<CommonSearchCondition> condList = null;
				CommonSearchCondition cond = null;
				
				//查找人员对应的角色
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
				cond.setValue(String.valueOf(user.getId()));
				condList.add(cond);
				
				List<AdminRightshare> rightList = rightshareService.searchAdminRightshareDef(condList);
				StringBuffer roleIds = null;
				if(rightList != null && rightList.size() > 0) {
					roleIds = new StringBuffer();
					roleIds.append("-11");
					for (AdminRightshare rh : rightList) {
						roleIds.append("," + rh.getRightSourceId());
					}
				}
				//根据角色获取对应的菜单信息
				if(roleIds != null) {
					condList = new ArrayList<CommonSearchCondition>();
					
					cond = new CommonSearchCondition();
					cond.setBeanName("rightType");
					cond.setColumnName("RIGHT_TYPE");
					cond.setOperator("eq");
					cond.setValue("M");
					condList.add(cond);
					
					cond = new CommonSearchCondition();
					cond.setBeanName("resourceType");
					cond.setColumnName("RESOURCE_TYPE");
					cond.setOperator("eq");
					cond.setValue("0");
					condList.add(cond);
					
					cond = new CommonSearchCondition();
					cond.setBeanName("resourceId");
					cond.setColumnName("RESOURCE_ID");
					cond.setOperator("in");
					cond.setValue(roleIds.toString());
					condList.add(cond);
					
					rightList = rightshareService.searchAdminRightshareDef(condList);
					StringBuffer menuIds = null;
					if(rightList != null && rightList.size() > 0) {
						menuIds = new StringBuffer();
						menuIds.append("-11");
						for (AdminRightshare rh : rightList) {
							menuIds.append("," + rh.getRightSourceId());
						}
					}
					
					
					//根据菜单ID，获取菜单列表
					if(menuIds != null) {
						condList = new ArrayList<CommonSearchCondition>();
						
						cond = new CommonSearchCondition();
						cond.setBeanName("id");
						cond.setColumnName("ID");
						cond.setOperator("in");
						cond.setValue(menuIds.toString());
						condList.add(cond);
						
						cond = new CommonSearchCondition();
						cond.setBeanName("status");
						cond.setColumnName("STATUS");
						cond.setOperator("eq");
						cond.setValue("1");
						condList.add(cond);
						
						menus = menuService.searchAdminMenuInfo(condList, null);
						
						if(menus != null && menus.size() > 0) {
							for(AdminMenuInfo m : menus) {
								int level = m.getMenuLevel();
								
								Map<String,Object> menuMap = new HashMap<String, Object>();
								menuMap.put("id", m.getId());
								menuMap.put("menucode", m.getMenuCode());
								menuMap.put("menuname", m.getMenuName());
								menuMap.put("menuparentid", m.getParentMenuId());
								menuMap.put("menuurl", m.getMenuUrl());
								menuMap.put("orderby", m.getOrderBy());
								
								if(level == 1) {
									menuLevel1.add(menuMap);
								} else if(level == 2) {
									menuLevel2.add(menuMap);
								}  else if(level == 3) {
									menuLevel3.add(menuMap);
								}
							}
							menuArray = buildMenu(isSysRole,menuLevel1,menuLevel2,menuLevel3);
						}
					}
				}
			}		
			
		} catch (Exception e) {
			System.err.println("根据当前用户获取对应的菜单-方法：getMenusByCurrUser异常：\n");
			e.printStackTrace();
		}
		
		return menuArray;
	}
	
	
	
	private JSONArray buildMenu(boolean isSysRole,Set<Map<String, Object>> menuLevel1, Set<Map<String, Object>> menuLevel2, Set<Map<String, Object>> menuLevel3) {
		JSONArray menuArray = new JSONArray();
		
		if(!isSysRole) {
			List<AdminMenuInfo> allMenus = menuService.searchAdminMenuInfoAll();
			
			System.err.println("==b=menuLevel2=:" + menuLevel2.size());
			for (Map<String,Object> ml2 : menuLevel2) {
				System.err.println("==b=menuLevel2==code&name=:" + ml2.toString());
			}
			
			
			if(menuLevel3 != null && menuLevel3.size() > 0) {
				for (Map<String,Object> ml3 : menuLevel3) {
					System.err.println("====menuLevel3=id&code&name=" + ml3.toString());
					for (AdminMenuInfo m3tom2 : allMenus) {
						if(Integer.valueOf(String.valueOf(ml3.get("menuparentid"))) == m3tom2.getId()) {
							Map<String,Object> tmpMenuMap = new HashMap<String, Object>();
							tmpMenuMap.put("id", m3tom2.getId());
							tmpMenuMap.put("menucode", m3tom2.getMenuCode());
							tmpMenuMap.put("menuname", m3tom2.getMenuName());
							tmpMenuMap.put("menuparentid", m3tom2.getParentMenuId());
							tmpMenuMap.put("menuurl", m3tom2.getMenuUrl());
							tmpMenuMap.put("orderby", m3tom2.getOrderBy());
							
							menuLevel2.add(tmpMenuMap);
							break;
						}
					}
				}
			}
			System.err.println("==a=menuLevel2=:" + menuLevel2.size());
			for (Map<String,Object> ml2 : menuLevel2) {
				System.err.println("==a=menuLevel2==code&name=:" + ml2.toString());
			}
			
			
			
			System.err.println("==b=menuLevel1=:" + menuLevel1.size());
			if(menuLevel2 != null && menuLevel2.size() > 0) {
				for (Map<String,Object> ml2 : menuLevel2) {
					for (AdminMenuInfo m2tom1 : allMenus) {
						if(Integer.valueOf(String.valueOf(ml2.get("menuparentid"))) == m2tom1.getId()) {
							Map<String,Object> tmpMenuMap = new HashMap<String, Object>();
							tmpMenuMap.put("id", m2tom1.getId());
							tmpMenuMap.put("menucode", m2tom1.getMenuCode());
							tmpMenuMap.put("menuname", m2tom1.getMenuName());
							tmpMenuMap.put("menuparentid", m2tom1.getParentMenuId());
							tmpMenuMap.put("menuurl", m2tom1.getMenuUrl());
							tmpMenuMap.put("orderby", m2tom1.getOrderBy());
							
							menuLevel1.add(tmpMenuMap);
							break;
						}
					}
				}
			}
			
			System.err.println("==a=menuLevel1=:" + menuLevel1.size());
		}
		
		List<Map<String,Object>> ms1 = new ArrayList<Map<String,Object>>(menuLevel1);
		//	排序一级菜单
		Collections.sort(ms1, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				int order = Integer.valueOf(String.valueOf(o1.get("orderby"))) - Integer.valueOf(String.valueOf(o2.get("orderby")));
				if (order > 0) {
					return 1;
				} else if (order < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		}); 
		
		// 排序二级菜单
		List<Map<String,Object>> ms2 = new ArrayList<Map<String,Object>>(menuLevel2);
		Collections.sort(ms2, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				int order = Integer.valueOf(String.valueOf(o1.get("orderby"))) - Integer.valueOf(String.valueOf(o2.get("orderby")));
				if (order > 0) {
					return 1;
				} else if (order < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		}); 
		// 排序三级菜单
		List<Map<String,Object>> ms3 = new ArrayList<Map<String,Object>>(menuLevel3);
		Collections.sort(ms3, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				int order = Integer.valueOf(String.valueOf(o1.get("orderby"))) - Integer.valueOf(String.valueOf(o2.get("orderby")));
				if (order > 0) {
					return 1;
				} else if (order < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		 
		
		
		if(ms1.size() > 0) {
			menuArray = new JSONArray();
			for(Map<String,Object> m1 : ms1) {
				int id = Integer.parseInt(String.valueOf(m1.get("id")));
				String name = Util.null2String(m1.get("menuname")).trim();
				String url = Util.null2String(m1.get("menuurl")).trim();
				
				JSONObject jo1 = new JSONObject();
				jo1.put("menuid", String.valueOf(id));
				jo1.put("menutab", name);
				jo1.put("menuname", name);
				jo1.put("menuurl", url);
				JSONArray children2 = new JSONArray();
				
				if(ms2.size() > 0) {
					for(Map<String,Object> m2 : ms2) {
						Integer id2 = Integer.parseInt(String.valueOf(m2.get("id")));
						Integer pid2 = Integer.parseInt(String.valueOf(m2.get("menuparentid")));
						String name2 = Util.null2String(m2.get("menuname")).trim();
						String url2 = Util.null2String(m2.get("menuurl")).trim();
						
						JSONObject jo2 = new JSONObject();
						jo2.put("menuid", String.valueOf(id2));
						jo2.put("menutab", name2);
						jo2.put("menuname", name2);
						jo2.put("menuurl", url2);
						
						JSONArray children3 = new JSONArray();
						//三级菜单与二级菜单匹配
						if(ms3.size() > 0) {
							for(Map<String,Object> m3 : ms3) {
								Integer id3 = Integer.parseInt(String.valueOf(m3.get("id")));
								Integer pid3 = Integer.parseInt(String.valueOf(m3.get("menuparentid")));
								String name3 = Util.null2String(m3.get("menuname")).trim();
								String url3 = Util.null2String(m3.get("menuurl")).trim();
								
								if(id2 == pid3) {
									JSONObject jo3 = new JSONObject();
									jo3.put("menuid", String.valueOf(id3));
									jo3.put("menutab", name3);
									jo3.put("menuname", name3);
									jo3.put("menuurl", url3);
									children3.add(jo3);
								}
							}
						}
						if(children3.size() > 0) {
							jo2.put("children", children3);
						}
						//二级菜单与一级菜单匹配
						if(pid2!= null && id == pid2) {
							children2.add(jo2);
						}
					}
				}
				if(children2.size() > 0) {
					jo1.put("children", children2);
				}
				menuArray.add(jo1);
			}
		}
		
		return menuArray;
	}
}
