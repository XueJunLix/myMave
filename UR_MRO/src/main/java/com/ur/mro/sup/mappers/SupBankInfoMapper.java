package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupBankInfo;
import java.util.List;

import com.ur.mro.sup.model.SupContractInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupBankInfoMapper {
    SupBankInfo getSupBankInfoByPK(Integer pkId);

    int insertSupBankInfo(SupBankInfo SupBankInfo);

    int updateSupBankInfoByPKSelective(SupBankInfo SupBankInfo);

    List<SupBankInfo> searchSupBankInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupBankInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupBankInfo> getSupBankInfoListBySupplierId(Integer supplierId);

    int  deleteSupBankInfo(Integer supplierId);
}