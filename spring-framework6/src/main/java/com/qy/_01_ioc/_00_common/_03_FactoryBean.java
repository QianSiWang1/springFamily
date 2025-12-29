package com.qy._01_ioc._00_common;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author qy
 * @Date 2025/12/11
 * FactoryBean 的概念和接口在 Spring 框架中被广泛使用。Spring 本身就提供了超过 50 种 FactoryBean 接口的实现。
 * <p>
 * 当您需要向容器请求一个实际的 FactoryBean 实例本身，而不是它生成的 bean 时，在调用 ApplicationContext 的 getBean() 方法时，请在 bean 的 id 前加上 & 符号。因此，对于
 * id 为 myBean 的 FactoryBean，调用 getBean("myBean") 将返回 FactoryBean 的生成 bean，而调用 getBean("&myBean") 将返回 FactoryBean 实例本身。
 */
public class _03_FactoryBean implements FactoryBean<_00_Bean> {
    @Override
    public _00_Bean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
