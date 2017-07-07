package com.senmiao.components.salary.service.impl;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.components.salary.repository.SalaryRepository;
import com.senmiao.components.salary.service.SalaryService;
import com.telecom.data.jpa.repository.BaseRepository;
import com.telecom.data.jpa.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yy on 2017/7/6.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SalaryServiceImpl extends BaseServiceImpl<Salary> implements SalaryService{
    private Logger log = LoggerFactory.getLogger(SalaryServiceImpl.class);

    @Resource
    private SalaryRepository repo;

    @Override
    protected BaseRepository<Salary> getRepo() {
        return repo;
    }


}
