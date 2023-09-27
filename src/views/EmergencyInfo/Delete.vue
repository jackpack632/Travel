<template>
  <div class="admin-page">
    <!-- 其他管理员页面内容 -->
    <EmergencyList />

  </div>
</template>


<script>
import EmergencyList from '@/components/EmergencyInfo/EmergencyList.vue';

export default {
  components: {
    EmergencyList
  },
  // 其他配置
};
</script>

<style scoped>
/* Your styles here */
</style>
