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


  return {getVideo, getVideoList, videoList, video}

})