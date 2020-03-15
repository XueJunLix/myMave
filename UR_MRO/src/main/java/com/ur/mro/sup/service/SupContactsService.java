package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupContactsMapper;
import com.ur.mro.sup.model.SupContacts;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupContactsService {
    @Autowired
    SupContactsMapper supContactsMapper;

    public SupContacts getSupContactsByPK(Integer pkId) {
        return supContactsMapper.getSupContactsByPK(pkId);
    }

    @Transactional
    public Integer insertSupContacts(SupContacts supContacts) {
        
        //TODO handle date columns here
        //supContacts.setCreatedTime(new Date());
        //supContacts.setLastUpdatedTime(new Date());
        
        supContactsMapper.insertSupContacts(supContacts);
        return supContacts.getId();
    }

    @Transactional
    public int updateSupContactsByPKSelective(SupContacts supContacts) {
        
        //TODO handle date columns here
        //supContacts.setCreatedTime(new Date());
        //supContacts.setLastUpdatedTime(new Date());
        
        int result = supContactsMapper.updateSupContactsByPKSelective(supContacts);
        return result;
    }

    @Transactional
    public int deleteSupContacts(Integer supplierId) {

        int result = supContactsMapper.deleteSupContacts(supplierId);
        return result;
    }

    public List<SupContacts> getSupContactsListBySupplierId(Integer supplierId){
        return supContactsMapper.getSupContactsListBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupContacts(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supContactsMapper.searchSupContactsCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupContacts> resultList = null;
        if(totalRecordNum>0){
            resultList = supContactsMapper.searchSupContacts(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}