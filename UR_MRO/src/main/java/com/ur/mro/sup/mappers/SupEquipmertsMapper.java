package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupEquipmerts;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupEquipmertsMapper {
    SupEquipmerts getSupEquipmertsByPK(Integer pkId);

    int insertSupEquipmerts(SupEquipmerts SupEquipmerts);

    int updateSupEquipmertsByPKSelective(SupEquipmerts SupEquipmerts);

    List<SupEquipmerts> searchSupEquipmerts(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupEquipmertsCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupEquipmerts> getSupEquipmertsListBySupplierId(Integer supplierId);

    int deleteSupEquipmerts(Integer supplierId);
}