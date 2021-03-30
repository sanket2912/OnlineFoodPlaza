package com.foodplaza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;

@Controller
public class CustomerController {
	@Autowired
	CustomerDaoImpl customerimpl;
	
	@RequestMapping(value="/customerForm",method=RequestMethod.GET)
	public ModelAndView showCustomerForm(@ModelAttribute("customer")Customer customer) {
		return new ModelAndView("AddCustomer","command",customer);
	}
	
	@RequestMapping(value="/savecustomer",method=RequestMethod.POST)
	public String addCustomer(@RequestAttribute("customer")Customer customer) {
		customerimpl.addCustomer(customer);
		return "Success";
	}
	
	@RequestMapping(value="customerUpdateForm",method=RequestMethod.GET)
	public ModelAndView showCustomerUpdateForm(@RequestAttribute("customer")Customer customer) {
		return new ModelAndView("UpdateCustomer","command",customer);
	}
	
	@RequestMapping(value="updateCustomer",method=RequestMethod.POST)
	public String  updateCustomer(@ModelAttribute("customer")Customer customer) {
		customerimpl.updateCustomer(customer);
		return "Success";
	}
	@RequestMapping(value="customerList",method=RequestMethod.GET)
	public ModelAndView showCustomerList() {
		List<Customer>custlist=customerimpl.getAllCustomer();
		return new ModelAndView("CustomerList","customerList",custlist);
	}
	
	@RequestMapping(value="/editCustomer",method=RequestMethod.GET)
	public ModelAndView getCustomerByEmailId(String customerEmailId) {
		Customer cust=customerimpl.getCustomerByEmailId(customerEmailId);
		return new ModelAndView("UpdateCustomer","command",cust);
	}
	@RequestMapping(value="deleteCustomer",method=RequestMethod.GET)
	public String deleteCustomer(String customerEmailId) {
		int row=customerimpl.deleteCustomer(customerEmailId);//keep that in mind customerEmailId should not be in double quotes
		if(row>0) {
			return "Success";
		}else {
			return"UpdateCustomer";
		}
	}
	
	@RequestMapping(value="/customerLogin",method=RequestMethod.GET)
	public ModelAndView customerLog(@RequestAttribute("customer")Customer customer) {
		return new ModelAndView("CustomerLogin","command",customer);
	}
	
	@RequestMapping(value="/cLogin",method=RequestMethod.POST)
	public ModelAndView cLoginSuccess(@ModelAttribute("customer")Customer customer) {
		customerimpl.customerLogin(customer.getCustomerName(), customer.getCustomerPassword());
		return new ModelAndView("redirect:/foodList");
	}
}


 