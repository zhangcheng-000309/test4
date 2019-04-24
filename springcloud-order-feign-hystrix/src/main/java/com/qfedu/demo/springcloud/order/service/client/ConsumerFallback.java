package com.qfedu.demo.springcloud.order.service.client;

import org.springframework.stereotype.Component;

import com.qfedu.demo.springclound.pojo.Consumer;

@Component
public class ConsumerFallback implements ConsumerFeignClient {

	@Override
	public Consumer getConsumer(String id) {
		return new Consumer();
	}

}
