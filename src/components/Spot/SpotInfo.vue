<template>
  <div class="Spot-Info">
    <h2>查询景区信息</h2>
    <el-form :model="Form">
      <el-form-item label="选择景区" prop="scenicArea">
        <el-select v-model="value" placeholder="请选择景区">
          <el-option
              v-for="item in options"
              :key="item.spotName"
              :label="item.spotName"
              :value="item.spotName"
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
          prop="spotName"
          label="景区名称">
      </el-table-column>
      <el-table-column
          prop="spotMsg"
          label="景区信息">
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
      axios.get("http://" + this.$serverIP + ":8081/Spot/" + this.value).then((res) => {
        this.tableData = res.data.data;
      });
    },
  },
};
</script>

<style scoped>
/* Your styles here */
</style>
