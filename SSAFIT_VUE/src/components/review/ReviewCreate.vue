<template>
  <div>
    <h2>댓글 작성</h2>
    <hr />
    <fieldset class="review-form">
      <div>
        <label for="title">제목</label>
        <br />
        <input type="text" id="title" v-model="review.title" />
      </div>
      <div>
        <label for="writer">작성자</label>
        <br />
        <input type="text" id="writer" :value="userId" readonly />
      </div>
      <div>
        <label for="content">내용</label>
        <br />
        <textarea id="content" v-model="review.content" />
      </div>
      <div class='btns'>
        <button @click="create">등록</button>
        <button @click="router.go(-1)">취소</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit';
import { ref } from 'vue';
import { useRoute } from 'vue-router';
import router from '@/router';

const route = useRoute()

const loginUser = ref(JSON.parse(localStorage.getItem("loginUser")));
const userId = ref(loginUser.value.userId)

const store = useSsafitStore()

const review = ref({
  title: '',
  userId: userId.value,
  content: ''
})

const create = function () {
  store.createReview(review.value, route.params.vid)
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