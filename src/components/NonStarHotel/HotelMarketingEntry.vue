<template>
  <div class="hotel-marketing-entry">
    <h2>录入非星级酒店营销信息</h2>
    <el-form :model="marketingForm" :rules="marketingRules" ref="marketingForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="游客状况" prop="visitorStatus">
        <el-input v-model="marketingForm.visitorStatus"></el-input>
      </el-form-item>
      <el-form-item label="营销信息" prop="marketingInfo">
        <el-input type="textarea" v-model="marketingForm.marketingInfo"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitMarketingInfo">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'HotelMarketingEntry',
  data() {
    return {
      marketingForm: {
        visitorStatus: '',
        marketingInfo: ''
      },
      marketingRules: {
        visitorStatus: [{ required: true, message: '请输入游客状况', trigger: 'blur' }],
        marketingInfo: [{ required: true, message: '请输入营销信息', trigger: 'blur' }]
      }
    };
  },
  methods: {
    submitMarketingInfo() {
      // 这里可以调用后端API提交营销信息
      // 示例：this.saveMarketingInfo();
    }
    // 示例：saveMarketingInfo() {
    // 调用后端API保存营销信息
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
