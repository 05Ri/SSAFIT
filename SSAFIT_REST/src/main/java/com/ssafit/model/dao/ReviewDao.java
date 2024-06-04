package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Review;

public interface ReviewDao {
    
    List<Review> selectByVideoId(int id);
    
    Review selectByReviewId(int id);

    int insertReview(Review review);

	int updateReview(Review review);

	int deleteReview(int reviewId);
}