package com.qy._01_ioc._01_core_concept;

import com.qy.model.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @Author qy
 * @Date 2026/1/10
 */
public class _01_BeanDefinition {
    public static void main(String[] args) {
        testBeanDefinitionReader();
        //testAnnotatedBeanDefinitionReader();
        //testXmlBeanDefinitionReader();
        //testClassPathXmlApplicationContext();
    }

    public static void testBeanDefinitionReader() {
        //此时User上没有@Component注解，所以不会被注册到容器中
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(_00_AppConfig.class);
        // 报错，因为User没有@Component注解
        //System.out.println(context.getBean("definitionBean"));
        // 生成一个BeanDefinition对象，并设置beanClass为User.class，并注册到ApplicationContext中
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(DefinitionBean.class);
        // 设置作用域
        beanDefinition.setScope("prototype");
        // 设置初始化方法
        beanDefinition.setInitMethodName("init");
        // 设置懒加载
        beanDefinition.setLazyInit(true);
        context.registerBeanDefinition("definitionBean", beanDefinition);
        System.out.println(context.getBean("definitionBean"));

    }

    public static void testAnnotatedBeanDefinitionReader() {
        //此时User上没有@Component注解，所以不会被注册到容器中
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        // 将User.class解析为BeanDefinition
        annotatedBeanDefinitionReader.register(User.class);
        System.out.println(context.getBean("user"));
    }

    public static void testXmlBeanDefinitionReader() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_00_AppConfig.class);
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
