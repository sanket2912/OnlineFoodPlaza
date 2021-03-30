package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.foodplaza.pojo.Customer;
public class CustomerDaoImpl implements CustomerDao {
	public JdbcTemplate customerjdbctemplate;
	public JdbcTemplate getCustomerjdbctemplate() {
		return customerjdbctemplate;
	}
	public void setCustomerjdbctemplate(JdbcTemplate customerjdbctemplate) {
		this.customerjdbctemplate=customerjdbctemplate;
	}
	@Override
	public int addCustomer(Customer customer) {
		String sql = "insert into customer values (?,?,?,?,?)";
		return customerjdbctemplate.update(sql,customer.getCustomerEmailId(),customer.getCustomerName(),customer.getCustomerPassword(),customer.getCustomerAddress(),customer.getCustomerContact());
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql ="update customer set customerName=?,customerPassword=?,customerAddress=?,customerContact=? where customerEmailId=?";
		return customerjdbctemplate.update(sql,customer.getCustomerName(),customer.getCustomerPassword(),customer.getCustomerAddress(),customer.getCustomerContact(),customer.getCustomerEmailId());
	}

	@Override
	public int deleteCustomer(String customerEmailId) {
		String sql="delete from customer where customerEmailId=?";
		return customerjdbctemplate.update(sql,customerEmailId);
	}

	@Override
	public Customer getCustomerByEmailId(String customerEmailId) {
		String sql="select * from customer where customerEmailId=?";
		
		return customerjdbctemplate.queryForObject(sql,new Object[] {customerEmailId} , new RowMapper<Customer>(){

			@Override
			public Customer mapRow(ResultSet rs, int num) throws SQLException {
				Customer cust=new Customer();
				cust.setCustomerEmailId(rs.getString(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerPassword(rs.getString(3));
				cust.setCustomerAddress(rs.getString(4));
				cust.setCustomerContact(rs.getString(5));
				return cust;
			}
			
		});
	}

	@Override
	public boolean customerLogin(String customerEmailId, String customerPassword) {
		String sql = "select customerName from customer where customerEmailId=? and customerPassword=?";
		Object customerName1;
		try{
			 customerName1=customerjdbctemplate.queryForObject(sql,new Object[] {customerEmailId,customerPassword},Object.class);
		}catch(Exception e) {
			return false;
		}
		if(customerName1==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean customerChangePassword(String customerEmailId, String customerPassword) {
		String sql = "update customer set customerPassword=? where customerEmailId=?";
		int c=customerjdbctemplate.update(sql,customerPassword,customerEmailId);
		if(c>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Customer> getAllCustomer() {
		String sql="select * from customer";
		
		return customerjdbctemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int num) throws SQLException {
				Customer c=new Customer();
				c.setCustomerEmailId(rs.getString(1));
				c.setCustomerName(rs.getString(2));
				c.setCustomerPassword(rs.getString(3));
				c.setCustomerAddress(rs.getString(4));
				c.setCustomerContact(rs.getString(5));
				return c;
			}
			
		});
	}

}
