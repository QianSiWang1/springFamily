package com.qy.aop;

import com.qy.aop.advice.MyAroundAdvice;
import com.qy.aop.service.BirdService;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周瑜
 */
@Configuration
public class BeanNameAutoProxyCreatorDemo {

	@Bean
	public BirdService birdService() {
		return new BirdService();
	}

	@Bean
	public MyAroundAdvice myAroundAdvise() {
		return new MyAroundAdvice();
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("birdS*");
		beanNameAutoProxyCreator.setInterceptorNames("myAroundAdvise");
		beanNameAutoProxyCreator.setProxyTargetClass(true);
		return beanNameAutoProxyCreator;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(BeanNameAutoProxyCreatorDemo.class);

		BirdService birdService = applicationContext.getBean("birdService", BirdService.class);
		birdService.fly();
	}
}
