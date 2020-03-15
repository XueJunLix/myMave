package com.ur.common.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/** 
 * 导出
 * @author qiyan.lan
 */
public class ExportUtil {
	
	//导出excel获取数字格式
	public static HashMap<Integer,Integer> getCellTypeMap(List<List<Object>> contentList){
        HashMap<Integer,Integer> cellTypeMap = new HashMap<>();
        if(contentList!=null && !contentList.isEmpty()) {
        	for(List<Object> rowList:contentList) {
            	for(int i=0, j=rowList.size(); i<j; i++) {
            		Object cellValue = rowList.get(i);
            		if(cellValue!=null) {
                		if(cellValue instanceof Integer
                				|| cellValue instanceof Double
                				|| cellValue instanceof Float
                				|| cellValue instanceof Long
                				|| cellValue instanceof BigDecimal
                				) {
                			cellTypeMap.put(i, 0);
                    	}
            		}
            	}
        	}
        }
        return cellTypeMap;
	}
	
}
