package com.ur.mro.mat.controller;

import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.menu.service.AdminMenuInfoService;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.common.util.UploadUtil;
import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;
import com.ur.mro.dic.service.DictionaryService;
import com.ur.mro.mat.mappers.MaterialMapper;
import com.ur.mro.mat.model.Material;
import com.ur.mro.mat.model.MaterialInfo;
import com.ur.mro.mat.service.MaterialInfoService;
import com.ur.mro.mat.service.MaterialService;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "mat")
@Api(description = "MaterialController的注释")
public class MaterialController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

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
    MaterialService materialService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    MaterialInfoService materialInfoService;

    @Autowired
    AdminMenuInfoService menuService;

    @Autowired
    AdminRightshareService rightService;

    private final String MAPPINGURL = "/materialList";


    /**
     * 物料主数据列表
     * @param model
     * @return
     */

    @RequestMapping(value="materialList",method = RequestMethod.GET)
    @ApiOperation(value = "物料主数据列表", notes = "物料主数据列表")
    public String MaterialTemplate(Model model) {
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态


        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);

        int menuId = menuService.getAdminMenuIdByMappingUrl(MAPPINGURL);
        List<AdminButtonInfo> buttons = rightService.getOperateBtnByCurrUser("L", menuId);
        System.err.println(buttons.size() + "====usermanager menuId=" + menuId);
        model.addAttribute("buttons", buttons);

        return "mro/mat/WLguanli";
    }

    /**
     * 物料主数据弹窗列表
     * @param model
     * @return
     */

    @RequestMapping(value="tkMaterialList",method = RequestMethod.GET)
    @ApiOperation(value = "物料主数据列表", notes = "物料主数据列表")
    public String TkMaterialTemplate(Model model) {
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态


        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);

        return "mro/mat/TKWLguanli";
    }

    /**
     * 编辑
     * @return
     */
    @RequestMapping(value="editMaterial",method = RequestMethod.GET)
    @ApiOperation(value = "表单编辑", notes = "表单编辑")
    public String editMaterialTemplate(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Material material = materialService.getMaterialByPK(Integer.valueOf(id));
        model.addAttribute("material",material);
        Map<String, String> unit = dictionaryService.getMapBySgroup("UNIT");//单位
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String, String> useArea = dictionaryService.getMapBySgroup("useArea");//使用区域
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String, String> oldCodeMat = dictionaryService.getMapBySgroup("GC_oldCodeMat");//下单类别
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态
        Map<String, String> buyGroup = dictionaryService.getMapBySgroup("GC_buyGroup");//采购组织
        String[] strArray = materialService.getOldmatCodes();
        JSONArray tenStrArray = materialService.getTenOldmatCodes();

        model.addAttribute("unit",unit);
        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("useArea",useArea);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("oldCodeMat",oldCodeMat);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);
        model.addAttribute("buyGroup",buyGroup);
        model.addAttribute("createOrEdit","编辑");
        model.addAttribute("imageUrl",imageUrl);
        model.addAttribute("deleteUrl",deleteUrl);
        model.addAttribute("downloadUrl",downloadUrl);
        model.addAttribute("uploadUrl",uploadUrl);
        model.addAttribute("strArray",strArray);
        model.addAttribute("tenStrArray",tenStrArray);

        return "mro/mat/WLbianji";
    }

    /**
     * 查看
     * @return
     */
    @RequestMapping(value="checkMaterial",method = RequestMethod.GET)
    @ApiOperation(value = "表单编辑", notes = "表单编辑")
    public String checkMaterial(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Material material = materialService.getMaterialByPK(Integer.valueOf(id));
        model.addAttribute("material",material);
        Map<String, String> unit = dictionaryService.getMapBySgroup("UNIT");//单位
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String, String> useArea = dictionaryService.getMapBySgroup("useArea");//使用区域
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String, String> oldCodeMat = dictionaryService.getMapBySgroup("GC_oldCodeMat");//下单类别
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态
        Map<String, String> buyGroup = dictionaryService.getMapBySgroup("GC_buyGroup");//采购组织
        String[] strArray = materialService.getOldmatCodes();
        JSONArray tenStrArray = materialService.getTenOldmatCodes();

        model.addAttribute("unit",unit);
        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("useArea",useArea);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("oldCodeMat",oldCodeMat);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);
        model.addAttribute("buyGroup",buyGroup);
        model.addAttribute("createOrEdit","编辑");
        model.addAttribute("imageUrl",imageUrl);
        model.addAttribute("deleteUrl",deleteUrl);
        model.addAttribute("downloadUrl",downloadUrl);
        model.addAttribute("uploadUrl",uploadUrl);
        model.addAttribute("strArray",strArray);
        model.addAttribute("tenStrArray",tenStrArray);

        return "mro/mat/WLchakan";
    }



    /**
     * 复制
     * @return
     */
    @RequestMapping(value="copyMaterial",method = RequestMethod.GET)
    @ApiOperation(value = "复制表单", notes = "复制表单")
    public String copyMaterialTemplate(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Material material = materialService.copyMaterial(Integer.valueOf(id));
        model.addAttribute("material",material);
        Map<String, String> unit = dictionaryService.getMapBySgroup("UNIT");//单位
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String, String> useArea = dictionaryService.getMapBySgroup("useArea");//使用区域
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String, String> oldCodeMat = dictionaryService.getMapBySgroup("GC_oldCodeMat");//下单类别
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态
        Map<String, String> buyGroup = dictionaryService.getMapBySgroup("GC_buyGroup");//采购组织
        String[] strArray = materialService.getOldmatCodes();
        JSONArray tenStrArray = materialService.getTenOldmatCodes();


        model.addAttribute("unit",unit);
        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("useArea",useArea);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("oldCodeMat",oldCodeMat);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);
        model.addAttribute("buyGroup",buyGroup);
        model.addAttribute("imageUrl",imageUrl);
        model.addAttribute("deleteUrl",deleteUrl);
        model.addAttribute("downloadUrl",downloadUrl);
        model.addAttribute("uploadUrl",uploadUrl);
        model.addAttribute("strArray",strArray);
        model.addAttribute("tenStrArray",tenStrArray);
        model.addAttribute("createOrEdit","复制");

        return "mro/mat/WLbianji";
    }



    /**
     * 删除
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="deleteMaterial",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "删除", notes = "删除")
    public CommonRestResponse deleteMaterial(Model model, HttpServletRequest httpRequest,@RequestBody  List<Material> materialList) {



        try {
            materialService.deletedMaterial(materialList);

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value="createMaterial",method = RequestMethod.GET)
    @ApiOperation(value = "新增表单", notes = "新增表单")
    public String createMaterial(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse){

        String id = httpRequest.getParameter("id");
        Material material = new Material();
        material.setStatus("1");
        material.setDeleted(0);
        model.addAttribute("material",material);
        Map<String, String> unit = dictionaryService.getMapBySgroup("UNIT");//单位
        Map<String, String> matType = dictionaryService.getMapBySgroup("GC_matType");//物料类型
        Map<String, String> brandType = dictionaryService.getMapBySgroup("GC_brand");
        Map<String, String> categoryA = dictionaryService.getMapBySgroup("GC_CategoryA");//大类
        Map<String, String> useArea = dictionaryService.getMapBySgroup("useArea");//使用区域
        Map<String,Map<String,String>> allCategoryB = dictionaryService.getMapBySgroupandCa("GC_CategoryA", "GC_CategoryB");//所有中类
        Map<String,Map<String,String>> allCategoryC = dictionaryService.getMapBySgroupandCa("GC_CategoryB","GC_CategoryC");//所有小类
        Map<String, String> oldCodeMat = dictionaryService.getMapBySgroup("GC_oldCodeMat");//下单类别
        Map<String,Map<String,String>> shopImage = dictionaryService.getMapBySgroupandCa("GC_brand","GC_shopImage");
        Map<String, String> matStatus = dictionaryService.getMapBySgroup("GC_matStatus");//物料状态
        Map<String, String> buyGroup = dictionaryService.getMapBySgroup("GC_buyGroup");//采购组织
        String[] strArray = materialService.getOldmatCodes();
        JSONArray tenStrArray = materialService.getTenOldmatCodes();

        model.addAttribute("unit",unit);
        model.addAttribute("matType",matType);
        model.addAttribute("brandType",brandType);
        model.addAttribute("categoryA",categoryA);
        model.addAttribute("useArea",useArea);
        model.addAttribute("allCategoryB",allCategoryB);
        model.addAttribute("allCategoryC",allCategoryC);
        model.addAttribute("oldCodeMat",oldCodeMat);
        model.addAttribute("shopImage",shopImage);
        model.addAttribute("matStatus",matStatus);
        model.addAttribute("buyGroup",buyGroup);
        model.addAttribute("createOrEdit","新增");
        model.addAttribute("imageUrl",imageUrl);
        model.addAttribute("deleteUrl",deleteUrl);
        model.addAttribute("downloadUrl",downloadUrl);
        model.addAttribute("uploadUrl",uploadUrl);
        model.addAttribute("strArray",strArray);
        model.addAttribute("tenStrArray",tenStrArray);



        return "mro/mat/WLbianji";
    }


    /**
     *保存方法
     * @param httpRequest
     * @param material
     * @return
     */
    @RequestMapping(value = "saveMaterial", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存方法", notes = "保存方法")
    public CommonRestResponse saveMaterial(HttpServletRequest httpRequest, @RequestBody Material material) {
        try {
            Integer id = materialService.saveMaterial(material);

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,id);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     *删除明细方法
     * @param httpRequest
     * @param materialInfo
     * @return
     */
    @RequestMapping(value = "deletedMaterialInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除明细方法", notes = "删除明细方法")
    public CommonRestResponse deletedMaterialInfo(HttpServletRequest httpRequest, @RequestBody MaterialInfo materialInfo) {
        try {
            materialInfo.setDeleted(1);
            materialInfoService.updateMaterialInfoByPKSelective(materialInfo);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 批量禁用物料
     * @param model
     * @param httpRequest
     */
    @RequestMapping(value="updateBatchStatus",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "批量禁用物料", notes = "批量禁用物料")
    public CommonRestResponse updateBatchStatus(Model model, HttpServletRequest httpRequest,@RequestBody  List<Material> materialList) {

        materialMapper.updateBatchStatus(materialList);
        try {

            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Material/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取Material", notes = "根据pkId获取Material",response = Material.class)
    public CommonRestResponse getMaterialByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            Material material = materialService.getMaterialByPK(pkId);



            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,material);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }



    @RequestMapping(value = "Material/update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新Material", notes = "根据pkId更新Material")
    public CommonRestResponse updateMaterialByPKSelective(HttpServletRequest httpRequest, @RequestBody Material material) {
        try {
            //TODO authentication to be done
            List<Material>  materialList= materialService.getMaterialByCode("01GCBGBGJS0001");
            materialService.updateMaterialByPKSelective(material);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    /**
     * 导出物料主数据
     * @param httpRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "Material/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Material通用查询方法", notes = "Material通用查询方法",response = Material.class, responseContainer="List")
    public CommonRestResponse searchMaterial(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done

            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Material.class);


            List<CommonSearchCondition> commonSearchConditionList = request.getCondList();
            /*CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setBeanName("");
            commonSearchCondition.setColumnName("DELETED");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue("0");
            commonSearchConditionList.add(commonSearchCondition);*/

            PagingRestResponse response = materialService.searchMaterial(request.getSelectFields(),commonSearchConditionList,request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "importMaterialExcel", method = RequestMethod.POST)
    public void uploadExcelSecondPlanShopPlanning(HttpServletRequest req, HttpServletResponse resp,
                                                  @RequestParam("file") MultipartFile file) throws Exception{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HashMap<String, Object> result = new HashMap<String, Object>();

        if(null != file &&  !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String filePath = req.getSession().getServletContext().getRealPath("upload/");
            logger.info("importMaterialExcel  importExcel  upload file: "+ filePath + fileName );
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
                result =  materialService.importExcel(filePath+fileName, fileName, inputStream, result);
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

    /**
     * 导出物料主数据
     * @param httpRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "Material/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "导出物料主数据", notes = "导出物料主数据")
    public CommonRestResponse exportMaterial(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Material.class);
            PagingRestResponse response = materialService.searchMaterial(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Material> resultList = (List<Material>)response.getData();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("物料编码");
                headerList.add("物料名称");
                headerList.add("英文描述");
                headerList.add("物料类型");
                headerList.add("品牌");
                headerList.add("店铺形象");
                headerList.add("基本单位");
                headerList.add("规格");
                headerList.add("材质");
                headerList.add("大类");
                headerList.add("中类");
                headerList.add("小类");
                headerList.add("制作工艺");
                headerList.add("颜色");
                headerList.add("状态");
                headerList.add("创建人");
                headerList.add("创建时间");
                headerList.add("更新人");
                headerList.add("更新时间");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Material row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getCode());
                    rowList.add(row.getName());
                    rowList.add(row.getMatDepict());
                    rowList.add(row.getMatType());
                    rowList.add(row.getBrandType());
                    rowList.add(row.getShopImageName());
                    rowList.add(row.getUnit());
                    rowList.add(row.getSpec());
                    rowList.add(row.getMaterialCz());
                    rowList.add(row.getCategoryA());
                    rowList.add(row.getCategoryB());
                    rowList.add(row.getCategoryC());
                    rowList.add(row.getMakeIe());
                    rowList.add(row.getColor());
                    rowList.add(row.getStatus());
                    rowList.add(row.getCreatedBy());
                    rowList.add(formatter.format(row.getCreatedTime()));
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(formatter.format(row.getLastUpdatedTime()));
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