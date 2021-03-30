package com.foodplaza.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.AdminDaoImpl;
import com.foodplaza.dao.CustomerDaoImpl;

@Controller
public class LoginController {
	@Autowired
	CustomerDaoImpl customerimpl;
	
	@Autowired
	AdminDaoImpl adminimpl;
	@RequestMapping("loginpage")
	public String getLoginPage()
	{
		return "Login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)	
	public ModelAndView getIndexPage(HttpServletRequest request,HttpSession session) {
		String type=request.getParameter("type");
		String userEmail=request.getParameter("customerEmailId");
		String pass= request.getParameter("customerPassword");
		if(type.equals("user")) {
			if(customerimpl.customerLogin(userEmail, pass)) {
				session.setAttribute("customerEmail",userEmail);
				session.setAttribute("password", pass);
				return new ModelAndView("index","msg","<b style=color:green;align:center;>login Successfull !!</b>");
			}
		}
		if(type.equals("admin")) {
			if(adminimpl.adminLogin(userEmail, pass)) {
				session.setAttribute("adminEmail",userEmail);
				session.setAttribute("password", pass);
				return new ModelAndView("index","msg","<b style=color:green;align:center;>login Successfull !!</b>");
			}
		}
		return new ModelAndView("Login","msg","<b style=color:red;align:center;>login Failed !!</b>");
	}
	@RequestMapping("resetpassword")
	public String getResetPage() {
		return "ResetPassword";
	}
	@RequestMapping(value="changePass",method=RequestMethod.POST)
	public ModelAndView changePassSuccess(HttpServletRequest request,HttpSession session) {
		String type=request.getParameter("type");
		String emailId=request.getParameter("email");
		String pass= request.getParameter("pass");
		if(type.equals("user")) {
			if(customerimpl.customerChangePassword(emailId, pass)) {
				return new ModelAndView("index","msg","<b style=color:green;align:center;>PassWord Changed Successfull !!</b>");
			}
		}
		if(type.equals("admin")) {
			if(adminimpl.adminChangePassword(emailId, pass)) {
				return new ModelAndView("index","msg","<b style=color:green;align:center;>PassWord Changed Successfull !!</b>");
			}
		}
		return new ModelAndView("ResetPassword","msg","<b style=color:red;align:center;>Password Change Failed !!</b>");
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public ModelAndView logoutmethod(HttpSession session) {
		String name=(String)session.getAttribute("customerEmail");
		if(name==null) {
			name=(String)session.getAttribute("adminEmail");
		}
		session.invalidate();
		return new ModelAndView("index","msg","<b style=color:green;>logout successfull "+name +"</b>");
	}
}

