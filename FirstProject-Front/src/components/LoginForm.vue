<template>
  <div class="container">
    <h2>로그인</h2>
    <fieldset class="text-center">
      <div>
        <label for="id">아이디:</label>
        <input v-model="id" type="text" id="id" required>

        <label for="password">비밀번호:</label>
        <input v-model="password" type="password" id="password" required>
      <button class="btn" @click="login">로그인</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "../stores/user";

const store = useUserStore();

const id = ref("");
const password = ref("");


const login = () => {
  let user = {
    id: id.value,
    password: password.value,
  };
 store.loginUser(user); 
};

const user = ref({
  id : id,
  password : password,
})

const loginUser = () =>{
  console.log(user.value)
  emit("login-user", user.value)
}



</script>
