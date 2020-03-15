package com.ur.mro.shop.controller;


import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Maps;
import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.menu.service.AdminMenuInfoService;
import com.ur.admin.rightshare.service.AdminRightshareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.ur.mro.contract.model.Contract;
import com.ur.mro.contract.service.ContractService;
import com.ur.mro.dic.service.DictionaryService;
import com.ur.mro.pic.service.AttachmentService;
import com.ur.mro.shop.model.Shop2GC;
import com.ur.mro.shop.service.Shop2GCService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "shop")
@Api(description = " Shop2GCController的注释 ")

public class Shop2GCController {

    private static final Logger logger = LoggerFactory.getLogger(Shop2GCController.class);
    
    private final String MAPPINGURL = "shop/Shop2GCList";

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    Shop2GCService shop2GCService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    AttachmentService attachmentService;


    @Autowired
    ContractService contractService;

    @Autowired
    AdminMenuInfoService menuService;

    @Autowired
    AdminRightshareService adminRightshareService;


    @RequestMapping(value = "Shop2GC/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "店铺查询方法", notes = "店铺查询方法",response = Shop2GC.class, responseContainer="List")
    public CommonRestResponse searchShop2GC(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Shop2GC.class);

            PagingRestResponse response = shop2GCService.searchShop2GC(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }


    @RequestMapping(value = "Shop2GC/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Shop2GC导出接口，返回待下载的Excel文件名", notes = "Shop2GC导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportShop2GC(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done

            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);

            //remove injection code
            request.removeInjectionCode();

            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Shop2GC.class);
            PagingRestResponse response = shop2GCService.searchShop2GC(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Shop2GC> resultList = (List<Shop2GC>)response.getData();

            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("code");
                headerList.add("name");
                headerList.add("contractArea");
                headerList.add("salesBudget");
                headerList.add("brandType");
                headerList.add("type");
                headerList.add("salesLevel");
                headerList.add("imageLevel");
                headerList.add("isCrossLayer");
                headerList.add("reload");
                headerList.add("isStreetShop");
                headerList.add("outsideHouse");
                headerList.add("staffEstablishing");
                headerList.add("expectedOpenTime");
                headerList.add("openTime");
                headerList.add("expectedEngineeringDeliveryTime");
                headerList.add("engineeringDeliveryTime");
                headerList.add("expectedEngineeringApproachTime");
                headerList.add("engineeringApproachTime");
                headerList.add("country");
                headerList.add("province");
                headerList.add("city");
                headerList.add("postcode");
                headerList.add("address");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("deleted");
                headerList.add("invoiceHead");
                headerList.add("disabled");
                headerList.add("area");
                headerList.add("region");
                headerList.add("district");

                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Shop2GC row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getCode());
                    rowList.add(row.getName());
                    rowList.add(row.getContractArea());
                    rowList.add(row.getSalesBudget());
                    rowList.add(row.getBrandType());
                    rowList.add(row.getType());
                    rowList.add(row.getSalesLevel());
                    rowList.add(row.getImageLevel());
                    rowList.add(row.getIsCrossLayer());
                    rowList.add(row.getReload());
                    rowList.add(row.getIsStreetShop());
                    rowList.add(row.getOutsideHouse());
                    rowList.add(row.getStaffEstablishing());
                    rowList.add(row.getExpectedOpenTime());
                    rowList.add(row.getOpenTime());
                    rowList.add(row.getExpectedEngineeringDeliveryTime());
                    rowList.add(row.getEngineeringDeliveryTime());
                    rowList.add(row.getExpectedEngineeringApproachTime());
                    rowList.add(row.getEngineeringApproachTime());
                    rowList.add(row.getCountry());
                    rowList.add(row.getProvince());
                    rowList.add(row.getCity());
                    rowList.add(row.getPostcode());
                    rowList.add(row.getAddress());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getInvoiceHead());
                    rowList.add(row.getDisabled());
                    rowList.add(row.getArea());
                    rowList.add(row.getRegion());
                    rowList.add(row.getDistrict());
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
            logger.error(e.getMessage());
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value="Shop2GCList",method = RequestMethod.GET)
    @ApiOperation(value = "店铺主数据列表数据", notes = "店铺主数据列表数据")
    public String Shop2GCList(Model model) {
         addDictionary2Model(model);
         getMenuButtonLByRode(model);
        return "mro/shop/DPguanli";
    }

    @RequestMapping(value = "Shop2GCEdit", method = RequestMethod.GET)
    @ApiOperation(value = "Shop2GCEdit默认页面模板", notes = "Shop2GCEdit默认页面模板")
    public String Shop2GCEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

        String id = httpRequest.getParameter("id");//0-新增，1-编辑，2-查看
        Shop2GC shop2GC = new Shop2GC();
        int isUpdate = 0;
        if(id!=null && !id.equals("")){
            shop2GC = shop2GCService.getShop2GCByPK(Integer.valueOf(id));
            List<Contract> lists=contractService.getContractByShopId(Integer.valueOf(id));
            if(lists!=null&&lists.size()>0){
                lists.forEach(en->{
                    if(en.getIsDefault()!=null&&en.getIsDefault().equals("true")){
                        en.setIsDefaults(true);
                    }
                    else
                        en.setIsDefaults(false);

                });
                shop2GC.setInfoContactInformationList(lists);
            }

            isUpdate = 1;
        }

        addDictionary2Model(model);
        model.addAttribute("shop2GC",shop2GC);
        model.addAttribute("isUpdate",isUpdate);
         return "mro/shop/DPbianji";
    }

    @RequestMapping(value = "Shop2GCCk", method = RequestMethod.GET)
    @ApiOperation(value = "查看页面", notes = "查看页面")
    public String Shop2GCCk(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

        String id = httpRequest.getParameter("id");
        Shop2GC shop2GC = new Shop2GC();
        if(id!=null && !id.equals("")){
            shop2GC = shop2GCService.getShop2GCByPK(Integer.valueOf(id));
            List<Contract> lists=contractService.getContractByShopId(Integer.valueOf(id));
            if(lists!=null&&lists.size()>0){
                lists.forEach(en->{
                    if(en.getIsDefault()!=null&&en.getIsDefault().equals("true")){
                        en.setIsDefaults(true);
                    }
                    else
                        en.setIsDefaults(false);

                });
                shop2GC.setInfoContactInformationList(lists);
            }
        }

        addDictionary2Model(model);
        model.addAttribute("shop2GC",shop2GC);
        model.addAttribute("isUpdate",2);
        return "mro/shop/DPchankan";
    }


    /**
     *保存方法
     * @param httpRequest
     * @param shop2GC
     * @return
     */
    @RequestMapping(value = "SaveShop2GC", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存方法", notes = "保存方法")
    public CommonRestResponse saveShop2GC(HttpServletRequest httpRequest, @RequestBody Shop2GC shop2GC) {
        try {
               int  count=shop2GCService.checkDataMaster(shop2GC);
              if(count>0){
                  return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"店铺主数据编码名称重复,保存失败！",null);
              }
              count=shop2GCService.checkDataDetail(shop2GC.getInfoContactInformationList());

            if(count>0){
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"店铺联系人明细重复,保存失败！",null);
            }

              Integer id = shop2GCService.save(shop2GC);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 删除
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteShop2GC",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteShop2GC(Model model, HttpServletRequest httpRequest,@RequestBody  List<Shop2GC> shop2GCList) {

        try {
              shop2GCService.delete(shop2GCList);

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }


    /**
     *删除明细方法
     * @return
     */
    @RequestMapping(value = "deletedShop2GC", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除明细方法", notes = "删除明细方法")
    public CommonRestResponse deletedShop2GC(HttpServletRequest httpRequest, @RequestBody Contract contract) {
        try {

            contractService.deleteContractByPKSelective(contract);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     *同步OA信息
     * @return
     */
    @RequestMapping(value = "synchroShop2GC", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "同步OA信息", notes = "同步OA信息")
    public CommonRestResponse synchroShop2GC(HttpServletRequest httpRequest,@RequestBody List<Shop2GC> shop2GCList) {
        try {
            shop2GCService.synchroShopInfo(shop2GCList);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }



    /**
     * 返回数据字典
     * @param model
     */
    private void addDictionary2Model(Model model){

            model.addAttribute("types",getDictionaryByKey("GC_shopType")); //类型
            model.addAttribute("saleLevels",getDictionaryByKey("GC_salesLevel")); //销售级别

            model.addAttribute("isCrossLayer",getDictionaryByKey("GC_yesOrNo"));//  跨层
            model.addAttribute("isStreetShop",getDictionaryByKey("GC_yesOrNo")); //街铺
            model.addAttribute("outsideHouse",getDictionaryByKey("GC_haveOrNot")); //外仓
            model.addAttribute("brandType",getDictionaryByKey("GC_brand")); //品牌

            model.addAttribute("disableds",getDictionaryByKey("GC_YON")); //禁用
            model.addAttribute("imageLevel",getDictionaryByKey("GC_shopImage")); //店铺形象

            model.addAttribute("country",getDictionaryByKey("nation")); //所属国家
            model.addAttribute("province",getDictionaryByKey("province")); //所属省份
            model.addAttribute("city",getDictionaryByKey("city")); //所属城市
            model.addAttribute("position",getDictionaryByKey("GC_position")); //职位

    }

    /**
     * 获取菜单权限
     * @param model
     */

    private  void getMenuButtonLByRode(Model model){
    	// 根据路径获取菜单ID，用于配置连接内容展示的按钮权限控制
    	int menuId = menuService.getAdminMenuIdByMappingUrl(MAPPINGURL);
    	
          List<AdminButtonInfo> buttons = adminRightshareService.getOperateBtnByCurrUser("L", menuId);
          Map<String,Object> btns=Maps.newHashMap();

          if(!Objects.isNull(buttons)&&!buttons.isEmpty()){
                for(AdminButtonInfo btn:buttons){
                if(btn.getButtonName()!=null&&"新增".equals(btn.getButtonName().trim()))
                     btns.put("isAdd",true);
                if(btn.getButtonName()!=null&&"编辑".equals(btn.getButtonName().trim()))
                    btns.put("isEdit",true);
                if(btn.getButtonName()!=null&&"删除".equals(btn.getButtonName().trim()))
                    btns.put("isDel",true);
                if(btn.getButtonName()!=null&&"查看".equals(btn.getButtonName().trim()))
                    btns.put("isLook",true);
                if(btn.getButtonName()!=null&&"同步".equals(btn.getButtonName().trim()))
                    btns.put("isSyn",true);
            }
        }
          model.addAttribute("auditButton", btns);
    }
    /**
     * 取数据字典
     */
    private  Map  getDictionaryByKey(String  key){
            if(key.equals("province"))
                return dictionaryService.getAllProvice();
            else if(key.equals("city"))
                return dictionaryService.getMapBySgroupandProvice();
             else
                return  dictionaryService.getMapBySgroup(key);

    }


}