package com.senmiao.components.user.search;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.senmiao.components.user.model.Users;
import com.senmiao.components.user.specification.UsersSpec;
import com.telecom.data.jpa.domain.dto.BaseSearch;

public class UsersSearch extends BaseSearch<Users>{

	private static final long serialVersionUID = -1131691514437675971L;

	private String name;

	private String phone;

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
	public Sort getSort() {
		return new Sort(Direction.DESC,"timeCreated");
	}

	@Override
	public Specification<Users> getSpecification() {
		return new UsersSpec(this);
	}



}
