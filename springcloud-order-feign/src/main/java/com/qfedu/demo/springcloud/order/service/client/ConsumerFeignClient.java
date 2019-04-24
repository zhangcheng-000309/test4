package com.qfedu.demo.springcloud.order.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qfedu.demo.springclound.pojo.Consumer;

@FeignClient("consumerservice") // 指定本接口对应的远程微服务
public interface ConsumerFeignClient {
	// 映射远程微服务接口
	@RequestMapping(value="/consumer/{id}", consumes = "application/json", method = RequestMethod.GET)
	Consumer getConsumer(@PathVariable("id")String id);
}
