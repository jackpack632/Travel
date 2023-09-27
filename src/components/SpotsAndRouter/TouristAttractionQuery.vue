<template>
  <div class="tourist-attraction-query">
    <h2>查询旅游景区信息</h2>
    <el-form :model="queryForm" :rules="queryRules" ref="queryForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="queryForm.scenicArea" placeholder="请选择景区">
          <el-option label="景区A" value="scenicA"></el-option>
          <el-option label="景区B" value="scenicB"></el-option>
          <!-- 可以根据实际情况添加更多景区选项 -->
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryTouristAttraction">查询</el-button>
      </el-form-item>
    </el-form>

    <div v-if="touristAttractionData">
      <h3>{{ touristAttractionData.scenicArea }}的旅游景区信息</h3>
      <p>景区名称：{{ touristAttractionData.attractionName }}</p>
      <p>景区类型：{{ touristAttractionData.attractionType }}</p>
      <!-- 其他旅游景区相关信息 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'TouristAttractionQuery',
  data() {
    return {
      queryForm: {
        scenicArea: ''
      },
      queryRules: {
        scenicArea: [{ required: true, message: '请选择景区', trigger: 'change' }]
      },
      touristAttractionData: null
    };
  },
  methods: {
    queryTouristAttraction() {
      // 这里可以调用后端API查询旅游景区信息
      // 示例：this.getTouristAttractionData();
    }
    // 示例：getTouristAttractionData() {
    // 调用后端API查询旅游景区信息并更新touristAttractionData
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
