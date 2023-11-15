<template>
    <div class="container">
      <h2>게시판</h2>
        <table class="board-list">
          <colgroup>
            <col style="width: 7%" />
            <col style="width: 30%"/>
            <col style="width: 30%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
          </colgroup>
          <thead>
            <tr> 
              <th>글번호</th>
              <th>글제목</th>
              <th>글내용</th>
              <th>유저아이디</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(board, index) in board" :key="index">
              <!-- <td>{{ index + 1 }}</td> -->
              <td>
                {{ board.boardId }}
              </td>
              <td>
                <RouterLink class="board-link" :to="`/board/${board.boardId}`">{{
                  board.boardTitle
                }}</RouterLink>
              </td>
              <!-- <td>{{ board.boardTitle }}</td> -->
              <!-- <td>{{ board.boardId }}</td> -->
              <td>{{ board.boardContent }}</td>
              <td>{{ board.userId }}</td>
            </tr>
          </tbody>
        </table>
      
        <br>
      <RouterLink to="/board/write">글작성</RouterLink>
      </div>
    
  </template>

<script setup>

import { ref, onMounted } from 'vue'
import { useBoardStore } from '@/stores/board'
import { computed } from "vue";

const store = useBoardStore()

onMounted(() => {
    store.getBoardList();
})

  const props = defineProps({
    board: {
      type: Array,
      default: () => [],
    },
  });
  
  // const userCnt = computed(() => props.users.length);
  </script>
  