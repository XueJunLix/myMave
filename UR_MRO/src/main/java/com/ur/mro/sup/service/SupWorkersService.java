package com.ur.mro.sup.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.sup.mappers.SupWorkersMapper;
import com.ur.mro.sup.model.SupWorkers;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupWorkersService {
    @Autowired
    SupWorkersMapper supWorkersMapper;

    public SupWorkers getSupWorkersByPK(Integer pkId) {
        return supWorkersMapper.getSupWorkersByPK(pkId);
    }

    @Transactional
    public Integer insertSupWorkers(SupWorkers supWorkers) {
        
        //TODO handle date columns here
        //supWorkers.setCreatedTime(new Date());
        //supWorkers.setLastUpdatedTime(new Date());
        
        supWorkersMapper.insertSupWorkers(supWorkers);
        return supWorkers.getId();
    }

    @Transactional
    public int updateSupWorkersByPKSelective(SupWorkers supWorkers) {
        
        //TODO handle date columns here
        //supWorkers.setCreatedTime(new Date());
        //supWorkers.setLastUpdatedTime(new Date());
        
        int result = supWorkersMapper.updateSupWorkersByPKSelective(supWorkers);
        return result;
    }

    @Transactional
    public int deleteSupSupPayInfo(Integer supplierId) {

        int result = supWorkersMapper.deleteSupSupPayInfo(supplierId);
        return result;
    }


    public List<SupWorkers> getSupWorkersBySupplierId(Integer supplierId){
        return supWorkersMapper.getSupWorkersBySupplierId(supplierId);
    }

    public PagingRestResponse searchSupWorkers(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supWorkersMapper.searchSupWorkersCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupWorkers> resultList = null;
        if(totalRecordNum>0){
            resultList = supWorkersMapper.searchSupWorkers(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}