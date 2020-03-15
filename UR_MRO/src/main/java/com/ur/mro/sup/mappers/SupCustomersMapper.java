package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupCustomers;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupCustomersMapper {
    SupCustomers getSupCustomersByPK(Integer pkId);

    int insertSupCustomers(SupCustomers SupCustomers);

    int updateSupCustomersByPKSelective(SupCustomers SupCustomers);

    List<SupCustomers> searchSupCustomers(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupCustomersCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupCustomers> getSupCustomersListBySupplierId(Integer supplierId);

    int deleteSupCustomers(Integer supplierId);
}