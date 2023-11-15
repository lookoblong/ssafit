import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { defineStore } from 'pinia'
import axios from "axios";
import { computed } from "vue";

export const useUserStore = defineStore('user', ()=>{
  const router = useRouter();
  const userList = ref([]);
  const user = ref("");
  const getUser = ref(false)

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

  const signup = (user) => {
    axios({
      url: 'http://localhost:8080/api/users/signup',
      method: "POST",
      data: {
        userId: user.id,
        userPassword: user.password,
      },
    })
      .then(() => {
        alert("회원가입 성공!");
        getUserList();
        router.push("/users");
      })
      .catch((err) => {
        alert("중복된 아이디입니다")
        console.log(err);
      });
  };

  const loginUser = (user) => {
    axios({
      url: 'http://localhost:8080/api/login',
      method: "POST",
      data: {
        userId: user.id,
        userPassword: user.password,
      },
    })
    .then((res) => {
      sessionStorage.setItem('access-token', res.data["access-token"])
      const token = res.data['access-token'].split('.')
      let id = token[1]
      id = atob(id)
      id = JSON.parse(id)
      console.log(id.id)
      user.value = id.id
      getUser.value = true
      console.log(user.value)
      console.log(getUser.value)
      alert("로그인 성공!")
      router.push("/");
    })
    .catch((err) => {
      console.log(err);
      alert("로그인 실패");
    });
  };


  const logout = () => {
    user.value = '';
    alert("로그아웃 하셨습니다")
    getUser.value = false
    router.push("/")
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

  return { router, user, userList, getUserList, signup, onMounted, loginUser, logout, getUser}
   

})