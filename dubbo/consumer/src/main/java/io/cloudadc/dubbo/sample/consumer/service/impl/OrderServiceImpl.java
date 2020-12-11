package io.cloudadc.dubbo.sample.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import io.cloudadc.dubbo.sample.api.UserService;
import io.cloudadc.dubbo.sample.consumer.service.Order;
import io.cloudadc.dubbo.sample.consumer.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private UserService userService;

	@Override
	public Order initOrder(Integer userId) {
		return new Order("orderID", "order", userService.getUserAddress(userId));
	}

}
