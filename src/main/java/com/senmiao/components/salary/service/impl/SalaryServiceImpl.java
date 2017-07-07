package com.senmiao.components.salary.service.impl;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.components.salary.repository.SalaryRepository;
import com.senmiao.components.salary.service.SalaryService;
import com.senmiao.dto.salary.SalaryForm;
import com.senmiao.util.StringUtil;
import com.telecom.common.character.Randoms;
import com.telecom.data.jpa.repository.BaseRepository;
import com.telecom.data.jpa.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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


    @Override
    public List<Salary> saveSalary(SalaryForm form) {

        List<String> moneyArr = StringUtil.str2list(form.getMoney(),"#");
        List<String> nameArr = StringUtil.str2list(form.getName(),"#");
        List<Salary> list =  new ArrayList<>();
        for (int i = 0; i < nameArr.size(); i++){
            Salary salary = new Salary();

            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyyMMdd");
            String time=format.format(date);

            salary.setSalaryNo(time + Randoms.number(4) );
            salary.setName(nameArr.get(i));
            salary.setTheDate(time);
            salary.setAlreadySattlement(false);
            salary.setMoney(moneyArr.get(i));
            list.add(salary);
        }

        return repo.save(list);
    }
}
