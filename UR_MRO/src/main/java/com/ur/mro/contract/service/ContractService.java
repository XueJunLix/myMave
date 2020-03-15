package com.ur.mro.contract.service;

import com.ur.common.service.BaseService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.util.Date;
import java.util.List;

import com.ur.mro.contract.mappers.ContractMapper;
import com.ur.mro.contract.model.Contract;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractService extends BaseService {
    @Autowired
    ContractMapper contractMapper;

    public Contract getContractByPK(Integer pkId) {
        return contractMapper.getContractByPK(pkId);
    }

    public List<Contract> getContractByShopId(Integer srmShop2gcInfoId){
         return contractMapper.getContractByShopId(srmShop2gcInfoId);
    }

    @Transactional
    public Integer insertContract(Contract contract) {
        
        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
        
        contractMapper.insertContract(contract);
        return contract.getId();
    }

    @Transactional
    public Integer insertBatchContract(List<Contract> list) {

        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
        return   contractMapper.insertBatchContract(list);

    }

    public Integer updateBatchContract(List<Contract> list) {

        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
        return   contractMapper.updateBatchContractInfo(list);

    }


    @Transactional
    public int updateContractByPKSelective(Contract contract) {
        
        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
        int result = contractMapper.updateContractByPKSelective(contract);
        return result;
    }

    @Transactional
    public int deleteContractByPKSelective(Contract contract) {

        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
          contract.setDeleted(1);
         super.setUpdateFields(contract);
        int result = contractMapper.updateContractByPKSelective(contract);
        return result;
    }

    public PagingRestResponse searchContract(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = contractMapper.searchContractCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<Contract> resultList = null;
        if(totalRecordNum>0){
            resultList = contractMapper.searchContract(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public   int  checkData( String code,Integer shopId){
        return contractMapper.checkData(code,shopId);
    }

    @Transactional
    public int updateContractByCodeAndShopId(Contract contract) {

        //TODO handle date columns here
        //contract.setCreatedTime(new Date());
        //contract.setLastUpdatedTime(new Date());
        int result = contractMapper.updateContractByCodeAndShopId(contract);
        return result;
    }

    @Transactional
    public  int deleteContractByShopIdNotCode(Contract contract){
            contract.setDeleted(1);
            super.setUpdateFields(contract);
            return  contractMapper.deleteContractByShopIdNotCode(contract);
    }
}