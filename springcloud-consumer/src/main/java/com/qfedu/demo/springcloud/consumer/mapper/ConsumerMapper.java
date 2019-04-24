package com.qfedu.demo.springcloud.consumer.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.qfedu.demo.springclound.pojo.Consumer;

@Mapper
public interface ConsumerMapper {
	
	Consumer findById (String id);
}
