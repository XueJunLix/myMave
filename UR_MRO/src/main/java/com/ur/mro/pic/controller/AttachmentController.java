package com.ur.mro.pic.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.ur.fw.common.excel.ExcelConfig;
import com.ur.fw.common.excel.ExcelWriteBean;
import com.ur.fw.common.excel.ExcelWriteKit;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.fw.common.util.UuidKit;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "pic")
@Api(description = "AttachmentController的注释")
public class AttachmentController {
    private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;

    @Value("${app.seperator}")
    private String seperator;

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value="Attachment",method = RequestMethod.GET)
    @ApiOperation(value = "Attachment默认页面模板", notes = "Attachment默认页面模板")
    public String AttachmentTemplate() {
        return "Attachment";
    }

    @RequestMapping(value = "Attachment/{pkId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据pkId获取Attachment", notes = "根据pkId获取Attachment",response = Attachment.class)
    public CommonRestResponse getAttachmentByPK(HttpServletRequest httpRequest, @PathVariable Integer pkId) {
        try {
            //TODO authentication to be done
            
            Attachment attachment = attachmentService.getAttachmentByPK(pkId);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,attachment);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Attachment/insert", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "插入Attachment对象", notes = "插入Attachment对象")
    public CommonRestResponse insertAttachment(HttpServletRequest httpRequest, @RequestBody Attachment attachment) {
        try {
            //TODO authentication to be done
            
            attachmentService.insertAttachment(attachment);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "根据pkId更新Attachment", notes = "根据pkId更新Attachment")
    public CommonRestResponse updateAttachmentByPKSelective(HttpServletRequest httpRequest, @RequestBody Attachment attachment) {
        try {
            //TODO authentication to be done
            
            attachmentService.updateAttachmentByPKSelective(attachment);
            
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,null);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Attachment/search", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Attachment通用查询方法", notes = "Attachment通用查询方法",response = Attachment.class, responseContainer="List")
    public CommonRestResponse searchAttachment(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            PageBean pageBean = null;
            if(request.getCurrPage()!=null&&request.getPageSize()!=null){
                pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
            }
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Attachment.class);
            PagingRestResponse response = attachmentService.searchAttachment(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            //TODO handle exception message here
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "Attachment/export", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Attachment导出接口，返回待下载的Excel文件名", notes = "Attachment导出接口,返回待下载的Excel文件名")
    public CommonRestResponse exportAttachment(HttpServletRequest httpRequest, @RequestBody CommonSearchRequest request) {
        try {
            //TODO authentication to be done
            
            //export currPage=1 pageSize=10000
            PageBean pageBean = new PageBean(1,10000);
            
            //remove injection code
            request.removeInjectionCode();
            
            //transform JavaBean ColumnName to DB ColumnName
            request.transformColumnNames(Attachment.class);
            PagingRestResponse response = attachmentService.searchAttachment(request.getSelectFields(),request.getCondList(),request.getOrderByList(),pageBean);
            List<Attachment> resultList = (List<Attachment>)response.getData();
            
            if(resultList!=null){
                List<String> headerList = new ArrayList<String>();
                headerList.add("id");
                headerList.add("groupId");
                headerList.add("name");
                headerList.add("size");
                headerList.add("createdBy");
                headerList.add("createdTime");
                headerList.add("lastUpdatedBy");
                headerList.add("lastUpdatedTime");
                headerList.add("abbfileName");
                headerList.add("fileName");
                headerList.add("fileType");
                headerList.add("rowId");
                headerList.add("comments");
                headerList.add("com1");
                headerList.add("com2");
                headerList.add("classname");
                headerList.add("deleted");
                headerList.add("image");
                headerList.add("asycImage");
                
                List<List<Object>> contentList = new ArrayList<List<Object>>();
                List<Object> rowList = null;
                for(Attachment row:resultList){
                    rowList = new ArrayList<Object>();
                    rowList.add(row.getId());
                    rowList.add(row.getGroupId());
                    rowList.add(row.getName());
                    rowList.add(row.getSize());
                    rowList.add(row.getCreatedBy());
                    rowList.add(row.getCreatedTime());
                    rowList.add(row.getLastUpdatedBy());
                    rowList.add(row.getLastUpdatedTime());
                    rowList.add(row.getAbbFileName());
                    rowList.add(row.getFilaName());
                    rowList.add(row.getFileType());
                    rowList.add(row.getRowId());
                    rowList.add(row.getComments());
                    rowList.add(row.getCom1());
                    rowList.add(row.getCom2());
                    rowList.add(row.getClassname());
                    rowList.add(row.getDeleted());
                    rowList.add(row.getImage());
                    rowList.add(row.getAsycImage());
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

    @RequestMapping(value="AttachmentList",method = RequestMethod.GET)
    @ApiOperation(value = "AttachmentList默认页面模板", notes = "AttachmentList默认页面模板")
    public String AttachmentList() {
        return "AttachmentList";
    }

    @RequestMapping(value = "AttachmentEdit", method = RequestMethod.GET)
    @ApiOperation(value = "AttachmentEdit默认页面模板", notes = "AttachmentEdit默认页面模板")
    public String AttachmentEdit(Model model, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        String id = httpRequest.getParameter("id");
        Attachment attachment = new Attachment();
        boolean isUpdate = false;
        if(id!=null && !id.equals("")){
            attachment = attachmentService.getAttachmentByPK(Integer.valueOf(id));
            isUpdate = true;
        }
        model.addAttribute("attachment",attachment);
        model.addAttribute("isUpdate",isUpdate);
        return "AttachmentEdit";
    }
    @RequestMapping(value="filesUpload",method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", notes = "文件上传")
    @ResponseBody
    public List<Attachment> uploadFiles(MultipartFile uploadFile, HttpServletRequest req){

        return null;

    }




}