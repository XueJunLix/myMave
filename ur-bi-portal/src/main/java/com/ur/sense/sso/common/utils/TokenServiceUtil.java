package com.ur.sense.sso.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * X获取Sense Ticket工具类
 * @author EBI
 *
 */
@Slf4j
public class TokenServiceUtil {

	private static String xrfkey = "0123456789abcdef";

	private static String protocol = PropertiesUtil.getProperty("Protocol");
	
	private static String host = PropertiesUtil.getProperty("SenseHost");//"qkmobrpt.hikvision.com.cn";
	
	private static String userDirectory = PropertiesUtil.getProperty("UserDirectory");
	
	private static String cerPassword = PropertiesUtil.getProperty("CerPassword");
	
	private static String defaultUserName = PropertiesUtil.getProperty("DefaultUserName");
	
	private static String vproxy = PropertiesUtil.getProperty("VirtualProxy");

	public String getTicket(String username) {
		log.info("protocol: {}", protocol);
		HttpsURLConnection connection = null;
		OutputStreamWriter wr = null;
		BufferedReader in = null;
		if("".equals(username) && !"".equals(defaultUserName)) {
			log.info("username is null, use defaultUserName");
			username = defaultUserName;
		}
		try {
			/************** BEGIN Certificate Acquisition **************/
//			String programPath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
			ClassPathResource clientResource = new ClassPathResource("cer" + File.separator + "client.jks");
			ClassPathResource rootResource = new ClassPathResource("cer" + File.separator + "root.jks");
			log.info("programPath:"+clientResource);
			File newFile = clientResource.getFile();
			File newFile1 = rootResource.getFile();
			String proxyCertPass = cerPassword;
			String rootCertPass = cerPassword;
			/************** END Certificate Acquisition **************/

			/**************
			 * BEGIN Certificate configuration for use in connection
			 **************/
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(new FileInputStream(newFile), proxyCertPass.toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(ks, proxyCertPass.toCharArray());
			KeyStore ksTrust = KeyStore.getInstance("JKS");
			ksTrust.load(new FileInputStream(newFile1), rootCertPass.toCharArray());
			TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			tmf.init(ksTrust);
			SSLContext context = SSLContext.getInstance("SSL");
//			context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			context.init(kmf.getKeyManagers(), new TrustManager[] { new TrustAnyTrustManager() }, null);
			SSLSocketFactory sslSocketFactory = context.getSocketFactory();
			/**************
			 * END Certificate configuration for use in connection
			 **************/

			/************** BEGIN HTTPS Connection **************/
			String qpsUrl = protocol+"://" + host + ":4243/qps" + vproxy + "/ticket?xrfkey=" + xrfkey;
			log.info("qpsUrl: {}", qpsUrl);
			URL url = new URL(qpsUrl);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setSSLSocketFactory(sslSocketFactory);
			connection.setRequestProperty("x-qlik-xrfkey", xrfkey);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setHostnameVerifier(new TokenServiceUtil().new TrustAyHostnameVerifier());
			connection.setRequestMethod("POST");
			/************** BEGIN JSON Message to Qlik Sense Proxy API **************/
			String body = "{ 'UserId':'" + username + "','UserDirectory':'"+userDirectory+"',";
			body += "'Attributes': [],";
			body += "}";
			log.info("Request Body: {}",  body);
			/************** END JSON Message to Qlik Sense Proxy API **************/

			wr = new OutputStreamWriter(connection.getOutputStream());
			wr.write(body);
			wr.flush(); // Get the response from the QPS BufferedReader
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				builder.append(inputLine);
			}
			String data = builder.toString();
			log.info("The response from the server is: {}", data);
			JSONObject json = JSONObject.parseObject(data);
			String ticket = json.getString("Ticket");
			connection.disconnect();
			/************** END HTTPS Connection **************/
			return ticket;
		}catch (Exception e) {
			log.error("unknown error---> {} ", Throwables.getStackTraceAsString(e));
		}
		finally {
			if(in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(wr != null) {
				try {
					wr.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(null != connection) {
				connection.disconnect();
			}
		}
		return "";
	}

	public class TrustAyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
	
	private static class TrustAnyTrustManager implements X509TrustManager {  
        public void checkClientTrusted(X509Certificate[] chain, String authType)  
                throws CertificateException {  
        }  
    
        public void checkServerTrusted(X509Certificate[] chain, String authType)  
                throws CertificateException {  
        }  
    
        public X509Certificate[] getAcceptedIssuers() {  
            return new X509Certificate[] {};  
        }  
    }  

	public static void main(String[] args) {
		TokenServiceUtil tsu = new TokenServiceUtil();
		String p = tsu.getTicket("administrator");
		System.out.println(p);
	}

}
