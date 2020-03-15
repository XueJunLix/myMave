package com.ur.mro.shop.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.shop.model.Shop2GC;
import com.ur.mro.shop.model.Shop2GCDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Shop2GCMapper {
    Shop2GC getShop2GCByPK(Integer pkId);

    int insertShop2GC(Shop2GC Shop2GC);

    int updateShop2GCByPKSelective(Shop2GC Shop2GC);

    List<Shop2GC> searchShop2GC(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchShop2GCCount(@Param("condList") List<CommonSearchCondition> condList);

    int  checkData(@Param("code") String code,@Param("name") String name);

      int  updateShop2GCByCode(Shop2GC shop2GC);

      int  updateBatchShop2GC(@Param("list") List<Shop2GC> shop2GCList);

      List<Shop2GC> getMasterIdByNameAndCode(@Param("list") List<Shop2GCDTO> shop2GCDTOList);

      List<Shop2GC>   findByStoreId(@Param("code")  String code);
}