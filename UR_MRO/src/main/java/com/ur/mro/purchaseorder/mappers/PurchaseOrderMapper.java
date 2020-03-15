package com.ur.mro.purchaseorder.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.purchaseorder.model.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseOrderMapper {
    PurchaseOrder getPurchaseOrderByPK(Integer pkId);

    int insertPurchaseOrder(PurchaseOrder PurchaseOrder);

    int updatePurchaseOrderByPKSelective(PurchaseOrder PurchaseOrder);

    List<PurchaseOrder> searchPurchaseOrder(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchPurchaseOrderCount(@Param("condList") List<CommonSearchCondition> condList);

     PurchaseOrder getPurchaseOrderByNo(@Param("orderNo") String  orderNo,@Param("djType")String djType);
}