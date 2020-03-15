package com.ur.mro.role.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;

import com.ur.mro.role.model.UserRoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleInfoMapper {
    UserRoleInfo getUserRoleInfoByPK(Integer pkId);

    int insertUserRoleInfo(UserRoleInfo UserRoleInfo);
     int insertBatchUserRoleInfo(@Param("list")List<UserRoleInfo> UserRoleInfo);
    int updateUserRoleInfoByPKSelective(UserRoleInfo UserRoleInfo);

    List<UserRoleInfo> searchUserRoleInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchUserRoleInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    List<UserRoleInfo> findUsername(@Param("userName") String userName);
}