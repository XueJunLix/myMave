package com.ur.mro.shouhuo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.util.List;

import com.ur.mro.shouhuo.mappers.WlHeadMapper;
import com.ur.mro.shouhuo.model.WlHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WlHeadService {
    @Autowired
    WlHeadMapper wlHeadMapper;

    public WlHead getWlHeadByPK(Integer pkId) {
        return wlHeadMapper.getWlHeadByPK(pkId);
    }

    @Transactional
    public Integer insertWlHead(WlHead wlHead) {
        
        //TODO handle date columns here
        //wlHead.setYjddTime(new Date());
        //wlHead.setCreatedTime(new Date());
        //wlHead.setLastUpdatedTime(new Date());
        //wlHead.setActualTime(new Date());
        
        wlHeadMapper.insertWlHead(wlHead);
        return wlHead.getId();
    }

    @Transactional
    public int updateWlHeadByPKSelective(WlHead wlHead) {
        
        //TODO handle date columns here
        //wlHead.setYjddTime(new Date());
        //wlHead.setCreatedTime(new Date());
        //wlHead.setLastUpdatedTime(new Date());
        //wlHead.setActualTime(new Date());
        
        int result = wlHeadMapper.updateWlHeadByPKSelective(wlHead);
        return result;
    }

    public PagingRestResponse searchWlHead(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = wlHeadMapper.searchWlHeadCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<WlHead> resultList = null;
        if(totalRecordNum>0){
            resultList = wlHeadMapper.searchWlHead(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}