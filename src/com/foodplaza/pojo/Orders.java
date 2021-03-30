package com.foodplaza.pojo;

public class Orders {
	private int orderId;
	private String customerEmailId;
	private double totalPrice;
	private String date;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerEmailId=" + customerEmailId + ", totalPrice=" + totalPrice
				+ ", date=" + date + "]";
	}
	
}
