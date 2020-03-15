package com.ur.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "shop")
public class Shop2OAConfig {

    private  String  accessKey;
    private  String  accessSecret;
    private  String  tokenUrl;
    private  String  employUrl;
    private  String  storeInfoUrl;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getEmployUrl() {
        return employUrl;
    }

    public void setEmployUrl(String employUrl) {
        this.employUrl = employUrl;
    }

    public String getStoreInfoUrl() {
        return storeInfoUrl;
    }

    public void setStoreInfoUrl(String storeInfoUrl) {
        this.storeInfoUrl = storeInfoUrl;
    }
}
