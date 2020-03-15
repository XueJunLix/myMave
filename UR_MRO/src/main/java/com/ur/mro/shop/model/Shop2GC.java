package com.ur.mro.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.ur.mro.contract.model.Contract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_SHOP2GC_INFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SHOP2GC_INFO null")
public class Shop2GC {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "CODE", nullable = true, length = 50, precision = 0)
    private String code;

    @ApiModelProperty(value = "null")
    @Column(name = "NAME", nullable = true, length = 150, precision = 0)
    private String name;

    @ApiModelProperty(value = "null")
    @Column(name = "CONTRACT_AREA", nullable = true, length = 50, precision = 0)
    private String contractArea;

    @ApiModelProperty(value = "null")
    @Column(name = "SALES_BUDGET", nullable = true, length = 53, precision = 0)
    private String salesBudget;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 20, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "TYPE", nullable = true, length = 50, precision = 0)
    private String type;

    @ApiModelProperty(value = "null")
    @Column(name = "SALES_LEVEL", nullable = true, length = 50, precision = 0)
    private String salesLevel;

    @ApiModelProperty(value = "null")
    @Column(name = "IMAGE_LEVEL", nullable = true, length = 50, precision = 0)
    private String imageLevel;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_CROSS_LAYER", nullable = true, length = 50, precision = 0)
    private String isCrossLayer;

    @ApiModelProperty(value = "null")
    @Column(name = "RELOAD", nullable = true, length = 50, precision = 0)
    private String reload;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_STREET_SHOP", nullable = true, length = 50, precision = 0)
    private String isStreetShop;

    @ApiModelProperty(value = "null")
    @Column(name = "OUTSIDE_HOUSE", nullable = true, length = 50, precision = 0)
    private String outsideHouse;

    @ApiModelProperty(value = "null")
    @Column(name = "STAFF_ESTABLISHING", nullable = true, length = 50, precision = 0)
    private String staffEstablishing;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "EXPECTED_OPEN_TIME", nullable = true, length = 27, precision = 7)
    private Date expectedOpenTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "OPEN_TIME", nullable = true, length = 27, precision = 7)
    private Date openTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "EXPECTED_ENGINEERING_DELIVERY_TIME", nullable = true, length = 27, precision = 7)
    private Date expectedEngineeringDeliveryTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "ENGINEERING_DELIVERY_TIME", nullable = true, length = 27, precision = 7)
    private Date engineeringDeliveryTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "EXPECTED_ENGINEERING_APPROACH_TIME", nullable = true, length = 27, precision = 7)
    private Date expectedEngineeringApproachTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "ENGINEERING_APPROACH_TIME", nullable = true, length = 27, precision = 7)
    private Date engineeringApproachTime;

    @ApiModelProperty(value = "null")
    @Column(name = "COUNTRY", nullable = true, length = 50, precision = 0)
    private String country;

    @ApiModelProperty(value = "null")
    @Column(name = "PROVINCE", nullable = true, length = 50, precision = 0)
    private String province;

    @ApiModelProperty(value = "null")
    @Column(name = "CITY", nullable = true, length = 50, precision = 0)
    private String city;

    @ApiModelProperty(value = "null")
    @Column(name = "POSTCODE", nullable = true, length = 50, precision = 0)
    private String postcode;

    @ApiModelProperty(value = "null")
    @Column(name = "ADDRESS", nullable = true, length = 250, precision = 0)
    private String address;

    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_BY", nullable = false, length = 50, precision = 0)
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "CREATED_TIME", nullable = false, length = 27, precision = 7)
    private Date createdTime;

    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_BY", nullable = false, length = 50, precision = 0)
    private String lastUpdatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "LAST_UPDATED_TIME", nullable = false, length = 27, precision = 7)
    private Date lastUpdatedTime;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "INVOICE_HEAD", nullable = true, length = 100, precision = 0)
    private String invoiceHead;

    @ApiModelProperty(value = "null")
    @Column(name = "DISABLED", nullable = true, length = 50, precision = 0)
    private String  disabled;

    @ApiModelProperty(value = "null")
    @Column(name = "AREA", nullable = true, length = 50, precision = 0)
    private String area;

    @ApiModelProperty(value = "null")
    @Column(name = "REGION", nullable = true, length = 50, precision = 0)
    private String region;

    @ApiModelProperty(value = "null")
    @Column(name = "DISTRICT", nullable = true, length = 50, precision = 0)
    private String district;


    @ApiModelProperty(value = "null")
    @Column(name = "CONTACTS", nullable = true, length = 50, precision = 0)
    private String  CONTACTS;

    @ApiModelProperty(value = "null")
    @Column(name = "TELEPHONE", nullable = true, length = 50, precision = 0)
    private String  TELEPHONE;

    @ApiModelProperty(value = "null")
    @Column(name = "MOBILEPHONE", nullable = true, length = 50, precision = 0)
    private String  MOBILEPHONE;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOPWIN_COUNT", nullable = true, length = 50, precision = 0)
    private Integer  shopWinCount;

    private List<Contract> infoContactInformationList= Lists.newArrayList();


    public List<Contract> getInfoContactInformationList() {
        return infoContactInformationList;
    }


    public  void  setInfoContactInformationList(List<Contract> infoContactInformationList) {
             this.infoContactInformationList=infoContactInformationList;
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
     * columnName CODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCode() {
        return code;
    }

    /**
     * columnName CODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getName() {
        return name;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * columnName CONTRACT_AREA <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getContractArea() {
        return contractArea;
    }

    /**
     * columnName CONTRACT_AREA <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setContractArea(String contractArea) {
        this.contractArea = contractArea;
    }

    /**
     * columnName SALES_BUDGET <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSalesBudget() {
        return salesBudget;
    }

    /**
     * columnName SALES_BUDGET <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSalesBudget(String salesBudget) {
        this.salesBudget = salesBudget;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * columnName BRAND_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    /**
     * columnName TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getType() {
        return type;
    }

    /**
     * columnName TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * columnName SALES_LEVEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSalesLevel() {
        return salesLevel;
    }

    /**
     * columnName SALES_LEVEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSalesLevel(String salesLevel) {
        this.salesLevel = salesLevel;
    }

    /**
     * columnName IMAGE_LEVEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getImageLevel() {
        return imageLevel;
    }

    /**
     * columnName IMAGE_LEVEL <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setImageLevel(String imageLevel) {
        this.imageLevel = imageLevel;
    }

    /**
     * columnName IS_CROSS_LAYER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsCrossLayer() {
        return isCrossLayer;
    }

    /**
     * columnName IS_CROSS_LAYER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsCrossLayer(String isCrossLayer) {
        this.isCrossLayer = isCrossLayer;
    }

    /**
     * columnName RELOAD <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReload() {
        return reload;
    }

    /**
     * columnName RELOAD <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReload(String reload) {
        this.reload = reload;
    }

    /**
     * columnName IS_STREET_SHOP <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsStreetShop() {
        return isStreetShop;
    }

    /**
     * columnName IS_STREET_SHOP <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsStreetShop(String isStreetShop) {
        this.isStreetShop = isStreetShop;
    }

    /**
     * columnName OUTSIDE_HOUSE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOutsideHouse() {
        return outsideHouse;
    }

    /**
     * columnName OUTSIDE_HOUSE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOutsideHouse(String outsideHouse) {
        this.outsideHouse = outsideHouse;
    }

    /**
     * columnName STAFF_ESTABLISHING <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStaffEstablishing() {
        return staffEstablishing;
    }

    /**
     * columnName STAFF_ESTABLISHING <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStaffEstablishing(String staffEstablishing) {
        this.staffEstablishing = staffEstablishing;
    }

    /**
     * columnName EXPECTED_OPEN_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getExpectedOpenTime() {
        return expectedOpenTime;
    }

    /**
     * columnName EXPECTED_OPEN_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpectedOpenTime(Date expectedOpenTime) {
        this.expectedOpenTime = expectedOpenTime;
    }

    /**
     * columnName OPEN_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * columnName OPEN_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * columnName EXPECTED_ENGINEERING_DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getExpectedEngineeringDeliveryTime() {
        return expectedEngineeringDeliveryTime;
    }

    /**
     * columnName EXPECTED_ENGINEERING_DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpectedEngineeringDeliveryTime(Date expectedEngineeringDeliveryTime) {
        this.expectedEngineeringDeliveryTime = expectedEngineeringDeliveryTime;
    }

    /**
     * columnName ENGINEERING_DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getEngineeringDeliveryTime() {
        return engineeringDeliveryTime;
    }

    /**
     * columnName ENGINEERING_DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEngineeringDeliveryTime(Date engineeringDeliveryTime) {
        this.engineeringDeliveryTime = engineeringDeliveryTime;
    }

    /**
     * columnName EXPECTED_ENGINEERING_APPROACH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getExpectedEngineeringApproachTime() {
        return expectedEngineeringApproachTime;
    }

    /**
     * columnName EXPECTED_ENGINEERING_APPROACH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setExpectedEngineeringApproachTime(Date expectedEngineeringApproachTime) {
        this.expectedEngineeringApproachTime = expectedEngineeringApproachTime;
    }

    /**
     * columnName ENGINEERING_APPROACH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getEngineeringApproachTime() {
        return engineeringApproachTime;
    }

    /**
     * columnName ENGINEERING_APPROACH_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEngineeringApproachTime(Date engineeringApproachTime) {
        this.engineeringApproachTime = engineeringApproachTime;
    }

    /**
     * columnName COUNTRY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCountry() {
        return country;
    }

    /**
     * columnName COUNTRY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * columnName PROVINCE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProvince() {
        return province;
    }

    /**
     * columnName PROVINCE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * columnName CITY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCity() {
        return city;
    }

    /**
     * columnName CITY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * columnName POSTCODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * columnName POSTCODE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * columnName ADDRESS <br/>
     * columnType varchar 250 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAddress() {
        return address;
    }

    /**
     * columnName ADDRESS <br/>
     * columnType varchar 250 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAddress(String address) {
        this.address = address;
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
     * columnName INVOICE_HEAD <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getInvoiceHead() {
        return invoiceHead;
    }

    /**
     * columnName INVOICE_HEAD <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    /**
     * columnName DISABLED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDisabled() {
        return disabled;
    }

    /**
     * columnName DISABLED <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    /**
     * columnName AREA <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getArea() {
        return area;
    }

    /**
     * columnName AREA <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * columnName REGION <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRegion() {
        return region;
    }

    /**
     * columnName REGION <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * columnName DISTRICT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDistrict() {
        return district;
    }

    /**
     * columnName DISTRICT <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDistrict(String district) {
        this.district = district;
    }
}