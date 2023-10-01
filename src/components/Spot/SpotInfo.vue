<template>
  <div class="Spot-Info">
    <h2>查询景区信息</h2>
    <el-form :model="Form">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="value" placeholder="请选择景区">
          <el-option
              v-for="item in options"
              :key="item.spotId"
              :label="item.spotName"
              :value="item.spotId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="select()">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="name"
          label="景区名称"
          width="180">
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  data() {
    return {
      Form: {},
      options: [], // 提供spot_id:value,spot_name:label
      value: '',
      tableData: [], // 存储查询到的路况信息
    };
  },
  mounted() {
    this.getOptions();
  },
  methods: {
    getOptions() {
      axios.get("http://" + this.$serverIP + ":8081/Spot").then((res) => {
        this.options = res.data.data;
      });
    },
    select() {
      // 假设根据选择的景区进行路况查询，并将结果存储在this.roadConditions中
      // 示例：this.roadConditions = yourQueryResults;
    },
  },
};
</script>

<style scoped>
/* Your styles here */
</style>
