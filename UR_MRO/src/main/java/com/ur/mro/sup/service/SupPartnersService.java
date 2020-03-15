package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupPartnersMapper;
import com.ur.mro.sup.model.SupPartners;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupPartnersService {
    @Autowired
    SupPartnersMapper supPartnersMapper;

    public SupPartners getSupPartnersByPK(Integer pkId) {
        return supPartnersMapper.getSupPartnersByPK(pkId);
    }

    @Transactional
    public Integer insertSupPartners(SupPartners supPartners) {
        
        //TODO handle date columns here
        //supPartners.setCreatedTime(new Date());
        //supPartners.setLastUpdatedTime(new Date());
        
        supPartnersMapper.insertSupPartners(supPartners);
        return supPartners.getId();
    }

    @Transactional
    public int updateSupPartnersByPKSelective(SupPartners supPartners) {
        
        //TODO handle date columns here
        //supPartners.setCreatedTime(new Date());
        //supPartners.setLastUpdatedTime(new Date());
        
        int result = supPartnersMapper.updateSupPartnersByPKSelective(supPartners);
        return result;
    }

    @Transactional
    public int deleteSupPartners(Integer supplierId) {

        int result = supPartnersMapper.deleteSupPartners(supplierId);
        return result;
    }

    public List<SupPartners> getSupPartnersListBySupplierId(Integer supplierId){
        return supPartnersMapper.getSupPartnersListBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupPartners(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supPartnersMapper.searchSupPartnersCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupPartners> resultList = null;
        if(totalRecordNum>0){
            resultList = supPartnersMapper.searchSupPartners(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}