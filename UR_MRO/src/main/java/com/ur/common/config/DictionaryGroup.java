package com.ur.common.config;

/**
 * 数据字典--组标识
 * @author Administrator
 *
 */
public class DictionaryGroup {
	//WEST
	public static final String SERIAL = "FJSX2";
	public static final String STYLE = "FJSX9";	
	public static final String GOODS_LEVEL = "FJSX10";	
	public static final String CATEGORY = "FJSX6";	
	public static final String SUB_CATEGORY = "FJSX7";
	public static final String ORDER_TYPE = "orderType";
	public static final String ORDER_NO = "allOrderNo";
	public static final String DISPLAY_GENRE = "displayGenre";
	public static final String SOUTH_NORTH_GENRE = "SOUTH_NORTH_GENRE";
	public static final String AB_GENRE = "AB_GENRE";
	public static final String PROCESSING_MODEL = "processingMode";
	public static final String FABRIC_PROPERTIES = "fabricFeatures";
	public static final String ORDER_MODEL = "orderModel";
	public static final String CYTYPE = "cyType";
	//企划款号发布状态
	public static final String PLAN_MODEL_NO_STATUS = "PLAN_MODEL_NO_STATUS";
	
	//店铺属性
	public static final String SHOP_TYPE = "SHOP_TYPE";	
	public static final String GOODS_AREA = "goodsarea";	
	public static final String SELL_AREA = "sellarea";	
	public static final String SHOP_DIS_LEVEL = "shopDisLevel";
	public static final String DENSITY_TYPE = "DENSITY_TYPE";
	public static final String SHOP_PLAN_LEVEL = "shopPlanLevel";
	//品牌
	public static final String BRAND = "brand";
	//季节：春夏、秋冬
	public static final String SEASON = "srm_season";
	public static final String SEASONDETAIL = "seasonDetail";
	
	//数据类型映射
	public static final String DATA_TYPE_MAPPING_TYPE = "NonProMDDataType";
	public static final String DATA_TYPE_MAPPING_VALUE_FIELD = "NonProMDValueColumns";
	
	public static final String NON_PROD_MD_RANGE_TYPE= "NonProMDRangeType";
	public static final String MASTER_DATA_TABLE= "imsMasterDataTable";
	
	
	public static final String DATA_TYPE_UNIT_PRICE="unit_price";//平均单价
	public static final String DATA_TYPE_DEPTH="depth";
	public static final String DATA_TYPE_WIDTH="width";
	public static final String DATA_TYPE_OTB_AMOUNT="OTB_amount";
	public static final String DATA_TYPE_FILL_RATIO="fill_ratio";  //满场系数
	public static final String DATA_TYPE_AMOUNT_PROPORTION="amount_proportion";
	public static final String DATA_TYPE_CATEGORY_PROPORTION="category_proportion";
	//public static final String DATA_TYPE_FILL_RATE="fill_rate";
	public static final String DATA_TYPE_NATION_WIDTH="nation_width";
	public static final String DATA_TYPE_REGION_AMOUNT_PROPORTION="region_amount_proportion";
	public static final String DATA_TYPE_CALCULATE_RESULT="calculate_result";
	public static final String DATA_TYPE_REGION_CATEGORY_PROPORTION="region_category_proportion";//区域品类宽度占比
	public static final String DATA_TYPE_WES_EFFECTIVE_STANDARD_SKUS="wes_effective_standard_skus";//wes有效标准sku数
	public static final String DATA_TYPE_LIFE_CYCLE="life_cycle"; //生命周期
	public static final String DATA_TYPE_AVERAGE_LIFE_CYCLE="average_life_cycle";//平均生命周期
	public static final String DATA_TYPE_STORE_LIFE_CYCLE="store_life_cycle"; //店铺生命周期
	

	public static final String DATA_TYPE_UNIQUE_CODE_ORDER_NO_SPLIT="unique_code_order_no_split";//唯一码单号拆分
	public static final String DATA_TYPE_UNIQUE_CODE_SPLIT_CHECK="unique_code_split_check";//唯一码拆分检核
	public static final String DATA_TYPE_UNIQUE_CODE_CHECK="unique_code_check";//唯一码检核
	
