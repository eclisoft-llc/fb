package com.fbol.xaa;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "com.fbol.xaa.model.orm" }, annotationClass = Mapper.class)
public class XaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(XaaApplication.class, args);
	}

}
