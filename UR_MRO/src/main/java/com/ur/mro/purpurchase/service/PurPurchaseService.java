package com.ur.mro.purpurchase.service;

import com.google.common.collect.Lists;
import com.ur.common.util.NumberUtils;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ur.mro.purpurchase.mappers.PurPurchaseMapper;
import com.ur.mro.purpurchase.model.Pic;
import com.ur.mro.purpurchase.model.PurPurchase;
import com.ur.mro.purpurchase.model.ShenqingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurPurchaseService {
    @Autowired
    PurPurchaseMapper purPurchaseMapper;

    public PurPurchase getPurPurchaseByPK(Integer pkId) {
        return purPurchaseMapper.getPurPurchaseByPK(pkId);
    }

    @Value("${pic.server.host.image_url}")
    private String picUrl;

    @Transactional
    public Integer insertPurPurchase(PurPurchase purPurchase) {
        
        //TODO handle date columns here
        //purPurchase.setCreatedTime(new Date());
        //purPurchase.setLastUpdatedTime(new Date());
        //purPurchase.setSubmitTime(new Date());
        //purPurchase.setFlowFinishTime(new Date());
        
        purPurchaseMapper.insertPurPurchase(purPurchase);
        return purPurchase.getId();
    }

    @Transactional
    public int updatePurPurchaseByPKSelective(PurPurchase purPurchase) {
        
        //TODO handle date columns here
        //purPurchase.setCreatedTime(new Date());
        //purPurchase.setLastUpdatedTime(new Date());
        //purPurchase.setSubmitTime(new Date());
        //purPurchase.setFlowFinishTime(new Date());
        
        int result = purPurchaseMapper.updatePurPurchaseByPKSelective(purPurchase);
        return result;
    }

    public PagingRestResponse searchPurPurchase(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = purPurchaseMapper.searchPurPurchaseCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<PurPurchase> resultList = null;
        if(totalRecordNum>0){
            resultList = purPurchaseMapper.searchPurPurchase(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }


    public PurPurchase  getPurchaseOrderByNo(String orderNo){
        PurPurchase purPurchase=purPurchaseMapper.getPurchaseOrderByNo(orderNo,null);

        if(purPurchase!=null){

        }
        return purPurchaseMapper.getPurchaseOrderByNo(orderNo,null);
    }


    public  PurPurchase  getPurchaseDetailByOrderNo(String orderNo){

        PurPurchase purPurchase=purPurchaseMapper.getPurchaseOrderByNo(orderNo,null);

        if(purPurchase!=null){

        }
        return purPurchaseMapper.getPurchaseOrderByNo(orderNo,null);
    }

    public  ShenqingData  getPurchaseInfoByOrderNo(String orderNo){

        Double total=0.00;
        List<Pic> picList= Lists.newArrayList();

        List<ShenqingData> list=purPurchaseMapper.getPurchaseInfoByOrderNo(orderNo);
        ShenqingData shenqingData=new ShenqingData();
        if(!(Objects.isNull(list)||list.isEmpty())){
            for(ShenqingData en :list){
                Pic pic=new Pic();
                shenqingData.setCreateName(en.getCreateName());
                shenqingData.setDept(en.getDept());
                shenqingData.setUseName(en.getUseName());
                shenqingData.setShopName(en.getShopName());
                shenqingData.setShopCode(en.getShopCode());
                shenqingData.setType(en.getType());
                shenqingData.setCreatTime(en.getCreatTime()==null?null:en.getCreatTime().substring(0,10));
                if(en.getPrice()!=null)
                total=NumberUtils.add(total,Double.valueOf(en.getPrice()));
                pic.setCode(en.getCode());
                pic.setName(en.getName());
                pic.setQuality(en.getQuality());
                pic.setUrl(this.picUrl+en.getUrl());
                pic.setPrice(en.getPrice());
                if(Objects.isNull(en.getQuality())
                        ||Objects.isNull(en.getPrice()))
                    continue;
                picList.add(pic);
            }
             shenqingData.setTotalPrice(String.valueOf(total));
             shenqingData.setPicList(picList);
        }
               return   shenqingData;
    }
}