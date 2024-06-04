package com.ssafit.model.dto;

import java.util.Date;

public class Review {
	private int reviewId;
	private int videoId;
	private String userId;
	private String title;
	private String content;
	private String regDate;

	public Review() {
	}

	public Review(int reviewId, int videoId, String userId, String title, String content, String regDate) {
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
}
