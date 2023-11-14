<template>
  <div class="video-management-page">
    <h1>영상 관리 페이지</h1>
    <router-view/>
  </div>
</template>

<style scoped>
.video-management-page {
  max-width: 800px;
  margin: auto;
  padding: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  background-color: #fff;
}

h1 {
  font-size: 2.5rem;
  text-align: center;
  margin-bottom: 30px;
}

</style>
