<template>
    <div>
        <fieldset class="login-form">
            <legend>로그인</legend>
            <div class="user-info">
                <input type="text" name="id" id="id" placeholder="🙍‍♂️아이디" v-model="user.userId"><br/>
                <input type="password" name="password" id="password" placeholder="🔒비밀번호" v-model="user.password"><br/>
            </div>
            <button @click="login">로그인</button>
            <button @click="regist">회원가입</button>
        </fieldset>
    </div>
</template>

<script setup>
import { useSsafitStore } from '@/stores/ssafit';
import { ref } from 'vue';
import router from '@/router'


const store = useSsafitStore();

const user = ref({
    userId: "",
    password: "",
    name: null,
});

const login = function() {
    // console.log(user.value);
    store.login(user.value);
}

const regist = function() {
    router.push({name: 'regist'})
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
  
