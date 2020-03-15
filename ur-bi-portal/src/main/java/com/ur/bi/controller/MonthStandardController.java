package com.ur.bi.controller;

import com.ur.bi.model.MonthStandard;
import com.ur.bi.service.MonthStandardService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "")
@Api(description = "MonthStandardController的注释")
public class MonthStandardController {
    private static final Logger logger = LoggerFactory.getLogger(MonthStandardController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    MonthStandardService monthStandardService;

    @RequestMapping(value="MonthStandard",method = RequestMethod.GET)
    @ApiOperation(value = "MonthStandard默认页面模板", notes = "MonthStandard默认页面模板")
    public String MonthStandardTemplate() {
        return "config/MonthStandard";
    }

    @RequestMapping(value = "MonthStandard/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取MonthStandard", notes = "根据pkId获取MonthStandard",response = MonthStandard.class)
    public CommonRestResponse getMonthStandardByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            MonthStandard monthStandard = monthStandardService.getMonthStandardByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,monthStandard);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "MonthStandard/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入MonthStandard对象", notes = "插入MonthStandard对象")
    public CommonRestResponse insertMonthStandard(HttpServletRequest httpRequest, @RequestBody MonthStandard monthStandard) {
        try {
            //TODO authentication to be done
            
            monthStandardService.insertMonthStandard(monthStandard);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "MonthStandard/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新MonthStandard", notes = "根据pkId更新MonthStandard")
    public CommonRestResponse updateMonthStandardByPKSelective(HttpServletRequest httpRequest, @RequestBody MonthStandard monthStandard) {
        try {
            //TODO authentication to be done
            
            monthStandardService.updateMonthStandardByPKSelective(monthStandard);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "MonthStandard/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "MonthStandard通用查询方法", notes = "MonthStandard通用查询方法",response = MonthStandard.class, responseContainer="List")
    public CommonRestResponse searchMonthStandard(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(MonthStandard.class);
            PagingRestResponse response = monthStandardService.searchMonthStandard(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "MonthStandard/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "MonthStandard导出接口，返回待下载的Excel文件名", notes = "MonthStandard导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportMonthStandard(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(MonthStandard.class);
            PagingRestResponse response = monthStandardService.searchMonthStandard(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<MonthStandard> resultList = (List<MonthStandard>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("自增id");
                headerList.add("数据类型");
                headerList.add("年份");
                headerList.add("季节");
                headerList.add("月份");
                headerList.add("单号");
                headerList.add("planLevel");
                headerList.add("销售级别");
                headerList.add("品牌编码");
                headerList.add("系列");
                headerList.add("原系列");
                headerList.add("风格");
                headerList.add("商品层");
                headerList.add("品类");
                headerList.add("中品类");
                headerList.add("企划店铺编码");
                headerList.add("店铺编码");
                headerList.add("stdValue");
                headerList.add("标准值上限");
                headerList.add("标准值下限");
                headerList.add("创建时间");
                headerList.add("创建者");
                headerList.add("修改时间");
                headerList.add("修改者");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(MonthStandard row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getType());
                    rowList.add(row.getYear());
                    rowList.add(row.getSeason());
                    rowList.add(row.getMonth());
                    rowList.add(row.getOrderNo());
                    rowList.add(row.getPlanLevel());
                    rowList.add(row.getSaleLevel());
                    rowList.add(row.getBrand());
                    rowList.add(row.getSerial());
                    rowList.add(row.getOriginalSerial());
                    rowList.add(row.getStyle());
                    rowList.add(row.getGoodsLevel());
                    rowList.add(row.getCategory());
                    rowList.add(row.getSubCategory());
                    rowList.add(row.getPlanShopNo());
                    rowList.add(row.getShopNo());
                    rowList.add(row.getStdValue());
                    rowList.add(row.getStdMaxValue());
                    rowList.add(row.getStdMinValue());
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

}