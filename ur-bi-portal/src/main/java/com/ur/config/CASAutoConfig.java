package com.ur.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class CASAutoConfig {
	
	@Value("${cas.server.host.url}")
	private String serverUrlPrefix;
	
	@Value("${cas.server.host.login_url}")
	private String serverLoginUrl;
	
	@Value("${app.server.host.url}")
	private String clientHostUrl;

	/**
	 * 授权过滤器
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterAuthenticationRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthenticationFilter());
		// 设定匹配的路径
		registration.addUrlPatterns("/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("casServerLoginUrl", serverUrlPrefix);
		initParameters.put("serverName", clientHostUrl);
		// 忽略的url，"|"分隔多个url
		initParameters.put("ignorePattern", "/WeiXin/getUser|/test|/js|/WeiXin/getMenuList|/css|/WeiXin/MenuPage|/WeiXin/openPage|/getUserInfoByLoginId|/getMenuByRootCode|/getMenuByLoginIdAndRootCode");
		registration.setInitParameters(initParameters);
		// 设定加载的顺序
		registration.setOrder(1);
		return registration;
	}
}