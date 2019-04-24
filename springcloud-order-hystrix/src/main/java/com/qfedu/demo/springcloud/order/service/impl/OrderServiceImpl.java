package com.qfedu.demo.springcloud.order.service.impl;

import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.qfedu.demo.springcloud.order.mapper.OrderMapper;
import com.qfedu.demo.springcloud.order.service.OrderService;
import com.qfedu.demo.springclound.pojo.Consumer;
import com.qfedu.demo.springclound.pojo.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Resource
	private OrderMapper orderMapper;

	@Autowired
	private RestTemplate restTemplate;

	private Consumer getConsumer(String id) {
		// 根据微服务名称进行调用，实际是通过ribbon进行调用
		ResponseEntity<Consumer> restExchange = 
			restTemplate.exchange("http://consumerservice/consumer/{id}",
				HttpMethod.GET, null, Consumer.class, id);
		return restExchange.getBody();
	}

	@Override
	public Orders findById(String id) {
		// 查询本地数据库，获取订单
		Orders o = orderMapper.findById(id);
		// 调用远程RESTful接口，获取客户
		Consumer c = this.getConsumer(o.getConsumerId());
		// 将客户设置到订单中，并返回
		o.setConsumer(c);
		return o;
	}

}
