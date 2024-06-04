package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoService {

	List<Video> getVideoList();

	Video getVideo(int id);

	List<Video> getPartVideoList(String part);

	List<Video> getDescendingVideoList();

}
