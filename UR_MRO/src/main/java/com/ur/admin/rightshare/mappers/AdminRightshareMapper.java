package com.ur.admin.rightshare.mappers;

import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminRightshareMapper {
    AdminRightshare getAdminRightshareByPK(Integer pkId);

    int insertAdminRightshare(AdminRightshare AdminRightshare);

    int updateAdminRightshareByPKSelective(AdminRightshare AdminRightshare);

    List<AdminRightshare> searchAdminRightshare(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchAdminRightshareCount(@Param("condList") List<CommonSearchCondition> condList);
    
    void deleteAdminRightshareByPKSelective(AdminRightshare AdminRightshare);
}