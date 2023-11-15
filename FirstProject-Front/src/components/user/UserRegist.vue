<template>
  <div class = "main" style="text-align: center; justify-content:center;">
    <br>
    <h2>회원가입</h2>
    <br>
    <form @submit.prevent="registUser">
      <label for="id">아이디 :</label>
      <input v-model="id" type="text" id="userId" required>
      <br>
      <label for="password">비밀번호 :</label>
      <input v-model="password" type="password" id="userPassword" required>

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
import  axios  from 'axios';
import { useRouter } from "vue-router";
import { defineEmits } from 'vue'; 
import { useUserStore } from '@/stores/user'

const store = useUserStore(); 

const router = useRouter(); 

const emit = defineEmits(["regist-user"]);

// const userId = ref('');
// const userPassword = ref('');

const id = ref('');
const password = ref(''); 

// const user = ref({
//   userId : userId,
//   userPassword: userPassword,
// })

const password2 = ref(""); 

// email에 @의 포함 여부
const isValidEmail = (id) => {
  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailRegex.test(id);
}

const registUser = () => {
  axios.get(`http://localhost:8080/api/users/${id.value}`)
    .then((response) => {
        if (!isValidEmail(id.value)) {
          alert("이메일 주소가 유효하지 않습니다.");
          return;
        } else {
        
        if (response.data.userId) {
        alert('중복된 아이디입니다. 다른 아이디를 선택하세요.');
        return;
        } 

        // if (!isValidPassword(password.value)) {
        //   alert("비밀번호는 8자리 이상이고, 특수문자를 포함해야 합니다.");
        //   return;
        // }

        // if (password.value !== password2.value) {
        //   alert("비밀번호가 일치하지 않습니다.");
        //   return;
        // }
      //   const user = {
      //     userId: id.value,
      //     userPassword: password.value,
      //   };
      //   emit("regist-user", user);
      // // alert('아이디 중복 검사 중 오류 발생');
      // // console.error('아이디 중복 검사 중 오류 발생:', error);
      //   alert('회원가입이 완료되었습니다.');
        
      }
    })
    .catch((error) => {
      if (!isValidEmail(id.value)) {
          alert("이메일 주소가 유효하지 않습니다.");
          return;
        } 
      const user = {
          userId: id.value,
          userPassword: password.value,
        };
        emit("regist-user", user);
      // alert('아이디 중복 검사 중 오류 발생');
      // console.error('아이디 중복 검사 중 오류 발생:', error);
        alert('회원가입이 완료되었습니다.');
    })
};

store.getUserList();

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