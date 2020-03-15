package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupPayInfoMapper;
import com.ur.mro.sup.model.SupPayInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupPayInfoService {
    @Autowired
    SupPayInfoMapper supPayInfoMapper;

    public SupPayInfo getSupPayInfoByPK(Integer pkId) {
        return supPayInfoMapper.getSupPayInfoByPK(pkId);
    }

    @Transactional
    public Integer insertSupPayInfo(SupPayInfo supPayInfo) {
        
        //TODO handle date columns here
        //supPayInfo.setCreatedTime(new Date());
        //supPayInfo.setLastUpdatedTime(new Date());
        
        supPayInfoMapper.insertSupPayInfo(supPayInfo);
        return supPayInfo.getId();
    }

    @Transactional
    public int updateSupPayInfoByPKSelective(SupPayInfo supPayInfo) {
        
        //TODO handle date columns here
        //supPayInfo.setCreatedTime(new Date());
        //supPayInfo.setLastUpdatedTime(new Date());
        
        int result = supPayInfoMapper.updateSupPayInfoByPKSelective(supPayInfo);
        return result;
    }

    @Transactional
    public int deleteSupSupPayInfo(Integer supplierId) {

        int result = supPayInfoMapper.deleteSupSupPayInfo(supplierId);
        return result;
    }

    public List<SupPayInfo> getSupPayInfoListBySupplierId(Integer supplierId){
        return supPayInfoMapper.getSupPayInfoListBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupPayInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supPayInfoMapper.searchSupPayInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupPayInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = supPayInfoMapper.searchSupPayInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}