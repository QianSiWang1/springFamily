package com.qy._01_ioc._09_inject._01_qualifier;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _05_MixedInject implements InitializingBean {
    private final _00_InnerBean innerBean;


    @Autowired
    @Qualifier("firstInnerBean")
    private _00_InnerBean innerBeanTwo;

    @Autowired
    public _05_MixedInject(@Qualifier("secondInnerBean") _00_InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_05_MixedInject ===> _00_InnerBean innerBean : " + innerBean.getName());
        System.out.println("_05_MixedInject ===> _00_InnerBeanTwo innerBean : " + innerBeanTwo.getName());
    }
}
