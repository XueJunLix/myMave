package com.ur.mro.mat.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.mat.model.Sourcelist;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SourcelistMapper {
    Sourcelist getSourcelistByPK(Integer pkId);

    int insertSourcelist(Sourcelist Sourcelist);

    int updateSourcelistByPKSelective(Sourcelist Sourcelist);

    List<Sourcelist> searchSourcelist(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSourcelistCount(@Param("condList") List<CommonSearchCondition> condList);

    int  insertBatchSourcelist(List<Sourcelist> list);

    int updateBatchSourcelist(List<Sourcelist> list);
}