import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { defineStore } from 'pinia'
import axios from "axios";
import { computed } from "vue";

export const useUserStore = defineStore('user', ()=>{
  const router = useRouter();
  const userList = ref([]);
  const user = ref({});

    // 사용자 목록 조회
  const getUserList = () => {
    axios({
      url: "http://localhost:8080/api/users" ,
      method: "GET",
    })
    .then((res) => {
      userList.value = res.data;
    })
    .catch((err) => {
      console.log(err);
    });
  };

  // 사용자 등록
  const registUser = (user) => {
    axios({
      url: 'http://localhost:8080/api/users/signup',
      method: "POST",
      data: {
        userId: user.userId,
        userPassword: user.userPassword,
      },
    })
      .then(() => {
        alert("등록 완료");
        getUserList();
        router.push("/users");
      })
      .catch((err) => {
        console.log(err);
      });
  };


  //로그인
  const loginUser = (u) => {
    axios({
      url: 'http://localhost:8080/api/login',
      method: "POST",
      data: {
        userId: u.id,
        userPassword: u.password,
      },
    })
      .then((res) => {
        alert("로그인 완료"); 
        user.value = res.data; 
        getUserList();
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
        alert("로그인에 실패했습니다");
      });
  };

  //겟유저
  const getUser = computed(() => !!user.value.userId); 

  //로그아웃
  const logout = () => {
    user.value = {};
  };


  // 사용자 수정 (유효성 검토)
  // const updateUser = (user) => {
  //   axios({
  //     url: API_URL+ "/:id",
  //     method: "PUT",
  //     data: {
  //       id: user.userId,
  //       password: user.userPassword,
  //     },
  //   })
  //     .then(() => {
  //       alert("수정 완료");
  //       getUserList();
  //       router.push("/users");
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //     });
  // };
  
  onMounted(() => {
    getUserList();
  });

  return { router, user, userList, getUserList, registUser, onMounted, loginUser, logout, getUser}
   

})