package com.itranswarp.learnjava.validator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 表明是一个bean
@Order(3) //使用Orde进行排序
public class NameValidator implements Validator {

	@Override
	public void validate(String email, String password, String name) {
		if (name == null || name.isBlank() || name.length() > 20) {
			throw new IllegalArgumentException("invalid name: " + name);
		}
	}
}
