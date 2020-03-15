package com.ur.mro.contract.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.contract.model.Contract;
import com.ur.mro.mat.model.MaterialInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContractMapper {
    Contract getContractByPK(Integer pkId);
     List<Contract> getContractByShopId(@Param("srmShop2gcInfoId")Integer srmShop2gcInfoId);

    int insertContract(Contract Contract);

    int updateContractByPKSelective(Contract Contract);

    List<Contract> searchContract(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchContractCount(@Param("condList") List<CommonSearchCondition> condList);

    int insertBatchContract(@Param("list") List<Contract> ContractInfoList);

     int updateBatchContractInfo(@Param("list") List<Contract> ContractInfoList);

     int  checkData(@Param("code") String code,@Param("shopId") Integer shopId);

     int  updateContractByCodeAndShopId(Contract Contract);

     int  deleteContractByShopIdNotCode(Contract Contract);
}