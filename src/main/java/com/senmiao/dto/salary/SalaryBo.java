package com.senmiao.dto.salary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.senmiao.components.salary.model.Salary;
import com.senmiao.util.DataUtil;
import com.telecom.data.common.dto.BaseBo;

/**
 * Created by yy on 2017/7/6.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalaryBo extends BaseBo<Salary>{
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

    public void setTimeCreated(Long timeCreated) {
        this.theDate = DataUtil.formatDate(timeCreated,"yyyy-MM-dd");
    }

    public String getAlreadySattlement() {
        return alreadySattlement;
    }

    public void setAlreadySattlement(String alreadySattlement) {
        this.alreadySattlement = alreadySattlement;
    }

    @Override
    protected void processBean(Salary arg0) {

    }

    public SalaryBo() {
    }

    public SalaryBo(Salary model) {

        fromModel(model);
    }
}
