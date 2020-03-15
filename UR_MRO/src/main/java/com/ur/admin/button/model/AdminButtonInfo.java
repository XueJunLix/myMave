package com.ur.admin.button.model;

import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONArray;

/**
 * TableName ADMIN_BUTTON
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "ADMIN_BUTTON null")
public class AdminButtonInfo {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_CODE", nullable = false, length = 100, precision = 0)
    private String buttonCode;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_NAME", nullable = false, length = 100, precision = 0)
    private String buttonName;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_CLICK", nullable = true, length = 100, precision = 0)
    private String buttonClick;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_ICON", nullable = true, length = 500, precision = 0)
    private String buttonIcon;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_CLASS", nullable = true, length = 200, precision = 0)
    private String buttonClass;

    @ApiModelProperty(value = "null")
    @Column(name = "BUTTON_STYLE", nullable = true, length = 500, precision = 0)
    private String buttonStyle;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDERBY", nullable = true, length = 19, precision = 0)
    private Integer orderby;

    @ApiModelProperty(value = "null")
    @Column(name = "MEMO", nullable = true, length = 100, precision = 0)
    private String memo;

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

    
    private JSONArray checkedMenus;	//已分配的菜单
    
    
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
     * columnName BUTTON_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getButtonCode() {
        return buttonCode;
    }

    /**
     * columnName BUTTON_CODE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setButtonCode(String buttonCode) {
        this.buttonCode = StringUtils.isEmpty(buttonCode) ? null : buttonCode;
    }

    /**
     * columnName BUTTON_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * columnName BUTTON_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setButtonName(String buttonName) {
        this.buttonName = StringUtils.isEmpty(buttonName) ? null : buttonName;
    }

    /**
     * columnName BUTTON_CLICK <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getButtonClick() {
        return buttonClick;
    }

    /**
     * columnName BUTTON_CLICK <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setButtonClick(String buttonClick) {
        this.buttonClick = buttonClick;
    }

    /**
     * columnName BUTTON_ICON <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getButtonIcon() {
        return buttonIcon;
    }

    /**
     * columnName BUTTON_ICON <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setButtonIcon(String buttonIcon) {
        this.buttonIcon = buttonIcon;
    }

    /**
     * columnName BUTTON_CLASS <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getButtonClass() {
        return buttonClass;
    }

    /**
     * columnName BUTTON_CLASS <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setButtonClass(String buttonClass) {
        this.buttonClass = buttonClass;
    }

    /**
     * columnName BUTTON_STYLE <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getButtonStyle() {
        return buttonStyle;
    }

    /**
     * columnName BUTTON_STYLE <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setButtonStyle(String buttonStyle) {
        this.buttonStyle = buttonStyle;
    }

    /**
     * columnName ORDERBY <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getOrderby() {
        return orderby;
    }

    /**
     * columnName ORDERBY <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
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

	public JSONArray getCheckedMenus() {
		return checkedMenus;
	}

	public void setCheckedMenus(JSONArray checkedMenus) {
		this.checkedMenus = checkedMenus;
	}	
}