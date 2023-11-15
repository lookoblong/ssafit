<template>
  <div class = "main" style="text-align: center; justify-content:center;">
    <br>
    <h2>Sign up</h2>
    <div class="withssafyfont">Use your email or other service to continue with SSAFIT</div>
    <br>
   
      <span>
      <label for="id" class="textfont">Your email</label>
      </span>
      <div>
      <input v-model="id" type="text" id="userId" required>
      </div>
      <br>
      <span>
      <label for="password" class="textfont">Your password</label>
      </span>
      <div>
      <input v-model="password" type="password" id="userPassword" required>
      </div>
      <br>
      <button class="btn" @click="signup">
        <div class="buttonfont">Sign up</div>
      </button>

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

const id = ref('');
const password = ref(''); 

const isValidEmail = (id) => {
  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailRegex.test(id);
}

const signup = () => { 
  
  if (!isValidEmail(id.value)) {
    alert("이메일 주소가 유효하지 않습니다.");
    return;
  } 
  else {
    let user = {
      id : id,
      password: password,
    }
    store.signup(user)
};
}

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

.btn {
  /* display: flex; */
  width: 528px;
  height: 64px;
  padding: 15px 0px 16px 0px;
  justify-content: center;
  /* align-items: center; */

  border-radius: 40px;
  opacity: 0.25;
  background: #111;

  /* text-align: center; */
}

.btn:hover {
  background-color: #555; 
  /* background-color: white; */
}

.buttonfont {
  color: #FFF;
  text-align: center;
  font-family: Poppins;
  font-size: 22px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
}

h2 {
  text-align: center;
  color: #333;
  font-family: Poppins;
  font-size: 32px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
}

input[type=text] { 
  height:56px;
  width: 528px;
  align-self: stretch;
  border-radius: 12px;
  border: 1px solid rgba(102, 102, 102, 0.35);
  text-indent: 15px;
}


input[type=password] { 
  height:56px;
  width: 528px;
  align-self: stretch;  
  border-radius: 12px;
  border: 1px solid rgba(102, 102, 102, 0.35);
  text-indent: 15px;
}

.withssafyfont {
  text-align: center;
  color: #666;
  font-family: Poppins;
  font-size: 16px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}

.textfont {
  color: #666;
  font-family: Poppins;
  font-size: 17px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}
</style>