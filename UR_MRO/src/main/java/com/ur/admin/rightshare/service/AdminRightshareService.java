package com.ur.admin.rightshare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.button.service.AdminButtonInfoService;
import com.ur.admin.rightshare.mappers.AdminRightshareMapper;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.common.Constants;
import com.ur.common.UserInfo;
import com.ur.common.service.BaseService;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

@Service
public class AdminRightshareService {
		
    @Autowired
    AdminRightshareMapper adminRightshareMapper;
    
    @Autowired
	RedisMessageBOService redisService;
    
    @Autowired
	BaseService baseService;
    
    @Autowired
	SysUserInfoService userService;
    
    @Autowired
    AdminButtonInfoService buttonService;

    public AdminRightshare getAdminRightshareByPK(Integer pkId) {
        return adminRightshareMapper.getAdminRightshareByPK(pkId);
    }

    @Transactional
    private AdminRightshare insertAdminRightshare(AdminRightshare adminRightshare) {
        List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
        CommonSearchCondition cond = new CommonSearchCondition();
        cond.setBeanName("rightType");
        cond.setColumnName("RIGHT_TYPE");
        cond.setOperator("eq");
        cond.setValue(adminRightshare.getRightType());
        condList.add(cond);
        
        cond = new CommonSearchCondition();
        cond.setBeanName("rightSourceId");
        cond.setColumnName("RIGHT_SOURCE_ID");
        cond.setOperator("eq");
        cond.setValue(String.valueOf(adminRightshare.getRightSourceId()));
        condList.add(cond);
        
        cond = new CommonSearchCondition();
        cond.setBeanName("resourceType");
        cond.setColumnName("RESOURCE_TYPE");
        cond.setOperator("eq");
        cond.setValue(adminRightshare.getResourceType());
        condList.add(cond);
        
        cond = new CommonSearchCondition();
        cond.setBeanName("resourceId");
        cond.setColumnName("RESOURCE_ID");
        cond.setOperator("eq");
        cond.setValue(String.valueOf(adminRightshare.getResourceId()));
        condList.add(cond);
        List<AdminRightshare> rightList = adminRightshareMapper.searchAdminRightshare(null, condList, null, null);
    	if(rightList == null || rightList.size() <= 0) {
	        adminRightshareMapper.insertAdminRightshare(adminRightshare);
    	}
    	return adminRightshare;
    }

    @Transactional
    private AdminRightshare updateAdminRightshareByPKSelective(AdminRightshare adminRightshare) {
        adminRightshareMapper.updateAdminRightshareByPKSelective(adminRightshare);
        return adminRightshare;
    }
    
    /**
     *	 批量插入、修改
     * @param rights
     * @return
     */
    public List<AdminRightshare> insertOrUpdateBetch(List<AdminRightshare> rights){
    	List<AdminRightshare> resultList = null;
    	if(rights != null && rights.size() > 0) {
    		resultList = new ArrayList<AdminRightshare>();
    		
    		String M_0 = "0";	//菜单--角色关系
    		String M_1 = "0";	//菜单--用户组关系
    		String M_3 = "0";	//菜单--操作按钮关系
    		String R_2 = "0";	//角色--人员关系
    		String R_3 = "0";	//角色--操作按钮关系
    		String U_2 = "0";	//用户组--人员关系
    		
    		for (AdminRightshare ar : rights) {
    			String rightType = ar.getRightType();
    			String resourceType = ar.getResourceType();
    			
    			if("M".equals(rightType) && "0".equals(resourceType)) {
    				M_0 = "1";
    			} else if("M".equals(rightType) && "1".equals(resourceType)) {
    				M_1 = "1";
    			} else if("M".equals(rightType) && "3".equals(resourceType)) {
    				M_3 = "1";
    			} else if("R".equals(rightType) && "2".equals(resourceType)) {
    				R_2 = "1";
    			} else if("R".equals(rightType) && "3".equals(resourceType)) {
    				R_3 = "1";
    			} else if("U".equals(rightType) && "2".equals(resourceType)) {
    				U_2 = "1";
    			}
    			
				insertAdminRightshare(ar);
				resultList.add(ar);
			}
    		//修改成功：删除redis key，在查询时重新加载在redis
    		delRedisCache(M_0, M_1, M_3, R_2, R_3, U_2);
    	}
    	return resultList;
    }
    
