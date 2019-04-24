package com.qfedu.demo.springcloud.order.controller;

import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qfedu.demo.springcloud.order.service.OrderService;
import com.qfedu.demo.springclound.pojo.Orders;

@RestController
public class OrderController {

	private Logger LOG = LoggerFactory.getLogger(OrderController.class);

	@Resource
	private OrderService orderService;

	@GetMapping("/order/{id}")
	@HystrixCommand // (fallbackMethod = "getOrderFallback")
	// @HystrixCommand(commandProperties = {
	// 		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
//	@HystrixCommand(
//            threadPoolKey = "ordergetthreadpool",
//            threadPoolProperties =
//                    {@HystrixProperty(name = "coreSize",value="30"),
//                     @HystrixProperty(name="maxQueueSize", value="10")}
//    )
	Orders get(@PathVariable("id") String id) {
		// 随机sleep三秒
		if (new Random().nextBoolean()) {
			LOG.info("sleep...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderService.findById(id);
	}

	/**
	 * 服务降级方法
	 * 
	 * @param id
	 * @return
	 */
	private Orders getOrderFallback(String id) {
		return new Orders();
	}
}
