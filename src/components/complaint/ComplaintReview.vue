<template>
  <div class="complaint-review">
    <h2 class="review-title">投诉评价</h2>
    <p>投诉编号: {{ complaintView.thingid }}</p>
    <p>投诉内容: {{ complaintView.notion }}</p>
    <p>处理结果: {{ complaintView.state }}</p>

    <h3 class="rating-section">评价打分</h3>
    <el-rate v-model="rating" :max="5"></el-rate>

    <h3>评价意见</h3>
    <el-input v-model="comment" type="textarea" rows="4"></el-input>

    <div class="button-container">
      <el-button type="primary" v-on:click="returnPage()" class="return-button">返回</el-button>
      <el-button type="primary" @click="submitReview" class="submit-button">提交评价</el-button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    complaintView: {
      thingid: Number,
      notion: String,
      state: String
    }
  },
  data() {
    return {
      rating: 0, // 评分
      comment: '' // 评价意见
    };
  },
  methods: {
    submitReview() {
      // 这里可以调用后端API提交评价数据
      // 示例：this.submitReviewData();
    },
    returnPage() {
      document.getElementsByClassName("complaint-review")[0].style.display = "none";
      document.getElementById("complaintList").style.display = "block";
    }
  }
};
</script>

<style scoped>
.complaint-review {
  padding-top: 20px; /* 添加上方内边距 */
  display: none;
}

.review-title {
  font-size: 30px; /* 放大字体大小 */
  font-weight: bold; /* 加粗字体 */
  margin-bottom: 20px; /* 添加下方间距 */
  margin-top: -20px; /* 将标题向上移动 */
}
.rating-section {
   margin-top: 20px; /* 增加评分和评价意见之间的间距 */
 }
.button-container {
  margin-top: 10px; /* 添加按钮与上方内容的间距 */
}
</style>
