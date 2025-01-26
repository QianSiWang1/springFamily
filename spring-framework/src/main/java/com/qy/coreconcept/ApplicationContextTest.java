package com.qy.coreconcept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

public class ApplicationContextTest {
    public static void main(String[] args) throws IOException {
        //testResourceLoad();
        //testGetRuntimeProperty();
        testPublishEvent();
    }

    public static void testResource(){
        //todo 这边没有效果
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String message = context.getMessage("test", null, null);
        System.out.println(message);

    }

    public static void testResourceLoad() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Resource resource = context.getResource("file:D:\\KnowledgeRepository\\AllJavaProject\\springFamily\\spring-framework\\src\\main\\java\\com\\qy\\service\\User.java");
        System.out.println(resource.contentLength());
        System.out.println(resource.getFilename());
        Resource resource1 = context.getResource("https://www.baidu.com");
        System.out.println(resource1.contentLength());
        System.out.println(resource1.getURL());
        Resource resource2 = context.getResource("classpath:spring.xml");
        System.out.println(resource2.contentLength());
        System.out.println(resource2.getURL());
    }

    public static void testGetRuntimeProperty(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println(systemEnvironment);
        System.out.println("=======");
        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
        System.out.println(systemProperties);
        System.out.println("=======");
        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        System.out.println(propertySources);
        System.out.println("=======");
        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
        //通过@PropertySource注解加载的配置文件
        System.out.println(context.getEnvironment().getProperty("qianyu"));
    }

    public static void testPublishEvent(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent("new MyEvent(context)");
    }

}
