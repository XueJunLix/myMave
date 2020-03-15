package com.ur.common.mappers;

import com.ur.common.model.SysSerialNumber;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysSerialNumberMapper {
    SysSerialNumber getSysSerialNumberByPK(Integer pkId);

    int insertSysSerialNumber(SysSerialNumber SysSerialNumber);

    int updateSysSerialNumberByPKSelective(SysSerialNumber SysSerialNumber);

    List<SysSerialNumber> searchSysSerialNumber(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchSysSerialNumberCount(@Param("condList") List<CommonSearchCondition> condList);

    SysSerialNumber findByCategory(String category);



}