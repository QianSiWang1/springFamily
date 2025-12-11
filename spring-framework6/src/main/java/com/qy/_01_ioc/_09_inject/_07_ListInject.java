package com.qy._01_ioc._09_inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author qy
 * @Date 2025/12/11
 */
@Component
public class _07_ListInject implements InitializingBean {
    private Set<_00_InnerBean> innerBeans;

    @Autowired
    public void setMovieCatalogs(Set<_00_InnerBean> innerBeans) {
        this.innerBeans = innerBeans;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("_07_ListInject ===> _00_InnerBean innerBean : " + innerBeans);
    }
}
