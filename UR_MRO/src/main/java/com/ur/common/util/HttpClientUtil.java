package com.ur.common.util;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http 工具类
 *
 */

public class HttpClientUtil {

     /**
      * post 请求
      * @param url
      * @param params
      * @return
      */
     public  static String  doPost(String url, String  params) throws Exception{

         HttpClient httpClient = new DefaultHttpClient();
         HttpPost httppost = new HttpPost(url);
         httppost.setHeader("Content-type", "application/json");

         StringEntity postingString = new StringEntity(params);// json传递
         httppost.setEntity(postingString);

          HttpResponse response=httpClient.execute(httppost);

         int httpCode = response.getStatusLine().getStatusCode();

         if(httpCode==200){
               HttpEntity resEntity=response.getEntity();
              return   EntityUtils.toString(resEntity,"UTF-8");
         }

            return null;
     }


}
