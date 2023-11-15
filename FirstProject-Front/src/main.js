import { createApp } from 'vue'
import { createPinia } from 'pinia'
import router from './router'
import axios from "axios";
import App from './App.vue'

<<<<<<< HEAD
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.js"
import "bootstrap-icons/font/bootstrap-icons.css"


=======
>>>>>>> 7139276dbfeb635cdbc76b9915b67f9b7cfe34a3
const app = createApp(App)

app.use(createPinia())
app.use(router)

app.config.globalProperties.$axios = axios;

app.mount('#app')
<<<<<<< HEAD

// kakao 로그인
window.Kakao.init("46e60c693adfb731063ad4f459c80b2f");

=======
>>>>>>> 7139276dbfeb635cdbc76b9915b67f9b7cfe34a3
