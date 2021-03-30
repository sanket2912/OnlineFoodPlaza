package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Orders;

public class CartDaoImpl implements CartDao {
	private JdbcTemplate cartjdbctemplate;
	public JdbcTemplate getCartjdbctemplate() {
		return cartjdbctemplate;
	}
	public void setCartjdbctemplate(JdbcTemplate cartjdbctemplate) {
		this.cartjdbctemplate= cartjdbctemplate;
	}
	
	@Override
	public int addToCart(Cart cart) {
		String sql = "insert into cart(cartQuantity,customerEmailId,foodId,foodName,totalPrice) values(?,?,?,?,?)";
		return cartjdbctemplate.update(sql,cart.getCartQuantity(),cart.getCustomerEmailId(),cart.getFoodId(),cart.getFoodName(),cart.getTotalPrice());
	}

	@Override
	public List<Cart> showCart(String customerEmailId) {
		String sql = "select * from cart where customerEmailId=?";
		return cartjdbctemplate.query(sql, new Object[] {customerEmailId}, new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int num) throws SQLException {
				Cart cart=new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setCartQuantity(rs.getInt(2));
				cart.setCustomerEmailId(customerEmailId);
				cart.setFoodId(rs.getInt(4));
				cart.setFoodName(rs.getString(5));
				cart.setTotalPrice(rs.getDouble(6));
				return cart;
			}
			
		});
	}

	@Override
	public int deleteCart(int cartId) {
		String sql = "delete from cart where cartId=?";
		return cartjdbctemplate.update(sql,cartId);
	}

	@Override
	public int clearCart(String customerEmailId) {
		String sql = "delete from cart where customerEmailId=?";
		return cartjdbctemplate.update(sql,customerEmailId);
	}
	@Override
	public int placeOrder(Orders orders) {
		return cartjdbctemplate.update("insert into orders(customerEmailId,totalPrice,date) values(?,?,?)",orders.getCustomerEmailId(),orders.getTotalPrice(),orders.getDate());
	}
	@Override
	public Cart getCartById(int cartId) {
		return cartjdbctemplate.queryForObject("select * from cart where cartId=?",new Object[] {cartId},new RowMapper<>() {

			@Override
			public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
				Cart cart=new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setCartQuantity(rs.getInt(2));
				cart.setCustomerEmailId(rs.getString(3));
				cart.setFoodId(rs.getInt(4));
				cart.setFoodName(rs.getString(5));
				cart.setTotalPrice(rs.getDouble(6));
				return cart;
			}
			
		});
	}

}
