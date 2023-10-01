<template>
  <div class="hotel-search">
    <h2>查询酒店信息</h2>
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
      <el-table :data="tableData" style="width: 100%">
        <!-- 酒店列 -->
        <el-table-column label="酒店" prop="hotelId"></el-table-column>

        <!-- 酒店是否为星级列 -->
        <el-table-column label="酒店是否为星级" prop="hotelStar"></el-table-column>

        <!-- 酒店房间总数列 -->
        <el-table-column label="酒店房间总数" prop="hotelRooms"></el-table-column>

        <!-- 酒店均价列 -->
        <el-table-column label="酒店均价" prop="hotelPrice"></el-table-column>

        <!-- 酒店剩余房间数列 -->
        <el-table-column label="酒店剩余房间数" prop="hotelRestNum"></el-table-column>

        <!-- 酒店是否营业列 -->
        <el-table-column label="酒店是否营业" prop="hotelState"></el-table-column>
      </el-table>
  </div>
</template>

<script>
export default {
  name: 'HotelSearch',
  data() {
    return {
      Form: {},
      options: [], // 提供spot_id:value,spot_name:label
      value: '',
      tableData: [],
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
      axios.get("http://" + this.$serverIP + ":8081/HotelSystem/"+this.value).then((res) => {
        this.tableData = res.data.data;
      });
    },
  },
};
</script>

<style scoped>
/* Your styles here */
</style>
