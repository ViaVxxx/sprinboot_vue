package com.via;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.via.mapper")

// @MapperScan是用来扫描和装配 MyBatis Mappers，
// Spring Boot 会自动为这些 Mapper 接口创建代理对象，并将其注册到 Spring 容器中。

public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
