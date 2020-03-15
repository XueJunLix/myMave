package com.ur.mro.shouhuo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.util.Date;
import java.util.List;

import com.ur.mro.shouhuo.mappers.GcshItemMapper;
import com.ur.mro.shouhuo.model.GcshItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GcshItemService {
    @Autowired
    GcshItemMapper gcshItemMapper;

    public GcshItem getGcshItemByPK(Integer pkId) {
        return gcshItemMapper.getGcshItemByPK(pkId);
    }

    @Transactional
    public Integer insertGcshItem(GcshItem gcshItem) {
        
        //TODO handle date columns here
        //gcshItem.setCreatedTime(new Date());
        //gcshItem.setLastUpdatedTime(new Date());
        //gcshItem.setSignDate(new Date());
        
        gcshItemMapper.insertGcshItem(gcshItem);
        return gcshItem.getId();
    }

    @Transactional
    public int updateGcshItemByPKSelective(GcshItem gcshItem) {
        
        //TODO handle date columns here
        //gcshItem.setCreatedTime(new Date());
        //gcshItem.setLastUpdatedTime(new Date());
        //gcshItem.setSignDate(new Date());
        
        int result = gcshItemMapper.updateGcshItemByPKSelective(gcshItem);
        return result;
    }

    public PagingRestResponse searchGcshItem(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = gcshItemMapper.searchGcshItemCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<GcshItem> resultList = null;
        if(totalRecordNum>0){
            resultList = gcshItemMapper.searchGcshItem(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}