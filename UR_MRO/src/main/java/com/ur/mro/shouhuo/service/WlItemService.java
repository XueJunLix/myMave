package com.ur.mro.shouhuo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;

import com.ur.mro.shouhuo.mappers.WlItemMapper;
import com.ur.mro.shouhuo.model.WlItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WlItemService {
    @Autowired
    WlItemMapper wlItemMapper;

    public WlItem getWlItemByPK(Integer pkId) {
        return wlItemMapper.getWlItemByPK(pkId);
    }

    @Transactional
    public Integer insertWlItem(WlItem wlItem) {
        
        //TODO handle date columns here
        //wlItem.setCreatedTime(new Date());
        //wlItem.setLastUpdatedTime(new Date());
        
        wlItemMapper.insertWlItem(wlItem);
        return wlItem.getId();
    }

    @Transactional
    public int updateWlItemByPKSelective(WlItem wlItem) {
        
        //TODO handle date columns here
        //wlItem.setCreatedTime(new Date());
        //wlItem.setLastUpdatedTime(new Date());
        
        int result = wlItemMapper.updateWlItemByPKSelective(wlItem);
        return result;
    }

    public PagingRestResponse searchWlItem(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = wlItemMapper.searchWlItemCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<WlItem> resultList = null;
        if(totalRecordNum>0){
            resultList = wlItemMapper.searchWlItem(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}