package com.foodplaza.dao;

import com.foodplaza.pojo.Feedback;

public interface FeedbackDao {
	int addFeedback(Feedback feedback);
	boolean getOurFeedback();
}
//model attribute , modelandview ,request,redirect