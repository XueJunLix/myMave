package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;

import java.util.List;

import com.ur.mro.shouhuo.model.WlItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WlItemMapper {
    WlItem getWlItemByPK(Integer pkId);

    int insertWlItem(WlItem WlItem);

    int updateWlItemByPKSelective(WlItem WlItem);

    List<WlItem> searchWlItem(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchWlItemCount(@Param("condList") List<CommonSearchCondition> condList);
}