package com.senmiao.components.salary.search;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.components.salary.specification.SalarySpec;
import com.telecom.data.jpa.domain.dto.BaseSearch;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by yy on 2017/7/6.
 */
public class SalarySearch extends BaseSearch<Salary>{
    private static final long serialVersionUID = -11316915144375665L;

    private String salaryNo;

    private String money;

    private String name;

    private String theDate;

    private String alreadySattlement;

    public String getSalaryNo() {
        return salaryNo;
    }

    public void setSalaryNo(String salaryNo) {
        this.salaryNo = salaryNo;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheDate() {
        return theDate;
    }

    public void setTheDate(String theDate) {
        this.theDate = theDate;
    }

    public String getAlreadySattlement() {
        return alreadySattlement;
    }

    public void setAlreadySattlement(String alreadySattlement) {
        this.alreadySattlement = alreadySattlement;
    }

    @Override
    public Sort getSort() {
        return new Sort(Sort.Direction.DESC,"timeCreated");
    }

    @Override
    public Specification<Salary> getSpecification() {
        return new SalarySpec(this);
    }

}
