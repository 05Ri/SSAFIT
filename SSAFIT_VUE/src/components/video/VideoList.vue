<template>
  <div class="main-videos">
    <div v-for="video in store.videoList" :key="video.videoId">
      <VideoListItem :video="video"/>
    </div>

    <RouterView />
  </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit'
import { onMounted } from 'vue'
import VideoListItem from '@/components/video/VideoListItem.vue'
const store = useSsafitStore()

onMounted(() => {
  store.getVideoList()
  // console.log(store.videoList)
})
</script>

<style scoped>
.main-videos {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
}
</style>
