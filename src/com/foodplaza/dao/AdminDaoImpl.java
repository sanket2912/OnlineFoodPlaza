package com.foodplaza.dao;
import org.springframework.jdbc.core.JdbcTemplate;
public class AdminDaoImpl implements AdminDao {
public JdbcTemplate adminjdbctemplate;
public JdbcTemplate getAdminjdbctemplate() {
	return adminjdbctemplate;
}
public void setAdminjdbctemplate(JdbcTemplate adminjdbctemplate) {
	this.adminjdbctemplate=adminjdbctemplate;
}
	@Override
	public boolean adminLogin(String adminUserName, String adminPassword) {
		String sql = "select adminUserName from admin where adminUserName=? and adminPassword=?";
		String adminUserName1;
		try{
			 adminUserName1=adminjdbctemplate.queryForObject(sql,new Object[] {adminUserName,adminPassword},String.class);
		}catch(Exception e) {
			return false;
		}
		if(adminUserName1==null)
		{
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public boolean adminChangePassword(String adminUserName, String adminPassword) {
		//first way
		String sql = "update admin set adminPassword=? where adminUserName=?";
		/*
		 * int c=adminjdbctemplate.update(sql,adminPassword,adminUserName); if(c>0) {
		 * return true; }else { return false; }
		 */
		//second way
		return adminjdbctemplate.update(sql,adminPassword,adminUserName)>0;
		//third way
		//return adminjdbctemplate.update("update admin set adminPassword=? where adminUserName=?,adminPassword,adminUserName)>0;
	}

}
