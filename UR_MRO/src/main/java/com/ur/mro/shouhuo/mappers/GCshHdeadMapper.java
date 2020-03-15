package com.ur.mro.shouhuo.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.shouhuo.model.GCshHdead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GCshHdeadMapper {
    GCshHdead getGCshHdeadByPK(Integer pkId);

    int insertGCshHdead(GCshHdead GCshHdead);

    int updateGCshHdeadByPKSelective(GCshHdead GCshHdead);

    List<GCshHdead> searchGCshHdead(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean,@Param("userName")String userName);

    int searchGCshHdeadCount(@Param("condList") List<CommonSearchCondition> condList,@Param("userName")String userName);

    GCshHdead findGCshHeadByShno(@Param("shNo")String shNo);

}