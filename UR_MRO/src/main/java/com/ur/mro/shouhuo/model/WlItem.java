package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_PO2GC_WLITEM
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_WLITEM null")
public class WlItem {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "WL_ID", nullable = true, length = 19, precision = 0)
    private Integer wlId;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_NO", nullable = true, length = 50, precision = 0)
    private String shNo;

    @ApiModelProperty(value = "null")
    @Column(name = "ROW_NO", nullable = true, length = 50, precision = 0)
    private String rowNo;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CODE", nullable = true, length = 50, precision = 0)
    private String matCode;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_NAME", nullable = true, length = 50, precision = 0)
    private String matName;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_SPEC", nullable = true, length = 255, precision = 0)
    private String matSpec;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_CZ", nullable = true, length = 255, precision = 0)
    private String matCz;

    @ApiModelProperty(value = "null")
    @Column(name = "UNIT", nullable = true, length = 50, precision = 0)
    private String unit;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_QUT", nullable = true, length = 18, precision = 0)
    private String shQut;

    @ApiModelProperty(value = "null")
    @Column(name = "S_TYPE", nullable = true, length = 50, precision = 0)
    private String sType;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_SHNO", nullable = true, length = 50, precision = 0)
    private String supShno;

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
    @Column(name = "PR_NO", nullable = true, length = 15, precision = 0)
    private String prNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_NO", nullable = true, length = 20, precision = 0)
    private String poNo;

    @ApiModelProperty(value = "null")
    @Column(name = "CH_NO", nullable = true, length = 30, precision = 0)
    private String chNo;

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
     * columnName WL_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getWlId() {
        return wlId;
    }

    /**
     * columnName WL_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setWlId(Integer wlId) {
        this.wlId = wlId;
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
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatName() {
        return matName;
    }

    /**
     * columnName MAT_NAME <br/>
     * columnType varchar 50 0 <br/>
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
     * columnName MAT_CZ <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatCz() {
        return matCz;
    }

    /**
     * columnName MAT_CZ <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatCz(String matCz) {
        this.matCz = matCz;
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
     * columnType numeric 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShQut() {
        return shQut;
    }

    /**
     * columnName SH_QUT <br/>
     * columnType numeric 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShQut(String shQut) {
        this.shQut = shQut;
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
     * columnName SUP_SHNO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupShno() {
        return supShno;
    }

    /**
     * columnName SUP_SHNO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupShno(String supShno) {
        this.supShno = supShno;
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
}