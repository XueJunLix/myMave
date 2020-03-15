package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PO2GC_WLHEAD
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_WLHEAD null")
public class WlHead {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "WL_NO", nullable = true, length = 50, precision = 0)
    private String wlNo;

    @ApiModelProperty(value = "null")
    @Column(name = "WL_COMPANY", nullable = true, length = 100, precision = 0)
    private String wlCompany;

    @ApiModelProperty(value = "null")
    @Column(name = "KD_NO", nullable = true, length = 50, precision = 0)
    private String kdNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 50, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 500, precision = 0)
    private String shopName;

    @ApiModelProperty(value = "null")
    @Column(name = "TEL", nullable = true, length = 50, precision = 0)
    private String tel;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTACTS", nullable = true, length = 50, precision = 0)
    private String contacts;

    @ApiModelProperty(value = "null")
    @Column(name = "CAR_NO", nullable = true, length = 50, precision = 0)
    private String carNo;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "YJDD_TIME", nullable = true, length = 27, precision = 7)
    private Date yjddTime;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_ADDR", nullable = true, length = 500, precision = 0)
    private String shAddr;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 500, precision = 0)
    private String comments;

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
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_TEL", nullable = true, length = 30, precision = 0)
    private String shopTel;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_CONTACTS", nullable = true, length = 30, precision = 0)
    private String shopContacts;

    @ApiModelProperty(value = "null")
    @Column(name = "PZ_TYPE", nullable = true, length = 30, precision = 0)
    private String pzType;

    @ApiModelProperty(value = "null")
    @Column(name = "EXPRESS_NAME", nullable = true, length = 100, precision = 0)
    private String expressName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "ACTUAL_TIME", nullable = true, length = 27, precision = 7)
    private Date actualTime;

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
     * columnName WL_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getWlNo() {
        return wlNo;
    }

    /**
     * columnName WL_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWlNo(String wlNo) {
        this.wlNo = wlNo;
    }

    /**
     * columnName WL_COMPANY <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getWlCompany() {
        return wlCompany;
    }

    /**
     * columnName WL_COMPANY <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWlCompany(String wlCompany) {
        this.wlCompany = wlCompany;
    }

    /**
     * columnName KD_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getKdNo() {
        return kdNo;
    }

    /**
     * columnName KD_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setKdNo(String kdNo) {
        this.kdNo = kdNo;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * columnName TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTel() {
        return tel;
    }

    /**
     * columnName TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * columnName CONTACTS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * columnName CONTACTS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * columnName CAR_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     * columnName CAR_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    /**
     * columnName YJDD_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getYjddTime() {
        return yjddTime;
    }

    /**
     * columnName YJDD_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setYjddTime(Date yjddTime) {
        this.yjddTime = yjddTime;
    }

    /**
     * columnName SH_ADDR <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShAddr() {
        return shAddr;
    }

    /**
     * columnName SH_ADDR <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShAddr(String shAddr) {
        this.shAddr = shAddr;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComments() {
        return comments;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComments(String comments) {
        this.comments = comments;
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
     * columnName SHOP_TEL <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopTel() {
        return shopTel;
    }

    /**
     * columnName SHOP_TEL <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    /**
     * columnName SHOP_CONTACTS <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopContacts() {
        return shopContacts;
    }

    /**
     * columnName SHOP_CONTACTS <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopContacts(String shopContacts) {
        this.shopContacts = shopContacts;
    }

    /**
     * columnName PZ_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPzType() {
        return pzType;
    }

    /**
     * columnName PZ_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPzType(String pzType) {
        this.pzType = pzType;
    }

    /**
     * columnName EXPRESS_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * columnName EXPRESS_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * columnName ACTUAL_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getActualTime() {
        return actualTime;
    }

    /**
     * columnName ACTUAL_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }
}