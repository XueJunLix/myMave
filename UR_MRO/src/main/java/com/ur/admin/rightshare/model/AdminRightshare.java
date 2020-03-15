package com.ur.admin.rightshare.model;

import javax.persistence.Column;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TableName ADMIN_RIGHTSHARE
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "ADMIN_RIGHTSHARE null")
public class AdminRightshare {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "RIGHT_TYPE", nullable = false, length = 10, precision = 0)
    private String rightType;

    @ApiModelProperty(value = "null")
    @Column(name = "RIGHT_SOURCE_ID", nullable = false, length = 10, precision = 0)
    private Integer rightSourceId;

    @ApiModelProperty(value = "null")
    @Column(name = "RESOURCE_TYPE", nullable = false, length = 10, precision = 0)
    private String resourceType;

    @ApiModelProperty(value = "null")
    @Column(name = "RESOURCE_ID", nullable = false, length = 10, precision = 0)
    private Integer resourceId;

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
     * columnName RIGHT_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getRightType() {
        return rightType;
    }

    /**
     * columnName RIGHT_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setRightType(String rightType) {
        this.rightType = StringUtils.isEmpty(rightType) ? null : rightType;
    }

    /**
     * columnName RIGHT_SOUTCE_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getRightSourceId() {
        return rightSourceId;
    }

    /**
     * columnName RIGHT_SOUTCE_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setRightSourceId(Integer rightSoutceId) {
        this.rightSourceId = rightSoutceId;
    }

    /**
     * columnName RESOURCE_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * columnName RESOURCE_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setResourceType(String resourceType) {
        this.resourceType = StringUtils.isEmpty(resourceType) ? null : resourceType;
    }

    /**
     * columnName RESOURCE_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * columnName RESOURCE_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}