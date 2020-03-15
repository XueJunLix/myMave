package com.ur.mro.dic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_SYS_DICTIONARY
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SYS_DICTIONARY null")
public class Dictionary {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 20, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "SGROUP", nullable = false, length = 20, precision = 0)
    private String sgroup;

    @ApiModelProperty(value = "null")
    @Column(name = "SKEY", nullable = false, length = 20, precision = 0)
    private String skey;

    @ApiModelProperty(value = "null")
    @Column(name = "SVALUE", nullable = true, length = 200, precision = 0)
    private String svalue;

    @ApiModelProperty(value = "null")
    @Column(name = "ACTIVE", nullable = true, length = 5, precision = 0)
    private String active;

    @ApiModelProperty(value = "null")
    @Column(name = "PARENT_ID", nullable = true, length = 19, precision = 0)
    private Integer parentId;

    @ApiModelProperty(value = "null")
    @Column(name = "DESCRIPTION", nullable = true, length = 255, precision = 0)
    private String description;

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
    @Column(name = "SCOM1", nullable = true, length = 100, precision = 0)
    private String scom1;

    @ApiModelProperty(value = "null")
    @Column(name = "SCOM2", nullable = true, length = 100, precision = 0)
    private String scom2;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "SORT", nullable = true, length = 10, precision = 0)
    private Integer sort;

    @ApiModelProperty(value = "null")
    @Column(name = "SCOM3", nullable = true, length = 100, precision = 0)
    private String scom3;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_DESCIPTION", nullable = true, length = 255, precision = 0)
    private String groupDesciption;

    @ApiModelProperty(value = "null")
    @Column(name = "SGROUP_NAME", nullable = true, length = 50, precision = 0)
    private String sgroupName;

    @ApiModelProperty(value = "null")
    @Column(name = "LEAF_NODE", nullable = false, length = 1, precision = 0)
    private Integer leafNode;

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
     * columnName GROUP_ID <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * columnName GROUP_ID <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * columnName SGROUP <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getSgroup() {
        return sgroup;
    }

    /**
     * columnName SGROUP <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setSgroup(String sgroup) {
        this.sgroup = StringUtils.isEmpty(sgroup) ? null : sgroup;
    }

    /**
     * columnName SKEY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getSkey() {
        return skey;
    }

    /**
     * columnName SKEY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setSkey(String skey) {
        this.skey = StringUtils.isEmpty(skey) ? null : skey;
    }

    /**
     * columnName SVALUE <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSvalue() {
        return svalue;
    }

    /**
     * columnName SVALUE <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    /**
     * columnName ACTIVE <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getActive() {
        return active;
    }

    /**
     * columnName ACTIVE <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * columnName PARENT_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * columnName PARENT_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * columnName DESCRIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDescription() {
        return description;
    }

    /**
     * columnName DESCRIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDescription(String description) {
        this.description = description;
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
     * columnName SCOM1 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getScom1() {
        return scom1;
    }

    /**
     * columnName SCOM1 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setScom1(String scom1) {
        this.scom1 = scom1;
    }

    /**
     * columnName SCOM2 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getScom2() {
        return scom2;
    }

    /**
     * columnName SCOM2 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setScom2(String scom2) {
        this.scom2 = scom2;
    }

    /**
     * columnName DELETED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * columnName DELETED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * columnName SORT <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * columnName SORT <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * columnName SCOM3 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getScom3() {
        return scom3;
    }

    /**
     * columnName SCOM3 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setScom3(String scom3) {
        this.scom3 = scom3;
    }

    /**
     * columnName GROUP_DESCIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGroupDesciption() {
        return groupDesciption;
    }

    /**
     * columnName GROUP_DESCIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGroupDesciption(String groupDesciption) {
        this.groupDesciption = groupDesciption;
    }

    /**
     * columnName SGROUP_NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSgroupName() {
        return sgroupName;
    }

    /**
     * columnName SGROUP_NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSgroupName(String sgroupName) {
        this.sgroupName = sgroupName;
    }

    /**
     * columnName LEAF_NODE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getLeafNode() {
        return leafNode;
    }

    /**
     * columnName LEAF_NODE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setLeafNode(Integer leafNode) {
        this.leafNode = leafNode;
    }
}