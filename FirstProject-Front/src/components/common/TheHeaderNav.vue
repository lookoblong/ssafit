<template>
    <header>
      <nav class="header-nav">
        <div>
          <RouterLink to="/" class="logo">SSAFIT</RouterLink>
        </div>
  
        <!--드롭다운 메뉴-->
  
    <div class="dropdown">
        <a href="#">   서비스소개   </a>
          <div class="dropdown-content">
            <a href="#">about us</a>
            <a href="#">what is ssafit</a>
            <a href="#">contact us</a>
          </div>
        </div>
        
      <div class="dropdown">
        <a href="#">   메인 기능   </a>
          <div class="dropdown-content">
            <a href="#">chatssafitT</a>
            <a href="#">서비스 시작</a>
            <a href="#">my계획표 확인하기</a>
          </div>
        </div>
        
        <div class="dropdown">
        <a href="#">   커뮤니티   </a>
          <div class="dropdown-content">
            <RouterLink to="/board">게시판</RouterLink>
            <a href="#">ssafit 사용법</a>
            <a href="#">diet Tip 게시판</a>
          </div>
        </div>
  
        <div class="dropdown">
        <a href="#">   운동영상   </a>
          <div class="dropdown-content">
            <a href="#">운동영상1</a>
            <a href="#">운동영상2</a>
            <a href="#">운동영상3</a>
          </div>
        </div>
    
  
        <div class="dropdown">
         <RouterLink to="/user">문의하기</RouterLink>
        </div>
       
  
        <div>
          <!-- <a href="#" v-if="getUser" @click="logout">로그아웃</a> -->
          <a href="#" v-if="!getUser"> 
            <div class="dropdown">
              <div>사용자님, 환영합니다.</div>
              <div class="dropdown-content">
                <a href="#">내 정보</a>
                <a href="#">내 스케줄</a>
                <a href="#">찜영상관리</a>
                <a href="#">친구관리</a>
              <RouterLink to="/login" @click="logout">로그아웃</RouterLink>
              </div>
              </div>
          </a>
          <p to="/login" v-else>
            <RouterLink :to="{ name: 'UserRegist' }">로그인</RouterLink>
            <RouterLink :to="{ name: 'UserRegist' }">회원가입</RouterLink>
            <RouterLink to="/user">사용자목록</RouterLink>
          </p>
          
         
          
        </div>
      </nav>
    </header>
  </template>
  
  <script setup>
  import { computed } from "vue";
  import { useUserStore } from "@/stores/user";
  import { RouterLink } from "vue-router";

  const store = useUserStore();

  const getUser = computed(() => store.getUser());
  
  // const getUser = computed(() => !!store.user);
  
  const logout = () => {
    store.logout(); 
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
    background-color: #53e3a6;
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
  