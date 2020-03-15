package com.ur.admin.menu.model;

import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONArray;

/**
 * TableName ADMIN_MENU_INFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "ADMIN_MENU_INFO null")
public class AdminMenuInfo {
		
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "MENU_CODE", nullable = true, length = 100, precision = 0)
    private String menuCode;

    @ApiModelProperty(value = "null")
    @Column(name = "MENU_NAME", nullable = true, length = 100, precision = 0)
    private String menuName;

    @ApiModelProperty(value = "null")
    @Column(name = "PARENT_MENU_ID", nullable = true, length = 19, precision = 0)
    private Integer parentMenuId;

    @ApiModelProperty(value = "null")
    @Column(name = "MENU_URL", nullable = true, length = 500, precision = 0)
    private String menuUrl;

    @ApiModelProperty(value = "null")
    @Column(name = "MENU_LEVEL", nullable = false, length = 10, precision = 0)
    private Integer menuLevel;

    @ApiModelProperty(value = "状态：1启用，0禁用")
    @Column(name = "STATUS", nullable = false, length = 10, precision = 0)
    private Integer status;

    @ApiModelProperty(value = "null")
    @Column(name = "MENU_DESC", nullable = true, length = 1000, precision = 0)
    private String menuDesc;

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
    
    @ApiModelProperty(value = "顺序")
    @Column(name = "ORDERBY", nullable = false, length = 10, precision = 0)
    private Integer orderBy;

    
    private JSONArray parentMenuItemsShow;
    private String parentMenuNames;
    private JSONArray parentMenus;
    
    /**
     * 	已授权角色
     */
    private JSONArray checkedRoles;
    
    /**
     * 	已授权用户组
     */
    private JSONArray checkedUserGroups;
    
    /**
     * 	已分配按钮
     */
    private JSONArray checkedButtons;
    
    /**
     * 	菜单对应的所有按钮
     */
    private JSONArray allButtons;
    
    
    
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
     * columnName MENU_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * columnName MENU_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * columnName MENU_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * columnName MENU_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * columnName PARENT_MENU_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getParentMenuId() {
        return parentMenuId;
    }

    /**
     * columnName PARENT_MENU_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * columnName MENU_URL <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * columnName MENU_URL <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * columnName MENU_LEVEL <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * columnName MENU_LEVEL <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
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
     * columnName MENU_DESC <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * columnName MENU_DESC <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
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
    
    
    

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public JSONArray getParentMenus() {
		return parentMenus;
	}

	public void setParentMenus(JSONArray parentMenus) {
		this.parentMenus = parentMenus;
	}

	public String getParentMenuNames() {
		return parentMenuNames;
	}

	public void setParentMenuNames(String parentMenuNames) {
		this.parentMenuNames = parentMenuNames;
	}

	public JSONArray getParentMenuItemsShow() {
		return parentMenuItemsShow;
	}

	public void setParentMenuItemsShow(JSONArray parentMenuItemsShow) {
		this.parentMenuItemsShow = parentMenuItemsShow;
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

	public JSONArray getCheckedButtons() {
		return checkedButtons;
	}

	public void setCheckedButtons(JSONArray checkedButtons) {
		this.checkedButtons = checkedButtons;
	}

	public JSONArray getAllButtons() {
		return allButtons;
	}

	public void setAllButtons(JSONArray allButtons) {
		this.allButtons = allButtons;
	}
	
}