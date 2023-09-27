<template>
  <div class="hotel-marketing">
    <h2 class="section-title">星级酒店营销</h2>
    <div class="section">
      <h3 class="subsection-title">导流情况</h3>
      <div class="marketing-status">
        <p>
          今日访问量：<span class="count">{{ visitorCount }}</span>
          <br>
          预订数量：<span class="count">{{ bookingCount }}</span>
        </p>
      </div>
    </div>
    <div class="section">
      <h3 class="subsection-title">星级酒店信息</h3>
      <div class="hotel-list">
        <!-- 星级酒店信息列表展示，例如： -->
        <div v-for="hotel in hotelList" :key="hotel.id">
          <h4>{{ hotel.name }}</h4>
          <p class="info">类型：{{ hotel.type }}</p>
          <p class="info">地址：{{ hotel.address }}</p>
          <el-button type="primary" class="submit-button">提交信息</el-button>
          <!-- 其他星级酒店信息项 -->
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'HotelMarketing',
  data() {
    return {
      visitorCount: 0,
      bookingCount: 0,
      hotelList: []
    };
  },
  created() {
    // 示例：调用后端API获取导流情况和星级酒店信息
    // this.fetchMarketingStatus();
    // this.fetchHotelList();
  },
  methods: {
    // 示例：fetchMarketingStatus() {
    // 调用后端API获取导流情况
    // }
    // 示例：fetchHotelList() {
    // 调用后端API获取星级酒店信息列表
    // }
  }
};
</script>

<style scoped>
/* 其他样式规则 */

.marketing-status p {
  margin: 0;
  padding: 10px;
  background-color: #f2f2f2;
  border-radius: 5px;
}

.count {
  font-weight: bold;
  display: block; /* 改变 span 默认的行内元素属性，使其显示为块元素 */
}
.submit-button {
  background-color: #3498db;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
}

/* 示例：其他样式规则 */
</style>