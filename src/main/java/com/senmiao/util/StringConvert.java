package com.senmiao.util;

import org.apache.commons.lang3.StringUtils;

public class StringConvert {

	public static boolean toBoolean(String input){
		input = StringUtils.trimToEmpty(input);
		return input.equals("on") || input.equals("1") || input.equals("y")? true:false;
	}
}
