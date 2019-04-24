package com.qfedu.demo.springcloud.consumer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.demo.springcloud.consumer.mapper.ConsumerMapper;
import com.qfedu.demo.springcloud.consumer.service.ConsumerService;
import com.qfedu.demo.springclound.pojo.Consumer;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService {

	@Resource
	private ConsumerMapper consumerMapper;
	
	@Override
	public Consumer findById(String id) {
		return consumerMapper.findById(id);
	}

}
