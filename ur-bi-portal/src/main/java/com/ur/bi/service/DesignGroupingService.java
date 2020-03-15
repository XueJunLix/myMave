package com.ur.bi.service;

import com.ur.bi.mappers.DesignGroupingMapper;
import com.ur.bi.model.DesignGrouping;
import com.ur.bi.model.MonthStandard;
import com.ur.common.config.DictionaryGroup;
import com.ur.common.util.UploadUtil;
import com.ur.eureka.service.EurekaDiscoveryService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.service.AdminUserInfoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.thymeleaf.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.poi.ss.usermodel.Sheet;

@Service
public class DesignGroupingService {
    @Autowired
    DesignGroupingMapper designGroupingMapper;

    @Autowired
    EurekaDiscoveryService eurekaDiscoveryService;

    @Autowired
    AdminUserInfoService adminUserInfoService;

    public int deleteByParams(List<CommonSearchCondition> condList) {
        return designGroupingMapper.deleteByParams(condList);
    }

    public DesignGrouping getDesignGroupingByPK(Integer pkId) {
        return designGroupingMapper.getDesignGroupingByPK(pkId);
    }



    @Transactional
    public Integer insertDesignGrouping(DesignGrouping designGrouping) {
        
        //TODO handle date columns here
        //designGrouping.setCreateTime(new Date());
        //designGrouping.setModifyTime(new Date());
        
        designGroupingMapper.insertDesignGrouping(designGrouping);
        return designGrouping.getId();
    }

    @Transactional
    public int updateDesignGroupingByPKSelective(DesignGrouping designGrouping) {
        
        //TODO handle date columns here
        //designGrouping.setCreateTime(new Date());
        //designGrouping.setModifyTime(new Date());
        
        int result = designGroupingMapper.updateDesignGroupingByPKSelective(designGrouping);
        return result;
    }

