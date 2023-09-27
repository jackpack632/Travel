<template>
  <div class="admin-page">


    <el-card class="box-card">
      <div slot="header" class="header-container">
        <div class="title">
          <h2>旅游应急信息列表</h2>
        </div>
        <div class="search-container">
          <el-input
            placeholder="请输入内容"
            v-model="input4"
            style="width: 300px;"
            class="search-input"
          >
            <i slot="prefix" class="el-input__icon el-icon-search"></i>
          </el-input>
          <el-button type="primary">搜索</el-button>
        </div>
      </div>
      <div v-for="(emergency, index) in emergencyList" :key="index" class="text item">
            <div class="emergency-item">
              <p>紧急通知: {{ emergency.title }}</p>
              <p>内容: {{ emergency.content }}</p>
              <p>日期: {{ emergency.date }}</p>
            </div>
            <hr class="emergency-divider">
          </div>
    </el-card>
  </div>
</template>

<script>
import EmergencySearch from '@/components/EmergencyInfo/EmergencySearch.vue';
import EmergencyList from '@/components/EmergencyInfo/EmergencyList.vue';

export default {
  components: {
    EmergencySearch,
    EmergencyList
  },
  data() {
    return {
      emergencyList: [
        "'紧急通知1',  '内容1',  '2023-12-31'",
        "'紧急通知1',  '内容1',  '2023-12-31'",
        "'紧急通知1',  '内容1',  '2023-12-31'",
        "'紧急通知1',  '内容1',  '2023-12-31'",
        // ...
      ],
      filteredEmergencyList: []
    };
  },
  methods: {
    updateEmergencyList(searchResult) {
      this.filteredEmergencyList = searchResult;
    }
  }
};
</script>

<style scoped>
.header-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.title {
  flex: 1; /* 让标题占据剩余空间 */
}



.search-input {
  margin-right: 10px;
}
.search-container {
  display: flex;
  justify-content: flex-end; /* 将内容向右对齐 */
  align-items: center; /* 垂直居中对齐 */
}
.emergency-item {
  margin: 20px 0; /* 上下间距 */
  padding: 10px; /* 内边距 */
  border: 1px solid #ccc; /* 可选：添加边框 */
}

.emergency-divider {
  margin: 20px 0;

}
</style>
