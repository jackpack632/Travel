<template>
  <div class="entertainment-group-query">
    <h2>查询营业性演出团体信息</h2>
    <el-form :model="queryForm" :rules="queryRules" ref="queryForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="queryForm.scenicArea" placeholder="请选择景区">
          <el-option label="景区A" value="scenicA"></el-option>
          <el-option label="景区B" value="scenicB"></el-option>
          <!-- 可以根据实际情况添加更多景区选项 -->
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryEntertainmentGroup">查询</el-button>
      </el-form-item>
    </el-form>

    <div v-if="entertainmentGroupData">
      <h3>{{ entertainmentGroupData.scenicArea }}的营业性演出团体信息</h3>
      <p>演出类型：{{ entertainmentGroupData.showType }}</p>
      <p>团体名称：{{ entertainmentGroupData.groupName }}</p>
      <!-- 其他营业性演出团体相关信息 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'EntertainmentGroupQuery',
  data() {
    return {
      queryForm: {
        scenicArea: ''
      },
      queryRules: {
        scenicArea: [{ required: true, message: '请选择景区', trigger: 'change' }]
      },
      entertainmentGroupData: null
    };
  },
  methods: {
    queryEntertainmentGroup() {
      // 这里可以调用后端API查询营业性演出团体信息
      // 示例：this.getEntertainmentGroupData();
    }
    // 示例：getEntertainmentGroupData() {
    // 调用后端API查询营业性演出团体信息并更新entertainmentGroupData
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