    public PagingRestResponse searchDesignGrouping(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {

        int totalRecordNum = designGroupingMapper.searchDesignGroupingCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);

        List<DesignGrouping> resultList = null;
        if(totalRecordNum>0){
            resultList = designGroupingMapper.searchDesignGrouping(selectFields, condList, orderByList, pageBean);
            if (resultList != null && resultList.size()>0){
                // 获取对应的描述信息
                Map<String, String> designGroupMap = eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.DESIGNGROUP);
                Map<String,String> serialMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.SERIAL);
                Map<String,String> styleMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.STYLE);
                Map<String,String> goodsLevelMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.GOODS_LEVEL);
                Map<String,String> categoryMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.CATEGORY);

                Map<String, String> userMap = eurekaDiscoveryService.getAllUserMap();

                for (DesignGrouping designGrouping : resultList) {
                    // 系列
                    if(serialMap.containsKey(designGrouping.getSerial())) {
                        designGrouping.setSerial(serialMap.get(designGrouping.getSerial()));
                    }
                    // 原系列
                    if(serialMap.containsKey(designGrouping.getOriginalSerial())) {
                        designGrouping.setOriginalSerial(serialMap.get(designGrouping.getOriginalSerial()));
                    }
                    // 风格
                    if(styleMap.containsKey(designGrouping.getStyle())) {
                        designGrouping.setStyle(styleMap.get(designGrouping.getStyle()));
                    }
                    // 商品层
                    if(goodsLevelMap.containsKey(designGrouping.getGoodsLevel())) {
                        designGrouping.setGoodsLevel(goodsLevelMap.get(designGrouping.getGoodsLevel()));
                    }
                    // 品类
                    if(categoryMap.containsKey(designGrouping.getCategory())) {
                        designGrouping.setCategory(categoryMap.get(designGrouping.getCategory()));
                    }
                    // 设计分组
                    if(designGroupMap.containsKey(designGrouping.getDesignGrouping())){
                        designGrouping.setDesignGrouping(designGroupMap.get(designGrouping.getDesignGrouping()));
                    }
                    if(userMap.containsKey(designGrouping.getCreateBy())){
                        designGrouping.setCreateBy(userMap.get(designGrouping.getCreateBy()));
                    }
                    if(userMap.containsKey(designGrouping.getModifyBy())){
                        designGrouping.setModifyBy(userMap.get(designGrouping.getModifyBy()));
                    }
                }
            }
        }

        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public  HashMap<String, Object> importExcel(String filePath,  String fileName,InputStream inputStream,
                                                HashMap< String, Object> result) throws Exception {
        POIFSFileSystem fileSystem = null;
        HSSFWorkbook book = null;
        XSSFWorkbook workBook = null;
        try{
            if(null != fileName && fileName.indexOf(".") > -1){
                String excelContentType = fileName.substring(fileName.lastIndexOf("."));
                if(excelContentType.equals(".xls")){
                    fileSystem = new POIFSFileSystem(inputStream);
                    book = new HSSFWorkbook(fileSystem);
                    HSSFSheet sheet = book.getSheetAt(0);
                    changeData(filePath, (Sheet)sheet,result);
                }else if(".xlsx".equals(excelContentType)){
                    workBook = new XSSFWorkbook(inputStream);
                    XSSFSheet sheet = workBook.getSheetAt(0);
                    changeData(filePath, (Sheet) sheet, result);
                }else {
                    result.put("success", false);
                    result.put("message", "上传的不是Excel文件，请上传Excel文件进行导入数据！");
                }
            }
        }catch(IOException e){
            result.put("success", false);
            result.put("message", e.getMessage());
            e.printStackTrace();
            throw new Exception(e.getMessage(), e);
        }finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                result.put("success", false);
                result.put("message", e.getMessage());
                e.printStackTrace();
                throw new Exception(e.getMessage(), e);
            }
        }
        return result;
    }

    private  HashMap<String, Object> changeData(String  filePath, Sheet sheet,
                                                HashMap<String, Object> result) {
//        Map<String,String> dataTypeMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap("DATA_TYPE");
//        Map<String,String> shopPlanLevelMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap("shopPlanLevel");
//        Map<String,String> saleLevelMap=eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap("SALES_RANK");

        Map<String,String> designGroupMap=eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.DESIGNGROUP);
        Map<String,String> serialMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.SERIAL);
        Map<String,String> originSerialMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.SERIAL);
        Map<String,String> styleMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.STYLE);
        Map<String,String> goodsLevelMap=eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.GOODS_LEVEL);
        Map<String,String> categoryMap= eurekaDiscoveryService.getActiveSCMDictionaryValueKeyMap(DictionaryGroup.CATEGORY);


        //String loginId=adminUserInfoService.getCurrentLoginUserName();


        // 获取Excel数据封装到list中
        List<DesignGrouping> beanList = new ArrayList<DesignGrouping>();
        DesignGrouping  bean;

        Map<String,String> keyMap = new HashMap<String,String>();


        boolean isSuccess= true;

        // 获取Excel内容
        //获取行数
        int rowCount = sheet.getLastRowNum();//行数
        List<Integer> years = new ArrayList<>();
        List<String> seasons = new ArrayList<>();
        List<Integer> months = new ArrayList<>();
        List<String> serials = new ArrayList<>();
        List<String> dataTypes = new ArrayList<>();

        for1:for (int i = 1; i <= rowCount; i++) {
            StringBuffer key = new StringBuffer();
            Row row = sheet.getRow(i);
            int cellCount = row.getLastCellNum();
            bean = new DesignGrouping();
            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                String item = UploadUtil.getCellFormatValue(cell);
                switch(j){
                    case 0:  //设计分组
                        if(!StringUtils.isEmpty(item)){
                            if(designGroupMap.get(item)!=null) {
                                bean.setDesignGrouping(designGroupMap.get(item));
                                key.append(bean.getDesignGrouping());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的品牌信息");
                                isSuccess=false;
                                break for1;
                            }
                        }else {
                            bean.setDesignGrouping("");
                            key.append("_");
                        }
                        break;
                    case 1: //系列
                        if(!StringUtils.isEmpty(item)){
                            if(serialMap.get(item)!=null) {
                                bean.setSerial(serialMap.get(item));
                                key.append("_").append(bean.getSerial());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的系列");
                                isSuccess=false;
                                break for1;
                            }
                        }else {
                            bean.setSerial("");
                            key.append("_");
                        }
                        if(!serials.contains(bean.getSerial())) {
                            serials.add(bean.getSerial());
                        }
                        break;
                    case 2: //风格
                        if(!StringUtils.isEmpty(item)){
                            if(styleMap.get(item)!=null) {
                                bean.setStyle(styleMap.get(item));
                                key.append("_").append(bean.getStyle());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的风格");
                                isSuccess=false;
                                break for1;
                            }
                        }else {
                            bean.setStyle("");
                            key.append("_");
                        }
                        break;
                    case 3: //品类
                        if(!StringUtils.isEmpty(item)){
                            if(categoryMap.get(item)!=null) {
                                bean.setCategory(categoryMap.get(item));
                                key.append("_").append(bean.getCategory());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的品类");
                                isSuccess=false;
                                break for1;
                            }
                        }else {
                            bean.setCategory("");
                            key.append("_");
                        }
                        break;
                    case 4:  //原系列
                        if(!StringUtils.isEmpty(item)){
                            if(originSerialMap.get(item)!=null) {
                                bean.setOriginalSerial(originSerialMap.get(item));
                                key.append("_").append(bean.getOriginalSerial());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的原系列");
                                isSuccess=false;
                                break for1;
                            }
                        }else {
                            bean.setOriginalSerial("");
                            key.append("_");
                        }
                        break;
                    case 5: //商品层
                        if(!StringUtils.isEmpty(item)){
                            if(goodsLevelMap.get(item)!=null) {
                                bean.setGoodsLevel(goodsLevelMap.get(item));
                                key.append("_").append(bean.getGoodsLevel());
                            }else {
                                result.put("success", false);
                                result.put("message", "第" + (i + 1) + "行第"+(j + 1) +"列数据不对，请填写正确的商品层");
                                isSuccess=false;
                                break for1;
                            }
                        }
                        break;
                }
            }
            if(keyMap.get(key.toString())!=null) {
                result.put("success", false);
                result.put("message", "第"+(i+1)+"行数据重复，请检查！");
                isSuccess=false;
                break for1;
            }
            keyMap.put(key.toString(), key.toString());
