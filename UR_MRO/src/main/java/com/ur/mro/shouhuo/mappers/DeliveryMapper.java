
package com.ur.mro.shouhuo.mappers;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;

import java.util.List;

import com.ur.mro.shouhuo.model.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;

import java.util.List;
import java.util.Map;

import com.ur.mro.shouhuo.model.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


    @Mapper
    public interface DeliveryMapper {
        Delivery getDeliveryByPK(Integer pkId);

        int insertDelivery(Delivery Delivery);

        int updateDeliveryByPKSelective(Delivery Delivery);

        List<Delivery> searchDelivery(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

        int searchDeliveryCount(@Param("condList") List<CommonSearchCondition> condList);

        Delivery getDeliveryByShNo(@Param("shNo")String shNo);
        List<Map<String,Object>> getDeliveryTotalCount(@Param("poNo")String poNo,
                                                       @Param("matcode")String matcode,
                                                       @Param("matName")String matName,
                                                       @Param("matSpec")String matSpec,
                                                       @Param("prNo")String prNo,
                                                       @Param("shopNo")String shopNo);

        List<Map<String,Object>> getPurchasePOActualCount(@Param("poNo")String poNo,
                                                          @Param("prNo")String prNo,
                                                          @Param("matCode")String matCode,
                                                          @Param("matName")String matName,
                                                          @Param("matSpec")String matSpec,
                                                          @Param("shopNo")String shopNo);

        List<Map<String,Object>> getPurchaseSHActualCount(
                @Param("poNo")String poNo,
                @Param("prNo")String prNo,
                @Param("matCode") String matCode,
                @Param("matName") String matName,
                @Param("matSpec")String matSpec,
                @Param("shopNo")String shopNo);


        String  getQCHOUT(@Param("poNo")String poNo,
                          @Param("matCode")String matcode,
                          @Param("matName")String matName,
                          @Param("shopNo")String shopNo);


    }
