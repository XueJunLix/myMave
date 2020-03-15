package com.ur.mro.oa.service;

import com.ur.admin.service.AdminUserInfoService;
import com.ur.admin.user.service.SysUserInfoService;
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
import com.ur.mro.mat.service.MaterialInfoService;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class OAMaterialService extends BaseService{
    @Autowired
    MaterialMapper materialMapper;

    public JSONArray getMaterialByCode(String code,String lastModifiedBy) {
        List<Material> materialList = materialMapper.searchMaterialBylastUpdateTimeAndCode(code,lastModifiedBy);
        JSONArray jSONArray = new JSONArray();
        for(int i=0;i<materialList.size();i++){
            JSONObject object  = new JSONObject();
            Material material = materialList.get(i);
            //单位
            String unit = material.getUnit();
            if (unit != null) {
                object.put("danw",unit);
            }else{
                object.put("danw","");
            }
            //状态
            String status = material.getStatus();
            if (status != null) {
                object.put("zt",status);
            }else{
                object.put("zt","");
            }
            //物资名称
            String name = material.getName();
            if (name != null) {
                object.put("wzmc",name);
            }else{
                object.put("wzmc","");
            }
            //类别
            String poType = material.getPoType();
            if (poType != null) {
                object.put("lb", poType);
            }else{
                object.put("lb","");
            }
            //规格型号
            String spec = material.getSpec();
            if (spec != null) {
                object.put("ggxh",spec);
            }else{
                object.put("ggxh","");
            }
            //单价
            String price = material.getPrice();
            if (price != null) {
                object.put("sj",price);
            }else{
                object.put("sj","");
            }
            //物料编码
            String codeNum = material.getCode();
            if (codeNum != null) {
                object.put("wlbm",codeNum);
            }else{
                object.put("wlbm","");
            }
            //形象
            String shopImage = material.getShopImage();
            if (shopImage != null) {
                object.put("dpxx",shopImage);
            }else{
                object.put("dpxx","");
            }
            //材质
            String materialCz = material.getMaterialCz();
            if (materialCz != null) {
                object.put("cz",materialCz);
            }else{
                object.put("cz","");
            }
            //大类
             String A = material.getCategoryA();
            if (A != null) {
                object.put("dl",A);
            }else{
                object.put("dl","");
            }
            //中类
            String B = material.getCategoryB();
            if (B!= null) {
                object.put("zl",B);
            }else{
                object.put("zl","");
            }
            //小类
            String C = material.getCategoryC();
            if (C != null) {
                object.put("xl",C);
            }else{
                object.put("xl","");
            }
            //物料类型
            String matType = material.getMatType();
            if (matType != null) {
                object.put("wllx",matType);
            }else{
                object.put("wllx","");
            }
            //制作工艺
            String makeIe = material.getMakeIe();
            if (makeIe != null) {
                object.put("zzgy",makeIe);
            }else{
                object.put("zzgy","");
            }
            //安全库存
             Double safeInv= material.getSafeInv();
            if (safeInv != null) {
                object.put("aqkc",String.valueOf(safeInv));
            }else{
                object.put("aqkc","");
            }
            //图片名称
            String pictureName = material.getModuleNo();
            if ( pictureName != null) {
                String str = pictureName;
                object.put("tpmc",str.substring(0, str.length() - 1));
            }else{
                object.put("tpmc","");
            }

            jSONArray.add(object);
        }
        return jSONArray;
    }
}