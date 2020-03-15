package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupCustomersMapper;
import com.ur.mro.sup.model.SupCustomers;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupCustomersService {
    @Autowired
    SupCustomersMapper supCustomersMapper;

    public SupCustomers getSupCustomersByPK(Integer pkId) {
        return supCustomersMapper.getSupCustomersByPK(pkId);
    }

    @Transactional
    public Integer insertSupCustomers(SupCustomers supCustomers) {
        
        //TODO handle date columns here
        //supCustomers.setCreatedTime(new Date());
        //supCustomers.setLastUpdatedTime(new Date());
        
        supCustomersMapper.insertSupCustomers(supCustomers);
        return supCustomers.getId();
    }

    @Transactional
    public int updateSupCustomersByPKSelective(SupCustomers supCustomers) {
        
        //TODO handle date columns here
        //supCustomers.setCreatedTime(new Date());
        //supCustomers.setLastUpdatedTime(new Date());
        
        int result = supCustomersMapper.updateSupCustomersByPKSelective(supCustomers);
        return result;
    }

    @Transactional
    public int deleteSupCustomers(Integer supplierID) {

        int result = supCustomersMapper.deleteSupCustomers(supplierID);
        return result;
    }

    public List<SupCustomers> getSupCustomersListBySupplierId(Integer supplierId){
       return supCustomersMapper.getSupCustomersListBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupCustomers(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supCustomersMapper.searchSupCustomersCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupCustomers> resultList = null;
        if(totalRecordNum>0){
            resultList = supCustomersMapper.searchSupCustomers(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}