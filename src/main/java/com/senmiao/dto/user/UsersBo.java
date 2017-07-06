package com.senmiao.dto.user;

import com.senmiao.components.user.model.Users;
import com.senmiao.util.DataUtil;
import com.senmiao.util.ValidateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telecom.data.common.dto.BaseBo;

@JsonInclude(Include.NON_NULL)
public class UsersBo extends BaseBo<Users> {

	private String id;
	
	private String name;  
	
	private String phone;

	private String time;

	private String creditScore;

	public String getTime() {
		return time;
	}

	public void setTimeCreated(Long timeCreated) {
		this.time = DataUtil.formatDate(timeCreated,"yyyy-MM-dd");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public void setName(String name) {
		if (!ValidateUtil.isValid(name)){
			this.name = "";
		}else {
			this.name = name;
		}
	}

	@Override
	protected void processBean(Users arg0) {

	}

	public UsersBo() {
	}

	public UsersBo(Users model) {
		
		fromModel(model);
	}

	
}
