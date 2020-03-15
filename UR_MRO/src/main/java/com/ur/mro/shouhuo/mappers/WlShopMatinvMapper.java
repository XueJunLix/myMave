package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.shouhuo.model.WlShopMatinv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WlShopMatinvMapper {
    WlShopMatinv getWlShopMatinvByPK(Integer pkId);

    int insertWlShopMatinv(WlShopMatinv WlShopMatinv);

    int updateWlShopMatinvByPKSelective(WlShopMatinv WlShopMatinv);

    List<WlShopMatinv> searchWlShopMatinv(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchWlShopMatinvCount(@Param("condList") List<CommonSearchCondition> condList);

    WlShopMatinv  getWlShopMatinvByShidCodee(
            @Param("supNo")String supNo,
            @Param("shNo")String shNo,
            @Param("poNo")String poNo,
            @Param("shopNo")String shopNo,
            @Param("matCode")String matCode
    );
}