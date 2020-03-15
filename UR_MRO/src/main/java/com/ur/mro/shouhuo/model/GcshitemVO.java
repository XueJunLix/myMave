package com.ur.mro.shouhuo.model;


/**
 * 		   @author 
 *         version: 1.00
 *         Date: 20160817 14:24
 *         Last modify Date: 20160817 14:24
 *         CopyRight (c) spro Company 2006	All rights reserved
 *         说明: 送货单明细<br>
 *         变更:<br>
 */
public class GcshitemVO {


	private String shNo;

	 private String poNo;

	 private String prNo;

	 private String rowNo;

	 private String matCode;

	 private String matName;

	 private String matSpec;

	private String matCz;

	 private String matSize;

	 private String unit;

	 private Double shQut;

	 private Double poQut;

	 private String makeIe;

	 private Double sjShQut;

	 private Double ysQut;

	 private String comments;

	private String bType;

	private String mType;

	private String sType;

	private Double price;

	private String supNo;

	private String supName;


	private String shopNo;


	private String shopName;

	private String tell;

	private String contacts;

	private String changeToShopNo;

	private String  changeToShopName;

	private Double outCount;

	private Double canShCount;


	private String changeToPoNo;


	private String changeToPoCount;
	

	 private Double qcShQut;


//打印用===============================

	private String shQut1;


	private String boxNum;


	private String poOrPrId;


	private String shItemId;

	public String getShItemId() {
		return shItemId;
	}

	public void setShItemId(String shItemId) {
		this.shItemId = shItemId;
	}

	public String getPoOrPrId() {
		return poOrPrId;
	}

	public void setPoOrPrId(String poOrPrId) {
		this.poOrPrId = poOrPrId;
	}

	public String getBoxNum() {
		return boxNum;
	}

	public void setBoxNum(String boxNum) {
		this.boxNum = boxNum;
	}

	//===================================
	public Double getYsQut() {
		return ysQut;
	}

	public void setYsQut(Double ysQut) {
		this.ysQut = ysQut;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getPrNo() {
		return prNo;
	}

	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}

	public String getShNo() {
		return shNo;
	}

	public Double getOutCount() {
		return outCount;
	}

	public void setOutCount(Double outCount) {
		this.outCount = outCount;
	}

	public void setShNo(String shNo) {
		this.shNo = shNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getChangeToPoNo() {
		return changeToPoNo;
	}

	public void setChangeToPoNo(String changeToPoNo) {
		this.changeToPoNo = changeToPoNo;
	}

	public String getChangeToPoCount() {
		return changeToPoCount;
	}

	public void setChangeToPoCount(String changeToPoCount) {
		this.changeToPoCount = changeToPoCount;
	}

	//采购订单
	public void setPoNo(String poNo){
		this.poNo = poNo;
	}
	 // 采购订单
	public String getPoNo() {
		return poNo;
    }
	 //项次

	public Double getCanShCount() {
		return canShCount;
	}

	public void setCanShCount(Double canShCount) {
		this.canShCount = canShCount;
	}

	public void setRowNo(String rowNo){
		this.rowNo = rowNo;
	}
	 // 项次
	public String getRowNo() {
		return rowNo;
    }
	 //物料编号
	public void setMatCode(String matCode){
		this.matCode = matCode;
	}
	 // 物料编号
	public String getMatCode() {
		return matCode;
    }
	 //物料名称
	public void setMatName(String matName){
		this.matName = matName;
	}
	 // 物料名称
	public String getMatName() {
		return matName;
    }
	 //规格
	public void setMatSpec(String matSpec){
		this.matSpec = matSpec;
	}
	 // 规格
	public String getMatSpec() {
		return matSpec;
    }
	 //材质
	public void setMatCz(String matCz){
		this.matCz = matCz;
	}
	 // 材质
	public String getMatCz() {
		return matCz;
    }
	 //尺寸
	public void setMatSize(String matSize){
		this.matSize = matSize;
	}
	 // 尺寸
	public String getMatSize() {
		return matSize;
    }
	 //计量单位
	public void setUnit(String unit){
		this.unit = unit;
	}
	 // 计量单位
	public String getUnit() {
		return unit;
    }
	 //送货数量
	public void setShQut(Double shQut){
		this.shQut = shQut;
	}
	 // 送货数量
	public Double getShQut() {
		return shQut;
    }
	 //订单数量
	public void setPoQut(Double poQut){
		this.poQut = poQut;
	}
	 // 订单数量
	public Double getPoQut() {
		return poQut;
    }
	 //制作工艺
	public void setMakeIe(String makeIe){
		this.makeIe = makeIe;
	}
	 // 制作工艺
	public String getMakeIe() {
		return makeIe;
    }
	 //实际送货数量
	public void setSjShQut(Double sjShQut){
		this.sjShQut = sjShQut;
	}
	 // 实际送货数量
	public Double getSjShQut() {
		return sjShQut;
    }
	 //备注
	public void setComments(String comments){
		this.comments = comments;
	}
	 // 备注
	public String getComments() {
		return comments;
    }

	public String getChangeToShopNo() {
		return changeToShopNo;
	}

	public void setChangeToShopNo(String changeToShopNo) {
		this.changeToShopNo = changeToShopNo;
	}

	public String getChangeToShopName() {
		return changeToShopName;
	}

	public void setChangeToShopName(String changeToShopName) {
		this.changeToShopName = changeToShopName;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShQut1() {
		return shQut1;
	}

	public void setShQut1(String shQut1) {
		this.shQut1 = shQut1;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Double getQcShQut() {
		return qcShQut;
	}

	public void setQcShQut(Double qcShQut) {
		this.qcShQut = qcShQut;
	}

	public String getSupNo() {
		return supNo;
	}

	public void setSupNo(String supNo) {
		this.supNo = supNo;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}
}