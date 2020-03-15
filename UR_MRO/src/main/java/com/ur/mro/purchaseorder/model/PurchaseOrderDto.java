package com.ur.mro.purchaseorder.model;


import com.ur.mro.order.model.OrderInfo;
import org.apache.poi.hmef.Attachment;

import java.util.ArrayList;
import java.util.List;


/**
 * 		   @author 
 *         version: 1.00
 *         Date: 20150818 10:25
 *         Last modify Date: 20150818 10:25
 *         CopyRight (c) spro Company 2006	All rights reserved
 *         说明: 采购订单<br>
 *         变更:<br>
 */
public class PurchaseOrderDto {


	private String poClassify;

	private String fhMode;

	private  String fhAddress;
	private String dhTime;
	private  String poType;
	private  String depositbankname;
	private  String zdzsl;//制单总数量
	private  Double ddzje;//订单总金额
	private  String contractMain;
	private  String contractId;
	private String supplierFullName;
	private String taskType;
	private String brandType;
	private String shopImage;

	private String applyDepartment;

	private String freight;
	private String deposit;
	private String installationFee;
	private String otherFee;

	//工程字段==========================================
	//"参考订单号
	private String referPo;
	//材料要求
	private String materialRequired;
	//配送方式
	private String dispatchingWay;
	//运费承运方
	private String payBy;

	private String  applyOrderNo1;


	private String isSend;


	private String companyCode;

	private String contractNo;


	private String taxRate;

	//成本中心代码
	private String costCenterCode;
	//成本中心名称
	private String costCenterName;

	private String appointQcDate;

	private String tokenKey;

	//收货单位
	private String shdw;
	//收货人
	private String shr;
	//联系方式
	private String lxfs;
	//收货地址
	private String shdz;

	public String getShdw() {
		return shdw;
	}

	public void setShdw(String shdw) {
		this.shdw = shdw;
	}

	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getShdz() {
		return shdz;
	}

	public void setShdz(String shdz) {
		this.shdz = shdz;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}



	//===================================================
	public String getReferPo() {
		return referPo;
	}

	public void setReferPo(String referPo) {
		this.referPo = referPo;
	}

	public String getMaterialRequired() {
		return materialRequired;
	}

	public void setMaterialRequired(String materialRequired) {
		this.materialRequired = materialRequired;
	}

	public String getDispatchingWay() {
		return dispatchingWay;
	}

	public void setDispatchingWay(String dispatchingWay) {
		this.dispatchingWay = dispatchingWay;
	}

	public String getPayBy() {
		return payBy;
	}

	public void setPayBy(String payBy) {
		this.payBy = payBy;
	}

	public String getContractMain() {
		return contractMain;
	}

