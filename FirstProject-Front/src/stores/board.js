import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { defineStore } from 'pinia'
import axios from "axios";

export const useBoardStore = defineStore('board', ()=>{
    const boardList = ref([]);
    const router = useRouter();
    const board = ref([]);

    // 게시판(글목록) 조회
  const getBoardList = () => {
    const API_URL = "http://localhost:8080/api/board";
    axios({
      url: API_URL,
      method: "GET",
    })
      .then((res) => {
        board.value = res.data;
        console.log(board)
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 글 등록
  const createBoard = (board) => {
    const API_URL = `http://localhost:8080/api/board`;
    axios({
      url: API_URL,
      method: "POST",
      data: {
        boardId: board.boardId,
        boardTitle: board.boardTitle,
        userId: board.userId,
        boardContent: board.boardContent,
        boardFile: board.boardFile,
      },
    })
      .then(() => {
        alert("등록 완료");
        getBoardList();
        router.push("/board");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 글 수정
  const updateBoard = (board) => {
    const API_URL = `http://localhost:8080/api/board`;
    // axios 요청 (Spring Boot Rest API 참고)
    axios({
      url: API_URL,
      method: "PUT",
      data: {
        boardId: board.boardId,
        boardTitle: board.boardTitle,
        userId: board.userId,
        boardContent: board.boardContent,
        boardFile: board.boardFile,
      }
    })
      .then(() => {
        alert("수정 완료");
        getBoardList();
        router.push("/board");
      })
      .catch((err) => {
        console.log(err);
      });
  };
  
  // 글 삭제
  const deleteBoard = (board) => {
    const API_URL = `http://localhost:8080/api/board/${board.boardId}`;
    // axios 요청 (Spring Boot Rest API 참고)
    axios({
      url: API_URL,
      method: "DELETE",
    })
      .then(() => {
        alert("삭제 완료");
        getBoardList();
        router.push("/board");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  onMounted(() => {
    getBoardList();
  });


  return { router, boardList, board, getBoardList, createBoard, updateBoard, deleteBoard, onMounted }

})