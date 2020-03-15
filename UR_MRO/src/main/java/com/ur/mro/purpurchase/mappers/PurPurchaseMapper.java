package com.ur.mro.purpurchase.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.purchaseorder.model.PurchaseOrder;
import com.ur.mro.purpurchase.model.PurPurchase;
import com.ur.mro.purpurchase.model.ShenqingData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurPurchaseMapper {
    PurPurchase getPurPurchaseByPK(Integer pkId);

    int insertPurPurchase(PurPurchase PurPurchase);

    int updatePurPurchaseByPKSelective(PurPurchase PurPurchase);

    List<PurPurchase> searchPurPurchase(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchPurPurchaseCount(@Param("condList") List<CommonSearchCondition> condList);

    PurPurchase   getPurchaseOrderByNo(@Param("orderNo") String  orderNo, @Param("djType")String djType);

     List<ShenqingData>   getPurchaseInfoByOrderNo(@Param("orderNo") String  orderNo);
}