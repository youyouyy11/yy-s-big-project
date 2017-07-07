package com.senmiao.components.salary.model;

import com.senmiao.components.user.model.Users;
import com.telecom.data.jpa.domain.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by yy on 2017/7/6.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sm_salary")
public class Salary extends BaseModel{
    private static final long serialVersionUID = 54144565041556567L;

    @Column (length = 20)               //工资流水号
    private String salaryNo;

    @Column (length = 20)               //工资金额
    private String money;

    @Column (length = 15)               //员工姓名
    private String name;

    @Column (length = 20)               //工资结算日期
    private String theDate;

    @Column (length = 4)                //是否结算
    private String alreadySattlement;

    @ManyToOne
    private Users users;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
