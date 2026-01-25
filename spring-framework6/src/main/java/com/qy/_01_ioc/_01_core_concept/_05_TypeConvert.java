package com.qy._01_ioc._01_core_concept;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * 类型转换
 * @Author qy
 * @Date 2026/1/17
 */
public class _05_TypeConvert {


    public static void main(String[] args) {
        //testPropertyEditor();
        //testConversionService();
        testTypeConverter();
    }

    /**
     * PropertyEditor
     */
    public static void testPropertyEditor(){
        _05_String2UserPropertyEditor propertyEditor = new _05_String2UserPropertyEditor();
        propertyEditor.setAsText("1");
        ConvertUser value = (ConvertUser) propertyEditor.getValue();
        System.out.println(value);
    }

    /**
     * DefaultConversionService
     */
    public static void testConversionService(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new _05_String2UserConverter());
        ConvertUser value = conversionService.convert("1", ConvertUser.class);
        System.out.println(value);
    }

    /**
     * SimpleTypeConverter
     */
    public static void testTypeConverter(){

        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        //typeConverter.registerCustomEditor(ConvertUser.class, new _05_String2UserPropertyEditor());

        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new _05_String2UserConverter());
        typeConverter.setConversionService(conversionService);

        ConvertUser value = typeConverter.convertIfNecessary("1", ConvertUser.class);
        System.out.println(value);
    }
}
