package com.ur.mro.sup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_SUP_SUPPLIER
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SUP_SUPPLIER null")
public class Supplier {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 20, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "CODE", nullable = true, length = 12, precision = 0)
    private String code;

    @ApiModelProperty(value = "null")
    @Column(name = "OLD_CODE", nullable = true, length = 12, precision = 0)
    private String oldCode;

    @ApiModelProperty(value = "状态：0启用，1禁用")
    @Column(name = "STATUS", nullable = true, length = 10, precision = 0)
    private String status;

    @ApiModelProperty(value = "null")
    @Column(name = "SHORT_NAME", nullable = true, length = 100, precision = 0)
    private String shortName;

    @ApiModelProperty(value = "null")
    @Column(name = "FULL_NAME", nullable = true, length = 200, precision = 0)
    private String fullName;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESSING_MODE", nullable = true, length = 10, precision = 0)
    private String processingMode;

    @ApiModelProperty(value = "null")
    @Column(name = "SITE_ADD", nullable = true, length = 255, precision = 0)
    private String siteAdd;

    @ApiModelProperty(value = "null")
    @Column(name = "INDUSTRY_TYPE", nullable = true, length = 10, precision = 0)
    private String industryType;

    @ApiModelProperty(value = "null")
    @Column(name = "ARTIFICIAL_PERSOR", nullable = true, length = 10, precision = 0)
    private String artificialPersor;

    @ApiModelProperty(value = "null")
    @Column(name = "GENERAL_MANAGER", nullable = true, length = 10, precision = 0)
    private String generalManager;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "FOUNDING_TIME", nullable = true, length = 10, precision = 0)
    private Date foundingTime;

    @ApiModelProperty(value = "null")
    @Column(name = "REGISTERED_CAPITAL", nullable = true, length = 19, precision = 0)
    private Integer registeredCapital;

    @ApiModelProperty(value = "null")
    @Column(name = "FLOOR_AREA", nullable = true, length = 10, precision = 0)
    private Integer floorArea;

    @ApiModelProperty(value = "null")
    @Column(name = "COVERED_AREA", nullable = true, length = 10, precision = 0)
    private Integer coveredArea;

    @ApiModelProperty(value = "null")
    @Column(name = "ENTERPRISE_PROPERTY", nullable = true, length = 10, precision = 0)
    private String enterpriseProperty;

    @ApiModelProperty(value = "null")
    @Column(name = "OWNER", nullable = true, length = 100, precision = 0)
    private String owner;

    @ApiModelProperty(value = "null")
    @Column(name = "BUSINESS_CONCEPTS", nullable = true, length = 500, precision = 0)
    private String businessConcepts;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 2147483647, precision = 0)
    private String comments;

    @ApiModelProperty(value = "null")
    @Column(name = "NATION", nullable = true, length = 20, precision = 0)
    private String nation;

    @ApiModelProperty(value = "null")
    @Column(name = "PROVINCE", nullable = true, length = 20, precision = 0)
    private String province;

    @ApiModelProperty(value = "null")
    @Column(name = "CITY", nullable = true, length = 20, precision = 0)
    private String city;

    @ApiModelProperty(value = "null")
    @Column(name = "ADDRESS", nullable = true, length = 500, precision = 0)
    private String address;

    @ApiModelProperty(value = "null")
    @Column(name = "ZIP_CODE", nullable = true, length = 10, precision = 0)
    private String zipCode;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_ADDS", nullable = true, length = 255, precision = 0)
    private String commentsAdds;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_PAPERS", nullable = true, length = 255, precision = 0)
    private String commentsPapers;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_CERTIFICATES", nullable = true, length = 255, precision = 0)
    private String commentsCertificates;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_MANAGERS", nullable = true, length = 255, precision = 0)
    private String commentsManagers;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_WORKERS", nullable = true, length = 255, precision = 0)
    private String commentsWorkers;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_EQUIPMENTS", nullable = true, length = 255, precision = 0)
    private String commentsEquipments;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_CUSTOMERS", nullable = true, length = 255, precision = 0)
    private String commentsCustomers;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_BIZSCOPE", nullable = true, length = 255, precision = 0)
    private String commentsBizscope;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS_PARTNERS", nullable = true, length = 255, precision = 0)
    private String commentsPartners;

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
    @Column(name = "SUP_TYPE", nullable = true, length = 10, precision = 0)
    private String supType;

    @ApiModelProperty(value = "null")
    @Column(name = "BUY_GROUP", nullable = true, length = 10, precision = 0)
    private String buyGroup;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_GROUP", nullable = true, length = 255, precision = 0)
    private String supGroup;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_CAL_STATUS", nullable = true, length = 10, precision = 0)
    private String supCalStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "MONTH_SETTLE", nullable = true, length = 10, precision = 0)
    private String monthSettle;

    @ApiModelProperty(value = "null")
    @Column(name = "SUP_COOPERATION_WAY", nullable = true, length = 10, precision = 0)
    private String supCooperationWay;

    @ApiModelProperty(value = "null")
    @Column(name = "DJ_TYPE", nullable = true, length = 30, precision = 0)
    private String djType;

    @ApiModelProperty(value = "null")
    @Column(name = "COORDINATION", nullable = true, length = 10, precision = 0)
    private String coordination;

    @ApiModelProperty(value = "null")
    @Column(name = "EARNEST_STATUS", nullable = true, length = 20, precision = 0)
    private String earnestStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "REGISTERNO", nullable = true, length = 50, precision = 0)
    private String registerno;

    @ApiModelProperty(value = "null")
    @Column(name = "QG_NUMBER", nullable = true, length = 100, precision = 0)
    private String qgNumber;

    @ApiModelProperty(value = "null")
    @Column(name = "LXR", nullable = true, length = 30, precision = 0)
    private String lxr;

    @ApiModelProperty(value = "null")
    @Column(name = "LXR_NUMBER", nullable = true, length = 30, precision = 0)
    private String lxrNumber;

    @ApiModelProperty(value = "null")
    @Column(name = "JX_COMMENTS", nullable = true, length = 1000, precision = 0)
    private String jxComments;

    @ApiModelProperty(value = "null")
    @Column(name = "JX_ADDRESS", nullable = true, length = 1000, precision = 0)
    private String jxAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "LXR_EMAIL", nullable = true, length = 255, precision = 0)
    private String lxrEmail;

    @ApiModelProperty(value = "null")
    @Column(name = "UR_KFY", nullable = true, length = 50, precision = 0)
    private String urKfy;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_NATION", nullable = true, length = 20, precision = 0)
    private String afterNation;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_PROVINCE", nullable = true, length = 20, precision = 0)
    private String afterProvince;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_CITY", nullable = true, length = 20, precision = 0)
    private String afterCity;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_ADDRESS", nullable = true, length = 500, precision = 0)
    private String afterAddress;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_ZIP_CODE", nullable = true, length = 10, precision = 0)
    private String afterZipCode;

    @ApiModelProperty(value = "null")
    @Column(name = "AFTER_PHONE_NUMBER", nullable = true, length = 10, precision = 0)

    private String afterPhoneNumber;

    public String getAfterNation() {
        return this.afterNation;
    }

    public void setAfterNation(String afterNation) {
        this.afterNation = afterNation;
    }


    public String getAfterCity() {
        return this.afterCity;
    }

    public void setAfterCity(String afterCity) {
        this.afterCity = afterCity;
    }

    public String getAfterProvince() {
        return afterProvince;
    }

    public void setAfterProvince(String afterProvince) {
        this.afterProvince = afterProvince;
    }

    public String getAfterAddress() {
        return this.afterAddress;
    }

    public void setAfterAddress(String afterAddress) {
        this.afterAddress = afterAddress;
    }

    public String getAfterZipCode() {
        return this.afterZipCode;
    }

    public void setAfterZipCode(String afterZipCode) {
        this.afterZipCode = afterZipCode;
    }

    public String getAfterPhoneNumber() {
        return this.afterPhoneNumber;
    }

    public void setAfterPhoneNumber(String afterPhoneNumber) {
        this.afterPhoneNumber = afterPhoneNumber;
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
     * columnName GROUP_ID <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * columnName GROUP_ID <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * columnName CODE <br/>
     * columnType varchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCode() {
        return code;
    }

    /**
     * columnName CODE <br/>
     * columnType varchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * columnName OLD_CODE <br/>
     * columnType varchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOldCode() {
        return oldCode;
    }

    /**
     * columnName OLD_CODE <br/>
     * columnType varchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    /**
     * columnName STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * columnName STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * columnName SHORT_NAME <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * columnName SHORT_NAME <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * columnName FULL_NAME <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * columnName FULL_NAME <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * columnName SITE_ADD <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSiteAdd() {
        return siteAdd;
    }

    /**
     * columnName SITE_ADD <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSiteAdd(String siteAdd) {
        this.siteAdd = siteAdd;
    }

    /**
     * columnName INDUSTRY_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * columnName INDUSTRY_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    /**
     * columnName ARTIFICIAL_PERSOR <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getArtificialPersor() {
        return artificialPersor;
    }

    /**
     * columnName ARTIFICIAL_PERSOR <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setArtificialPersor(String artificialPersor) {
        this.artificialPersor = artificialPersor;
    }

    /**
     * columnName GENERAL_MANAGER <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGeneralManager() {
        return generalManager;
    }

    /**
     * columnName GENERAL_MANAGER <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    /**
     * columnName FOUNDING_TIME <br/>
     * columnType TIMESTAMP 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getFoundingTime() {
        return foundingTime;
    }

    /**
     * columnName FOUNDING_TIME <br/>
     * columnType TIMESTAMP 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }

    /**
     * columnName REGISTERED_CAPITAL <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * columnName REGISTERED_CAPITAL <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * columnName FLOOR_AREA <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getFloorArea() {
        return floorArea;
    }

    /**
     * columnName FLOOR_AREA <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    /**
     * columnName COVERED_AREA <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getCoveredArea() {
        return coveredArea;
    }

    /**
     * columnName COVERED_AREA <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCoveredArea(Integer coveredArea) {
        this.coveredArea = coveredArea;
    }

    /**
     * columnName ENTERPRISE_PROPERTY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    /**
     * columnName ENTERPRISE_PROPERTY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    /**
     * columnName OWNER <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOwner() {
        return owner;
    }

    /**
     * columnName OWNER <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * columnName BUSINESS_CONCEPTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBusinessConcepts() {
        return businessConcepts;
    }

    /**
     * columnName BUSINESS_CONCEPTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBusinessConcepts(String businessConcepts) {
        this.businessConcepts = businessConcepts;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType nvarchar 2147483647 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComments() {
        return comments;
    }

    /**
     * columnName COMMENTS <br/>
     * columnType nvarchar 2147483647 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * columnName NATION <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getNation() {
        return nation;
    }

    /**
     * columnName NATION <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * columnName PROVINCE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProvince() {
        return province;
    }

    /**
     * columnName PROVINCE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * columnName CITY <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCity() {
        return city;
    }

    /**
     * columnName CITY <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * columnName ADDRESS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAddress() {
        return address;
    }

    /**
     * columnName ADDRESS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * columnName ZIP_CODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * columnName ZIP_CODE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * columnName COMMENTS_ADDS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsAdds() {
        return commentsAdds;
    }

    /**
     * columnName COMMENTS_ADDS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsAdds(String commentsAdds) {
        this.commentsAdds = commentsAdds;
    }

    /**
     * columnName COMMENTS_PAPERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsPapers() {
        return commentsPapers;
    }

    /**
     * columnName COMMENTS_PAPERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsPapers(String commentsPapers) {
        this.commentsPapers = commentsPapers;
    }

    /**
     * columnName COMMENTS_CERTIFICATES <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsCertificates() {
        return commentsCertificates;
    }

    /**
     * columnName COMMENTS_CERTIFICATES <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsCertificates(String commentsCertificates) {
        this.commentsCertificates = commentsCertificates;
    }

    /**
     * columnName COMMENTS_MANAGERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsManagers() {
        return commentsManagers;
    }

    /**
     * columnName COMMENTS_MANAGERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsManagers(String commentsManagers) {
        this.commentsManagers = commentsManagers;
    }

    /**
     * columnName COMMENTS_WORKERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsWorkers() {
        return commentsWorkers;
    }

    /**
     * columnName COMMENTS_WORKERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsWorkers(String commentsWorkers) {
        this.commentsWorkers = commentsWorkers;
    }

    /**
     * columnName COMMENTS_EQUIPMENTS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsEquipments() {
        return commentsEquipments;
    }

    /**
     * columnName COMMENTS_EQUIPMENTS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsEquipments(String commentsEquipments) {
        this.commentsEquipments = commentsEquipments;
    }

    /**
     * columnName COMMENTS_CUSTOMERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsCustomers() {
        return commentsCustomers;
    }

    /**
     * columnName COMMENTS_CUSTOMERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsCustomers(String commentsCustomers) {
        this.commentsCustomers = commentsCustomers;
    }

    /**
     * columnName COMMENTS_BIZSCOPE <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsBizscope() {
        return commentsBizscope;
    }

    /**
     * columnName COMMENTS_BIZSCOPE <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsBizscope(String commentsBizscope) {
        this.commentsBizscope = commentsBizscope;
    }

    /**
     * columnName COMMENTS_PARTNERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCommentsPartners() {
        return commentsPartners;
    }

    /**
     * columnName COMMENTS_PARTNERS <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCommentsPartners(String commentsPartners) {
        this.commentsPartners = commentsPartners;
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
     * columnName SUP_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupType() {
        return supType;
    }

    /**
     * columnName SUP_TYPE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupType(String supType) {
        this.supType = supType;
    }

    /**
     * columnName BUY_GROUP <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBuyGroup() {
        return buyGroup;
    }

    /**
     * columnName BUY_GROUP <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBuyGroup(String buyGroup) {
        this.buyGroup = buyGroup;
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
     * columnName SUP_GROUP <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupGroup() {
        return supGroup;
    }

    /**
     * columnName SUP_GROUP <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupGroup(String supGroup) {
        this.supGroup = supGroup;
    }

    /**
     * columnName SUP_CAL_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupCalStatus() {
        return supCalStatus;
    }

    /**
     * columnName SUP_CAL_STATUS <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupCalStatus(String supCalStatus) {
        this.supCalStatus = supCalStatus;
    }

    /**
     * columnName MONTH_SETTLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMonthSettle() {
        return monthSettle;
    }

    /**
     * columnName MONTH_SETTLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMonthSettle(String monthSettle) {
        this.monthSettle = monthSettle;
    }

    /**
     * columnName SUP_COOPERATION_WAY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSupCooperationWay() {
        return supCooperationWay;
    }

    /**
     * columnName SUP_COOPERATION_WAY <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupCooperationWay(String supCooperationWay) {
        this.supCooperationWay = supCooperationWay;
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
     * columnName COORDINATION <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCoordination() {
        return coordination;
    }

    /**
     * columnName COORDINATION <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCoordination(String coordination) {
        this.coordination = coordination;
    }

    /**
     * columnName EARNEST_STATUS <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEarnestStatus() {
        return earnestStatus;
    }

    /**
     * columnName EARNEST_STATUS <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEarnestStatus(String earnestStatus) {
        this.earnestStatus = earnestStatus;
    }

    /**
     * columnName REGISTERNO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRegisterno() {
        return registerno;
    }

    /**
     * columnName REGISTERNO <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    /**
     * columnName QG_NUMBER <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getQgNumber() {
        return qgNumber;
    }

    /**
     * columnName QG_NUMBER <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setQgNumber(String qgNumber) {
        this.qgNumber = qgNumber;
    }

    /**
     * columnName LXR <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLxr() {
        return lxr;
    }

    /**
     * columnName LXR <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    /**
     * columnName LXR_NUMBER <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLxrNumber() {
        return lxrNumber;
    }

    /**
     * columnName LXR_NUMBER <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLxrNumber(String lxrNumber) {
        this.lxrNumber = lxrNumber;
    }

    /**
     * columnName JX_COMMENTS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getJxComments() {
        return jxComments;
    }

    /**
     * columnName JX_COMMENTS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setJxComments(String jxComments) {
        this.jxComments = jxComments;
    }

    /**
     * columnName JX_ADDRESS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getJxAddress() {
        return jxAddress;
    }

    /**
     * columnName JX_ADDRESS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setJxAddress(String jxAddress) {
        this.jxAddress = jxAddress;
    }

    /**
     * columnName LXR_EMAIL <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLxrEmail() {
        return lxrEmail;
    }

    /**
     * columnName LXR_EMAIL <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLxrEmail(String lxrEmail) {
        this.lxrEmail = lxrEmail;
    }

    /**
     * columnName UR_KFY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getUrKfy() {
        return urKfy;
    }

    /**
     * columnName UR_KFY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setUrKfy(String urKfy) {
        this.urKfy = urKfy;
    }
}