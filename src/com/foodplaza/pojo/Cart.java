package com.foodplaza.pojo;

public class Cart {
	private int cartId;
	private int cartQuantity;
	private String customerEmailId;
	private int foodId;
	private String foodName;
	private double totalPrice;
	
	public Cart(int cartQuantity, String customerEmailId, int foodId, String foodName, double totalPrice) {
		super();
		this.cartQuantity = cartQuantity;
		this.customerEmailId = customerEmailId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.totalPrice = totalPrice;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int i) {
		this.foodId = i;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartQuantity=" + cartQuantity + ", customerEmailId=" + customerEmailId
				+ ", foodId=" + foodId + ", foodName=" + foodName + ", totalPrice=" + totalPrice + "]";
	}
	
}
