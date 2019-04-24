package com.qfedu.demo.springcloud.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.qfedu.demo.springclound.pojo.Orders;

@Mapper
public interface OrderMapper {
	
	Orders findById(String id);
}
