package com.ur.mro.purpurchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.purmatinfo.model.PurMatinfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PUR_PURCHASE_APPLY
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PUR_PURCHASE_APPLY null")
public class PurPurchase {
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
    @Column(name = "APPLY_BY", nullable = true, length = 50, precision = 0)
    private String applyBy;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_DEPARTMENT", nullable = true, length = 20, precision = 0)
    private String applyDepartment;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 500, precision = 0)
    private String comments;

    @ApiModelProperty(value = "null")
    @Column(name = "CURRENCY", nullable = true, length = 10, precision = 0)
    private String currency;

    @ApiModelProperty(value = "null")
    @Column(name = "EXCHANGE_RATE", nullable = true, length = 10, precision = 2)
    private String exchangeRate;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 10, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_NO", nullable = true, length = 50, precision = 0)
    private String orderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_STATUS", nullable = true, length = 10, precision = 0)
    private Integer orderStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_TYPE", nullable = true, length = 20, precision = 0)
    private String orderType;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESSING_MODE", nullable = true, length = 10, precision = 0)
    private String processingMode;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE", nullable = true, length = 20, precision = 0)
    private String purchase;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_ORG", nullable = true, length = 20, precision = 0)
    private String purchaseOrg;

    @ApiModelProperty(value = "null")
    @Column(name = "STORE_ID", nullable = true, length = 255, precision = 0)
    private String storeId;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "FLOW_BY", nullable = true, length = 255, precision = 0)
    private String flowBy;

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
    @Column(name = "SUPPLIER_CODE", nullable = true, length = 30, precision = 0)
    private String supplierCode;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_NAME", nullable = true, length = 100, precision = 0)
    private String supplierName;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_BY", nullable = true, length = 30, precision = 0)
    private String purchaseBy;

    @ApiModelProperty(value = "null")
    @Column(name = "FLOW_TYPE", nullable = true, length = 10, precision = 0)
    private Integer flowType;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_PO", nullable = true, length = 30, precision = 0)
    private String referPo;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_REQUIRED", nullable = true, length = 30, precision = 0)
    private String materialRequired;

    @ApiModelProperty(value = "null")
    @Column(name = "DJ_TYPE", nullable = true, length = 30, precision = 0)
    private String djType;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_TYPE", nullable = true, length = 30, precision = 0)
    private String applyType;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_APPLY_NO", nullable = true, length = 30, precision = 0)
    private String referApplyNo;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_ORDER_FINISH", nullable = true, length = 30, precision = 0)
    private String isOrderFinish;

    @ApiModelProperty(value = "null")
    @Column(name = "TASK_TYPE", nullable = true, length = 50, precision = 0)
    private String taskType;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 2, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_IMAGE", nullable = true, length = 5, precision = 0)
    private String shopImage;

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
    @Column(name = "IS_TB", nullable = true, length = 10, precision = 0)
    private String isTb;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_SEND", nullable = true, length = 10, precision = 0)
    private String isSend;

    @ApiModelProperty(value = "null")
    @Column(name = "COST_CENTER_CODE", nullable = true, length = 30, precision = 0)
    private String costCenterCode;

    @ApiModelProperty(value = "null")
    @Column(name = "COST_CENTER_NAME", nullable = true, length = 50, precision = 0)
    private String costCenterName;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_NAME", nullable = true, length = 60, precision = 0)
    private String applyName;

    @ApiModelProperty(value = "null")
    @Column(name = "REMOVED", nullable = true, length = 1, precision = 0)
    private Integer removed;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "FLOW_FINISH_TIME", nullable = true, length = 27, precision = 7)
    private Date flowFinishTime;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_DB", nullable = true, length = 10, precision = 0)
    private String isDb;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_PR", nullable = true, length = 30, precision = 0)
    private String referPr;

    @ApiModelProperty(value = "null")
    @Column(name = "REFER_BG", nullable = true, length = 30, precision = 0)
    private String referBg;

    @ApiModelProperty(value = "null")
    @Column(name = "OA_CREATE_NO", nullable = true, length = 50, precision = 0)
    private String oaCreateNo;

    List<Attachment> files = new ArrayList<Attachment>();


    public List<Attachment> getFiles() {
        return files;
    }

    public void setFiles(List<Attachment> files) {
        this.files = files;
    }

    List<PurMatinfo> purMatinfoList = new ArrayList<PurMatinfo>();

    public List<PurMatinfo> getPurMatinfoList() {
        return purMatinfoList;
    }

    public void setPurMatinfoList(List<PurMatinfo> purMatinfoList) {
        this.purMatinfoList = purMatinfoList;
    }

    public String getUserBy() {
        return userBy;
    }

    public void setUserBy(String userBy) {
        this.userBy = userBy;
    }

    public  String  userBy;


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
     * columnName APPLY_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyBy() {
        return applyBy;
    }

    /**
     * columnName APPLY_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyBy(String applyBy) {
        this.applyBy = applyBy;
    }

    /**
     * columnName APPLY_DEPARTMENT <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyDepartment() {
        return applyDepartment;
    }

    /**
     * columnName APPLY_DEPARTMENT <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
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
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * columnName ORDER_NO <br/>
     * columnType varchar 50 0 <br/>
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
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * columnName ORDER_TYPE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
     * columnName FLOW_BY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFlowBy() {
        return flowBy;
    }

    /**
     * columnName FLOW_BY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlowBy(String flowBy) {
        this.flowBy = flowBy;
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
     * columnName SUPPLIER_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * columnName SUPPLIER_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * columnName SUPPLIER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * columnName SUPPLIER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseBy() {
        return purchaseBy;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseBy(String purchaseBy) {
        this.purchaseBy = purchaseBy;
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
     * columnName APPLY_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * columnName APPLY_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    /**
     * columnName REFER_APPLY_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReferApplyNo() {
        return referApplyNo;
    }

    /**
     * columnName REFER_APPLY_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReferApplyNo(String referApplyNo) {
        this.referApplyNo = referApplyNo;
    }

    /**
     * columnName IS_ORDER_FINISH <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsOrderFinish() {
        return isOrderFinish;
    }

    /**
     * columnName IS_ORDER_FINISH <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsOrderFinish(String isOrderFinish) {
        this.isOrderFinish = isOrderFinish;
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
     * columnName IS_TB <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsTb() {
        return isTb;
    }

    /**
     * columnName IS_TB <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsTb(String isTb) {
        this.isTb = isTb;
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
     * columnName APPLY_NAME <br/>
     * columnType varchar 60 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyName() {
        return applyName;
    }

    /**
     * columnName APPLY_NAME <br/>
     * columnType varchar 60 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    /**
     * columnName REMOVED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getRemoved() {
        return removed;
    }

    /**
     * columnName REMOVED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRemoved(Integer removed) {
        this.removed = removed;
    }

    /**
     * columnName FLOW_FINISH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getFlowFinishTime() {
        return flowFinishTime;
    }

    /**
     * columnName FLOW_FINISH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFlowFinishTime(Date flowFinishTime) {
        this.flowFinishTime = flowFinishTime;
    }

    /**
     * columnName IS_DB <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsDb() {
        return isDb;
    }

    /**
     * columnName IS_DB <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsDb(String isDb) {
        this.isDb = isDb;
    }

    /**
     * columnName REFER_PR <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReferPr() {
        return referPr;
    }

    /**
     * columnName REFER_PR <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReferPr(String referPr) {
        this.referPr = referPr;
    }

    /**
     * columnName REFER_BG <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReferBg() {
        return referBg;
    }

    /**
     * columnName REFER_BG <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReferBg(String referBg) {
        this.referBg = referBg;
    }

    /**
     * columnName OA_CREATE_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOaCreateNo() {
        return oaCreateNo;
    }

    /**
     * columnName OA_CREATE_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOaCreateNo(String oaCreateNo) {
        this.oaCreateNo = oaCreateNo;
    }
}