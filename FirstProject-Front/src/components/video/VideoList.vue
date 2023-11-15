<template>
  <div class="video-list-page">
    <h2>영상 목록</h2>
    <div class="video-list-card">
      <table>
        <thead>
          <tr>
            <th>제목</th>
            <th>URL</th>
            <th>부위</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="video in store.videoList" :key="video.videoId">
            <td>
              <router-link :to="`/video/${video.videoId}`">{{ video.videoTitle }}</router-link>
            </td>
            <td>{{ video.videoUrl }}</td>
            <td>{{ video.videoPart }}</td>
          </tr>
        </tbody>
      </table>
      <router-link :to="{ name: 'VideoRegist' }">
        <button>Regist</button>
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useVideoStore } from '@/stores/video'

const store = useVideoStore()

onMounted(() => {
  store.getVideoList();
})
</script>

<style scoped>
.video-list-page {
max-width: 800px;
margin: auto;
padding: 20px;
}

.video-list-card {
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
border-radius: 8px;
overflow: hidden;
}

table {
width: 100%;
border-collapse: collapse;
margin-top: 15px;
text-align: center;
}

th, td {
padding: 12px;
text-align: left;
border-bottom: 1px solid #ddd;
text-align: center;

}

th {
background-color: #f2f2f2;
}
</style>