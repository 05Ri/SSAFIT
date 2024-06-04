package com.ssafit.model.dto;

public class Video {
	private int videoId;
	private String url;
	private String title;
	private String part;
	private int viewCnt;

	public Video() {
	}

	public Video(int videoId, String url, String title, String part, int viewCnt) {
		this.videoId = videoId;
		this.url = url;
		this.title = title;
		this.part = part;
		this.viewCnt = viewCnt;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", url=" + url + ", title=" + title + ", part=" + part + ", viewCnt="
				+ viewCnt + "]";
	}

}