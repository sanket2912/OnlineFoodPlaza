package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

public interface FoodDao {
	int addFood(Food food);
	int updateFood(Food food);
	int deleteFood(int foodId);
	Food getFoodById(int foodId);
	List<Food>getAllFoods();
	List<Food> searchByFoodType(String foodType);
	List<Food> searchByCategory(String foodCategory);
	List<Food> searchFoodByName(String foodName);
}
