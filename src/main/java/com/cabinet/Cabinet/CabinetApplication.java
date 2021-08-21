package com.cabinet.Cabinet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(value= {"com.cabinet.Cabinet.mapper.boardMapper"}) //인터페이스를 인식할 수 있도록 설정
public class CabinetApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(CabinetApplication.class, args);
		final SpringApplicationBuilder builder = new SpringApplicationBuilder(CabinetApplication.class);

		// beanNameGenerator 를 등록한다.
		builder.beanNameGenerator(new BeanNameGenerator() {
			
			@Override
			public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		builder.run(args);
	}

}
