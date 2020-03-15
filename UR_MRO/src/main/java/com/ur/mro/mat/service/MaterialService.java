package com.ur.mro.mat.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ur.admin.service.AdminUserInfoService;
import com.ur.admin.user.service.SysUserInfoService;
//import com.ur.common.model.Mat2SAPConfig;
import com.ur.common.service.BaseService;
import com.ur.common.service.SysSerivalNumberService;
import com.ur.common.util.UploadUtil;
import com.ur.fw.common.excel.ExcelReadKit;
import com.ur.fw.common.excel.ExcelReadResultBean;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.dic.service.DictionaryService;
import com.ur.mro.mat.mappers.MaterialMapper;
import com.ur.mro.mat.model.Material;
import com.ur.mro.mat.model.MaterialInfo;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;
import com.ur.mro.sap.service.SapInterfaceDataLog2Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MaterialService  extends BaseService{
    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    SysSerivalNumberService sysSerivalNumberService;

    @Autowired
    SysUserInfoService sysUserInfoService;

    @Autowired
    AdminUserInfoService adminUserInfoService;

    @Autowired
    MaterialInfoService materialInfoService;

    @Autowired
    private SapInterfaceDataLog2Service sapInterfaceDataLogService;

    /*@Autowired
    private Mat2SAPConfig mat2SAPConfig;*/


    public List<Material> getMaterialByCode(String code){
        return materialMapper.getMaterialByCode(code);
    }


    //所有旧物料编码
    public String[] getOldmatCodes(){
        List<Material> codeList = materialMapper.getOldMatCode();
        List<String> stringList  = new ArrayList<String>();
        for(int i = 0;i<codeList.size();i++){
            Material material = codeList.get(i);
            String st = material.getOldCodeMat();
            stringList.add(st);
        }
        for(int i = 0;i<10;i++){
            stringList.add("1");
        }
        String[] strings = new String[stringList.size()];
        stringList.toArray(strings);


        return  strings;
    }


    //默认十个旧物料编码
    public JSONArray getTenOldmatCodes(){
        List<Material> codeList = materialMapper.getOldMatCode();
        String str = "";
        JSONArray jsonArray =  new JSONArray();
        for(int i = 0;i<10;i++) {
            Material material = codeList.get(i);
            String st = material.getOldCodeMat();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("label", st);
            jsonObject.put("value", st);
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    public Material getMaterialByPK(Integer pkId) {
        Material material = materialMapper.getMaterialByPK(pkId);
        List<MaterialInfo> materialInfoList = materialInfoService.getMaterialInfoListBySupplierId(pkId);
        if(materialInfoList.size()>0){
            material.setMaterialInfoList(materialInfoList);
        }else{
            materialInfoList = new ArrayList<MaterialInfo>();
            material.setMaterialInfoList(materialInfoList);

        }
        List<Attachment> attachmentList = super.getAttachmentList(pkId,"com.ur.srm.mat.domain.Material");

        List<Attachment> pictureList = new ArrayList<Attachment>();
        List<Attachment> docFileList = new ArrayList<Attachment>();
        if(attachmentList.size()>0){
            for(int i = 0;i<attachmentList.size();i++){
                Attachment attachment = attachmentList.get(i);
                if("2".equals(attachment.getCom2())){
                    docFileList.add(attachment);
                }else{
                    pictureList.add(attachment);
                }
            }
            //material.setFiles(attachmentList);
        }
        material.setFiles(pictureList);
        material.setDoCfiles(docFileList);
        return material;
    }

    public Material copyMaterial(Integer pkId) {
        Material material = materialMapper.getMaterialByPK(pkId);
        material.setId(null);
        material.setCreatedBy(null);
        material.setCreatedTime(null);
        material.setLastUpdatedBy(null);
        material.setLastUpdatedTime(null);
        material.setCode(null);
        material.setName(null);
        return material;
    }

    //流水号规则
    public String getCreateMaterialNum(String brandType,String catC){
        String perCode = "";
        String numbCode = materialMapper.getCodeNum(brandType,catC);
        if(numbCode!=null){
            String str = "";
            int numb = Integer.parseInt(numbCode);
            numb++;
            if (numb < 10) {
                str = catC + "000" + numb;
            } else if (9 < numb && numb < 100) {
                str = catC + "00" + numb;
            } else if (99 < numb && numb < 1000) {
                str = catC + "0" + numb;
            } else {
                str = catC + numb;
            }
            perCode = str;
        }else{
            perCode = catC + "0001";
        }
        return brandType+perCode;
    }

    public int repeatMaterialList(Material material){
        List<CommonSearchCondition> commonSearchConditionList = new ArrayList<CommonSearchCondition>();

        if(material.getName()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("NAME");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getName());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getUnit()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("UNIT");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getUnit());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getSpec()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("SPEC");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getSpec());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getMaterialCz()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("MATERIAL_CZ");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getMaterialCz());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getCategoryA()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("CATEGORY_A");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getCategoryA());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getCategoryB()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("CATEGORY_B");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getCategoryB());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getCategoryC()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("CATEGORY_C");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getCategoryC());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getMakeIe()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("MAKE_IE");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getMakeIe());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getBrandType()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("BRAND_TYPE");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getBrandType());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getShopImage()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("SHOP_IMAGE");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(material.getShopImage());
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getChang()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("CHANG");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(String.valueOf(material.getChang()));
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getKuan()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("KUAN");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(String.valueOf(material.getKuan()));
            commonSearchConditionList.add(commonSearchCondition);
        }
        if(material.getGao()!=null){
            CommonSearchCondition commonSearchCondition = new CommonSearchCondition();
            commonSearchCondition.setColumnName("GAO");
            commonSearchCondition.setOperator("eq");
            commonSearchCondition.setValue(String.valueOf(material.getGao()));
            commonSearchConditionList.add(commonSearchCondition);
        }

        int totalRecordNum = materialMapper.searchMaterialCount(commonSearchConditionList);


         return  totalRecordNum;
    }


    @Transactional
    public Integer insertMaterial(Material material) {

        materialMapper.insertMaterial(material);
        return material.getId();
    }

    //保存
    @Transactional
    public Integer saveMaterial(Material material)throws Exception  {


        Integer id = material.getId();
        if(id == null){
            int repeatNum = this.repeatMaterialList(material);
            if(repeatNum>0){
                throw new Exception("该物料已存在，请勿创建相同的物料！");
            }
            String code = this.getCreateMaterialNum(material.getBrandType(),material.getCategoryC());
            material.setCode(code);
            super.setCreateFields(material);
            id = this.insertMaterial(material);
            //配件明细
            List<MaterialInfo> materialInfoList =  material.getMaterialInfoList();
            if(materialInfoList.size()>0){
                for(int i = 0;i<materialInfoList.size();i++){
                    MaterialInfo materialInfo = materialInfoList.get(i);
                    materialInfo.setDeleted(0);
                    materialInfo.setSupplierId(id);
                    super.setCreateFields(materialInfo);
                }
                materialInfoService.insertBatchMaterialInfo(materialInfoList);
            }
            //图片明细
            List<Attachment> filePictureList  = material.getFiles();
            if(filePictureList.size()>0){
                for(int i = 0;i<filePictureList.size();i++){
                    Attachment filePicture = filePictureList.get(i);
                    Integer fileId = filePicture.getId();
                    Attachment attachment1 = attachmentService.getAttachmentByPK(fileId);
                    attachment1.setRowId(id);
                    attachment1.setClassname("com.ur.srm.mat.domain.Material");
                    attachment1.setCom1("1");
                    super.setUpdateFields(attachment1);
                    attachmentService.updateAttachmentByPKSelective(attachment1);

                }
            }
            //附件明细
            List<Attachment> fileDocList =  material.getDoCfiles();
            if(fileDocList.size()>0){
                for(int i = 0;i<fileDocList.size();i++){
                    Attachment docFiles = fileDocList.get(i);
                    Integer fileId = docFiles.getId();
                    Attachment attachment2 = attachmentService.getAttachmentByPK(fileId);
                    attachment2.setRowId(id);
                    attachment2.setClassname("com.ur.srm.mat.domain.Material");
                    attachment2.setCom2("2");
                    super.setUpdateFields(attachment2);
                    attachmentService.updateAttachmentByPKSelective(attachment2);

                }
            }

        }else{
            super.setUpdateFields(material);
            materialMapper.updateMaterialByPKSelective(material);
            List<MaterialInfo> materialInfoList =  material.getMaterialInfoList();
            List<MaterialInfo> insertMaterialInfoList = new ArrayList<MaterialInfo>();
            List<MaterialInfo> updateMaterialInfoList = new ArrayList<MaterialInfo>();
            if(materialInfoList.size()>0){
                for(int i = 0;i<materialInfoList.size();i++){
                    MaterialInfo materialInfo = materialInfoList.get(i);
                    if(materialInfo.getId()!=null){
                        materialInfo.setDeleted(0);
                        super.setUpdateFields(materialInfo);
                        updateMaterialInfoList.add(materialInfo);
                        materialInfoService.updateBatchMaterialInfo(updateMaterialInfoList);
                    }else{
                        materialInfo.setDeleted(0);
                        materialInfo.setSupplierId(id);
                        super.setCreateFields(materialInfo);
                        insertMaterialInfoList.add(materialInfo);
                        materialInfoService.insertBatchMaterialInfo(insertMaterialInfoList);
                    }

                }

            }
            List<Attachment> filePictureList  = material.getFiles();
            if(filePictureList.size()>0){
                for(int i = 0;i<filePictureList.size();i++){
                    Attachment filePicture = filePictureList.get(i);
                    Integer fileId = filePicture.getId();
                    Attachment attachment1 = attachmentService.getAttachmentByPK(fileId);
                    attachment1.setRowId(id);
                    attachment1.setClassname("com.ur.srm.mat.domain.Material");
                    attachment1.setCom1("1");
                    super.setUpdateFields(attachment1);
                    attachmentService.updateAttachmentByPKSelective(attachment1);

                }
            }
            List<Attachment> fileDocList =  material.getDoCfiles();
            if(fileDocList.size()>0){
                for(int i = 0;i<fileDocList.size();i++){
                    Attachment doCfile = fileDocList.get(i);
                    Integer fileId = doCfile.getId();
                    Attachment attachment2 = attachmentService.getAttachmentByPK(fileId);
                    attachment2.setRowId(id);
                    attachment2.setClassname("com.ur.srm.mat.domain.Material");
                    attachment2.setCom2("2");
                    super.setUpdateFields(attachment2);
                    attachmentService.updateAttachmentByPKSelective(attachment2);

                }
            }
        }

        matcrAsySapWs(material);
        return material.getId();
    }

    /**
     * sap接口：成品/ACC商品编码主数据维护信息传输（商品主数据传输）
     * 需求编号：FS-MM-001
     * 接口编号：INT_SLM_002
     * @param material
     */
    public void matcrAsySapWs(Material material){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = format.format(new Date());
        System.out.println(dateString);
        String interfaceCode = "INT_MRO_002";
        String demandCode = "FS-MM-001";
        StringBuffer sb = new StringBuffer();

        String dataId = material.getId()+"";//商品id
        String dataCode = material.getCode()+"";//物料编码 ， 写入中间表

        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ur.cn:SLM:ERP:MasterData\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:SLM_MAT>\n" +
                "         <MSG_HDR>\n" +
                "            <INTNO>"+interfaceCode+"</INTNO>\n" +
                "            <!--Optional:-->\n" +
                "            <MSG_GUID></MSG_GUID>\n" +
                "            <!--Optional:-->\n" +
                "            <PIGUID></PIGUID>\n" +
                "            <SENDER>MRO</SENDER>\n" +
                "            <RECEIVER>SAP</RECEIVER>\n" +
                "            <BUSTYPE>"+demandCode+"</BUSTYPE>\n" +
                "            <!--Optional:-->\n" +
                "            <DATT>"+dateString+"</DATT>\n" +
                "            <!--Optional:-->\n" +
                "            <RES1></RES1>\n" +
                "            <!--Optional:-->\n" +
                "            <RES2></RES2>\n" +
                "            <!--Optional:-->\n" +
                "            <RES3></RES3>\n" +
                "         </MSG_HDR>\n" +
                "         <MSG_BODY>\n" +
                "            <!--1 or more repetitions:-->\n");



           String materialSapStr = "";
            String matnr = "";
            /*if(material.getMatType().equals("04")){
                matnr = material.getDesignNo();
            }else if(material.getMatType().equals("01") || material.getMatType().equals("02")){
            }*/
            matnr = material.getCode();

            materialSapStr = materialSapStr(material);
            sb.append(materialSapStr);



        sb.append("         </MSG_BODY>\n" +
                "      </urn:SLM_MAT>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");

        System.out.println("sb:"+sb);

        //String sapurl =mat2SAPConfig.getUrl1();
         // System.out.println("sapulr="+sapurl);
