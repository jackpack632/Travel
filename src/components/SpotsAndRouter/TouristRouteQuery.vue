<template>
  <div class="tourist-route-query">
    <h2>查询旅游线路信息</h2>
    <el-form :model="queryForm" :rules="queryRules" ref="queryForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="queryForm.scenicArea" placeholder="请选择景区">
          <el-option label="景区A" value="scenicA"></el-option>
          <el-option label="景区B" value="scenicB"></el-option>
          <!-- 可以根据实际情况添加更多景区选项 -->
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryTouristRoute">查询</el-button>
      </el-form-item>
    </el-form>

    <div v-if="touristRouteData">
      <h3>{{ touristRouteData.scenicArea }}的旅游线路信息</h3>
      <p>线路名称：{{ touristRouteData.routeName }}</p>
      <p>线路类型：{{ touristRouteData.routeType }}</p>
      <!-- 其他旅游线路相关信息 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'TouristRouteQuery',
  data() {
    return {
      queryForm: {
        scenicArea: ''
      },
      queryRules: {
        scenicArea: [{ required: true, message: '请选择景区', trigger: 'change' }]
      },
      touristRouteData: null
    };
  },
  methods: {
    queryTouristRoute() {
      // 这里可以调用后端API查询旅游线路信息
      // 示例：this.getTouristRouteData();
    }
    // 示例：getTouristRouteData() {
    // 调用后端API查询旅游线路信息并更新touristRouteData
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
