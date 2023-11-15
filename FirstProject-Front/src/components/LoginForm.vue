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
<<<<<<< HEAD
  <div>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img
        src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
        width="200"
        alt="카카오 로그인 버튼" />
    </a>
  </div>
  <div @click="kakaoLogout()">로그아웃</div>
=======
>>>>>>> 7139276dbfeb635cdbc76b9915b67f9b7cfe34a3
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "../stores/user";

const store = useUserStore();

const id = ref("");
const password = ref("");

<<<<<<< HEAD
=======

>>>>>>> 7139276dbfeb635cdbc76b9915b67f9b7cfe34a3
const login = () => {
  let user = {
    id: id.value,
    password: password.value,
  };
 store.loginUser(user); 
};

<<<<<<< HEAD
const kakaoLogin= () => {
  window.Kakao.Auth.login({
    scope: "account_email",
    success: getKakaoAccount(),
  })
}
 
const getKakaoAccount= () => {
  window.Kakao.API.request({
    url: "/v2/user/me",
    success: (res) => {
      const kakao_account = res.kakao_account;
      const email = kakao_account.email;
      console.log("email", email);
      alert("로그인 성공!");
    },
    fail: (error) => {
      console.log(error);
    },
  });
}

const kakaoLogout = () => {
  window.Kakao.Auth.logout((res) => {
    console.log(res)
  })
}

=======
>>>>>>> 7139276dbfeb635cdbc76b9915b67f9b7cfe34a3
const user = ref({
  id : id,
  password : password,
})

const loginUser = () =>{
  console.log(user.value)
  emit("login-user", user.value)
}



</script>
