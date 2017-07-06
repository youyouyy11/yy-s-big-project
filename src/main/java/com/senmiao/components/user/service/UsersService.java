package com.senmiao.components.user.service;

import com.senmiao.components.user.model.Users;
import com.senmiao.components.user.search.UsersSearch;
import com.senmiao.dto.user.UsersForm;
import com.telecom.data.jpa.service.BaseService;

import java.util.List;

public interface UsersService extends BaseService<Users> {

    Users findByMobile(String mobile, String clientIp);

    List<Users> getByUsersSearch(UsersSearch search);

    List<Users> multiSave(UsersForm form);

    List<Users>screenByCreditScore(String creditScore);

}