	public static final String RANGE_TYPE_PLAN_SHOP_NO="planShopNo";
	public static final String RANGE_TYPE_GOODS_AREA="goodsarea";
	public static final String RANGE_TYPE_ORDER_NO="allOrderNo";

	public static final String MONTH_STANDARD_UNIQUE_CODE_DEPTH_ADJUST="UNIQUE_CODE_DEPTH_ADJUST";

	//店铺企划等级
	public static final String SHOP_LEVEL_PLAN_LEVEL = "planLevel";	
	
	
	public static final String MASTER_DATA_TABLE_PROPORTION="proportion_master_data";
	public static final String MASTER_DATA_TABLE_PLAN_PROCESS_DATA="plan_process_data";
	public static final String MASTER_DATA_TABLE_NON_PROPORTION="non_proportion_master_data";
	
	
	public static final String DATA_TYPE_PLAN_SALES_TARGET="plan_sales_target";//企划销售目标金额
	
	public static final String SHOP_ATTACHMENT_TYPE="shopAttachmenttType"; //店铺图片分类

	public static final String VERSION_DATA_TYPE="version_data_type"; //版本类型
	

	public static final String EUREKA_CY_COLOR="cyColour"; //成衣颜色
	public static final String SAMPLE="sample"; //版型
	public static final String SILHOUETTE="silhouette"; //廓型
	public static final String DESIGNELEMENTS="designElements"; //设计元素
	public static final String SLEEVETYPE="sleeveType"; //袖型
	public static final String CLOLENGTH="cloLength"; //衣长
	public static final String SLEEVEPANTLENGTH2="sleevePantLength2"; //袖长
	public static final String COLLARTYPE="collarType"; //袖长
	public static final String HEELHEIGHT="heelHeight"; //鞋跟高度
	public static final String THICKNESS="thickness"; //厚薄
	public static final String SELECT_TYPE="selectType"; //成衣主数据限定字段
	public static final String COLOR_NO="mlss201801-001";//mlss201801-001存放的是色组

	//二次企划
	public static final String SECOND_PLAN_SPECIFY_TYPE="specify_type";//指定款
	public static final String SECOND_PLAN_MONTH_STANDARD="2ndPlanMonthStandard";//二次企划月度标准值
	public static final String SECOND_PLAN_MASTER_DATA_TABLE_PROPORTION="second_plan_proportion_master_data";
	public static final String SECOND_PLAN_MASTER_DATA_TABLE_NON_PROPORTION="second_plan_non_proportion_master_data";
	
	
	//二次企划占比非占比主数据数据类型
	public static final String DATA_TYPE_2ND_PLANNNING_SALES_TARGET_PROPORTION="2nd_plannning_sales_target_proportion";//二次企划目标销售金额系列占比	
	public static final String DATA_TYPE_2ND_PLANNNING_SALES_TARGET="2nd_plannning_sales_target";//二次企划系列目标销售金额
	public static final String DATA_TYPE_2ND_PLANNNING_WEST_REQUIREMENT="2nd_plannning_west_requirement";//二次企划店铺WEST需求明细
	public static final String DATA_TYPE_2ND_PLANNNING_WES_EFFECTIVE_STANDARD_SKUS="2nd_plannning_wes_effective_standard_skus";//二次企划WES有效标准SKU数
	
	//二次企划月度标准值数据类型
	public static final String SECOND_PLAN_MONTH_STANDARD_SHOP_SALE_TARGET="2nd_shop_sales_target";
	
	//SCM送货类型
	public static final String SCM_YYSHTYPE="yyShType";
	
	//二次企划月度标准值类型
	public static final String SECOND_PLAN_MONTH_STANDARD_TYPE_STANDARD_DEP="STANDARD_DEP"; //二次企划标准值-深度标准
	
}
