<template>
    <div>
      <h2>글 작성</h2>
      <div>
        <label readonly for="userId">아이디:</label>
        <input v-model="userId" type="text" id="userId" required>
        
        <label>제목:</label>
        <input v-model="boardTitle" type="text" id="boardTitle" required>

        <label for="boardText">내용:</label>
        <input v-model="boardText" type="text" id="boardText" required>
  
        <button type="submit2" @click="registBoard">등록</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  import { useRouter } from 'vue-router';
  
  const userId = ref('');
  const boardTitle = ref('');
  const boardText = ref(''); 
  const router = useRouter(); 

//   const board = ref({
//     userId: '',
//     boardTitle: '',
//     boardText: '',
//   })


//   const registBoard = () => {
//     console.log(board.value)
//     emit("create-board", board.value)
//   }
  

    const registBoard = function(){
    axios({
    url: 'http://localhost:8080/api/board',
    method: 'POST',
    headers: {
        "Content-Type": "application/json"
    },
    data: {
        boardTitle : boardTitle.value,
        userId : userId.value,
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
  