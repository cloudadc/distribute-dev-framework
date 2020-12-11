package io.cloudadc.dubbo.sample.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cloudadc.dubbo.sample.consumer.service.Order;
import io.cloudadc.dubbo.sample.consumer.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(produces = {"application/json", "application/xml"})
@Tag(name = "order", description = "The order API")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@RequestMapping(path = {"/api/initOrder"}, method = {RequestMethod.GET})
	@Operation(summary = "Get order by uid", description = "Return order")
	public Order initOrder(@RequestParam("uid") @Parameter(description = "uid", required = true)Integer userId) {
		return orderService.initOrder(userId);
	}
}
