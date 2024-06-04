<template>
  <div class="logo">
    <h1><RouterLink :to="{name: 'home'}" id='logo-router'>SSAFIT</RouterLink></h1>
    <div v-if="store.loginUser">
      <span>{{ store.loginUser.name }}님 반갑습니다</span>
      <span> | </span>
      <a href="#" @click.prevent="store.logout">로그아웃</a>
    </div>
    <div v-else>
      <RouterLink :to="{name: 'login'}">로그인</RouterLink>
      <span> | </span>
      <RouterLink :to="{name: 'regist'}">회원가입</RouterLink>
    </div>
  </div>

  <div class="nav-bar">
    <RouterLink :to="{name: 'allVideo'}">전체</RouterLink>
    <RouterLink :to="{name: 'ascVideo'}">조회수순</RouterLink>
    <div>
      <RouterLink :to="{name: 'partVideo', params:{part: selectedPart}}" @click="store.getPartVideos(selectedPart)">부위별로 보기</RouterLink>
      <select v-model="selectedPart">
        <option>전신</option>
        <option>상체</option>
        <option>하체</option>
        <option>복부</option>
      </select>
    </div>
  </div>
</template>

<script setup>
import { useSsafitStore } from "@/stores/ssafit";
import { onMounted, ref } from "vue";

const store = useSsafitStore()
const selectedPart = ref("상체");

onMounted(()=>{
  console.log(store.loginUser)
  store.loginUser = JSON.parse(localStorage.getItem("loginUser"));
})


</script>

<style scoped>
.logo {
  padding: 1rem;
  display: flex;
  align-items: center;
}

.logo h1 {
  flex-grow: 1;
}

nav a {
  padding: 5px;
  text-decoration: none;
  color: black;
}

.nav-bar {
  display: flex;
  justify-content: space-around;
  background-color: aliceblue;
  padding: 10px;
}

#logo-router {
  color: black;
}
</style>
