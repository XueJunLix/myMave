package com.ur.mro.shouhuo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;

/**
 * TableName SRM_PO2GC_GCSHHEAD
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_PO2GC_GCSHHEAD null")
public class GCshHdead {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

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
    @Column(name = "SUP_NO", nullable = true, length = 50, precision = 0)
    private String supNo;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_NAME", nullable = true, length = 500, precision = 0)
    private String supName;

    @ApiModelProperty(value = "null")
    @Column(name = "TEL", nullable = true, length = 50, precision = 0)
    private String tel;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTACTS", nullable = true, length = 50, precision = 0)
    private String contacts;

    @ApiModelProperty(value = "null")
    @Column(name = "BOXES", nullable = true, length = 10, precision = 0)
    private Integer boxes;

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
    @Column(name = "SUP_TEL", nullable = true, length = 50, precision = 0)
    private String supTel;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_LINK_MAN", nullable = true, length = 50, precision = 0)
    private String supLinkMan;

    @ApiModelProperty(value = "null")
    @Column(name = "ADDR", nullable = true, length = 255, precision = 0)
    private String addr;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_TYPE", nullable = true, length = 30, precision = 0)
    private String shType;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "REQUIRED_ARRIVAL_DATE", nullable = true, length = 27, precision = 7)
    private Date requiredArrivalDate;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_ALREADY_EXPORT", nullable = false, length = 1, precision = 0)
    private Integer isAlreadyExport;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_SUBMIT", nullable = false, length = 1, precision = 0)
    private Integer isSubmit;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_HASH_CHANGE_MAT", nullable = true, length = 50, precision = 0)
    private String isHashChangeMat;

    @ApiModelProperty(value = "null")
    @Column(name = "MY_CHECK_BOX", nullable = true, length = 1, precision = 0)
    private Integer myCheckBox;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 2, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "GC_SH_STATUS", nullable = true, length = 2, precision = 0)
    private String gcShStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "FREIGHT", nullable = true, length = 18, precision = 2)
    private String freight;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_DELIVER_DATE", nullable = true, length = 27, precision = 7)
    private Date supplierDeliverDate;

    @ApiModelProperty(value = "null")
    @Column(name = "EMAIL", nullable = true, length = 100, precision = 0)
    private String email;

    @ApiModelProperty(value = "null")
    @Column(name = "WL_NO", nullable = true, length = 50, precision = 0)
    private String wlNo;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_SEND", nullable = true, length = 5, precision = 0)
    private String isSend;

    @ApiModelProperty(value = "null")
    @Column(name = "BOX_NO", nullable = true, length = 50, precision = 0)
    private String boxNo;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_GCJLSIGN", nullable = true, length = 5, precision = 0)
    private String isGcjlsign;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_NO", nullable = true, length = 50, precision = 0)
    private String outerWarehouseNo;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_NAME", nullable = true, length = 500, precision = 0)
    private String outerWarehouseName;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_CONTACTS", nullable = true, length = 50, precision = 0)
    private String outerWarehouseContacts;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_TEL", nullable = true, length = 50, precision = 0)
    private String outerWarehouseTel;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_EMAIL", nullable = true, length = 100, precision = 0)
    private String outerWarehouseEmail;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTER_WAREHOUSE_ADDR", nullable = true, length = 255, precision = 0)
    private String outerWarehouseAddr;

    @ApiModelProperty(value = "null")
    @Column(name = "SH_TASK_TYPE", nullable = true, length = 2, precision = 0)
    private String shTaskType;

    @ApiModelProperty(value = "null")
    @Column(name = "COMPANY_CODE", nullable = true, length = 10, precision = 0)
    private String companyCode;

    private String  matCode;

    private String price;

    private String qcShQut;

    public String getQcShQut() {
        return qcShQut;
    }

    public void setQcShQut(String qcShQut) {
        this.qcShQut = qcShQut;
    }
    private String cyQut;
    public String getCyQut() {
        return this.cyQut;
    }
    public void setCyQut(String cyQut) {
        this.cyQut = cyQut;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSHQut2() {
        return sHQut2;
    }

    public void setSHQut2(String sHQut2) {
        this.sHQut2 = sHQut2;
    }

    private String sHQut2;

    public String getAbbfileName() {
        return abbfileName;
    }

    public void setAbbfileName(String abbfileName) {
        this.abbfileName = abbfileName;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    private String  matName;

    public String getShQut() {
        return shQut;
    }

    public void setShQut(String shQut) {
        this.shQut = shQut;
    }

    public String getPoQut() {
        return poQut;
    }

    public void setPoQut(String poQut) {
        this.poQut = poQut;
    }

    public String getSjShQut() {
        return sjShQut;
    }

    public void setSjShQut(String sjShQut) {
        this.sjShQut = sjShQut;
    }

    private String abbfileName;
    private String createByName;

    private  String   shQut ;
    private  String poQut  ;
    private String sjShQut;


    private List<GcshItem> gcshitemVOs = new ArrayList<GcshItem>();

    public List<GcshItem> getGcshitemVOs() {
        return gcshitemVOs;
    }

    public void setGcshitemVOs(List<GcshItem> gcshitemVOs) {
        this.gcshitemVOs = gcshitemVOs;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public boolean getChecked() {
        return checked?checked:false;
    }

    public Integer getShouHchayi() {
        return this.shouHchayi;
    }

    public void setShouHchayi(Integer shouHchayi) {
        this.shouHchayi = shouHchayi;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private boolean checked;

    private  Integer shouHchayi;

    private String ysOut;

    public String getPrNO() {
        return prNO;
    }

    public void setPrNO(String prNO) {
        this.prNO = prNO;
    }

    private String prNO;

    public String getYsOut() {
        return ysOut;
    }

    public void setYsOut(String ysOut) {
        this.ysOut = ysOut;
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
     * columnName SUP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupNo() {
        return supNo;
    }

    /**
     * columnName SUP_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    /**
     * columnName SUP_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupName() {
        return supName;
    }

    /**
     * columnName SUP_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupName(String supName) {
        this.supName = supName;
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
     * columnName SUP_TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupTel() {
        return supTel;
    }

    /**
     * columnName SUP_TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupTel(String supTel) {
        this.supTel = supTel;
    }

    /**
     * columnName SUP_LINK_MAN <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupLinkMan() {
        return supLinkMan;
    }

    /**
     * columnName SUP_LINK_MAN <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupLinkMan(String supLinkMan) {
        this.supLinkMan = supLinkMan;
    }

    /**
     * columnName ADDR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAddr() {
        return addr;
    }

    /**
     * columnName ADDR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * columnName SH_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShType() {
        return shType;
    }

    /**
     * columnName SH_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShType(String shType) {
        this.shType = shType;
    }

    /**
     * columnName REQUIRED_ARRIVAL_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getRequiredArrivalDate() {
        return requiredArrivalDate;
    }

    /**
     * columnName REQUIRED_ARRIVAL_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRequiredArrivalDate(Date requiredArrivalDate) {
        this.requiredArrivalDate = requiredArrivalDate;
    }

    /**
     * columnName IS_ALREADY_EXPORT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getIsAlreadyExport() {
        return isAlreadyExport;
    }

    /**
     * columnName IS_ALREADY_EXPORT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setIsAlreadyExport(Integer isAlreadyExport) {
        this.isAlreadyExport = isAlreadyExport;
    }

    /**
     * columnName IS_SUBMIT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getIsSubmit() {
        return isSubmit;
    }

    /**
     * columnName IS_SUBMIT <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    /**
     * columnName IS_HASH_CHANGE_MAT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsHashChangeMat() {
        return isHashChangeMat;
    }

    /**
     * columnName IS_HASH_CHANGE_MAT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsHashChangeMat(String isHashChangeMat) {
        this.isHashChangeMat = isHashChangeMat;
    }

    /**
     * columnName MY_CHECK_BOX <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getMyCheckBox() {
        return myCheckBox;
    }

    /**
     * columnName MY_CHECK_BOX <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMyCheckBox(Integer myCheckBox) {
        this.myCheckBox = myCheckBox;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType nvarchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType nvarchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    /**
     * columnName GC_SH_STATUS <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGcShStatus() {
        return gcShStatus;
    }

    /**
     * columnName GC_SH_STATUS <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGcShStatus(String gcShStatus) {
        this.gcShStatus = gcShStatus;
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
     * columnName SUPPLIER_DELIVER_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getSupplierDeliverDate() {
        return supplierDeliverDate;
    }

    /**
     * columnName SUPPLIER_DELIVER_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierDeliverDate(Date supplierDeliverDate) {
        this.supplierDeliverDate = supplierDeliverDate;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEmail() {
        return email;
    }

    /**
     * columnName EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEmail(String email) {
        this.email = email;
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
     * columnName IS_SEND <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsSend() {
        return isSend;
    }

    /**
     * columnName IS_SEND <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    /**
     * columnName BOX_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBoxNo() {
        return boxNo;
    }

    /**
     * columnName BOX_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    /**
     * columnName IS_GCJLSIGN <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsGcjlsign() {
        return isGcjlsign;
    }

    /**
     * columnName IS_GCJLSIGN <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsGcjlsign(String isGcjlsign) {
        this.isGcjlsign = isGcjlsign;
    }

    /**
     * columnName OUTER_WAREHOUSE_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseNo() {
        return outerWarehouseNo;
    }

    /**
     * columnName OUTER_WAREHOUSE_NO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseNo(String outerWarehouseNo) {
        this.outerWarehouseNo = outerWarehouseNo;
    }

    /**
     * columnName OUTER_WAREHOUSE_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseName() {
        return outerWarehouseName;
    }

    /**
     * columnName OUTER_WAREHOUSE_NAME <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseName(String outerWarehouseName) {
        this.outerWarehouseName = outerWarehouseName;
    }

    /**
     * columnName OUTER_WAREHOUSE_CONTACTS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseContacts() {
        return outerWarehouseContacts;
    }

    /**
     * columnName OUTER_WAREHOUSE_CONTACTS <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseContacts(String outerWarehouseContacts) {
        this.outerWarehouseContacts = outerWarehouseContacts;
    }

    /**
     * columnName OUTER_WAREHOUSE_TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseTel() {
        return outerWarehouseTel;
    }

    /**
     * columnName OUTER_WAREHOUSE_TEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseTel(String outerWarehouseTel) {
        this.outerWarehouseTel = outerWarehouseTel;
    }

    /**
     * columnName OUTER_WAREHOUSE_EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseEmail() {
        return outerWarehouseEmail;
    }

    /**
     * columnName OUTER_WAREHOUSE_EMAIL <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseEmail(String outerWarehouseEmail) {
        this.outerWarehouseEmail = outerWarehouseEmail;
    }

    /**
     * columnName OUTER_WAREHOUSE_ADDR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOuterWarehouseAddr() {
        return outerWarehouseAddr;
    }

    /**
     * columnName OUTER_WAREHOUSE_ADDR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOuterWarehouseAddr(String outerWarehouseAddr) {
        this.outerWarehouseAddr = outerWarehouseAddr;
    }

    /**
     * columnName SH_TASK_TYPE <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShTaskType() {
        return shTaskType;
    }

    /**
     * columnName SH_TASK_TYPE <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShTaskType(String shTaskType) {
        this.shTaskType = shTaskType;
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
}