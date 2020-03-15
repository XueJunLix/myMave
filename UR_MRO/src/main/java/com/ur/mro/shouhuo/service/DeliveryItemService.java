package com.ur.mro.shouhuo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;

import com.ur.mro.shouhuo.mappers.DeliveryItemMapper;
import com.ur.mro.shouhuo.model.DeliveryItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryItemService {
    @Autowired
    DeliveryItemMapper deliveryItemMapper;

    public DeliveryItem getDeliveryItemByPK(Integer pkId) {
        return deliveryItemMapper.getDeliveryItemByPK(pkId);
    }

    @Transactional
    public Integer insertDeliveryItem(DeliveryItem deliveryItem) {
        
        //TODO handle date columns here
        //deliveryItem.setCreatedTime(new Date());
        //deliveryItem.setLastUpdatedTime(new Date());
        
        deliveryItemMapper.insertDeliveryItem(deliveryItem);
        return deliveryItem.getId();
    }

    @Transactional
    public int updateDeliveryItemByPKSelective(DeliveryItem deliveryItem) {
        
        //TODO handle date columns here
        //deliveryItem.setCreatedTime(new Date());
        //deliveryItem.setLastUpdatedTime(new Date());
        
        int result = deliveryItemMapper.updateDeliveryItemByPKSelective(deliveryItem);
        return result;
    }

    public PagingRestResponse searchDeliveryItem(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = deliveryItemMapper.searchDeliveryItemCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<DeliveryItem> resultList = null;
        if(totalRecordNum>0){
            resultList = deliveryItemMapper.searchDeliveryItem(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public void insertBatchDeliveryItem(@Param("list")List<DeliveryItem> deliveryItemList){
          deliveryItemMapper.insertBatchDeliveryItem(deliveryItemList);
    }

    public  int updateBathcDeliveryItemByPKSelective(@Param("list")List<DeliveryItem> deliveryItemList){
        return deliveryItemMapper.updateBathcDeliveryItemByPKSelective(deliveryItemList);
    }
}