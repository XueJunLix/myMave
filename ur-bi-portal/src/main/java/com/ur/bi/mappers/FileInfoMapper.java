package com.ur.bi.mappers;

import com.ur.bi.model.FileInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileInfoMapper {

    int insert(FileInfo fileInfo);

    FileInfo findById(String id);

    List<FileInfo> findByIds(List<String> ids);

    List<FileInfo> list(@Param("fileInfo") FileInfo fileInfo);

    int delete(FileInfo fileInfo);

    int count(@Param("condList") List<CommonSearchCondition> condList);

    List<FileInfo> paging(@Param("condList") List<CommonSearchCondition> condList, @Param("pageBean") PageBean pageBean);
}
