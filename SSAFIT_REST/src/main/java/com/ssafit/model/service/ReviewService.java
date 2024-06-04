package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Review;

public interface ReviewService {
    
    List<Review> getReviewList(int videoId);
    
    Review getReviewDetail(int reviewId);

    int writeReview(Review review);

	int modifyReview(Review review);

	int removeReview(int reviewId);
}