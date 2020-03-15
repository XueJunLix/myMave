package com.ur.mro.sup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * TableName SRM_SUP_BANKINFO
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SUP_BANKINFO null")
public class SupBankInfo {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "BANKCODE", nullable = true, length = 150, precision = 0)
    private String bankcode;

    @ApiModelProperty(value = "null")
    @Column(name = "BANKNAME", nullable = true, length = 150, precision = 0)
    private String bankname;

    @ApiModelProperty(value = "null")
    @Column(name = "DEPOSITBANKNAME", nullable = true, length = 200, precision = 0)
    private String depositbankname;

    @ApiModelProperty(value = "null")
    @Column(name = "ACCOUNTNAME", nullable = true, length = 150, precision = 0)
    private String accountname;

    @ApiModelProperty(value = "null")
    @Column(name = "BANKACCOUNT", nullable = true, length = 150, precision = 0)
    private String bankaccount;

    @ApiModelProperty(value = "null")
    @Column(name = "SUPPLIER_ID", nullable = true, length = 19, precision = 0)
    private Integer supplierId;

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
    @Column(name = "NATION", nullable = true, length = 20, precision = 0)
    private String nation;

    @ApiModelProperty(value = "null")
    @Column(name = "PROVINCE", nullable = true, length = 20, precision = 0)
    private String province;

    @ApiModelProperty(value = "null")
    @Column(name = "CITY", nullable = true, length = 20, precision = 0)
    private String city;

    //开户许可证
    List<Attachment> kaihuFiles = new ArrayList<Attachment>();

    public List<Attachment> getKaihuFiles() {
        return this.kaihuFiles;
    }

    public void setKaihuFiles(List<Attachment> kaihuFiles) {
        this.kaihuFiles = kaihuFiles;
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
     * columnName BANKCODE <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBankcode() {
        return bankcode;
    }

    /**
     * columnName BANKCODE <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    /**
     * columnName BANKNAME <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * columnName BANKNAME <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * columnName DEPOSITBANKNAME <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDepositbankname() {
        return depositbankname;
    }

    /**
     * columnName DEPOSITBANKNAME <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDepositbankname(String depositbankname) {
        this.depositbankname = depositbankname;
    }

    /**
     * columnName ACCOUNTNAME <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAccountname() {
        return accountname;
    }

    /**
     * columnName ACCOUNTNAME <br/>
     * columnType nvarchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    /**
     * columnName BANKACCOUNT <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBankaccount() {
        return bankaccount;
    }

    /**
     * columnName BANKACCOUNT <br/>
     * columnType varchar 150 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    /**
     * columnName SUPPLIER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * columnName SUPPLIER_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
}