    @Transactional
    public void deleteAdminRightshareByPKSelective(AdminRightshare adminRightshare) {
    	String rightType = adminRightshare.getRightType();
		String resourceType = adminRightshare.getResourceType();
		
		String M_0 = "0";	//菜单--角色关系
		String M_1 = "0";	//菜单--用户组关系
		String M_3 = "0";	//菜单--操作按钮关系
		String R_2 = "0";	//角色--人员关系
		String RM_3M = "0";	//角色--菜单按钮关系
		String U_2 = "0";	//用户组--人员关系
		
		if("M".equals(rightType) && "0".equals(resourceType)) {
			M_0 = "1";
		} else if("M".equals(rightType) && "1".equals(resourceType)) {
			M_1 = "1";
		} else if("M".equals(rightType) && "3".equals(resourceType)) {
			M_3 = "1";
		} else if("R".equals(rightType) && "2".equals(resourceType)) {
			R_2 = "1";
		} else if("RM".equals(rightType) && "3M".equals(resourceType)) {
			RM_3M = "1";
		} else if("U".equals(rightType) && "2".equals(resourceType)) {
			U_2 = "1";
		}
		
    	adminRightshareMapper.deleteAdminRightshareByPKSelective(adminRightshare);
        //修改成功：删除redis key，在查询时重新加载在redis
    	delRedisCache(M_0, M_1, M_3, R_2, RM_3M, U_2);
    }

