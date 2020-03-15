package com.ur.mro.mat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_MAT_SOURCELIST
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_MAT_SOURCELIST null")
public class Sourcelist {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

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

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "DETAULTED", nullable = true, length = 255, precision = 0)
    private String detaulted;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_CAPACITY", nullable = true, length = 100, precision = 0)
    private String supplierCapacity;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_CODE", nullable = true, length = 20, precision = 0)
    private String supplierCode;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_LEVEL", nullable = true, length = 10, precision = 0)
    private String supplierLevel;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_NAME", nullable = true, length = 100, precision = 0)
    private String supplierName;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_PCODE", nullable = true, length = 100, precision = 0)
    private String supplierPcode;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_PCOLOR", nullable = true, length = 40, precision = 0)
    private String supplierPcolor;

    @ApiModelProperty(value = "null")
    @Column(name = "TYPE", nullable = true, length = 4, precision = 0)
    private String type;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_ID", nullable = true, length = 19, precision = 0)
    private Integer materialId;

    @ApiModelProperty(value = "null")
    @Column(name = "PANTONE_COLOR", nullable = true, length = 20, precision = 0)
    private String pantoneColor;

    @ApiModelProperty(value = "null")
    @Column(name = "ZT_CODE", nullable = true, length = 20, precision = 0)
    private String ztCode;

    @ApiModelProperty(value = "null")
    @Column(name = "REMARKS", nullable = true, length = 255, precision = 0)
    private String remarks;

    @ApiModelProperty(value = "null")
    @Column(name = "MIN_ORDER_COUNT", nullable = true, length = 18, precision = 2)
    private String minOrderCount;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_TIME", nullable = true, length = 10, precision = 0)
    private Integer deliveryTime;

    @ApiModelProperty(value = "null")
    @Column(name = "UNIT", nullable = true, length = 10, precision = 0)
    private String unit;

    @ApiModelProperty(value = "null")
    @Column(name = "FREEZE", nullable = true, length = 50, precision = 0)
    private String freeze;

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
     * columnName DETAULTED <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDetaulted() {
        return detaulted;
    }

    /**
     * columnName DETAULTED <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDetaulted(String detaulted) {
        this.detaulted = detaulted;
    }

    /**
     * columnName SUPPLIER_CAPACITY <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierCapacity() {
        return supplierCapacity;
    }

    /**
     * columnName SUPPLIER_CAPACITY <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierCapacity(String supplierCapacity) {
        this.supplierCapacity = supplierCapacity;
    }

    /**
     * columnName SUPPLIER_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * columnName SUPPLIER_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * columnName SUPPLIER_LEVEL <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierLevel() {
        return supplierLevel;
    }

    /**
     * columnName SUPPLIER_LEVEL <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierLevel(String supplierLevel) {
        this.supplierLevel = supplierLevel;
    }

    /**
     * columnName SUPPLIER_NAME <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * columnName SUPPLIER_NAME <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * columnName SUPPLIER_PCODE <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierPcode() {
        return supplierPcode;
    }

    /**
     * columnName SUPPLIER_PCODE <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierPcode(String supplierPcode) {
        this.supplierPcode = supplierPcode;
    }

    /**
     * columnName SUPPLIER_PCOLOR <br/>
     * columnType nvarchar 40 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierPcolor() {
        return supplierPcolor;
    }

    /**
     * columnName SUPPLIER_PCOLOR <br/>
     * columnType nvarchar 40 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierPcolor(String supplierPcolor) {
        this.supplierPcolor = supplierPcolor;
    }

    /**
     * columnName TYPE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getType() {
        return type;
    }

    /**
     * columnName TYPE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * columnName MATERIAL_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**
     * columnName MATERIAL_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    /**
     * columnName PANTONE_COLOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPantoneColor() {
        return pantoneColor;
    }

    /**
     * columnName PANTONE_COLOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPantoneColor(String pantoneColor) {
        this.pantoneColor = pantoneColor;
    }

    /**
     * columnName ZT_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZtCode() {
        return ztCode;
    }

    /**
     * columnName ZT_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZtCode(String ztCode) {
        this.ztCode = ztCode;
    }

    /**
     * columnName REMARKS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * columnName REMARKS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * columnName MIN_ORDER_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMinOrderCount() {
        return minOrderCount;
    }

    /**
     * columnName MIN_ORDER_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMinOrderCount(String minOrderCount) {
        this.minOrderCount = minOrderCount;
    }

    /**
     * columnName DELIVERY_TIME <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * columnName DELIVERY_TIME <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * columnName UNIT <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getUnit() {
        return unit;
    }

    /**
     * columnName UNIT <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * columnName FREEZE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFreeze() {
        return freeze;
    }

    /**
     * columnName FREEZE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFreeze(String freeze) {
        this.freeze = freeze;
    }
}