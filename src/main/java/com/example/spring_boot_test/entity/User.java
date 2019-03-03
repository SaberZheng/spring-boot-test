package com.example.spring_boot_test.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: aimiguo
 * @Date: 2018/10/8
 * @Time: 17:34
 * Description:
 */
@Component//要使用这个注解，这样就可以在 component scan时候被发现了，不然会无法自动注入，
@PropertySource({"classpath:/my.properties"})//注意路径的书写格式
@ConfigurationProperties(prefix = "user")
public class User {
    String nikename;
    int age;

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
