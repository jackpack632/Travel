<template>
  <div class="emergency-list">
    <h2>旅游应急信息列表</h2>
    <ul>
      <li v-for="(emergency, index) in emergencyList" :key="index" class="emergency-item">
        <div class="emergency-content">
          <div class="emergency-text">
            <h3>{{ emergency.title }}</h3>
            <p>{{ emergency.content }}</p>
            <p>有效期：{{ emergency.validity }}</p>
          </div>
          <button class="delete-button" @click="deleteEmergency(index)">删除</button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'EmergencyList',
  data() {
    return {
      tableData:[]
    };
  },mounted() {
    this.getEmergencyList();
  },
  methods: {
    deleteEmergency(index) {
      // 在这里实现删除逻辑，可以调用后端API来删除
      // 示例：this.deleteEmergencyBackend(index);
      this.emergencyList.splice(index, 1); // 假设删除前端数据
    }
    // 示例：deleteEmergencyBackend(index) {
    // 调用后端API删除数据
    // }
  }
</script>

<style scoped>
/* Your styles here */
.emergency-item {
  margin: 20px 0; /* 上下间距 */
  padding: 10px; /* 内边距 */
  border: 1px solid #ccc; /* 可选：添加边框 */
  background-color: white;
}

.emergency-content {
  display: flex;
  justify-content: space-between;
  align-items: center;

}

.emergency-text {
  flex: 1;
}

.delete-button {
  background-color: red;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
}
</style>
