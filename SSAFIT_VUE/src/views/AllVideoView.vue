<template>
  <div>
    <h2>전체 영상 보기</h2>
    <VideoList />
  </div>
</template>

<script setup>
import VideoList from '@/components/video/VideoList.vue'
import { useSsafitStore } from '@/stores/ssafit'
import { onMounted } from 'vue'

const store = useSsafitStore()

onMounted(() => {
  store.getVideoList()
})
</script>

<style scoped>

</style>
