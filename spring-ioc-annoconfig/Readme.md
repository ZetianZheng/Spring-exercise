# Resource:
This exercise from  
[廖雪峰的官方网站/Spring开发/IOC原理/使用Annotation配置](https://www.liaoxuefeng.com/wiki/1252599548343744/1282382596407330)
# NOTE:
## 常用bean注解
使用annotation 的:   
**@Component**定义bean,  
**@Autowired** 自动装配bean
---
## Appconfig
再生成一个配置文件**AppConfig**.   
注意目录结构，这个文件一般在最顶层  

**@Configuration**:  
这个配置文件需要一个**@Configuration** 注解表示它是配置类:  
因为我们需要再main中：AnnotationConfigApplicationContext(AppConfig.class) 使用它(参数必须是一个有@Configuration的 class)  

**@ComponentScan**:  
其次去生成bean配置和注入文件，   
我们需要一个注解让他们自动扫描，  
所以在这个配置文件中会有一个 **@ComponentScan** 去扫描所有的 **@Component**注解生成的bean和他们之间的注入关系。



# TASK:
如果我们想给UserService注入HikariDataSource，但是这个类位于com.zaxxer.hikari包中，并且HikariDataSource也不可能有@Component注解，如何告诉IoC容器创建并配置HikariDataSource？或者换个说法，如何创建并配置一个第三方Bean？

使用@Bean注解，可以创建第三方的bean,详见：   
[Spring-exercise/spring-ioc-customize at master · ZetianZheng/Spring-exercise](https://github.com/ZetianZheng/Spring-exercise/tree/master/spring-ioc-customize)


```java
// Appconfig:
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
```
mailService:
```java
@Component
public class MailService {

	@Autowired // 这是field inject，不推荐，但是教学一下第三方bean的注入
	@Qualifier("utc8")
	ZoneId zoneId = ZoneId.systemDefault();

	@Autowired
	@Qualifier("Z")
	ZoneId zoneId2 = ZoneId.systemDefault();

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
```

