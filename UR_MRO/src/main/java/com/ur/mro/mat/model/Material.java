package com.ur.mro.mat.model;

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
 * TableName SRM_MAT_MATERIAL
 * tableRemarks null
 */
//TODO add Serializable implements
@ApiModel(description = "SRM_MAT_MATERIAL null")
public class Material {
    @ApiModelProperty(value = "null")
    @Column(name = "ID", nullable = false, length = 19, precision = 0)
    private Integer id;

    @ApiModelProperty(value = "null")
    @Column(name = "GROUP_ID", nullable = true, length = 20, precision = 0)
    private String groupId;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_TYPE", nullable = true, length = 10, precision = 0)
    private String matType;

    @ApiModelProperty(value = "null")
    @Column(name = "DESIGN_NO", nullable = true, length = 30, precision = 0)
    private String designNo;

    @ApiModelProperty(value = "null")
    @Column(name = "CODE", nullable = true, length = 30, precision = 0)
    private String code;

    @ApiModelProperty(value = "null")
    @Column(name = "GRID_NO", nullable = true, length = 30, precision = 0)
    private String gridNo;

    @ApiModelProperty(value = "null")
    @Column(name = "DEV_CODE_MAT", nullable = true, length = 30, precision = 0)
    private String devCodeMat;

    @ApiModelProperty(value = "null")
    @Column(name = "OLD_CODE_MAT", nullable = true, length = 30, precision = 0)
    private String oldCodeMat;

    @ApiModelProperty(value = "null")
    @Column(name = "NAME", nullable = true, length = 255, precision = 0)
    private String name;

    @ApiModelProperty(value = "null")
    @Column(name = "UNIT", nullable = true, length = 10, precision = 0)
    private String unit;

    @ApiModelProperty(value = "null")
    @Column(name = "SIDESEAL", nullable = true, length = 20, precision = 0)
    private String sideseal;

    @ApiModelProperty(value = "null")
    @Column(name = "GPERM2", nullable = true, length = 8, precision = 2)
    private String gperm2;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND_TYPE", nullable = true, length = 2, precision = 0)
    private String brandType;

    @ApiModelProperty(value = "null")
    @Column(name = "MODULE_NO", nullable = true, length = 20, precision = 0)
    private String moduleNo;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_A", nullable = true, length = 10, precision = 0)
    private String categoryA;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_B", nullable = true, length = 10, precision = 0)
    private String categoryB;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_C", nullable = true, length = 10, precision = 0)
    private String categoryC;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY_D", nullable = true, length = 10, precision = 0)
    private String categoryD;

    @ApiModelProperty(value = "null")
    @Column(name = "DENSITY", nullable = true, length = 20, precision = 0)
    private String density;

    @ApiModelProperty(value = "null")
    @Column(name = "YARN_SPEC", nullable = true, length = 200, precision = 0)
    private String yarnSpec;

    @ApiModelProperty(value = "null")
    @Column(name = "SHRINK_RATE", nullable = true, length = 20, precision = 0)
    private String shrinkRate;

    @ApiModelProperty(value = "null")
    @Column(name = "ING_DESCRIPTION", nullable = true, length = 255, precision = 0)
    private String ingDescription;

    @ApiModelProperty(value = "null")
    @Column(name = "ING_COMMENTS", nullable = true, length = 500, precision = 0)
    private String ingComments;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_SOURCE", nullable = true, length = 100, precision = 0)
    private String matSource;

    @ApiModelProperty(value = "null")
    @Column(name = "YEAR", nullable = true, length = 10, precision = 0)
    private Integer year;

    @ApiModelProperty(value = "null")
    @Column(name = "SEASON", nullable = true, length = 5, precision = 0)
    private String season;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_NO", nullable = true, length = 10, precision = 0)
    private String orderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PLAN_ORDER_NO", nullable = true, length = 10, precision = 0)
    private String planOrderNo;

    @ApiModelProperty(value = "null")
    @Column(name = "TYPE", nullable = true, length = 10, precision = 0)
    private String type;

    @ApiModelProperty(value = "null")
    @Column(name = "ORDER_TYPE", nullable = true, length = 20, precision = 0)
    private String orderType;

    @ApiModelProperty(value = "null")
    @Column(name = "SERIAL", nullable = true, length = 10, precision = 0)
    private String serial;

    @ApiModelProperty(value = "null")
    @Column(name = "STYLE", nullable = true, length = 10, precision = 0)
    private String style;

    @ApiModelProperty(value = "null")
    @Column(name = "BUSINESS_LEVEL", nullable = true, length = 5, precision = 0)
    private String businessLevel;

    @ApiModelProperty(value = "null")
    @Column(name = "CATEGORY", nullable = true, length = 5, precision = 0)
    private String category;

    @ApiModelProperty(value = "null")
    @Column(name = "SUB_CATEGORY", nullable = true, length = 5, precision = 0)
    private String subCategory;

    @ApiModelProperty(value = "null")
    @Column(name = "DESIGNER", nullable = true, length = 20, precision = 0)
    private String designer;

    @ApiModelProperty(value = "null")
    @Column(name = "STYLENAME_AUTO", nullable = true, length = 50, precision = 0)
    private String stylenameAuto;

    @ApiModelProperty(value = "null")
    @Column(name = "STYLENAME_CUSTOM", nullable = true, length = 50, precision = 0)
    private String stylenameCustom;

    @ApiModelProperty(value = "null")
    @Column(name = "SAMPLE", nullable = true, length = 10, precision = 0)
    private String sample;

    @ApiModelProperty(value = "null")
    @Column(name = "SILHOUETTE", nullable = true, length = 10, precision = 0)
    private String silhouette;

    @ApiModelProperty(value = "null")
    @Column(name = "FABRIC_FEATURES", nullable = true, length = 20, precision = 0)
    private String fabricFeatures;

    @ApiModelProperty(value = "null")
    @Column(name = "ELEMENT", nullable = true, length = 20, precision = 0)
    private String element;

    @ApiModelProperty(value = "null")
    @Column(name = "SLEEVE_TYPE", nullable = true, length = 20, precision = 0)
    private String sleeveType;

