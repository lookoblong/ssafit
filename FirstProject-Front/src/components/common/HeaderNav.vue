<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo">SSAFIT</RouterLink>
      </div>

      <!--드롭다운 메뉴-->

  <div class="dropdown">
      <a href="#">INTRO</a>
        <div class="dropdown-content">
          <a href="#">ABOUT US</a>
          <a href="#">SSAFIT</a>
        </div>
      </div>
      
    <div class="dropdown">
      <a href="#"> SERVICE </a>
        <div class="dropdown-content">
          <a href="#">chatgPT</a>
          <a href="#">get PT</a>
          <a href="#">my PT</a>
        </div>
      </div>
      
      <div class="dropdown">
      <a href="#"> COMMUNITY </a>
        <div class="dropdown-content">
          <RouterLink to="/board">자게</RouterLink>
          <a href="#">HOW TO SSAFIT</a>
          <a href="#">Todays TIP</a>
        </div>
      </div>
  
      <div class="dropdown">
       <RouterLink to="/contactUs">CONTACT</RouterLink>
      </div>

      <!-- <div>
        <p to="/login">
          <RouterLink to="/login">LOGIN</RouterLink>
          <RouterLink :to="{ name: 'UserRegist' }">SIGN UP</RouterLink>
          <RouterLink to="/users">USER</RouterLink>
          <RouterLink to="/video">VIDEO</RouterLink>
        </p>

      </div> -->


      <div>
          <!-- <a href="#" v-if="getUser" @click="logout">로그아웃</a> -->
          <a href="#" v-if="getUser"> 
            <div class="dropdown">
              <div>{{ store.user.userId }}님, 환영합니다.</div>
              <div class="dropdown-content">
                <a href="#">내 정보</a>
                <a href="#">내 스케줄</a>
                <a href="#">찜영상관리</a>
                <a href="#">친구관리</a>
              <RouterLink to="/" @click="logout">로그아웃</RouterLink>
              </div>
              </div>
              <RouterLink to="/video">VIDEO</RouterLink>
          </a>
          <p to="/login" v-else>
            <RouterLink to="/login">LOGIN</RouterLink>
            <RouterLink :to="{ name: 'UserRegist' }">SIGN UP</RouterLink>
            <RouterLink to="/users">USER</RouterLink>
            <RouterLink to="/video">VIDEO</RouterLink>
          </p>
        </div>

    </nav>
  </header>
</template>

<script setup>
  import { computed } from "vue";
  import { useUserStore } from "@/stores/user";
  import { RouterLink } from "vue-router"

  const store = useUserStore();

  const getUser = computed(() => !!store.getUser);

  const logout = () => { 
    store.logout(); 
    alert("로그아웃 되었습니다.");
    console.log('Logout function called');
  };
</script>

<style>

/*드롭다운 메뉴*/
.dropdown{
  position : relative;
  display : inline-block;
}

.dropdown-content{
  display : none;
  position : absolute;
  z-index : 1; /*다른 요소들보다 앞에 배치*/
}

.dropdown-content a{
  display : block;
  color : black;
  text-align: center;
}

.dropdown:hover .dropdown-content {
  display: block;
}

header {
  height: 70px;
  background-color:  rgb(166, 173, 224);
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}
</style>
