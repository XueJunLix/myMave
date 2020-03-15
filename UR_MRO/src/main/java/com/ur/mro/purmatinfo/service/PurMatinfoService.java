package com.ur.mro.purmatinfo.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import java.util.Date;
import java.util.List;

import com.ur.mro.purmatinfo.mappers.PurMatinfoMapper;
import com.ur.mro.purmatinfo.model.PurMatinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurMatinfoService {
    @Autowired
    PurMatinfoMapper purMatinfoMapper;

    public PurMatinfo getPurMatinfoByPK(Integer pkId) {
        return purMatinfoMapper.getPurMatinfoByPK(pkId);
    }

    @Transactional
    public Integer insertPurMatinfo(PurMatinfo purMatinfo) {
        
        //TODO handle date columns here
        //purMatinfo.setCreatedTime(new Date());
        //purMatinfo.setLastUpdatedTime(new Date());
        //purMatinfo.setDeliveryDate(new Date());
        //purMatinfo.setExpectedArrivalDate(new Date());
        //purMatinfo.setPlanUseData(new Date());
        //purMatinfo.setOrderHandledTime(new Date());
        //purMatinfo.setDdDate(new Date());
        //purMatinfo.setMinDate(new Date());
        //purMatinfo.setTheLastOrderDate(new Date());
        
        purMatinfoMapper.insertPurMatinfo(purMatinfo);
        return purMatinfo.getId();
    }

    @Transactional
    public int updatePurMatinfoByPKSelective(PurMatinfo purMatinfo) {
        
        //TODO handle date columns here
        //purMatinfo.setCreatedTime(new Date());
        //purMatinfo.setLastUpdatedTime(new Date());
        //purMatinfo.setDeliveryDate(new Date());
        //purMatinfo.setExpectedArrivalDate(new Date());
        //purMatinfo.setPlanUseData(new Date());
        //purMatinfo.setOrderHandledTime(new Date());
        //purMatinfo.setDdDate(new Date());
        //purMatinfo.setMinDate(new Date());
        //purMatinfo.setTheLastOrderDate(new Date());
        
        int result = purMatinfoMapper.updatePurMatinfoByPKSelective(purMatinfo);
        return result;
    }

    public PagingRestResponse searchPurMatinfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = purMatinfoMapper.searchPurMatinfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<PurMatinfo> resultList = null;
        if(totalRecordNum>0){
            resultList = purMatinfoMapper.searchPurMatinfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}