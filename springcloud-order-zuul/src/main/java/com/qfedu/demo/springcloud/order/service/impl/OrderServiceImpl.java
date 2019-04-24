package com.qfedu.demo.springcloud.order.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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

	/**
	 * 直接调用客户服务地址
	 */
	private final static String CONSUMER_URL = "http://consumerservice/consumer/{id}";

	/**
	 * 通过zuul路由服务器自动路由到客户服务地址
	 */
	private final static String CONSUMER_URL_ZUUL = "http://zuulservice/consumerservice/consumer/{id}";

	/**
	 * 通过zuul路由服务器手动路由到客户服务地址，需要在zuulservice.yml中配置
	 */
	private final static String CONSUMER_URL_ZUUL_NO_AUTO = "http://zuulservice/myconsumer/consumer/{id}";

	/**
	 * 通过zuul路由服务器静态路由到客户服务地址，需要在zuulservice.yml中配置
	 */
	private final static String CONSUMER_URL_ZUUL_STATIC = "http://zuulservice/mystaticconsumer/consumer/{id}";
	
	/**
	 * 通过zuul路由服务器api路由到客户服务地址，需要在zuulservice.yml中配置
	 */
	private final static String CONSUMER_URL_ZUUL_API = "http://zuulservice/api/consumerservice/consumer/{id}";
	
	private Consumer getConsumer(String id) {
		// 根据微服务名称进行调用，实际是通过ribbon进行调用
		ResponseEntity<Consumer> restExchange = restTemplate.exchange(CONSUMER_URL_ZUUL_STATIC, HttpMethod.GET, null,
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
