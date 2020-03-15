package com.ur.mro.mat.service;

import com.ur.common.service.BaseService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.mat.mappers.MaterialInfoMapper;
import com.ur.mro.mat.model.MaterialInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialInfoService extends BaseService{
    @Autowired
    MaterialInfoMapper materialInfoMapper;

    //批量新增
    @Transactional
    public Integer insertBatchMaterialInfo(List<MaterialInfo> materialInfoList){
        return materialInfoMapper.insertBatchMaterialInfo(materialInfoList);
    }
    //批量修改
    public Integer updateBatchMaterialInfo(List<MaterialInfo> materialInfoList){
        return materialInfoMapper.updateBatchMaterialInfo(materialInfoList);
    }

    public  Integer deletedBatchMaterialInfo(List<MaterialInfo> materialInfoList){
        for(int i = 0;i<materialInfoList.size();i++){
            MaterialInfo materialInfo = materialInfoList.get(i);
            materialInfo.setDeleted(0);
            super.setUpdateFields(materialInfo);

        }
        return materialInfoMapper.updateBatchMaterialInfo(materialInfoList);
    }

    //通过父ID查找明细
    public List<MaterialInfo> getMaterialInfoListBySupplierId(Integer supplierId){
        return materialInfoMapper.getMaterialInfoListBySupplierId(supplierId);
    }

    public MaterialInfo getMaterialInfoByPK(Integer pkId) {
        return materialInfoMapper.getMaterialInfoByPK(pkId);
    }

    @Transactional
    public Integer insertMaterialInfo(MaterialInfo materialInfo) {
        
        //TODO handle date columns here
        //materialInfo.setCreatedTime(new Date());
        //materialInfo.setLastUpdatedTime(new Date());
        
        materialInfoMapper.insertMaterialInfo(materialInfo);
        return materialInfo.getId();
    }

    @Transactional
    public int updateMaterialInfoByPKSelective(MaterialInfo materialInfo) {
        
        //TODO handle date columns here
        //materialInfo.setCreatedTime(new Date());
        //materialInfo.setLastUpdatedTime(new Date());
        
        int result = materialInfoMapper.updateMaterialInfoByPKSelective(materialInfo);
        return result;
    }

    public PagingRestResponse searchMaterialInfo(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = materialInfoMapper.searchMaterialInfoCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<MaterialInfo> resultList = null;
        if(totalRecordNum>0){
            resultList = materialInfoMapper.searchMaterialInfo(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}