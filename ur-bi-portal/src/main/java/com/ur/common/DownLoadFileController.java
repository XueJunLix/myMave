package com.ur.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.ur.fw.common.web.HttpResponseKit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "")
@Api(description = "从临时文件夹下载指定文件的Controller")
public class DownLoadFileController {
	private static final Logger logger = LoggerFactory.getLogger(DownLoadFileController.class);

    @Value("${app.tempFilePath}")
    private String tempFilePath;
    
    @ResponseBody
    @ApiOperation(value = "根据fileName下载指定文件", notes = "根据fileName下载指定文件")
	@RequestMapping(value = "DownloadFile/{fileName}/{extName}", method = RequestMethod.GET)    
    public void downloadFile(HttpServletRequest httpRequest,HttpServletResponse httpResponse,@PathVariable String fileName,@PathVariable String extName) {
    	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
        try {
        	//TODO authentication to be done

			InputStream is = new FileInputStream(tempFilePath+fileName+"."+extName);

			httpResponse.reset();
			
			String contentType = "application/octet-stream;charset=UTF-8";
			if(extName!=null&&extName.toLowerCase().equals("xlsx")) {
				contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8";
			}
			
			httpResponse.setContentType(contentType);
			HttpResponseKit.setAttachmentFile(httpRequest, httpResponse, fileName+"."+extName);

			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(httpResponse.getOutputStream());			

			byte[] buff = new byte[2048];
			int bytesRead;

			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (Exception e) {
				logger.error("输出Excel出错:{}", e);
			}
		}
    }  	
    
    @ResponseBody
    @ApiOperation(value = "根据fileName下载指定文件", notes = "根据fileName下载指定文件")
	@RequestMapping(value = "DownloadFile", method = RequestMethod.GET)    
    public void downloadFileReName(HttpServletRequest httpRequest,HttpServletResponse httpResponse
    		, @RequestParam("fileName")String fileName
    		, @RequestParam("extName")String extName
    		, @RequestParam("newFileName")String newFileName) {
    	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
        try {
    		if(!StringUtils.isEmpty(fileName) && !StringUtils.isEmpty(extName)) {
    			if(StringUtils.isEmpty(newFileName)) {
    				newFileName=fileName;
    			}
    			//TODO authentication to be done

    			InputStream is = new FileInputStream(tempFilePath+fileName+"."+extName);

    			httpResponse.reset();
    			
    			String contentType = "application/octet-stream;charset=UTF-8";
    			if(extName!=null&&extName.toLowerCase().equals("xlsx")) {
    				contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8";
    			}
    			
    			httpResponse.setContentType(contentType);
    			HttpResponseKit.setAttachmentFile(httpRequest, httpResponse, newFileName+"."+extName);

    			bis = new BufferedInputStream(is);
    			bos = new BufferedOutputStream(httpResponse.getOutputStream());			

    			byte[] buff = new byte[2048];
    			int bytesRead;

    			// Simple read/write loop.
    			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
    				bos.write(buff, 0, bytesRead);
    			}  
    		}  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (Exception e) {
				logger.error("输出Excel出错:{}", e);
			}
		}
    }  	
	
}
