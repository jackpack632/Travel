<template>
  <div class="emergency-search">
    <input v-model="searchKeyword" placeholder="输入关键字">
    <button @click="searchEmergency">搜索</button>
  </div>
</template>

<script>
export default {
  name: 'EmergencySearch',
  data() {
    return {
      searchKeyword: ''
    };
  },
  methods: {
    searchEmergency() {
      // 在这里实现查询逻辑，可以调用后端API来查询
      // 示例：this.searchEmergencyBackend(this.searchKeyword);
      // 然后根据查询结果更新显示的旅游应急信息列表
      // 示例：this.$emit('search-emergency', searchResult);
    }
    // 示例：searchEmergencyBackend(keyword) {
    // 调用后端API查询数据
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
