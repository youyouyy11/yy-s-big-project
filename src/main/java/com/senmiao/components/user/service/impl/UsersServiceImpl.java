package com.senmiao.components.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.senmiao.components.user.search.UsersSearch;
import com.senmiao.dto.user.UsersForm;
import com.senmiao.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.senmiao.components.user.model.Users;
import com.senmiao.components.user.repository.UsersRepository;
import com.senmiao.components.user.service.UsersService;
import com.telecom.data.jpa.repository.BaseRepository;
import com.telecom.data.jpa.service.impl.BaseServiceImpl;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl extends BaseServiceImpl<Users>implements UsersService {

	private Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Resource
	private UsersRepository repo;

	@Override
	protected BaseRepository<Users> getRepo() {
		return repo;
	}

	/**
	 * 通过手机号获取用户信息
	 * 
	 * @param mobile
	 *            手机号
	 * @return 用户信息
	 */
	@Override
	public Users findByMobile(String mobile, String clientIp) {
		mobile = StringUtils.trimToNull(mobile);
		if (mobile == null)
			return null;
		Users user = null;
		try {
			user = repo.findByPhone(mobile);

			if (null == user) {
				log.info("login error! phone:[{}], IP-Address:[{}]", mobile, clientIp);
				return null;
			}
			repo.updateLastLoginInfo(user.getId(), new Date(), clientIp);
		} catch (Exception e) {
			log.error("login error! error [{}]", ExceptionUtils.getStackTrace(e));
			return null;
		}

		return user;
	}

    @Override
    public List<Users> getByUsersSearch(UsersSearch search) {
        return repo.findAll(search.getSpecification(), search.getSort());
    }

    @Override
    public List<Users> multiSave(UsersForm form) {
        List<String> nameArr = StringUtil.str2list(form.getName(), "#");        //识别 # 分割字符串
        List<String> phoneArr = StringUtil.str2list(form.getPhone(), "#");
        List<Users> list = new ArrayList<>();
        for (int i = 0; i<nameArr.size(); i++ ){
            Users u = new Users();
            u.setName(nameArr.get(i));
            u.setPhone(phoneArr.get(i));
            list.add(u);
        }
        repo.save(list);
        return null;
    }


}
