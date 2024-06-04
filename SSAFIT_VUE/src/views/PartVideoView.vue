<template>
  <div>
    <h2>부위별로 보기</h2>
    <VideoList />
  </div>
</template>

<script setup>
import VideoList from '@/components/video/VideoList.vue'
import { useSsafitStore } from '@/stores/ssafit'
import { onMounted } from 'vue'
import { useRoute } from 'vue-router'

const store = useSsafitStore()
const route = useRoute()

onMounted(() => {
  store.getPartVideos(route.params.part)
})
</script>

<style scoped>

</style>
