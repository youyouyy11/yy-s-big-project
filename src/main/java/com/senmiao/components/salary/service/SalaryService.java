package com.senmiao.components.salary.service;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.dto.salary.SalaryForm;
import com.telecom.data.jpa.service.BaseService;

import java.util.List;

/**
 * Created by yy on 2017/7/6.
 */
public interface SalaryService extends BaseService<Salary>{
    List<Salary> saveSalary(SalaryForm form);
}
