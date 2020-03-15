package com.ur.mro.purmatinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PUR_APPLY_INFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PUR_APPLY_INFO null")
public class PurMatinfo {
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
    @Column(name = "BASE_UNIT", nullable = true, length = 255, precision = 0)
    private String baseUnit;

    @ApiModelProperty(value = "null")
    @Column(name = "BASE_UNIT_COUNT", nullable = true, length = 53, precision = 0)
    private String baseUnitCount;

    @ApiModelProperty(value = "null")
    @Column(name = "CLO_DESIGN_NO", nullable = true, length = 255, precision = 0)
    private String cloDesignNo;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 255, precision = 0)
    private String comments;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_DATE", nullable = true, length = 27, precision = 7)
    private Date deliveryDate;

    @ApiModelProperty(value = "null")
    @Column(name = "DEMAND_ORDER_NO", nullable = true, length = 255, precision = 0)
    private String demandOrderNo;

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
    @Column(name = "ROW_ID", nullable = true, length = 50, precision = 0)
    private String rowId;

    @ApiModelProperty(value = "null")
    @Column(name = "STORE_ID", nullable = true, length = 255, precision = 0)
    private String storeId;

    @ApiModelProperty(value = "null")
    @Column(name = "TAX_RATE", nullable = true, length = 53, precision = 0)
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
    @Column(name = "APPLY_ID", nullable = false, length = 19, precision = 0)
    private Integer applyId;

    @ApiModelProperty(value = "null")
    @Column(name = "M_ROW_ID", nullable = true, length = 10, precision = 0)
    private Integer mRowId;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_AREADY_APPLY", nullable = true, length = 1, precision = 0)
    private Integer isAreadyApply;

    @ApiModelProperty(value = "null")
    @Column(name = "FLAT", nullable = true, length = 1, precision = 0)
    private Integer flat;

    @ApiModelProperty(value = "null")
    @Column(name = "CLO_DEMAND_NO", nullable = true, length = 50, precision = 0)
    private String cloDemandNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_COLOR", nullable = true, length = 130, precision = 0)
    private String supplierColor;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_P_CODE", nullable = true, length = 130, precision = 0)
    private String supplierPCode;

    @ApiModelProperty(value = "null")
    @Column(name = "STANDARD_COLOR", nullable = true, length = 20, precision = 0)
    private String standardColor;

    @ApiModelProperty(value = "null")
    @Column(name = "STANDARD_COLOR_YN", nullable = true, length = 1, precision = 0)
    private Integer standardColorYn;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 30, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 50, precision = 0)
    private String shopName;

    @ApiModelProperty(value = "null")
    @Column(name = "ENTER_INFO", nullable = true, length = 30, precision = 0)
    private String enterInfo;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_QUALITY", nullable = true, length = 50, precision = 0)
    private String materialQuality;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESS_TECHNOLOGY", nullable = true, length = 255, precision = 0)
    private String processTechnology;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "EXPECTED_ARRIVAL_DATE", nullable = true, length = 27, precision = 7)
    private Date expectedArrivalDate;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_BY", nullable = true, length = 30, precision = 0)
    private String receiverBy;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_ADDRESS", nullable = true, length = 255, precision = 0)
    private String receiverAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_BY_TELEPHONE", nullable = true, length = 30, precision = 0)
    private String receiverByTelephone;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_B", nullable = true, length = 30, precision = 0)
    private String categoryB;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_A", nullable = true, length = 30, precision = 0)
    private String categoryA;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_COUNT", nullable = true, length = 53, precision = 0)
    private String changeCount;

    @ApiModelProperty(value = "null")
    @Column(name = "HANDLE_SUGGESTION", nullable = true, length = 30, precision = 0)
    private String handleSuggestion;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "PLAN_USE_DATA", nullable = true, length = 27, precision = 7)
    private Date planUseData;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_REASON", nullable = true, length = 30, precision = 0)
    private String changeReason;

    @ApiModelProperty(value = "null")
    @Column(name = "TOTAL_COUNT", nullable = true, length = 53, precision = 0)
    private String totalCount;

    @ApiModelProperty(value = "null")
    @Column(name = "CURRENT_COUNT", nullable = true, length = 53, precision = 0)
    private String currentCount;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_C", nullable = true, length = 30, precision = 0)
    private String categoryC;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_NO", nullable = true, length = 30, precision = 0)
    private String groupNo;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_PO", nullable = true, length = 50, precision = 0)
    private String referPo;

    @ApiModelProperty(value = "null")
    @Column(name = "CAN_CREATED", nullable = true, length = 30, precision = 0)
    private String canCreated;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_HANDLED", nullable = true, length = 1, precision = 0)
    private Integer isHandled;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_HANDLED_BY", nullable = true, length = 30, precision = 0)
    private String orderHandledBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_HANDLED_TIME", nullable = true, length = 27, precision = 7)
    private Date orderHandledTime;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_DAYS", nullable = true, length = 10, precision = 0)
    private Integer poDays;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "DD_DATE", nullable = true, length = 27, precision = 7)
    private Date ddDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "MIN_DATE", nullable = true, length = 27, precision = 7)
    private Date minDate;

    @ApiModelProperty(value = "null")
    @Column(name = "WINDOW_CODE", nullable = true, length = 30, precision = 0)
    private String windowCode;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "THE_LAST_ORDER_DATE", nullable = true, length = 27, precision = 7)
    private Date theLastOrderDate;

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
     * columnName CLO_DESIGN_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCloDesignNo() {
        return cloDesignNo;
    }

    /**
     * columnName CLO_DESIGN_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCloDesignNo(String cloDesignNo) {
        this.cloDesignNo = cloDesignNo;
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
     * columnName ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRowId() {
        return rowId;
    }

    /**
     * columnName ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRowId(String rowId) {
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
     * columnName TAX_RATE <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTaxRate() {
        return taxRate;
    }

    /**
     * columnName TAX_RATE <br/>
     * columnType float 53 0 <br/>
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
     * columnName APPLY_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * columnName APPLY_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * columnName M_ROW_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getmRowId() {
        return mRowId;
    }

    /**
     * columnName M_ROW_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setmRowId(Integer mRowId) {
        this.mRowId = mRowId;
    }

    /**
     * columnName IS_AREADY_APPLY <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsAreadyApply() {
        return isAreadyApply;
    }

    /**
     * columnName IS_AREADY_APPLY <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsAreadyApply(Integer isAreadyApply) {
        this.isAreadyApply = isAreadyApply;
    }

    /**
     * columnName FLAT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getFlat() {
        return flat;
    }

    /**
     * columnName FLAT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    /**
     * columnName CLO_DEMAND_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCloDemandNo() {
        return cloDemandNo;
    }

    /**
     * columnName CLO_DEMAND_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCloDemandNo(String cloDemandNo) {
        this.cloDemandNo = cloDemandNo;
    }

    /**
     * columnName SUPPLIER_COLOR <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierColor() {
        return supplierColor;
    }

    /**
     * columnName SUPPLIER_COLOR <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierColor(String supplierColor) {
        this.supplierColor = supplierColor;
    }

    /**
     * columnName SUPPLIER_P_CODE <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierPCode() {
        return supplierPCode;
    }

    /**
     * columnName SUPPLIER_P_CODE <br/>
     * columnType varchar 130 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierPCode(String supplierPCode) {
        this.supplierPCode = supplierPCode;
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
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * columnName ENTER_INFO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEnterInfo() {
        return enterInfo;
    }

    /**
     * columnName ENTER_INFO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEnterInfo(String enterInfo) {
        this.enterInfo = enterInfo;
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
     * columnName EXPECTED_ARRIVAL_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    /**
     * columnName EXPECTED_ARRIVAL_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpectedArrivalDate(Date expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
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
     * columnName CHANGE_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeCount() {
        return changeCount;
    }

    /**
     * columnName CHANGE_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeCount(String changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * columnName HANDLE_SUGGESTION <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getHandleSuggestion() {
        return handleSuggestion;
    }

    /**
     * columnName HANDLE_SUGGESTION <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setHandleSuggestion(String handleSuggestion) {
        this.handleSuggestion = handleSuggestion;
    }

    /**
     * columnName PLAN_USE_DATA <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getPlanUseData() {
        return planUseData;
    }

    /**
     * columnName PLAN_USE_DATA <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPlanUseData(Date planUseData) {
        this.planUseData = planUseData;
    }

    /**
     * columnName CHANGE_REASON <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * columnName CHANGE_REASON <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    /**
     * columnName TOTAL_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * columnName TOTAL_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * columnName CURRENT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCurrentCount() {
        return currentCount;
    }

    /**
     * columnName CURRENT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCurrentCount(String currentCount) {
        this.currentCount = currentCount;
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
     * columnName GROUP_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * columnName GROUP_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    /**
     * columnName REFER_PO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReferPo() {
        return referPo;
    }

    /**
     * columnName REFER_PO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReferPo(String referPo) {
        this.referPo = referPo;
    }

    /**
     * columnName CAN_CREATED <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCanCreated() {
        return canCreated;
    }

    /**
     * columnName CAN_CREATED <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCanCreated(String canCreated) {
        this.canCreated = canCreated;
    }

    /**
     * columnName IS_HANDLED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsHandled() {
        return isHandled;
    }

    /**
     * columnName IS_HANDLED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsHandled(Integer isHandled) {
        this.isHandled = isHandled;
    }

    /**
     * columnName ORDER_HANDLED_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderHandledBy() {
        return orderHandledBy;
    }

    /**
     * columnName ORDER_HANDLED_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderHandledBy(String orderHandledBy) {
        this.orderHandledBy = orderHandledBy;
    }

    /**
     * columnName ORDER_HANDLED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getOrderHandledTime() {
        return orderHandledTime;
    }

    /**
     * columnName ORDER_HANDLED_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderHandledTime(Date orderHandledTime) {
        this.orderHandledTime = orderHandledTime;
    }

    /**
     * columnName PO_DAYS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getPoDays() {
        return poDays;
    }

    /**
     * columnName PO_DAYS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoDays(Integer poDays) {
        this.poDays = poDays;
    }

    /**
     * columnName DD_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getDdDate() {
        return ddDate;
    }

    /**
     * columnName DD_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDdDate(Date ddDate) {
        this.ddDate = ddDate;
    }

    /**
     * columnName MIN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getMinDate() {
        return minDate;
    }

    /**
     * columnName MIN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    /**
     * columnName WINDOW_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getWindowCode() {
        return windowCode;
    }

    /**
     * columnName WINDOW_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWindowCode(String windowCode) {
        this.windowCode = windowCode;
    }

    /**
     * columnName THE_LAST_ORDER_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getTheLastOrderDate() {
        return theLastOrderDate;
    }

    /**
     * columnName THE_LAST_ORDER_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTheLastOrderDate(Date theLastOrderDate) {
        this.theLastOrderDate = theLastOrderDate;
    }

    /**
     * columnName PR_ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPrRowId() {
        return prRowId;
    }

    /**
     * columnName PR_ROW_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPrRowId(String prRowId) {
        this.prRowId = prRowId;
    }
}