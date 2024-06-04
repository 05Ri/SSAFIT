<template>
  <div>
    <h2>인기 영상</h2>
    <VideoList />
  </div>
</template>

<script setup>
import VideoList from '@/components/video/VideoList.vue'
import { useSsafitStore } from '@/stores/ssafit'
import { onMounted } from 'vue'

const store = useSsafitStore()

onMounted(() => {
  store.getAscendingVideos()
})

</script>

<style scoped>

</style>
