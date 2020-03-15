package com.ur.mro.purmatinfo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.purmatinfo.model.PurMatinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurMatinfoMapper {
    PurMatinfo getPurMatinfoByPK(Integer pkId);

    int insertPurMatinfo(PurMatinfo PurMatinfo);

    int updatePurMatinfoByPKSelective(PurMatinfo PurMatinfo);

    List<PurMatinfo> searchPurMatinfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchPurMatinfoCount(@Param("condList") List<CommonSearchCondition> condList);
}