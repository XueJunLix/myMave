package com.ur.common.service;

import java.text.MessageFormat;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

@Service
public class LocalLanguageService {

	@Autowired
    MessageSource messageSource;

	/**
	 * 获取当前语言环境
	 * @return
	 */
	public String getLocaleLanguage() {
		String language ="1"; //默认中文
		if(LocaleContextHolder.getLocale().equals(Locale.US)) {
			language="2";
		}
		return language;
	}
	
	/**
	 * 获取多语言配置信息
	 * @param key
	 * @param defaultMessage
	 * @return
	 */
	public String getMessage(String key,String defaultMessage){
    	Locale locale = LocaleContextHolder.getLocale();
    	return messageSource.getMessage(key, null,defaultMessage, locale);
    }
	
	public String getMessage(String key,String defaultMessage,String param){
    	Locale locale = LocaleContextHolder.getLocale();
    	String message= messageSource.getMessage(key, null,defaultMessage, locale);
    	if(!StringUtils.isEmpty(message)) {
    		return MessageFormat.format(message,param);
    	}
    	return null;
    }
}
