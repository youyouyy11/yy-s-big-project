package com.senmiao.components.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.telecom.data.jpa.domain.model.BaseModel;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sm_users")
public class Users extends BaseModel{
	private static final long serialVersionUID = 5414456504119071567L;

	@Column(length=15)
	private String name;                                        // 用户姓名
	
	@Column(length=20)
	private String phone;                                       // 手机号码
	
	@Column(length=50)
	private String email;										// 电子邮箱
	
	@Column(length=15)
	private String occupation;                                  // 职业
	
	@Column(length=50)
	private String password;                                    // 密码
	
	@Column(length=30)
	private String sign;                                        // 个人签名
	
	@Column(length=200)
	private String photo;                                       // 头像
	
	@Column(length=20)
	private String company;										// 公司名称
	
	@Column(length=50)
	private String code;
	
	@Column(length=50)
	private String wechatcode;									//微信CODE
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime;                      			//最后登录时间
	
	@Column(length=60)
	private String lastLoginIp;                      			//最后登录IP


	
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

//	public String getQqcode() {
//		return qqcode;
//	}
//
//	public void setQqcode(String qqcode) {
//		this.qqcode = qqcode;
//	}

	public String getWechatcode() {
		return wechatcode;
	}

	public void setWechatcode(String wechatcode) {
		this.wechatcode = wechatcode;
	}

//	public String getMingdaocode() {
//		return mingdaocode;
//	}
//
//	public void setMingdaocode(String mingdaocode) {
//		this.mingdaocode = mingdaocode;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		return "Users{" +
				"name='" + name + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
