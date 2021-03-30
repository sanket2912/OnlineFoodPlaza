package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Orders;

public interface OrderDao {
	Orders placeOrder(Orders orders);
	List<Orders> showOrder();	
//	Orders getOrderByEmailId(String customerEmailId);
}
