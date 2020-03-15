package com.ur.bi.service;

import com.ur.bi.mappers.FileInfoMapper;
import com.ur.bi.model.FileInfo;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileInfoService {

    private final FileInfoMapper fileInfoMapper;

    @Autowired
    public FileInfoService(FileInfoMapper fileInfoMapper) {
        this.fileInfoMapper = fileInfoMapper;
    }

    public FileInfo findById(String id) {
        return fileInfoMapper.findById(id);
    }

    public int insertFileInfo(FileInfo fileInfo) {
        return fileInfoMapper.insert(fileInfo);
    }

    public int delete(FileInfo fileInfo) {
        return fileInfoMapper.delete(fileInfo);
    }

    public int count(List<CommonSearchCondition> condList) {
        return fileInfoMapper.count(condList);
    }

    public List<FileInfo> paging(List<CommonSearchCondition> condList, PageBean pageBean) {
        return fileInfoMapper.paging(condList, pageBean);
    }
}
