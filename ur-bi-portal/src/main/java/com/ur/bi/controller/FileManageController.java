package com.ur.bi.controller;

import com.google.common.base.Throwables;
import com.ur.bi.model.FileInfo;
import com.ur.bi.service.FileInfoService;
import com.ur.bi.service.HdfsFileSystemService;
import com.ur.common.service.UserInfoService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.CommonSearchRequest;
import com.ur.fw.common.rest.PagingRestResponse;
import io.swagger.annotations.Api;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/file-manage")
@Api(description = "Controller的注释")
public class FileManageController {

    @Value("${app.hdfs.uri}")
    private String hdfsUri;

    @Value("${app.hdfs.base-path}")
    private String basePath;

    private final UserInfoService userInfoService;

    private final FileInfoService fileInfoService;

    private final HdfsFileSystemService hdfsFileSystemService;

    @Autowired
    public FileManageController(UserInfoService userInfoService, FileInfoService fileInfoService, HdfsFileSystemService hdfsFileSystemService) {
        this.userInfoService = userInfoService;
        this.fileInfoService = fileInfoService;
        this.hdfsFileSystemService = hdfsFileSystemService;
    }

    @GetMapping("/files")
    public String download(){
        return "/file-manage/files";
    }

    @PostMapping("/listFiles")
    @ResponseBody
    public CommonRestResponse ListFile(@RequestBody CommonSearchRequest request){

        PageBean pageBean = null;
        if(request.getCurrPage() != null && request.getPageSize() != null){
            pageBean = new PageBean(request.getCurrPage(),request.getPageSize());
        }

        //remove injection code
        request.removeInjectionCode();

        CommonSearchCondition csc = new CommonSearchCondition();
        csc.setOperator("eq");
        csc.setColumnName("createBy");
        csc.setValue(userInfoService.getCurrentLoginUserName());
        request.getCondList().add(csc);

        //transform JavaBean ColumnName to DB ColumnName
        request.transformColumnNames(FileInfo.class);

        int count = fileInfoService.count(request.getCondList());
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), count);

        return new PagingRestResponse(
                CommonRestResponse.SUCCESS_FLAG,
                CommonRestResponse.SUCCESS_MESSAGE,
                fileInfoService.paging(request.getCondList(), pageBean), pageBean);
    }

    @GetMapping("/downloadFile/{fileId}")
    @ResponseBody
    public void DownloadFile(HttpServletResponse response, @PathVariable("fileId") String fileId) {

        if (Strings.isBlank(fileId)) {
            log.error("File Id is needed to handleDownload a file.");
//            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, "File Id is needed to handleDownload file.",null);
        }

        FileInfo fileInfo = fileInfoService.findById(fileId);

        if (fileInfo == null) {
            log.error("File is not found for file id : {}.", fileId);
//            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, "File is not found for file id.",null);
        }

        try {
            response.setContentType("application/octet-stream");
            response.setContentLength(fileInfo.getSize().intValue());
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileInfo.getOriginalFilename().getBytes(), "ISO-8859-1") + "\"");

            hdfsFileSystemService.copyFromHdfsToStream(new URI(hdfsUri), new Path(fileInfo.getPath()), response.getOutputStream());
        } catch (Exception e) {
            log.error("Failed to handleDownload file from HDFS, error : {}", Throwables.getStackTraceAsString(e));
        }
    }

    @RequestMapping(value = "/upload/{folder}/{date}", method = RequestMethod.POST)
    @ResponseBody
    /**
     * TODO 目前仅电商需要通过这种方式上传文件，待有更多的部门需要上传数据时，需要根据添加的部门增加目录。
     * 便于下游ETL流程区分哪个目录可以用于相应的作业流程。
     */
    public CommonRestResponse upload(@RequestParam("dataFiles") MultipartFile[] dataFiles, @PathVariable("folder") String folder, @PathVariable("date") String date) {
        try {
            if (dataFiles != null && dataFiles.length != 1) {
                log.error("Only 1 file is allowed.");
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, "Only 1 file is allowed.",null);
            }
            MultipartFile dataFile = dataFiles[0];

            String originalFilename = dataFile.getOriginalFilename();
            String fileName = UUID.randomUUID().toString().replaceAll("-","")
                    + originalFilename.substring(originalFilename.lastIndexOf("."));

            FileInfo fileInfo = new FileInfo();
            fileInfo.setFolder(folder);
            fileInfo.setDataDate(date);
            fileInfo.setPath(basePath + fileInfo.getFolder() + "/" + fileInfo.getDataDate() + "/" + fileName);
            fileInfo.setUri(hdfsUri + fileInfo.getPath());
            fileInfo.setOriginalFilename(originalFilename);
            fileInfo.setFilename(fileName);
            fileInfo.setSize(dataFile.getSize());
            fileInfo.setDeleted(false);
            fileInfo.setCreateBy(userInfoService.getCurrentLoginUserName());

            log.debug("Saving file : {}", fileInfo.toString());

            hdfsFileSystemService.saveStreamToHdfs(dataFile.getInputStream(), new URI(hdfsUri), new Path(fileInfo.getPath()));
            fileInfoService.insertFileInfo(fileInfo);
            return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG, CommonRestResponse.SUCCESS_MESSAGE, fileInfo);
        } catch (Exception e) {
            log.error("Failed to upload file, error : {}", Throwables.getStackTraceAsString(e));
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, e.getMessage(),null);
        }
    }

    @GetMapping("/delete/{fileId}")
    @ResponseBody
    public CommonRestResponse delete(@PathVariable("fileId") String fileId) {
        try {
            if (Strings.isBlank(fileId)) {
                log.error("File Id is needed to delete a file.");
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, "File Id is needed to delete file.",null);
            }

            FileInfo fileInfo = fileInfoService.findById(fileId);

            if (fileInfo == null) {
                log.error("File is not found for file id : {}.", fileId);
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, "File is not found for file id.",null);
            }

            try {
                fileInfo.setDeleted(true);
                fileInfo.setModifyBy(userInfoService.getCurrentLoginUserName());
                fileInfo.setModifyTime(LocalDateTime.now());
                fileInfoService.delete(fileInfo);
                boolean deleted = hdfsFileSystemService.deleteFromHdfs(new URI(hdfsUri), new Path(fileInfo.getPath()));
                return new CommonRestResponse(Boolean.TRUE == deleted ? CommonRestResponse.SUCCESS_FLAG : CommonRestResponse.FAILED_FLAG, null,null);
            } catch (Exception e) {
                log.error("Failed to delete file from HDFS, error : {}", Throwables.getStackTraceAsString(e));
                return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, e.getMessage(),null);
            }
        } catch (Exception e) {
            log.error("Failed to delete file, error : {}", Throwables.getStackTraceAsString(e));
            return new CommonRestResponse(CommonRestResponse.FAILED_FLAG, e.getMessage(),null);
        }
    }
}
