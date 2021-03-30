package com.foodplaza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

@Controller
public class FoodController {

		@Autowired
		FoodDaoImpl foodimpl; 
		
		/*
		 * @RequestMapping(value="/showFoodForm",method=RequestMethod.GET) public String
		 * showFoodForm(Model m) { m.addAttribute("command",new Food()); return
		 * "AddFood"; }
		 */
		
		@RequestMapping(value="/foodForm",method=RequestMethod.GET)
		public ModelAndView showFoodForm(@ModelAttribute("food")Food food) {
			return new ModelAndView("AddFood","command",food);
		}
		@RequestMapping(value="/saveFood", method=RequestMethod.POST)
		public ModelAndView save(@RequestAttribute("food")Food food) {
			foodimpl.addFood(food);
			return new ModelAndView("redirect:/foodList");
		}
		@RequestMapping(value="/foodUpdateForm",method=RequestMethod.GET)
		public ModelAndView showFoodupdateForm(@RequestAttribute("food")Food food) {
			return new ModelAndView("UpdateFood","command",food);
		}
		@RequestMapping(value="/updatefood",method=RequestMethod.POST)
		public String updateFood(@ModelAttribute("food")Food food) {
			foodimpl.updateFood(food);
			return "Success";
		}
		@RequestMapping(value="/foodList",method=RequestMethod.GET)
		public ModelAndView getFood() {
		List<Food>flist = foodimpl.getAllFoods();
		return new ModelAndView("FoodList","foodList",flist);
		}
		@RequestMapping(value="/editFood")
		public ModelAndView	searchFoodById(int foodId) {
		Food f=foodimpl.getFoodById(foodId);
		return new ModelAndView("UpdateFood","command",f);
		}
		@RequestMapping(value="/deleteFood")
		public String deleteFood(int foodId){
			int row=foodimpl.deleteFood(foodId);
			if(row>0) {
				return "Success";
			}else {
				return "/showFodList";
			}
		}
		@RequestMapping(value="/searchByFoodType",method=RequestMethod.GET)
		public ModelAndView searchByFoodType(String foodType) {
			List<Food> foodList=foodimpl.searchByFoodType(foodType);
			return new ModelAndView("FoodList","foodList",foodList);
		}
		@RequestMapping(value="/searchByCategory",method=RequestMethod.GET)
		public ModelAndView searchByCategory(String foodCategory) {
			List<Food>foodList=foodimpl.searchByCategory(foodCategory);
			return new ModelAndView("FoodList","foodList",foodList);
		}
		@RequestMapping(value="/displayIndex",method=RequestMethod.GET)
		public ModelAndView displayIndex() {
			return new ModelAndView("index");
		}
		
		
		@RequestMapping(value="/searchFoodByName",method=RequestMethod.GET)
		public ModelAndView searchByName() {
			return new ModelAndView("SearchFood");
		}
		@RequestMapping(value="/searchFoodForm",method=RequestMethod.POST)
		public ModelAndView searchByNameForm(String foodName) {
			List<Food>foodList=foodimpl.searchFoodByName(foodName);
			return new ModelAndView("FoodList","foodList",foodList);
		}
}
