import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'


export const useVideoStore = defineStore('video', ()=> {
  const videoList = ref([])
  
  const getVideoList= function () {
    axios.get(`http://localhost:8080/api/video/`)
    .then((res) => {
      videoList.value = res.data
      console.log(videoList)
    })
  }
  const video = ref({});
  const getVideo = function(id) {
    axios.get(`http://localhost:8080/api/video/${id}`)
    .then((res) => {
      video.value = res.data
    })
  }

  const registVideo = function (part, title, url) {
    video.value.videoPart = part.value;
    video.value.videoTitle = title.value;
    video.value.videoUrl = url.value;
  
    axios({
      url: 'http://localhost:8080/api/video',
      method: 'POST',
      headers: {
          "Content-Type": "application/json"
      },
      data: video.value
    })
    .then(() => {
      alert('등록 성공!')
    })
    .catch((err) => {
      console.log(err)
    })
  }


  return {getVideo, getVideoList, videoList, video, registVideo}

})