    @ApiModelProperty(value = "null")
    @Column(name = "COLLAR_TYPE", nullable = true, length = 20, precision = 0)
    private String collarType;

    @ApiModelProperty(value = "null")
    @Column(name = "CLO_LENGTH", nullable = true, length = 10, precision = 0)
    private String cloLength;

    @ApiModelProperty(value = "null")
    @Column(name = "SLEEVE_PANT_LENGTH", nullable = true, length = 10, precision = 0)
    private String sleevePantLength;

    @ApiModelProperty(value = "null")
    @Column(name = "THICKNESS", nullable = true, length = 20, precision = 0)
    private String thickness;

    @ApiModelProperty(value = "null")
    @Column(name = "BRAND", nullable = true, length = 20, precision = 0)
    private String brand;

    @ApiModelProperty(value = "null")
    @Column(name = "COMMENTS", nullable = true, length = 500, precision = 0)
    private String comments;

    @ApiModelProperty(value = "状态：0启用，1禁用")
    @Column(name = "STATUS", nullable = true, length = 5, precision = 0)
    private String status;

    @ApiModelProperty(value = "null")
    @Column(name = "SIZEGROUP_CODE", nullable = true, length = 20, precision = 0)
    private String sizegroupCode;

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
    @Column(name = "COST_PRICE", nullable = true, length = 10, precision = 2)
    private String costPrice;

    @ApiModelProperty(value = "null")
    @Column(name = "SPEC", nullable = true, length = 200, precision = 0)
    private String spec;

    @ApiModelProperty(value = "null")
    @Column(name = "DELETED", nullable = false, length = 1, precision = 0)
    private Integer deleted;

    @ApiModelProperty(value = "null")
    @Column(name = "EDITION", nullable = true, length = 255, precision = 0)
    private String edition;

