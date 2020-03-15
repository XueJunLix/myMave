package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.Supplier;
import java.util.List;

import com.ur.mro.sup.model.SupplierHb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupplierMapper {
    Supplier getSupplierByPK(Integer pkId);

    Integer insertSupplier(Supplier Supplier);

    int updateSupplierByPKSelective(Supplier Supplier);

    List<Supplier> searchSupplier(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupplierCount(@Param("condList") List<CommonSearchCondition> condList);

    int  deleteSupplier(Integer id);

    Supplier getSupplierByNo(@Param("code") String code, @Param("djType") String djType);


}