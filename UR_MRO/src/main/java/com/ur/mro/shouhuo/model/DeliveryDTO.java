package com.ur.mro.shouhuo.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 收货确认
 */
public class DeliveryDTO {

    private  String  delivery_note;
    private Integer  choose;
    private boolean  isshow;

    public List<GCshHdead> getProducts() {
        return products;
    }

    public void setProducts(List<GCshHdead> products) {
        this.products = products;
    }

    private List<GCshHdead>  products=new ArrayList<GCshHdead>();

    public String getDelivery_note() {
        return delivery_note;
    }

    public void setDelivery_note(String delivery_note) {
        this.delivery_note = delivery_note;
    }

    public boolean getCheck() {
          return this.check;
    }

    private boolean  check;
    public void setCheck(boolean check) {
        if(!check)
            check=false;
        this.check = check;
    }

    public Integer getChoose() {
          return this.choose;
    }

    public void setChoose(Integer choose) {
        if(choose==null)
            choose=0;
        this.choose = choose;
    }

    public boolean getIsshow() {
        return isshow;
    }

    public void setIsshow(boolean isshow) {
        this.isshow = isshow;
    }

    public String getNowtype() {
        return nowtype;
    }

    public void setNowtype(String nowtype) {
        this.nowtype = nowtype;
    }

    private String  nowtype;


}
