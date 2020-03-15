package com.ur.admin.usergroup.mappers;

import com.ur.admin.usergroup.model.AdminUserGroup;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminUserGroupMapper {
    AdminUserGroup getAdminUserGroupByPK(Integer pkId);

    int insertAdminUserGroup(AdminUserGroup AdminUserGroup);

    int updateAdminUserGroupByPKSelective(AdminUserGroup AdminUserGroup);

    List<AdminUserGroup> searchAdminUserGroup(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);
    
    List<AdminUserGroup> searchAdminUserGroupDef();

    int searchAdminUserGroupCount(@Param("condList") List<CommonSearchCondition> condList);
}