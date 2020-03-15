package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupWorkers;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupWorkersMapper {
    SupWorkers getSupWorkersByPK(Integer pkId);

    int insertSupWorkers(SupWorkers SupWorkers);

    int updateSupWorkersByPKSelective(SupWorkers SupWorkers);

    List<SupWorkers> searchSupWorkers(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupWorkersCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupWorkers> getSupWorkersBySupplierId(Integer supplierId);

    int deleteSupSupPayInfo(Integer supplierId);
}