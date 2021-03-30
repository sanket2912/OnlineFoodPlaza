package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

public interface CustomerDao {
	int addCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(String customerEmailId);
	Customer getCustomerByEmailId(String customerEmailId);
	List<Customer>getAllCustomer();
	boolean customerLogin(String customerName, String customerPassword);
	boolean customerChangePassword(String customerName, String customerPassword);

}
