package com.ur.mro.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PUR_ORDER_INFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PUR_ORDER_INFO null")
public class OrderInfo {
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
    @Column(name = "APPLY_ORDER_NO", nullable = true, length = 255, precision = 0)
    private String applyOrderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "BASE_UNIT", nullable = true, length = 255, precision = 0)
    private String baseUnit;

    @ApiModelProperty(value = "null")
    @Column(name = "BASE_UNIT_COUNT", nullable = true, length = 53, precision = 0)
    private String baseUnitCount;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 255, precision = 0)
    private String comments;

    @ApiModelProperty(value = "null")
    @Column(name = "CONFIRM_SAMPLE", nullable = true, length = 255, precision = 0)
    private String confirmSample;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_DATE", nullable = true, length = 27, precision = 7)
    private Date deliveryDate;

    @ApiModelProperty(value = "null")
    @Column(name = "DESIGN_NO", nullable = true, length = 255, precision = 0)
    private String designNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CODE", nullable = true, length = 255, precision = 0)
    private String matCode;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_COLOR", nullable = true, length = 255, precision = 0)
    private String matColor;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_COLOR_NO", nullable = true, length = 255, precision = 0)
    private String matColorNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_NAME", nullable = true, length = 255, precision = 0)
    private String matName;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_SPEC", nullable = true, length = 255, precision = 0)
    private String matSpec;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_TYPE", nullable = true, length = 255, precision = 0)
    private String matType;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_USE", nullable = true, length = 255, precision = 0)
    private String matUse;

    @ApiModelProperty(value = "null")
    @Column(name = "MODULE_NO", nullable = true, length = 255, precision = 0)
    private String moduleNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PANTONE_COLOR", nullable = true, length = 255, precision = 0)
    private String pantoneColor;

    @ApiModelProperty(value = "null")
    @Column(name = "PPS_ORDER_NO", nullable = true, length = 255, precision = 0)
    private String ppsOrderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_AMOUNT", nullable = true, length = 53, precision = 0)
    private String purchaseAmount;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_COUNT", nullable = true, length = 53, precision = 0)
    private String purchaseCount;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_UNIT", nullable = true, length = 255, precision = 0)
    private String purchaseUnit;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_UNIT_PRICE", nullable = true, length = 53, precision = 0)
    private String purchaseUnitPrice;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVE_STATUS", nullable = true, length = 10, precision = 0)
    private Integer receiveStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "ROW_ID", nullable = true, length = 10, precision = 0)
    private Integer rowId;

    @ApiModelProperty(value = "null")
    @Column(name = "STORE_ID", nullable = true, length = 255, precision = 0)
    private String storeId;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_PCODE", nullable = true, length = 255, precision = 0)
    private String supplierPcode;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLY_SAMPLE", nullable = true, length = 255, precision = 0)
    private String supplySample;

    @ApiModelProperty(value = "null")
    @Column(name = "TAKE_MAT_STATUS", nullable = true, length = 10, precision = 0)
    private Integer takeMatStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "TAX_RATE", nullable = true, length = 10, precision = 0)
    private String taxRate;

    @ApiModelProperty(value = "null")
    @Column(name = "TECH_CODE", nullable = true, length = 255, precision = 0)
    private String techCode;

    @ApiModelProperty(value = "null")
    @Column(name = "TECH_NAME", nullable = true, length = 255, precision = 0)
    private String techName;

    @ApiModelProperty(value = "null")
    @Column(name = "UNIT_COEFFICIENT", nullable = true, length = 53, precision = 0)
    private String unitCoefficient;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_ID", nullable = false, length = 19, precision = 0)
    private Integer orderId;

    @ApiModelProperty(value = "null")
    @Column(name = "GIRARD_NAME", nullable = true, length = 255, precision = 0)
    private String girardName;

    @ApiModelProperty(value = "null")
    @Column(name = "DEMAND_ORDER_NO", nullable = true, length = 255, precision = 0)
    private String demandOrderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "M_ID", nullable = true, length = 255, precision = 0)
    private String mId;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_COLOR_NO", nullable = true, length = 255, precision = 0)
    private String supplierColorNo;

    @ApiModelProperty(value = "null")
    @Column(name = "M_ROW_ID", nullable = true, length = 50, precision = 0)
    private String mRowId;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_COUNT", nullable = true, length = 18, precision = 2)
    private String applyCount;

    @ApiModelProperty(value = "null")
    @Column(name = "COMPONENT", nullable = true, length = 100, precision = 0)
    private String component;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "RETURN_DATE", nullable = true, length = 23, precision = 3)
    private Date returnDate;

    @ApiModelProperty(value = "null")
    @Column(name = "WASHING_SHRINKAGE", nullable = true, length = 10, precision = 2)
    private String washingShrinkage;

    @ApiModelProperty(value = "null")
    @Column(name = "DESIGNER", nullable = true, length = 50, precision = 0)
    private String designer;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_COUNT", nullable = true, length = 18, precision = 2)
    private String deliveryCount;

    @ApiModelProperty(value = "null")
    @Column(name = "ZJ_COUNT", nullable = true, length = 18, precision = 2)
    private String zjCount;

    @ApiModelProperty(value = "null")
    @Column(name = "ZJ_RESULT", nullable = true, length = 30, precision = 0)
    private String zjResult;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "ZJ_TIME", nullable = true, length = 23, precision = 3)
    private Date zjTime;

    @ApiModelProperty(value = "null")
    @Column(name = "SL_STATUS", nullable = true, length = 1, precision = 0)
    private Integer slStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_AMOUNT", nullable = true, length = 18, precision = 2)
    private String shAmount;

    @ApiModelProperty(value = "null")
    @Column(name = "DEVELOP_MAT_NO", nullable = true, length = 30, precision = 0)
    private String developMatNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MCODE", nullable = true, length = 20, precision = 0)
    private String mcode;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "CONTRACT_DELIVERYDATE", nullable = true, length = 10, precision = 0)
    private Date contractDeliverydate;

    @ApiModelProperty(value = "null")
    @Column(name = "STANDARD_COLOR_YN", nullable = true, length = 1, precision = 0)
    private Integer standardColorYn;

    @ApiModelProperty(value = "null")
    @Column(name = "STANDARD_COLOR", nullable = true, length = 20, precision = 0)
    private String standardColor;

    @ApiModelProperty(value = "null")
    @Column(name = "PUR_ORDER_LD", nullable = true, length = 20, precision = 0)
    private String purOrderLd;

    @ApiModelProperty(value = "null")
    @Column(name = "PUR_ORDER_LD_NO", nullable = true, length = 20, precision = 0)
    private String purOrderLdNo;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "EXPECTED_DELIVERY", nullable = true, length = 23, precision = 3)
    private Date expectedDelivery;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 30, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 30, precision = 0)
    private String shopName;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_C", nullable = true, length = 30, precision = 0)
    private String categoryC;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_A", nullable = true, length = 30, precision = 0)
    private String categoryA;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_B", nullable = true, length = 30, precision = 0)
    private String categoryB;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_QUALITY", nullable = true, length = 50, precision = 0)
    private String materialQuality;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESS_TECHNOLOGY", nullable = true, length = 255, precision = 0)
    private String processTechnology;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_BY", nullable = true, length = 30, precision = 0)
    private String receiverBy;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_ADDRESS", nullable = true, length = 255, precision = 0)
    private String receiverAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "ECEIVER_BY_TELEPHONE", nullable = true, length = 30, precision = 0)
    private String eceiverByTelephone;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "MAKE_FINISH_TIME", nullable = true, length = 27, precision = 7)
    private Date makeFinishTime;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_BY_TELEPHONE", nullable = true, length = 30, precision = 0)
    private String receiverByTelephone;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_USE", nullable = true, length = 30, precision = 0)
    private String isUse;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_GOODS_COUNT", nullable = true, length = 30, precision = 0)
    private String supplierGoodsCount;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_ACTUAL_COUNT", nullable = true, length = 53, precision = 0)
    private String purchaseActualCount;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_ACTUAL_AMOUNT", nullable = true, length = 53, precision = 0)
    private String purchaseActualAmount;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_GCSHHEAD_FINISH", nullable = true, length = 1, precision = 0)
    private Integer isGcshheadFinish;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_WL_TO_SHOP_FINISH", nullable = true, length = 1, precision = 0)
    private Integer isWlToShopFinish;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_GCDELIVERY_FINISH", nullable = true, length = 1, precision = 0)
    private Integer isGcdeliveryFinish;

    @ApiModelProperty(value = "null")
    @Column(name = "WARRANTY", nullable = true, length = 10, precision = 0)
    private Integer warranty;

    @ApiModelProperty(value = "null")
    @Column(name = "STOCK_ORDER_NO", nullable = true, length = 255, precision = 0)
    private String stockOrderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SYSL", nullable = true, length = 10, precision = 2)
    private String sysl;

    @ApiModelProperty(value = "null")
    @Column(name = "PR_ROW_ID", nullable = true, length = 50, precision = 0)
    private String prRowId;

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
     * columnName APPLY_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyOrderNo() {
        return applyOrderNo;
    }

    /**
     * columnName APPLY_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyOrderNo(String applyOrderNo) {
        this.applyOrderNo = applyOrderNo;
    }

    /**
     * columnName BASE_UNIT <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBaseUnit() {
        return baseUnit;
    }

    /**
     * columnName BASE_UNIT <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    /**
     * columnName BASE_UNIT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBaseUnitCount() {
        return baseUnitCount;
    }

    /**
     * columnName BASE_UNIT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBaseUnitCount(String baseUnitCount) {
        this.baseUnitCount = baseUnitCount;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComments() {
        return comments;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * columnName CONFIRM_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getConfirmSample() {
        return confirmSample;
    }

    /**
     * columnName CONFIRM_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setConfirmSample(String confirmSample) {
        this.confirmSample = confirmSample;
    }

    /**
     * columnName DELIVERY_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * columnName DELIVERY_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * columnName DESIGN_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDesignNo() {
        return designNo;
    }

    /**
     * columnName DESIGN_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDesignNo(String designNo) {
        this.designNo = designNo;
    }

    /**
     * columnName MAT_CODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatCode() {
        return matCode;
    }

    /**
     * columnName MAT_CODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    /**
     * columnName MAT_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatColor() {
        return matColor;
    }

    /**
     * columnName MAT_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatColor(String matColor) {
        this.matColor = matColor;
    }

    /**
     * columnName MAT_COLOR_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatColorNo() {
        return matColorNo;
    }

    /**
     * columnName MAT_COLOR_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatColorNo(String matColorNo) {
        this.matColorNo = matColorNo;
    }

    /**
     * columnName MAT_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatName() {
        return matName;
    }

    /**
     * columnName MAT_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatName(String matName) {
        this.matName = matName;
    }

    /**
     * columnName MAT_SPEC <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatSpec() {
        return matSpec;
    }

    /**
     * columnName MAT_SPEC <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    /**
     * columnName MAT_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatType() {
        return matType;
    }

    /**
     * columnName MAT_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatType(String matType) {
        this.matType = matType;
    }

    /**
     * columnName MAT_USE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatUse() {
        return matUse;
    }

    /**
     * columnName MAT_USE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatUse(String matUse) {
        this.matUse = matUse;
    }

    /**
     * columnName MODULE_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getModuleNo() {
        return moduleNo;
    }

    /**
     * columnName MODULE_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * columnName PANTONE_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPantoneColor() {
        return pantoneColor;
    }

    /**
     * columnName PANTONE_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPantoneColor(String pantoneColor) {
        this.pantoneColor = pantoneColor;
    }

    /**
     * columnName PPS_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPpsOrderNo() {
        return ppsOrderNo;
    }

    /**
     * columnName PPS_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPpsOrderNo(String ppsOrderNo) {
        this.ppsOrderNo = ppsOrderNo;
    }

    /**
     * columnName PURCHASE_AMOUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * columnName PURCHASE_AMOUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    /**
     * columnName PURCHASE_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseCount() {
        return purchaseCount;
    }

    /**
     * columnName PURCHASE_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseCount(String purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    /**
     * columnName PURCHASE_UNIT <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    /**
     * columnName PURCHASE_UNIT <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    /**
     * columnName PURCHASE_UNIT_PRICE <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    /**
     * columnName PURCHASE_UNIT_PRICE <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseUnitPrice(String purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    /**
     * columnName RECEIVE_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    /**
     * columnName RECEIVE_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    /**
     * columnName ROW_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getRowId() {
        return rowId;
    }

    /**
     * columnName ROW_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    /**
     * columnName STORE_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * columnName STORE_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * columnName SUPPLIER_PCODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierPcode() {
        return supplierPcode;
    }

    /**
     * columnName SUPPLIER_PCODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierPcode(String supplierPcode) {
        this.supplierPcode = supplierPcode;
    }

    /**
     * columnName SUPPLY_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplySample() {
        return supplySample;
    }

    /**
     * columnName SUPPLY_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplySample(String supplySample) {
        this.supplySample = supplySample;
    }

    /**
     * columnName TAKE_MAT_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getTakeMatStatus() {
        return takeMatStatus;
    }

    /**
     * columnName TAKE_MAT_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTakeMatStatus(Integer takeMatStatus) {
        this.takeMatStatus = takeMatStatus;
    }

    /**
     * columnName TAX_RATE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTaxRate() {
        return taxRate;
    }

    /**
     * columnName TAX_RATE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * columnName TECH_CODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTechCode() {
        return techCode;
    }

    /**
     * columnName TECH_CODE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTechCode(String techCode) {
        this.techCode = techCode;
    }

    /**
     * columnName TECH_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTechName() {
        return techName;
    }

    /**
     * columnName TECH_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTechName(String techName) {
        this.techName = techName;
    }

    /**
     * columnName UNIT_COEFFICIENT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getUnitCoefficient() {
        return unitCoefficient;
    }

    /**
     * columnName UNIT_COEFFICIENT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setUnitCoefficient(String unitCoefficient) {
        this.unitCoefficient = unitCoefficient;
    }

    /**
     * columnName ORDER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * columnName ORDER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * columnName GIRARD_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGirardName() {
        return girardName;
    }

    /**
     * columnName GIRARD_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGirardName(String girardName) {
        this.girardName = girardName;
    }

    /**
     * columnName DEMAND_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDemandOrderNo() {
        return demandOrderNo;
    }

    /**
     * columnName DEMAND_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDemandOrderNo(String demandOrderNo) {
        this.demandOrderNo = demandOrderNo;
    }

    /**
     * columnName M_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getmId() {
        return mId;
    }

    /**
     * columnName M_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setmId(String mId) {
        this.mId = mId;
    }

    /**
     * columnName SUPPLIER_COLOR_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierColorNo() {
        return supplierColorNo;
    }

    /**
     * columnName SUPPLIER_COLOR_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierColorNo(String supplierColorNo) {
        this.supplierColorNo = supplierColorNo;
    }

    /**
     * columnName M_ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getmRowId() {
        return mRowId;
    }

    /**
     * columnName M_ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setmRowId(String mRowId) {
        this.mRowId = mRowId;
    }

    /**
     * columnName APPLY_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyCount() {
        return applyCount;
    }

    /**
     * columnName APPLY_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyCount(String applyCount) {
        this.applyCount = applyCount;
    }

    /**
     * columnName COMPONENT <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComponent() {
        return component;
    }

    /**
     * columnName COMPONENT <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * columnName RETURN_DATE <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * columnName RETURN_DATE <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * columnName WASHING_SHRINKAGE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getWashingShrinkage() {
        return washingShrinkage;
    }

    /**
     * columnName WASHING_SHRINKAGE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWashingShrinkage(String washingShrinkage) {
        this.washingShrinkage = washingShrinkage;
    }

    /**
     * columnName DESIGNER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * columnName DESIGNER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * columnName DELIVERY_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDeliveryCount() {
        return deliveryCount;
    }

    /**
     * columnName DELIVERY_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryCount(String deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    /**
     * columnName ZJ_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZjCount() {
        return zjCount;
    }

    /**
     * columnName ZJ_COUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZjCount(String zjCount) {
        this.zjCount = zjCount;
    }

    /**
     * columnName ZJ_RESULT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZjResult() {
        return zjResult;
    }

    /**
     * columnName ZJ_RESULT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZjResult(String zjResult) {
        this.zjResult = zjResult;
    }

    /**
     * columnName ZJ_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getZjTime() {
        return zjTime;
    }

    /**
     * columnName ZJ_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZjTime(Date zjTime) {
        this.zjTime = zjTime;
    }

    /**
     * columnName SL_STATUS <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getSlStatus() {
        return slStatus;
    }

    /**
     * columnName SL_STATUS <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSlStatus(Integer slStatus) {
        this.slStatus = slStatus;
    }

    /**
     * columnName SH_AMOUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShAmount() {
        return shAmount;
    }

    /**
     * columnName SH_AMOUNT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShAmount(String shAmount) {
        this.shAmount = shAmount;
    }

    /**
     * columnName DEVELOP_MAT_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDevelopMatNo() {
        return developMatNo;
    }

    /**
     * columnName DEVELOP_MAT_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDevelopMatNo(String developMatNo) {
        this.developMatNo = developMatNo;
    }

    /**
     * columnName MCODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMcode() {
        return mcode;
    }

    /**
     * columnName MCODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    /**
     * columnName CONTRACT_DELIVERYDATE <br/>
     * columnType TIMESTAMP 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getContractDeliverydate() {
        return contractDeliverydate;
    }

    /**
     * columnName CONTRACT_DELIVERYDATE <br/>
     * columnType TIMESTAMP 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContractDeliverydate(Date contractDeliverydate) {
        this.contractDeliverydate = contractDeliverydate;
    }

    /**
     * columnName STANDARD_COLOR_YN <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getStandardColorYn() {
        return standardColorYn;
    }

    /**
     * columnName STANDARD_COLOR_YN <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStandardColorYn(Integer standardColorYn) {
        this.standardColorYn = standardColorYn;
    }

    /**
     * columnName STANDARD_COLOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStandardColor() {
        return standardColor;
    }

    /**
     * columnName STANDARD_COLOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStandardColor(String standardColor) {
        this.standardColor = standardColor;
    }

    /**
     * columnName PUR_ORDER_LD <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurOrderLd() {
        return purOrderLd;
    }

    /**
     * columnName PUR_ORDER_LD <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurOrderLd(String purOrderLd) {
        this.purOrderLd = purOrderLd;
    }

    /**
     * columnName PUR_ORDER_LD_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurOrderLdNo() {
        return purOrderLdNo;
    }

    /**
     * columnName PUR_ORDER_LD_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurOrderLdNo(String purOrderLdNo) {
        this.purOrderLdNo = purOrderLdNo;
    }

    /**
     * columnName EXPECTED_DELIVERY <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    /**
     * columnName EXPECTED_DELIVERY <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * columnName CATEGORY_C <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryC() {
        return categoryC;
    }

    /**
     * columnName CATEGORY_C <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryC(String categoryC) {
        this.categoryC = categoryC;
    }

    /**
     * columnName CATEGORY_A <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryA() {
        return categoryA;
    }

    /**
     * columnName CATEGORY_A <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryA(String categoryA) {
        this.categoryA = categoryA;
    }

    /**
     * columnName CATEGORY_B <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryB() {
        return categoryB;
    }

    /**
     * columnName CATEGORY_B <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryB(String categoryB) {
        this.categoryB = categoryB;
    }

    /**
     * columnName MATERIAL_QUALITY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMaterialQuality() {
        return materialQuality;
    }

    /**
     * columnName MATERIAL_QUALITY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMaterialQuality(String materialQuality) {
        this.materialQuality = materialQuality;
    }

    /**
     * columnName PROCESS_TECHNOLOGY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProcessTechnology() {
        return processTechnology;
    }

    /**
     * columnName PROCESS_TECHNOLOGY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProcessTechnology(String processTechnology) {
        this.processTechnology = processTechnology;
    }

    /**
     * columnName RECEIVER_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiverBy() {
        return receiverBy;
    }

    /**
     * columnName RECEIVER_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiverBy(String receiverBy) {
        this.receiverBy = receiverBy;
    }

    /**
     * columnName RECEIVER_ADDRESS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * columnName RECEIVER_ADDRESS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * columnName ECEIVER_BY_TELEPHONE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEceiverByTelephone() {
        return eceiverByTelephone;
    }

    /**
     * columnName ECEIVER_BY_TELEPHONE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEceiverByTelephone(String eceiverByTelephone) {
        this.eceiverByTelephone = eceiverByTelephone;
    }

    /**
     * columnName MAKE_FINISH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getMakeFinishTime() {
        return makeFinishTime;
    }

    /**
     * columnName MAKE_FINISH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMakeFinishTime(Date makeFinishTime) {
        this.makeFinishTime = makeFinishTime;
    }

    /**
     * columnName RECEIVER_BY_TELEPHONE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiverByTelephone() {
        return receiverByTelephone;
    }

    /**
     * columnName RECEIVER_BY_TELEPHONE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiverByTelephone(String receiverByTelephone) {
        this.receiverByTelephone = receiverByTelephone;
    }

    /**
     * columnName IS_USE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * columnName IS_USE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    /**
     * columnName SUPPLIER_GOODS_COUNT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierGoodsCount() {
        return supplierGoodsCount;
    }

    /**
     * columnName SUPPLIER_GOODS_COUNT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierGoodsCount(String supplierGoodsCount) {
        this.supplierGoodsCount = supplierGoodsCount;
    }

    /**
     * columnName PURCHASE_ACTUAL_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseActualCount() {
        return purchaseActualCount;
    }

    /**
     * columnName PURCHASE_ACTUAL_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseActualCount(String purchaseActualCount) {
        this.purchaseActualCount = purchaseActualCount;
    }

    /**
     * columnName PURCHASE_ACTUAL_AMOUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseActualAmount() {
        return purchaseActualAmount;
    }

    /**
     * columnName PURCHASE_ACTUAL_AMOUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseActualAmount(String purchaseActualAmount) {
        this.purchaseActualAmount = purchaseActualAmount;
    }

    /**
     * columnName IS_GCSHHEAD_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsGcshheadFinish() {
        return isGcshheadFinish;
    }

    /**
     * columnName IS_GCSHHEAD_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsGcshheadFinish(Integer isGcshheadFinish) {
        this.isGcshheadFinish = isGcshheadFinish;
    }

    /**
     * columnName IS_WL_TO_SHOP_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsWlToShopFinish() {
        return isWlToShopFinish;
    }

    /**
     * columnName IS_WL_TO_SHOP_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsWlToShopFinish(Integer isWlToShopFinish) {
        this.isWlToShopFinish = isWlToShopFinish;
    }

    /**
     * columnName IS_GCDELIVERY_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsGcdeliveryFinish() {
        return isGcdeliveryFinish;
    }

    /**
     * columnName IS_GCDELIVERY_FINISH <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsGcdeliveryFinish(Integer isGcdeliveryFinish) {
        this.isGcdeliveryFinish = isGcdeliveryFinish;
    }

    /**
     * columnName WARRANTY <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getWarranty() {
        return warranty;
    }

    /**
     * columnName WARRANTY <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    /**
     * columnName STOCK_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStockOrderNo() {
        return stockOrderNo;
    }

    /**
     * columnName STOCK_ORDER_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStockOrderNo(String stockOrderNo) {
        this.stockOrderNo = stockOrderNo;
    }

    /**
     * columnName SYSL <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSysl() {
        return sysl;
    }

    /**
     * columnName SYSL <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSysl(String sysl) {
        this.sysl = sysl;
    }

    /**
     * columnName PR_ROW_ID <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPrRowId() {
        return prRowId;
    }

    /**
     * columnName PR_ROW_ID <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPrRowId(String prRowId) {
        this.prRowId = prRowId;
    }
}