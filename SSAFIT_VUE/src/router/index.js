import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegistView from '../views/RegistView.vue'
import AllVideoView from '../views/AllVideoView.vue'
import ASCVideoView from '../views/ASCVideoView.vue'
import PartVideoView from '../views/PartVideoView.vue'

import VideoDetail from '@/components/video/VideoDetail.vue'

import ReviewDetail from '@/components/review/ReviewDetail.vue'
import ReviewCreate from '@/components/review/ReviewCreate.vue'
import ReviewUpdate from '@/components/review/ReviewUpdate.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/regist',
      name: 'regist',
      component: RegistView,
    },
    {
      path: '/video',
      name: 'allVideo',
      component: AllVideoView,
    },
    {
      path: '/video/view-cnt',
      name: 'ascVideo',
      component: ASCVideoView,
    },
    {
      path: '/video/search/:part',
      name: 'partVideo',
      component: PartVideoView,
    },
    {
      path: '/video/:vid',
      name: 'videoDetail',
      component: VideoDetail,
    },
    {
      path: '/review/:vid',
      name: 'reviewCreate',
      component: ReviewCreate,
      beforeEnter: (to, from)=> {
        // 로그인 되어있지 않은 경우
        if (!localStorage.getItem ('loginUser')) {
          alert("로그인이 필요한 페이지입니다.")
          return false;
        }

      }
    },
    {
      path: '/review/:vid/:rid',
      name: 'reviewDetail',
      component: ReviewDetail,
    },
    {
      path: '/review/:vid/:rid',
      name: 'reviewUpdate',
      component: ReviewUpdate,
    },
  ]
})

export default router
