package com.senmiao.rest.user;

import java.util.*;

import javax.annotation.Resource;

import com.senmiao.util.StringUtil;
import com.telecom.common.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.senmiao.components.user.model.Users;
import com.senmiao.components.user.search.UsersSearch;
import com.senmiao.components.user.service.UsersService;
import com.senmiao.dto.user.UsersBo;
import com.senmiao.dto.user.UsersForm;
import com.senmiao.dto.user.UsersList;
import com.telecom.data.jpa.domain.dto.MessageOutput;

/**
 * 
 * 用户信息操作接口
 * 
 * @author zhangxu
 */
@RestController
@RequestMapping("/server/users")
public class UserRest {

	private Logger log = LoggerFactory.getLogger(UserRest.class);

	@Resource private UsersService srv;

	// ------------------------------------------------------- common methods
	
	@RequestMapping("/pagelist.json")
	@ResponseBody
	public Page<UsersBo> pageList(@ModelAttribute UsersSearch searchForm) {
		return new UsersList(srv.pageList(searchForm)).getPage();
	}

	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute UsersSearch searchForm) {
		Map<String, Object> map = new HashMap<>();
		List<UsersBo> accounts = new UsersList(srv.list(searchForm)).getList();
		map.put("aaData", accounts);
		return map;
	}

	@RequestMapping("/detail/{id}.json")
	@ResponseBody
	public UsersBo detail(@PathVariable String id) {
		return new UsersBo(srv.detail(id));
	}

	@RequestMapping("/save.json")
	@ResponseBody
	public MessageOutput save(@ModelAttribute UsersForm form) {
		return new MessageOutput(srv.saveForm(form, new Users()).getId());
	}

	@RequestMapping("/delete.json")
	@ResponseBody
	public void delete(@RequestParam String id) {
		srv.fakeDeleteById(id);
	}

	// ------------------------------------------------------ project methods

	@RequestMapping("/getByUsersSearch.json")			//多重搜索
	@ResponseBody
	public Result<List<UsersBo>> getByUsersSearch(@ModelAttribute UsersSearch search){
		List<Users> list = srv.getByUsersSearch(search);
		List<UsersBo> bos = new ArrayList<>();
		Iterator<Users> it = list.iterator();
		while (it.hasNext()){
			bos.add(new UsersBo(it.next()));
		}
		return new Result<List<UsersBo>>(200, "查询成功", bos);
	}

	@RequestMapping("/multiSave.json")					//多重创建
	@ResponseBody
	public Result<List<UsersBo>> multiSave(@ModelAttribute UsersForm form){

		return  new Result<>(200," 添加成功",new UsersList(srv.multiSave(form)).getList());		//输出用通过BO（list）
	}

	@RequestMapping("/screenByCreditScore")				//排序筛选
	@ResponseBody
	public Result<List<UsersBo>> screenByCreditScore(@RequestParam String creditScore){
		return new Result<>(200,"筛选成功",new UsersList(srv.screenByCreditScore(creditScore)).getList());
	}


}
