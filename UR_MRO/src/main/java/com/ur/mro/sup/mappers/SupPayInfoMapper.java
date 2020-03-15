package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupPayInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupPayInfoMapper {
    SupPayInfo getSupPayInfoByPK(Integer pkId);

    int insertSupPayInfo(SupPayInfo SupPayInfo);

    int updateSupPayInfoByPKSelective(SupPayInfo SupPayInfo);

    List<SupPayInfo> searchSupPayInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupPayInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupPayInfo> getSupPayInfoListBySupplierId(Integer supplierId);

    int deleteSupSupPayInfo(Integer supplierId);
}