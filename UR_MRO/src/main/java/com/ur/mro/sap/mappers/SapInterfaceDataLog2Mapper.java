package com.ur.mro.sap.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.sap.model.SapInterfaceDataLog2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SapInterfaceDataLog2Mapper {
    SapInterfaceDataLog2 getSapInterfaceDataLog2ByPK(Integer pkId);

    int insertSapInterfaceDataLog2(SapInterfaceDataLog2 SapInterfaceDataLog2);

    int updateSapInterfaceDataLog2ByPKSelective(SapInterfaceDataLog2 SapInterfaceDataLog2);

    List<SapInterfaceDataLog2> searchSapInterfaceDataLog2(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSapInterfaceDataLog2Count(@Param("condList") List<CommonSearchCondition> condList);
}