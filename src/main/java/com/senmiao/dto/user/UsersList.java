package com.senmiao.dto.user;

import com.senmiao.components.user.model.Users;
import com.telecom.data.jpa.domain.dto.BaseListOutput;

public class UsersList extends BaseListOutput<Users, UsersBo> {

	public UsersList(Object form) {
		super(form);
	}
}
