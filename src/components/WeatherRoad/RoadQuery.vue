<template>
  <div class="Road-query">
    <h2>查询路况信息</h2>
    <el-form :model="Form">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="value" placeholder="请选择景区">
          <el-option
          v-for="item in options"
          :key="item.spotId"
          :label="item.spotName"
          :value="item.spotId">
          </el-option>
      </el-select>
    </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="select()">查询</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {

  data() {
    return {
      Form: {
      },
      options: [],//提供spot_id:value,spot_name:label
      value: '',
    };
  },mounted() {
    this.getOptions();
  },
  methods: {
    getOptions(){
      axios.get("http://"+this.$serverIP+":8081/WeatherRoadSystem").then((res) => {
        this.options = res.data.data;
      })
    }

  }
};
</script>

<style scoped>
/* Your styles here */
</style>
