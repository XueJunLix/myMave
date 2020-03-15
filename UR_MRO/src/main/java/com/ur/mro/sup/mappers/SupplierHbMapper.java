package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupplierHb;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupplierHbMapper {
    SupplierHb getSupplierHbByPK(Integer pkId);

    List<SupplierHb> searchSupplierHb(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupplierHbCount(@Param("condList") List<CommonSearchCondition> condList);

    String getSupCodeNum(String type);
}