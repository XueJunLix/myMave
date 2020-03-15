package com.ur.mro.sup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_SUP_CONTACTS
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SUP_CONTACTS null")
public class SupContacts {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "NAME", nullable = true, length = 110, precision = 0)
    private String name;

    @ApiModelProperty(value = "null")
    @Column(name = "PHONENUMBER", nullable = true, length = 130, precision = 0)
    private String phonenumber;

    @ApiModelProperty(value = "null")
    @Column(name = "TELNUMBER", nullable = true, length = 130, precision = 0)
    private String telnumber;

    @ApiModelProperty(value = "null")
    @Column(name = "FAXNUMBER", nullable = true, length = 130, precision = 0)
    private String faxnumber;

    @ApiModelProperty(value = "null")
    @Column(name = "EMAIL", nullable = true, length = 100, precision = 0)
    private String email;

    @ApiModelProperty(value = "null")
    @Column(name = "ISDEFAULT", nullable = true, length = 1, precision = 0)
    private Boolean isdefault=false;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_ID", nullable = false, length = 19, precision = 0)
    private Integer supplierId;

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
    @Column(name = "DELETED", nullable = true, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "POSITION", nullable = true, length = 50, precision = 0)
    private String position;

    @ApiModelProperty(value = "null")
    @Column(name = "MRLXR", nullable = true, length = 50, precision = 0)
    private Boolean mrLxr=true;

    @ApiModelProperty(value = "null")
    @Column(name = "MRSHLXR", nullable = true, length = 50, precision = 0)
    private Boolean mrShLxr=true;

    @ApiModelProperty(value = "null")
    @Column(name = "MRCWLXR", nullable = true, length = 50, precision = 0)
    private Boolean mrCwLxr=true;

    public Boolean getMrLxr() {
        return this.mrLxr;
    }

    public void setMrLxr(Boolean mrLxr) {
        this.mrLxr = mrLxr;
    }

    public Boolean getMrShLxr() {
        return this.mrShLxr;
    }

    public void setMrShLxr(Boolean mrShLxr) {
        this.mrShLxr = mrShLxr;
    }

    public Boolean getMrCwLxr() {
        return this.mrCwLxr;
    }

    public void setMrCwLxr(Boolean mrCwLxr) {
        this.mrCwLxr = mrCwLxr;
    }

    public Boolean getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

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
     * columnName NAME <br/>
     * columnType nvarchar 110 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getName() {
        return name;
    }

    /**
     * columnName NAME <br/>
     * columnType nvarchar 110 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * columnName PHONENUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * columnName PHONENUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * columnName TELNUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTelnumber() {
        return telnumber;
    }

    /**
     * columnName TELNUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    /**
     * columnName FAXNUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFaxnumber() {
        return faxnumber;
    }

    /**
     * columnName FAXNUMBER <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFaxnumber(String faxnumber) {
        this.faxnumber = faxnumber;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEmail() {
        return email;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * columnName ISDEFAULT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */


    /**
     * columnName SUPPLIER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * columnName SUPPLIER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
     * columnName DELETED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * columnName DELETED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * columnName POSITION <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPosition() {
        return position;
    }

    /**
     * columnName POSITION <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPosition(String position) {
        this.position = position;
    }
}