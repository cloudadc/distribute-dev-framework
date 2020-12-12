package io.cloudadc.dubbo.userservice.consumer.service;

import java.io.Serializable;
import java.util.List;

import io.cloudadc.dubbo.userservice.api.UserAddress;

public class Order implements Serializable {

	private static final long serialVersionUID = -5751520443848005068L;
	
	private String id;
	
	private String name;
	
	private List<UserAddress> userAddress;
	
	public Order() {}

	public Order(String id, String name, List<UserAddress> userAddress) {
		super();
		this.id = id;
		this.name = name;
		this.userAddress = userAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

}
