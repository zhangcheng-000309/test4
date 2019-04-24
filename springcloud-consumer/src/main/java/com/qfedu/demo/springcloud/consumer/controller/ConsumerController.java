package com.qfedu.demo.springcloud.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.demo.springcloud.consumer.service.ConsumerService;
import com.qfedu.demo.springclound.pojo.Consumer;

@RestController
public class ConsumerController {
	
	@Resource
	private ConsumerService consumerService;
	
	@GetMapping("/consumer/{id}")
	Consumer get (@PathVariable("id") String id) {
		return consumerService.findById(id);
	}
}
