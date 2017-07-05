package com.senmiao.dto.user;

import com.senmiao.components.user.model.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telecom.data.common.dto.BaseForm;

@JsonInclude(Include.NON_NULL)
public class UsersForm extends BaseForm<Users> {

	private String name;
	
	private String phone;
	
	private String con;

	private String email;

	private String occupation;

	private String password;

	private String sign;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	protected void processBean(Users arg0) {
		// TODO Auto-generated method stub

	}

}
