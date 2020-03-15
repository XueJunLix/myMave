package com.ur.mro.dic.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.dic.model.Dictionary;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictionaryMapper {
    Dictionary getDictionaryByPK(Integer pkId);

    int insertDictionary(Dictionary Dictionary);

    int updateDictionaryByPKSelective(Dictionary Dictionary);

    List<Dictionary> searchDictionary(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchDictionaryCount(@Param("condList") List<CommonSearchCondition> condList);

    //根据数据参数名找到相对应的数据字典
    List<Dictionary>  getListBySgroup(String sgroup);

    //根据大类找到对应的中类数据集或者根据中类找到小类
    List<Dictionary> getListBySgroupandCa(@Param("sgroup") String sgroup,@Param("skey") String skey);

    String getSvalueBySgoupandSkey(@Param("sgroup")String sgroup,@Param("skey") String skey);

    List<Dictionary> getListBySgroupandProvince(@Param("skey") String skey);

    List<Dictionary> getProvinceList();

    int updateBatchDictionaryList(List<Dictionary> dictionaryList);

    int insertBatchDictionaryList(@Param("list") List<Dictionary> dictionaryList);
}