<template>
  <div class="container">
    <h2>사용자 목록</h2>
    <h4>등록된 사용자의 수 : {{ userCnt }}</h4>
    <div v-if="userList.length">
      <table class="user-list">
        
        <thead>
          <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>패스워드</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(userList, index) in userList" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <RouterLink class="user-link" :to="`/users/${userList.userId}`">{{userList.userId }}</RouterLink>
            </td>
            <td>{{ userList.userPassword}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 사용자가 없습니다.</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
import { computed } from "vue";

const store = useUserStore()

const props = defineProps({
    userList: {
      type: Array,
      default: () => [],
    },
  });

  const userCnt = computed(() => props.userList.length);

</script>
