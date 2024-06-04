<template>
  <div>
    <h2>영상 상세 보기</h2>
    <hr />
    <div class="video-detail">
      <iframe
      width="700"
      height="450"
      :src="store.video.url"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      referrerpolicy="strict-origin-when-cross-origin"
      />
      <h2>{{ store.video.title }}</h2>
      <p>조회수: {{ store.video.viewCnt }}</p>
    </div>
  </div>
  <hr>
  <ReviewList />
  <div class="review-create-btn">
    <RouterLink :to="{name: 'reviewCreate'}">댓글 달기</RouterLink>
  </div>
</template>

<script setup>
import ReviewList from '@/components/review/ReviewList.vue'
import { useSsafitStore } from '@/stores/ssafit'
import { onMounted } from 'vue'
import { useRoute } from 'vue-router'

const store = useSsafitStore()

const route = useRoute()

onMounted(() => {
  store.getVideo(route.params.vid)
})
</script>

<style scoped>
h2 {
  margin: 20px;
}

.video-detail {
  margin: 20px;
  text-align: center;
}
</style>
