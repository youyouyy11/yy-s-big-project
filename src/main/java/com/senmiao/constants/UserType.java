package com.senmiao.constants;

import org.apache.commons.lang3.StringUtils;

public enum UserType {

	admin("管理者"),
	
	teacher("老师"),
	
	hr("HR"),
	
	agent("代理商"),
	
	general("普通用户");


	private String name;
	private String value;
	
	
	private UserType(String name) {
		this.value = this.toString();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	
	public static UserType formatEunm(String key){
		
		if(StringUtils.isBlank(key)){
    		return null;
    	}
    	try {
			return UserType.valueOf(key);
		} catch (Exception e) {
			return general;
		} 
	}
	
}
