# Resource
This exercise from  
[定制Bean - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/1252599548343744/1308043627200545)
# NOTE:
## Scope:
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 使用prototype来将默认的singleton模式切换成工厂factory模式，每次调用bean容器都会返回一个实例。  


## 注入List
### Interface Validator:

validator的接口，为了便于扩展，定义一个接口：  
之后有三个接口相同, 实现不同的类来实现这个接口：EmailValidator, NameValidator, PasswordValidator这三者可以使用@Order来确定list中的排序
最后有一个Validators作为入口验证：  

### Validators:  

这里Validators被注入了一个List<Validator>,   
Spring会自动装配所有类别为Validator的bean，  
之后再新增其他的Validator类型也不用怕，可以被直接再这里装配

## 忽略组件注入，可选注入：
MailService:  
```java
@Autowired(required = false) // 如果没有找到ZoneId这个bean，就忽略，不加required = false则会报错  
ZoneId zoneId = ZoneId.systemDefault();
```

## @Bean 注解创建第三方bean
AppConfig.java @Bean注解,注意这种bean只调用一次，还是单例模式
  
## 使用@PostConstruct 和 @PreDestroy初始化和清理方法上标记
MailService

## 别名 @Qualifier("xxxx") @Primary 
```java
	@Primary // 如果外部注入的时候没有使用别名，那么默认使用primary的bean注入
	@Qualifier("z") // 使用别名z指定这个bean，外面注入的时候可以使用别名指定注入
```


# TASK: