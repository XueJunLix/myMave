package com.ur.mro.sup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ur.mro.sup.model.*;
import com.ur.mro.sup.service.*;
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
import com.ur.mro.dic.service.DictionaryService;
import com.ur.mro.sup.mappers.SupplierHbMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "sup")
@Api(description = "SupplierHbController的注释")
public class SupplierHbController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierHbController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Value("${pic.server.host.download_url}")
    String downloadUrl;

    @Value("${pic.server.host.upload_url}")
    String uploadUrl;

    @Value("${pic.server.host.image_url}")
    String imageUrl;

    @Value("${pic.server.host.delete_url}")
    String deleteUrl;


    @Autowired
    SupplierService supplierService;

    @Autowired
    SupContractInfoService supContractInfoService;

    @Autowired
    SupplierHbService supplierHbService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    SupplierHbMapper supplierHbMapper;

    @Autowired
    SupBankInfoService supBankInfoService;

    @Autowired
    SupWorkersService supWorkersService;

    @Autowired
    SupEquipmertsService supEquipmertsService;

    @Autowired
    SupPartnersService supPartnersService;

    @Autowired
    SupCustomersService supCustomersService;

    @Autowired
    SupPayInfoService supPayInfoService;

    @Autowired
    SupContactsService supContactsService;


    /**
     * 供应商列表
     * @param model
     * @return
     */
    @RequestMapping(value="supplierList",method = RequestMethod.GET)
    @ApiOperation(value = "供应商列表", notes = "供应商列表")
    public String SupplierTemplate(Model model) {
        Map<String, String> coordination = dictionaryService.getMapBySgroup("coordination");//是否协同
        Map<String, String> gCsupStatus = dictionaryService.getMapBySgroup("GC_SUP_STATUS");//供应商状态

        model.addAttribute("coordination",coordination);
        model.addAttribute("gCsupStatus",gCsupStatus);

        return "mro/sup/GYSguanli";
    }

    /**
     * 新增修改
     * @param model
     * @param httpRequest
     * @param httpResponse
     * @return
     */
    @RequestMapping(value = "editSupplier", method = RequestMethod.GET)
    @ApiOperation(value = "SupplierEdit默认页面模板", notes = "SupplierEdit默认页面模板")
    public String SupplierEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        SupplierHb supplierHb = supplierHbService.getSupplierHb(id);

        model.addAttribute("supplierHb",supplierHb);

        Map<String, String> coordination = dictionaryService.getMapBySgroup("coordination");//是否协同
        Map<String, String> gCsupStatus = dictionaryService.getMapBySgroup("GC_SUP_STATUS");//供应商状态
        Map<String, String> supCooperationWay = dictionaryService.getMapBySgroup("GC_supCooperationWay");//供应商等级
        Map<String, String> suppType = dictionaryService.getMapBySgroup("GC_Supp_type");//供应商类型（账户组）
        Map<String, String> industryType = dictionaryService.getMapBySgroup("industryType");//行业类型
        Map<String, String> nation = dictionaryService.getMapBySgroup("nation");//国家
        Map<String, String> privince = dictionaryService.getAllProvice();//省
        Map<String,Map<String,String>> allCity = dictionaryService.getMapBySgroupandProvice();//所有市
        Map<String, String> payWay = dictionaryService.getMapBySgroup("GCpayWay");//付款条件
        Map<String, String> payCurrency = dictionaryService.getMapBySgroup("payCurrency");//订单币别
        Map<String, String> payCess = dictionaryService.getMapBySgroup("GCpayCess");//税码
        Map<String, String> payMode = dictionaryService.getMapBySgroup("GC_payMode");//付款条件
        Map<String, String> year = dictionaryService.getMapBySgroup("year");//年


        model.addAttribute("coordination",coordination);
        model.addAttribute("gCsupStatus",gCsupStatus);
        model.addAttribute("supCooperationWay",supCooperationWay);
        model.addAttribute("suppType",suppType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("nation",nation);
        model.addAttribute("privince",privince);
        model.addAttribute("allCity",allCity);
        model.addAttribute("payWay",payWay);
        model.addAttribute("payCurrency",payCurrency);
        model.addAttribute("payCess",payCess);
        model.addAttribute("payMode",payMode);
        model.addAttribute("year",year);
        model.addAttribute("imageUrl",imageUrl);
        model.addAttribute("deleteUrl",deleteUrl);
        model.addAttribute("downloadUrl",downloadUrl);
        model.addAttribute("uploadUrl",uploadUrl);

        return "mro/sup/GYSbianji";
    }

    @RequestMapping(value = "getSupplier/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取Supplier", notes = "根据pkId获取Supplier",response = Supplier.class)
    public CommonRestResponse getSupplierByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            Supplier supplier = supplierService.getSupplierByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,supplier);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 保存供应商主数据
     * @param httpRequest
     * @param supplierHb
     * @return
     */
    @RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存供应商主数据", notes = "保存供应商主数据")
    public CommonRestResponse insertSupplier(HttpServletRequest httpRequest, @RequestBody SupplierHb supplierHb) {
        try {

            supplierHbService.saveSupplierHb(supplierHb);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除供应商（包括明细）
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupplierHb",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupplierHb(Model model, HttpServletRequest httpRequest,@RequestBody  SupplierHb supplierHb) {
                    Integer id = supplierHb.getSupplier().getId();
                    supplierService.deleteSupplier(id);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除银行信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupBankInfo",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupBankInfo(Model model, HttpServletRequest httpRequest,@RequestBody  SupBankInfo supBankInfo) {
        supBankInfoService.updateSupBankInfoByPKSelective(supBankInfo);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除合同信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupContractInfo",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupContractInfo(Model model, HttpServletRequest httpRequest,@RequestBody  SupContractInfo supContractInfo) {

        supContractInfoService.updateSupContractInfoByPKSelective(supContractInfo);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除人员情况信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupWorkers",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupWorkers(Model model, HttpServletRequest httpRequest,@RequestBody  SupWorkers supWorkers) {

        supWorkersService.updateSupWorkersByPKSelective(supWorkers);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除设备情况信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupEquipmerts",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupEquipmerts(Model model, HttpServletRequest httpRequest,@RequestBody  SupEquipmerts supEquipmerts) {

        supEquipmertsService.updateSupEquipmertsByPKSelective(supEquipmerts);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }


    /**
     * 删除合作厂商信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupPartners",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupPartners(Model model, HttpServletRequest httpRequest,@RequestBody  SupPartners supPartners) {

        supPartnersService.updateSupPartnersByPKSelective(supPartners);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除主要客户信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupCustomers",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupCustomers(Model model, HttpServletRequest httpRequest,@RequestBody  SupCustomers supCustomers) {

        supCustomersService.updateSupCustomersByPKSelective(supCustomers);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除支付数据信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupPayInfo",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupPayInfo(Model model, HttpServletRequest httpRequest,@RequestBody  SupPayInfo supPayInfo) {

        supPayInfoService.updateSupPayInfoByPKSelective(supPayInfo);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除联系人信息
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteSupContacts",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteSupContacts(Model model, HttpServletRequest httpRequest,@RequestBody SupContacts supContacts) {

        supContactsService.updateSupContactsByPKSelective(supContacts);

        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Supplier/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新Supplier", notes = "根据pkId更新Supplier")
    public CommonRestResponse updateSupplierByPKSelective(HttpServletRequest httpRequest, @RequestBody Supplier supplier) {
        try {
            //TODO authentication to be done
            
            supplierService.updateSupplierByPKSelective(supplier);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 查询
     * @param httpRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "供应商查询列表", notes = "供应商查询列表",response = Supplier.class, responseContainer="List")
    public CommonRestResponse searchSupplier(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Supplier.class);
            PagingRestResponse response = supplierHbService.searchSupplierHb(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }


    @RequestMapping(value = "Supplier/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Supplier导出接口，返回待下载的Excel文件名", notes = "Supplier导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportSupplier(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Supplier.class);
            PagingRestResponse response = supplierService.searchSupplier(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Supplier> resultList = (List<Supplier>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("供应商编码");
                headerList.add("供应商名称");
                headerList.add("供应商简称");
                headerList.add("供应商类型");
                headerList.add("供应商状态");
                headerList.add("旧供应商编码");
                headerList.add("对应开发员");
                headerList.add("是否协同");
                headerList.add("电子签章状态");
                headerList.add("供应商等级");
                headerList.add("营业执照");
                headerList.add("当前支付方式");
                headerList.add("当前支付条件");
                headerList.add("当前税率");
                headerList.add("地址");
                headerList.add("默认联系人");
                headerList.add("默认固定电话");
                headerList.add("默认传真");
                headerList.add("默认邮箱");
                headerList.add("合同编号");
                headerList.add("合同起");
                headerList.add("合同止");
                headerList.add("银行代码");
                headerList.add("银行名称");
                headerList.add("开户行名称");
                headerList.add("户名");
                headerList.add("银行账号");
                headerList.add("售后地址");
                headerList.add("售后联系人");
                headerList.add("售后固定电话");
                headerList.add("售后移动电话");
                headerList.add("售后传真");
                headerList.add("售后邮箱");
                headerList.add("创建人");
                headerList.add("创建时间");
                headerList.add("更新人");
                headerList.add("更新时间");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Supplier row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getCode());
                    rowList.add(row.getFullName());
                    rowList.add(row.getShortName());
                    rowList.add(row.getSupType());
                    rowList.add(row.getSupCalStatus());
                    rowList.add(row.getOldCode());
                    rowList.add("对应开发人员");
                    rowList.add(row.getCoordination());
                    rowList.add(row.getEarnestStatus());
                    rowList.add(row.getSupCooperationWay());
                    rowList.add("营业执照");
                    rowList.add("当前支付方式");
                    rowList.add("当前税率");
                    rowList.add("地址");
                    rowList.add("默认联系人");
                    rowList.add("固定电话");
                    rowList.add("默认移动电话");
                    rowList.add("默认传真");
                    rowList.add("默认邮箱");
                    rowList.add("合同编号");
                    rowList.add("合同起");
                    rowList.add("合同止");
                    rowList.add("银行代码");
                    rowList.add("银行名称");
                    rowList.add("开户行名称");
                    rowList.add("户名");
                    rowList.add("银行账号");
                    rowList.add(row.getAfterAddress());
                    rowList.add("售后联系人");
                    rowList.add("");
                    rowList.add(row.getCommentsBizscope());
                    rowList.add(row.getCommentsPartners());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getSupType());
                    rowList.add(row.getBuyGroup());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getSupGroup());
                    rowList.add(row.getSupCalStatus());
                    rowList.add(row.getMonthSettle());
                    rowList.add(row.getSupCooperationWay());
                    rowList.add(row.getDjType());
                    rowList.add(row.getCoordination());
                    rowList.add(row.getEarnestStatus());
                    rowList.add(row.getRegisterno());
                    rowList.add(row.getQgNumber());
                    rowList.add(row.getLxr());
                    rowList.add(row.getLxrNumber());
                    rowList.add(row.getJxComments());
                    rowList.add(row.getJxAddress());
                    rowList.add(row.getLxrEmail());
                    rowList.add(row.getUrKfy());
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

    @RequestMapping(value="SupplierList",method = RequestMethod.GET)
    @ApiOperation(value = "SupplierList默认页面模板", notes = "SupplierList默认页面模板")
    public String SupplierList() {
        return "SupplierList";
    }



    @RequestMapping(value="SupContractInfo",method = RequestMethod.GET)
    @ApiOperation(value = "SupContractInfo默认页面模板", notes = "SupContractInfo默认页面模板")
    public String SupContractInfoTemplate() {
        return "SupContractInfo";
    }

    @RequestMapping(value = "SupContractInfo/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取SupContractInfo", notes = "根据pkId获取SupContractInfo",response = SupContractInfo.class)
    public CommonRestResponse getSupContractInfoByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            SupContractInfo supContractInfo = supContractInfoService.getSupContractInfoByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,supContractInfo);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "SupContractInfo/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入SupContractInfo对象", notes = "插入SupContractInfo对象")
    public CommonRestResponse insertSupContractInfo(HttpServletRequest httpRequest, @RequestBody SupContractInfo supContractInfo) {
        try {
            //TODO authentication to be done
            
            supContractInfoService.insertSupContractInfo(supContractInfo);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "SupContractInfo/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新SupContractInfo", notes = "根据pkId更新SupContractInfo")
    public CommonRestResponse updateSupContractInfoByPKSelective(HttpServletRequest httpRequest, @RequestBody SupContractInfo supContractInfo) {
        try {
            //TODO authentication to be done
            
            supContractInfoService.updateSupContractInfoByPKSelective(supContractInfo);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "SupContractInfo/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "SupContractInfo通用查询方法", notes = "SupContractInfo通用查询方法",response = SupContractInfo.class, responseContainer="List")
    public CommonRestResponse searchSupContractInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(SupContractInfo.class);
            PagingRestResponse response = supContractInfoService.searchSupContractInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "SupContractInfo/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "SupContractInfo导出接口，返回待下载的Excel文件名", notes = "SupContractInfo导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportSupContractInfo(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(SupContractInfo.class);
            PagingRestResponse response = supContractInfoService.searchSupContractInfo(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<SupContractInfo> resultList = (List<SupContractInfo>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("contractNo");
                headerList.add("comments");
                headerList.add("supId");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("deleted");
                headerList.add("priceStartDate");
                headerList.add("priceEndDate");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(SupContractInfo row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getContractNo());
                    rowList.add(row.getComments());
                    rowList.add(row.getSupId());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getPriceStartDate());
                    rowList.add(row.getPriceEndDate());
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

    @RequestMapping(value="SupContractInfoList",method = RequestMethod.GET)
    @ApiOperation(value = "SupContractInfoList默认页面模板", notes = "SupContractInfoList默认页面模板")
    public String SupContractInfoList() {
        return "SupContractInfoList";
    }

    @RequestMapping(value = "SupContractInfoEdit", method = RequestMethod.GET)
    @ApiOperation(value = "SupContractInfoEdit默认页面模板", notes = "SupContractInfoEdit默认页面模板")
    public String SupContractInfoEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        SupContractInfo supContractInfo = new SupContractInfo();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            supContractInfo = supContractInfoService.getSupContractInfoByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("supContractInfo",supContractInfo);
        model.addAttribute("isUpdate",isUpdate);
        return "SupContractInfoEdit";
    }

    @RequestMapping(value="SupplierHb",method = RequestMethod.GET)
    @ApiOperation(value = "SupplierHb默认页面模板", notes = "SupplierHb默认页面模板")
    public String SupplierHbTemplate() {
        return "SupplierHb";
    }

    @RequestMapping(value = "SupplierHb/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取SupplierHb", notes = "根据pkId获取SupplierHb",response = SupplierHb.class)
    public CommonRestResponse getSupplierHbByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            SupplierHb supplierHb = supplierHbService.getSupplierHbByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,supplierHb);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "saveSupplierHb", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存供应商主数据", notes = "保存供应商主数据")
    public CommonRestResponse saveSupplierHb(HttpServletRequest httpRequest, @RequestBody SupplierHb supplierHb) {
        try {
            //TODO authentication to be done
            
            supplierHbService.saveSupplierHb(supplierHb);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

   /* @RequestMapping(value = "SupplierHb/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新SupplierHb", notes = "根据pkId更新SupplierHb")
    public CommonRestResponse updateSupplierHbByPKSelective(HttpServletRequest httpRequest, @RequestBody SupplierHb supplierHb) {
        try {
            //TODO authentication to be done

            supplierHbService.updateSupplierHbByPKSelective(supplierHb);

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }*/

    @RequestMapping(value = "SupplierHb/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "SupplierHb通用查询方法", notes = "SupplierHb通用查询方法",response = SupplierHb.class, responseContainer="List")
    public CommonRestResponse searchSupplierHb(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Supplier.class);
            PagingRestResponse response = supplierHbService.searchSupplierHb(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
}