package com.ur.mro.dic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import java.util.Date;


public class DictionaryItem {
    private Integer id;

    private String groupId;

    private String sgroup;

    private String skey;

    private String svalue;

    private Boolean active;

    private Integer parentId;

    private String description;

    private String createdBy;

    private Date createdTime;

    private String lastUpdatedBy;

    private Date lastUpdatedTime;

    private String scom1;

    private String scom2;

    private Integer deleted;

    private Integer sort;

    private String scom3;

    private String groupDesciption;

    private String sgroupName;

    private Boolean leafNode;



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



    public String getSkey() {
        return skey;
    }


    public void setSkey(String skey) {
        this.skey = StringUtils.isEmpty(skey) ? null : skey;
    }


    public String getSvalue() {
        return svalue;
    }


    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }


    public Integer getParentId() {
        return parentId;
    }


    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
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


    public String getScom1() {
        return scom1;
    }

    public void setScom1(String scom1) {
        this.scom1 = scom1;
    }


    public String getScom2() {
        return scom2;
    }


    public void setScom2(String scom2) {
        this.scom2 = scom2;
    }


    public Integer getDeleted() {
        return deleted;
    }


    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getSort() {
        return sort;
    }


    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getScom3() {
        return scom3;
    }


    public void setScom3(String scom3) {
        this.scom3 = scom3;
    }

    public String getSgroup() {
        return this.sgroup;
    }

    public void setSgroup(String sgroup) {
        this.sgroup = sgroup;
    }

    public String getGroupDesciption() {
        return this.groupDesciption;
    }

    public void setGroupDesciption(String groupDesciption) {
        this.groupDesciption = groupDesciption;
    }

    public String getSgroupName() {
        return this.sgroupName;
    }

    public void setSgroupName(String sgroupName) {
        this.sgroupName = sgroupName;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getLeafNode() {
        return this.leafNode;
    }

    public void setLeafNode(Boolean leafNode) {
        this.leafNode = leafNode;
    }
}