package com.ur.mro.pic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName SRM_SYS_ATTACHMENT
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_SYS_ATTACHMENT null")
public class Attachment {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 20, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "NAME", nullable = true, length = 50, precision = 0)
    private String name;

    @ApiModelProperty(value = "null")
    @Column(name = "SIZE", nullable = true, length = 19, precision = 0)
    private Integer size;

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
    @Column(name = "ABBFILE_NAME", nullable = true, length = 50, precision = 0)
    private String abbFileName;

    @ApiModelProperty(value = "null")
    @Column(name = "FILE_NAME", nullable = true, length = 50, precision = 0)
    private String filaName;

    @ApiModelProperty(value = "null")
    @Column(name = "FILE_TYPE", nullable = true, length = 12, precision = 0)
    private String fileType;

    @ApiModelProperty(value = "null")
    @Column(name = "ROW_ID", nullable = true, length = 19, precision = 0)
    private Integer rowId;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 500, precision = 0)
    private String comments;

    @ApiModelProperty(value = "null")
    @Column(name = "COM1", nullable = true, length = 100, precision = 0)
    private String com1;

    @ApiModelProperty(value = "null")
    @Column(name = "COM2", nullable = true, length = 100, precision = 0)
    private String com2;

    @ApiModelProperty(value = "null")
    @Column(name = "CLASSNAME", nullable = true, length = 100, precision = 0)
    private String classname;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "IMAGE", nullable = true, length = 1, precision = 0)
    private Integer image;

    @ApiModelProperty(value = "null")
    @Column(name = "ASYC_IMAGE", nullable = false, length = 1, precision = 0)
    private Integer asycImage;

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
     * columnName NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getName() {
        return name;
    }

    /**
     * columnName NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * columnName SIZE <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getSize() {
        return size;
    }

    /**
     * columnName SIZE <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSize(Integer size) {
        this.size = size;
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
     * columnName ABBFILE_NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getAbbFileName() {
        return this.abbFileName;
    }

    public void setAbbFileName(String abbFileName) {
        this.abbFileName = abbFileName;
    }

    /**
     * columnName FILE_NAME <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFilaName() {
        return this.filaName;
    }

    public void setFilaName(String filaName) {
        this.filaName = filaName;
    }

    /**
     * columnName FILE_TYPE <br/>
     * columnType nvarchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * columnName FILE_TYPE <br/>
     * columnType nvarchar 12 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * columnName ROW_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getRowId() {
        return rowId;
    }

    /**
     * columnName ROW_ID <br/>
     * columnType bigint 19 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRowId(Integer rowId) {
        this.rowId = rowId;
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
     * columnName COM1 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCom1() {
        return com1;
    }

    /**
     * columnName COM1 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCom1(String com1) {
        this.com1 = com1;
    }

    /**
     * columnName COM2 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCom2() {
        return com2;
    }

    /**
     * columnName COM2 <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCom2(String com2) {
        this.com2 = com2;
    }

    /**
     * columnName CLASSNAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getClassname() {
        return classname;
    }

    /**
     * columnName CLASSNAME <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setClassname(String classname) {
        this.classname = classname;
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
     * columnName IMAGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getImage() {
        return image;
    }

    /**
     * columnName IMAGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setImage(Integer image) {
        this.image = image;
    }

    /**
     * columnName ASYC_IMAGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getAsycImage() {
        return asycImage;
    }

    /**
     * columnName ASYC_IMAGE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setAsycImage(Integer asycImage) {
        this.asycImage = asycImage;
    }
}