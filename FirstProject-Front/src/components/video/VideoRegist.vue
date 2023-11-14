<template>
  <div>
    <h2>영상 등록</h2>
    <form @submit.prevent="registVideo">
      <label>파트:</label>
      <input v-model="part" type="text" id="part" required>

      <label>URL:</label>
      <input v-model="url" type="url" id="url" required>

      <button type="submit">등록</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useVideoStore } from '@/stores/video'

const store = useVideoStore();

const part = ref('')
const url = ref('')
const title = ref('')

const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY

const getVideoTitle = async () => {
  const keyValuePairs = url.value.split('=');
  const videoId = keyValuePairs[1];
  console.log(videoId)
  const apiUrl = `https://www.googleapis.com/youtube/v3/videos?part=snippet&id=${videoId}&key=${API_KEY}`;
  try {
    const response = await axios.get(apiUrl);
    console.log(response);
    title.value = response.data.items[0].snippet.title;
    console.log(title.value)
  } catch (error) {
    console.log(error);
  }
};

const registVideo = async function () {
  await getVideoTitle();
  await store.registVideo(part, title, url);
}
</script>
