package com.ur.mro.sup.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.sup.model.SupPartners;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupPartnersMapper {
    SupPartners getSupPartnersByPK(Integer pkId);

    int insertSupPartners(SupPartners SupPartners);

    int updateSupPartnersByPKSelective(SupPartners SupPartners);

    List<SupPartners> searchSupPartners(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSupPartnersCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SupPartners> getSupPartnersListBySupplierId(Integer supplierId);

    int deleteSupPartners(Integer supplierId);
}