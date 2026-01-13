package com.qy._01_ioc._01_core_concept;

import com.qy.model.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @Author qy
 * @Date 2026/1/13
 */
public class _02_BeanDefinitionReader {
    public static void main(String[] args) {
        //testBeanDefinitionReader();
        //testClassPathBeanDefinitionScanner();
        testXmlBeanDefinitionReader();
    }

    public static void testBeanDefinitionReader() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        annotatedBeanDefinitionReader.register(User.class);
        // AnnotationConfigApplicationContext创建时，传参会自动调用refresh方法？不传参 需要手动refresh一下？
        context.refresh();
        System.out.println(context.getBean("user"));
    }

    public static void testXmlBeanDefinitionReader() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        int i = beanDefinitionReader.loadBeanDefinitions("spring-bean-definition-reader.xml");
        context.refresh();
        System.out.println(context.getBean("user"));
    }

    public static void testClassPathBeanDefinitionScanner() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
        scanner.scan("com.qy._01_ioc._01_core_concept");
        System.out.println(context.getBean("commonBean"));
    }
}
