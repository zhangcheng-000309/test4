package com.qfedu.demo.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// @RefreshScope // actuator提供的注解，让用户访问/refresh时可以强制刷新配置（从配置服务器重新读取）
public class OrderApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
