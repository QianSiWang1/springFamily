package com.qy._01_ioc._00_common;

import com.qy.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _01_Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User)applicationContext.getBean("user");
        user.hello();
    }
}
