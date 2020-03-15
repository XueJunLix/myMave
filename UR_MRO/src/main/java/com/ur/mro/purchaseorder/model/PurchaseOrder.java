package com.ur.mro.purchaseorder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ur.mro.order.model.OrderInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PUR_PURCHASE_ORDER
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PUR_PURCHASE_ORDER null")
public class PurchaseOrder {
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
    @Column(name = "COMMENTS", nullable = true, length = 500, precision = 0)
    private String comments;

    @ApiModelProperty(value = "null")
    @Column(name = "CURRENCY", nullable = true, length = 10, precision = 0)
    private String currency;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_ADDRESS", nullable = true, length = 500, precision = 0)
    private String deliveryAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "EXCHANGE_RATE", nullable = true, length = 10, precision = 2)
    private String exchangeRate;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 10, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_NO", nullable = true, length = 20, precision = 0)
    private String orderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_STATUS", nullable = true, length = 10, precision = 0)
    private Integer orderStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_TYPE", nullable = true, length = 10, precision = 0)
    private String orderType;

    @ApiModelProperty(value = "null")
    @Column(name = "PAY_WAY", nullable = true, length = 50, precision = 0)
    private String payWay;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESSING_MODE", nullable = true, length = 10, precision = 0)
    private String processingMode;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE", nullable = true, length = 20, precision = 0)
    private String purchase;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_AMOUNT", nullable = true, length = 20, precision = 4)
    private String purchaseAmount;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_ORG", nullable = true, length = 20, precision = 0)
    private String purchaseOrg;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_CODE", nullable = true, length = 20, precision = 0)
    private String supplierCode;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_NAME", nullable = true, length = 400, precision = 0)
    private String supplierName;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_BY", nullable = true, length = 50, precision = 0)
    private String purchaseBy;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_TYPE", nullable = true, length = 4, precision = 0)
    private String purchaseType;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_MODE", nullable = true, length = 4, precision = 0)
    private String deliveryMode;

    @ApiModelProperty(value = "null")
    @Column(name = "STORE_ID", nullable = true, length = 255, precision = 0)
    private String storeId;

    @ApiModelProperty(value = "null")
    @Column(name = "FLOW_ID", nullable = true, length = 255, precision = 0)
    private String flowId;

    @ApiModelProperty(value = "null")
    @Column(name = "AFFIRM_STATUS", nullable = true, length = 10, precision = 0)
    private String affirmStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "CURRERY_TECH", nullable = true, length = 20, precision = 0)
    private String curreryTech;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "SUBMIT_TIME", nullable = true, length = 23, precision = 3)
    private Date submitTime;

    @ApiModelProperty(value = "null")
    @Column(name = "SUBMIT_USER", nullable = true, length = 20, precision = 0)
    private String submitUser;

    @ApiModelProperty(value = "null")
    @Column(name = "PAY_MODE", nullable = true, length = 30, precision = 0)
    private String payMode;

    @ApiModelProperty(value = "null")
    @Column(name = "AUDITOR", nullable = true, length = 50, precision = 0)
    private String auditor;

    @ApiModelProperty(value = "null")
    @Column(name = "CONSIGNEE", nullable = true, length = 50, precision = 0)
    private String consignee;

    @ApiModelProperty(value = "null")
    @Column(name = "QUALITY_MANAGER", nullable = true, length = 50, precision = 0)
    private String qualityManager;

    @ApiModelProperty(value = "null")
    @Column(name = "HAS_REPORT", nullable = true, length = 5, precision = 0)
    private String hasReport;

    @ApiModelProperty(value = "null")
    @Column(name = "ZJ_COMMENTS", nullable = true, length = 255, precision = 0)
    private String zjComments;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_TYPE", nullable = true, length = 20, precision = 0)
    private String poType;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_CLASSIFY", nullable = true, length = 20, precision = 0)
    private String poClassify;

    @ApiModelProperty(value = "null")
    @Column(name = "FH_MODE", nullable = true, length = 20, precision = 0)
    private String fhMode;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "DH_TIME", nullable = true, length = 27, precision = 7)
    private Date dhTime;

    @ApiModelProperty(value = "null")
    @Column(name = "FH_ADDRESS", nullable = true, length = 2147483647, precision = 0)
    private String fhAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTRACT_ID", nullable = true, length = 255, precision = 0)
    private String contractId;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTRACT_MAIN", nullable = true, length = 255, precision = 0)
    private String contractMain;

    @ApiModelProperty(value = "null")
    @Column(name = "FLOW_TYPE", nullable = true, length = 10, precision = 0)
    private Integer flowType;

    @ApiModelProperty(value = "null")
    @Column(name = "CT_COMMENTS", nullable = true, length = 255, precision = 0)
    private String ctComments;

    @ApiModelProperty(value = "null")
    @Column(name = "SJ_COMMENTS", nullable = true, length = 255, precision = 0)
    private String sjComments;

    @ApiModelProperty(value = "null")
    @Column(name = "PK_COMMENTS", nullable = true, length = 255, precision = 0)
    private String pkComments;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_PO", nullable = true, length = 30, precision = 0)
    private String referPo;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_REQUIRED", nullable = true, length = 30, precision = 0)
    private String materialRequired;

    @ApiModelProperty(value = "null")
    @Column(name = "DISPATCHING_WAY", nullable = true, length = 30, precision = 0)
    private String dispatchingWay;

    @ApiModelProperty(value = "null")
    @Column(name = "PAY_BY", nullable = true, length = 30, precision = 0)
    private String payBy;

    @ApiModelProperty(value = "null")
    @Column(name = "DJ_TYPE", nullable = true, length = 30, precision = 0)
    private String djType;

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
    @Column(name = "IS_CAN_CHANGE", nullable = true, length = 1, precision = 0)
    private Integer isCanChange;

    @ApiModelProperty(value = "null")
    @Column(name = "TASK_TYPE", nullable = true, length = 50, precision = 0)
    private String taskType;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_CAN_FED_BACK", nullable = true, length = 1, precision = 0)
    private Integer isCanFedBack;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 2, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_IMAGE", nullable = true, length = 5, precision = 0)
    private String shopImage;

    @ApiModelProperty(value = "null")
    @Column(name = "GC_PO_STATUS", nullable = true, length = 30, precision = 0)
    private String gcPoStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_DEPARTMENT", nullable = true, length = 20, precision = 0)
    private String applyDepartment;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_SHIP_DATE", nullable = true, length = 27, precision = 7)
    private Date supplierShipDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_PRODUCE_DATE", nullable = true, length = 27, precision = 7)
    private Date supplierProduceDate;

    @ApiModelProperty(value = "null")
    @Column(name = "FREIGHT", nullable = true, length = 18, precision = 0)
    private String freight;

    @ApiModelProperty(value = "null")
    @Column(name = "DEPOSIT", nullable = true, length = 18, precision = 0)
    private String deposit;

    @ApiModelProperty(value = "null")
    @Column(name = "INSTALLATION_FEE", nullable = true, length = 18, precision = 0)
    private String installationFee;

    @ApiModelProperty(value = "null")
    @Column(name = "OTHER_FEE", nullable = true, length = 18, precision = 0)
    private String otherFee;

    @ApiModelProperty(value = "null")
    @Column(name = "REQID", nullable = true, length = 10, precision = 0)
    private String reqid;

    @ApiModelProperty(value = "null")
    @Column(name = "ISOK", nullable = true, length = 2, precision = 0)
    private String isok;

    @ApiModelProperty(value = "null")
    @Column(name = "FLAG", nullable = true, length = 10, precision = 0)
    private String flag;

    @ApiModelProperty(value = "null")
    @Column(name = "OA_FW_STATUS", nullable = true, length = 10, precision = 0)
    private String oaFwStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "ZJSP_BY", nullable = true, length = 50, precision = 0)
    private String zjspBy;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_SEND", nullable = true, length = 10, precision = 0)
    private String isSend;

    @ApiModelProperty(value = "null")
    @Column(name = "COMPANY_CODE", nullable = true, length = 10, precision = 0)
    private String companyCode;

    @ApiModelProperty(value = "null")
    @Column(name = "COST_CENTER_CODE", nullable = true, length = 30, precision = 0)
    private String costCenterCode;

    @ApiModelProperty(value = "null")
    @Column(name = "COST_CENTER_NAME", nullable = true, length = 50, precision = 0)
    private String costCenterName;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_REC", nullable = true, length = 10, precision = 0)
    private String isRec;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTRACT_NO", nullable = true, length = 50, precision = 0)
    private String contractNo;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_QC", nullable = true, length = 10, precision = 0)
    private String isQc;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "APPOINT_QC_DATE", nullable = true, length = 27, precision = 7)
    private Date appointQcDate;

    @ApiModelProperty(value = "null")
    @Column(name = "DZ_IS_SEND", nullable = true, length = 10, precision = 0)
    private String dzIsSend;


    private List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(List<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
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
     * columnName COMMENTS <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComments() {
        return comments;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * columnName CURRENCY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * columnName CURRENCY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * columnName DELIVERY_ADDRESS <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * columnName DELIVERY_ADDRESS <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * columnName EXCHANGE_RATE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * columnName EXCHANGE_RATE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * columnName GROUP_ID <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * columnName GROUP_ID <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * columnName ORDER_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * columnName ORDER_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * columnName ORDER_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * columnName ORDER_STATUS <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * columnName ORDER_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * columnName ORDER_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * columnName PAY_WAY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * columnName PAY_WAY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    /**
     * columnName PROCESSING_MODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProcessingMode() {
        return processingMode;
    }

    /**
     * columnName PROCESSING_MODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode;
    }

    /**
     * columnName PURCHASE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchase() {
        return purchase;
    }

    /**
     * columnName PURCHASE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    /**
     * columnName PURCHASE_AMOUNT <br/>
     * columnType numeric 20 4 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * columnName PURCHASE_AMOUNT <br/>
     * columnType numeric 20 4 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    /**
     * columnName PURCHASE_ORG <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseOrg() {
        return purchaseOrg;
    }

    /**
     * columnName PURCHASE_ORG <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseOrg(String purchaseOrg) {
        this.purchaseOrg = purchaseOrg;
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
     * columnName SUPPLIER_NAME <br/>
     * columnType varchar 400 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * columnName SUPPLIER_NAME <br/>
     * columnType varchar 400 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseBy() {
        return purchaseBy;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseBy(String purchaseBy) {
        this.purchaseBy = purchaseBy;
    }

    /**
     * columnName PURCHASE_TYPE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseType() {
        return purchaseType;
    }

    /**
     * columnName PURCHASE_TYPE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    /**
     * columnName DELIVERY_MODE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDeliveryMode() {
        return deliveryMode;
    }

    /**
     * columnName DELIVERY_MODE <br/>
     * columnType varchar 4 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
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
     * columnName FLOW_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * columnName FLOW_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * columnName AFFIRM_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAffirmStatus() {
        return affirmStatus;
    }

    /**
     * columnName AFFIRM_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAffirmStatus(String affirmStatus) {
        this.affirmStatus = affirmStatus;
    }

    /**
     * columnName CURRERY_TECH <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCurreryTech() {
        return curreryTech;
    }

    /**
     * columnName CURRERY_TECH <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCurreryTech(String curreryTech) {
        this.curreryTech = curreryTech;
    }

    /**
     * columnName SUBMIT_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * columnName SUBMIT_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * columnName SUBMIT_USER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSubmitUser() {
        return submitUser;
    }

    /**
     * columnName SUBMIT_USER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSubmitUser(String submitUser) {
        this.submitUser = submitUser;
    }

    /**
     * columnName PAY_MODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPayMode() {
        return payMode;
    }

    /**
     * columnName PAY_MODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    /**
     * columnName AUDITOR <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     * columnName AUDITOR <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    /**
     * columnName CONSIGNEE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * columnName CONSIGNEE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * columnName QUALITY_MANAGER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getQualityManager() {
        return qualityManager;
    }

    /**
     * columnName QUALITY_MANAGER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setQualityManager(String qualityManager) {
        this.qualityManager = qualityManager;
    }

    /**
     * columnName HAS_REPORT <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getHasReport() {
        return hasReport;
    }

    /**
     * columnName HAS_REPORT <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setHasReport(String hasReport) {
        this.hasReport = hasReport;
    }

    /**
     * columnName ZJ_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZjComments() {
        return zjComments;
    }

    /**
     * columnName ZJ_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZjComments(String zjComments) {
        this.zjComments = zjComments;
    }

    /**
     * columnName PO_TYPE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoType() {
        return poType;
    }

    /**
     * columnName PO_TYPE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoType(String poType) {
        this.poType = poType;
    }

    /**
     * columnName PO_CLASSIFY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoClassify() {
        return poClassify;
    }

    /**
     * columnName PO_CLASSIFY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoClassify(String poClassify) {
        this.poClassify = poClassify;
    }

    /**
     * columnName FH_MODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFhMode() {
        return fhMode;
    }

    /**
     * columnName FH_MODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFhMode(String fhMode) {
        this.fhMode = fhMode;
    }

    /**
     * columnName DH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getDhTime() {
        return dhTime;
    }

    /**
     * columnName DH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDhTime(Date dhTime) {
        this.dhTime = dhTime;
    }

    /**
     * columnName FH_ADDRESS <br/>
     * columnType varchar 2147483647 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFhAddress() {
        return fhAddress;
    }

    /**
     * columnName FH_ADDRESS <br/>
     * columnType varchar 2147483647 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFhAddress(String fhAddress) {
        this.fhAddress = fhAddress;
    }

    /**
     * columnName CONTRACT_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * columnName CONTRACT_ID <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * columnName CONTRACT_MAIN <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getContractMain() {
        return contractMain;
    }

    /**
     * columnName CONTRACT_MAIN <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContractMain(String contractMain) {
        this.contractMain = contractMain;
    }

    /**
     * columnName FLOW_TYPE <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getFlowType() {
        return flowType;
    }

    /**
     * columnName FLOW_TYPE <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }

    /**
     * columnName CT_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCtComments() {
        return ctComments;
    }

    /**
     * columnName CT_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCtComments(String ctComments) {
        this.ctComments = ctComments;
    }

    /**
     * columnName SJ_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSjComments() {
        return sjComments;
    }

    /**
     * columnName SJ_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSjComments(String sjComments) {
        this.sjComments = sjComments;
    }

    /**
     * columnName PK_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPkComments() {
        return pkComments;
    }

    /**
     * columnName PK_COMMENTS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPkComments(String pkComments) {
        this.pkComments = pkComments;
    }

    /**
     * columnName REFER_PO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReferPo() {
        return referPo;
    }

    /**
     * columnName REFER_PO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReferPo(String referPo) {
        this.referPo = referPo;
    }

    /**
     * columnName MATERIAL_REQUIRED <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMaterialRequired() {
        return materialRequired;
    }

    /**
     * columnName MATERIAL_REQUIRED <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMaterialRequired(String materialRequired) {
        this.materialRequired = materialRequired;
    }

    /**
     * columnName DISPATCHING_WAY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDispatchingWay() {
        return dispatchingWay;
    }

    /**
     * columnName DISPATCHING_WAY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDispatchingWay(String dispatchingWay) {
        this.dispatchingWay = dispatchingWay;
    }

    /**
     * columnName PAY_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPayBy() {
        return payBy;
    }

    /**
     * columnName PAY_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    /**
     * columnName DJ_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDjType() {
        return djType;
    }

    /**
     * columnName DJ_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDjType(String djType) {
        this.djType = djType;
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
     * columnName IS_CAN_CHANGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsCanChange() {
        return isCanChange;
    }

    /**
     * columnName IS_CAN_CHANGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsCanChange(Integer isCanChange) {
        this.isCanChange = isCanChange;
    }

    /**
     * columnName TASK_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * columnName TASK_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * columnName IS_CAN_FED_BACK <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsCanFedBack() {
        return isCanFedBack;
    }

    /**
     * columnName IS_CAN_FED_BACK <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsCanFedBack(Integer isCanFedBack) {
        this.isCanFedBack = isCanFedBack;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    /**
     * columnName SHOP_IMAGE <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopImage() {
        return shopImage;
    }

    /**
     * columnName SHOP_IMAGE <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    /**
     * columnName GC_PO_STATUS <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGcPoStatus() {
        return gcPoStatus;
    }

    /**
     * columnName GC_PO_STATUS <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGcPoStatus(String gcPoStatus) {
        this.gcPoStatus = gcPoStatus;
    }

    /**
     * columnName APPLY_DEPARTMENT <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyDepartment() {
        return applyDepartment;
    }

    /**
     * columnName APPLY_DEPARTMENT <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    /**
     * columnName SUPPLIER_SHIP_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getSupplierShipDate() {
        return supplierShipDate;
    }

    /**
     * columnName SUPPLIER_SHIP_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierShipDate(Date supplierShipDate) {
        this.supplierShipDate = supplierShipDate;
    }

    /**
     * columnName SUPPLIER_PRODUCE_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getSupplierProduceDate() {
        return supplierProduceDate;
    }

    /**
     * columnName SUPPLIER_PRODUCE_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierProduceDate(Date supplierProduceDate) {
        this.supplierProduceDate = supplierProduceDate;
    }

    /**
     * columnName FREIGHT <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFreight() {
        return freight;
    }

    /**
     * columnName FREIGHT <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFreight(String freight) {
        this.freight = freight;
    }

    /**
     * columnName DEPOSIT <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDeposit() {
        return deposit;
    }

    /**
     * columnName DEPOSIT <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    /**
     * columnName INSTALLATION_FEE <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getInstallationFee() {
        return installationFee;
    }

    /**
     * columnName INSTALLATION_FEE <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setInstallationFee(String installationFee) {
        this.installationFee = installationFee;
    }

    /**
     * columnName OTHER_FEE <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOtherFee() {
        return otherFee;
    }

    /**
     * columnName OTHER_FEE <br/>
     * columnType varchar 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * columnName REQID <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReqid() {
        return reqid;
    }

    /**
     * columnName REQID <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReqid(String reqid) {
        this.reqid = reqid;
    }

    /**
     * columnName ISOK <br/>
     * columnType char 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsok() {
        return isok;
    }

    /**
     * columnName ISOK <br/>
     * columnType char 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsok(String isok) {
        this.isok = isok;
    }

    /**
     * columnName FLAG <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFlag() {
        return flag;
    }

    /**
     * columnName FLAG <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * columnName OA_FW_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOaFwStatus() {
        return oaFwStatus;
    }

    /**
     * columnName OA_FW_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOaFwStatus(String oaFwStatus) {
        this.oaFwStatus = oaFwStatus;
    }

    /**
     * columnName ZJSP_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZjspBy() {
        return zjspBy;
    }

    /**
     * columnName ZJSP_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZjspBy(String zjspBy) {
        this.zjspBy = zjspBy;
    }

    /**
     * columnName IS_SEND <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsSend() {
        return isSend;
    }

    /**
     * columnName IS_SEND <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    /**
     * columnName COMPANY_CODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * columnName COMPANY_CODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * columnName COST_CENTER_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCostCenterCode() {
        return costCenterCode;
    }

    /**
     * columnName COST_CENTER_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    /**
     * columnName COST_CENTER_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCostCenterName() {
        return costCenterName;
    }

    /**
     * columnName COST_CENTER_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
    }

    /**
     * columnName IS_REC <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsRec() {
        return isRec;
    }

    /**
     * columnName IS_REC <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsRec(String isRec) {
        this.isRec = isRec;
    }

    /**
     * columnName CONTRACT_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * columnName CONTRACT_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * columnName IS_QC <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsQc() {
        return isQc;
    }

    /**
     * columnName IS_QC <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsQc(String isQc) {
        this.isQc = isQc;
    }

    /**
     * columnName APPOINT_QC_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getAppointQcDate() {
        return appointQcDate;
    }

    /**
     * columnName APPOINT_QC_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAppointQcDate(Date appointQcDate) {
        this.appointQcDate = appointQcDate;
    }

    /**
     * columnName DZ_IS_SEND <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDzIsSend() {
        return dzIsSend;
    }

    /**
     * columnName DZ_IS_SEND <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDzIsSend(String dzIsSend) {
        this.dzIsSend = dzIsSend;
    }
}