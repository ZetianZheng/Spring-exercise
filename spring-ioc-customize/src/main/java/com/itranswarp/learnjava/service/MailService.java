package com.itranswarp.learnjava.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired(required = false) // 如果没有找到ZoneId这个bean，就忽略，不加required = false则会报错
	ZoneId zoneId = ZoneId.systemDefault();

	@PostConstruct // 初始化，在构造方法和@Autowired 注入后面执行
	public void init() {
		System.out.println("Init mail service with zoneId = " + this.zoneId);
	}

	@PreDestroy // 清理方法，销毁周期之前执行
	public void shutdown() {
		System.out.println("Shutdown mail service");
	}

	public String getTime() {
		return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
	}

	public void sendLoginMail(User user) {
		System.err.println(String.format("Hi, %s! You are logged in at %s", user.getName(), getTime()));
	}

	public void sendRegistrationMail(User user) {
		System.err.println(String.format("Welcome, %s!", user.getName()));

	}
}
