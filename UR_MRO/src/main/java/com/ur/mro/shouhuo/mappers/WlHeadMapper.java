package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.shouhuo.model.WlHead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WlHeadMapper {
    WlHead getWlHeadByPK(Integer pkId);

    int insertWlHead(WlHead WlHead);

    int updateWlHeadByPKSelective(WlHead WlHead);

    List<WlHead> searchWlHead(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchWlHeadCount(@Param("condList") List<CommonSearchCondition> condList);
}