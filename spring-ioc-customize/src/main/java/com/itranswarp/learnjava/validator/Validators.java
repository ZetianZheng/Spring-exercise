package com.itranswarp.learnjava.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validators {

	@Autowired
	List<Validator> validators; // 这里Validators被注入了一个List<Validator>, Spring会自动装配所有类别为Validator的bean，之后再新增其他的Validator类型也不用怕，可以被直接再这里装配

	public void validate(String email, String password, String name) {
		for (var validator : this.validators) { // 已经被装配好了
			validator.validate(email, password, name);
		}
	}
}
