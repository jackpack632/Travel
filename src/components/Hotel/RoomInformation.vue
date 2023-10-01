<template>
  <div>
    <!-- 添加按钮 -->
    <el-button type="primary" @click="showAddDialog">添加房间信息</el-button>

    <!-- 房间信息表格 -->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="酒店" prop="hotelId"></el-table-column>
      <el-table-column label="是否为星级" prop="hotelStar"></el-table-column>
      <el-table-column label="房间总数" prop="hotelRooms"></el-table-column>
      <el-table-column label="均价" prop="hotelPrice"></el-table-column>
      <el-table-column label="剩余房间数" prop="hotelRestNum"></el-table-column>
      <el-table-column label="是否营业" prop="hotelState"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="showEditDialog(scope.row)">修改</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加/修改对话框 -->
    <el-dialog :visible.sync="dialogVisible" :title="dialogTitle" @close="handleDialogClose">
      <el-form :model="editedData" label-width="80px">
        <el-form-item label="酒店名称">
          <el-input v-model="editedData.hotelId"></el-input>
        </el-form-item>
        <el-form-item label="是否为星级">
          <el-switch v-model="editedData.hotelStar"></el-switch>
        </el-form-item>
        <el-form-item label="房间总数">
          <el-input v-model.number="editedData.hotelRooms" type="number"></el-input>
        </el-form-item>
        <el-form-item label="均价">
          <el-input v-model.number="editedData.hotelPrice" type="number"></el-input>
        </el-form-item>
        <el-form-item label="剩余房间数">
          <el-input v-model.number="editedData.hotelRestNum" type="number"></el-input>
        </el-form-item>
        <el-form-item label="是否营业">
          <el-switch v-model="editedData.hotelState"></el-switch>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="saveData">保存</el-button>
          <el-button @click="handleDialogClose">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import axios from '../../utils/Axios'
export default {
  data() {
    return {
      tableData: [],
      dialogVisible: false,
      dialogTitle: '',
      editedData: {},
    };
  },mounted() {
    axios.get("http://" + this.$serverIP + ":8081/HotelSystem/admin/information").then((res) => {
      this.tableData = res.data.data;
    });
  },
  methods: {
    showAddDialog() {
      this.dialogVisible = true;
      this.dialogTitle = '添加房间信息';
      this.editedData = {}; // 清空编辑数据
    },
    showEditDialog(row) {
      this.dialogVisible = true;
      this.dialogTitle = '修改房间信息';
      this.editedData = { ...row }; // 使用深拷贝防止修改影响原数据
    },
    handleDialogClose() {
      this.dialogVisible = false;
      this.editedData = {}; // 清空编辑数据
    },
    saveData() {
      // 保存数据的逻辑，可以根据需要发送请求到后端
      if (this.dialogTitle === '添加房间信息') {
        // 添加数据
        axios.post("http://" + this.$serverIP + ":8081/HotelSystem/admin/information",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        });
      } else {
        // 修改数据
        axios.put("http://" + this.$serverIP + ":8081/HotelSystem/admin/information",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        });
      }
      this.handleDialogClose();
    },
  },
  watch: {
    tableData: {
      handler() {
        // 数据变化时重新进行搜索
        this.handleSearch();
      },
      deep: true,
    },
  },
  created() {
    // 初始化时进行搜索
    this.handleSearch();
  },
};
</script>
