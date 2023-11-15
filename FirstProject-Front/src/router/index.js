import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import LoginForm from "@/components/LoginForm.vue";
import User from "../views/UserView.vue";
import UserList from "@/components/user/UserList.vue";
import UserSignup from "@/components/user/UserSignup.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import Video from "../views/VideoView.vue"
import VideoList from "@/components/video/VideoList.vue"
import VideoRegist from "@/components/video/VideoRegist.vue"
import VideoDetail from "@/components/video/VideoDetail.vue"
import ReviewList from "@/components/review/ReviewList.vue"
import Board from "../views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardModify from "@/components/board/BoardModify.vue";
import BoardWrite from "@/components/board/BoardWrite.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import contactUs from "@/components/contactUs/contactUs.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/contactUs",
    name: "contactUs",
    component: contactUs,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginForm,
  },
  {
    path: "/users",
    component: User,
    children: [
      {
        path: "signup",
        name: "UserSignup",
        component: UserSignup,
      },
      {
        path: "",
        name: "UserList",
        component: UserList,
      },
      {
        path: ":id",
        name: "UserDetail",
        component: UserDetail,
      },
    ],
  },
  {
    path: "/board",
    component: Board,
    children: [
      {
        path: "write",
        name: "BoardWrite",
        component: BoardWrite,
      },
      {
        path: "modify/:id",
        name: "BoardModify",
        component: BoardModify,
      },
      {
        path: "",
        name: "BoardList",
        component: BoardList,
      },
      {
        path: ":id",
        name: "BoardDetail",
        component: BoardDetail,
      }
    ],
  },
  {
    path: "/video",
    name: "Video",
    component: Video,
    children: [
      {
        path: "",
        name: "VideoList",
        component: VideoList,
      },
      {
        path: "regist",
        name: "VideoRegist",
        component: VideoRegist,
      },
      {
        path: ":id",
        name: "VideoDetail",
        component: VideoDetail,
        children:[
          {
            path: 'reviews',
            name: "ReviewList",
            component: ReviewList,
          },
          
        ]
      },
     
    ],
  },
  
  
  
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
