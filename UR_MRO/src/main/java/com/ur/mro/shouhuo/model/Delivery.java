package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.ur.mro.pic.model.Attachment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PO2GC_DELIVERY
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_DELIVERY null")
public class Delivery {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_NO", nullable = true, length = 50, precision = 0)
    private String deliveryNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_NO", nullable = true, length = 50, precision = 0)
    private String shNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 50, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 500, precision = 0)
    private String shopName;

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
    @Column(name = "CH_NO", nullable = true, length = 30, precision = 0)
    private String chNo;

    @ApiModelProperty(value = "null")
    @Column(name = "DEL_DIFF_STATUS", nullable = true, length = 50, precision = 0)
    private String delDiffStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 2, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "GC_WL_STATUS", nullable = true, length = 2, precision = 0)
    private String gcWlStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "FREIGHT", nullable = true, length = 18, precision = 2)
    private String freight;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "GOODS_SIGN_DATE", nullable = true, length = 27, precision = 7)
    private Date goodsSignDate;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_SUBMIT", nullable = true, length = 10, precision = 0)
    private String isSubmit;

    @ApiModelProperty(value = "null")
    @Column(name = "BOXES", nullable = true, length = 10, precision = 0)
    private Integer boxes;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_COMPLETED", nullable = true, length = 10, precision = 0)
    private String isCompleted;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_OUTNUMBER", nullable = true, length = 10, precision = 0)
    private String isOutnumber;

    @ApiModelProperty(value = "null")
    @Column(name = "DP_NAME", nullable = true, length = 150, precision = 0)
    private String dpName;

    @ApiModelProperty(value = "null")
    @Column(name = "DP_NO", nullable = true, length = 100, precision = 0)
    private String dpNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SENDER_NO", nullable = true, length = 50, precision = 0)
    private String senderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SENDER_NAME", nullable = true, length = 100, precision = 0)
    private String senderName;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_NO", nullable = true, length = 50, precision = 0)
    private String receiverNo;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIVER_NAME", nullable = true, length = 100, precision = 0)
    private String receiverName;

    private List<Attachment> files =new ArrayList<Attachment>();

    public List<Attachment> getFiles() {
        return files;
    }

    public void setFiles(List<Attachment> files) {
        this.files = files;
    }

    List<DeliveryItem> deliveryitems= Lists.newArrayList();

    public List<DeliveryItem> getDeliveryitems() {
        return deliveryitems;
    }

    public void setDeliveryitems(List<DeliveryItem> deliveryitems) {
        this.deliveryitems = deliveryitems;
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
     * columnName DELIVERY_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDeliveryNo() {
        return deliveryNo;
    }

    /**
     * columnName DELIVERY_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    /**
     * columnName SH_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShNo() {
        return shNo;
    }

    /**
     * columnName SH_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShNo(String shNo) {
        this.shNo = shNo;
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
     * columnName CH_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChNo() {
        return chNo;
    }

    /**
     * columnName CH_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChNo(String chNo) {
        this.chNo = chNo;
    }

    /**
     * columnName DEL_DIFF_STATUS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDelDiffStatus() {
        return delDiffStatus;
    }

    /**
     * columnName DEL_DIFF_STATUS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDelDiffStatus(String delDiffStatus) {
        this.delDiffStatus = delDiffStatus;
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
     * columnName GC_WL_STATUS <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGcWlStatus() {
        return gcWlStatus;
    }

    /**
     * columnName GC_WL_STATUS <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGcWlStatus(String gcWlStatus) {
        this.gcWlStatus = gcWlStatus;
    }

    /**
     * columnName FREIGHT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFreight() {
        return freight;
    }

    /**
     * columnName FREIGHT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFreight(String freight) {
        this.freight = freight;
    }

    /**
     * columnName GOODS_SIGN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getGoodsSignDate() {
        return goodsSignDate;
    }

    /**
     * columnName GOODS_SIGN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGoodsSignDate(Date goodsSignDate) {
        this.goodsSignDate = goodsSignDate;
    }

    /**
     * columnName IS_SUBMIT <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsSubmit() {
        return isSubmit;
    }

    /**
     * columnName IS_SUBMIT <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    /**
     * columnName BOXES <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getBoxes() {
        return boxes;
    }

    /**
     * columnName BOXES <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBoxes(Integer boxes) {
        this.boxes = boxes;
    }

    /**
     * columnName IS_COMPLETED <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsCompleted() {
        return isCompleted;
    }

    /**
     * columnName IS_COMPLETED <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * columnName IS_OUTNUMBER <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsOutnumber() {
        return isOutnumber;
    }

    /**
     * columnName IS_OUTNUMBER <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsOutnumber(String isOutnumber) {
        this.isOutnumber = isOutnumber;
    }

    /**
     * columnName DP_NAME <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDpName() {
        return dpName;
    }

    /**
     * columnName DP_NAME <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    /**
     * columnName DP_NO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDpNo() {
        return dpNo;
    }

    /**
     * columnName DP_NO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDpNo(String dpNo) {
        this.dpNo = dpNo;
    }

    /**
     * columnName SENDER_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSenderNo() {
        return senderNo;
    }

    /**
     * columnName SENDER_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    /**
     * columnName SENDER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * columnName SENDER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * columnName RECEIVER_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiverNo() {
        return receiverNo;
    }

    /**
     * columnName RECEIVER_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    /**
     * columnName RECEIVER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * columnName RECEIVER_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}