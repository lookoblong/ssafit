<template>
    <div class="container">
      <br>
      <h2>글 보기</h2>
      <fieldset class="text-center">
        <br>
        <label for="userId">글번호</label>
        <input readonly
          type="text"
          id="id"
          v-model="board.boardId"
          class="view"
        /><br />
        <label for="email">작성자</label>
        <input readonly type="email" id="email" v-model="board.userId" class="view" /><br />
        <label for="password">제목</label>
        <input readonly type="text" id="title" v-model="board.boardTitle" class="view"/><br />
        <label for="name">내용</label>
        <input readonly type="text" id="name" v-model="board.boardContent" class="view" /><br />
        
        <br>
        <button class="btn" @click="GoModify">수정</button>
        <button class="btn" @click="call_confirm()">삭제</button>
      </fieldset>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import axios from "axios";
  import { useRouter } from "vue-router";
  
  const router = useRouter(); 
  const emit = defineEmits();
  
  const GoModify = () => {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    router.push( { name:"BoardModify", params:{id:id}})
  }

  const board = ref({
    boardId: "",
    boardTitle: "",
    userId: "",
    boardContent: "",
  });
  
  const updateBoard = () => {
    emit("update-board", board.value);
  };
  
  const deleteBoard = () => {
    emit("delete-board", board.value);
  };

  const call_confirm = function(){
    if(confirm("정말로 삭제하시겠습니까?")){
      deleteBoard();
    }else{
    }
  }

 
  
  onMounted(() => {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    const API_URL = `http://localhost:8080/api/board/${id}`;
    axios({
      url: API_URL,
      method: "GET",
    })
      .then((res) => {
        board.value.boardId = res.data.boardId;
        board.value.boardTitle = res.data.boardTitle;
        board.value.boardContent = res.data.boardContent;
        board.value.userId = res.data.userId;
      })
      .catch((err) => {
        console.log(err);
      });
  });
  </script>

<style scoped>
.container {
  text-align: center;
}

.text-center {
  text-align: center;
}

.view {
  width: 80%;
  padding: 8px;
  margin-bottom: 10px;
}

.view-textarea {
  width: 80%;
  height: 150px;
  padding: 8px;
  margin-bottom: 10px;
}

.btn {
  padding: 10px;
  background-color: #333; /* 무채색 배경 */
  color: #fff; /* 흰색 텍스트 */
  border: none;
  cursor: pointer;
  margin-right: 10px;
}

.btn:hover {
  background-color: #555; /* 호버 시 어둡게 변하는 배경 */
}
</style>