package com.senmiao.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {



	/**
	 * 将字符串转换成数组,按照tag分割
	 */
	public static String[] str2Arr(String str,String tag){
		if(ValidateUtil.isValid(str)){
			return str.split(tag);
		}
		return null ;
	}

	/**
	 * 判断在values数组中是否含有指定value字符串
	 */
	public static boolean contains(String[] values, String value) {
		if(ValidateUtil.isValid(values)){
			for(String s : values){
				if(s.equals(value)){
					return true ;
				}
			}
		}
		return false;
	}

	/**
	 * 将数组变换成字符串,使用" "号分割
	 */
	public static String arr2Str(Object[] arr) {
		String temp = "" ;
		if(ValidateUtil.isValid(arr)){
			for(Object s : arr){
				temp = temp + s + " " ;
			}
			return temp.substring(0,temp.length() - 1);
		}
		return temp;
	}
	
	public static String arr2Str(Object[] arr, String tag) {
		String temp = "" ;
		if(ValidateUtil.isValid(arr)){
			for(Object s : arr){
				temp = temp + s;
			}
			return temp.substring(0,temp.length());
		}
		return temp;
	}

	public static String list2str(List<String> list){
		String temp = "";
		if(ValidateUtil.isValid(list)){
			for(String s : list){
				temp = temp + s + " ";
			}
			return temp.substring(0, temp.length() - 1);
		}
		return temp;
	}

	// 将字符串变成list集合
	public static List<String> str2list(String str, String rgx){
		List<String> list = new ArrayList<String>();
		if(null == str || "".equals(str)) return list;
		String[] arr = str.split(rgx);
		for(String s : arr){
			list.add(s);
		}
		return list;
	}

	//获得字符串的描述信息
	public static String getDescString(String str){
		if(str != null && str.trim().length() > 30){
			return str.substring(0,30);
		}
		return str ;
	}

	public static String redirectPath(String action, String resultTypeId, Integer id){
		StringBuilder sb = new StringBuilder();
		sb.append(action).append("?").append(resultTypeId).append("=").append(id)
				.append("&state=success&resultType=").append(resultTypeId)
				.append("&timestamp=").append(System.currentTimeMillis());
		return sb.toString();

	}

	/**
	 * 截取出字符串中的整数部分
	 * @return
	 */
	public static String strParseInteger(String str){
		return str.substring(0, str.indexOf("."));
	}

	/**
	 * 从 <code>str</code> 中截取字符，每<code>size</code>个字符就换行。
	 * @param str
	 * @param size
	 * @return
	 */
	public static String strToMultipleLines(String str, int size){
		if(size<=0) throw new IndexOutOfBoundsException("Error size to spilt.");

		StringBuilder sb = new StringBuilder();
		char[] c = str.toCharArray();
		for(int i=0; i < c.length; i++){
			sb.append(c[i]);
			if(i%size==0 && i!=0) sb.append("\r\n");
		}
		return sb.toString();
	}

	/*
	 * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
	 */
	public static boolean isHave(String[] strs, String s) {

		for (int i = 0; i < strs.length; i++) {
			// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
			if (strs[i].equals(s)) {
				// 查找到了就返回真，不在继续查询
				return true;
			}
		}

		// 没找到返回false
		return false;
	}
}