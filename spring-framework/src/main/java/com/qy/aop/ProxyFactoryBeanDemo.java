package com.qy.aop;

import com.qy.aop.advice.MyAroundAdvice;
import com.qy.aop.service.BirdService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周瑜
 */
@Configuration
@ComponentScan("com.qy.aop.service")
public class ProxyFactoryBeanDemo {


	@Bean
	public MyAroundAdvice myAroundAdvice() {
		return new MyAroundAdvice();
	}


	@Bean
	public ProxyFactoryBean birdService() {
		BirdService birdService = new BirdService();
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyTargetClass(false);
		proxyFactoryBean.setTarget(birdService);
		proxyFactoryBean.setInterceptorNames("myAroundAdvice");
		return proxyFactoryBean;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ProxyFactoryBeanDemo.class);
		BirdService userService = applicationContext.getBean("birdService", BirdService.class);
		userService.fly();
	}
}
