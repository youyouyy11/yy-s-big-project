package com.senmiao.dto.salary;

import com.senmiao.components.salary.model.Salary;
import com.telecom.data.jpa.domain.dto.BaseListOutput;

/**
 * Created by yy on 2017/7/6.
 */
public class SalaryList extends BaseListOutput<Salary,SalaryBo> {
    public SalaryList(Object form) {
        super(form);
    }
}
