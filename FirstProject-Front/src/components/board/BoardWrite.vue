<template>
  <h2>글 작성</h2>
    <div>
      <div v-if="store.getUser">
        <label for="userId">아이디:</label>
        <input readonly v-model="store.user.userId" type="text" id="userId">
      <!-- <input readonly v-model="userId.value" type="text" id="userId" class="view"> -->
      
      <label>제목:</label>
      <input v-model="boardTitle" type="text" id="boardTitle" required>

      <label for="boardText">내용:</label>
      <input v-model="boardText" type="text" id="boardText" required>

      <button type="submit2" @click="registBoard">등록</button>
    </div>
    <div v-else>
      <!-- <p>alert('로그인 해주세요')</p> -->
      <div>SSAFIT 멤버만 글을 작성할 수 있습니다. 로그인하세요</div>
      <RouterLink to="/login">LOGIN</RouterLink>
    </div>
  </div>
</template>
  
<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
import { useUserStore } from "@/stores/user";
import { RouterLink } from "vue-router";
import { computed } from "vue";

const store = useUserStore();

const getUser = computed(() => store.getUser());

const userId = ref('');
const boardTitle = ref('');
const boardText = ref(''); 
const router = useRouter(); 

const alertAlarm = function(){
  alert('로그인 해주세요')
}  


const registBoard = function(){
  axios({
  url: 'http://localhost:8080/api/board',
  method: 'POST',
  headers: {
      "Content-Type": "application/json"
  },
  data: {
      boardTitle : boardTitle.value,
      userId : store.user.userId,
      boardContent : boardText.value,
    }
  })
  .then(() => {
    alert('글 등록 성공!')
    router.push( {name: "BoardList"})
  })
  .catch((err) => {
    console.log(err)
  })
}

</script>

<style scoped>

</style>
