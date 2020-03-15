package com.ur.admin.menu.mappers;

import com.ur.admin.menu.model.AdminMenuInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMenuInfoMapper {
    AdminMenuInfo getAdminMenuInfoByPK(Integer pkId);

    int insertAdminMenuInfo(AdminMenuInfo AdminMenuInfo);

    int updateAdminMenuInfoByPKSelective(AdminMenuInfo AdminMenuInfo);

    List<AdminMenuInfo> searchAdminMenuInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchAdminMenuInfoCount(@Param("condList") List<CommonSearchCondition> condList);
   
}