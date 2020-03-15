package com.ur.bi.controller;

import com.ur.bi.mappers.DesignGroupingMapper;
import com.ur.bi.model.DesignGrouping;
import com.ur.common.util.ExportUtil;
import com.alibaba.fastjson.JSONObject;
import com.ur.bi.service.DesignGroupingService;
import com.ur.common.config.DictionaryGroup;
import com.ur.common.util.UploadUtil;
import com.ur.eureka.model.SCMDictionaryBO;
import com.ur.eureka.service.EurekaDiscoveryService;
import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "")
@Api(description = "DesignGroupingController的注释")
public class DesignGroupingController {
    private static final Logger logger = LoggerFactory.getLogger(DesignGroupingController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    private EurekaDiscoveryService eurekaDiscoveryService;

    @Autowired
    DesignGroupingService designGroupingService;

    @Autowired
    DesignGroupingMapper designGroupingMapper;


    @RequestMapping(value="DesignGrouping",method = RequestMethod.GET)
    @ApiOperation(value = "DesignGrouping默认页面模板", notes = "DesignGrouping默认页面模板")
    public String DesignGroupingTemplate(Model model) {
        Map<String,String> designGroupMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap(DictionaryGroup.DESIGNGROUP);
        Map<String,String> serialMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap("FJSX2");
        List<SCMDictionaryBO> styleMap= eurekaDiscoveryService.getActiveSCMDictionaryBOs(DictionaryGroup.STYLE);
        Map<String,String> goodsLevelMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap("FJSX10");
        Map<String,String> categoryMap= eurekaDiscoveryService.getActiveSCMDictionaryKeyValueMap("FJSX6");

        Map<String, String> userMap = eurekaDiscoveryService.getAllUserMap();
        HashMap<String, String> userMaps = new HashMap<>();
        List<String> userIds = designGroupingMapper.selectUser();

        for (String userId : userIds) {
            if (userMap.containsKey(userId)){
                String userName = userMap.get(userId);
                userMaps.put(userId,userName);
            }
        }

        model.addAttribute("userItems",userMaps);
        model.addAttribute("designGroupItems",designGroupMap);
        model.addAttribute("serialItems",serialMap);
        model.addAttribute("styleItems",styleMap);
        model.addAttribute("goodsLevelItems",goodsLevelMap);
        model.addAttribute("categoryItems",categoryMap);

        return "bi/DesignGrouping";
    }

    @RequestMapping(value = "DesignGrouping/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonRestResponse deleteDesignGroup(HttpServletRequest httpRequest,
                                             @RequestBody List<Integer> idList) {
        try {
            designGroupingService.delUpdateByIdList(idList);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,
                    CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/del", method = RequestMethod.POST)
    @ResponseBody
    public CommonRestResponse delDesignGroup(HttpServletRequest httpRequest,
                                             @RequestBody List<Integer> idList) {
        try {
            designGroupingService.deleteByIdList(idList);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,
                    CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取DesignGrouping", notes = "根据pkId获取DesignGrouping",response = DesignGrouping.class)
    public CommonRestResponse getDesignGroupingByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            DesignGrouping designGrouping = designGroupingService.getDesignGroupingByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,designGrouping);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入DesignGrouping对象", notes = "插入DesignGrouping对象")
    public CommonRestResponse insertDesignGrouping(HttpServletRequest httpRequest, @RequestBody DesignGrouping designGrouping) {
        try {
            //TODO authentication to be done
            
            designGroupingService.insertDesignGrouping(designGrouping);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新DesignGrouping", notes = "根据pkId更新DesignGrouping")
    public CommonRestResponse updateDesignGroupingByPKSelective(HttpServletRequest httpRequest, @RequestBody DesignGrouping designGrouping) {
        try {
            //TODO authentication to be done
            
            designGroupingService.updateDesignGroupingByPKSelective(designGrouping);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "DesignGrouping通用查询方法", notes = "DesignGrouping通用查询方法",response = DesignGrouping.class, responseContainer="List")
    public CommonRestResponse searchDesignGrouping(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(DesignGrouping.class);
            PagingRestResponse response = designGroupingService.searchDesignGrouping(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DesignGrouping/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "DesignGrouping导出接口，返回待下载的Excel文件名", notes = "DesignGrouping导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportDesignGrouping(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(DesignGrouping.class);
            PagingRestResponse response = designGroupingService.searchDesignGrouping(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<DesignGrouping> resultList = (List<DesignGrouping>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
//                headerList.add("自增id");
                headerList.add("设计分组");
                headerList.add("系列");
                headerList.add("风格");
                headerList.add("品类");
                headerList.add("原系列");
                headerList.add("商品层");
                headerList.add("创建时间");
                headerList.add("创建者");
                headerList.add("修改时间");
                headerList.add("修改者");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(DesignGrouping row:resultList){
                    rowList = new ArrayList<Object>();
//                    rowList.add(row.getId());
                    rowList.add(row.getDesignGrouping());
                    rowList.add(row.getSerial());
                    rowList.add(row.getStyle());
                    rowList.add(row.getCategory());
                    rowList.add(row.getOriginalSerial());
                    rowList.add(row.getGoodsLevel());
                    rowList.add(row.getCreateTime());
                    rowList.add(row.getCreateBy());
                    rowList.add(row.getModifyTime());
                    rowList.add(row.getModifyBy());
                    contentList.add(rowList);
                }
                
                String fileName = UuidKit.getUuid();
                
                ExcelWriteBean writeBean = new ExcelWriteBean();
                writeBean.setFileName(fileName);
                writeBean.setFileType(ExcelConfig.FT_XLSX);
                writeBean.setHeaderList(headerList);
                writeBean.setContentList(contentList);
                writeBean.setCellTypeMap(ExportUtil.getCellTypeMap(contentList));

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

    @RequestMapping(value="DesignGroupingList",method = RequestMethod.GET)
    @ApiOperation(value = "DesignGroupingList默认页面模板", notes = "DesignGroupingList默认页面模板")
    public String DesignGroupingList() {
        return "DesignGroupingList";
    }

    @RequestMapping(value = "DesignGroupingEdit", method = RequestMethod.GET)
    @ApiOperation(value = "DesignGroupingEdit默认页面模板", notes = "DesignGroupingEdit默认页面模板")
    public String DesignGroupingEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        DesignGrouping designGrouping = new DesignGrouping();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            designGrouping = designGroupingService.getDesignGroupingByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("designGrouping",designGrouping);
        model.addAttribute("isUpdate",isUpdate);
        return "DesignGroupingEdit";
    }

    @RequestMapping(value = "DesignGrouping/importExcel", method = RequestMethod.POST)
    @ApiOperation(value = "ConfigMonthStandard导入接口", notes = "ConfigMonthStandard导入接口")
    public void uploadExcel(HttpServletRequest req, HttpServletResponse resp,
                            @RequestParam("file") MultipartFile file) throws Exception{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HashMap<String, Object> result = new HashMap<String, Object>();

        if(null != file &&  !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String filePath = req.getSession().getServletContext().getRealPath("upload/");
            try {
                UploadUtil.uploadFile(file.getBytes(), filePath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            File uploadedFile = new File(filePath+fileName);
            FileInputStream fis = new FileInputStream(uploadedFile);

            JSONObject jo= new JSONObject();
            try {
                InputStream inputStream = fis;
                result =  designGroupingService.importExcel(filePath+fileName, fileName, inputStream, result);
                jo.put("success", result.get("success"));
                jo.put("message", result.get("message"));
            } catch (Exception e) {
                e.printStackTrace();
                jo.put("success",  false);
                jo.put("message", e.getMessage());

            }
            out.write(jo.toString());
        }
        out.flush();
        out.close();
    }
}