package com.cabinet.Cabinet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.cabinet.Cabinet.src.main.resources.mappers"}) //인터페이스를 인식할 수 있도록 설정
public class CabinetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabinetApplication.class, args);
	}

}
