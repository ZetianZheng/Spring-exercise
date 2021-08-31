package com.itranswarp.learnjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml"); // 装载配置文件
		UserService userService = context.getBean(UserService.class); // 找到bean
		User user = userService.login("bob@example.com", "password"); // 正常调用
		System.out.println(user.getName());
	}
}
