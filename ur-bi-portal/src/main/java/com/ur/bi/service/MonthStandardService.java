package com.ur.bi.service;

import com.ur.bi.mappers.MonthStandardMapper;
import com.ur.bi.model.MonthStandard;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonthStandardService {

    @Autowired
    MonthStandardMapper monthStandardMapper;

    public MonthStandard getMonthStandardByPK(Integer pkId) {
        return monthStandardMapper.getMonthStandardByPK(pkId);
    }

    @Transactional
    public Integer insertMonthStandard(MonthStandard monthStandard) {
        
        //TODO handle date columns here
        //monthStandard.setCreateTime(new Date());
        //monthStandard.setModifyTime(new Date());
        
        monthStandardMapper.insertMonthStandard(monthStandard);
        return monthStandard.getId();
    }

    @Transactional
    public int updateMonthStandardByPKSelective(MonthStandard monthStandard) {
        
        //TODO handle date columns here
        //monthStandard.setCreateTime(new Date());
        //monthStandard.setModifyTime(new Date());
        
        int result = monthStandardMapper.updateMonthStandardByPKSelective(monthStandard);
        return result;
    }

    public PagingRestResponse searchMonthStandard(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = monthStandardMapper.searchMonthStandardCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<MonthStandard> resultList = null;
        if(totalRecordNum>0){
            resultList = monthStandardMapper.searchMonthStandard(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}