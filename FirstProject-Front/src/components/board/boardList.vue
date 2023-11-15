<template>
    <div class="container">
      <br>
      <h2>게시판</h2>
        <table class="board-list">
          <colgroup>
            <col style="width: 3%" />
            <col style="width: 10%"/>
            <col style="width: 5%" />
            <!-- <col style="width: 20%" /> -->
            <!-- <col style="width: 15%" /> -->
          </colgroup>
          <thead>
            <tr> 
              <th>No</th>
              <th>
                  제목
              </th>
              <!-- <th>글내용</th> -->
              <th>글쓴이</th> 
            </tr>
          </thead>
          <tbody>
            <tr v-for="(board, index) in board" :key="index">
              <!-- <td>{{ index + 1 }}</td> -->
              <td>
                {{ board.boardId }}
              </td>
              <td class="left">
                <RouterLink class="board-link" :to="`/board/${board.boardId}`">{{     
                  board.boardTitle
                }}</RouterLink>
              </td>
              <!-- <td>{{ board.boardTitle }}</td> -->
              <!-- <td>{{ board.boardId }}</td> -->
              <!-- <td>{{ board.boardContent }}</td> -->
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

<style scoped>
.container {
  text-align: center;
}

.board-list {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  border: 1px solid #000; /* 바깥쪽 테두리 색상: 검은색 */
}

.board-list th, .board-list td {
  padding: 10px;
  text-align: center; /* 가운데 정렬로 변경 */
  border-bottom: 1px solid #ddd; /* 아래 테두리 색상: 연한 회색 */
}

.board-list th {
  background-color: #f2f2f2;
}

.board-link {
  color: #007bff;
  text-decoration: none;
}

.board-link:hover {
  text-decoration: underline;
}

.left {
  text-align: left;
  padding-left: 10px; /* 왼쪽 여백 추가 */
}

.title {
  text-align: center;
}

/* "제목" 열의 하위 항목들을 왼쪽 정렬 */
.board-list td.left {
  text-align: left;
  padding-left: 20px; /* 추가한 여백 */
}
</style>
