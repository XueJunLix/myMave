package com.ur.sense.sso.common.utils;

import org.springframework.core.env.Environment;

public class PropertiesUtil {
	 
	private static Environment env = null;
	
	public static void setEnvironment(Environment env) {
		PropertiesUtil.env = env;
	}
	
	public static String getProperty(String key) {
		return PropertiesUtil.env.getProperty(key);
	}
	
	
}