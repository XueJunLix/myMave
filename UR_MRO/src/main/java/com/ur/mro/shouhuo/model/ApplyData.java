package com.ur.mro.shouhuo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApplyData implements Serializable {

    private String createName;
    private String dept;
    private String useName;
    private String shopName;
    private String shopCode;
    private String reason;
    private String type;
    private String price;
    private String creatTime;

    private List<GCshHdead> pic=new ArrayList<>();

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public List<GCshHdead> getPic() {
        return pic;
    }

    public void setPic(List<GCshHdead> pic) {
        this.pic = pic;
    }
}
