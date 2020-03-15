package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupBankInfoMapper;
import com.ur.mro.sup.model.SupBankInfo;
import java.util.Date;
import java.util.List;

import com.ur.mro.sup.model.SupContractInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupBankInfoService {
    @Autowired
    SupBankInfoMapper supBankInfoMapper;

    public SupBankInfo getSupBankInfoByPK(Integer pkId) {
        return supBankInfoMapper.getSupBankInfoByPK(pkId);
    }

    @Transactional
    public Integer insertSupBankInfo(SupBankInfo supBankInfo) {
        
        //TODO handle date columns here
        //supBankInfo.setCreatedTime(new Date());
        //supBankInfo.setLastUpdatedTime(new Date());
        
        supBankInfoMapper.insertSupBankInfo(supBankInfo);
        return supBankInfo.getId();
    }

    @Transactional
    public int updateSupBankInfoByPKSelective(SupBankInfo supBankInfo) {
        
        //TODO handle date columns here
        //supBankInfo.setCreatedTime(new Date());
        //supBankInfo.setLastUpdatedTime(new Date());
        
        int result = supBankInfoMapper.updateSupBankInfoByPKSelective(supBankInfo);
        return result;
    }

    @Transactional
    public int deleteSupBankInfo(Integer supplierId) {

        int result = supBankInfoMapper.deleteSupBankInfo(supplierId);
        return result;
    }

    public PagingRestResponse searchSupBankInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supBankInfoMapper.searchSupBankInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupBankInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = supBankInfoMapper.searchSupBankInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }


    public List<SupBankInfo> getSupBankInfoListBysupId(Integer supId){
        return supBankInfoMapper.getSupBankInfoListBySupplierId(supId);
    }
}