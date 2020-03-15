package com.ur.mro.mat.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.mat.model.Material;
import java.util.List;

import com.ur.mro.purchaseorder.model.PurchaseOrder;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialMapper {
    Material getMaterialByPK(Integer pkId);

    int insertMaterial(Material Material);

    int updateMaterialByPKSelective(Material Material);

    List<Material> searchMaterial(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchMaterialCount(@Param("condList") List<CommonSearchCondition> condList);

    List<Material> getMaterialByCode(String code);

    int  deletedMaterial(Material material);

    String getCodeNum(@Param("brandType") String brandType,@Param("categoryC") String categoryC);

    List<Material> getOldMatCode();

    int updateBatchStatus(List<Material> updateList);

    int updateBatchMaterialList(List<Material> updateList);

    List<Material> searchMaterialBylastUpdateTimeAndCode(@Param("code")String code, @Param("lastUpdatedTime") String lastUpdatedTime);

    Material getMatOrderByNo(@Param("orderNo") String  orderNo, @Param("djType")String djType);
}