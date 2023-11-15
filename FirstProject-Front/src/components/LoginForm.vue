<template>

  <div class="container">
    <br>
    <h2>Log in</h2>
    <div class="withssafyfont">Use your email or other service to continue with SSAFIT</div>
    <br>
    <fieldset class="text-center">
      <span>
        <label for="id" class="textfont">Your email</label>
      </span>
      <div>
        <input v-model="id" type="text" id="id" required/>
      </div>
      <br>
      <span>
        <label for="password" class="textfont">Your password</label>
      </span>
      <div>
        <input v-model="password" type="password" id="password" required/>
      </div>
      <div>
        <br>
      <button class="btn" @click="login">
        <div class="buttonfont">Log in</div>
      </button>
      </div>
    </fieldset>
    </div>



    <!-- <div>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img
        src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
        width="200"
        alt="카카오 로그인 버튼" />
    </a>
  </div> -->

   <!-- <div>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img
        src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
        width="200"
        alt="카카오 로그아웃 버튼" />
    </a>
  </div> -->

  <!-- <div @click="kakaoLogout()">카카오 로그아웃</div> -->

  
  <!--여기서부터 내가 디자인해가는 부분들 -->

  <br>

  <div style="width: 100%; height: 100%; justify-content: flex-start; align-items: center; gap: 23px; display: inline-flex">
    <div style="flex: 1 1 0; height: 2px; background: rgba(102, 102, 102, 0.25)"></div>
    <div style="color: #666666; font-size: 24px; font-family: Avenir; font-weight: 400; word-wrap: break-word">OR</div>
    <div style="flex: 1 1 0; height: 2px; background: rgba(102, 102, 102, 0.25)"></div>
  </div>

  

  <br>
  <br>

  <div class = "socialLogin" @click="kakaoLogin()">
    <img src="@/assets/kakao.png" width="33" height="33" viewBox="0 0 33 33" fill="none"/>
    <div class = "font" >Log in with Kakao</div>
  </div>
  <br>
  <div class = "socialLogin" @click="kakaoLogin()">
    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" viewBox="0 0 25 25" fill="none">
      <path d="M23.0005 12.7332C23.0005 11.8699 22.9291 11.2399 22.7744 10.5865H12.7148V14.4832H18.6196C18.5006 15.4515 17.8577 16.9099 16.4291 17.8898L16.4091 18.0203L19.5897 20.435L19.8101 20.4565C21.8338 18.6249 23.0005 15.9298 23.0005 12.7332Z" fill="#4285F4"/>
      <path d="M12.714 23.0001C15.6068 23.0001 18.0353 22.0667 19.8092 20.4567L16.4282 17.89C15.5235 18.5083 14.3092 18.94 12.714 18.94C9.88069 18.94 7.47596 17.1083 6.61874 14.5767L6.49309 14.5871L3.18583 17.0955L3.14258 17.2133C4.90446 20.6433 8.5235 23.0001 12.714 23.0001Z" fill="#34A853"/>
      <path d="M6.62095 14.5767C6.39476 13.9234 6.26386 13.2233 6.26386 12.5C6.26386 11.7767 6.39476 11.0767 6.60905 10.4234L6.60306 10.2842L3.25435 7.7356L3.14478 7.78667C2.41862 9.21002 2.00195 10.8084 2.00195 12.5C2.00195 14.1917 2.41862 15.79 3.14478 17.2133L6.62095 14.5767Z" fill="#FBBC05"/>
      <path d="M12.7141 6.05997C14.7259 6.05997 16.083 6.91163 16.8569 7.62335L19.8807 4.73C18.0236 3.03834 15.6069 2 12.7141 2C8.52353 2 4.90447 4.35665 3.14258 7.78662L6.60686 10.4233C7.47598 7.89166 9.88073 6.05997 12.7141 6.05997Z" fill="#EB4335"/>
    </svg>
    <div class = "font" >Log in with Google</div>
  </div>
  <br>
  <div style="width: 100%; height: 100%; justify-content: flex-start; align-items: center; gap: 23px; display: inline-flex">
    <div style="flex: 1 1 0; height: 2px; background: rgba(102, 102, 102, 0.25)"></div>
    <div style="color: #666666; font-size: 24px; font-family: Avenir; font-weight: 400; word-wrap: break-word">OR</div>
    <div style="flex: 1 1 0; height: 2px; background: rgba(102, 102, 102, 0.25)"></div>
  </div>
  <br>
  <br>
  <div class = "socialLogin" @click="kakaoLogout()">
    <img src="@/assets/kakao.png" width="33" height="33" viewBox="0 0 33 33" fill="none"/>
    <div class = "font" >Logout from Kakao</div>
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

const user = ref({
  id : id,
  password : password,
})

const loginUser = () =>{
  console.log(user.value)
  emit("login-user", user.value)
}



</script>

<style scoped>

  /* .container {
    /* display: inline-flex;  */
    /* flex-direction: column;
    justify-content: center;
    align-items: center;
     gap: 40px; 
  } */ 

  h2 {
    text-align: center;
    color: #333;
    font-family: Poppins;
    font-size: 32px;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
  }

  .socialLogin {
    display: flex;
    width: 528px;
    height: 72px;
    padding: 20.5px 148.5px 21.5px 149.5px;
    justify-content: center;
    align-items: center;

    border-radius: 40px;
    border: 1px solid #333;
    background: #FFF;

    margin: auto; /* 추가: 중앙 정렬 */

    
  }

  .socialLogin:hover {
  background-color: black; /* 호버 시 어둡게 변하는 배경 */
}

.socialLogin:hover .font {
  color: white; /* 호버 시 글자색을 하얗게 설정 */
}

  .font {
    padding-left: 10px;
    color: #333;
    font-family: Avenir;
    font-size: 22px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }

  .or {
    color: #666;
    font-family: Avenir;
    font-size: 24px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    text-align: center;
  }

  .loginStyle {
    color: #666;
    font-family: Poppins;
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
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

  /* .btn:hover .buttonfont {
    color:black;
  } */
   
   .buttonfont {
    color: #FFF;
    text-align: center;
    font-family: Poppins;
    font-size: 22px;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
   }

   .text-center .textfont {
    color: #666;
    font-family: Poppins;
    font-size: 17px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;


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
   
</style>
