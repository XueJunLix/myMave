package com.ur.mro.shouhuo.model;



import com.ur.mro.pic.model.Attachment;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author version: 1.00
 *         Date: 20160817 14:24
 *         Last modify Date: 20160817 14:24
 *         CopyRight (c) spro Company 2006	All rights reserved
 *         说明: 送货单表头<br>
 *         变更:<br>
 */
public class GcShHeadDto  {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    private Boolean myCheckBox;


    //类型3种，值分别是：supToShop,supToWL,WLtoShop
    //类型3种，值分别是：supToShop,supToWL,WLtoShop
    private String shType;


    private String shNo;

    private String shopNo;

    private String shopName;

    private String supNo;

    private String supName;

    private String tel;

    private String contacts;

    private String supTel;

    private String supLinkMan;

    private String email;

    private String addr;

    private Integer boxes;

    private String supShno;

    private String comments;

	private String brandType;

    private String taskType;

	private String gcShStatus;

    private Date requiredArrivalDate;

    private String requiredArrivalDate1;


    private String companyCode;

    private String supAddress;

    private Boolean isAlreadyExport;

    private Boolean isSubmit;


    private String  isHashChangeMat;
	

	private Date supplierDeliverDate;
    
    private Double freight;

	private String wlNo;

    private String boxNo;


    //PO一键转送货单用==判断订单明细是否属于同一个店铺===============================

    private Boolean isSingleShopNo ;


    private String isGCJLSign;

    private String outerWarehouseNo;


    private String outerWarehouseName;


    private String outerWarehouseContacts;


    private String outerWarehouseTel;


    private String outerWarehouseEmail;


    private String outerWarehouseAddr;

    private Date signDate;

    private String isSend;



    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getOuterWarehouseContacts() {
        return outerWarehouseContacts;
    }

    public void setOuterWarehouseContacts(String outerWarehouseContacts) {
        this.outerWarehouseContacts = outerWarehouseContacts;
    }

    public String getOuterWarehouseTel() {
        return outerWarehouseTel;
    }

    public void setOuterWarehouseTel(String outerWarehouseTel) {
        this.outerWarehouseTel = outerWarehouseTel;
    }

    public String getOuterWarehouseEmail() {
        return outerWarehouseEmail;
    }

    public void setOuterWarehouseEmail(String outerWarehouseEmail) {
        this.outerWarehouseEmail = outerWarehouseEmail;
    }

    public String getOuterWarehouseAddr() {
        return outerWarehouseAddr;
    }

    public void setOuterWarehouseAddr(String outerWarehouseAddr) {
        this.outerWarehouseAddr = outerWarehouseAddr;
    }

    public String getOuterWarehouseNo() {
        return outerWarehouseNo;
    }

    public void setOuterWarehouseNo(String outerWarehouseNo) {
        this.outerWarehouseNo = outerWarehouseNo;
    }

    public String getOuterWarehouseName() {
        return outerWarehouseName;
    }

    public void setOuterWarehouseName(String outerWarehouseName) {
        this.outerWarehouseName = outerWarehouseName;
    }


    public String getIsGCJLSign() {
        return isGCJLSign;
    }

    public void setIsGCJLSign(String isGCJLSign) {
        this.isGCJLSign = isGCJLSign;
    }

    public Boolean getIsSingleShopNo() {
        return isSingleShopNo;
    }

    public void setIsSingleShopNo(Boolean isSingleShopNo) {
        this.isSingleShopNo = isSingleShopNo;
    }

    //=================================
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSupTel() {
        return supTel;
    }

    public void setSupTel(String supTel) {
        this.supTel = supTel;
    }

    public String getSupLinkMan() {
        return supLinkMan;
    }

    public void setSupLinkMan(String supLinkMan) {
        this.supLinkMan = supLinkMan;
    }

    //送货单
    public void setShNo(String shNo) {
        this.shNo = shNo;
    }

    // 送货单
    public String getShNo() {
        return shNo;
    }



    public Boolean getMyCheckBox() {
        return myCheckBox;
    }

    public void setMyCheckBox(Boolean myCheckBox) {
        this.myCheckBox = myCheckBox;
    }

    //店铺编号
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    // 店铺编号
    public String getShopNo() {
        return shopNo;
    }

    //店铺名称
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    // 店铺名称
    public String getShopName() {
        return shopName;
    }

    //供应商编号
    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    // 供应商编号
    public String getSupNo() {
        return supNo;
    }

    //供应商名称
    public void setSupName(String supName) {
        this.supName = supName;
    }

    // 供应商名称
    public String getSupName() {
        return supName;
    }

    //联系电话
    public void setTel(String tel) {
        this.tel = tel;
    }

    // 联系电话
    public String getTel() {
        return tel;
    }

    //联系人
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    // 联系人
    public String getContacts() {
        return contacts;
    }

    //总箱数
    public void setBoxes(Integer boxes) {
        this.boxes = boxes;
    }

    // 总箱数
    public Integer getBoxes() {
        return boxes;
    }

    public String getIsHashChangeMat() {
        return isHashChangeMat;
    }

    public void setIsHashChangeMat(String isHashChangeMat) {
        this.isHashChangeMat = isHashChangeMat;
    }

    //供应商送货编号
    public void setSupShno(String supShno) {
        this.supShno = supShno;
    }

    // 供应商送货编号
    public String getSupShno() {
        return supShno;
    }

    //备注
    public void setComments(String comments) {
        this.comments = comments;
    }

    // 备注
    public String getComments() {
        return comments;
    }

    private List<GcshItem> gcshitemVOs = new ArrayList<GcshItem>();

    public List<GcshItem> getGcshitemVOs() {
        return gcshitemVOs;
    }

    public void setGcshitemVOs(List<GcshItem> gcshitemVOs) {
        this.gcshitemVOs = gcshitemVOs;
    }



    private List<Attachment> files = new ArrayList<Attachment>();

    public List<Attachment> getFiles() {
        return files;
    }

    public void setFiles(List<Attachment> files) {
        this.files = files;
    }

    public String getShType() {
        return shType;
    }

    public String getSupAddress() {
        return supAddress;
    }


    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public void setShType(String shType) {
        this.shType = shType;
    }

    public Date getRequiredArrivalDate() {
        return requiredArrivalDate;
    }

    public void setRequiredArrivalDate(Date requiredArrivalDate) {
        this.requiredArrivalDate = requiredArrivalDate;
    }

    public String getRequiredArrivalDate1() {
        return requiredArrivalDate1;
    }

    public Boolean getIsAlreadyExport() {
        return isAlreadyExport;
    }

    public void setIsAlreadyExport(Boolean isAlreadyExport) {
        this.isAlreadyExport = isAlreadyExport;
    }

    public void setRequiredArrivalDate1(String requiredArrivalDate1) {
        this.requiredArrivalDate1 = requiredArrivalDate1;
    }

    public Boolean getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Boolean isSubmit) {
        this.isSubmit = isSubmit;
    }

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getGcShStatus() {
		return gcShStatus;
	}

	public void setGcShStatus(String gcShStatus) {
		this.gcShStatus = gcShStatus;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Date getSupplierDeliverDate() {
		return supplierDeliverDate;
	}

	public void setSupplierDeliverDate(Date supplierDeliverDate) {
		this.supplierDeliverDate = supplierDeliverDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWlNo() {
		return wlNo;
	}

	public void setWlNo(String wlNo) {
		this.wlNo = wlNo;
	}

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }


	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    
}