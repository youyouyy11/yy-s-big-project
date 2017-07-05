package com.senmiao.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 数据工具类
 */
public class DataUtil {

	public static final String DATETYPE = "yyyyMMdd";
	public static final String YEARTYPE = "yyyy-MM-dd";
	public static final String DATETIMETYPE = "yyyyMMddHHmmss";
	public static final String TIMETYPE = "HHmmss";


	/**
	 * 使用MD5算法加密
	 */
	public static String MD5(String src) {
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			byte[] bytes = src.getBytes();
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] targ = messageDigest.digest(bytes);
			for (byte b : targ) {
				buffer.append(chars[(b >> 4) & 0x0F]);
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成六位随机数字
	 * 
	 * @param
	 */
	public static String getSixRandom() {
		Integer randomNum = (int) ((Math.random() * 9 + 1) * 100000);
		while (randomNum < 100000 || randomNum > 999999) {
			randomNum = (int) ((Math.random() * 9 + 1) * 100000);
		}
		String randNum = Integer.toString(randomNum);
		return randNum;
	}
	
	/**
	 * 生成六位随机团队码
	 * 
	 * @param
	 */
	public static String getTeamCode(String src) {
		Integer randomNum = (int) ((Math.random() * 9 + 1) * 1000);
		while (randomNum < 1000 || randomNum > 9999) {
			randomNum = (int) ((Math.random() * 9 + 1) * 1000);
		}
		String randNum = String.valueOf(randomNum);
		return src + randNum;
	}

	public static String formatDate(Long date) {

		return formatDate(date, DATETYPE);

	}

	public static String formatDate(Long date, String format) {

		if (null == date) {
			return "";
		}
		return DateFormatUtils.format(date, format);
	}

	public static Long parseTime(String date) {

		return parseTime(date, DATETYPE);
	}

	public static Long parseTime(String date, String format) {

		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			return parseDate(date.trim(), format).getTime();
		} catch (Exception e) {

			return null;
		}
	}

	public static Date parseDate(String date, String format) {

		if (StringUtils.isBlank(date)) {
			return null;
		}

		try {
			return DateUtils.parseDate(date.trim(), format);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getMonthDate() {
		SimpleDateFormat df = new SimpleDateFormat(DATETYPE);// 定义格式，不显示毫秒
		return df.format(new Date());
	}

	public static Properties loadProperty(String props){
		InputStream inputStream = null;
		Properties prop = new Properties();
		try{
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(props);
			prop.load(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
		}
		return prop;
	}

	

}
