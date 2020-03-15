package com.ur.mro.sup.service;

import com.ur.common.service.BaseService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupContractInfoMapper;
import com.ur.mro.sup.mappers.SupplierHbMapper;
import com.ur.mro.sup.mappers.SupplierMapper;
import com.ur.mro.sup.model.SupContractInfo;
import com.ur.mro.sup.model.Supplier;
import java.util.Date;
import java.util.List;

import com.ur.mro.sup.model.SupplierHb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierService extends BaseService{
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierHbMapper supplierHbMapper;

    @Autowired
    SupContractInfoMapper supContractInfoMapper;

    public Supplier getSupplierByPK(Integer pkId) {
        return supplierMapper.getSupplierByPK(pkId);
    }

    @Transactional
    public Integer insertSupplier(Supplier supplier) {

        //TODO handle date columns here
        //supplier.setFoundingTime(new Date());
        //supplier.setCreatedTime(new Date());
        //supplier.setLastUpdatedTime(new Date());

        supplierMapper.insertSupplier(supplier);
        return supplier.getId();
    }

    @Transactional
    public int updateSupplierByPKSelective(Supplier supplier) {

        //TODO handle date columns here
        //supplier.setFoundingTime(new Date());
        //supplier.setCreatedTime(new Date());
        //supplier.setLastUpdatedTime(new Date());

        int result = supplierMapper.updateSupplierByPKSelective(supplier);
        return result;
    }

    @Transactional
    public int deleteSupplier(Integer id) {

        int result = supplierMapper.deleteSupplier(id);
        return result;
    }

    public PagingRestResponse searchSupplier(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {

        int totalRecordNum = supplierMapper.searchSupplierCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);

        List<Supplier> resultList = null;
        if(totalRecordNum>0){
            resultList = supplierMapper.searchSupplier(selectFields, condList, orderByList, pageBean);
        }

        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
    public Supplier getSupplierByNo(String code, String djType){
        return supplierMapper.getSupplierByNo(code,djType);
    }
}