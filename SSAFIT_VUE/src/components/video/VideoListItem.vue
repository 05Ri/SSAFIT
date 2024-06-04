<template>
  <div class="video-container">
    <iframe
    width="297"
    height="200"
    :src="video.url"
    title="YouTube video player"
    frameborder="0"
    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
    referrerpolicy="strict-origin-when-cross-origin"
    />
    <p class="video-title">{{ video.title }}</p>
    <div class="sub">
      <span>{{ video.part }}</span>
    </div>
    <div class="video-detail-btn">
      <RouterLink :to="{name: 'videoDetail', params: {vid: video.videoId}}">Review</RouterLink>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue'

defineProps({
  video: Object,
})
</script>

<style scoped>
.video-container {
  border: 2px solid #e8e8e8;
  width: 300px;
  height: 300px;
  margin: 5px;
}

.video-container > .sub {
  background-color: black;
  color: white;
  width: 3rem;
  padding: 3px;
  margin: 1px;
  text-align: center;
  border-radius: 50%;
}

.video-detail-btn {
  text-align: center;
  border: 1px solid #cccccc;
  width: 10rem;
  margin: 0 auto;
}

.video-title {
  white-space: nowrap; /* 텍스트가 줄 바꿈되지 않도록 설정 */
  overflow: hidden; /* 넘친 부분을 숨김 */
  text-overflow: ellipsis; /* 넘친 부분을 "..."으로 표시 */
}

</style>
