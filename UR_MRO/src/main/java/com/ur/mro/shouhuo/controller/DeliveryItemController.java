package com.ur.mro.shouhuo.controller;

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

import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;
import com.ur.mro.shouhuo.model.DeliveryItem;
import com.ur.mro.shouhuo.service.DeliveryItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "")
@Api(description = "DeliveryItemController的注释")
public class DeliveryItemController {
    private static final Logger logger = LoggerFactory.getLogger(DeliveryItemController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    DeliveryItemService deliveryItemService;

    @RequestMapping(value="DeliveryItem",method = RequestMethod.GET)
    @ApiOperation(value = "DeliveryItem默认页面模板", notes = "DeliveryItem默认页面模板")
    public String DeliveryItemTemplate() {
        return "DeliveryItem";
    }

    @RequestMapping(value = "DeliveryItem/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取DeliveryItem", notes = "根据pkId获取DeliveryItem",response = DeliveryItem.class)
    public CommonRestResponse getDeliveryItemByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            DeliveryItem deliveryItem = deliveryItemService.getDeliveryItemByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,deliveryItem);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DeliveryItem/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入DeliveryItem对象", notes = "插入DeliveryItem对象")
    public CommonRestResponse insertDeliveryItem(HttpServletRequest httpRequest, @RequestBody DeliveryItem deliveryItem) {
        try {
            //TODO authentication to be done
            
            deliveryItemService.insertDeliveryItem(deliveryItem);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DeliveryItem/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新DeliveryItem", notes = "根据pkId更新DeliveryItem")
    public CommonRestResponse updateDeliveryItemByPKSelective(HttpServletRequest httpRequest, @RequestBody DeliveryItem deliveryItem) {
        try {
            //TODO authentication to be done
            
            deliveryItemService.updateDeliveryItemByPKSelective(deliveryItem);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DeliveryItem/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "DeliveryItem通用查询方法", notes = "DeliveryItem通用查询方法",response = DeliveryItem.class, responseContainer="List")
    public CommonRestResponse searchDeliveryItem(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(DeliveryItem.class);
            PagingRestResponse response = deliveryItemService.searchDeliveryItem(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "DeliveryItem/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "DeliveryItem导出接口，返回待下载的Excel文件名", notes = "DeliveryItem导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportDeliveryItem(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(DeliveryItem.class);
            PagingRestResponse response = deliveryItemService.searchDeliveryItem(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<DeliveryItem> resultList = (List<DeliveryItem>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("deliveryId");
                headerList.add("rowNo");
                headerList.add("matCode");
                headerList.add("matName");
                headerList.add("matSpec");
                headerList.add("matCz");
                headerList.add("matSize");
                headerList.add("unit");
                headerList.add("shQut");
                headerList.add("makeIe");
                headerList.add("comments");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("deleted");
                headerList.add("bType");
                headerList.add("mType");
                headerList.add("sType");
                headerList.add("qcShQut");
                headerList.add("cyQut");
                headerList.add("dealResult");
                headerList.add("poNo");
                headerList.add("prNo");
                headerList.add("ysQut");
                headerList.add("ksQut");
                headerList.add("shopNo");
                headerList.add("shopName");
                headerList.add("poItemRowNo");
                headerList.add("shItemId");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(DeliveryItem row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getDeliveryId());
                    rowList.add(row.getRowNo());
                    rowList.add(row.getMatCode());
                    rowList.add(row.getMatName());
                    rowList.add(row.getMatSpec());
                    rowList.add(row.getMatCz());
                    rowList.add(row.getMatSize());
                    rowList.add(row.getUnit());
                    rowList.add(row.getShQut());
                    rowList.add(row.getMakeIe());
                    rowList.add(row.getComments());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getbType());
                    rowList.add(row.getmType());
                    rowList.add(row.getsType());
                    rowList.add(row.getQcShQut());
                    rowList.add(row.getCyQut());
                    rowList.add(row.getDealResult());
                    rowList.add(row.getPoNo());
                    rowList.add(row.getPrNo());
                    rowList.add(row.getYsQut());
                    rowList.add(row.getKsQut());
                    rowList.add(row.getShopNo());
                    rowList.add(row.getShopName());
                    rowList.add(row.getPoItemRowNo());
                    rowList.add(row.getShItemId());
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

    @RequestMapping(value="DeliveryItemList",method = RequestMethod.GET)
    @ApiOperation(value = "DeliveryItemList默认页面模板", notes = "DeliveryItemList默认页面模板")
    public String DeliveryItemList() {
        return "DeliveryItemList";
    }

    @RequestMapping(value = "DeliveryItemEdit", method = RequestMethod.GET)
    @ApiOperation(value = "DeliveryItemEdit默认页面模板", notes = "DeliveryItemEdit默认页面模板")
    public String DeliveryItemEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        DeliveryItem deliveryItem = new DeliveryItem();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            deliveryItem = deliveryItemService.getDeliveryItemByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("deliveryItem",deliveryItem);
        model.addAttribute("isUpdate",isUpdate);
        return "DeliveryItemEdit";
    }
}