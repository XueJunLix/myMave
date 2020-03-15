package com.ur.bi.mappers;

import com.ur.bi.model.DesignGrouping;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DesignGroupingMapper {
    int deleteByParams(@Param("condList") List<CommonSearchCondition> condList);

    DesignGrouping getDesignGroupingByPK(Integer pkId);

    int insertDesignGrouping(DesignGrouping DesignGrouping);

    int updateDesignGroupingByPKSelective(DesignGrouping DesignGrouping);

    List<DesignGrouping> searchDesignGrouping(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchDesignGroupingCount(@Param("condList") List<CommonSearchCondition> condList);

    int insertBatchDesignGroupingMapper(List<DesignGrouping> configMonthStandards);

    int updateBatch(@Param("list")List<DesignGrouping> list);

    @Select("select distinct create_by from bi_design_grouping")
    List<String> selectUser();

    int deleteByIdList(@Param("idList")List<Integer> idList);

    int delUpdateByIdList(@Param("idList")List<Integer> idList);

//    @Select("select  id,design_grouping as designGrouping,serial,original_serial as originalSerial ,style,goods_level as goodsLevel,category,create_time as createTime," +
//            "create_by as createBy,modify_time as modifyTime,modify_by as modifyBy,deleted from bi_design_grouping")
    List<DesignGrouping> getDesignGroupings();
}