package com.foodplaza.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;

@Controller
public class LoginController {
	@Autowired
	CustomerDaoImpl loginimpl;
	@RequestMapping("loginpage")
	public ModelAndView getLoginPage()
	{
		return new ModelAndView("Login","cust",new Customer());
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView getIndexPage(@ModelAttribute("cust")Customer c,HttpSession session) {
		boolean flag = false;
		if(c.getType().equals("user")) {
			if(loginimpl.customerLogin(c.getCustomerEmailId(),c.getCustomerPassword())) {
				session.setAttribute("cust", c);
				flag = true;
			}
		}
		else if (c.getType().equals("admin")) {
			if(loginimpl.customerLogin(c.getCustomerEmailId(),c.getCustomerPassword())) {
				session.setAttribute("cust", c);
				flag=true;
			}
		}
		
		if(flag) {
			return new ModelAndView("index","success","Welcome"+c.getCustomerEmailId());
		}else {
			session.setAttribute("failure","Invalid Credentials!! Login again !!!");
			return new ModelAndView("redirect:/Login");
		}
	}
}
