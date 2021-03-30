package com.foodplaza.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.foodplaza.pojo.Feedback;

public class FeedbackDaoImpl implements FeedbackDao {
	private JdbcTemplate feedbacktemplate;
	public JdbcTemplate getFeedbacktemplate() {
		return feedbacktemplate;
	}
	public void setFeedbacktemplate(JdbcTemplate feedbacktemplate) {
		this.feedbacktemplate=feedbacktemplate;
	}
	@Override
	public int addFeedback(Feedback feedback) {
		String sql="insert into feedback(customerName,customerEmailId,review,suggestion)values(?,?,?,?)";
		return feedbacktemplate.update(sql,feedback.getCustomerName(),feedback.getCustomerEmailId(),feedback.getReview(),feedback.getSuggestion());
	}

	@Override
	public boolean getOurFeedback() {
		// TODO Auto-generated method stub
		return false;
	}

}
