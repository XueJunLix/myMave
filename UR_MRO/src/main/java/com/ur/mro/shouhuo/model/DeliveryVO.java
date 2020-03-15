package com.ur.mro.shouhuo.model;

import com.ur.mro.pic.model.Attachment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryVO {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String chNo;
    private String deliveryNo;
    private String shNo;
    private String shopNo;
    private String shopName;
    private String comments;
    private String brandType;
    private String gcWlStatus;
    private Date goodsSignDate;
    private String goodsSignDate1;
    private String freight;

    private String isSubmit;

    private Integer boxes;

    private String isCompleted;

    private String isOutnumber;
    private String errorXX;

    private String dpName;
    private String dpNo;

    private String senderNo;
    private String senderName;
    private String receiverNo;

    private String receiverName;

    private String qcShQut;

    public String getQcShQut() {
        return qcShQut;
    }

    public void setQcShQut(String qcShQut) {
        this.qcShQut = qcShQut;
    }

    public String getCyQut() {
        return cyQut;
    }

    public void setCyQut(String cyQut) {
        this.cyQut = cyQut;
    }

    private String cyQut;

    public String getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    public String getDpNo() {
        return dpNo;
    }

    public void setDpNo(String dpNo) {
        this.dpNo = dpNo;
    }

    public String getErrorXX() {
        return errorXX;
    }

    public void setErrorXX(String errorXX) {
        this.errorXX = errorXX;
    }

    public String getIsOutnumber() {
        return isOutnumber;
    }

    public void setIsOutnumber(String isOutnumber) {
        this.isOutnumber = isOutnumber;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }
    //no info
    public void setDeliveryNo(String deliveryNo){
        this.deliveryNo = deliveryNo;
    }
    // no info
    public String getDeliveryNo() {
        return deliveryNo;
    }
    //no info
    public void setShNo(String shNo){
        this.shNo = shNo;
    }
    // no info
    public String getShNo() {
        return shNo;
    }
    //店铺编号
    public void setShopNo(String shopNo){
        this.shopNo = shopNo;
    }
    // 店铺编号
    public String getShopNo() {
        return shopNo;
    }
    //店铺名称
    public void setShopName(String shopName){
        this.shopName = shopName;
    }
    // 店铺名称
    public String getShopName() {
        return shopName;
    }
    //备注
    public void setComments(String comments){
        this.comments = comments;
    }
    // 备注
    public String getComments() {
        return comments;
    }
    private List<DeliveryItem> deliveryitemVOs = new ArrayList<DeliveryItem>();
    public List<DeliveryItem>  getDeliveryitemVOs() {
        return deliveryitemVOs;
    }
    public void setDeliveryitemVOs(List<DeliveryItem> deliveryitemVOs) {
        this.deliveryitemVOs = deliveryitemVOs;
    }

    private List<Attachment> files =new ArrayList<Attachment>();

    public List<Attachment> getFiles() {
        return files;
    }

    public void setFiles(List<Attachment> files) {
        this.files = files;
    }

    public String getChNo() {
        return chNo;
    }

    public void setChNo(String chNo) {
        this.chNo = chNo;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getGcWlStatus() {
        return gcWlStatus;
    }

    public void setGcWlStatus(String gcWlStatus) {
        this.gcWlStatus = gcWlStatus;
    }

    public Date getGoodsSignDate() {
        return goodsSignDate;
    }

    public void setGoodsSignDate(Date goodsSignDate) {
        this.goodsSignDate = goodsSignDate;
    }

    public String getGoodsSignDate1() {
        return goodsSignDate1;
    }

    public void setGoodsSignDate1(String goodsSignDate1) {
        this.goodsSignDate1 = goodsSignDate1;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public Integer getBoxes() {
        return boxes;
    }

    public void setBoxes(Integer boxes) {
        this.boxes = boxes;
    }


}
