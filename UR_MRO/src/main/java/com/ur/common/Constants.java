package com.ur.common;

/**
 * Created by Lesng on 2015/7/23.
 */
public class Constants {
    public static final Integer MAX_INT = 999999999;
    
    /**
     * 	系统管理：用户组对应的redis key值
     * */
    public final static String SYSTEM_USERGROUP_KEY = "SYSTEM_USERGROUP_KEY";
    
    /**
     * 	系统管理：用户对应的redis key值
     * */
    public final static String SYSTEM_USER_KEY = "SYSTEM_USER_KEY";

    /**
     * 	系统管理：角色对应的redis key值
     * */
    public final static String SYSTEM_ROLES_KEY = "SYSTEM_ROLES_KEY";	//用于在redis上存储所有角色的key
    
    /**
     * 	系统管理：菜单对应的redis key值
     * */
    public final static String SYSTEM_MENUS_KEY = "SYSTEM_MENUS_KEY";
    
    /**
     * 	系统管理：按钮对应的redis key值
     * */
    public final static String SYSTEM_BUTTON_KEY = "SYSTEM_BUTTON_KEY";
    
    
    /**
	 * 	菜单--角色
	 */
	public final static String SYS_RIGHTSHARE_M_0_KEY = "SYS_RIGHTSHARE_M_0_KEY";
	
	/**
	 * 	菜单--用户组
	 */
	public final static String SYS_RIGHTSHARE_M_1_KEY = "SYS_RIGHTSHARE_M_1_KEY";
	
	/**
	 * 	菜单--操作按钮
	 */
	public final static String SYS_RIGHTSHARE_M_3_KEY = "SYS_RIGHTSHARE_M_3_KEY";
	
	/**
	 * 	角色--人员
	 */
	public final static String SYS_RIGHTSHARE_R_2_KEY = "SYS_RIGHTSHARE_R_2_KEY";
	
	/**
	 * 	用户组--人员
	 */
	public final static String SYS_RIGHTSHARE_U_2_KEY = "SYS_RIGHTSHARE_U_2_KEY";
	
	/**
	 * 	角色--菜单按钮
	 */
	public final static String SYS_RIGHTSHARE_RM_3M_KEY = "SYS_RIGHTSHARE_RM_3M_KEY";
}
