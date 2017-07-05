package com.senmiao.components.user.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.senmiao.components.user.model.Users;
import com.telecom.data.jpa.repository.BaseRepository;

public interface UsersRepository extends BaseRepository<Users> {

	/**
     * 根据用户USERID或EMAIL或MOBILE登录
     * @param input
     * @param password
     * @return 用户列表
     */
    @Query("select u from Users u where u.phone =:phone and u.password=:password")
    public Users findByLoginInput(@Param("phone") String phone, @Param("password") String password);
	
	/**
     * 更新最后登录时间/IP
     * @param id 用户ID
     * @return 
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query("update Users u set u.lastLoginTime = ?2, u.lastLoginIp = ?3 where u.id = ?1")
    public int updateLastLoginInfo(String id,Date loginTime,String loginIp);
    
	@Query("FROM Users u where u.phone = ?1")
	public Users findByPhone(String phone);
	
	@Query("FROM Users u where u.wechatcode = ?1")
	public Users findByWeixinOpenId(String openId);

    @Query("FROM Users u WHERE u.deleted = 0 ORDER BY u.timeCreated DESC")
    public List<Users> findAll();

}
