package com.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.foodplaza.dao.AdminDaoImpl;
import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;
import com.foodplaza.pojo.Orders;

public class Test {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
		AdminDaoImpl adminimpl = new AdminDaoImpl();

		String adminUserName;
		String adminPassword;

		Scanner sc= new Scanner(System.in);
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		CustomerDaoImpl customerimpl = (CustomerDaoImpl)context.getBean("customerTemplate");
		Customer customer= null;
		String customerEmailId;
		String customerName;
		String customerPassword;
		String customerAddress;
		String customerContact;

		FoodDaoImpl foodimpl = (FoodDaoImpl)context.getBean("foodTemplate");
		Food food=null;
		int foodId;
		String foodName;
		String foodType;
		String foodCategory;
		int foodPrice;
		
		OrderDaoImpl orderimpl = new OrderDaoImpl();
		boolean istrue;
		int b;
		int choice;
		System.out.println("1.admin login\n2.customer login");
		int login=sc.nextInt();
		if(login==1) {
			System.out.println("Enter admin name");
			adminUserName=br.readLine();
			System.out.println("Enter admin password");
			adminPassword=br.readLine();
			boolean isadmin=adminimpl.adminLogin(adminUserName, adminPassword);
			if(isadmin) {
				System.out.println("1.Manage Food\n2.Manage Orders\n3.Change password");
				int select=sc.nextInt();
				if(select==1) {
					
					do {
						System.out.println("1.add food\n2.update food\n3.delete food\n4.get food by Id\n5.get all food items");
						choice=sc.nextInt();
						switch(choice) {
						case 1: {
							System.out.println("Enter food Name");
							foodName=br.readLine();
							System.out.println("Enter food Type");
							foodType=br.readLine();
							System.out.println("Enter food Category");
							foodCategory=br.readLine();
							System.out.println("Enter food Price");
							foodPrice=sc.nextInt();
							food=new Food();
							food.setFoodName(foodName);
							food.setFoodType(foodType);
							food.setFoodCategory(foodCategory);
							food.setFoodPrice(foodPrice);

							b=foodimpl.addFood(food);
							if(b>0) {
								System.out.println("Food added successfully");
							}else {
								System.out.println("Food does not added successfully");
							}
						}
						break;
						case 2:{
							System.out.println("Enter food Name");

							foodName=br.readLine();
							System.out.println("Enter food Type");
							foodType=br.readLine();
							System.out.println("Enter food Category");
							foodCategory=br.readLine();
							System.out.println("Enter food Price");
							foodPrice=sc.nextInt();
							food=new Food();
							food.setFoodName(foodName);
							food.setFoodType(foodType);
							food.setFoodCategory(foodCategory);
							food.setFoodPrice(foodPrice);

							b=foodimpl.updateFood(food);
							if(b>0) {
								System.out.println("Food updated successfully");
							}else {
								System.out.println("Food does not updated successfully");
							}
						}
						break;
						case 3:
							System.out.println("Enter the food Id to delete food");
							foodId=sc.nextInt();
							b=foodimpl.deleteFood(foodId);
							if(b>0) {
								System.out.println("food deleted successfully");
							}else {
								System.out.println("Food does not deleted");
							}
							break;
						case 4:
							System.out.println("Enter the food Id");
							foodId=sc.nextInt();
							food=foodimpl.getFoodById(foodId);
							System.out.println(food);
							break;
						case 5:
							List<Food> foodlist=foodimpl.getAllFoods();
							Iterator<Food> it = foodlist.iterator();
							while(it.hasNext()) {
								System.out.println(it.next());
							}
							break;

						}

					}while(choice>0);
				}else if(select==2){
					System.out.println("1.place order\n2.show orders");
					System.out.println("Enter your choice:");
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter EmailId of customer");
						customerEmailId=br.readLine();
						//List<Orders>orders=orderimpl.placeOrder(customerEmailId);
						//System.out.println(orders);
						break;
					case 2:
						System.out.println("Orders: ");
						System.out.println(orderimpl.showOrder());
						break;
					}
					
				}else if(select==3) {
					System.out.println("1.Change password");
					adminPassword=br.readLine();
					istrue=adminimpl.adminChangePassword(adminUserName, adminPassword);
					if(istrue) {
						System.out.println("Password changed successfully");
					}else {
						System.out.println("Password does not changed.");
					}
				}


			}
		}else if(login==2) {
			System.out.println("Enter customer name: ");
			customerName=br.readLine();
			System.out.println("Enter customer password: ");
			customerPassword = br.readLine();
			boolean isCustomer=customerimpl.customerLogin(customerName, customerPassword);
			if(isCustomer) {
				System.out.println("\n1.Add Customer\n2.Update Customer\n3.DeleteCustomer\n4.Search Customer\n5.All Customers\n6.Change customer password\n7.Exit");
				System.out.println("\n Enter the Choice");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter the customer Name");
					customerName=br.readLine();
					System.out.println("Enter the customer password");
					customerPassword=br.readLine();
					System.out.println("Enter the customer email Id");
					customerEmailId=br.readLine();
					System.out.println("Enter the customer Contact No");
					customerContact=br.readLine();
					System.out.println("Enter the customer Address");
					customerAddress=br.readLine();
					customer=new Customer();
					customer.setCustomerEmailId(customerEmailId);
					customer.setCustomerName(customerName);
					customer.setCustomerPassword(customerPassword);
					customer.setCustomerAddress(customerAddress);
					customer.setCustomerContact(customerContact);
					b=customerimpl.addCustomer(customer);
					if(b>0) {
						System.out.println("Customer added Successfully.");
					}else {
						System.out.println("Customer does not added.");
					}
					break;
				case 2:
					System.out.println("Enter the customer Name");
					customerName=br.readLine();
					System.out.println("Enter the customer password");
					customerPassword=br.readLine();
					System.out.println("Enter the customer email Id");
					customerEmailId=br.readLine();
					System.out.println("Enter the customer Contact No");
					customerContact=br.readLine();
					System.out.println("Enter the customer Address");
					customerAddress=br.readLine();
					customer=new Customer();
					customer.setCustomerEmailId(customerEmailId);
					customer.setCustomerName(customerName);
					customer.setCustomerPassword(customerPassword);
					customer.setCustomerAddress(customerAddress);
					customer.setCustomerContact(customerContact);
					b=customerimpl.updateCustomer(customer);
					if(b>0) {
						System.out.println("Customer updated Successfully.");
					}else {
						System.out.println("Customer does not updated.");
					}
					break;
				case 3:
					System.out.println("Enter customer Email Id");
					customerEmailId=br.readLine();
					b=customerimpl.deleteCustomer(customerEmailId);
					if(b>0) {
						System.out.println("Customer deleted successfully.");
					}else {
						System.out.println("Customer does not deleted");
					}
					break;
				case 4:
					System.out.println("Enter customer Email Id");
					customerEmailId=br.readLine();
					customer=customerimpl.getCustomerByEmailId(customerEmailId);
					if(customer!=null) {
						System.out.println(customer);
					}else {
						System.out.println("customer does not exist.");
					}
					break;
				case 5:
//					List<Customer>alist=customerimpl
					
					break;
				case 6:
					System.out.println("Enter customer Name:");
					customerName=br.readLine();
					System.out.println("Etner customer Password");
					customerPassword=br.readLine();
					istrue=customerimpl.customerChangePassword(customerName, customerPassword);
					if(istrue) {
						System.out.println("Customer password changed successfully");
					}else {
						System.out.println("Coul'd not change customer password.");
					}
					break;
				}

			}
		}


	}

}
