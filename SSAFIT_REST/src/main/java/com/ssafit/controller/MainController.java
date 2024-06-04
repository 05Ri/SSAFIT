package com.ssafit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Review;
import com.ssafit.model.dto.User;
import com.ssafit.model.dto.Video;
import com.ssafit.model.service.ReviewService;
import com.ssafit.model.service.UserService;
import com.ssafit.model.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="SSAFIT Rest Controller", description="운동영상 및 의견 공유를 위한 API")
@RequestMapping("/ssafit-api")
@CrossOrigin
public class MainController {

	UserService uService;
	VideoService vService;
	ReviewService rService;

	public MainController(UserService uService, VideoService vService, ReviewService rService) {
		this.uService = uService;
		this.vService = vService;
		this.rService = rService;
	}

	@GetMapping("/user")
	@Operation(summary = "회원 로그인", description = "아이디와 비밀번호 값을 받아서 일치하면 로그인 가능")
	public ResponseEntity<?> login(@ModelAttribute User user) {
		System.out.println(user);
		
		if (user.getUserId() == null || user.getPassword() == null) {
			return new ResponseEntity<String>("정보미입력", HttpStatus.BAD_REQUEST);
		}

		System.out.println(user.getUserId() + " " + user.getPassword() + " " + user.getName());

		User loginUser = uService.getUser(user);
		if (loginUser == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		System.out.println(loginUser);
		return new ResponseEntity<User>(loginUser, HttpStatus.OK);
	}

	@PostMapping("/user")
	@Operation(summary = "유저 회원가입", description = "새로운 유저 등록")
	public ResponseEntity<?> signup(@RequestBody User user) {
		if (user.getUserId() == null || user.getPassword() == null || user.getName() == null) {
			return new ResponseEntity<String>("정보미입력", HttpStatus.BAD_REQUEST);
		}

		System.out.println(user.getUserId() + " " + user.getPassword() + " " + user.getName());

		if (uService.signUp(user) == 0) {
			return new ResponseEntity<String>("ID중복", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// 영상 전체 가져오기
	@GetMapping("/video")
	@Operation(summary = "모든 영상 가져오기", description = "모든 운동 영상들을 가져온다.")
	public ResponseEntity<?> getAllVideos() {
		List<Video> list = vService.getVideoList();

		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 영상 상세보기
	@GetMapping("/video/{id}")
	@Operation(summary = "영상 상세보기", description = "메인 화면에서 영상 하나를 클릭하면 영상정보를 가져온다.")
	public ResponseEntity<?> getVideoDetail(@PathVariable("id") int id) {
		Video video = vService.getVideo(id);

		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}

	// 영상 부위별로 가져오기
	@GetMapping("/video/search/{part}")
	@Operation(summary = "운동 부위 별 영상", description = "운동하고자 하는 부위에 맞게 영상을 가져온다")
	public ResponseEntity<?> getPartVideos(@PathVariable("part") String part) {
		List<Video> list = vService.getPartVideoList(part);

		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 영상 조회수 순으로 가져오기
	@GetMapping("/video/view-cnt")
	@Operation(summary = "영상 조회수 많은 순", description = "으로 가져오기")
	public ResponseEntity<?> getAscendingVideos() {
		List<Video> list = vService.getDescendingVideoList();

		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 리뷰 리스트 가져오기
	@GetMapping("/review/{videoId}")
	@Operation(summary = "영상 하나 가져올 때 그 영상에 달린 댓글들", description = "을 가져온다.")
	public ResponseEntity<?> getReviewList(@PathVariable("videoId") int videoId) {
		List<Review> reviews = rService.getReviewList(videoId);
		if (reviews == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
	}

	// 리뷰 상세보기
	@GetMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "댓글들 중 하나를 선택하면", description = "댓글 상세정보를 가져온다")
	public ResponseEntity<?> getReviewDetail(@PathVariable("videoId") int videoId,
			@PathVariable("reviewId") int reviewId) {
		Review review = rService.getReviewDetail(reviewId);
		if (review == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 리뷰 등록
	@PostMapping("/review/{videoId}")
	@Operation(summary = "댓글 등록", description = "제목, 유저, 내용을 입력받아서 등록한다.")
	public ResponseEntity<?> writeReview(@RequestBody Review review, @PathVariable("videoId") int videoId) {
		review.setVideoId(videoId);
		rService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 리뷰 수정
	@PutMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "댓글 수정", description = "제목과 내용을 받아서 수정한다.")
	public ResponseEntity<?> modifyReview(@RequestBody Review review, @PathVariable("videoId") int videoId, @PathVariable("reviewId") int reviewId) {
		review.setVideoId(videoId);
		review.setReviewId(reviewId);
		rService.modifyReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 리뷰 삭제
	@DeleteMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "댓글 삭제", description = "자세하게 본 해당 댓글을 삭제한다")
	public ResponseEntity<?> deleteReview(@PathVariable("videoId") int videoId, @PathVariable("reviewId") int reviewId) {
		rService.removeReview(reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}