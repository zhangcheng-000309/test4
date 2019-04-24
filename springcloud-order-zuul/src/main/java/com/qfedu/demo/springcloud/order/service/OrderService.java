package com.qfedu.demo.springcloud.order.service;

import com.qfedu.demo.springclound.pojo.Orders;

public interface OrderService {

	Orders findById (String id);
}
