package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoDao {

	// 모든 영상 가져오기
	List<Video> selectAll();

	// 영상 id와 일치하는 영상 가져오기
	Video selectOne(int id);

	// 부위별 영상들 가져오기
	List<Video> selectPart(String part);

	List<Video> sortDescending();

	void updateViewCnt(int id);
	
}
