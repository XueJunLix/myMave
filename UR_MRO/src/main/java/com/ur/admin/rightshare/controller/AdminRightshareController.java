package com.ur.admin.rightshare.controller;

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

import com.ur.admin.button.model.AdminButtonInfo;
import com.ur.admin.rightshare.model.AdminRightshare;
import com.ur.admin.rightshare.service.AdminRightshareService;
import com.ur.common.util.Util;
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
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/right")
@Api(description = "AdminRightshareController的注释")
public class AdminRightshareController {
    private static final Logger logger = LoggerFactory.getLogger(AdminRightshareController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AdminRightshareService adminRightshareService;

    @RequestMapping(value = "/AdminRightshare/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除插入AdminRightshare对象", notes = "删除AdminRightshare对象")
    public CommonRestResponse deleteAdminRightshare(@RequestBody String rightInfo) {
    	logger.debug("删除授权信息....." + rightInfo);
        try {
			JSONObject o = JSONObject.fromObject(rightInfo);
			AdminRightshare adminRightshare = new AdminRightshare();

			adminRightshare.setRightType(Util.null2String(o.get("rightType")));
			adminRightshare.setRightSourceId(Integer.valueOf(Util.null2String(o.get("rightSourceId"))));
			adminRightshare.setResourceType(Util.null2String(o.get("resourceType")));
			adminRightshare.setResourceId(Integer.valueOf(Util.null2String(o.get("resourceId"))));
        	
        	adminRightshareService.deleteAdminRightshareByPKSelective(adminRightshare);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminRightshare);
        } catch (Exception e) {
        	logger.debug("删除授权信息异常.....");
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    @RequestMapping(value = "/getOperateBtnByCurrUser", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据当前用户对象获取操作按钮getOperateBtnByCurrUser", notes = "根据当前用户对象获取操作按钮getOperateBtnByCurrUser")
    public CommonRestResponse getOperateBtnByCurrUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
    	logger.debug("根据当前用户对象获取操作按钮getOperateBtnByCurrUser.");
        try {
        	List<AdminButtonInfo> buttons = adminRightshareService.getOperateBtnByCurrUser("L", 1);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,buttons);
        } catch (Exception e) {
        	logger.debug("根据当前用户对象获取操作按钮getOperateBtnByCurrUser.");
            e.printStackTrace();
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value="AdminRightshare",method = RequestMethod.GET)
    @ApiOperation(value = "AdminRightshare默认页面模板", notes = "AdminRightshare默认页面模板")
    public String AdminRightshareTemplate() {
        return "AdminRightshare";
    }

    @RequestMapping(value = "AdminRightshare/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取AdminRightshare", notes = "根据pkId获取AdminRightshare",response = AdminRightshare.class)
    public CommonRestResponse getAdminRightshareByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            AdminRightshare adminRightshare = adminRightshareService.getAdminRightshareByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,adminRightshare);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

	/*
	 * @RequestMapping(value = "AdminRightshare/insert", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation(value = "插入AdminRightshare对象", notes = "插入AdminRightshare对象")
	 * public CommonRestResponse insertAdminRightshare(HttpServletRequest
	 * httpRequest, @RequestBody AdminRightshare adminRightshare) { try { //TODO
	 * authentication to be done
	 * 
	 * adminRightshareService.insertAdminRightshare(adminRightshare);
	 * 
	 * return new
	 * CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.
	 * SUCCESS_MESSAGE,null); } catch (Exception e) { e.printStackTrace(); //TODO
	 * handle exception message here return new
	 * CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null); } }
	 * 
	 * @RequestMapping(value = "AdminRightshare/update", method = RequestMethod.PUT)
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation(value = "根据pkId更新AdminRightshare", notes =
	 * "根据pkId更新AdminRightshare") public CommonRestResponse
	 * updateAdminRightshareByPKSelective(HttpServletRequest
	 * httpRequest, @RequestBody AdminRightshare adminRightshare) { try { //TODO
	 * authentication to be done
	 * 
	 * adminRightshareService.updateAdminRightshareByPKSelective(adminRightshare);
	 * 
	 * return new
	 * CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.
	 * SUCCESS_MESSAGE,null); } catch (Exception e) { e.printStackTrace(); //TODO
	 * handle exception message here return new
	 * CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null); } }
	 */

    @RequestMapping(value = "AdminRightshare/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminRightshare通用查询方法", notes = "AdminRightshare通用查询方法",response = AdminRightshare.class, responseContainer="List")
    public CommonRestResponse searchAdminRightshare(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminRightshare.class);
            PagingRestResponse response = adminRightshareService.searchAdminRightshare(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "AdminRightshare/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "AdminRightshare导出接口，返回待下载的Excel文件名", notes = "AdminRightshare导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAdminRightshare(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(AdminRightshare.class);
            PagingRestResponse response = adminRightshareService.searchAdminRightshare(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<AdminRightshare> resultList = (List<AdminRightshare>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("rightType");
                headerList.add("rightSoutceId");
                headerList.add("resourceType");
                headerList.add("resourceId");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(AdminRightshare row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getRightType());
                    rowList.add(row.getRightSourceId());
                    rowList.add(row.getResourceType());
                    rowList.add(row.getResourceId());
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

    @RequestMapping(value="AdminRightshareList",method = RequestMethod.GET)
    @ApiOperation(value = "AdminRightshareList默认页面模板", notes = "AdminRightshareList默认页面模板")
    public String AdminRightshareList() {
        return "AdminRightshareList";
    }

    @RequestMapping(value = "AdminRightshareEdit", method = RequestMethod.GET)
    @ApiOperation(value = "AdminRightshareEdit默认页面模板", notes = "AdminRightshareEdit默认页面模板")
    public String AdminRightshareEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        AdminRightshare adminRightshare = new AdminRightshare();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            adminRightshare = adminRightshareService.getAdminRightshareByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("adminRightshare",adminRightshare);
        model.addAttribute("isUpdate",isUpdate);
        return "AdminRightshareEdit";
    }
}