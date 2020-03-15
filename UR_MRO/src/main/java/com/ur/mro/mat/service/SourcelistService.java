package com.ur.mro.mat.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.mat.mappers.SourcelistMapper;
import com.ur.mro.mat.model.Sourcelist;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SourcelistService {
    @Autowired
    SourcelistMapper sourcelistMapper;

    public Sourcelist getSourcelistByPK(Integer pkId) {
        return sourcelistMapper.getSourcelistByPK(pkId);
    }

    @Transactional
    public Integer insertSourcelist(Sourcelist sourcelist) {
        
        //TODO handle date columns here
        //sourcelist.setCreatedTime(new Date());
        //sourcelist.setLastUpdatedTime(new Date());
        
        sourcelistMapper.insertSourcelist(sourcelist);
        return sourcelist.getId();
    }

    @Transactional
    public int updateSourcelistByPKSelective(Sourcelist sourcelist) {
        
        //TODO handle date columns here
        //sourcelist.setCreatedTime(new Date());
        //sourcelist.setLastUpdatedTime(new Date());
        
        int result = sourcelistMapper.updateSourcelistByPKSelective(sourcelist);
        return result;
    }

    public PagingRestResponse searchSourcelist(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = sourcelistMapper.searchSourcelistCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<Sourcelist> resultList = null;
        if(totalRecordNum>0){
            resultList = sourcelistMapper.searchSourcelist(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}