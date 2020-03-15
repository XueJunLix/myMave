package com.ur.admin.role.mappers;

import com.ur.admin.role.model.AdminRoleInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminRoleInfoMapper {
    AdminRoleInfo getAdminRoleInfoByPK(Integer pkId);

    int insertAdminRoleInfo(AdminRoleInfo AdminRoleInfo);

    int updateAdminRoleInfoByPKSelective(AdminRoleInfo AdminRoleInfo);

    List<AdminRoleInfo> searchAdminRoleInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchAdminRoleInfoCount(@Param("condList") List<CommonSearchCondition> condList);
    
}