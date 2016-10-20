package com.sample.spring.app2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	private String orderDesc;
	private String orderQty;
	private String orderPrice;

	public Order() {
	}

	public Order(String orderDesc, String orderQty, String orderPrice) {
		this.orderDesc = orderDesc;
		this.orderQty = orderQty;
		this.orderPrice = orderPrice;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public Order(String orderDesc, String orderQty) {

		this.orderDesc = orderDesc;

	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

}
