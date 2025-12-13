package com.qy._01_ioc._09_inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author qy
 * @Date 2025/12/13
 */
@Configuration
public class _00_InjectConfiguration {
    @Bean
    public _00_InnerBean firstInnerBean() {
        _00_InnerBean innerBean = new _00_InnerBean();
        innerBean.setName("firstInnerBean");
        return innerBean;
    }

    @Bean
    @Primary
    //@Fallback ?
    public _00_InnerBean secondInnerBean() {
        _00_InnerBean innerBean = new _00_InnerBean();
        innerBean.setName("secondInnerBean");
        return innerBean;
    }
}
