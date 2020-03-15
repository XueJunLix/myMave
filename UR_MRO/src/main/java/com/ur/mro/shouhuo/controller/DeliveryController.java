package com.ur.mro.shouhuo.controller;

import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;

import com.ur.mro.purpurchase.model.ShenqingData;
import com.ur.mro.purpurchase.service.PurPurchaseService;
import com.ur.mro.shouhuo.model.Delivery;

import com.ur.mro.shouhuo.model.DeliveryVO;
import com.ur.mro.shouhuo.model.GCshHdead;
import com.ur.mro.shouhuo.service.DeliveryService;
import com.ur.mro.shouhuo.service.GCshHdeadService;
import com.ur.mro.shouhuo.service.WlShopMatinvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;
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
@RequestMapping(value = "delivery")
@Api(description = "收货确认")
public class DeliveryController {
    private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    GCshHdeadService gCshHdeadService;

    @Autowired
    WlShopMatinvService wlShopMatinvService;

    @Autowired
    PurPurchaseService purPurchaseService;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Delivery通用查询方法", notes = "Delivery通用查询方法",response = Delivery.class, responseContainer="List")
    public CommonRestResponse searchDelivery(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done

            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }

            //remove injection code
            request.removeInjectionCode();

            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(GCshHdead.class);
            PagingRestResponse response = gCshHdeadService.searchGCshHdead(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/pro/info/{prNo}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询采购申请信息", notes = "查询采购申请信息",response = Delivery.class)
    public CommonRestResponse getPurchaseInfo(HttpServletRequest httpRequest,@PathVariable String prNo) {
        try {

            //TODO authentication to be done
            ShenqingData shenqingData=purPurchaseService.getPurchaseInfoByOrderNo(prNo);
             return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,shenqingData);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Delivery导出接口，返回待下载的Excel文件名", notes = "Delivery导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportDelivery(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done

            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);

            //remove injection code
            request.removeInjectionCode();

            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(GCshHdead.class);
            PagingRestResponse response = gCshHdeadService.searchGCshHdead(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Delivery> resultList = (List<Delivery>)response.getData();

            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("deliveryNo");
                headerList.add("shNo");
                headerList.add("shopNo");
                headerList.add("shopName");
                headerList.add("comments");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("deleted");
                headerList.add("chNo");
                headerList.add("delDiffStatus");
                headerList.add("brandType");
                headerList.add("gcWlStatus");
                headerList.add("freight");
                headerList.add("goodsSignDate");
                headerList.add("isSubmit");
                headerList.add("boxes");
                headerList.add("isCompleted");
                headerList.add("isOutnumber");
                headerList.add("dpName");
                headerList.add("dpNo");
                headerList.add("senderNo");
                headerList.add("senderName");
                headerList.add("receiverNo");
                headerList.add("receiverName");

                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Delivery row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getDeliveryNo());
                    rowList.add(row.getShNo());
                    rowList.add(row.getShopNo());
                    rowList.add(row.getShopName());
                    rowList.add(row.getComments());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getChNo());
                    rowList.add(row.getDelDiffStatus());
                    rowList.add(row.getBrandType());
                    rowList.add(row.getGcWlStatus());
                    rowList.add(row.getFreight());
                    rowList.add(row.getGoodsSignDate());
                    rowList.add(row.getIsSubmit());
                    rowList.add(row.getBoxes());
                    rowList.add(row.getIsCompleted());
                    rowList.add(row.getIsOutnumber());
                    rowList.add(row.getDpName());
                    rowList.add(row.getDpNo());
                    rowList.add(row.getSenderNo());
                    rowList.add(row.getSenderName());
                    rowList.add(row.getReceiverNo());
                    rowList.add(row.getReceiverName());
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

    @RequestMapping(value="DeliveryList",method = RequestMethod.GET)
    @ApiOperation(value = "收货确认列表管理", notes = "收货确认列表管理")
    public String DeliveryList(Model model) {
        return "mro/shouhuo/SHdaishou";
    }

    @RequestMapping(value = "DeliveryEdit", method = RequestMethod.GET)
    @ApiOperation(value = "收货确认编辑", notes = "收货确认编辑")
    public String DeliveryEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Delivery delivery = new Delivery();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            delivery = deliveryService.getDeliveryByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("delivery",delivery);
        model.addAttribute("isUpdate",isUpdate);
        return "DeliveryEdit";
    }

    /**
     *保存方法
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "/saveDelivery", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "保存方法", notes = "保存方法")
    public CommonRestResponse saveDelivery(HttpServletRequest httpRequest, @RequestBody List<DeliveryVO> deliveryDtos) {

        try {
            for(DeliveryVO deliveryDto:deliveryDtos){
                String shNo = deliveryDto.getShNo() == null ? "" : deliveryDto.getShNo();
                GCshHdead gcShHead = gCshHdeadService.findGCshHeadByShno(shNo);
                if (gcShHead != null) {
                    String isGCJLSign = gcShHead.getIsGcjlsign() == null ? "" : gcShHead.getIsGcjlsign();
                    String signContacts = gcShHead.getContacts() == null ? "" : gcShHead.getContacts();
                    // 根据登录角色是否为工程监理来判读
                    //     Collection<String> roles = SecurityUtils.getUserDetails().getRoleCodes();
                    if ("1".equals(isGCJLSign)) {

                   /* if (!roles.contains("scm_gc_gcjl")) {
                        throw new Exception("该订单为工程监理签收订单，非工程监理角色，无法签收！");
                    }*/
                    } else if ("0".equals(isGCJLSign)) {
                        // 0 店铺签收
                        /*
                         * String shopNo = deliveryDto.getShopNo(); String
                         * loginUserNo = getLoginUserNo();
                         */
                    /*if (roles.contains("scm_gc_gcjl")) {
                        throw new Exception("该订单为店铺签收订单，工程监理角色，无法签收！");
                    }*/
                    }

                }
                  Integer id=Integer.valueOf(String.valueOf(deliveryDto.getId()).substring(1));
                  DeliveryVO vo=gCshHdeadService.get(id);

                  vo.setQcShQut(deliveryDto.getQcShQut());
                  vo.setCyQut(deliveryDto.getCyQut());

                  deliveryDto.setGcWlStatus("01");
                // deliveryDto.setGoodsSignDate(new Date());

                // update by siyang.gu 17/10/2017 需要在保存之后调用SAP传送接口
                // 故在return之前使用变量来接收返回值，而后再return之
                   deliveryService.saveDelivery(vo);
                // Gcshhead gcshhead =
                // gcShHeadService.findByShno(deliveryDto.getShNo());
                // gcShHeadService.setGcShHeadFinish(gcshhead,deliveryDto);
                // update by siyang.gu 17/10/2017 发送PO信息到SAP接口
                // ======================================================传SAP start
                // deliveryDto =deliveryService.get(id);
                // deliveryService.deliveryCrAsySapWs(deliveryDto);
                // ======================================================传SAP end


            }

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

}