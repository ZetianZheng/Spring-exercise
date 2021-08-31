package com.itranswarp.learnjava;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.itranswarp.learnjava.service.MailSession;
import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;

@Configuration
@ComponentScan
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // 调用配置类
		UserService userService = context.getBean(UserService.class);
		userService.register("sam@example.com", "password", "Sam");
		User user = userService.login("sam@example.com", "password");
		System.out.println(user.getName());
		context.getBean(MailSession.class);
		context.getBean(MailSession.class);
		context.getBean(MailSession.class);
		((ConfigurableApplicationContext) context).close();

	}

	@Bean
	@Primary // 如果外部注入的时候没有使用别名，那么默认使用primary的bean注入
	@Qualifier("z") // 使用别名z指定这个bean，外面注入的时候可以使用别名指定注入
	ZoneId createZoneOfZ() {
		return ZoneId.of("Z");
	}

	@Bean
	@Qualifier("utc8")
	ZoneId createZoneOfUTC8() {
		return ZoneId.of("UTC+08:00");
	}
}
