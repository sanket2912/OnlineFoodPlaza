package com.foodplaza.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;
import com.foodplaza.pojo.Orders;

@Controller
public class CartController {
	@Autowired
	CartDaoImpl cartimpl;

	@Autowired
	FoodDaoImpl foodimpl;
	
	@RequestMapping(value="cartForm",method=RequestMethod.GET)
	public ModelAndView searchFoodByID(int foodId,HttpSession session) {
		Food food=foodimpl.getFoodById(foodId);
		//String customerEmailId="dumbresanket29@gmail.com";
		String customerEmailId=(String)session.getAttribute("customerEmail");
		int cartQuantity=1;
		double totalPrice=food.getFoodPrice()*cartQuantity;
		Cart cart=new Cart(cartQuantity, customerEmailId, food.getFoodId(), food.getFoodName(), totalPrice);
		cartimpl.addToCart(cart);
		return new ModelAndView("redirect:/cartList");
	}

	@RequestMapping(value="/cartList")
	public ModelAndView showCartList(HttpSession session) {
		//String customerEmailId="dumbresanket29@gmail.com";
		String customerEmailId=(String)session.getAttribute("customerEmail");
		List<Cart>cartlist=cartimpl.showCart(customerEmailId);
		return new ModelAndView("CartList","cartList",cartlist);
	}
	@RequestMapping(value="/deleteCart",method=RequestMethod.GET)
	public ModelAndView deleteCart(int cartId)
	{
		int row= cartimpl.deleteCart(cartId);
		return new ModelAndView("redirect:/cartList");
	}
	@RequestMapping(value="/clearCart",method=RequestMethod.GET)
	public ModelAndView clearCart(String customerEmailId) {
		cartimpl.clearCart(customerEmailId);
		return new ModelAndView("Success");
	}
	@RequestMapping(value="/editCart",method=RequestMethod.GET)
	public ModelAndView searchById(int cartId) { 
		Cart cart = cartimpl.getCartById(cartId);
		return new ModelAndView("AddCart","command",cart);
	}
	
	@RequestMapping(value="placeOrder")
	public ModelAndView placeOrder(HttpSession session,HttpServletRequest request)
	{
		String[] totalPrice = request.getParameterValues("totalPrice");
		String[] quantity = request.getParameterValues("quantity");
		double total=0;
		for(int i=0;i<totalPrice.length;i++) {
			total = total + (Double.parseDouble(totalPrice[i]))*(Integer.parseInt(quantity[i]));
		}
		request.setAttribute("total",total);
		String s = (String)session.getAttribute("customerEmail");
		String date = new Date().toString();
		Orders o = new Orders();
		o.setCustomerEmailId(s);
		o.setTotalPrice(total);
		o.setDate(date);
		int i=cartimpl.placeOrder(o);
		if(i>0) {
			cartimpl.clearCart(o.getCustomerEmailId());
		}else {
			System.out.println("could not be added to cart");
		}
		
		return new ModelAndView ("Bill","total",total);
	}

}
