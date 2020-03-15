package com.ur.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;

/**
 * TableName SRM_SYS_SERIAL_NUMBER
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SYS_SERIAL_NUMBER null")
public class SysSerialNumber {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 10, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY", nullable = true, length = 30, precision = 0)
    private String category;

    @ApiModelProperty(value = "null")
    @Column(name = "LAST_NUMBER", nullable = true, length = 19, precision = 0)
    private Integer lastNumber;

    @ApiModelProperty(value = "null")
    @Column(name = "INITIAL_NUMBER", nullable = true, length = 19, precision = 0)
    private Integer initialNumber;

    @ApiModelProperty(value = "null")
    @Column(name = "MAX_NUMBER", nullable = true, length = 19, precision = 0)
    private Integer maxNumber;

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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getGroupId() {
        return groupId;
    }


    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getLastNumber() {
        return lastNumber;
    }


    public void setLastNumber(Integer lastNumber) {
        this.lastNumber = lastNumber;
    }


    public Integer getInitialNumber() {
        return initialNumber;
    }


    public void setInitialNumber(Integer initialNumber) {
        this.initialNumber = initialNumber;
    }



    public Integer getMaxNumber() {
        return maxNumber;
    }


    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public Date getCreatedTime() {
        return createdTime;
    }


    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}