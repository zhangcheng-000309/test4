package com.qfedu.demo.springcloud.order.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.demo.springcloud.order.service.OrderService;
import com.qfedu.demo.springclound.pojo.Orders;

@RestController
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	@GetMapping("/order/{id}")
	Orders get (@PathVariable("id") String id) {
		return orderService.findById(id);
	}
}
