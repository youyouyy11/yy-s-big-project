package com.senmiao.components.user.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.senmiao.util.ValidateUtil;
import org.springframework.data.jpa.domain.Specification;

import com.senmiao.components.user.model.Users;
import com.senmiao.components.user.search.UsersSearch;

public class UsersSpec implements Specification<Users> {

	private UsersSearch form;
	
	public UsersSpec(UsersSearch descSearch){
		this.form = descSearch;
	}
	
	@Override
	public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate p = cb.conjunction();
		
		 p.getExpressions().add(cb.equal(root.<Boolean>get("deleted"), false));         //判断是否假删

		 if(ValidateUtil.isValid(form.getEmail()))                                      //判断该数据是否有效（前端是否输入了该值）
			 p.getExpressions().add(cb.equal(root.<String>get("email"), form.getEmail()));

        if(ValidateUtil.isValid(form.getPhone()))
            p.getExpressions().add(cb.equal(root.<String>get("phone"), form.getPhone()));

        if(ValidateUtil.isValid(form.getName()))
            p.getExpressions().add(cb.equal(root.<String>get("name"), form.getName()));


		
		return p;
	}

}