    @ApiModelProperty(value = "null")
    @Column(name = "EDITION_TYPE", nullable = true, length = 255, precision = 0)
    private String editionType;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "INSALE_DATE", nullable = true, length = 27, precision = 7)
    private Date insaleDate;

    @ApiModelProperty(value = "null")
    @Column(name = "ITEM_NO", nullable = true, length = 10, precision = 0)
    private Integer itemNo;

    @ApiModelProperty(value = "null")
    @Column(name = "LENDER", nullable = true, length = 255, precision = 0)
    private String lender;

    @ApiModelProperty(value = "null")
    @Column(name = "MADER", nullable = true, length = 255, precision = 0)
    private String mader;

    @ApiModelProperty(value = "null")
    @Column(name = "MARK", nullable = true, length = 255, precision = 0)
    private String mark;

    @ApiModelProperty(value = "null")
    @Column(name = "OLD_STYLE_NO", nullable = true, length = 255, precision = 0)
    private String oldStyleNo;

    @ApiModelProperty(value = "null")
    @Column(name = "PAPER_SAMPLE", nullable = true, length = 255, precision = 0)
    private String paperSample;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "PIC_DATE", nullable = true, length = 27, precision = 7)
    private Date picDate;

    @ApiModelProperty(value = "null")
    @Column(name = "PLATE_TYPE", nullable = true, length = 255, precision = 0)
    private String plateType;

    @ApiModelProperty(value = "null")
    @Column(name = "POST_PROCESS", nullable = true, length = 255, precision = 0)
    private String postProcess;

    @ApiModelProperty(value = "null")
    @Column(name = "PRICE", nullable = true, length = 53, precision = 0)
    private String price;

    @ApiModelProperty(value = "null")
    @Column(name = "PRODUCT_NAME", nullable = true, length = 255, precision = 0)
    private String productName;

    @ApiModelProperty(value = "null")
    @Column(name = "QC", nullable = true, length = 255, precision = 0)
    private String qc;

    @ApiModelProperty(value = "null")
    @Column(name = "SAMPLE_SIZE", nullable = true, length = 255, precision = 0)
    private String sampleSize;

    @ApiModelProperty(value = "null")
    @Column(name = "SKU", nullable = true, length = 255, precision = 0)
    private String sku;

    @ApiModelProperty(value = "null")
    @Column(name = "SMP_STATUS_MARK", nullable = true, length = 255, precision = 0)
    private String smpStatusMark;

    @ApiModelProperty(value = "null")
    @Column(name = "STOCK_SPACE", nullable = true, length = 255, precision = 0)
    private String stockSpace;

    @ApiModelProperty(value = "null")
    @Column(name = "STYLE_SOURCE", nullable = true, length = 255, precision = 0)
    private String styleSource;

    @ApiModelProperty(value = "null")
    @Column(name = "TAIL", nullable = true, length = 255, precision = 0)
    private String tail;

    @ApiModelProperty(value = "null")
    @Column(name = "TAILOR", nullable = true, length = 255, precision = 0)
    private String tailor;

    @ApiModelProperty(value = "null")
    @Column(name = "ATTACHMENT_ID", nullable = true, length = 10, precision = 0)
    private Integer attachmentId;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_GROUP", nullable = true, length = 255, precision = 0)
    private String matGroup;

    @ApiModelProperty(value = "null")
    @Column(name = "buy_Group", nullable = true, length = 2, precision = 0)
    private String buyGroup;

    @ApiModelProperty(value = "null")
    @Column(name = "REMARKS", nullable = true, length = 1000, precision = 0)
    private String remarks;

    @ApiModelProperty(value = "null")
    @Column(name = "DESIGNER_NAME", nullable = true, length = 255, precision = 0)
    private String designerName;

    @ApiModelProperty(value = "null")
    @Column(name = "SB_STATUS", nullable = true, length = 255, precision = 0)
    private String sbStatus;

    @ApiModelProperty(value = "null")
    @Column(name = "SKU_COUNT", nullable = true, length = 10, precision = 0)
    private Integer skuCount;

    @ApiModelProperty(value = "null")
    @Column(name = "MONTH_SETTLE", nullable = true, length = 255, precision = 0)
    private String monthSettle;

    @ApiModelProperty(value = "null")
    @Column(name = "DEM_FLAG", nullable = true, length = 1, precision = 0)
    private Integer demFlag;

    @ApiModelProperty(value = "null")
    @Column(name = "SLEEVE_LENGTH", nullable = true, length = 10, precision = 0)
    private String sleeveLength;

    @ApiModelProperty(value = "null")
    @Column(name = "DB_TYPE", nullable = true, length = 30, precision = 0)
    private String dbType;

    @ApiModelProperty(value = "null")
    @Column(name = "REF_SAMPLE_CODE", nullable = true, length = 30, precision = 0)
    private String refSampleCode;

    @ApiModelProperty(value = "null")
    @Column(name = "OLD_STYLE", nullable = true, length = 30, precision = 0)
    private String oldStyle;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_NO", nullable = true, length = 30, precision = 0)
    private String applyNo;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLY_SAMPLE", nullable = true, length = 10, precision = 0)
    private String applySample;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "BELOW_DATE", nullable = true, length = 27, precision = 7)
    private Date belowDate;

    @ApiModelProperty(value = "null")
    @Column(name = "ESTIMATE_PRICE", nullable = true, length = 18, precision = 2)
    private String estimatePrice;

    @ApiModelProperty(value = "null")
    @Column(name = "PROCESSING_MODE", nullable = true, length = 10, precision = 0)
    private String processingMode;

    @ApiModelProperty(value = "null")
    @Column(name = "SIZE_MARK", nullable = true, length = 255, precision = 0)
    private String sizeMark;

    @ApiModelProperty(value = "null")
    @Column(name = "PRODUCT_CODE", nullable = true, length = 30, precision = 0)
    private String productCode;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_BY", nullable = true, length = 50, precision = 0)
    private String purchaseBy;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASE_AMOUMT", nullable = true, length = 18, precision = 2)
    private String purchaseAmoumt;

    @ApiModelProperty(value = "null")
    @Column(name = "ORIGINAL_CUSTOMER", nullable = true, length = 50, precision = 0)
    private String originalCustomer;

    @ApiModelProperty(value = "null")
    @Column(name = "REF_DESIGN_NO", nullable = true, length = 30, precision = 0)
    private String refDesignNo;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_PRO", nullable = true, length = 5, precision = 0)
    private String isPro;

    @ApiModelProperty(value = "null")
    @Column(name = "ESTIMATE_COST", nullable = true, length = 18, precision = 2)
    private String estimateCost;

    @ApiModelProperty(value = "null")
    @Column(name = "RETAIL_PRICE", nullable = true, length = 18, precision = 2)
    private String retailPrice;

    @ApiModelProperty(value = "null")
    @Column(name = "IN_OQR_MAKE_ORDER", nullable = true, length = 1, precision = 0)
    private Integer inOqrMakeOrder;

    @ApiModelProperty(value = "null")
    @Column(name = "COMPREHENSIVE_COST", nullable = true, length = 18, precision = 2)
    private String comprehensiveCost;

    @ApiModelProperty(value = "null")
    @Column(name = "APPLICATION_CATEGORY", nullable = true, length = 255, precision = 0)
    private String applicationCategory;

    @ApiModelProperty(value = "null")
    @Column(name = "PURCHASED_COLOR", nullable = true, length = 255, precision = 0)
    private String purchasedColor;

    @ApiModelProperty(value = "null")
    @Column(name = "OVERSEAS_PURCHASE", nullable = true, length = 1, precision = 0)
    private Integer overseasPurchase;

    @ApiModelProperty(value = "null")
    @Column(name = "SALES_TRACKING", nullable = true, length = 20, precision = 0)
    private String salesTracking;

    @ApiModelProperty(value = "null")
    @Column(name = "CURRENT_HOLDER", nullable = true, length = 20, precision = 0)
    private String currentHolder;

    @ApiModelProperty(value = "null")
    @Column(name = "DELIVER_GOODS", nullable = true, length = 1, precision = 0)
    private Integer deliverGoods;

    @ApiModelProperty(value = "null")
    @Column(name = "CONSIGNOR", nullable = true, length = 20, precision = 0)
    private String consignor;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "DELIVERY_TIME", nullable = true, length = 27, precision = 7)
    private Date deliveryTime;

    @ApiModelProperty(value = "null")
    @Column(name = "GOODS_RECEIP", nullable = true, length = 1, precision = 0)
    private Integer goodsReceip;

    @ApiModelProperty(value = "null")
    @Column(name = "CONSIGNEE", nullable = true, length = 20, precision = 0)
    private String consignee;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "RECEIP_TIME", nullable = true, length = 27, precision = 7)
    private Date receipTime;

    @ApiModelProperty(value = "null")
    @Column(name = "SHIPPING_NOTE", nullable = true, length = 255, precision = 0)
    private String shippingNote;

    @ApiModelProperty(value = "null")
    @Column(name = "RECEIPT_NOTE", nullable = true, length = 255, precision = 0)
    private String receiptNote;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "PROCUREMENT_TIME", nullable = true, length = 27, precision = 7)
    private Date procurementTime;

    @ApiModelProperty(value = "null")
    @Column(name = "CHARACTERISTIC", nullable = true, length = 20, precision = 0)
    private String characteristic;

    @ApiModelProperty(value = "null")
    @Column(name = "PRODUCTION_CATEGORY", nullable = true, length = 20, precision = 0)
    private String productionCategory;

    @ApiModelProperty(value = "null")
    @Column(name = "PARTICIPATE_PRICE", nullable = true, length = 1, precision = 0)
    private Integer participatePrice;

    @ApiModelProperty(value = "null")
    @Column(name = "PRICING_PEOPLE", nullable = true, length = 50, precision = 0)
    private String pricingPeople;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "PRICING_TIME", nullable = true, length = 23, precision = 3)
    private Date pricingTime;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_PRICED", nullable = true, length = 10, precision = 0)
    private String isPriced;

    @ApiModelProperty(value = "null")
    @Column(name = "MATERIAL_CZ", nullable = true, length = 50, precision = 0)
    private String materialCz;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_TYPE", nullable = true, length = 20, precision = 0)
    private String poType;

    @ApiModelProperty(value = "null")
    @Column(name = "MAKE_IE", nullable = true, length = 255, precision = 0)
    private String makeIe;

    @ApiModelProperty(value = "null")
    @Column(name = "SAFE_INV", nullable = true, length = 18, precision = 0)
    private Double safeInv;

    @ApiModelProperty(value = "null")
    @Column(name = "STANDER_PRICE", nullable = true, length = 18, precision = 0)
    private String standerPrice;

    @ApiModelProperty(value = "null")
    @Column(name = "PO_TQDATE", nullable = true, length = 10, precision = 0)
    private Integer poTqdate;

    @ApiModelProperty(value = "null")
    @Column(name = "DJ_TYPE", nullable = true, length = 50, precision = 0)
    private String djType;

    @ApiModelProperty(value = "null")
    @Column(name = "COLOR", nullable = true, length = 50, precision = 0)
    private String color;

    @ApiModelProperty(value = "null")
    @Column(name = "CLOPURCHASE", nullable = true, length = 50, precision = 0)
    private String clopurchase;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "null")
    @Column(name = "CLOPURCHASE_TIME", nullable = true, length = 27, precision = 7)
    private Date clopurchaseTime;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_IMAGE", nullable = true, length = 100, precision = 0)
    private String shopImage;

    @ApiModelProperty(value = "null")
    @Column(name = "SHOP_IMAGE_NAME", nullable = true, length = 200, precision = 0)
    private String shopImageName;

    @ApiModelProperty(value = "null")
    @Column(name = "IS_ZCGL", nullable = true, length = 1, precision = 0)
    private Integer isZcgl;

    @ApiModelProperty(value = "null")
    @Column(name = "MAT_DEPICT", nullable = true, length = 500, precision = 0)
    private String matDepict;


    @ApiModelProperty(value = "null")
    @Column(name = "SYQY", nullable = true, length = 50, precision = 0)
    private String syqy;

    @ApiModelProperty(value = "null")
    @Column(name = "GLDBD", nullable = true, length = 100, precision = 0)
    private String gldbd;

    @ApiModelProperty(value = "null")
    @Column(name = "CHANG", nullable = true, length = 18, precision = 2)
    private Double chang;

    @ApiModelProperty(value = "null")
    @Column(name = "KUAN", nullable = true, length = 18, precision = 2)
    private Double kuan;

    @ApiModelProperty(value = "null")
    @Column(name = "GAO", nullable = true, length = 18, precision = 2)
    private Double gao;

    List<MaterialInfo>  materialInfoList  = new ArrayList<MaterialInfo>();

    public List<MaterialInfo> getMaterialInfoList() {
        return this.materialInfoList;
    }

    public void setMaterialInfoList(List<MaterialInfo> materialInfoList) {
        this.materialInfoList = materialInfoList;
    }

    List<Attachment> files = new ArrayList<Attachment>();

    List<Attachment> doCfiles = new ArrayList<Attachment>();

    public List<Attachment> getDoCfiles() {
        return this.doCfiles;
    }

    public void setDoCfiles(List<Attachment> doCfiles) {
        this.doCfiles = doCfiles;
    }

    List<String> checkPictureList = new ArrayList<String>();

    public List<String> getCheckPictureList() {
        return this.checkPictureList;
    }

    public void setCheckPictureList(List<String> checkPictureList) {
        this.checkPictureList = checkPictureList;
    }

    public List<Attachment> getFiles() {
        return this.files;
    }

    public void setFiles(List<Attachment> files) {
        this.files = files;
    }

    public String getSyqy() {
        return this.syqy;
    }

    public void setSyqy(String syqy) {
        this.syqy = syqy;
    }

    public String getGldbd() {
        return this.gldbd;
    }

    public void setGldbd(String gldbd) {
        this.gldbd = gldbd;
    }

    public Double getChang() {
        return this.chang;
    }

    public void setChang(Double chang) {
        this.chang = chang;
    }

    public Double getKuan() {
        return this.kuan;
    }

    public void setKuan(Double kuan) {
        this.kuan = kuan;
    }

    public Double getGao() {
        return this.gao;
    }

    public void setGao(Double gao) {
        this.gao = gao;
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
     * columnName MAT_TYPE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatType() {
        return matType;
    }

    /**
     * columnName MAT_TYPE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatType(String matType) {
        this.matType = matType;
    }

    /**
     * columnName DESIGN_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDesignNo() {
        return designNo;
    }

    /**
     * columnName DESIGN_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDesignNo(String designNo) {
        this.designNo = designNo;
    }

    /**
     * columnName CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCode() {
        return code;
    }

    /**
     * columnName CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * columnName GRID_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGridNo() {
        return gridNo;
    }

    /**
     * columnName GRID_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGridNo(String gridNo) {
        this.gridNo = gridNo;
    }

    /**
     * columnName DEV_CODE_MAT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDevCodeMat() {
        return devCodeMat;
    }

    /**
     * columnName DEV_CODE_MAT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDevCodeMat(String devCodeMat) {
        this.devCodeMat = devCodeMat;
    }

    /**
     * columnName OLD_CODE_MAT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOldCodeMat() {
        return oldCodeMat;
    }

    /**
     * columnName OLD_CODE_MAT <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOldCodeMat(String oldCodeMat) {
        this.oldCodeMat = oldCodeMat;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getName() {
        return name;
    }

    /**
     * columnName NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * columnName UNIT <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getUnit() {
        return unit;
    }

    /**
     * columnName UNIT <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * columnName SIDESEAL <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSideseal() {
        return sideseal;
    }

    /**
     * columnName SIDESEAL <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSideseal(String sideseal) {
        this.sideseal = sideseal;
    }

    /**
     * columnName GPERM2 <br/>
     * columnType numeric 8 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getGperm2() {
        return gperm2;
    }

    /**
     * columnName GPERM2 <br/>
     * columnType numeric 8 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGperm2(String gperm2) {
        this.gperm2 = gperm2;
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
     * columnName MODULE_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getModuleNo() {
        return moduleNo;
    }

    /**
     * columnName MODULE_NO <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * columnName CATEGORY_A <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryA() {
        return categoryA;
    }

    /**
     * columnName CATEGORY_A <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryA(String categoryA) {
        this.categoryA = categoryA;
    }

    /**
     * columnName CATEGORY_B <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryB() {
        return categoryB;
    }

    /**
     * columnName CATEGORY_B <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryB(String categoryB) {
        this.categoryB = categoryB;
    }

    /**
     * columnName CATEGORY_C <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryC() {
        return categoryC;
    }

    /**
     * columnName CATEGORY_C <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryC(String categoryC) {
        this.categoryC = categoryC;
    }

    /**
     * columnName CATEGORY_D <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategoryD() {
        return categoryD;
    }

    /**
     * columnName CATEGORY_D <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategoryD(String categoryD) {
        this.categoryD = categoryD;
    }

    /**
     * columnName DENSITY <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDensity() {
        return density;
    }

    /**
     * columnName DENSITY <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDensity(String density) {
        this.density = density;
    }

    /**
     * columnName YARN_SPEC <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getYarnSpec() {
        return yarnSpec;
    }

    /**
     * columnName YARN_SPEC <br/>
     * columnType nvarchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setYarnSpec(String yarnSpec) {
        this.yarnSpec = yarnSpec;
    }

    /**
     * columnName SHRINK_RATE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShrinkRate() {
        return shrinkRate;
    }

    /**
     * columnName SHRINK_RATE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShrinkRate(String shrinkRate) {
        this.shrinkRate = shrinkRate;
    }

    /**
     * columnName ING_DESCRIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIngDescription() {
        return ingDescription;
    }

    /**
     * columnName ING_DESCRIPTION <br/>
     * columnType nvarchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIngDescription(String ingDescription) {
        this.ingDescription = ingDescription;
    }

    /**
     * columnName ING_COMMENTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIngComments() {
        return ingComments;
    }

    /**
     * columnName ING_COMMENTS <br/>
     * columnType nvarchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIngComments(String ingComments) {
        this.ingComments = ingComments;
    }

    /**
     * columnName MAT_SOURCE <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatSource() {
        return matSource;
    }

    /**
     * columnName MAT_SOURCE <br/>
     * columnType nvarchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatSource(String matSource) {
        this.matSource = matSource;
    }

    /**
     * columnName YEAR <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getYear() {
        return year;
    }

    /**
     * columnName YEAR <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * columnName SEASON <br/>
     * columnType nvarchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSeason() {
        return season;
    }

    /**
     * columnName SEASON <br/>
     * columnType nvarchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * columnName ORDER_NO <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * columnName ORDER_NO <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * columnName PLAN_ORDER_NO <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPlanOrderNo() {
        return planOrderNo;
    }

    /**
     * columnName PLAN_ORDER_NO <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPlanOrderNo(String planOrderNo) {
        this.planOrderNo = planOrderNo;
    }

    /**
     * columnName TYPE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getType() {
        return type;
    }

    /**
     * columnName TYPE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * columnName ORDER_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * columnName ORDER_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * columnName SERIAL <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSerial() {
        return serial;
    }

    /**
     * columnName SERIAL <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * columnName STYLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStyle() {
        return style;
    }

    /**
     * columnName STYLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * columnName BUSINESS_LEVEL <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBusinessLevel() {
        return businessLevel;
    }

    /**
     * columnName BUSINESS_LEVEL <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBusinessLevel(String businessLevel) {
        this.businessLevel = businessLevel;
    }

    /**
     * columnName CATEGORY <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCategory() {
        return category;
    }

    /**
     * columnName CATEGORY <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * columnName SUB_CATEGORY <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * columnName SUB_CATEGORY <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * columnName DESIGNER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * columnName DESIGNER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * columnName STYLENAME_AUTO <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStylenameAuto() {
        return stylenameAuto;
    }

    /**
     * columnName STYLENAME_AUTO <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStylenameAuto(String stylenameAuto) {
        this.stylenameAuto = stylenameAuto;
    }

    /**
     * columnName STYLENAME_CUSTOM <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStylenameCustom() {
        return stylenameCustom;
    }

    /**
     * columnName STYLENAME_CUSTOM <br/>
     * columnType nvarchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStylenameCustom(String stylenameCustom) {
        this.stylenameCustom = stylenameCustom;
    }

    /**
     * columnName SAMPLE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSample() {
        return sample;
    }

    /**
     * columnName SAMPLE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSample(String sample) {
        this.sample = sample;
    }

    /**
     * columnName SILHOUETTE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSilhouette() {
        return silhouette;
    }

    /**
     * columnName SILHOUETTE <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSilhouette(String silhouette) {
        this.silhouette = silhouette;
    }

    /**
     * columnName FABRIC_FEATURES <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getFabricFeatures() {
        return fabricFeatures;
    }

    /**
     * columnName FABRIC_FEATURES <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setFabricFeatures(String fabricFeatures) {
        this.fabricFeatures = fabricFeatures;
    }

    /**
     * columnName ELEMENT <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getElement() {
        return element;
    }

    /**
     * columnName ELEMENT <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * columnName SLEEVE_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSleeveType() {
        return sleeveType;
    }

    /**
     * columnName SLEEVE_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    /**
     * columnName COLLAR_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCollarType() {
        return collarType;
    }

    /**
     * columnName COLLAR_TYPE <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCollarType(String collarType) {
        this.collarType = collarType;
    }

    /**
     * columnName CLO_LENGTH <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCloLength() {
        return cloLength;
    }

    /**
     * columnName CLO_LENGTH <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCloLength(String cloLength) {
        this.cloLength = cloLength;
    }

    /**
     * columnName SLEEVE_PANT_LENGTH <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSleevePantLength() {
        return sleevePantLength;
    }

    /**
     * columnName SLEEVE_PANT_LENGTH <br/>
     * columnType nvarchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSleevePantLength(String sleevePantLength) {
        this.sleevePantLength = sleevePantLength;
    }

    /**
     * columnName THICKNESS <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getThickness() {
        return thickness;
    }

    /**
     * columnName THICKNESS <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    /**
     * columnName BRAND <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBrand() {
        return brand;
    }

    /**
     * columnName BRAND <br/>
     * columnType nvarchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * columnName STATUS <br/>
     * columnType nvarchar 5 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * columnName STATUS <br/>
     * columnType nvarchar 5 0 <br/>
     * columnRemarks 状态：0启用，1禁用 <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * columnName SIZEGROUP_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSizegroupCode() {
        return sizegroupCode;
    }

    /**
     * columnName SIZEGROUP_CODE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSizegroupCode(String sizegroupCode) {
        this.sizegroupCode = sizegroupCode;
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
     * columnName COST_PRICE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCostPrice() {
        return costPrice;
    }

    /**
     * columnName COST_PRICE <br/>
     * columnType numeric 10 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * columnName SPEC <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSpec() {
        return spec;
    }

    /**
     * columnName SPEC <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSpec(String spec) {
        this.spec = spec;
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
     * columnName EDITION <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEdition() {
        return edition;
    }

    /**
     * columnName EDITION <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * columnName EDITION_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEditionType() {
        return editionType;
    }

    /**
     * columnName EDITION_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    /**
     * columnName INSALE_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getInsaleDate() {
        return insaleDate;
    }

    /**
     * columnName INSALE_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setInsaleDate(Date insaleDate) {
        this.insaleDate = insaleDate;
    }

    /**
     * columnName ITEM_NO <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getItemNo() {
        return itemNo;
    }

    /**
     * columnName ITEM_NO <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * columnName LENDER <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getLender() {
        return lender;
    }

    /**
     * columnName LENDER <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setLender(String lender) {
        this.lender = lender;
    }

    /**
     * columnName MADER <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMader() {
        return mader;
    }

    /**
     * columnName MADER <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMader(String mader) {
        this.mader = mader;
    }

    /**
     * columnName MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMark() {
        return mark;
    }

    /**
     * columnName MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * columnName OLD_STYLE_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOldStyleNo() {
        return oldStyleNo;
    }

    /**
     * columnName OLD_STYLE_NO <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOldStyleNo(String oldStyleNo) {
        this.oldStyleNo = oldStyleNo;
    }

    /**
     * columnName PAPER_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPaperSample() {
        return paperSample;
    }

    /**
     * columnName PAPER_SAMPLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPaperSample(String paperSample) {
        this.paperSample = paperSample;
    }

    /**
     * columnName PIC_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getPicDate() {
        return picDate;
    }

    /**
     * columnName PIC_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPicDate(Date picDate) {
        this.picDate = picDate;
    }

    /**
     * columnName PLATE_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPlateType() {
        return plateType;
    }

    /**
     * columnName PLATE_TYPE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    /**
     * columnName POST_PROCESS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPostProcess() {
        return postProcess;
    }

    /**
     * columnName POST_PROCESS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPostProcess(String postProcess) {
        this.postProcess = postProcess;
    }

    /**
     * columnName PRICE <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPrice() {
        return price;
    }

    /**
     * columnName PRICE <br/>
     * columnType float 53 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * columnName PRODUCT_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProductName() {
        return productName;
    }

    /**
     * columnName PRODUCT_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * columnName QC <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getQc() {
        return qc;
    }

    /**
     * columnName QC <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setQc(String qc) {
        this.qc = qc;
    }

    /**
     * columnName SAMPLE_SIZE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSampleSize() {
        return sampleSize;
    }

    /**
     * columnName SAMPLE_SIZE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSampleSize(String sampleSize) {
        this.sampleSize = sampleSize;
    }

    /**
     * columnName SKU <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSku() {
        return sku;
    }

    /**
     * columnName SKU <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * columnName SMP_STATUS_MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSmpStatusMark() {
        return smpStatusMark;
    }

    /**
     * columnName SMP_STATUS_MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSmpStatusMark(String smpStatusMark) {
        this.smpStatusMark = smpStatusMark;
    }

    /**
     * columnName STOCK_SPACE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStockSpace() {
        return stockSpace;
    }

    /**
     * columnName STOCK_SPACE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStockSpace(String stockSpace) {
        this.stockSpace = stockSpace;
    }

    /**
     * columnName STYLE_SOURCE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getStyleSource() {
        return styleSource;
    }

    /**
     * columnName STYLE_SOURCE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStyleSource(String styleSource) {
        this.styleSource = styleSource;
    }

    /**
     * columnName TAIL <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTail() {
        return tail;
    }

    /**
     * columnName TAIL <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTail(String tail) {
        this.tail = tail;
    }

    /**
     * columnName TAILOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getTailor() {
        return tailor;
    }

    /**
     * columnName TAILOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setTailor(String tailor) {
        this.tailor = tailor;
    }

    /**
     * columnName ATTACHMENT_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getAttachmentId() {
        return attachmentId;
    }

    /**
     * columnName ATTACHMENT_ID <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * columnName MAT_GROUP <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatGroup() {
        return matGroup;
    }

    /**
     * columnName MAT_GROUP <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatGroup(String matGroup) {
        this.matGroup = matGroup;
    }

    /**
     * columnName buy_Group <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getBuyGroup() {
        return buyGroup;
    }

    /**
     * columnName buy_Group <br/>
     * columnType varchar 2 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBuyGroup(String buyGroup) {
        this.buyGroup = buyGroup;
    }

    /**
     * columnName REMARKS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * columnName REMARKS <br/>
     * columnType varchar 1000 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * columnName DESIGNER_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDesignerName() {
        return designerName;
    }

    /**
     * columnName DESIGNER_NAME <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    /**
     * columnName SB_STATUS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSbStatus() {
        return sbStatus;
    }

    /**
     * columnName SB_STATUS <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSbStatus(String sbStatus) {
        this.sbStatus = sbStatus;
    }

    /**
     * columnName SKU_COUNT <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getSkuCount() {
        return skuCount;
    }

    /**
     * columnName SKU_COUNT <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    /**
     * columnName MONTH_SETTLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMonthSettle() {
        return monthSettle;
    }

    /**
     * columnName MONTH_SETTLE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMonthSettle(String monthSettle) {
        this.monthSettle = monthSettle;
    }

    /**
     * columnName DEM_FLAG <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getDemFlag() {
        return demFlag;
    }

    /**
     * columnName DEM_FLAG <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDemFlag(Integer demFlag) {
        this.demFlag = demFlag;
    }

    /**
     * columnName SLEEVE_LENGTH <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSleeveLength() {
        return sleeveLength;
    }

    /**
     * columnName SLEEVE_LENGTH <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    /**
     * columnName DB_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * columnName DB_TYPE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * columnName REF_SAMPLE_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRefSampleCode() {
        return refSampleCode;
    }

    /**
     * columnName REF_SAMPLE_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRefSampleCode(String refSampleCode) {
        this.refSampleCode = refSampleCode;
    }

    /**
     * columnName OLD_STYLE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOldStyle() {
        return oldStyle;
    }

    /**
     * columnName OLD_STYLE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOldStyle(String oldStyle) {
        this.oldStyle = oldStyle;
    }

    /**
     * columnName APPLY_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * columnName APPLY_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    /**
     * columnName APPLY_SAMPLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplySample() {
        return applySample;
    }

    /**
     * columnName APPLY_SAMPLE <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplySample(String applySample) {
        this.applySample = applySample;
    }

    /**
     * columnName BELOW_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getBelowDate() {
        return belowDate;
    }

    /**
     * columnName BELOW_DATE <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setBelowDate(Date belowDate) {
        this.belowDate = belowDate;
    }

    /**
     * columnName ESTIMATE_PRICE <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEstimatePrice() {
        return estimatePrice;
    }

    /**
     * columnName ESTIMATE_PRICE <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEstimatePrice(String estimatePrice) {
        this.estimatePrice = estimatePrice;
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
     * columnName SIZE_MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSizeMark() {
        return sizeMark;
    }

    /**
     * columnName SIZE_MARK <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSizeMark(String sizeMark) {
        this.sizeMark = sizeMark;
    }

    /**
     * columnName PRODUCT_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * columnName PRODUCT_CODE <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseBy() {
        return purchaseBy;
    }

    /**
     * columnName PURCHASE_BY <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseBy(String purchaseBy) {
        this.purchaseBy = purchaseBy;
    }

    /**
     * columnName PURCHASE_AMOUMT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchaseAmoumt() {
        return purchaseAmoumt;
    }

    /**
     * columnName PURCHASE_AMOUMT <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchaseAmoumt(String purchaseAmoumt) {
        this.purchaseAmoumt = purchaseAmoumt;
    }

    /**
     * columnName ORIGINAL_CUSTOMER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getOriginalCustomer() {
        return originalCustomer;
    }

    /**
     * columnName ORIGINAL_CUSTOMER <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOriginalCustomer(String originalCustomer) {
        this.originalCustomer = originalCustomer;
    }

    /**
     * columnName REF_DESIGN_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRefDesignNo() {
        return refDesignNo;
    }

    /**
     * columnName REF_DESIGN_NO <br/>
     * columnType varchar 30 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRefDesignNo(String refDesignNo) {
        this.refDesignNo = refDesignNo;
    }

    /**
     * columnName IS_PRO <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsPro() {
        return isPro;
    }

    /**
     * columnName IS_PRO <br/>
     * columnType varchar 5 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsPro(String isPro) {
        this.isPro = isPro;
    }

    /**
     * columnName ESTIMATE_COST <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getEstimateCost() {
        return estimateCost;
    }

    /**
     * columnName ESTIMATE_COST <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setEstimateCost(String estimateCost) {
        this.estimateCost = estimateCost;
    }

    /**
     * columnName RETAIL_PRICE <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getRetailPrice() {
        return retailPrice;
    }

    /**
     * columnName RETAIL_PRICE <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * columnName IN_OQR_MAKE_ORDER <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getInOqrMakeOrder() {
        return inOqrMakeOrder;
    }

    /**
     * columnName IN_OQR_MAKE_ORDER <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setInOqrMakeOrder(Integer inOqrMakeOrder) {
        this.inOqrMakeOrder = inOqrMakeOrder;
    }

    /**
     * columnName COMPREHENSIVE_COST <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getComprehensiveCost() {
        return comprehensiveCost;
    }

    /**
     * columnName COMPREHENSIVE_COST <br/>
     * columnType numeric 18 2 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setComprehensiveCost(String comprehensiveCost) {
        this.comprehensiveCost = comprehensiveCost;
    }

    /**
     * columnName APPLICATION_CATEGORY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getApplicationCategory() {
        return applicationCategory;
    }

    /**
     * columnName APPLICATION_CATEGORY <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setApplicationCategory(String applicationCategory) {
        this.applicationCategory = applicationCategory;
    }

    /**
     * columnName PURCHASED_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPurchasedColor() {
        return purchasedColor;
    }

    /**
     * columnName PURCHASED_COLOR <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPurchasedColor(String purchasedColor) {
        this.purchasedColor = purchasedColor;
    }

    /**
     * columnName OVERSEAS_PURCHASE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getOverseasPurchase() {
        return overseasPurchase;
    }

    /**
     * columnName OVERSEAS_PURCHASE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setOverseasPurchase(Integer overseasPurchase) {
        this.overseasPurchase = overseasPurchase;
    }

    /**
     * columnName SALES_TRACKING <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getSalesTracking() {
        return salesTracking;
    }

    /**
     * columnName SALES_TRACKING <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setSalesTracking(String salesTracking) {
        this.salesTracking = salesTracking;
    }

    /**
     * columnName CURRENT_HOLDER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCurrentHolder() {
        return currentHolder;
    }

    /**
     * columnName CURRENT_HOLDER <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    /**
     * columnName DELIVER_GOODS <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getDeliverGoods() {
        return deliverGoods;
    }

    /**
     * columnName DELIVER_GOODS <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliverGoods(Integer deliverGoods) {
        this.deliverGoods = deliverGoods;
    }

    /**
     * columnName CONSIGNOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getConsignor() {
        return consignor;
    }

    /**
     * columnName CONSIGNOR <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    /**
     * columnName DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * columnName DELIVERY_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * columnName GOODS_RECEIP <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getGoodsReceip() {
        return goodsReceip;
    }

    /**
     * columnName GOODS_RECEIP <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setGoodsReceip(Integer goodsReceip) {
        this.goodsReceip = goodsReceip;
    }

    /**
     * columnName CONSIGNEE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * columnName CONSIGNEE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * columnName RECEIP_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getReceipTime() {
        return receipTime;
    }

    /**
     * columnName RECEIP_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceipTime(Date receipTime) {
        this.receipTime = receipTime;
    }

    /**
     * columnName SHIPPING_NOTE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShippingNote() {
        return shippingNote;
    }

    /**
     * columnName SHIPPING_NOTE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    /**
     * columnName RECEIPT_NOTE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getReceiptNote() {
        return receiptNote;
    }

    /**
     * columnName RECEIPT_NOTE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setReceiptNote(String receiptNote) {
        this.receiptNote = receiptNote;
    }

    /**
     * columnName PROCUREMENT_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getProcurementTime() {
        return procurementTime;
    }

    /**
     * columnName PROCUREMENT_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProcurementTime(Date procurementTime) {
        this.procurementTime = procurementTime;
    }

    /**
     * columnName CHARACTERISTIC <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * columnName CHARACTERISTIC <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * columnName PRODUCTION_CATEGORY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getProductionCategory() {
        return productionCategory;
    }

    /**
     * columnName PRODUCTION_CATEGORY <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setProductionCategory(String productionCategory) {
        this.productionCategory = productionCategory;
    }

    /**
     * columnName PARTICIPATE_PRICE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getParticipatePrice() {
        return participatePrice;
    }

    /**
     * columnName PARTICIPATE_PRICE <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setParticipatePrice(Integer participatePrice) {
        this.participatePrice = participatePrice;
    }

    /**
     * columnName PRICING_PEOPLE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPricingPeople() {
        return pricingPeople;
    }

    /**
     * columnName PRICING_PEOPLE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPricingPeople(String pricingPeople) {
        this.pricingPeople = pricingPeople;
    }

    /**
     * columnName PRICING_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getPricingTime() {
        return pricingTime;
    }

    /**
     * columnName PRICING_TIME <br/>
     * columnType datetime 23 3 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPricingTime(Date pricingTime) {
        this.pricingTime = pricingTime;
    }

    /**
     * columnName IS_PRICED <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getIsPriced() {
        return isPriced;
    }

    /**
     * columnName IS_PRICED <br/>
     * columnType varchar 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsPriced(String isPriced) {
        this.isPriced = isPriced;
    }

    /**
     * columnName MATERIAL_CZ <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMaterialCz() {
        return materialCz;
    }

    /**
     * columnName MATERIAL_CZ <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMaterialCz(String materialCz) {
        this.materialCz = materialCz;
    }

    /**
     * columnName PO_TYPE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getPoType() {
        return poType;
    }

    /**
     * columnName PO_TYPE <br/>
     * columnType varchar 20 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoType(String poType) {
        this.poType = poType;
    }

    /**
     * columnName MAKE_IE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMakeIe() {
        return makeIe;
    }

    /**
     * columnName MAKE_IE <br/>
     * columnType varchar 255 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMakeIe(String makeIe) {
        this.makeIe = makeIe;
    }

    public Double getSafeInv() {
        return this.safeInv;
    }

    public void setSafeInv(Double safeInv) {
        this.safeInv = safeInv;
    }

    /**
     * columnName SAFE_INV <br/>
     * columnType numeric 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */


    public String getStanderPrice() {
        return standerPrice;
    }

    /**
     * columnName STANDER_PRICE <br/>
     * columnType numeric 18 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setStanderPrice(String standerPrice) {
        this.standerPrice = standerPrice;
    }

    /**
     * columnName PO_TQDATE <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getPoTqdate() {
        return poTqdate;
    }

    /**
     * columnName PO_TQDATE <br/>
     * columnType int 10 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setPoTqdate(Integer poTqdate) {
        this.poTqdate = poTqdate;
    }

    /**
     * columnName DJ_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getDjType() {
        return djType;
    }

    /**
     * columnName DJ_TYPE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setDjType(String djType) {
        this.djType = djType;
    }

    /**
     * columnName COLOR <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getColor() {
        return color;
    }

    /**
     * columnName COLOR <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * columnName CLOPURCHASE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getClopurchase() {
        return clopurchase;
    }

    /**
     * columnName CLOPURCHASE <br/>
     * columnType varchar 50 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setClopurchase(String clopurchase) {
        this.clopurchase = clopurchase;
    }

    /**
     * columnName CLOPURCHASE_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Date getClopurchaseTime() {
        return clopurchaseTime;
    }

    /**
     * columnName CLOPURCHASE_TIME <br/>
     * columnType datetime2 27 7 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setClopurchaseTime(Date clopurchaseTime) {
        this.clopurchaseTime = clopurchaseTime;
    }

    /**
     * columnName SHOP_IMAGE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopImage() {
        return shopImage;
    }

    /**
     * columnName SHOP_IMAGE <br/>
     * columnType varchar 100 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    /**
     * columnName SHOP_IMAGE_NAME <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getShopImageName() {
        return shopImageName;
    }

    /**
     * columnName SHOP_IMAGE_NAME <br/>
     * columnType varchar 200 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setShopImageName(String shopImageName) {
        this.shopImageName = shopImageName;
    }

    /**
     * columnName IS_ZCGL <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public Integer getIsZcgl() {
        return isZcgl;
    }

    /**
     * columnName IS_ZCGL <br/>
     * columnType bit 1 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setIsZcgl(Integer isZcgl) {
        this.isZcgl = isZcgl;
    }

    /**
     * columnName MAT_DEPICT <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public String getMatDepict() {
        return matDepict;
    }

    /**
     * columnName MAT_DEPICT <br/>
     * columnType varchar 500 0 <br/>
     * columnRemarks null <br/>
     * isPK false <br/>
     * nullAble true <br/>
     */
    public void setMatDepict(String matDepict) {
        this.matDepict = matDepict;
    }
}