package com.ur.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class UploadUtil {
	
	
	 public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
	        File targetFile = new File(filePath);  
	        if(!targetFile.exists()){    
	            targetFile.mkdirs();    
	        }       
	        FileOutputStream out = new FileOutputStream(filePath+fileName);
	        out.write(file);
	        out.flush();
	        out.close();
	    }

		public static void resultError(HashMap<String, Object> result, int i, String errorMsg){
			result.put("success", false);
			result.put("message", "第"+(i+1)+"行数据有错误, "+errorMsg);
		}

		public static void resultError(HashMap<String, Object> result, int i, int j, String errorMsg){
			result.put("success", false);
			result.put("message", "第"+(i+1)+"行的第"+(j+1)+"列数据有错误, "+errorMsg);
		}
	 
		public static void resultError(HashMap<String, Object> result, int i, int j){
			result.put("success", false);
			result.put("message", "第"+(i+1)+"行的第"+(j+1)+"列数据有错误, 不能为空！（如果存在一行为空，请删除空行） ");
		}
		
		public static void resultErrorNotBlank(HashMap<String, Object> result, int i, int j){
			result.put("success", false);
			result.put("message", "第"+(i+1)+"行的第"+(j+1)+"列数据有错误, 不能为空！");
		}
		
		public static void resultErrorDataDuplication(HashMap<String, Object> result, int i){
			result.put("success", false);
			result.put("message", "第"+(i+1)+"行数据有错误, 导入的excel中有重复数据！");
		}
		
		public static String getCellFormatValue(Cell cell)  {
			String cellvalue = "";
			try{
				if (cell != null) {
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						 if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
				                SimpleDateFormat sdf = null;  
				                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
				                        .getBuiltinFormat("h:mm")) {  
				                    sdf = new SimpleDateFormat("HH:mm");  
				                } else {// 日期  
				                    sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                }  
				                Date date = cell.getDateCellValue();  
				                cellvalue = sdf.format(date);  
				            } else if (cell.getCellStyle().getDataFormat() == 58) {  
				                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
				                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                double value = cell.getNumericCellValue();  
				                Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
				                cellvalue = sdf.format(date);  
				            } else {  
				                double value = cell.getNumericCellValue();  
				                CellStyle style = cell.getCellStyle();  
				                DecimalFormat format = new DecimalFormat("#.000000");
				                String temp = style.getDataFormatString();  
				                //单元格设置成常规
				                /*if (temp.equals("General")) {
				                    format.applyPattern("#");  
				                }  */
				                cellvalue = format.format(value);  
				            }  
				            break;  
						
					 case HSSFCell.CELL_TYPE_STRING://String类型
						 	cellvalue = cell.getRichStringCellValue().toString().trim();  
				            break;  
				        case HSSFCell.CELL_TYPE_BLANK:  
				        	cellvalue = "";  
				        default:  
				        	cellvalue = "";  
				            break;  
					}
				} else {
					cellvalue = "";
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return cellvalue;
		}
		
		public static String getCellFormatValueNumber(Cell cell)  {
			String cellvalue = "";
			try{
				if (cell != null) {
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						 if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
				                SimpleDateFormat sdf = null;  
				                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
				                        .getBuiltinFormat("h:mm")) {  
				                    sdf = new SimpleDateFormat("HH:mm");  
				                } else {// 日期  
				                    sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                }  
				                Date date = cell.getDateCellValue();  
				                cellvalue = sdf.format(date);  
				            } else if (cell.getCellStyle().getDataFormat() == 58) {  
				                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
				                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                double value = cell.getNumericCellValue();  
				                Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
				                cellvalue = sdf.format(date);  
				            } else {  
				                double value = cell.getNumericCellValue();  
				                CellStyle style = cell.getCellStyle();  
				                DecimalFormat format = new DecimalFormat("#");
				                String temp = style.getDataFormatString();  
				                //单元格设置成常规
				                /*if (temp.equals("General")) {
				                    format.applyPattern("#");  
				                }  */
				                cellvalue = format.format(value);  
				            }  
				            break;  
						
					 case HSSFCell.CELL_TYPE_STRING://String类型
						 	cellvalue = cell.getRichStringCellValue().toString().trim();  
				            break;  
				        case HSSFCell.CELL_TYPE_BLANK:  
				        	cellvalue = "";  
				        default:  
				        	cellvalue = "";  
				            break;  
					}
				} else {
					cellvalue = "";
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return cellvalue;
		}
		
		public static String getCellFormatValueNumber(Cell cell,String decimalFormat)  {
			String cellvalue = "";
			try{
				if (cell != null) {
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						 if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
				                SimpleDateFormat sdf = null;  
				                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
				                        .getBuiltinFormat("h:mm")) {  
				                    sdf = new SimpleDateFormat("HH:mm");  
				                } else {// 日期  
				                    sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                }  
				                Date date = cell.getDateCellValue();  
				                cellvalue = sdf.format(date);  
				            } else if (cell.getCellStyle().getDataFormat() == 58) {  
				                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
				                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                double value = cell.getNumericCellValue();  
				                Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
				                cellvalue = sdf.format(date);  
				            } else {  
				                double value = cell.getNumericCellValue();  
				                DecimalFormat format = new DecimalFormat(decimalFormat);
				                cellvalue = format.format(value);  
				            }  
				            break;  
						
					 case HSSFCell.CELL_TYPE_STRING://String类型
						 	cellvalue = cell.getRichStringCellValue().toString().trim();  
				            break;  
				        case HSSFCell.CELL_TYPE_BLANK:  
				        	cellvalue = "";  
				        default:  
				        	cellvalue = "";  
				            break;  
					}
				} else {
					cellvalue = "";
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return cellvalue;
		}

}
