<template>
  <div>
    <h2>리뷰 상세 보기</h2>
    <hr />
    <div class="review-detail">
      <fieldset class="review-form">
        <div>
          <label for="title">제목</label>
          <br />
          <input type="text" readonly :value="store.review.title" />
        </div>
        <div>
          <label for="writer">작성자</label>
          <br />
          <input type="text" readonly :value="store.review.userId" />
        </div>
        <div>
          <label for="content">내용</label>
          <br />
          <textarea readonly :value="store.review.content" />
        </div>
        <div>
          <label for="regDate">작성일자</label>
          <br />
          <input type="text" readonly :value="store.review.regDate" />
        </div>
        <div class="btns">
          <button @click="modifyReview">수정</button>
          <button @click="deleteReview">삭제</button>
        </div>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios'


const store = useSsafitStore()

const route = useRoute()
const router = useRouter()

onMounted(() => {
  store.getReview(route.params.vid, route.params.rid)
})

const modifyReview = function() {
  if (store.review.userId === store.loginUser.userId) {
    router.push({name: 'reviewUpdate', params: {vid: route.params.vid, rid: route.params.rid}})
  }
  else {
    alert("수정 권한이 없습니다.")
  }
}


const deleteReview = function () {
  if (store.review.userId === store.loginUser.userId) {
    axios.delete(`http://localhost:8080/ssafit-api/review/${route.params.vid}/${route.params.rid}`)
    .then(() => {
      alert("리뷰 삭제 성공")
      router.push({name: 'videoDetail', params: route.params.vid})
    })
  }
  else {
    alert("삭제 권한이 없습니다.")
  }
}

</script>
<style scoped>
h2 {
  margin: 20px;
}

.review-form {
  margin: 20px;
  padding : 20px;
  width : 400px;
  height : 450px;
}

.review-form textarea {
  width : 250px;
  height : 200px;
}

.review-form .btns {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.review-form button {
  width : 100px;
}
</style>
