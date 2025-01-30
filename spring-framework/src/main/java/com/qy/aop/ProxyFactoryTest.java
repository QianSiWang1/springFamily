package com.qy.aop;

import com.qy.aop.service.BirdService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class ProxyFactoryTest {
    public static void main(String[] args) {
        BirdService birdService = new BirdService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(birdService);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("before");
            }
        });
//        proxyFactory.addAdvisor(new PointcutAdvisor() {
//            @Override
//            public Pointcut getPointcut() {
//                return new StaticMethodMatcherPointcut() {
//                    @Override
//                    public boolean matches(Method method, Class<?> aClass) {
//                        return method.getName().equals("fly");
//                    }
//                };
//            }
//
//            @Override
//            public Advice getAdvice() {
//                return new MethodBeforeAdvice() {
//                    @Override
//                    public void before(Method method, Object[] objects, Object o) throws Throwable {
//                        System.out.println("before");
//                    }
//                };
//            }
//
//            @Override
//            public boolean isPerInstance() {
//                return false;
//            }
//        });
        BirdService proxy = (BirdService) proxyFactory.getProxy();
        proxy.fly();

    }
}
