<template>
  <div class = "main" style="text-align: center; justify-content:center;">
    <br>
    <h2>회원가입</h2>
    <br>
    <form @submit.prevent="registUser">
      <label for="userId">아이디 :</label>
      <input v-model="userId" type="text" id="userId" required>
      <br>
      <label for="userPassword">비밀번호 :</label>
      <input v-model="userPassword" type="password" id="userPassword" required>

      <br>
      <br>
      <div class=buttonStyle>
      <button type="submit">Sign up</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const emit = defineEmits();

const userId = ref('')
const userPassword = ref('')

const user = ref({
  userId : userId,
  userPassword: userPassword,
})

const registUser = () => {
  console.log(user.value)
  emit("regist-user", user.value)
};
</script>

<style scoped>

  .main {
    text-align : center;
    font-family: Poppins;
  }


  button {
    text-align : center;
      width: 200px;
      height: 64px;
      padding: 15px 42px 16px 42px;
      justify-content: center;
      align-items: center;
      color : white;

      border-radius: 16px;
      opacity: 0.25;
      background: black;
      font-family: Poppins;
      font-size: 22px;
      font-style: normal;
      font-weight: 500;
      line-height: normal;

  }
</style>