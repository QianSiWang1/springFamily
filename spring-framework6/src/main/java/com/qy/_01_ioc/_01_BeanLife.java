package com.qy._01_ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author qy
 * @Date 2025/12/9
 */
@Component
public class _01_BeanLife implements InitializingBean, DisposableBean, LifecycleProcessor, ApplicationContextAware, BeanNameAware {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(_00_AppConfig.class);
        applicationContext.registerShutdownHook();
        applicationContext.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLife.InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanLife.DisposableBean.destroy");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("BeanLife.PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanLife.PreDestroy");
    }

    @Override
    public void onRefresh() {
        System.out.println("BeanLife.LifecycleProcessor.onRefresh");
    }

    @Override
    public void onClose() {
        System.out.println("BeanLife.LifecycleProcessor.onClose");
    }

    @Override
    public void start() {
        System.out.println("BeanLife.LifecycleProcessor.start");
    }

    @Override
    public void stop() {
        System.out.println("BeanLife.LifecycleProcessor.stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanLife.BeanNameAware.setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("BeanLife.ApplicationContextAware.setApplicationContext");
    }
}
