package com.ur.mro.mat.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.mat.model.MaterialInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialInfoMapper {
    MaterialInfo getMaterialInfoByPK(Integer pkId);

    int insertMaterialInfo(MaterialInfo MaterialInfo);

    int updateMaterialInfoByPKSelective(MaterialInfo MaterialInfo);

    List<MaterialInfo> searchMaterialInfo(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchMaterialInfoCount(@Param("condList") List<CommonSearchCondition> condList);

    int insertBatchMaterialInfo(@Param("list") List<MaterialInfo> materialInfoList);

    int updateBatchMaterialInfo(@Param("list") List<MaterialInfo> materialInfoList);

    List<MaterialInfo> getMaterialInfoListBySupplierId(Integer supplierId);


}