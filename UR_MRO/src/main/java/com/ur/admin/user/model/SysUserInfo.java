package com.ur.admin.user.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONArray;

/**
 * TableName SYS_USERS
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SYS_USERS null")
public class SysUserInfo {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 10, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "LOGIN_NAME", nullable = true, length = 100, precision = 0)
    private String loginName;

    @ApiModelProperty(value = "null")
    @Column(name = "NAME", nullable = true, length = 100, precision = 0)
    private String name;

    @ApiModelProperty(value = "null")
    @Column(name = "PASSWORD", nullable = true, length = 100, precision = 0)
    private String password;

    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_BY", nullable = true, length = 50, precision = 0)
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_TIME", nullable = true, length = 27, precision = 7)
    private Date createdTime;

    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_BY", nullable = true, length = 50, precision = 0)
    private String lastUpdatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_TIME", nullable = true, length = 27, precision = 7)
    private Date lastUpdatedTime;

    @ApiModelProperty(value = "null")
    @Column(name = "role", nullable = true, length = 255, precision = 0)
    private String role;

    @ApiModelProperty(value = "null")
    @Column(name = "JOB_NUMBER", nullable = true, length = 100, precision = 0)
    private String jobNumber;

    @ApiModelProperty(value = "null")
    @Column(name = "EMAIL", nullable = true, length = 200, precision = 0)
    private String email;

    @ApiModelProperty(value = "状态：0启用，1禁用")
    @Column(name = "STATUS", nullable = true, length = 10, precision = 0)
    private Integer status;
    
    
    private String passwordconfirm;
    
    private List<Integer> ids;
    
    /**
     * 已授权角色
     */
    private JSONArray checkedRoles;
    
    /**
     * 已授权用户组
     */
    private JSONArray checkedUserGroups;
    

    /**
     * columnName ID <br/>
     * columnType int identity 10 0 <br/>
     * columnRemarks null <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public Integer getId() {
        return id;
    }

    /**
     * columnName ID <br/>
     * columnType int identity 10 0 <br/>
     * columnRemarks null <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * columnName LOGIN_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * columnName LOGIN_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getName() {
        return name;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * columnName PASSWORD <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPassword() {
        return password;
    }

    /**
     * columnName PASSWORD <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * columnName CREATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * columnName CREATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * columnName CREATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * columnName CREATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * columnName LAST_UPDATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * columnName LAST_UPDATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * columnName LAST_UPDATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * columnName LAST_UPDATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * columnName role <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRole() {
        return role;
    }

    /**
     * columnName role <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * columnName JOB_NUMBER <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * columnName JOB_NUMBER <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEmail() {
        return email;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * columnName STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * columnName STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public JSONArray getCheckedRoles() {
		return checkedRoles;
	}

	public void setCheckedRoles(JSONArray checkedRoles) {
		this.checkedRoles = checkedRoles;
	}

	public JSONArray getCheckedUserGroups() {
		return checkedUserGroups;
	}

	public void setCheckedUserGroups(JSONArray checkedUserGroups) {
		this.checkedUserGroups = checkedUserGroups;
	}
	
}