package com.lhy.mybatis1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;


//@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.lhy.mybatis1.mapper")
@EnableScheduling
public class Mybatis1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis1Application.class, args);
	}

//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
}
