package com.example.spring_boot_test;

import com.example.spring_boot_starter_hello.HelloService;
import com.example.spring_boot_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@SpringBootApplication//开启自动配置
public class SpringBootTestApplication {

    @Autowired
    private User user;

    @Resource
    private HelloService helloService;

    //通过@Value注入值
    @Value("${my.username}")
    private String userName;

    public static void main(String[] args) {
        //关闭banner
		/*SpringApplication springApplication = new SpringApplication(SpringBootTestApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);*/
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

    @RequestMapping("/")
    String index() {
        System.out.println(user.getNikename() + ":" + user.getAge());
        return "hello " + userName + " spring boot !!!";
    }

    @RequestMapping("hello")
    String hello() {
        return helloService.sayHello();
    }
}

