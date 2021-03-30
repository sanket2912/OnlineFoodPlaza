package com.foodplaza.pojo;

public class Customer {
	private String customerEmailId;
	private String customerName;
	private String customerPassword;
	private String customerAddress;
	private String customerContact;
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	@Override
	public String toString() {
		return "Customer [customerEmailId=" + customerEmailId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", customerAddress=" + customerAddress + ", customerContact=" + customerContact
				+"]";
	}


	
}
