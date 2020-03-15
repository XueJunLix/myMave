package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PO2GC_GCSHITEM
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_GCSHITEM null")
public class GcshItem {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_ID", nullable = true, length = 19, precision = 0)
    private Integer shId;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_NO", nullable = true, length = 50, precision = 0)
    private String poNo;

    @ApiModelProperty(value = "null")
    @Column(name = "ROW_NO", nullable = true, length = 50, precision = 0)
    private String rowNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CODE", nullable = true, length = 50, precision = 0)
    private String matCode;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_NAME", nullable = true, length = 255, precision = 0)
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
    @Column(name = "PO_QUT", nullable = true, length = 53, precision = 0)
    private String poQut;

    @ApiModelProperty(value = "null")
    @Column(name = "MAKE_IE", nullable = true, length = 50, precision = 0)
    private String makeIe;

    @ApiModelProperty(value = "null")
    @Column(name = "SJ_SH_QUT", nullable = true, length = 53, precision = 0)
    private String sjShQut;

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
    @Column(name = "B_TYPE", nullable = true, length = 10, precision = 0)
    private String bType;

    @ApiModelProperty(value = "null")
    @Column(name = "M_TYPE", nullable = true, length = 10, precision = 0)
    private String mType;

    @ApiModelProperty(value = "null")
    @Column(name = "S_TYPE", nullable = true, length = 10, precision = 0)
    private String sType;

    @ApiModelProperty(value = "null")
    @Column(name = "PR_NO", nullable = true, length = 15, precision = 0)
    private String prNo;

    @ApiModelProperty(value = "null")
    @Column(name = "YS_QUT", nullable = true, length = 24, precision = 0)
    private String ysQut;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NO", nullable = true, length = 30, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_NO", nullable = true, length = 50, precision = 0)
    private String shNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_NAME", nullable = true, length = 50, precision = 0)
    private String shopName;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_TO_SHOP_NO", nullable = true, length = 50, precision = 0)
    private String changeToShopNo;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_TO_SHOP_NAME", nullable = true, length = 50, precision = 0)
    private String changeToShopName;

    @ApiModelProperty(value = "null")
    @Column(name = "OUT_COUNT", nullable = true, length = 53, precision = 0)
    private String outCount;

    @ApiModelProperty(value = "null")
    @Column(name = "CAN_SH_COUNT", nullable = true, length = 53, precision = 0)
    private String canShCount;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_TO_PO_NO", nullable = true, length = 50, precision = 0)
    private String changeToPoNo;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANGE_TO_PO_COUNT", nullable = true, length = 53, precision = 0)
    private String changeToPoCount;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "SIGN_DATE", nullable = true, length = 27, precision = 7)
    private Date signDate;

    @ApiModelProperty(value = "null")
    @Column(name = "BOX_NUM", nullable = true, length = 20, precision = 0)
    private String boxNum;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_NO", nullable = true, length = 10, precision = 0)
    private String supNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_NAME", nullable = true, length = 50, precision = 0)
    private String supName;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_OR_PR_ID", nullable = true, length = 50, precision = 0)
    private String poOrPrId;

    private String shQut1;

    public String getShQut1() {
        return shQut1;
    }

    public void setShQut1(String shQut1) {
        this.shQut1 = shQut1;
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
     * columnName SH_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getShId() {
        return shId;
    }

    /**
     * columnName SH_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShId(Integer shId) {
        this.shId = shId;
    }

    /**
     * columnName PO_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoNo() {
        return poNo;
    }

    /**
     * columnName PO_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoNo(String poNo) {
        this.poNo = poNo;
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
     * columnName PO_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoQut() {
        return poQut;
    }

    /**
     * columnName PO_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoQut(String poQut) {
        this.poQut = poQut;
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
     * columnName SJ_SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSjShQut() {
        return sjShQut;
    }

    /**
     * columnName SJ_SH_QUT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSjShQut(String sjShQut) {
        this.sjShQut = sjShQut;
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
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getbType() {
        return bType;
    }

    /**
     * columnName B_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setbType(String bType) {
        this.bType = bType;
    }

    /**
     * columnName M_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getmType() {
        return mType;
    }

    /**
     * columnName M_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setmType(String mType) {
        this.mType = mType;
    }

    /**
     * columnName S_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getsType() {
        return sType;
    }

    /**
     * columnName S_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setsType(String sType) {
        this.sType = sType;
    }

    /**
     * columnName PR_NO <br/>
     * columnType varchar 15 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPrNo() {
        return prNo;
    }

    /**
     * columnName PR_NO <br/>
     * columnType varchar 15 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    /**
     * columnName YS_QUT <br/>
     * columnType real 24 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getYsQut() {
        return ysQut;
    }

    /**
     * columnName YS_QUT <br/>
     * columnType real 24 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setYsQut(String ysQut) {
        this.ysQut = ysQut;
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
     * columnName CHANGE_TO_SHOP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeToShopNo() {
        return changeToShopNo;
    }

    /**
     * columnName CHANGE_TO_SHOP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeToShopNo(String changeToShopNo) {
        this.changeToShopNo = changeToShopNo;
    }

    /**
     * columnName CHANGE_TO_SHOP_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeToShopName() {
        return changeToShopName;
    }

    /**
     * columnName CHANGE_TO_SHOP_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeToShopName(String changeToShopName) {
        this.changeToShopName = changeToShopName;
    }

    /**
     * columnName OUT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOutCount() {
        return outCount;
    }

    /**
     * columnName OUT_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOutCount(String outCount) {
        this.outCount = outCount;
    }

    /**
     * columnName CAN_SH_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCanShCount() {
        return canShCount;
    }

    /**
     * columnName CAN_SH_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCanShCount(String canShCount) {
        this.canShCount = canShCount;
    }

    /**
     * columnName CHANGE_TO_PO_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeToPoNo() {
        return changeToPoNo;
    }

    /**
     * columnName CHANGE_TO_PO_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeToPoNo(String changeToPoNo) {
        this.changeToPoNo = changeToPoNo;
    }

    /**
     * columnName CHANGE_TO_PO_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getChangeToPoCount() {
        return changeToPoCount;
    }

    /**
     * columnName CHANGE_TO_PO_COUNT <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setChangeToPoCount(String changeToPoCount) {
        this.changeToPoCount = changeToPoCount;
    }

    /**
     * columnName SIGN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * columnName SIGN_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * columnName BOX_NUM <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBoxNum() {
        return boxNum;
    }

    /**
     * columnName BOX_NUM <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBoxNum(String boxNum) {
        this.boxNum = boxNum;
    }

    /**
     * columnName SUP_NO <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupNo() {
        return supNo;
    }

    /**
     * columnName SUP_NO <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    /**
     * columnName SUP_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupName() {
        return supName;
    }

    /**
     * columnName SUP_NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupName(String supName) {
        this.supName = supName;
    }

    /**
     * columnName PO_OR_PR_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoOrPrId() {
        return poOrPrId;
    }

    /**
     * columnName PO_OR_PR_ID <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoOrPrId(String poOrPrId) {
        this.poOrPrId = poOrPrId;
    }
}