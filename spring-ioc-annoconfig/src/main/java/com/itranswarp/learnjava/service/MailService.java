package com.itranswarp.learnjava.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired // 这是field inject，不推荐，但是教学一下第三方bean的注入
	@Qualifier("utc8")
	ZoneId zoneId = ZoneId.systemDefault();

	@Autowired
	@Qualifier("Z")
	ZoneId zoneId2 = ZoneId.systemDefault();

	public MailService() {

		this.zoneId = ZoneId.systemDefault();
	}

	public String getTime() {
		return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
	}

	public String getZTime(){ return ZonedDateTime.now(this.zoneId2).format(DateTimeFormatter.ISO_ZONED_DATE_TIME); }

	public void sendLoginMail(User user) {
		System.err.println(String.format("Hi, %s! You are logged in at %s, and the z time is %s", user.getName(), getTime(), getZTime()));
	}

	public void sendRegistrationMail(User user) {
		System.err.println(String.format("Welcome, %s!", user.getName()));

	}
}
