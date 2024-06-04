<template>
  <div v-if="store.reviewList.length !== 0">
    <table class="review-table">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>작성시간</th>
      </tr>
      <tr v-for="(review, idx) in store.reviewList" :key="review.reviewId">
        <td>{{ idx }}</td>
        <td><RouterLink :to="{name: 'reviewDetail', params:{vid: route.params.vid, rid: review.reviewId}}"> {{ review.title }} </RouterLink></td> <!-- 여기 링크처리 -->
        <td>{{ review.content }}</td>
        <td>{{ review.userId }}</td>
        <td>{{ review.regDate }}</td>
      </tr>
    </table>
  </div>
  <div v-else>
    <h2>리뷰가 없습니다... 댓글을 달아주세요!</h2>
  </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit';
import { onMounted } from 'vue';
import { RouterLink, useRoute } from 'vue-router';

const store = useSsafitStore();

const route = useRoute();

onMounted(() => {
  store.getReviewList(route.params.vid)
})
</script>

<style scoped>
table, th, td {
  border: 0.5px solid black;
  border-collapse: collapse;
  text-align: center;
}

.review-table {
  margin: 10px auto;
  width: 80%;
  height: 5rem;
}
</style>
