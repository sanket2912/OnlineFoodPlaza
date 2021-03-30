package com.foodplaza.pojo;

public class Feedback {
	private int feedbackId;
	private String customerName;
	private String customerEmailId;
	private String review;
	private String suggestion;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", review=" + review + "]";
	}
	
}

//feedback pojo -feedbackId, customerName, customerEmailId, review,suggestion
//feedback table