//            bean.setCreateBy(adminUserInfoService.getCurrentLoginUserName());
//            bean.setModifyBy(adminUserInfoService.getCurrentLoginUserName());
            bean.setCreateBy("admin");
            bean.setModifyBy("admin");
            bean.setCreateTime(new Date());
            bean.setModifyTime(new Date());
            bean.setDeleted(0);
            beanList.add(bean);
        }

        //
        if(isSuccess && beanList.size()>0){
    		/*for(ConfigMonthStandard item : beanList){
    			item.setCreateBy(loginId);
    			item.setModifyBy(loginId);
    			item.setCreateTime(new Date());
    			item.setModifyTime(new Date());
    			configMonthStandardMapper.insertConfigMonthStandard(item);
    		}*/
            Map<String, DesignGrouping> existsMap = new HashMap<>();

            // 获取数据库数据
            List<DesignGrouping> groupings = designGroupingMapper.getDesignGroupings();
            for (DesignGrouping grouping : groupings) {
                existsMap.put(this.getUniqueKey(grouping),grouping);
            }

            List<DesignGrouping> insertList = new ArrayList<>();
            List<DesignGrouping> updateList = new ArrayList<>();

            for(DesignGrouping item:beanList) {
                if(existsMap.containsKey(this.getUniqueKey(item))) {
                    item.setId(existsMap.get(this.getUniqueKey(item)).getId());
                    updateList.add(item);
                }else {
                    insertList.add(item);
                }
            }
            int insertSize = insertList.size();
            int updateSize = updateList.size();
            if(!insertList.isEmpty()) {
                this.insertList(insertList);
            }
            if(!updateList.isEmpty()) {
                this.updateList(updateList);
            }
            if(insertSize>0 && updateSize>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！包含:新增【"+insertSize+"】条,更新【"+updateSize+"】条。");
            }else if(insertSize==0 && updateSize>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！更新【"+updateSize+"】条。");
            }else if(updateSize==0 && insertSize>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！新增【"+insertSize+"】条。");
            }
        }
        return result;
    }

    private List<DesignGrouping> getDesignGroupings() {
        return designGroupingMapper.getDesignGroupings();
    }

    public int updateList(List<DesignGrouping> updateList) {
        int batchNum = 1000;
        int totalSize = 0;
        int part =0;
        //保存更新数据
        if(updateList!=null && updateList.size()>0) {
            totalSize = updateList.size();
            part = totalSize/batchNum;//分批数
            for (int i = 0; i < part; i++) {
                designGroupingMapper.updateBatch(updateList.subList(0, batchNum));
                updateList.subList(0, batchNum).clear();
            }
            if(!updateList.isEmpty()) {
                designGroupingMapper.updateBatch(updateList);
            }
        }
        return totalSize;
    }

    public int insertList(List<DesignGrouping> insertList) {
        int batchNum = 1000;
        int totalSize = 0;
        int part =0;
        //保存新增数据
        if(insertList!=null && insertList.size()>0) {
            totalSize = insertList.size();
            part = totalSize/batchNum;//分批数
            for (int i = 0; i < part; i++) {
                designGroupingMapper.insertBatchDesignGroupingMapper(insertList.subList(0, batchNum));
                insertList.subList(0, batchNum).clear();
            }
            if(!insertList.isEmpty()) {
                designGroupingMapper.insertBatchDesignGroupingMapper(insertList);
            }
        }
        return totalSize;
    }

    public String getUniqueKey(DesignGrouping bean) {
        String key = bean.getDesignGrouping()+"-"+bean.getSerial()+"-"+bean.getOriginalSerial()+"-"+bean.getStyle()+"-"+bean.getGoodsLevel()+"-"+bean.getCategory();
        return key;
    }


    public void deleteByIdList(List<Integer> idList) {
        designGroupingMapper.deleteByIdList(idList);
    }

    public void delUpdateByIdList(List<Integer> idList) {
        designGroupingMapper.delUpdateByIdList(idList);
    }
}