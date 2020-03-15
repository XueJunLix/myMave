package com.ur.bi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

/**
 * TableName config_month_standard
 * tableRemarks 月度标准值配置
 */
//TODO add Serializable implements
@ApiModel(description = "config_month_standard 月度标准值配置")
public class MonthStandard {
    @ApiModelProperty(value = "自增id")
    @Column(name = "id", nullable = false, length = 10, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "数据类型")
    @Column(name = "type", nullable = false, length = 100, precision = 0)
    private String type;

    @ApiModelProperty(value = "年份")
    @Column(name = "year", nullable = false, length = 10, precision = 0)
    private Integer year;

    @ApiModelProperty(value = "季节")
    @Column(name = "season", nullable = true, length = 10, precision = 0)
    private String season;

    @ApiModelProperty(value = "月份")
    @Column(name = "month", nullable = true, length = 10, precision = 0)
    private Integer month;

    @ApiModelProperty(value = "单号")
    @Column(name = "order_no", nullable = true, length = 20, precision = 0)
    private String orderNo;

    @ApiModelProperty(value = "")
    @Column(name = "plan_level", nullable = true, length = 10, precision = 0)
    private String planLevel;

    @ApiModelProperty(value = "销售级别")
    @Column(name = "sale_level", nullable = true, length = 10, precision = 0)
    private String saleLevel;

    @ApiModelProperty(value = "品牌编码")
    @Column(name = "brand", nullable = true, length = 10, precision = 0)
    private String brand;

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

    @ApiModelProperty(value = "中品类")
    @Column(name = "sub_category", nullable = true, length = 10, precision = 0)
    private String subCategory;

    @ApiModelProperty(value = "企划店铺编码")
    @Column(name = "plan_shop_no", nullable = true, length = 50, precision = 0)
    private String planShopNo;

    @ApiModelProperty(value = "店铺编码")
    @Column(name = "shop_no", nullable = true, length = 20, precision = 0)
    private String shopNo;

    @ApiModelProperty(value = "")
    @Column(name = "std_value", nullable = true, length = 10, precision = 2)
    private BigDecimal stdValue;

    @ApiModelProperty(value = "标准值上限")
    @Column(name = "std_max_value", nullable = true, length = 10, precision = 2)
    private BigDecimal stdMaxValue;

    @ApiModelProperty(value = "标准值下限")
    @Column(name = "std_min_value", nullable = true, length = 10, precision = 2)
    private BigDecimal stdMinValue;

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
     * columnName type <br/>
     * columnType VARCHAR 100 0 <br/>
     * columnRemarks 数据类型 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public String getType() {
        return type;
    }

    /**
     * columnName type <br/>
     * columnType VARCHAR 100 0 <br/>
     * columnRemarks 数据类型 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setType(String type) {
        this.type = StringUtils.isEmpty(type) ? null : type;
    }

    /**
     * columnName year <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 年份 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public Integer getYear() {
        return year;
    }

    /**
     * columnName year <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 年份 <br/>
     * isPK false <br/>
     * nullAble false <br/>
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * columnName season <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 季节 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSeason() {
        return season;
    }

    /**
     * columnName season <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 季节 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * columnName month <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 月份 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * columnName month <br/>
     * columnType INTEGER 10 0 <br/>
     * columnRemarks 月份 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * columnName order_no <br/>
     * columnType VARCHAR 20 0 <br/>
     * columnRemarks 单号 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * columnName order_no <br/>
     * columnType VARCHAR 20 0 <br/>
     * columnRemarks 单号 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * columnName plan_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks  <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPlanLevel() {
        return planLevel;
    }

    /**
     * columnName plan_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks  <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPlanLevel(String planLevel) {
        this.planLevel = planLevel;
    }

    /**
     * columnName sale_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 销售级别 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSaleLevel() {
        return saleLevel;
    }

    /**
     * columnName sale_level <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 销售级别 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSaleLevel(String saleLevel) {
        this.saleLevel = saleLevel;
    }

    /**
     * columnName brand <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 品牌编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBrand() {
        return brand;
    }

    /**
     * columnName brand <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 品牌编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * columnName sub_category <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 中品类 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * columnName sub_category <br/>
     * columnType VARCHAR 10 0 <br/>
     * columnRemarks 中品类 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * columnName plan_shop_no <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 企划店铺编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPlanShopNo() {
        return planShopNo;
    }

    /**
     * columnName plan_shop_no <br/>
     * columnType VARCHAR 50 0 <br/>
     * columnRemarks 企划店铺编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPlanShopNo(String planShopNo) {
        this.planShopNo = planShopNo;
    }

    /**
     * columnName shop_no <br/>
     * columnType VARCHAR 20 0 <br/>
     * columnRemarks 店铺编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * columnName shop_no <br/>
     * columnType VARCHAR 20 0 <br/>
     * columnRemarks 店铺编码 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * columnName std_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks  <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public BigDecimal getStdValue() {
        return stdValue;
    }

    /**
     * columnName std_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks  <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStdValue(BigDecimal stdValue) {
        this.stdValue = stdValue;
    }

    /**
     * columnName std_max_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks 标准值上限 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public BigDecimal getStdMaxValue() {
        return stdMaxValue;
    }

    /**
     * columnName std_max_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks 标准值上限 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStdMaxValue(BigDecimal stdMaxValue) {
        this.stdMaxValue = stdMaxValue;
    }

    /**
     * columnName std_min_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks 标准值下限 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public BigDecimal getStdMinValue() {
        return stdMinValue;
    }

    /**
     * columnName std_min_value <br/>
     * columnType DECIMAL 10 2 <br/>
     * columnRemarks 标准值下限 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStdMinValue(BigDecimal stdMinValue) {
        this.stdMinValue = stdMinValue;
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