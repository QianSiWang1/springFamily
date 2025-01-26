package com.qy.coreconcept;

import com.qy.service.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class BeanDefinitionTest {
    public static void main(String[] args) {
        testAnnotatedBeanDefinitionReader();
        //testXmlBeanDefinitionReader();
        //testClassPathXmlApplicationContext();
    }
    public static void testBeanDefinitionReader() {
        //此时User上没有@Component注解，所以不会被注册到容器中
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);
        // 生成一个BeanDefinition对象，并设置beanClass为User.class，并注册到ApplicationContext中
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setScope("prototype"); // 设置作用域
        beanDefinition.setInitMethodName("init"); // 设置初始化方法
        beanDefinition.setLazyInit(true); // 设置懒加载
        context.registerBeanDefinition("user", beanDefinition);
        System.out.println(context.getBean("user"));
    }

    public static void testAnnotatedBeanDefinitionReader() {
        //此时User上没有@Component注解，所以不会被注册到容器中
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        // 将User.class解析为BeanDefinition
        annotatedBeanDefinitionReader.register(User.class);
        System.out.println(context.getBean("user"));
    }

    public static void testXmlBeanDefinitionReader() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        int i = beanDefinitionReader.loadBeanDefinitions("spring.xml");
        System.out.println(context.getBean("user"));
    }

    public static void testClassPathXmlApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
        scanner.scan("com.qy");
        System.out.println(context.getBean("userService"));
    }

}
