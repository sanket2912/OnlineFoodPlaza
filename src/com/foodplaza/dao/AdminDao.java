package com.foodplaza.dao;

public interface AdminDao {
	boolean adminLogin(String adminUserName, String adminPassword);
	boolean adminChangePassword(String adminUserName,String adminPassword);
}
