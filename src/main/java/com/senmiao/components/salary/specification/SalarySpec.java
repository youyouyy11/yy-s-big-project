package com.senmiao.components.salary.specification;

import com.senmiao.components.salary.model.Salary;
import com.senmiao.components.salary.search.SalarySearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by yy on 2017/7/6.
 */
public class SalarySpec implements Specification<Salary>{
    private SalarySearch form;

    public SalarySpec(SalarySearch descSearch){
        this.form = descSearch;
    }

    @Override
    public Predicate toPredicate(Root<Salary> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate p = cb.conjunction();

        p.getExpressions().add(cb.equal(root.<Boolean>get("deleted"), false));         //判断是否假删

        return p;
    }
}