	public void setContractMain(String contractMain) {
		this.contractMain = contractMain;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Double getDdzje() {
		return ddzje;
	}

	public void setDdzje(Double ddzje) {
		this.ddzje = ddzje;
	}

	public String getZdzsl() {
		return zdzsl;
	}

	public void setZdzsl(String zdzsl) {
		this.zdzsl = zdzsl;
	}



	public String getDepositbankname() {
		return depositbankname;
	}

	public void setDepositbankname(String depositbankname) {
		this.depositbankname = depositbankname;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getPoClassify() {
		return poClassify;
	}

	public void setPoClassify(String poClassify) {
		this.poClassify = poClassify;
	}

	public String getFhMode() {
		return fhMode;
	}

	public void setFhMode(String fhMode) {
		this.fhMode = fhMode;
	}

	public String getFhAddress() {
		return fhAddress;
	}

	public void setFhAddress(String fhAddress) {
		this.fhAddress = fhAddress;
	}

	public String getDhTime() {
		return dhTime;
	}

	public void setDhTime(String dhTime) {
		this.dhTime = dhTime;
	}

	private String dxzje;

	private String dw;

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getDxzje() {
		return dxzje;
	}

	public void setDxzje(String dxzje) {
		this.dxzje = dxzje;
	}

	private String affirmStatus;
	private String curreryTech;
	private String submitUser;

	//紧用于版料采购的收货登记界面
	private String purchaseUnit;
	private String purchaseUnitPrice;

	private String zjComments;

	//是否有检查报告
	private String hasReport;

	//联系人
	private  String contact;
	/**
	 * 固话
	 */
	private String phone;

	/**
	 * 移动电话
	 */
	private String telPhone;

	private String userPhone; //订单创建人的电话

	private String purchaseWholeCount;//采购总数量


	private String ppsOrderNo;

	private String moduleNo;


	private String designNo;

	private Double deliveryCount;

	private Double deliveryPrice;

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	private String zjResult;
	private Double zjCount;
	private String cz;//传真

	private List msList = new ArrayList();

	public List getMsList() {
		return msList;
	}

	public void setMsList(List msList) {
		this.msList = msList;
	}

	private  List sumList = new ArrayList();

	public List getSumList() {
		return sumList;
	}

	public void setSumList(List sumList) {
		this.sumList = sumList;
	}

	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	private Double zsl;

	public Double getZsl() {
		return zsl;
	}

	public void setZsl(Double zsl) {
		this.zsl = zsl;
	}

	private Double zje;

	public Double getZje() {
		return zje;
	}

	public void setZje(Double zje) {
		this.zje = zje;
	}

	private List<Attachment> files=new ArrayList<Attachment>();
	public List<Attachment> getFiles() {
		return files;
	}

	public void setFiles(List<Attachment> files) {
		this.files = files;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long id;

	private String type_;

	private  String flowId;

	private  String confirmSample;

	private String payMode;

	private String mRowId;

	public String getApplyOrderNo1() {
		return applyOrderNo1;
	}

	public void setApplyOrderNo1(String applyOrderNo1) {
		this.applyOrderNo1 = applyOrderNo1;
	}

	public String getCtComments() {
		return ctComments;
	}

	public void setCtComments(String ctComments) {
		this.ctComments = ctComments;
	}

	public String getSjComments() {
		return sjComments;
	}

	public void setSjComments(String sjComments) {
		this.sjComments = sjComments;
	}

	public String getPkComments() {
		return pkComments;
	}

	public void setPkComments(String pkComments) {
		this.pkComments = pkComments;
	}

	private String ctComments;
	private String sjComments;
	private String pkComments;

	private String groupId;

	private String orderType;

	private String orderNo;

	private Integer orderStatus;

	private String purchaseOrg;

	private String purchase;

	private String processingMode;

	private String storeId;

	private String currency;

	private Double exchangeRate;

	private String supplierCode;

	private String supplierName;

	private Double purchaseAmount;

	private String payWay;

	private String deliveryAddress;

	private String comments;


	private String purchaseBy;

	private String purchaseBy1;


	private String purchaseType;

	private String deliveryMode;

	//创建人
	private String createdBy;

	private String createdBy1;

	//创建时间
	private String createdDate;


	//==========================gc物料打印用字段 店铺信息===========================================

	private String shopName;//店铺名称
	private String receiverBy; //收货人
	private String receiverByTelephone; //联系电话
	private String receiverAddress; //收货地址

	//======================================================================================
	//总监审批者
	private String zjspBy;



	//no info
	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	// no info
	public String getGroupId() {
		return groupId;
	}

	public String getType_() {
		return type_;
	}

	public void setType_(String type_) {
		this.type_ = type_;
	}

	//no info
	public void setOrderType(String orderType){
		this.orderType = orderType;
	}
	// no info
	public String getOrderType() {
		return orderType;
	}
	//no info
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	// no info



	public String getOrderNo() {
		return orderNo;
	}

	public String getConfirmSample() {
		return confirmSample;
	}

	public void setConfirmSample(String confirmSample) {
		this.confirmSample = confirmSample;
	}

	public String getZjComments() {
		return zjComments;
	}

	public void setZjComments(String zjComments) {
		this.zjComments = zjComments;
	}

	//no info
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	// no info
	public Integer getOrderStatus() {
		return orderStatus;
	}
	//no info

	public Double getDeliveryCount() {
		return deliveryCount;
	}

	public void setDeliveryCount(Double deliveryCount) {
		this.deliveryCount = deliveryCount;
	}

	public void setPurchaseOrg(String purchaseOrg){
		this.purchaseOrg = purchaseOrg;
	}
	// no info
	public String getPurchaseOrg() {
		return purchaseOrg;
	}
	//no info
	public void setPurchase(String purchase){
		this.purchase = purchase;
	}
	// no info
	public String getPurchase() {
		return purchase;
	}
	//no info
	public void setProcessingMode(String processingMode){
		this.processingMode = processingMode;
	}
	// no info
	public String getProcessingMode() {
		return processingMode;
	}
	//no info
	public void setStoreId(String storeId){
		this.storeId = storeId;
	}
	// no info
	public String getStoreId() {
		return storeId;
	}
	//no info
	public void setCurrency(String currency){
		this.currency = currency;
	}
	// no info


	public String getPurchaseWholeCount() {
		return purchaseWholeCount;
	}

	public void setPurchaseWholeCount(String purchaseWholeCount) {
		this.purchaseWholeCount = purchaseWholeCount;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getCurrency() {
		return currency;
	}
	//no info
	public void setExchangeRate(Double exchangeRate){
		this.exchangeRate = exchangeRate;
	}
	// no info
	public Double getExchangeRate() {
		return exchangeRate;
	}
	//no info


	public String getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public String getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}

	public void setPurchaseUnitPrice(String purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
	}

	public String getHasReport() {
		return hasReport;
	}

	public void setHasReport(String hasReport) {
		this.hasReport = hasReport;
	}

	public Double getZjCount() {
		return zjCount;
	}

	public void setZjCount(Double zjCount) {
		this.zjCount = zjCount;
	}

	public void setSupplierCode(String supplierCode){
		this.supplierCode = supplierCode;
	}
	// no info
	public String getSupplierCode() {
		return supplierCode;
	}
	//no info
	public void setSupplierName(String supplierName){
		this.supplierName = supplierName;
	}
	// no info
	public String getSupplierName() {
		return supplierName;
	}
	//no info
	public void setPurchaseAmount(Double purchaseAmount){
		this.purchaseAmount = purchaseAmount;
	}
	// no info
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	//no info
	public void setPayWay(String payWay){
		this.payWay = payWay;
	}
	// no info
	public String getPayWay() {
		return payWay;
	}
	//no info
	public void setDeliveryAddress(String deliveryAddress){
		this.deliveryAddress = deliveryAddress;
	}
	// no info
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	//no info
	public void setComments(String comments){
		this.comments = comments;
	}

	public String getPurchaseBy() {
		return purchaseBy;
	}

	public String getAffirmStatus() {
		return affirmStatus;
	}

	public void setAffirmStatus(String affirmStatus) {
		this.affirmStatus = affirmStatus;
	}

	public String getCurreryTech() {
		return curreryTech;
	}

	public void setCurreryTech(String curreryTech) {
		this.curreryTech = curreryTech;
	}

	public String getSubmitUser() {
		return submitUser;
	}

	public void setSubmitUser(String submitUser) {
		this.submitUser = submitUser;
	}

	public void setPurchaseBy(String purchaseBy) {
		this.purchaseBy = purchaseBy;
	}

	public String getmRowId() {
		return mRowId;
	}

	public void setmRowId(String mRowId) {
		this.mRowId = mRowId;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getPpsOrderNo() {
		return ppsOrderNo;
	}

	public void setPpsOrderNo(String ppsOrderNo) {
		this.ppsOrderNo = ppsOrderNo;
	}

	public String getModuleNo() {
		return moduleNo;
	}

	public String getCreatedBy1() {
		return createdBy1;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public void setCreatedBy1(String createdBy1) {
		this.createdBy1 = createdBy1;
	}

	public void setModuleNo(String moduleNo) {
		this.moduleNo = moduleNo;
	}

	public String getDesignNo() {
		return designNo;
	}

	public void setDesignNo(String designNo) {
		this.designNo = designNo;
	}

	public String getZjResult() {
		return zjResult;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setZjResult(String zjResult) {
		this.zjResult = zjResult;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getPurchaseBy1() {
		return purchaseBy1;
	}

	public void setPurchaseBy1(String purchaseBy1) {
		this.purchaseBy1 = purchaseBy1;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	// no info
	public String getComments() {
		return comments;
	}
	private List<OrderInfo> orderInfoVOs = new ArrayList<OrderInfo>();
	public List<OrderInfo>  getOrderInfoVOs() {
		return orderInfoVOs;
	}
	public void setOrderInfoVOs(List<OrderInfo> orderInfoVOs) {
		this.orderInfoVOs = orderInfoVOs;
	}


	public String fax;

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSupplierFullName() {
		return supplierFullName;
	}

	public void setSupplierFullName(String supplierFullName) {
		this.supplierFullName = supplierFullName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getReceiverBy() {
		return receiverBy;
	}

	public void setReceiverBy(String receiverBy) {
		this.receiverBy = receiverBy;
	}

	public String getReceiverByTelephone() {
		return receiverByTelephone;
	}

	public void setReceiverByTelephone(String receiverByTelephone) {
		this.receiverByTelephone = receiverByTelephone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getShopImage() {
		return shopImage;
	}

	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}

	public String getApplyDepartment() {
		return applyDepartment;
	}

	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getInstallationFee() {
		return installationFee;
	}

	public void setInstallationFee(String installationFee) {
		this.installationFee = installationFee;
	}

	public String getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}


	public String getZjspBy() {
		return zjspBy;
	}

	public void setZjspBy(String zjspBy) {
		this.zjspBy = zjspBy;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getAppointQcDate() {
		return appointQcDate;
	}

	public void setAppointQcDate(String appointQcDate) {
		this.appointQcDate = appointQcDate;
	}

	
	
}