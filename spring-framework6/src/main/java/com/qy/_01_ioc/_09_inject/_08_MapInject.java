package com.qy._01_ioc._09_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author qy
 * @Date 2025/12/12
 */
@Component
public class _08_MapInject {

    /**
     * Map注入 key为Bean的名称，value为Bean对象
     */
    Map<String, _00_InnerBean> innerBeanMap;

    @Autowired
    public void setInnerBeanMap(Map<String, _00_InnerBean> innerBeanMap) {
        this.innerBeanMap = innerBeanMap;
    }
}
