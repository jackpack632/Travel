<template>
  <div class="hotel-search">
    <h2>查询星级酒店房间预订情况</h2>
    <el-form :model="searchForm" :rules="searchRules" ref="searchForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="入住日期" prop="checkInDate">
        <el-date-picker v-model="searchForm.checkInDate" type="date"></el-date-picker>
      </el-form-item>
      <el-form-item label="离店日期" prop="checkOutDate">
        <el-date-picker v-model="searchForm.checkOutDate" type="date"></el-date-picker>
      </el-form-item>
      <!-- 其他查询条件项 -->
      <el-form-item>
        <el-button type="primary" @click="searchHotels">查询</el-button>
      </el-form-item>
    </el-form>
    <!-- 显示查询结果的酒店列表 -->
    <div v-if="searchResults.length">
      <h3>查询结果</h3>
      <ul>
        <li v-for="(hotel, index) in searchResults" :key="index">
          {{ hotel.name }} - {{ hotel.availableRooms }} 间房间可订
          <el-button type="success" @click="bookHotel(hotel)">预订</el-button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HotelSearch',
  data() {
    return {
      searchForm: {
        checkInDate: '',
        checkOutDate: ''
        // 其他查询条件
      },
      searchResults: [] // 查询结果
    };
  },
  computed: {
    searchRules() {
      // 编写查询条件的验证规则
      // 示例：返回一个包含验证规则的对象
    }
  },
  methods: {
    searchHotels() {
      // 这里可以调用后端API进行酒店查询
      // 示例：this.fetchHotelResults();
    },
    bookHotel(hotel) {
      // 这里可以调用后端API进行酒店预订
      // 示例：this.makeReservation(hotel);
    }
    // 示例：fetchHotelResults() {
    // 调用后端API获取酒店查询结果
    // }
    // 示例：makeReservation(hotel) {
    // 调用后端API进行酒店预订
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
