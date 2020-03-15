package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PO2GC_DELIVERYITEM
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_DELIVERYITEM null")
public class DeliveryItem {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_ID", nullable = true, length = 19, precision = 0)
    private Integer deliveryId;

    @ApiModelProperty(value = "null")
    @Column(name = "ROW_NO", nullable = true, length = 50, precision = 0)
    private String rowNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CODE", nullable = true, length = 50, precision = 0)
    private String matCode;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_NAME", nullable = true, length = 100, precision = 0)
    private String matName;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_SPEC", nullable = true, length = 100, precision = 0)
    private String matSpec;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CZ", nullable = true, length = 50, precision = 0)
    private String matCz;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_SIZE", nullable = true, length = 50, precision = 0)
    private String matSize;

    @ApiModelProperty(value = "null")
    @Column(name = "UNIT", nullable = true, length = 50, precision = 0)
    private String unit;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_QUT", nullable = true, length = 53, precision = 0)
    private String shQut;

    @ApiModelProperty(value = "null")
    @Column(name = "MAKE_IE", nullable = true, length = 50, precision = 0)
    private String makeIe;

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
    @Column(name = "B_TYPE", nullable = true, length = 50, precision = 0)
    private String bType;

    @ApiModelProperty(value = "null")
    @Column(name = "M_TYPE", nullable = true, length = 50, precision = 0)
    private String mType;

    @ApiModelProperty(value = "null")
    @Column(name = "S_TYPE", nullable = true, length = 50, precision = 0)
    private String sType;

    @ApiModelProperty(value = "null")
    @Column(name = "QC_SH_QUT", nullable = true, length = 53, precision = 0)
    private String qcShQut;

    @ApiModelProperty(value = "null")
    @Column(name = "CY_QUT", nullable = true, length = 53, precision = 0)
    private String cyQut;

    @ApiModelProperty(value = "null")
    @Column(name = "DEAL_RESULT", nullable = true, length = 50, precision = 0)
    private String dealResult;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_NO", nullable = true, length = 20, precision = 0)
    private String poNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PR_NO", nullable = true, length = 20, precision = 0)
    private String prNo;

    @ApiModelProperty(value = "null")
    @Column(name = "YS_QUT", nullable = true, length = 53, precision = 0)
    private String ysQut;

    @ApiModelProperty(value = "null")
    @Column(name = "KS_QUT", nullable = true, length = 53, precision = 0)
    private String ksQut;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 100, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 150, precision = 0)
    private String shopName;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_ITEM_ROW_NO", nullable = true, length = 50, precision = 0)
    private String poItemRowNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_ITEM_ID", nullable = true, length = 50, precision = 0)
    private String shItemId;

    Delivery delivery= new Delivery();

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
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
     * columnName DELIVERY_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getDeliveryId() {
        return deliveryId;
    }

    /**
     * columnName DELIVERY_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * columnName ROW_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRowNo() {
        return rowNo;
    }

    /**
     * columnName ROW_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    /**
     * columnName MAT_CODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatCode() {
        return matCode;
    }

    /**
     * columnName MAT_CODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    /**
     * columnName MAT_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatName() {
        return matName;
    }

    /**
     * columnName MAT_NAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatName(String matName) {
        this.matName = matName;
    }

    /**
     * columnName MAT_SPEC <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatSpec() {
        return matSpec;
    }

    /**
     * columnName MAT_SPEC <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    /**
     * columnName MAT_CZ <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatCz() {
        return matCz;
    }

    /**
     * columnName MAT_CZ <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatCz(String matCz) {
        this.matCz = matCz;
    }

    /**
     * columnName MAT_SIZE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatSize() {
        return matSize;
    }

    /**
     * columnName MAT_SIZE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatSize(String matSize) {
        this.matSize = matSize;
    }

    /**
     * columnName UNIT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getUnit() {
        return unit;
    }

    /**
     * columnName UNIT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * columnName SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShQut() {
        return shQut;
    }

    /**
     * columnName SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShQut(String shQut) {
        this.shQut = shQut;
    }

    /**
     * columnName MAKE_IE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMakeIe() {
        return makeIe;
    }

    /**
     * columnName MAKE_IE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMakeIe(String makeIe) {
        this.makeIe = makeIe;
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
     * columnName B_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getbType() {
        return bType;
    }

    /**
     * columnName B_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setbType(String bType) {
        this.bType = bType;
    }

    /**
     * columnName M_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getmType() {
        return mType;
    }

    /**
     * columnName M_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setmType(String mType) {
        this.mType = mType;
    }

    /**
     * columnName S_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getsType() {
        return sType;
    }

    /**
     * columnName S_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setsType(String sType) {
        this.sType = sType;
    }

    /**
     * columnName QC_SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getQcShQut() {
        return qcShQut;
    }

    /**
     * columnName QC_SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setQcShQut(String qcShQut) {
        this.qcShQut = qcShQut;
    }

    /**
     * columnName CY_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCyQut() {
        return cyQut;
    }

    /**
     * columnName CY_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCyQut(String cyQut) {
        this.cyQut = cyQut;
    }

    /**
     * columnName DEAL_RESULT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * columnName DEAL_RESULT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    /**
     * columnName PO_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     * columnName PO_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    /**
     * columnName PR_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPrNo() {
        return prNo;
    }

    /**
     * columnName PR_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    /**
     * columnName YS_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getYsQut() {
        return ysQut;
    }

    /**
     * columnName YS_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setYsQut(String ysQut) {
        this.ysQut = ysQut;
    }

    /**
     * columnName KS_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getKsQut() {
        return ksQut;
    }

    /**
     * columnName KS_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setKsQut(String ksQut) {
        this.ksQut = ksQut;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * columnName SHOP_NO <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * columnName SHOP_NAME <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * columnName PO_ITEM_ROW_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoItemRowNo() {
        return poItemRowNo;
    }

    /**
     * columnName PO_ITEM_ROW_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoItemRowNo(String poItemRowNo) {
        this.poItemRowNo = poItemRowNo;
    }

    /**
     * columnName SH_ITEM_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShItemId() {
        return shItemId;
    }

    /**
     * columnName SH_ITEM_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShItemId(String shItemId) {
        this.shItemId = shItemId;
    }
}