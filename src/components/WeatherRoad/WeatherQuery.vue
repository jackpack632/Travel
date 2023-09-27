<template>
  <div class="weather-query">
    <h2>查询天气状况</h2>
    <el-form :model="queryForm" :rules="queryRules" ref="queryForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="queryForm.scenicArea" placeholder="请选择景区">
          <el-option label="景区A" value="scenicA"></el-option>
          <el-option label="景区B" value="scenicB"></el-option>
          <!-- 可以根据实际情况添加更多景区选项 -->
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryWeather">查询</el-button>
      </el-form-item>
    </el-form>

    <div v-if="weatherData">
      <h3>{{ weatherData.scenicArea }}的天气状况</h3>
      <p>当前温度：{{ weatherData.temperature }}</p>
      <p>天气情况：{{ weatherData.condition }}</p>
      <!-- 其他天气相关信息 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'WeatherQuery',
  data() {
    return {
      queryForm: {
        scenicArea: ''
      },
      queryRules: {
        scenicArea: [{ required: true, message: '请选择景区', trigger: 'change' }]
      },
      weatherData: null
    };
  },
  methods: {
    queryWeather() {
      // 这里可以调用后端API查询天气信息
      // 示例：this.getWeatherData();
    }
    // 示例：getWeatherData() {
    // 调用后端API查询天气信息并更新weatherData
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
