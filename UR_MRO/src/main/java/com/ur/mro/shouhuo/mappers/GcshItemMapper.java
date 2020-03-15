package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.shouhuo.model.GcshItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GcshItemMapper {
    GcshItem getGcshItemByPK(Integer pkId);

    int insertGcshItem(GcshItem GcshItem);

    int updateGcshItemByPKSelective(GcshItem GcshItem);

    List<GcshItem> searchGcshItem(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchGcshItemCount(@Param("condList") List<CommonSearchCondition> condList);

    List<GcshItem>  getListGcshItemByShId(Integer shId);
}