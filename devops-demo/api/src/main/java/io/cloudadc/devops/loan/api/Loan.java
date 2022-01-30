package io.cloudadc.devops.loan.api;

import java.io.Serializable;

public class Loan implements Serializable {

	private static final long serialVersionUID = -3320256766624498177L;
	
	private Integer id;
	
	private String user;
	
	private String phone;

	public Loan() {
		super();
	}

	public Loan(Integer id, String user, String phone) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsers() {
		return user;
	}

	public void setUsers(String user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", user=" + user + ", phone=" + phone + "]";
	}

}
