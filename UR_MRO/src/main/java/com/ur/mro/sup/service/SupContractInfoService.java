package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupContractInfoMapper;
import com.ur.mro.sup.model.SupContractInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupContractInfoService {
    @Autowired
    SupContractInfoMapper supContractInfoMapper;

    public SupContractInfo getSupContractInfoByPK(Integer pkId) {
        return supContractInfoMapper.getSupContractInfoByPK(pkId);
    }

    @Transactional
    public Integer insertSupContractInfo(SupContractInfo supContractInfo) {

        
        supContractInfoMapper.insertSupContractInfo(supContractInfo);
        return supContractInfo.getId();
    }

    @Transactional
    public int updateSupContractInfoByPKSelective(SupContractInfo supContractInfo) {
        
        //TODO handle date columns here
        //supContractInfo.setCreatedTime(new Date());
        //supContractInfo.setLastUpdatedTime(new Date());
        //supContractInfo.setPriceStartDate(new Date());
        //supContractInfo.setPriceEndDate(new Date());
        
        int result = supContractInfoMapper.updateSupContractInfoByPKSelective(supContractInfo);
        return result;
    }

    @Transactional
    public int deleteSupContractInfo(Integer supplierId) {

        int result = supContractInfoMapper.deleteSupContractInfo(supplierId);
        return result;
    }



    public PagingRestResponse searchSupContractInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supContractInfoMapper.searchSupContractInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupContractInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = supContractInfoMapper.searchSupContractInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public List<SupContractInfo> getSupContractInfoListBysupId(Integer supId){
        return supContractInfoMapper.getSupContractInfoListBysupId(supId);
    }
}