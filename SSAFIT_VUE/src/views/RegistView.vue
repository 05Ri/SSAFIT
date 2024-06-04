<template>
  <div>
      <fieldset class="login-form">
          <legend>회원가입</legend>
          <div class="user-info">
              <input type="text" id="id" placeholder="아이디" v-model="user.userId"><br/>
              <input type="text" id="name" placeholder="이름" v-model="user.name"><br/>
              <input type="password" id="password" placeholder="비밀번호" v-model="user.password"><br/>
          </div>
          <button @click="regist">회원가입</button>
      </fieldset>
  </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit';
import { ref } from 'vue';


const store = useSsafitStore();

const user = ref({
  userId: "",
  name: "",
  password: ""
})

const regist = function() {
  store.regist(user.value);
}

</script>

<style scoped>
.login-form {
  display: flex;
  flex-direction: column;
  width: 500px;
  height: 350px;
  padding : 50px;
  margin : 100px auto;
}

.user-info > input {
  display: block;
  height: 30px;
  width: 300px;
  margin: 0 auto;
  padding: 0 10px;
}

.login-form > button {
  height: 30px;
  margin: 10px;
}

legend {
  text-align: center;
}

</style>

