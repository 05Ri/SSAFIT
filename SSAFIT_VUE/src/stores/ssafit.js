import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const SSAFIT_REST_API = `http://localhost:8080/ssafit-api`
export const useSsafitStore = defineStore('ssafit', () => {
  
  // 영상 목록
  const videoList = ref([])
  const getVideoList = function() {
    axios.get(SSAFIT_REST_API + '/video')
    .then((response) => {
      videoList.value = response.data
    })
  }

  // 오름차순으로
  const getAscendingVideos = function() {
    axios.get(SSAFIT_REST_API + '/video/view-cnt')
    .then((response) => {
      videoList.value = response.data
    })
  }

  // 운동 부위별로
  const getPartVideos = function(part) {
    axios.get(SSAFIT_REST_API + `/video/search/${part}`)
    .then((response) => {
      videoList.value = response.data
    })
  }

  // 비디오 상세
  const video = ref({})
  const getVideo = function(vid) {
    axios.get(`${SSAFIT_REST_API}/video/${vid}`)
    .then((response) => {
      video.value = response.data
    })
  }

  // 리뷰 생성
  const createReview = function (review, vid) {
    axios({
      url: SSAFIT_REST_API + `/review/${vid}`,
      method: 'POST',
      data: review,
    })
    .then(() => {
      alert("리뷰 등록 성공")
      router.push({name: 'videoDetail', params: {vid: vid}})
    })
    .catch((err) => {
      alert("리뷰 등록 실패")
    })
  }

  // 리뷰 목록
  const reviewList = ref([])
  const getReviewList = function(vid) {
    axios.get(SSAFIT_REST_API + `/review/${vid}`)
    .then((response) => {
      reviewList.value = response.data
    })
  }

  // 리뷰 상세
  const review = ref({})
  const getReview = function(vid, rid) {
    axios.get(`${SSAFIT_REST_API}/review/${vid}/${rid}`)
    .then((response) => {
      review.value = response.data
    })
  }
  
  // 리뷰 수정
  const modifyReview = function(review, vid, rid) {
    axios.put(`${SSAFIT_REST_API}/review/${vid}/${rid}`, review)
    .then((response) => {
      router.push({name: 'videoDetail', params: {vid: vid}})
      alert("리뷰 수정 성공")
    })
  }

  // 로그인
  const loginUser = ref(null);
  const login = function(user) {
    axios({
      url: SSAFIT_REST_API + `/user`,
      method: 'get',
      params: {
        userId: user.userId,
        password: user.password,
      }
    })
    .then((response) => {
      alert("로그인 성공")
      localStorage.setItem("loginUser", JSON.stringify(response.data)) // 로그인 유지
      loginUser.value = response.data;
      router.push({name: 'home'})
    })
    .catch(()=>{
      alert("로그인 실패")
    })
  }

  //로그아웃
  const logout = function() {
    localStorage.removeItem("loginUser")
    loginUser.value = null;
    alert("로그아웃 성공")
    router.go() // 현재 페이지를 새로고침
  }

  // 회원가입
  const regist = function(user) {
    axios.post(SSAFIT_REST_API + `/user`, user)
    .then((response) => {
      alert("회원가입 성공")
      router.push({name: 'login'})
    })
    .catch(()=>{
      alert("회원가입 실패")
    })
  }


  return {
    videoList,
    getVideoList,
    getAscendingVideos,
    getPartVideos,
    video,
    getVideo,
    createReview,
    reviewList,
    getReviewList,
    review,
    getReview,
    modifyReview,
    login,
    logout,
    regist,
    loginUser,
  }
})
