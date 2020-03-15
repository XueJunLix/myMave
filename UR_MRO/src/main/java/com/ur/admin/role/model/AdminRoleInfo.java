package com.ur.admin.role.model;

import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONArray;

/**
 * TableName ADMIN_ROLE_INFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "ADMIN_ROLE_INFO null")
public class AdminRoleInfo {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "ROLE_CODE", nullable = true, length = 100, precision = 0)
    private String roleCode;

    @ApiModelProperty(value = "null")
    @Column(name = "ROLE_NAME", nullable = true, length = 200, precision = 0)
    private String roleName;

    @ApiModelProperty(value = "null")
    @Column(name = "MEMO", nullable = true, length = 100, precision = 0)
    private String memo;

    @ApiModelProperty(value = "状态：0启用，1禁用")
    @Column(name = "STATUS", nullable = false, length = 10, precision = 0)
    private Integer status;

    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_BY", nullable = false, length = 50, precision = 0)
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_TIME", nullable = false, length = 27, precision = 7)
    private Date createdTime;

    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_BY", nullable = false, length = 50, precision = 0)
    private String lastUpdatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_TIME", nullable = false, length = 27, precision = 7)
    private Date lastUpdatedTime;
    
    private JSONArray currUserArray;	//当前用户组对应的用户

    /**
     * 	已分配菜单
     */
    private JSONArray checkedMenus;
    
    /**
     * 	已分配按钮
     */
    private JSONArray checkedButtons;
    
    /**
     * columnName ID <br/>
     * columnType bigint identity 19 0 <br/>
     * columnRemarks null <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public Integer getId() {
        return id;
    }

    /**
     * columnName ID <br/>
     * columnType bigint identity 19 0 <br/>
     * columnRemarks null <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * columnName ROLE_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * columnName ROLE_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * columnName ROLE_NAME <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * columnName ROLE_NAME <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * columnName MEMO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMemo() {
        return memo;
    }

    /**
     * columnName MEMO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * columnName STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * columnName STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * columnName CREATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * columnName CREATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = StringUtils.isEmpty(createdBy) ? null : createdBy;
    }

    /**
     * columnName CREATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * columnName CREATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * columnName LAST_UPDATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * columnName LAST_UPDATED_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = StringUtils.isEmpty(lastUpdatedBy) ? null : lastUpdatedBy;
    }

    /**
     * columnName LAST_UPDATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * columnName LAST_UPDATED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

	public JSONArray getCurrUserArray() {
		return currUserArray;
	}

	public void setCurrUserArray(JSONArray currUserArray) {
		this.currUserArray = currUserArray;
	}

	public JSONArray getCheckedMenus() {
		return checkedMenus;
	}

	public void setCheckedMenus(JSONArray checkedMenus) {
		this.checkedMenus = checkedMenus;
	}

	public JSONArray getCheckedButtons() {
		return checkedButtons;
	}

	public void setCheckedButtons(JSONArray checkedButtons) {
		this.checkedButtons = checkedButtons;
	}
}