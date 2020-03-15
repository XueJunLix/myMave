package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupEquipmertsMapper;
import com.ur.mro.sup.model.SupEquipmerts;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupEquipmertsService {
    @Autowired
    SupEquipmertsMapper supEquipmertsMapper;

    public SupEquipmerts getSupEquipmertsByPK(Integer pkId) {
        return supEquipmertsMapper.getSupEquipmertsByPK(pkId);
    }

    @Transactional
    public Integer insertSupEquipmerts(SupEquipmerts supEquipmerts) {
        
        //TODO handle date columns here
        //supEquipmerts.setCreatedTime(new Date());
        //supEquipmerts.setLastUpdatedTime(new Date());
        
        supEquipmertsMapper.insertSupEquipmerts(supEquipmerts);
        return supEquipmerts.getId();
    }

    @Transactional
    public int updateSupEquipmertsByPKSelective(SupEquipmerts supEquipmerts) {
        
        //TODO handle date columns here
        //supEquipmerts.setCreatedTime(new Date());
        //supEquipmerts.setLastUpdatedTime(new Date());
        
        int result = supEquipmertsMapper.updateSupEquipmertsByPKSelective(supEquipmerts);
        return result;
    }

    @Transactional
    public int deleteSupEquipmerts(Integer supplierId) {

        int result = supEquipmertsMapper.deleteSupEquipmerts(supplierId);
        return result;
    }


    public List<SupEquipmerts>getSupEquipmertsListBySupplierId(Integer supplierId){
        return supEquipmertsMapper.getSupEquipmertsListBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupEquipmerts(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supEquipmertsMapper.searchSupEquipmertsCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupEquipmerts> resultList = null;
        if(totalRecordNum>0){
            resultList = supEquipmertsMapper.searchSupEquipmerts(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}