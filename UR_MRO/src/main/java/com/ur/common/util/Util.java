package com.ur.common.util;

public class Util {
	
	public static String null2String(Object obj) {
		if(obj == null) {
			return "";
		} else {
			return String.valueOf(obj);
		}
	}
}
