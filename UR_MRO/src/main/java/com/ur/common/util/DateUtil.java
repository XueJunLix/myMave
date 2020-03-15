package com.ur.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
* @ClassName: DateUtil 
* @Description: TODO(日期处理类) 
*
 */
public final class DateUtil {
	/**
	 * 日
	 */
	public final static int INTERVAL_DAY = 1;
	/**
	 * 周
	 */
	public final static int INTERVAL_WEEK = 2;
	/**
	 * 月
	 */
	public final static int INTERVAL_MONTH = 3;
	/**
	 * 年
	 */
	public final static int INTERVAL_YEAR = 4;
	/**
	 * 小时
	 */
	public final static int INTERVAL_HOUR = 5;
	/**
	 * 分钟
	 */
	public final static int INTERVAL_MINUTE = 6;
	/**
	 * 秒
	 */
	public final static int INTERVAL_SECOND = 7;
	
	
	/**
	 * 字符型转换成日期型
	 * 
	 * @param date 需要转换的字符串日期 
	 * @param dateFormat 需要转的日期格式  "yyyy-MM-dd"
	 * @return 一个指定格式的日期
	 */
	public static Date dateFormat(String date, String dateFormat) {
		if (date == null) return null;
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		if (date != null) {
			try {
				return format.parse(date);
			} catch (Exception ex) {
				ex.fillInStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 使用默认格式 yyyy-MM-dd HH:mm:ss
	 * @param  date 需要转换的字符串日期 
	 * @return  带有时分秒的日期对象
	 */
	public static Date dateFormat(String date){
		return dateFormat(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/** 
	 * 日期型转换成字符串 
	 * @param date  
	 * @param dateFormat
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String dateFormat(Date date, String dateFormat) {
		if (date == null) return "";
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		if (date != null) {
			return format.format(date);
		}
		return "";
	}
	
	/**
	* @Title: 给定一个日期，返回加减n天后的日期  
	* @param @param basicDate
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws
	 */
    public static Date minAfterDate(Date basicDate,int n)   {  
    	Calendar now = Calendar.getInstance();
    	now.setTime(basicDate);
    	now.add(Calendar.DAY_OF_YEAR,0-n);
    	Date dt1= now.getTime();
        return  dt1;  
    } 
    /**
     * @Description: TODO(当前日期加减n天后的日期，返回String   (yyyy-mm-dd)  ) 
     * @param @param n 需要减去的天数
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
	public static String minAfterStr(int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_MONTH, +n);
		return df.format(rightNow.getTime());
	}
	/**
	 * 比较日期大小
	 * @param @param DATE1
	 * @param @param DATE2
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public static int compare_date(String DATE1, String DATE2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

	
	/**
	 * 比较日期大小
	 * @param @param DATE1
	 * @param @param DATE2
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public static int compare_date(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

	/**
	 * 获取年月组合（例：201405）
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getYearAndMonth(Integer year, Integer month){
		return getYearAndMonth(year, month, "");
	}
	/**
	 * 获取年月组合（例：'2014'+sign+'05'）
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getYearAndMonth(Integer year, Integer month, String sign){
		String result = "";
		if(month<10){
			result = String.valueOf(year) + sign + "0" + String.valueOf(month);
		}else{
			result = String.valueOf(year) + sign + String.valueOf(month);
		}
		return result;
	}
	/**
	 * 获取一个月的年月组合（例：201405）
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getYearAndLastMonth(Integer year, Integer month){
		return getYearAndLastMonth(year, month, "");
	}
	/**
	 * 获取一个月的年月组合（例：'2014'+sign+'05'）
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getYearAndLastMonth(Integer year, Integer month, String sign){
		String result = "";
		if(month>10){
			result = String.valueOf(year) + sign + String.valueOf(month-1);
		}else if(month>1){
			result = String.valueOf(year) + sign + "0" + String.valueOf(month-1);
		}else{
			result = String.valueOf(year - 1) + sign + "12";
		}
		return result;
	}
	/**
	 * 根据年 月 获取对应的月份 天数
	 * */
	public static int getDaysByYearMonth(int year, int month) {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 上下限数值判断
	 * @param value
	 * @return
	 */
	public static boolean isLimitNum(String value){
		String regex = "^[1-9]?[0-9](.[0-9]{1,2})?$";
		return value.matches(regex);
	}
	
	public static String fetchStringFromDouble(Double zz){
		String tempMin = String.valueOf(zz);
		tempMin = zz%1==0? tempMin.substring(0,tempMin.length()-2) : tempMin;
		BigDecimal bd = new BigDecimal(tempMin);  
		return bd.toPlainString();
	}
	
	public static String double2String(Double zz){
		String tempMin = String.valueOf(zz);
		return tempMin.lastIndexOf(".0")==-1 ? tempMin : tempMin.substring(0,tempMin.length()-2);
	}
	
	
	/** 
     * 凌晨 
     * @param date 
     * @flag 0 返回yyyy-MM-dd 00:00:00日期<br> 
     *       1 返回yyyy-MM-dd 23:59:59日期 
     * @return 
     */  
    public static Date weeHours(Date date, int flag) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int hour = cal.get(Calendar.HOUR_OF_DAY);  
        int minute = cal.get(Calendar.MINUTE);  
        int second = cal.get(Calendar.SECOND);  
        //时分秒（毫秒数）  
        long millisecond = hour*60*60*1000 + minute*60*1000 + second*1000;  
        //凌晨00:00:00  
        cal.setTimeInMillis(cal.getTimeInMillis()-millisecond);  
           
        if (flag == 0) {  
            return cal.getTime();  
        } else if (flag == 1) {  
            //凌晨23:59:59  
            cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);  
        }  
        return cal.getTime();  
    }  
    
	
}
