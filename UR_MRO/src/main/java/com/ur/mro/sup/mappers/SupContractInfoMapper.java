package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupContractInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupContractInfoMapper {
    SupContractInfo getSupContractInfoByPK(Integer pkId);

    int insertSupContractInfo(SupContractInfo SupContractInfo);

    int updateSupContractInfoByPKSelective(SupContractInfo SupContractInfo);

    List<SupContractInfo> searchSupContractInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupContractInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupContractInfo> getSupContractInfoListBysupId(Integer supId);

    int deleteSupContractInfo(Integer supId);
}