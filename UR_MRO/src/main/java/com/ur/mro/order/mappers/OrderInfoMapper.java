package com.ur.mro.order.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.order.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderInfoMapper {
    OrderInfo getOrderInfoByPK(Integer pkId);
    List<OrderInfo>   getOrderInfoByOrderId(Integer orderId);
    int insertOrderInfo(OrderInfo OrderInfo);

    int updateOrderInfoByPKSelective(OrderInfo OrderInfo);

    List<OrderInfo> searchOrderInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchOrderInfoCount(@Param("condList") List<CommonSearchCondition> condList);
}