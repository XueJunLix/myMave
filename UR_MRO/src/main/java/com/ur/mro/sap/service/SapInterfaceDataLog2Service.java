package com.ur.mro.sap.service;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ur.srm.sap.domain.SapInterfaceDataLog;
//import com.ur.srm.sap.repository.SapInterfaceDataLogRepository;
//import com.ur.srm.sap.service.SapInterfaceDataLogService;

import com.ur.common.model.Mat2SAPConfig;
import com.ur.common.service.BaseService;
import com.ur.mro.sap.mappers.SapInterfaceDataLog2Mapper;
import com.ur.mro.sap.model.SapInterfaceDataLog2;

//import com.ur_middleware.sap.domain.SapInterfaceDataLog;
//import com.ur_middleware.sap.repository.SapInterfaceDataLogRepository;
//import com.ur_middleware.sap.service.SapInterfaceDataLogService;


/**
 * 		   @author
 *         version: 1.00
 *         Date: 20170921 14:04
 *         Last modify Date: 20160328 14:04
 *         CopyRight (c) spro Company 2006	All rights reserved
 *         说明: sap接口日志<br>
 *         变更:<br>
 */
@Service
public class SapInterfaceDataLog2Service extends BaseService {



    @Autowired
    private SapInterfaceDataLog2Mapper sapInterfaceDataLogRepository;

    @Autowired
    private Mat2SAPConfig mat2SAPConfig;

    public Integer saveSapInterfaceDataLog(SapInterfaceDataLog2 sapInterfaceDataLog) {
        sapInterfaceDataLog.setDeleted(0);
        sapInterfaceDataLog.setCreatedTime(new Date());
        super.setCreateFields(sapInterfaceDataLog);
        super.setUpdateFields(sapInterfaceDataLog);
        sapInterfaceDataLog.setCreatedBy(sapInterfaceDataLog.getLastUpdatedBy());

        sapInterfaceDataLogRepository.insertSapInterfaceDataLog2(sapInterfaceDataLog);
        return   sapInterfaceDataLog.getId();
    }

    public void del(Integer id) {
        SapInterfaceDataLog2 sapInterfaceDataLog2=sapInterfaceDataLogRepository.getSapInterfaceDataLog2ByPK(id);
        sapInterfaceDataLog2.setDeleted(1);
        super.setUpdateFields(sapInterfaceDataLog2);
        sapInterfaceDataLogRepository.updateSapInterfaceDataLog2ByPKSelective(sapInterfaceDataLog2);
    }

    public SapInterfaceDataLog2 findOne(Integer id) {
        return sapInterfaceDataLogRepository.getSapInterfaceDataLog2ByPK(id);
    }



    /**
     * 通用sap发送接口
     * @param url
     * @param content
     * @param demandCode
     * @param interfaceCode
     */

    public SapInterfaceDataLog2 sapsend(String url,String content,String demandCode,String interfaceCode,String sapusername,String sappassword,String dataId,String dataCode){
        SapInterfaceDataLog2 sapInterfaceDataLog = new SapInterfaceDataLog2();
       // String sapinterface=null;
       String sapinterface = mat2SAPConfig.getInterfaces();
        if(sapinterface == null || "close".equals(sapinterface)){
            return null;
        }
        if(sapusername==null || sapusername.equals("")){
           sapusername = mat2SAPConfig.getUsername();
        }
        if(sappassword==null || sappassword.equals("")){
           sappassword = mat2SAPConfig.getPassword();
        }
        
        //传之前记录
        sapInterfaceDataLog.setUrl(url);
        sapInterfaceDataLog.setContent(content);
        sapInterfaceDataLog.setUsername(sapusername);
        sapInterfaceDataLog.setPassword(sappassword);
        sapInterfaceDataLog.setHttpStatus("404");
        sapInterfaceDataLog.setInterfaceCode(interfaceCode);
        sapInterfaceDataLog.setDemandCode(demandCode);
      //  sapInterfaceDataLog.setDataId(dataId);
       // sapInterfaceDataLog.setSource("SLM");
       // sapInterfaceDataLog.setTarget("SAP");
       // sapInterfaceDataLog.setDataCode(dataCode);
        saveSapInterfaceDataLog(sapInterfaceDataLog);
        

        try{

            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(AuthScope.ANY,
                    new UsernamePasswordCredentials(sapusername, sappassword));
            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(credsProvider)
                    .build();

            HttpPost httppost = new HttpPost(url);
            httppost.setHeader("Content-Type", "application/soap+xml;charset=utf-8;action=\"generateLabel\"");

            StringEntity requestEntity = new StringEntity(content, "text/xml", "UTF-8");
            httppost.setEntity(requestEntity);

            HttpResponse response = client.execute(httppost);
            int httpCode = response.getStatusLine().getStatusCode();
            System.out.println("httpCode="+httpCode);

            /*sapInterfaceDataLog.setUrl(url);
            sapInterfaceDataLog.setContent(content);
            sapInterfaceDataLog.setUsername(sapusername);
            sapInterfaceDataLog.setPassword(sappassword);*/
             sapInterfaceDataLog.setHttpStatus(httpCode + "");
            /*sapInterfaceDataLog.setInterfaceCode(interfaceCode);
            sapInterfaceDataLog.setDemandCode(demandCode);
            sapInterfaceDataLog.setDataId(dataId);
            sapInterfaceDataLog.setSource("SLM");
            sapInterfaceDataLog.setTarget("SAP");
            sapInterfaceDataLog.setDataCode(dataCode);*/

            saveSapInterfaceDataLog(sapInterfaceDataLog);
            return sapInterfaceDataLog;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * *函数包含外围系统、收货单号（送货单号）、状态（ABC三种状态）的字段。
     *A：SAP的收货发数据已过账，MRO可发起冲销指令传给SAP；
     *B：SAP的收货数据未过账，MRO不需要发起冲销指令传给SAP；
     *C：SAP还没有收货数据，MRO不需要发起冲销指令传给SAP。
     *
     * <soap-env:Envelope xmlns:soap-env="http://schemas.xmlsoap.org/soap/envelope/">
     <soap-env:Header/>
     <soap-env:Body>
     <n0:ZMM_GET_ZMMT009H_MROResponse xmlns:n0="urn:sap-com:document:sap:rfc:functions">
     <E_RETURN>C</E_RETURN>
     </n0:ZMM_GET_ZMMT009H_MROResponse>
     </soap-env:Body>
     </soap-env:Envelope>
     */
    public String getSapBack(String url,String username,String password,String content){
        String backXML = "";
        try {

            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(AuthScope.ANY,
                    new UsernamePasswordCredentials(username, password));
            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(credsProvider)
                    .build();

            //method.setRequestHeader("Content-Type", "application/soap+xml;charset=utf-8;action=\"generateLabel\"");
            HttpPost httppost = new HttpPost(url);
          //  httppost.setHeader("Content-Type", "application/soap+xml;charset=utf-8;action=\"generateLabel\"");

            StringEntity requestEntity = new StringEntity(content, "text/xml", "UTF-8");
            httppost.setEntity(requestEntity);

            HttpResponse response = client.execute(httppost);
            int httpCode = response.getStatusLine().getStatusCode();
            HttpEntity resEntity=response.getEntity();
            backXML =  EntityUtils.toString(resEntity,"UTF-8");
            System.out.println(backXML);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        String backCode = "";
//        if (backXML.length() > 0) {
//            backCode = backXML.substring(backXML.indexOf("<E_RETURN>")+10,backXML.indexOf("</E_RETURN>"));
//        }
        return backXML;
    }

}