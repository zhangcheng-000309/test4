package com.qfedu.demo.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 本应用通过eureka客户端到eureka注册中心注册
// @RefreshScope // actuator提供的注解，让用户访问/refresh时可以强制刷新配置（从配置服务器重新读取）
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
