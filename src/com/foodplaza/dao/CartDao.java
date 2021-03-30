package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Orders;

public interface CartDao {
	int addToCart(Cart cart);
	List<Cart> showCart(String customerEmailId);
	int deleteCart(int cartId);
	int clearCart(String customerEmailId);
	int placeOrder(Orders orders);
	Cart getCartById(int cartId);
}
