package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;

import java.util.List;

import com.ur.mro.shouhuo.model.DeliveryItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeliveryItemMapper {
    DeliveryItem getDeliveryItemByPK(Integer pkId);

    int insertDeliveryItem(DeliveryItem DeliveryItem);
    int  insertBatchDeliveryItem(@Param("list")List<DeliveryItem> deliveryItemList);
    int updateDeliveryItemByPKSelective(DeliveryItem DeliveryItem);
    int updateBathcDeliveryItemByPKSelective(@Param("list")List<DeliveryItem> deliveryItemList);

    List<DeliveryItem> searchDeliveryItem(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchDeliveryItemCount(@Param("condList") List<CommonSearchCondition> condList);
    List<DeliveryItem> getDeliveryItemByShId(@Param("shItemId")String  shItemId);
}