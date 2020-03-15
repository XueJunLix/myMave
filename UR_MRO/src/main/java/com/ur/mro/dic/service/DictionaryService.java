package com.ur.mro.dic.service;

import com.google.common.collect.Maps;
import com.ur.common.service.BaseService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.dic.mappers.DictionaryMapper;
import com.ur.mro.dic.model.Dictionary;

import java.util.*;

import com.ur.mro.dic.model.DictionaryHead;
import com.ur.mro.dic.model.DictionaryItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.MapUtils;

@Service
public class DictionaryService extends BaseService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    public Dictionary getDictionaryByPK(Integer pkId) {
        return dictionaryMapper.getDictionaryByPK(pkId);
    }

    @Transactional
    public Integer insertDictionary(Dictionary dictionary) {
        
        //TODO handle date columns here
        //dictionary.setCreatedTime(new Date());
        //dictionary.setLastUpdatedTime(new Date());
        
        dictionaryMapper.insertDictionary(dictionary);
        return dictionary.getId();
    }

    @Transactional
    public int updateDictionaryByPKSelective(Dictionary dictionary) {
        
        //TODO handle date columns here
        //dictionary.setCreatedTime(new Date());
        //dictionary.setLastUpdatedTime(new Date());
        
        int result = dictionaryMapper.updateDictionaryByPKSelective(dictionary);
        return result;
    }

    public PagingRestResponse searchDictionary(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = dictionaryMapper.searchDictionaryCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<Dictionary> resultList = null;
        if(totalRecordNum>0){
            resultList = dictionaryMapper.searchDictionary(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    /**
     * 通过sgroup找到相对应的数据集
     * @param sgroup
     * @return
     */
    public Map<String,String> getMapBySgroup (String sgroup){

            return  super.getMapBySgroup(sgroup);
    }

    /**
     *大中小类级联参数集查询
     * @param sgroup
     * @return
     */
    public Map<String,Map<String,String>> getMapBySgroupandCa(String sgroupParent,String sgroup){
        Map<String,Map<String,String>> mapAll = new HashMap<String,Map<String,String>>();
        List<Dictionary> dicList = dictionaryMapper.getListBySgroup(sgroupParent);
        for(int i = 0;i<dicList.size();i++){
            Dictionary dictionary = dicList.get(i);
            String skey = dictionary.getSkey();
            List<Dictionary> dicItem =  dictionaryMapper.getListBySgroupandCa(sgroup,skey);
            Map<String,String> mapItem = new HashMap<String,String>();
            for(int j = 0;j<dicItem.size();j++){
                Dictionary dictionaryitem =  dicItem.get(j);
                String skeyItem = dictionaryitem.getSkey();
                String svalueItem = dictionaryitem.getSvalue();
                mapItem.put(skeyItem,svalueItem);
            }
         mapAll.put(skey,mapItem);
        }
        return  mapAll;
    }

    public Map<String,String> getAllProvice(){
        List<Dictionary> dictionaryList = dictionaryMapper.getProvinceList();
        Map<String,String> maps = new HashMap<String,String>();
        for(int i = 0;i<dictionaryList.size();i++){
            Dictionary dictionary =  dictionaryList.get(i);
            maps.put(dictionary.getSkey(),dictionary.getSvalue());
        }
        return maps;
    }

    /**
     * 某个省下所有的市
     * @return
     */
    public Map<String,Map<String,String>> getMapBySgroupandProvice(){

        Map<String,Map<String,String>> mapAll = new HashMap<String,Map<String,String>>();
        List<Dictionary> dicList = dictionaryMapper.getProvinceList();
        for(int i = 0;i<dicList.size();i++){
            Dictionary dictionary = dicList.get(i);
            String skey = dictionary.getSkey();
            List<Dictionary> dicItem =  dictionaryMapper.getListBySgroupandProvince(skey);
            Map<String,String> mapItem = new HashMap<String,String>();
            for(int j = 0;j<dicItem.size();j++){
                Dictionary dictionaryitem =  dicItem.get(j);
                String skeyItem = dictionaryitem.getSkey();
                String svalueItem = dictionaryitem.getSvalue();
                mapItem.put(skeyItem,svalueItem);
            }
            mapAll.put(skey,mapItem);
        }

        return mapAll;
    }


    /**
     * 编辑
     * @param sgroup
     * @return
     */
    public DictionaryHead getDictionaryListBySgroup(String sgroup){
        DictionaryHead dictionaryHead = new DictionaryHead();
        List<DictionaryItem> dictionaryItemList = new ArrayList<DictionaryItem>();
        List<Dictionary> dictionaryList = dictionaryMapper.getListBySgroup(sgroup);
        dictionaryHead.setSgroup(dictionaryList.get(0).getSgroup());
        dictionaryHead.setSgroupName(dictionaryList.get(0).getSgroupName());
        dictionaryHead.setGroupDesciption(dictionaryList.get(0).getDescription());

       for(int i = 0;i<dictionaryList.size();i++){
           DictionaryItem dictionaryItem = new DictionaryItem();
           Dictionary dictionary = dictionaryList.get(i);
           BeanUtils.copyProperties(dictionary,dictionaryItem);
           if(dictionary.getLeafNode()==1){
               dictionaryItem.setLeafNode(true);
           }else{
               dictionaryItem.setLeafNode(false);
           }
           if(dictionary.getActive().equals("1")){
               dictionaryItem.setActive(true);
           }else{
               dictionaryItem.setActive(false);
           }
           dictionaryItemList.add(dictionaryItem);
       }
        dictionaryHead.setDictionaryItemList(dictionaryItemList);
        return dictionaryHead;
    }

    public int saveDictionaryHead(DictionaryHead dictionaryHead){
        List<DictionaryItem> dictionaryItemList = dictionaryHead.getDictionaryItemList();
        List<Dictionary> updateDictionaryList = new ArrayList<Dictionary>();
        List<Dictionary> insertDictionaryList = new ArrayList<Dictionary>();
        if(dictionaryItemList.size()>0){
            for(int i = 0;i<dictionaryItemList.size();i++){
                DictionaryItem dictionaryItem = dictionaryItemList.get(i);
                Dictionary dictionary = new Dictionary();
                BeanUtils.copyProperties(dictionaryItem,dictionary);
                if(dictionaryItem.getActive()==true){
                    dictionary.setActive("1");
                }else{
                    dictionary.setActive("0");
                }

                if(dictionaryItem.getLeafNode()==true){
                    dictionary.setLeafNode(1);
                }else{
                    dictionary.setLeafNode(0);
                }
                if(dictionary.getId()!=null){
                    updateDictionaryList.add(dictionary);
                }else{
                    super.setUpdateFields(dictionary);
                    dictionary.setSgroup(dictionaryHead.getSgroup());
                    dictionary.setGroupDesciption(dictionaryHead.getGroupDesciption());
                    dictionary.setSgroupName(dictionaryHead.getSgroupName());
                    insertDictionaryList.add(dictionary);
                }


            }
            if(updateDictionaryList.size()>0){
                int aa = dictionaryMapper.updateBatchDictionaryList(updateDictionaryList);
            }
            if(insertDictionaryList.size()>0){
                int bb = dictionaryMapper.insertBatchDictionaryList(insertDictionaryList);
            }

        }


        return 0;
    }

    public Map<String,Map<String,String>> getAllProviceBySgroup(){

        Map<String,Map<String,String>> maps=new HashMap<String,Map<String,String>>();
        Map<String,String> values= null;

        List<Dictionary> dictionaryList = dictionaryMapper.getProvinceList();
        for(int i = 0;i<dictionaryList.size();i++){
            Dictionary dictionary =  dictionaryList.get(i);
            if(maps.get(dictionary.getParentId().toString())==null){
                values=Maps.newHashMap();
                values.put(dictionary.getSkey(),dictionary.getSvalue());
                maps.put(dictionary.getParentId().toString(),values);
            }
            else{
                maps.get(dictionary.getParentId()).put(dictionary.getSkey(),dictionary.getSvalue());
            }
        }
        return maps;
    }

}