<template>
    <div class="container">
      <br>
      <h2>글 보기</h2>
      <br>
      <fieldset class="text-center">
        <br>
        <label for="userId">글번호</label>
        <input readonly
          type="text"
          id="id"
          v-model="board.boardId"
          class="view"
        /><br />
        <label for="email">아이디</label>
        <input type="email" id="email" v-model="board.userId" class="view" /><br />
        <label for="password">글제목</label>
        <input type="text" id="title" v-model="board.boardTitle" class="view"/><br />
        <label for="name">글내용</label>
        <input type="text" id="name" v-model="board.boardContent" class="view" /><br />
        
        <!-- <label for="age">나이</label>
        <input type="number" id="age" v-model="user.age" class="view" /><br /> -->
        <br>
        <button class="btn" @click="updateBoard">수정</button>
        <button class="btn" @click="deleteBoard">삭제</button>
      </fieldset>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import axios from "axios";
  
  const emit = defineEmits();
  
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
  