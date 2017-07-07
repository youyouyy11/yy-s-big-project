package com.senmiao.components.salary.repository;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.components.user.model.Users;
import com.telecom.data.jpa.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yy on 2017/7/6.
 */
public interface SalaryRepository extends BaseRepository<Salary>{


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying


    @Query("FROM Users u WHERE u.deleted = 0 ORDER BY u.timeCreated DESC")
    public List<Salary> findAll();
}
