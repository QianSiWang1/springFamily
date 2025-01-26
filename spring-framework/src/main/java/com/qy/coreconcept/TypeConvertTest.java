package com.qy.coreconcept;

import com.qy.service.User;
import com.qy.service.UserService;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;

public class TypeConvertTest {
    public static void main(String[] args) {
        //test();
        //test2();
        //testConversionService();
        testTypeConverter();
    }

    public static void test(){
        StringToUserPropertyEditor propertyEditor = new StringToUserPropertyEditor();
        propertyEditor.setAsText("1");
        User value = (User) propertyEditor.getValue();
        System.out.println(value);
    }

    public static void test2(){
        // 创建一个Spring容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //在AppConfig中配置了类型转换器，所以@Value("${test}")可以自动注入
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }

    public static void testConversionService(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToUserConverter());
        User value = conversionService.convert("1", User.class);
        System.out.println(value);
    }

    public static void testTypeConverter(){
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        typeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
        //typeConverter.setConversionService(conversionService);
        User value = typeConverter.convertIfNecessary("1", User.class);
        System.out.println(value);
    }
}
