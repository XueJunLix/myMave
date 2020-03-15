package com.ur.admin.user.mappers;

import com.ur.admin.user.model.SysUserInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserInfoMapper {

    SysUserInfo getSysUserInfoByPK(Integer pkId);

    int insertSysUserInfo(SysUserInfo SysUserInfo);

    int updateSysUserInfoByPKSelective(SysUserInfo SysUserInfo);

    List<SysUserInfo> searchSysUserInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSysUserInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    List<SysUserInfo> getAllSysUserInfo();

   int  findUsername(@Param("userName") String userName);
}