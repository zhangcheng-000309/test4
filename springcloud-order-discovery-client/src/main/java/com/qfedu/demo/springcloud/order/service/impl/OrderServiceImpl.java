package com.qfedu.demo.springcloud.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

	@Resource
	private OrderMapper orderMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Resource
	private DiscoveryClient discoveryClient;

	private Consumer getConsumer(String id) {
		// 从注册中心，获取微服务信息
		List<ServiceInstance> si = discoveryClient.getInstances("consumerservice");
		if (si.size() == 0) {
			return null;
		}
		String rootUrl = si.get(0).getUri().toString();
		// 根据微服务实际地址进行调用
		ResponseEntity<Consumer> restExchange = restTemplate.exchange(rootUrl + "/consumer/{id}", HttpMethod.GET, null,
				Consumer.class, id);
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
