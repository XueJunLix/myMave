package com.ur.eureka.model;

import java.util.Date;

public class AdminUserInfoBO {
	//private static final long serialVersionUID = -1041327031937199938L;

    private Integer userId;

    //登录ID
    private String loginId;

    //登录密码
    private String loginPassword;

    //用户名
    private String adminUserName;

    //用户类型
    private Integer adminUserType;

    //用户职位
    private String adminUserPose;

    //用户部门
    private String adminUserDepartment;

    //用户公司
    private String adminUserCompany;

    //用户电话
    private String adminUserTelephone;

    //用户手机
    private String adminUserMobile;

    //用户邮箱
    private String adminUserEmail;

    //状态
    private Integer status;

    //备注
    private String memo;

    //工号
    private String adminUserCode;

    //店铺编码
    private String adminShopCode;
    
    private Integer createUser;
    
    private Date modifyTime;
    
    private Integer modifyUser;
    private Date createTime;

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Integer modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public Integer getAdminUserType() {
		return adminUserType;
	}

	public void setAdminUserType(Integer adminUserType) {
		this.adminUserType = adminUserType;
	}

	public String getAdminUserPose() {
		return adminUserPose;
	}

	public void setAdminUserPose(String adminUserPose) {
		this.adminUserPose = adminUserPose;
	}

	public String getAdminUserDepartment() {
		return adminUserDepartment;
	}

	public void setAdminUserDepartment(String adminUserDepartment) {
		this.adminUserDepartment = adminUserDepartment;
	}

	public String getAdminUserCompany() {
		return adminUserCompany;
	}

	public void setAdminUserCompany(String adminUserCompany) {
		this.adminUserCompany = adminUserCompany;
	}

	public String getAdminUserTelephone() {
		return adminUserTelephone;
	}

	public void setAdminUserTelephone(String adminUserTelephone) {
		this.adminUserTelephone = adminUserTelephone;
	}

	public String getAdminUserMobile() {
		return adminUserMobile;
	}

	public void setAdminUserMobile(String adminUserMobile) {
		this.adminUserMobile = adminUserMobile;
	}

	public String getAdminUserEmail() {
		return adminUserEmail;
	}

	public void setAdminUserEmail(String adminUserEmail) {
		this.adminUserEmail = adminUserEmail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAdminUserCode() {
		return adminUserCode;
	}

	public void setAdminUserCode(String adminUserCode) {
		this.adminUserCode = adminUserCode;
	}

	public String getAdminShopCode() {
		return adminShopCode;
	}

	public void setAdminShopCode(String adminShopCode) {
		this.adminShopCode = adminShopCode;
	}

}
