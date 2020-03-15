package com.ur.admin.button.mappers;

import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminButtonInfoMapper {
    AdminButtonInfo getAdminButtonInfoByPK(Integer pkId);

    int insertAdminButtonInfo(AdminButtonInfo AdminButtonInfo);

    int updateAdminButtonInfoByPKSelective(AdminButtonInfo AdminButtonInfo);

    List<AdminButtonInfo> searchAdminButtonInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchAdminButtonInfoCount(@Param("condList") List<CommonSearchCondition> condList);
}