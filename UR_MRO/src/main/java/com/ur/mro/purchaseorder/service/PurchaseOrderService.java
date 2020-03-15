package com.ur.mro.purchaseorder.service;

import com.ur.common.util.DateUtil;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ur.mro.purchaseorder.mappers.PurchaseOrderMapper;
import com.ur.mro.purchaseorder.model.PurchaseOrder;
import com.ur.mro.purchaseorder.model.PurchaseOrderDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class PurchaseOrderService {
    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;

    public PurchaseOrder getPurchaseOrderByPK(Integer pkId) {
        return purchaseOrderMapper.getPurchaseOrderByPK(pkId);
    }

    @Transactional
    public Integer insertPurchaseOrder(PurchaseOrder purchaseOrder) {
        
        //TODO handle date columns here
        //purchaseOrder.setCreatedTime(new Date());
        //purchaseOrder.setLastUpdatedTime(new Date());
        //purchaseOrder.setSubmitTime(new Date());
        //purchaseOrder.setDhTime(new Date());
        //purchaseOrder.setSupplierShipDate(new Date());
        //purchaseOrder.setSupplierProduceDate(new Date());
        //purchaseOrder.setAppointQcDate(new Date());
        
        purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
        return purchaseOrder.getId();
    }

    @Transactional
    public int updatePurchaseOrderByPKSelective(PurchaseOrder purchaseOrder) {
        
        //TODO handle date columns here
        //purchaseOrder.setCreatedTime(new Date());
        //purchaseOrder.setLastUpdatedTime(new Date());
        //purchaseOrder.setSubmitTime(new Date());
        //purchaseOrder.setDhTime(new Date());
        //purchaseOrder.setSupplierShipDate(new Date());
        //purchaseOrder.setSupplierProduceDate(new Date());
        //purchaseOrder.setAppointQcDate(new Date());
        
        int result = purchaseOrderMapper.updatePurchaseOrderByPKSelective(purchaseOrder);
        return result;
    }

    public PagingRestResponse searchPurchaseOrder(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = purchaseOrderMapper.searchPurchaseOrderCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<PurchaseOrder> resultList = null;
        if(totalRecordNum>0){
            resultList = purchaseOrderMapper.searchPurchaseOrder(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public PurchaseOrder getPurchaseOrderDtoByOrderNo(String orderNo,String djType) {

        PurchaseOrder purchaseOrder = purchaseOrderMapper.getPurchaseOrderByNo(orderNo,djType);
       /* if (purchaseOrder != null) {
            purchaseOrderDto =this.get(purchaseOrder.getId());
        }*/
        return purchaseOrder;
    }


}