//        String url = "http://192.168.13.39:50100/XISOAPAdapter/MessageServlet?senderParty=&senderService=SCM_Q&receiverParty=&receiverService=&interface=SCM_MasterData_Out&interfaceNamespace=urn%3Aur.cn%3ASCM%3AERP%3AMasterData";
        //sapInterfaceDataLogService.sapsend(sapurl, sb.toString(), demandCode, interfaceCode, "", "",dataId,dataCode);
    }

    private String materialSapStr(Material material) {
        /*String zsjh1 = "";
        if(colorNo!=null && !colorNo.equals("")){
            zsjh1 = material.getDesignNo()+colorNo+size;
        }
        String ztm = "";
        String zspm1 = "";
        if(colorNo!=null && !colorNo.equals("")){
            ztm = material.getProductCode()+colorNo+size;
            zspm1 = material.getProductCode()+colorNo+size;
        }*/

        String materialSapStr =  "            <BU_ITEM>\n" +
                "               <MATNR>"+material.getCode()+"</MATNR>\n" +//商品编码
                "               <ZSPLX>4</ZSPLX>\n" +//商品类型 SCM: 成品，ACC，面辅料，SLM:MRO(物资)，服务 规定如下：1-成品，2-ACC, 3-面辅料，4-MRO（物资），5-服务
                "               <MAKTX>"+(material.getName())+"</MAKTX>\n" +//商品名称
                "               <!--Optional:-->\n" +
                "               <ZSJH></ZSJH>\n" +//设计号（不带颜色尺码）
                "               <!--Optional:-->\n" +
                "               <ZSJH1></ZSJH1>\n" +//设计号（带颜色尺码）
                "               <!--Optional:-->\n" +
                "               <ZWYM></ZWYM>\n" +//唯一码
                "               <!--Optional:-->\n" +
                "               <ZTM></ZTM>\n" +//条码 ：商品编码+色号+尺码
                "               <!--Optional:-->\n" +
                "               <ZDPJ></ZDPJ>\n" +//吊牌价
                "               <!--Optional:-->\n" +
                "               <ZSPBM></ZSPBM>\n" +//商品编码（不带颜色尺码）
                "               <!--Optional:-->\n" +
                "               <ZSPBM1></ZSPBM1>\n" +//商品编码（带颜色尺码）
                "               <!--Optional:-->\n" +
                "               <ZDL>"+(material.getCategoryA()==null?"":material.getCategoryA())+"</ZDL>\n" +//大类
                "               <!--Optional:-->\n" +
                "               <ZDL_MS>"+getDictionarySvalue("GC_CategoryA", material.getCategoryA())+"</ZDL_MS>\n" +//大类
                "               <!--Optional:-->\n" +
                "               <ZZL>"+(material.getCategoryB()==null?"":material.getCategoryB())+"</ZZL>\n" +//中类
                "               <!--Optional:-->\n" +
                "               <ZZL_MS>"+getDictionarySvalue("GC_CategoryB", material.getCategoryB())+"</ZZL_MS>\n" +//中类
                "               <!--Optional:-->\n" +
                "               <ZXL>"+(material.getCategoryC()==null?"":material.getCategoryC()) +"</ZXL>\n" +//小类
                "               <!--Optional:-->\n" +
                "               <ZXL_MS>"+getDictionarySvalue("GC_CategoryC", material.getCategoryC())+"</ZXL_MS>\n" +//小类
                "               <!--Optional:-->\n" +
                "               <MEINS>"+(material.getUnit()==null?"":material.getUnit()) +"</MEINS>\n" +//基本计量单位
                "               <!--Optional:-->\n" +
                "               <ZKFBM></ZKFBM>\n" +//开发编码---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZJWLBM>"+(material.getOldCodeMat()==null?"":material.getOldCodeMat())+"</ZJWLBM>\n" +//旧物料编码---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZLBMF>"+(material.getSideseal()==null?"":material.getSideseal())+"</ZLBMF>\n" +//连边门封---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZMKH>"+(material.getModuleNo()==null?"":material.getModuleNo())+"</ZMKH>\n" +//模块号---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZJWMD>"+(material.getDensity()==null?"":material.getDensity()) + "</ZJWMD>\n" +//经纬密度---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZSZGG>"+(material.getYarnSpec()==null?"":material.getYarnSpec())+ "</ZSZGG>\n" +//纱支规格---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZSSL>"+(material.getShrinkRate()==null?"":material.getShrinkRate()) + "</ZSSL>\n" +//缩水率---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZCFBCSM>"+(material.getIngDescription()==null?"":material.getIngDescription())+"</ZCFBCSM>\n" +//成份补充说明---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZCFBZ>"+(material.getIngComments()==null?"":material.getIngComments())+"</ZCFBZ>\n" +//成份备注---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZWLLY></ZWLLY>\n" +//物料来源---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZNF>"+(material.getYear()==null?"":material.getYear())+"</ZNF>\n" +//年份---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZJJ>"+(material.getSeason()==null?"":material.getSeason())+"</ZJJ>\n" +//季节---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZDH>"+(material.getOrderNo()==null?"":material.getOrderNo())+"</ZDH>\n" +//单号---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZQHDH>"+(material.getPlanOrderNo()==null?"":material.getPlanOrderNo())+"</ZQHDH>\n" +//企划单号---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZLB>"+(material.getType()==null?"":material.getType())+"</ZLB>\n" +//类别---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZDDSX>"+(material.getOrderType()==null?"":material.getOrderType())+"</ZDDSX>\n" +//订单属性---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZXL1>"+(material.getSerial()==null?"":material.getSerial())+"</ZXL1>\n" +//系列---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZFG>"+(material.getStyle()==null?"":material.getStyle())+"</ZFG>\n" +//风格---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZSPC>"+(material.getBusinessLevel()==null?"":material.getBusinessLevel())+"</ZSPC>\n" +//商品层---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZSJS>"+(material.getDesigner()==null?"":material.getDesigner())+"</ZSJS>\n" +//设计师---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZZDKM>"+(material.getStylenameAuto()==null?"":material.getStylenameAuto()) + "</ZZDKM>\n" +//自动款名---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZZDKM1>"+(material.getStylenameCustom()==null?"":material.getStylenameCustom())+"</ZZDKM1>\n" +//自定款名---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZBX>"+(material.getSample()==null?"":material.getSample())+"</ZBX>\n" +//版型---成衣属性
                "               <!--Optional:-->\n" +//
                "               <ZKX>"+(material.getSilhouette()==null?"":material.getSilhouette())+"</ZKX>\n" +//廓型---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZMLTZ>"+(material.getFabricFeatures()==null?"":material.getFabricFeatures())+"</ZMLTZ>\n" +//面料特性---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZYS>"+(material.getElement()==null?"":material.getElement())+"</ZYS>\n" +//元素---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZXX>"+(material.getSleeveType()==null?"":material.getSleeveType())+ "</ZXX>\n" +//袖型---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZLX>"+(material.getCollarType()==null?"":material.getCollarType())+"</ZLX>\n" +//领型---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZYC>"+(material.getCloLength()==null?"":material.getCloLength())+"</ZYC>\n" +//衣长---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZXCKC>"+(material.getSleeveLength()==null?"":material.getSleeveLength()) +"</ZXCKC>\n" +//袖长/裤长---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZHB>"+(material.getThickness()==null?"":material.getThickness())+"</ZHB>\n" +//厚薄---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZPP>"+(material.getBrand()==null?"":material.getBrand()) +"</ZPP>\n" +//品牌---成衣属性
                "               <!--Optional:-->\n" +
                "               <ZBZ>"+(material.getComments()==null?"":material.getComments())+"</ZBZ>\n" +//备注
                "               <!--Optional:-->\n" +
                "               <ZZT>"+(material.getStatus()==null?"":material.getStatus()) + "</ZZT>\n" +//状态
                "               <!--Optional:-->\n" +
                "               <ZCMZ>"+(material.getSizegroupCode()==null?"":material.getSizegroupCode())+"</ZCMZ>\n" +//尺码组
                "               <!--Optional:-->\n" +
                "               <ZCBJ></ZCBJ>\n" +//成本价---面辅料属性
                "               <!--Optional:-->\n" +
                "               <ZGG></ZGG>\n" +//规格
                "               <!--Optional:-->\n" +
                "               <ZGG_MS>"+(material.getSpec()==null?"":material.getSpec())+"</ZGG_MS>\n" +//规格描述
                "               <!--Optional:-->\n" +
                "               <ZSCBJ>"+material.getDeleted()+"</ZSCBJ>\n" +//删除标记
                "               <!--Optional:-->\n" +
                "               <ZBC>"+(material.getEdition()==null?"":material.getEdition())+"</ZBC>\n" +//版次
                "               <!--Optional:-->\n" +
                "               <ZBCLX>"+(material.getEditionType()==null?"":material.getEditionType())+ "</ZBCLX>\n" +//版次类型
                "               <!--Optional:-->\n" +
                "               <ZSSSJ>"+(material.getInsaleDate()==null?"":material.getInsaleDate())+"</ZSSSJ>\n" +//上市时间
                "               <!--Optional:-->\n" +
                "               <ZCMM></ZCMM>\n" +//尺码唛
                "               <!--Optional:-->\n" +
                "               <ZTKYKH></ZTKYKH>\n" +//套款原款号
                "               <!--Optional:-->\n" +
                "               <ZCPMC></ZCPMC>\n" +//产品名称
                "               <!--Optional:-->\n" +
                "               <ZYYCM></ZYYCM>\n" +//样衣尺码
                "               <!--Optional:-->\n" +
                "               <ZSKUS>"+(material.getSkuCount()==null?"":material.getSkuCount())+"</ZSKUS>\n" +//SKU数
                "               <!--Optional:-->\n" +
                "               <ZCGZ></ZCGZ>\n" +//采购组
                "               <!--Optional:-->\n" +
                "               <ZSJSMC></ZSJSMC>\n" +//设计师名称
                "               <!--Optional:-->\n" +
                "               <ZKX1></ZKX1>\n" +//廓形
                "               <!--Optional:-->\n" +
                "               <ZXC></ZXC>\n" +//袖长
                "               <!--Optional:-->\n" +
                "               <ZDBLX>"+(material.getDbType()==null?"":material.getDbType())+"</ZDBLX>\n" +//打版类型
                "               <!--Optional:-->\n" +
                "               <ZCKBY>"+(material.getRefSampleCode()==null?"":material.getRefSampleCode())+"</ZCKBY>\n" +//参考版衣
                "               <!--Optional:-->\n" +
                "               <ZTKYKH1></ZTKYKH1>\n" +//参考版衣
                "               <!--Optional:-->\n" +
                "               <ZSQLSH>"+(material.getApplyNo()==null?"":material.getApplyNo())+"</ZSQLSH>\n" +//申请流水号
                "               <!--Optional:-->\n" +
                "               <ZSFTGYY></ZSFTGYY>\n" +//是否提供样衣
                "               <!--Optional:-->\n" +
                "               <ZTGJG></ZTGJG>\n" +//预估价格
                "               <!--Optional:-->\n" +
                "               <ZJGFS></ZJGFS>\n" +//加工方式
                "               <!--Optional:-->\n" +
                "               <ZCMSM></ZCMSM>\n" +//尺码说明
                "               <!--Optional:-->\n" +
                "               <ZCPBM></ZCPBM>\n" +//产品编码
                "               <!--Optional:-->\n" +
                "               <ZCGR></ZCGR>\n" +//采购人
                "               <!--Optional:-->\n" +
                "               <ZCGJE></ZCGJE>\n" +//采购金额
                "               <!--Optional:-->\n" +
                "               <ZYGCB>"+(material.getEstimatePrice()==null?"":material.getEstimatePrice())+"</ZYGCB>\n" +//预估成本
                "               <!--Optional:-->\n" +
                "               <ZCZ>"+material.getMaterialCz()+"</ZCZ>\n" +//材质
                "               <!--Optional:-->\n" +
                "               <ZZZGY>"+material.getMakeIe()+"</ZZZGY>\n" +//制作工艺
                "               <!--Optional:-->\n" +
                "               <ZAQKC></ZAQKC>\n" +//安全库存
                "               <!--Optional:-->\n" +
                "               <ZBZJ></ZBZJ>\n" +//标准价
                "               <!--Optional:-->\n" +
                "               <ZCGTQQ></ZCGTQQ>\n" +//采购提前期
                "               <!--Optional:-->\n" +
                "               <ZDJLX></ZDJLX>\n" +//单据类型
                "               <!--Optional:-->\n" +
                "               <ZYS1></ZYS1>\n" +//颜色
                "               <!--Optional:-->\n" +
                "               <ZYS1_MS>"+(material.getColor()==null?"":material.getColor())+"</ZYS1_MS>\n" +//颜色描述
                "               <!--Optional:-->\n" +
                "               <ZBYYS></ZBYYS>\n" +//版衣颜色
                "               <!--Optional:-->\n" +
                "               <ZRES1></ZRES1>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES2></ZRES2>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES3></ZRES3>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES4></ZRES4>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES5></ZRES5>\n" +
                "            </BU_ITEM>\n";


        return materialSapStr;
    }


    //删除
    public void deletedMaterial(List<Material> materialList){
        if(materialList.size()>0){
            for(int i = 0;i<materialList.size();i++){
                Material material = materialList.get(i);
                Material dMaterial = materialMapper.getMaterialByPK(material.getId());
                dMaterial.setDeleted(1);
                super.setCreateFields(dMaterial);
                materialMapper.deletedMaterial(dMaterial);

                List<MaterialInfo> materialInfoList= materialInfoService.getMaterialInfoListBySupplierId(material.getId());
                if(materialInfoList.size()>0){
                    for(int j = 0;j<materialInfoList.size();j++){
                        materialInfoService.deletedBatchMaterialInfo(materialInfoList);
                    }
                }

            }
        }
    }

    @Transactional
    public Integer insertMaterial1(Material material){
        String code = this.getCreateMaterialNum(material.getBrandType(),material.getCategoryC());
        material.setCode(code);
        super.setCreateFields(material);
        Integer id = materialMapper.insertMaterial(material);
        return id;
    }

    @Transactional
    public int updateMaterialByPKSelective(Material material) {
        int result = materialMapper.updateMaterialByPKSelective(material);
        return result;
    }

    public PagingRestResponse searchMaterial(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {



        int totalRecordNum = materialMapper.searchMaterialCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<Material> resultList = null;
        if(totalRecordNum>0){
            resultList = materialMapper.searchMaterial(selectFields, condList, orderByList, pageBean);
        }


        for(int i = 0;i<resultList.size();i++){
            Material material = resultList.get(i);

            material.setCheckPictureList(attachmentService.getPicTureByMatId(material.getId()));


            String unit = material.getUnit();
            if(StringUtils.isNotEmpty(unit)){
                material.setUnit(super.getDicSvalue("UNIT",unit));
            }

            String brankType = material.getBrandType();
            if(StringUtils.isNotEmpty(brankType)){
                material.setBrandType(super.getDicSvalue("GC_brand",brankType));
            }

            String matType = material.getMatType();
            if(StringUtils.isNotEmpty(matType)){
                material.setMatType(super.getDicSvalue("GC_matType",matType));
            }

            String status = material.getStatus();
            if(StringUtils.isNotEmpty(status)){
                material.setStatus(super.getDicSvalue("GC_matStatus",status));
            }

            String caA = material.getCategoryA();
            if(StringUtils.isNotEmpty(status)){
                material.setCategoryA(super.getDicSvalue("GC_CategoryA",caA));
            }

            String caB = material.getCategoryB();
            if(StringUtils.isNotEmpty(caB)){
                material.setCategoryB(super.getDicSvalue("GC_CategoryB",caB));
            }

            String caC = material.getCategoryC();
            if(StringUtils.isNotEmpty(caC)){
                material.setCategoryC(super.getDicSvalue("GC_CategoryC",caC));
            }

            Map<String,String> mapUser = super.getAllSysUserInfo();
            String createBy = material.getCreatedBy();
            if(StringUtils.isNotEmpty(createBy)){

                material.setCreatedBy(mapUser.get(createBy));
            }

            String lastUpdateBy = material.getLastUpdatedBy();
            if(StringUtils.isNotEmpty(lastUpdateBy)){
                material.setLastUpdatedBy(mapUser.get(lastUpdateBy));
            }

        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public HashMap<String, Object> importExcel(String filePath, String fileName, InputStream inputStream,
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

    public  HashMap<String, Object> changeData(String  filePath, Sheet sheet,
                                               HashMap<String, Object> result) {
        String loginId=adminUserInfoService.getCurrentLoginUserName();
        Map<String, String> matType = super.getMapBygetSkeyByValue("GC_matType");
        Map<String, String> brandType = super.getMapBygetSkeyByValue("GC_brand");
        Map<String, String> buyGroup = super.getMapBygetSkeyByValue("GC_buyGroup");
        Map<String, String> matStatus = super.getMapBygetSkeyByValue("GC_matStatus");
        Map<String, String> categoryA = super.getMapBygetSkeyByValue("GC_CategoryA");
        Map<String, String> categoryB = super.getMapBygetSkeyByValue("GC_CategoryB");
        Map<String, String> categoryC = super.getMapBygetSkeyByValue("GC_CategoryC");
        Map<String, String> oldCodeMat = super.getMapBygetSkeyByValue("GC_oldCodeMat");
        Map<String, String> unit = super.getMapBygetSkeyByValue("UNIT");
        Map<String, String> shopImage = super.getMapBygetSkeyByValue("GC_shopImage");
        Map<String, String> useArea = super.getMapBygetSkeyByValue("useArea");//使用区域

        ExcelReadKit excelReadKit = new ExcelReadKit();
        ExcelReadResultBean readResultBean = excelReadKit.readExcel(filePath, 0);
        List<List<String>> list = readResultBean.getContentList();
        Map<String,String> keyMap = new HashMap<String,String>();

        List<Material> materialCodeList = new ArrayList<Material>();
        List<Material> materialNoCodeList = new ArrayList<Material>();
        Material material;
        String item;
        boolean isSuccess= true;
        Integer rowNum =list.size();
        for1:for(int i=1, size=list.size(); i<size; i++) {
            StringBuffer key = new StringBuffer();
            List<String> rowData = list.get(i);
            if (rowData.size() < 21) {
                UploadUtil.resultError(result, i, "请上传正确认模版！！");
                break for1;
            }
            material = new Material();
            for(int j=0, columnSize=rowData.size(); j<columnSize; j++ ) {
                item = rowData.get(j);
                try {
                    switch(j){
                        case 0://物料编码
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    List<Material> materialList1 = this.getMaterialByCode(item);
                                    if(materialList1.size()>0){
                                        material.setCode(item);
                                        key.append(item);
                                    }else{
                                        UploadUtil.resultError(result, i,j, "物料编码【"+item+"】不存在！");
                                        isSuccess = false;
                                        break for1;
                                    }

                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 1://物料名称
                            if(!StringUtils.isEmpty(item)){
                                material.setName(item);
                                key.append(item);
                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 2:  //物料类型
                            if (!StringUtils.isEmpty(item)) {
                                if(matType.containsKey(item)){
                                    material.setMatType(matType.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "物料类型【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            } else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 3://采购组
                            if(!StringUtils.isEmpty(item)){
                                if(buyGroup.containsKey(item)){
                                    material.setBuyGroup(buyGroup.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "采购组【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 4://品牌
                            if(!StringUtils.isEmpty(item)){
                                if(brandType.containsKey(item)){
                                    material.setBrandType(brandType.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "品牌【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;


                        case 5://形象名称
                            if(!StringUtils.isEmpty(item)){
                                material.setShopImageName(item);
                                key.append(item);

                                String imageCode = "";
                                if (item.indexOf(",")!=-1){
                                    String[] strArr = item.split(",");
                                    for (int k = 0; k < strArr.length; ++k) {
                                        if(k==strArr.length-1){
                                            if(shopImage.containsKey(strArr[k])) {
                                                if (imageCode.contains(shopImage.get(strArr[k]))) {
                                                    UploadUtil.resultError(result, i,j, "形象【"+item+"】有重复！");
                                                    isSuccess = false;
                                                    break for1;
                                                }
                                                imageCode += shopImage.get(strArr[k]);

                                            }else{
                                                UploadUtil.resultError(result, i,j, "形象【"+strArr[k]+"】不存在！");
                                                isSuccess = false;
                                                break for1;
                                            }
                                        }else{
                                            if(shopImage.containsKey(strArr[k])){
                                                if (imageCode.contains(shopImage.get(strArr[k]))) {
                                                    UploadUtil.resultError(result, i,j, "形象【"+item+"】有重复！");
                                                    isSuccess = false;
                                                    break for1;
                                                }
                                                    imageCode += shopImage.get(strArr[k]) + ",";
                                               // }
                                            }else{
                                                UploadUtil.resultError(result, i,j, "形象【"+strArr[k]+"】不存在！");
                                                isSuccess = false;
                                                break for1;
                                            }
                                        }
                                    }
                                }else{
                                        if(!item.equals("/")&&!item.equals("\\")){
                                            if(shopImage.containsKey(item)){
                                                imageCode = shopImage.get(item);
                                            }else{
                                                UploadUtil.resultError(result, i,j, "形象【"+item+"】不存在！");
                                                isSuccess = false;
                                                break for1;
                                            }

                                        }
                                }
                                material.setShopImage(imageCode);


                            }
                            break;

                        case 6://状态
                            if(!StringUtils.isEmpty(item)){
                                if(matStatus.containsKey(item)){
                                    material.setStatus(matStatus.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "状态【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 7://大类
                            if(!StringUtils.isEmpty(item)){
                                if(categoryA.containsKey(item)){
                                    material.setCategoryA(categoryA.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "大类【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 8://中类
                            if(!StringUtils.isEmpty(item)){
                                if(categoryB.containsKey(item)){
                                    material.setCategoryB(categoryB.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "中类【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 9://小类
                            if(!StringUtils.isEmpty(item)){
                                if(categoryC.containsKey(item)){
                                    material.setCategoryC(categoryC.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "小类【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 10://规格
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    material.setSpec(item);
                                    key.append(item);
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 11://材质
                            if(!StringUtils.isEmpty(item)){
                                material.setMaterialCz(item);
                                key.append(item);
                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                        case 12://下单类别
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    if(oldCodeMat.containsKey(item)){
                                        material.setPoType(oldCodeMat.get(item));
                                        key.append(item);
                                    }else{
                                        UploadUtil.resultError(result, i,j, "下单类别【"+item+"】不存在！");
                                        isSuccess = false;
                                        break for1;
                                    }
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 13://制作工艺
                            if(!StringUtils.isEmpty(item)){
                                material.setMakeIe(item);
                                key.append(item);
                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 14://颜色
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    material.setColor(item);
                                    key.append(item);
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 15://单位
                            if(!StringUtils.isEmpty(item)){
                                if(unit.containsKey(item)){
                                    material.setUnit(unit.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "单位【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 16://备注
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    material.setRemarks(item);
                                    key.append(item);
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }

                            break;

                        case 17://旧物料编码
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    List<Material> materialList1 = this.getMaterialByCode(item);
                                    if(materialList1.size()>0){
                                        material.setOldCodeMat(item);
                                        key.append(item);
                                    }else{
                                        UploadUtil.resultError(result, i,j, "旧物料编码【"+item+"】不存在！");
                                        isSuccess = false;
                                        break for1;
                                    }

                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 18://使用区域
                            if(!StringUtils.isEmpty(item)){
                                if(useArea.containsKey(item)){
                                    material.setSyqy(useArea.get(item));
                                    key.append(item);
                                }else{
                                    UploadUtil.resultError(result, i,j, "使用区域【"+item+"】不存在！");
                                    isSuccess = false;
                                    break for1;
                                }

                            }else {
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 19://长
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    try{
                                        material.setChang(Double.valueOf(item));
                                    }catch (Exception e){
                                        UploadUtil.resultError(result, i,j, "长【"+item+"】请输入数字！");
                                        isSuccess = false;
                                        break for1;
                                    }

                                }

                            }else{
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 20://宽
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    try{
                                        material.setKuan(Double.valueOf(item));
                                    }catch (Exception e){
                                        UploadUtil.resultError(result, i,j, "宽【"+item+"】请输入数字！");
                                        isSuccess = false;
                                        break for1;
                                    }
                                }
                            }else{
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;
                        case 21://高
                            if(!StringUtils.isEmpty(item)){
                                if(!item.equals("/")&&!item.equals("\\")){
                                    try{
                                        material.setGao(Double.valueOf(item));
                                    }catch (Exception e){
                                        UploadUtil.resultError(result, i,j, "高【"+item+"】请输入数字！");
                                        isSuccess = false;
                                        break for1;
                                    }
                                }
                            }else{
                                UploadUtil.resultErrorNotBlank(result, i, j);
                                isSuccess = false;
                                break for1;
                            }
                            break;

                    }



                } catch (Exception e) {
                    UploadUtil.resultError(result, i,j);
                    isSuccess=false;
                    break for1;
                }
            }


            if(keyMap.get(key.toString())!=null) {
                result.put("success", false);
                result.put("message", "第"+(i+1)+"行数据重复，请检查！");
                isSuccess=false;
                break for1;
            }
            keyMap.put(key.toString(), key.toString());

            material.setDeleted(0);
            String code = material.getCode();
            if(!StringUtils.isEmpty(code)){
                    material.setCreatedBy(loginId);
                    material.setCreatedTime(new Date());
                    material.setLastUpdatedBy(loginId);
                    material.setLastUpdatedTime(new Date());
                    materialCodeList.add(material);
            }else{
                material.setLastUpdatedBy(loginId);
                material.setLastUpdatedTime(new Date());
                materialNoCodeList.add(material);
            }

        }
        Integer updateCode = materialCodeList.size();
        Integer insertCode = materialNoCodeList.size();


        //保存的条数是不是跟Excel的条数相等
        if(updateCode+insertCode==rowNum-1){

            if(isSuccess&&insertCode>0){
                    for(int a = 0;a<materialNoCodeList.size();a++){
                            Material materiala = materialNoCodeList.get(a);
                            this.insertMaterial1(materiala);

                    }
            }
            if(isSuccess&&updateCode>0){
                this.updateBatchMaterialList(materialCodeList);
            }


            if(updateCode>0 && insertCode>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！包含:新增【"+insertCode+"】条,更新【"+updateCode+"】条。");
            }else if(insertCode==0 && updateCode>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！更新【"+updateCode+"】条。");
            }else if(updateCode==0 && insertCode>0) {
                result.put("success", true);
                result.put("message", "数据导入成功！新增【"+insertCode+"】条。");
            }
        }/*else{
            result.put("success", false);
            result.put("message","导入失败");
        }*/

        return result;
    }

    /**
     * 批量更新物料（导入）
     * @param updateList
     * @return
     */
    @Transactional
    public  int updateBatchMaterialList(List<Material> updateList){
        return materialMapper.updateBatchMaterialList(updateList);
    }

    public String getDictionarySvalue(String sgroup, String skey) {
        Map<String, String> map = dictionaryService.getMapBySgroup(sgroup);
        return map.get(skey);
    }

}