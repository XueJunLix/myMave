package com.ur.bi.mappers;

import com.ur.bi.model.MonthStandard;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MonthStandardMapper {
    MonthStandard getMonthStandardByPK(Integer pkId);

    int insertMonthStandard(MonthStandard MonthStandard);

    int updateMonthStandardByPKSelective(MonthStandard MonthStandard);

    List<MonthStandard> searchMonthStandard(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchMonthStandardCount(@Param("condList") List<CommonSearchCondition> condList);
}