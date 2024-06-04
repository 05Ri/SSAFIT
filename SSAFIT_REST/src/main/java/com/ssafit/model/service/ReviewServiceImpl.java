package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafit.model.dao.ReviewDao;
import com.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewDao dao;

    public ReviewServiceImpl(ReviewDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Review> getReviewList(int videoId) {
        return dao.selectByVideoId(videoId);
    }

    @Override
    public Review getReviewDetail(int reviewId) {
        return dao.selectByReviewId(reviewId);
    }

    @Override
    public int writeReview(Review review) {
        return dao.insertReview(review);
    }

	@Override
	public int modifyReview(Review review) {
		return dao.updateReview(review);
	}

	@Override
	public int removeReview(int reviewId) {
		return dao.deleteReview(reviewId);
	}
    
}