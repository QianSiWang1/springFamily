package com.qy._01_ioc._01_core_concept;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * @Author qy
 * @Date 2026/1/14
 */
public class _04_ApplicationContext {
    public static void main(String[] args) throws InterruptedException {
        //testGetRuntimeProperty();
        testPublishEvent();
    }

    /**
     *  国际化
     *  需要创建messages.properties文件，并配置内容
     *  并且需要要注入MessageSource bean
     */
    public static void testInternational() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
        String message = context.getMessage("test", null, null);
        System.out.println(message);
        String message1 = context.getMessage("test", null, new Locale("en"));
        System.out.println(message1);
    }

    /**
     * 加载资源
     */
    public static void testLoadResource() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
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
    /**
     * 获取运行时属性
     */
    public static void testGetRuntimeProperty(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
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

    /**
     * 发布事件
     */
    public static void testPublishEvent() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
        context.publishEvent("new MyEvent(context)");

        Thread.sleep(5000);
    }
}
