package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	VideoDao dao;
	
	@Autowired
	public VideoServiceImpl(VideoDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Video> getVideoList() {
		return dao.selectAll();
	}

	@Override
	public Video getVideo(int id) {
		dao.updateViewCnt(id);
		
		return dao.selectOne(id);
	}

	@Override
	public List<Video> getPartVideoList(String part) {
		return dao.selectPart(part);
	}

	@Override
	public List<Video> getDescendingVideoList() {
		return dao.sortDescending();
	}
	
}
