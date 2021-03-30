package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.foodplaza.pojo.Orders;

public class OrderDaoImpl implements OrderDao {
	private JdbcTemplate orderjdbctemplate;
	public JdbcTemplate getOrderjdbctemplate() {
		return orderjdbctemplate;
	}
	public void setOrderjdbctemplate(JdbcTemplate orderjdbctemplate) {
		this.orderjdbctemplate=orderjdbctemplate;
	}
	@Override
	public Orders placeOrder(Orders orders) {
		orderjdbctemplate.update("insert into orders(customerEmailId,totalPrice,date) values(?,?,?)",orders.getCustomerEmailId(),orders.getTotalPrice(),orders.getDate());
		return
				orderjdbctemplate.queryForObject("select * from orders where customerEmailId=?",new Object[] {orders.getCustomerEmailId()},new RowMapper<>() {
					@Override 
					public Orders mapRow(ResultSet rs, int arg1) throws SQLException {
						Orders o=new Orders();
						o.setOrderId(rs.getInt(1));
						o.setCustomerEmailId(rs.getString(2));
						o.setTotalPrice(rs.getDouble(3));
						o.setDate(rs.getString(4));
						
						return o;
					}

				});

	}

	@Override
	public List<Orders> showOrder() {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public Orders getOrderByEmailId(String customerEmailId){
//	return	orderjdbctemplate.queryForObject("select * from orders where customerEmailId=?",new Object[] {customerEmailId},new RowMapper<>() {
//
//		@Override
//		public Orders mapRow(ResultSet rs, int arg1) throws SQLException {
//			Orders o=new Orders();
//			o.setOrderId(rs.getInt(1));
//			o.setCustomerEmailId(rs.getString(2));
//			o.setTotalPrice(rs.getDouble(3));
//			o.setDate(rs.getString(4));
//			return o;
//		}
//			
//		});
//				
//	}

}
