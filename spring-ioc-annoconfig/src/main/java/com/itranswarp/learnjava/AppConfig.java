package com.itranswarp.learnjava;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;

import java.time.ZoneId;

@Configuration
@ComponentScan
public class AppConfig {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		User user = userService.login("bob@example.com", "password");
		System.out.println(user.getName());
	}

	@Bean
	@Primary
	@Qualifier("Z")
	ZoneId createZoneId() {
		return ZoneId.of("Z");
	}

	@Bean
	@Qualifier("utc8")
	ZoneId createZoneOfUTC8() {
		return ZoneId.of("UTC+08:00");
	}
}
