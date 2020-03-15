package com.ur.mro.shouhuo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ur.mro.shouhuo.mappers.DeliveryItemMapper;
import com.ur.mro.shouhuo.mappers.GCshHdeadMapper;
import com.ur.mro.shouhuo.mappers.GcshItemMapper;
import com.ur.mro.shouhuo.mappers.WlShopMatinvMapper;
import com.ur.mro.shouhuo.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WlShopMatinvService {
    @Autowired
    WlShopMatinvMapper wlShopMatinvMapper;

    @Autowired
    GcshItemMapper gcshItemMapper;

    @Autowired
    DeliveryItemMapper deliveryItemMapper;

    @Autowired
    GCshHdeadMapper gCshHdeadMapper;

    public WlShopMatinv getWlShopMatinvByPK(Integer pkId) {
        return wlShopMatinvMapper.getWlShopMatinvByPK(pkId);
    }

    @Transactional
    public Integer insertWlShopMatinv(WlShopMatinv wlShopMatinv) {
        
        //TODO handle date columns here
        //wlShopMatinv.setCreatedTime(new Date());
        //wlShopMatinv.setLastUpdatedTime(new Date());
        
        wlShopMatinvMapper.insertWlShopMatinv(wlShopMatinv);
        return wlShopMatinv.getId();
    }

    @Transactional
    public int updateWlShopMatinvByPKSelective(WlShopMatinv wlShopMatinv) {
        
        //TODO handle date columns here
        //wlShopMatinv.setCreatedTime(new Date());
        //wlShopMatinv.setLastUpdatedTime(new Date());
        
        int result = wlShopMatinvMapper.updateWlShopMatinvByPKSelective(wlShopMatinv);
        return result;
    }

    public PagingRestResponse searchWlShopMatinv(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = wlShopMatinvMapper.searchWlShopMatinvCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<WlShopMatinv> resultList = null;
        if(totalRecordNum>0){
            resultList = wlShopMatinvMapper.searchWlShopMatinv(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    //写入库存(1.供应商到物流公司提交后写入-->增加库存. 2.物流到店铺提交后写入 --> 减少库存)
    public void writeMatinv(GCshHdead gcshhead,Delivery deli)  throws Exception {
        if (gcshhead == null) {
            return;
        }
        if ("supToWL".equals(gcshhead.getShType())) {//1.供应商到物流公司提交后写入-->增加库存
//            String shNo = gcshhead.getShNo();
//            String supNo = gcshhead.getSupNo();
            List<GcshItem> gcshitems = gcshhead.getGcshitemVOs();
            if (gcshitems == null) {//防止空指针
                gcshitems = new ArrayList<GcshItem>();
            }
            List<DeliveryItem> delitems = new ArrayList<DeliveryItem>();
            if(deli != null){
                delitems = deli.getDeliveryitems();
            }

            for (GcshItem gcshitem : gcshitems) {
                if (gcshitem.getDeleted()==1) {
                    continue;
                }
//                String shopNo = gcshitem.getShopNo();
//                String matCode = gcshitem.getMatCode();
//                String poNo = gcshitem.getPoNo();

                //  WlShopMatinv wlShopMatinv = (WlShopMatinv) super.getObjectByField(WlShopMatinv.class, supNo + ";" + shNo + ";" + poNo + ";" + shopNo + ";" + matCode, "supplierCode;shNo;poNo;shopCode;matCode");
                WlShopMatinv wlShopMatinv = new WlShopMatinv();
//                if (wlShopMatinv == null) {
//                    wlShopMatinv = new WlShopMatinv();
//                }

                wlShopMatinv.setShId(gcshhead.getId());
                wlShopMatinv.setSupplierCode(gcshhead.getShopNo());//物流公司编码
                wlShopMatinv.setSupplierName(gcshhead.getShopName());//物流公司名称
                wlShopMatinv.setShNo(gcshhead.getShNo());
                wlShopMatinv.setSupNo(gcshhead.getSupNo());
                wlShopMatinv.setSupName(gcshhead.getSupName());

                wlShopMatinv.setMatCode(gcshitem.getMatCode());
                wlShopMatinv.setMatName(gcshitem.getMatName());
                wlShopMatinv.setMatSpec(gcshitem.getMatSpec());
                wlShopMatinv.setPoNo(gcshitem.getPoNo());
                wlShopMatinv.setShopName(gcshitem.getShopName());
                wlShopMatinv.setShopCode(gcshitem.getShopNo());

                if(deli != null){
                    for(DeliveryItem d : delitems){
                        if(gcshitem.getMatCode().equals(d.getMatCode())){
                            wlShopMatinv.setMatQut(d.getQcShQut());//  目前供应商到物流取实际验收数
                        }
                    }
                }else{
                    if (gcshitem.getSjShQut() != null) {//库存数量
                        wlShopMatinv.setMatQut(gcshitem.getSjShQut());
                    } else {
                        wlShopMatinv.setMatQut(gcshitem.getShQut());
                    }
                }

                wlShopMatinvMapper.insertWlShopMatinv(wlShopMatinv);
            }
        } else if ("WLtoShop".equals(gcshhead.getShType())) { //2.物流到店铺提交后写入 --> 减少库存
            if ("2".equals(gcshhead.getIsHashChangeMat()) || gcshhead.getIsHashChangeMat() == null) {//不是转店的时候才写入(转店的在保存时写入,使用下面方法 subChangeShopMatinv())
                String supNo = gcshhead.getSupNo();
                List<GcshItem> gcshitems = gcshhead.getGcshitemVOs();
                if (gcshitems == null) {
                    gcshitems = new ArrayList<GcshItem>();
                }
                for (GcshItem gcshitem : gcshitems) {
                    if (gcshitem.getDeleted()==1) {
                        continue;
                    }
                    String shNo = gcshitem.getShNo();
                    String shopNo = gcshitem.getShopNo();
                    String matCode = gcshitem.getMatCode();
                    String poNo = gcshitem.getPoNo();

                    WlShopMatinv wlShopMatinv=wlShopMatinvMapper.getWlShopMatinvByShidCodee(
                            supNo,
                            shNo,
                            poNo,
                            shopNo,
                            matCode
                    );
                    if (wlShopMatinv != null) {
                        Double count = Double.valueOf(wlShopMatinv.getMatQut());//库存数量
                        Double nowCount;
                        if (gcshitem.getSjShQut() != null) {//存在实际送货数量以实际送货数量为准
                            nowCount = count - Double.valueOf(gcshitem.getSjShQut());//减去库存量
                        } else {
                            nowCount = count - Double.valueOf(gcshitem.getShQut());//减去库存量
                        }

                       /* if (nowCount < 0) {
                            throw new BaseException("库存剩余量为:" + String.valueOf(count) + ",库存不足！", new Object[]{});
                        }*/

                        wlShopMatinv.setMatQut(String.valueOf(nowCount));
                        wlShopMatinvMapper.insertWlShopMatinv(wlShopMatinv);
                    }

                }
            }
        }
    }
}