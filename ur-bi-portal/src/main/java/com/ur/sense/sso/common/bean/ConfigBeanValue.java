package com.ur.sense.sso.common.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigBeanValue {
	
	@Value("${SenseServer}")
    public  String SenseServer;
 
    @Value("${UserDirectory}")
    public  String UserDirectory;
 
    @Value("${Protocol}")
    public  String Protocol;
 
    @Value("${SenseHost}")
    public  String SenseHost;
 
    @Value("${CerPassword}")
    public  String CerPassword;
 
    @Value("${DefaultUserName}")
    public  String DefaultUserName;
 
    @Value("${VirtualProxy}")
    public  String VirtualProxy;
 
    @Value("${ErrorPage}")
    public  String ErrorPage;
    
}
