package com.qfedu.demo.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
// @RefreshScope // actuator提供的注解，让用户访问/refresh时可以强制刷新配置（从配置服务器重新读取）
public class OrderFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFeignApplication.class, args);
	}

}
