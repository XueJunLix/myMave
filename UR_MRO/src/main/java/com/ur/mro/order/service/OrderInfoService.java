package com.ur.mro.order.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;

import com.ur.mro.order.mappers.OrderInfoMapper;
import com.ur.mro.order.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderInfoService {
    @Autowired
    OrderInfoMapper orderInfoMapper;

    public OrderInfo getOrderInfoByPK(Integer pkId) {
        return orderInfoMapper.getOrderInfoByPK(pkId);
    }

    @Transactional
    public Integer insertOrderInfo(OrderInfo orderInfo) {
        
        //TODO handle date columns here
        //orderInfo.setCreatedTime(new Date());
        //orderInfo.setLastUpdatedTime(new Date());
        //orderInfo.setDeliveryDate(new Date());
        //orderInfo.setReturnDate(new Date());
        //orderInfo.setZjTime(new Date());
        //orderInfo.setContractDeliverydate(new Date());
        //orderInfo.setExpectedDelivery(new Date());
        //orderInfo.setMakeFinishTime(new Date());
        
        orderInfoMapper.insertOrderInfo(orderInfo);
        return orderInfo.getId();
    }

    @Transactional
    public int updateOrderInfoByPKSelective(OrderInfo orderInfo) {
        
        //TODO handle date columns here
        //orderInfo.setCreatedTime(new Date());
        //orderInfo.setLastUpdatedTime(new Date());
        //orderInfo.setDeliveryDate(new Date());
        //orderInfo.setReturnDate(new Date());
        //orderInfo.setZjTime(new Date());
        //orderInfo.setContractDeliverydate(new Date());
        //orderInfo.setExpectedDelivery(new Date());
        //orderInfo.setMakeFinishTime(new Date());
        
        int result = orderInfoMapper.updateOrderInfoByPKSelective(orderInfo);
        return result;
    }

    public PagingRestResponse searchOrderInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = orderInfoMapper.searchOrderInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<OrderInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = orderInfoMapper.searchOrderInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}