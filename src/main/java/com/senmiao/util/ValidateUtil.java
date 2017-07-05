package com.senmiao.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtil {
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param src 输入字符串
	 * @return
	 */
	public static boolean isValid(String src){
		src = StringUtils.trimToNull(src);
		if(src == null || "".equals(src.trim())){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 将字符串做去空处理
	 * 
	 * @param src
	 * @return
	 */
	public static String trimToNull(String src){
		src = StringUtils.trimToNull(src);
		return isValid(src) ? src : null;
	}
	
	/**
	 * 获取字符串数据的第一个元素
	 * 
	 * @param strs
	 * @return
	 */
	public static String getFirstElement(String[] strs){
		return isValid(strs) ? strs[0] : "";
	}
	
	
	/**
	 * 判断集合是否为空
	 * 
	 * @param col
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col){
		if(col == null || col.isEmpty()){			
			return false ;
		}
		return true ;
	}

	/**
	 * 判断传入对象是否为空
	 * @param col
	 * @return
	 */
	public static boolean isValid(Object obj){
		if(obj == null){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断数组的长度为零，或对象数组为空
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean isValid(Object[] arr){
		if(arr == null || arr.length == 0){
			return false ;
		}
		return true ;
	}

	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if ((obj instanceof CharSequence)) {
			return ((CharSequence) obj).length() == 0;
		}
		if ((obj instanceof Collection)) {
			return ((Collection) obj).isEmpty();
		}
		if ((obj instanceof Map)) {
			return ((Map) obj).isEmpty();
		}
		return false;
	}
	
}
