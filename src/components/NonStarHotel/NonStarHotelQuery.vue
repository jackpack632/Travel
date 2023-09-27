<template>
  <div class="non-star-hotel-query">
    <h2>查询非星级酒店房间预订情况</h2>
    <el-form :model="queryForm" :rules="queryRules" ref="queryForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="选择城市" prop="city">
        <el-select v-model="queryForm.city" placeholder="请选择城市">
          <el-option label="城市A" value="cityA"></el-option>
          <el-option label="城市B" value="cityB"></el-option>
          <!-- 可以根据实际情况添加更多城市选项 -->
        </el-select>
      </el-form-item>
      <el-form-item label="入住日期" prop="checkInDate">
        <el-date-picker v-model="queryForm.checkInDate" type="date" placeholder="选择日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="退房日期" prop="checkOutDate">
        <el-date-picker v-model="queryForm.checkOutDate" type="date" placeholder="选择日期"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryNonStarHotels">查询</el-button>
      </el-form-item>
    </el-form>

    <div v-if="nonStarHotelList.length">
      <h3>非星级酒店列表</h3>
      <ul>
        <li v-for="(hotel, index) in nonStarHotelList" :key="index">
          <h4>{{ hotel.name }}</h4>
          <p>城市：{{ hotel.city }}</p>
          <p>房间剩余：{{ hotel.availableRooms }}间</p>
          <el-button type="primary" @click="bookRoom(hotel)">预订</el-button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NonStarHotelQuery',
  data() {
    return {
      queryForm: {
        city: '',
        checkInDate: '',
        checkOutDate: ''
      },
      queryRules: {
        city: [{ required: true, message: '请选择城市', trigger: 'change' }],
        checkInDate: [{ required: true, message: '请选择入住日期', trigger: 'change' }],
        checkOutDate: [{ required: true, message: '请选择退房日期', trigger: 'change' }]
      },
      nonStarHotelList: []
    };
  },
  methods: {
    queryNonStarHotels() {
      // 这里可以调用后端API查询非星级酒店信息
      // 示例：this.getNonStarHotelList();
    },
    bookRoom(hotel) {
      // 处理预订逻辑，例如跳转到预订页面
    }
    // 示例：getNonStarHotelList() {
    // 调用后端API查询非星级酒店信息并更新nonStarHotelList
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
