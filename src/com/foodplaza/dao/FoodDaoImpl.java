package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.foodplaza.pojo.Food;

public class FoodDaoImpl implements FoodDao {
	
public JdbcTemplate jdbcfoodtemplate;

	public JdbcTemplate getJdbcfoodtemplate() {
		return jdbcfoodtemplate;
	}
	public void setJdbcfoodtemplate(JdbcTemplate jdbcfoodtemplate) {
		this.jdbcfoodtemplate=jdbcfoodtemplate;
	}
	
	@Override
	public int addFood(Food food) {
		String sql = "insert into food(foodName,foodType,foodCategory,foodPrice) values (?,?,?,?)";
		return jdbcfoodtemplate.update(sql,food.getFoodName(),food.getFoodType(),food.getFoodCategory(),food.getFoodPrice());
	}

	@Override
	public int updateFood(Food food) {
		String sql = "update food set foodName=?, foodType=?,foodCategory=?,foodPrice=? where foodId=?";
		return jdbcfoodtemplate.update(sql,food.getFoodName(),food.getFoodType(),food.getFoodCategory(),food.getFoodPrice(),food.getFoodId());
	}

	@Override
	public int deleteFood(int foodId) {
		String sql = "delete from food where foodId=?";
		return jdbcfoodtemplate.update(sql,foodId);
	}

	@Override
	public Food getFoodById(int foodId) {
		String sql ="select * from food where foodId=?";
		return jdbcfoodtemplate.queryForObject(sql, new Object[] {foodId},new RowMapper<Food>() {

			@Override
			public Food mapRow(ResultSet rs, int num) throws SQLException {
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodPrice(rs.getDouble(5));
				return f;
			}
			
		});
	}

	@Override
	public List<Food> getAllFoods() {
		String getAll ="select * from food";
		return jdbcfoodtemplate.query(getAll, new RowMapper<Food>() {

			@Override
			public Food mapRow(ResultSet rs, int num) throws SQLException {
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodPrice(rs.getDouble(5));
				return f;
			}
			
		});
	}
	@Override
	public List<Food> searchByFoodType(String foodType) {
		String sql= "select * from food where foodType like ?";
		return jdbcfoodtemplate.query(sql,new Object[] {"%"+ foodType +"%"},new RowMapper<Food>() {

			@Override
			public Food mapRow(ResultSet rs, int num) throws SQLException {
				Food f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodPrice(rs.getDouble(5));
				return f;
			}
			
		});
	}
	@Override
	public List<Food> searchByCategory(String foodCategory) {
		String sql = "select * from food where foodCategory like ?";
		return jdbcfoodtemplate.query(sql,new Object[] {"%"+ foodCategory +"%"},new RowMapper<Food>() {

			@Override
			public Food mapRow(ResultSet rs, int num) throws SQLException {
				Food f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodPrice(rs.getDouble(5));
				return f	;
			}
			
		});
	}
	@Override
	public List<Food> searchFoodByName(String foodName) {
		String sql ="select * from food where foodName like ?";
		return jdbcfoodtemplate.query(sql, new Object[] {"%"+foodName +"%"},new RowMapper<Food>() {

			@Override
			public Food mapRow(ResultSet rs, int num) throws SQLException {
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodPrice(rs.getDouble(5));
				return f;
			}
			
		});
	}


}
