package io.cloudadc.dubbo.userservice.api;

import java.io.Serializable;

public class UserAddress implements Serializable {

	private static final long serialVersionUID = -3320256766624498177L;
	
	private Integer id;
	
	private String userAddress;
	
	private String phone;

	public UserAddress() {
		super();
	}

	public UserAddress(Integer id, String userAddress, String phone) {
		super();
		this.id = id;
		this.userAddress = userAddress;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", userAddress=" + userAddress + ", phone=" + phone + "]";
	}

}
