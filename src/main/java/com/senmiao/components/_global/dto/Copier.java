package com.senmiao.components._global.dto;

import com.telecom.common.bean.Beans;

public class Copier<T> {
	
	public void fromModel(T from,Object to) {
		try {
			Beans.copy(from, to);
		} catch (Exception ex) {
		}

	}
	

}
