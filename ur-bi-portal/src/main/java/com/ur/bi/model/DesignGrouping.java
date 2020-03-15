package com.ur.bi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.Table;
/**
 * TableName t_config_design_grouping
 * tableRemarks
 */
//TODO add Serializable implements
@ApiModel(description = "t_config_design_grouping")
@Table(name = "bi_design_grouping")
public class DesignGrouping {
    @ApiModelProperty(value = "自增id")
    @Id
    @GeneratedValue(generator = "JDBC")//返回自增长主键
    private Integer id;

    @ApiModelProperty(value = "设计分组")
    @Column(name = "design_grouping", length = 10, precision = 0)
    private String designGrouping;

    @ApiModelProperty(value = "系列")
    @Column(name = "serial", nullable = true, length = 10, precision = 0)
    private String serial;

    @ApiModelProperty(value = "原系列")
    @Column(name = "original_serial", nullable = true, length = 10, precision = 0)
    private String originalSerial;

    @ApiModelProperty(value = "风格")
    @Column(name = "style", nullable = true, length = 10, precision = 0)
    private String style;

    @ApiModelProperty(value = "商品层")
    @Column(name = "goods_level", nullable = true, length = 10, precision = 0)
    private String goodsLevel;

    @ApiModelProperty(value = "品类")
    @Column(name = "category", nullable = true, length = 10, precision = 0)
    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time", nullable = false, length = 19, precision = 0)
    private Date createTime;

    @ApiModelProperty(value = "创建者")
    @Column(name = "create_by", nullable = false, length = 50, precision = 0)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @Column(name = "modify_time", nullable = false, length = 19, precision = 0)
    private Date modifyTime;

    @ApiModelProperty(value = "修改者")
    @Column(name = "modify_by", nullable = false, length = 50, precision = 0)
    private String modifyBy;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "deleted", nullable = false, length = 50, precision = 0)
    private Integer deleted;

    public Integer getDeleted() {
        return deleted;
    }
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * columnName id <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 自增id <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public Integer getId() {
        return id;
    }

    /**
     * columnName id <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 自增id <br/>
     * isPK true <br/>
     * nullAble false <br/>
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * columnName design_grouping <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 设计分组 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getDesignGrouping() {
        return designGrouping;
    }

    /**
     * columnName design_grouping <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 设计分组 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setDesignGrouping(String designGrouping) {
        this.designGrouping = StringUtils.isEmpty(designGrouping) ? null : designGrouping;
    }

    /**
     * columnName serial <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 系列 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSerial() {
        return serial;
    }

    /**
     * columnName serial <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 系列 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * columnName original_serial <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 原系列 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOriginalSerial() {
        return originalSerial;
    }

    /**
     * columnName original_serial <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 原系列 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOriginalSerial(String originalSerial) {
        this.originalSerial = originalSerial;
    }

    /**
     * columnName style <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 风格 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStyle() {
        return style;
    }

    /**
     * columnName style <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 风格 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * columnName goods_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 商品层 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGoodsLevel() {
        return goodsLevel;
    }

    /**
     * columnName goods_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 商品层 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGoodsLevel(String goodsLevel) {
        this.goodsLevel = goodsLevel;
    }

    /**
     * columnName category <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 品类 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategory() {
        return category;
    }

    /**
     * columnName category <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 品类 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * columnName create_time <br/>
     * columnType TIMESTAMP 19 0 <br/>
     * columnRemarks 创建时间 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * columnName create_time <br/>
     * columnType TIMESTAMP 19 0 <br/>
     * columnRemarks 创建时间 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * columnName create_by <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 创建者 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * columnName create_by <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 创建者 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setCreateBy(String createBy) {
        this.createBy = StringUtils.isEmpty(createBy) ? null : createBy;
    }

    /**
     * columnName modify_time <br/>
     * columnType TIMESTAMP 19 0 <br/>
     * columnRemarks 修改时间 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * columnName modify_time <br/>
     * columnType TIMESTAMP 19 0 <br/>
     * columnRemarks 修改时间 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * columnName modify_by <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 修改者 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * columnName modify_by <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 修改者 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = StringUtils.isEmpty(modifyBy) ? null : modifyBy;
    }
}