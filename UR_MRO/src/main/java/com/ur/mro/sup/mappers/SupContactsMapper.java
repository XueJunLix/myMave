package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupContacts;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupContactsMapper {
    SupContacts getSupContactsByPK(Integer pkId);

    int insertSupContacts(SupContacts SupContacts);

    int updateSupContactsByPKSelective(SupContacts SupContacts);

    List<SupContacts> searchSupContacts(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupContactsCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupContacts> getSupContactsListBySupplierId(Integer supplierId);

    int deleteSupContacts(Integer supplierId);
}