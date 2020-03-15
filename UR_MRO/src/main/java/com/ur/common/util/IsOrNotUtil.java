package com.ur.common.util;

import java.util.HashMap;
import java.util.Map;

public class IsOrNotUtil {
	
	public static Map<String, String> getKeyValueMap(){
		return IsOrNotUtil.getKeyValueMap(false);
	}
	
	public static Map<String, String> getKeyValueMap(boolean reverse){
		Map<String, String> map = new HashMap<String, String>();
		if(reverse) {
			map.put("是", "1");
			map.put("否", "0");
		}else {
			map.put("1", "是");
			map.put("0", "否");
		}
		return map;
	}

}
