package com.qy._01_ioc._09_inject._00_common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

/**
 * @Author qy
 * @Date 2025/12/13
 */
@Component
public class _10_NullableInject {
    _00_InnerBean innerBean;

    @Autowired
    public void setInnerBeanMap(@Nullable _00_InnerBean innerBean) {
        this.innerBean = innerBean;
    }
}
