package com.ur.mro.dic.controller;

import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;
import com.ur.mro.dic.model.Dictionary;
import com.ur.mro.dic.model.DictionaryHead;
import com.ur.mro.dic.model.DictionaryItem;
import com.ur.mro.dic.service.DictionaryService;
import com.ur.mro.sup.model.SupplierHb;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "dic")
@Api(description = "DictionaryController的注释")
public class DictionaryController {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 数据字典列表
     * @return
     */
    @RequestMapping(value="dictionaryList",method = RequestMethod.GET)
    @ApiOperation(value = "数据字典列表", notes = "数据字典列表")
    public String DictionaryTemplate() {
        return "mro/dic/dictionaryList";
    }


    /**
     * 新增编辑页面
     * @param model
     * @param httpRequest
     * @param httpResponse
     * @return
     */
    @RequestMapping(value = "editDictionary", method = RequestMethod.GET)
    @ApiOperation(value = "新增编辑页面", notes = "新增编辑页面")
    public String dictionaryEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String sgroup = httpRequest.getParameter("sgroup");
        DictionaryHead dictionaryHead = new DictionaryHead();
        if(sgroup!=null && !sgroup.equals("")){
            dictionaryHead = dictionaryService.getDictionaryListBySgroup(sgroup);
        }/*else{
            List<DictionaryItem> dictionaryItemList = new ArrayList<DictionaryItem>();
            DictionaryItem dictionaryItem = new DictionaryItem();
            dictionaryItemList.add(dictionaryItem);
            dictionaryHead.setDictionaryItemList(dictionaryItemList);
        }*/
        model.addAttribute("dictionaryHead",dictionaryHead);
        return "mro/dic/dictionaryEdit";
    }

    /**
     * 保存数据字典
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "saveDictionaryHead", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存数据字典", notes = "保存数据字典")
    public CommonRestResponse insertSupplier(HttpServletRequest httpRequest, @RequestBody DictionaryHead dictionaryHead) {
        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Dictionary/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取Dictionary", notes = "根据pkId获取Dictionary",response = Dictionary.class)
    public CommonRestResponse getDictionaryByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            Dictionary dictionary = dictionaryService.getDictionaryByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,dictionary);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 保存数据字典
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "saveDictionary", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "saveDictionary", notes = "saveDictionary")
    public CommonRestResponse saveDictionary(HttpServletRequest httpRequest, @RequestBody DictionaryHead dictionaryHead) {
        try {
            //TODO authentication to be done
            
            dictionaryService.saveDictionaryHead(dictionaryHead);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }


    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Dictionary通用查询方法", notes = "Dictionary通用查询方法",response = Dictionary.class, responseContainer="List")
    public CommonRestResponse searchDictionary(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Dictionary.class);
            PagingRestResponse response = dictionaryService.searchDictionary(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Dictionary/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Dictionary导出接口，返回待下载的Excel文件名", notes = "Dictionary导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportDictionary(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Dictionary.class);
            PagingRestResponse response = dictionaryService.searchDictionary(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Dictionary> resultList = (List<Dictionary>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("groupId");
                headerList.add("sgroup");
                headerList.add("skey");
                headerList.add("svalue");
                headerList.add("active");
                headerList.add("parentId");
                headerList.add("description");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("scom1");
                headerList.add("scom2");
                headerList.add("deleted");
                headerList.add("sort");
                headerList.add("scom3");
                headerList.add("groupDesciption");
                headerList.add("sgroupName");
                headerList.add("leafNode");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Dictionary row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getGroupId());
                    rowList.add(row.getSgroup());
                    rowList.add(row.getSkey());
                    rowList.add(row.getSvalue());
                    rowList.add(row.getActive());
                    rowList.add(row.getParentId());
                    rowList.add(row.getDescription());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getScom1());
                    rowList.add(row.getScom2());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getSort());
                    rowList.add(row.getScom3());
                    rowList.add(row.getGroupDesciption());
                    rowList.add(row.getSgroupName());
                    rowList.add(row.getLeafNode());
                    contentList.add(rowList);
                }
                
                String fileName = UuidKit.getUuid();
                
                ExcelWriteBean writeBean = new ExcelWriteBean();
                writeBean.setFileName(fileName);
                writeBean.setFileType(ExcelConfig.FT_XLSX);
                writeBean.setHeaderList(headerList);
                writeBean.setContentList(contentList);
                
                ExcelWriteKit kit = new ExcelWriteKit();
                kit.outputExcel(writeBean, tempFilePath,seperator);
                
                Map<String,String> returnObj = new HashMap<String,String>();
                returnObj.put("fileName", fileName);
                returnObj.put("extName", ExcelConfig.FT_XLSX);
                
                return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,returnObj);
            }else {
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"查询数据失败",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value="DictionaryList",method = RequestMethod.GET)
    @ApiOperation(value = "DictionaryList默认页面模板", notes = "DictionaryList默认页面模板")
    public String DictionaryList() {
        return "DictionaryList";
    }

    @RequestMapping(value = "DictionaryEdit", method = RequestMethod.GET)
    @ApiOperation(value = "DictionaryEdit默认页面模板", notes = "DictionaryEdit默认页面模板")
    public String DictionaryEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Dictionary dictionary = new Dictionary();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            dictionary = dictionaryService.getDictionaryByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("dictionary",dictionary);
        model.addAttribute("isUpdate",isUpdate);
        return "dictionaryEdit";
    }
}