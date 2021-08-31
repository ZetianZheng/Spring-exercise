package com.itranswarp.learnjava.validator;

public interface Validator {
	//  validator的接口，为了便于扩展，定义一个接口：
	//  之后有三个接口相同, 实现不同的类来实现这个接口：EmailValidator, NameValidator, PasswordValidator
	// 最后有一个Validators作为入口验证：

	void validate(String email, String password, String name);
}