    public PagingRestResponse searchAdminRightshare(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = adminRightshareMapper.searchAdminRightshareCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<AdminRightshare> resultList = null;
        if(totalRecordNum>0){
            resultList = adminRightshareMapper.searchAdminRightshare(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    
    
	public List<AdminRightshare> searchAdminRightshareDef(List<CommonSearchCondition> condList) {
    	List<AdminRightshare> resultList = null;    	
    	try {
    		if(resultList == null) {
    			resultList = adminRightshareMapper.searchAdminRightshare(null,condList,null,null);
    		}
    	} catch (Exception e) {
    		System.err.println("==获取权限方法：searchAdminRightshareDef 异常==");
    		e.printStackTrace();
    	}
    	
    	
        return resultList;
    }
	
	
	/**
	 * 	根据授权组合查询相关的权限，对应的组合有：
	 * 	M-0 菜单对应角色	
	 * 	M-1 菜单对应用户组	
	 * 	M-3 菜单对应操作按钮	
	 * 	R-2 角色对应人员	
	 * 	R-3 角色对应操作按钮	
	 * 	U-2 用户组对应人员
	 * 
	 * @param rightType	对应的取值：M-菜单类型		R-角色类型		U-用户组类型
	 * @param resourceType 对应的取值：0-角色		1-用户组		2-人员		3-操作按钮
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AdminRightshare> searchAdminRightshareAll(String rightType, String resourceType) {
    	List<AdminRightshare> resultList = null;
    	try {	
    		if(rightType != null && !"".equals(rightType) && resourceType != null && !"".equals(resourceType)) {
	    		String redisKey = "";
	    		
	    		if("M".equals(rightType) && "0".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_M_0_KEY;
	    		} else if("M".equals(rightType) && "1".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_M_1_KEY;
	    		} else if("M".equals(rightType) && "3".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_M_3_KEY;
	    		} else if("R".equals(rightType) && "2".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_R_2_KEY;
	    		} else if("RM".equals(rightType) && "3M".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_RM_3M_KEY;
	    		} else if("U".equals(rightType) && "2".equals(resourceType)) {
	    			redisKey = Constants.SYS_RIGHTSHARE_U_2_KEY;
	    		}
	    		System.err.println("===redisKey=" + redisKey);
	    		Object list = redisService.getFromRedis(redisKey);
	    		System.err.println("----------------==list===" + list);
	    		if(list == null || (list != null && ((List<AdminRightshare>)list).size() <= 0 )) {
	    			List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
	    			CommonSearchCondition cond = new CommonSearchCondition();
	    			cond.setBeanName("rightType");
	    			cond.setColumnName("RIGHT_TYPE");
	    			cond.setOperator("eq");
	    			cond.setValue(rightType);
	    			condList.add(cond);
	    			
	    			cond = new CommonSearchCondition();
	    			cond.setBeanName("resourceType");
	    			cond.setColumnName("RESOURCE_TYPE");
	    			cond.setOperator("eq");
	    			cond.setValue(resourceType);
	    			condList.add(cond);
	    			
	    			resultList = adminRightshareMapper.searchAdminRightshare(null, condList, null, null);
	    			System.err.println("---------resultList------=====" + resultList.size());
	    			redisService.addRedis(redisKey, resultList);
	    		} else {
	    			resultList = (List<AdminRightshare>)list;
	    		}
    		}
    	} catch (Exception e) {
    		System.err.println("==获取所有权限方法：searchAdminRightshareAll 异常==");
    		e.printStackTrace();
    	}
	    return resultList;
    }
	
	/**
	 * 根据用户组ID获取该用户组下所有用户id，格式：1,2,3,4...
	 * @param usergroupId	用户组ID
	 * @return
	 */
	public String getUserIdByUserGroupId(String usergroupId) {
		StringBuffer userIds = new StringBuffer();
		userIds.append("-1");	//初始值
		
		List<AdminRightshare> rights = this.searchAdminRightshareAll("U","2");
		if(!rights.isEmpty()) {
			for (AdminRightshare ar : rights) {
				if(ar.getRightSourceId() == Integer.valueOf(usergroupId)) {
					userIds.append("," + ar.getResourceId());
				}
			}
		}
		return userIds.toString();
	}
	
	/**
	 * 	获取当前用户对应的菜单操作按钮
	 * @param btnTag	按钮类别：L-列表按钮	D-详情页按钮
	 * @return
	 */
	public List<AdminButtonInfo> getOperateBtnByCurrUser(String btnTag, int menuId) {
		List<AdminButtonInfo> buttons = null;
		try {
			UserInfo user = baseService.getCurrentLoginUserInfo();
			System.err.println("===userName="+user.getUsername()+"======userId=" + user.getId());
			
			List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
			CommonSearchCondition cond = new CommonSearchCondition();
			cond.setBeanName("loginName");
			cond.setColumnName("LOGIN_NAME");
			cond.setOperator("eq");
			cond.setValue(user.getUsername());
			condList.add(cond);
			
			SysUserInfo su = userService.searchSysUserInfo(condList, null).get(0);
			
			String userLoginId = su.getLoginName();
			int userId = su.getId();
			
			List<Integer> buttonIds = new ArrayList<Integer>();
			
			//根据系统用户ID，查找是否是-系统管理员角色成员
			boolean isSysRole = false;
			List<String> userIds = getUserIdByRoleId("1");
			if(userIds.contains(String.valueOf(userId)) || "admin".equals(userLoginId)) {
				isSysRole = true;
			}
			
			//	管理员用户或者管理员角色用户
			if(isSysRole) {
				List<AdminRightshare> btnList = searchAdminRightshareAll("M", "3");
				if(btnList!=null && btnList.size() > 0) {
					for (AdminRightshare ar : btnList) {
						buttonIds.add(ar.getResourceId());
					}
				}
			}
			//	非管理员或者非管理员角色用户
			else {
				//	第一步：查找角色对应的人员
				List<AdminRightshare> roleUsersList = searchAdminRightshareAll("R", "2");
				
				//	第2步：查找菜单对应的角色
				List<AdminRightshare> menuRolesList = searchAdminRightshareAll("M", "0");
				
				//	第3步：查找菜单对应的按钮
				List<AdminRightshare> menuButtonsList = searchAdminRightshareAll("M", "3");
				
				//	第4步：查找角色对应的菜单按钮
				List<AdminRightshare> roleMenuButtonsList = searchAdminRightshareAll("RM", "3M");
				
				for(AdminRightshare ur : roleUsersList) {
					int ur_roleId = ur.getRightSourceId();	//角色Id
					int ur_userId = ur.getResourceId();	//用户ID
					
					if(ur_userId == userId) {
						System.err.println("===ur_userId=" + ur_userId + "===ur_roleId=" + ur_roleId + "==========menuId=" + menuId);
						for (AdminRightshare mr : menuRolesList) {
							int mr_menuId = mr.getRightSourceId();	//菜单Id
							int mr_roleId = mr.getResourceId();	//角色ID
							if(ur_roleId == mr_roleId && mr_menuId == menuId) {
								System.err.println("===mr_menuId=" + mr_menuId + "===mr_roleId=" + mr_roleId+ "==========menuId=" + menuId);
								for(AdminRightshare mb : menuButtonsList) {
									int mb_menuId = mb.getRightSourceId();	//菜单Id
									int mb_buttonId = mb.getResourceId();	//按钮ID
									if(mr_menuId == mb_menuId && menuId == mr_menuId) {
										System.err.println("===mb_menuId=" + mb_menuId + "===mb_buttonId=" + mb_buttonId+ "==========menuId=" + menuId);
										for(AdminRightshare rb : roleMenuButtonsList) {
											int rmb_roleId = rb.getRightSourceId();	//角色Id
											int rmb_buttonId = rb.getResourceId();	//菜单按钮ID
											if(rmb_roleId == ur_roleId && Integer.valueOf(mb_buttonId + "" + mb_menuId) == rmb_buttonId) {
												buttonIds.add(mb_buttonId);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			System.err.println("===buttons=" + buttonIds.toString());
			List<AdminButtonInfo> allButtons = buttonService.searchAdminButtonInfoAll();
			if(allButtons != null && allButtons.size() > 0) {
				buttons = new ArrayList<AdminButtonInfo>();
				for (AdminButtonInfo btn : allButtons) {
					if(buttonIds.contains(btn.getId()) && btn.getButtonCode().indexOf("MRO_" + btnTag) > -1) {
						buttons.add(btn);
					}
				}
			}
			
		} catch (Exception e) {
			System.err.println("获取当前用户对应的菜单操作按钮异常==getOperateBtnByCurrUser=" + e.getMessage());
			e.printStackTrace();
		}
		return buttons;
	}
	
	
	/**
	 * 根据角色ID获取该角色下所有用户id，格式：1,2,3,4...
	 * @param roleId	角色ID
	 * @return
	 */
	public List<String> getUserIdByRoleId(String roleId) {
		List<String> userIds = new ArrayList<String>();
		
		List<AdminRightshare> rights = this.searchAdminRightshareAll("R","2");
		if(!rights.isEmpty()) {
			for (AdminRightshare ar : rights) {
				if(ar.getRightSourceId() == Integer.valueOf(roleId)) {
					userIds.add(ar.getResourceId() + "");
				}
			}
		}
		return userIds;
	}
	
	private void delRedisCache(String M_0, String M_1, String M_3, String R_2, String RM_3M, String U_2) {
		if("1".equals(M_0)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_M_0_KEY);
		}
		if("1".equals(M_1)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_M_1_KEY);
		}
		if("1".equals(M_3)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_M_3_KEY);
		}
		if("1".equals(R_2)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_R_2_KEY);
		}
		if("1".equals(RM_3M)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_RM_3M_KEY);
		}
		if("1".equals(U_2)) {
			redisService.delRedis(Constants.SYS_RIGHTSHARE_U_2_KEY);
		}
	}
}