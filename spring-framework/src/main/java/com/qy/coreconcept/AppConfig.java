package com.qy.coreconcept;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Collections;

@ComponentScan("com.qy")
@PropertySource("classpath:spring.properties")
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

/*    @Bean
    public ApplicationListener applicationListener() {
        return new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("接收到了一个事件");
            }
        };
    }*/

//    @Bean
//    public CustomEditorConfigurer customEditorConfigurer() {
//        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
//        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
//
//        // 表示StringToUserPropertyEditor可以将String转化成User类型，在Spring源码中，如果发现当前对象是String，而需要的类型是User，就会使用该PropertyEditor来做类型转化
//        propertyEditorMap.put(User.class, StringToUserPropertyEditor.class);
//        customEditorConfigurer.setCustomEditors(propertyEditorMap);
//        return customEditorConfigurer;
//    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));
        return conversionServiceFactoryBean;
    }
}
