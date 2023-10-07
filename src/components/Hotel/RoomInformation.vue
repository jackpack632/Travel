<template>
  <div><h2>酒店信息调整</h2>
    <!-- 添加按钮 -->
    <el-button type="primary" @click="showAddDialog">添加房间信息</el-button>

    <!-- 房间信息表格 -->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="酒店名称" prop="hotelName"></el-table-column>
      <el-table-column label="是否为星级" prop="hotelStar"></el-table-column>
      <el-table-column label="房间总数" prop="hotelRooms"></el-table-column>
      <el-table-column label="均价" prop="hotelPrice"></el-table-column>
      <el-table-column label="剩余房间数" prop="hotelRestNum"></el-table-column>
      <el-table-column label="是否营业" prop="hotelState"></el-table-column>
      <el-table-column label="所属景区" prop="spotName"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-row type="flex" justify="start">
            <el-button size="medium" type="success" @click="showEditDialog(scope.row)">修改</el-button>
            <el-button size="medium" type="warning" @click="deleteData(scope.row)">删除</el-button></el-row>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加/修改对话框 -->
    <el-dialog :visible.sync="dialogVisible" :title="dialogTitle" @close="handleDialogClose">
      <el-form :model="editedData" label-width="80px">
        <el-form-item label="酒店名称">
          <el-input v-model="editedData.hotelName"></el-input>
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
          <el-radio-group v-model="editedData.hotelState">
            <el-radio-button label="是"></el-radio-button>
            <el-radio-button label="否"></el-radio-button>
          </el-radio-group>
        </el-form-item>
          <el-form-item label="是否为星级">
            <el-radio-group v-model="editedData.hotelStar">
              <el-radio-button label="是"></el-radio-button>
              <el-radio-button label="否"></el-radio-button>
            </el-radio-group>
          </el-form-item>
        <el-form-item>
          <el-form >
            <el-form-item label="选择景区" prop="scenicArea">
              <el-select v-model="editedData.spotName" placeholder="请选择景区">
                <el-option
                    v-for="item in options"
                    :key="item.spotspotName"
                    :label="item.spotName"
                    :value="item.spotName"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-form>
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
      options: [],
      editedData: {},
    };
  },mounted() {
    this.handleSearch();
    this.getOptions();
  },
  methods: {
    getOptions() {
      axios.get("http://" + this.$serverIP + ":8081/Spot").then((res) => {
        this.options = res.data.data;
      });
    },
    handleSearch() {
      axios.get("http://" + this.$serverIP + ":8081/HotelSystem/admin/information").then((res) => {
        this.tableData = res.data.data;
      });
    },
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
        }).finally(() => {
          this.handleSearch();
        })
      } else {
        // 修改数据
        axios.put("http://" + this.$serverIP + ":8081/HotelSystem/admin/information",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        }).finally(() => {
          this.handleSearch();
        })
      }
      this.handleDialogClose();
    },deleteData(row) {
      // 删除数据的逻辑，可以根据需要发送请求到后端
      axios.delete("http://" + this.$serverIP + ":8081/HotelSystem/admin/information/" + row.hotelId).then((res) => {
        if (res.data.code === 200) {
          this.$message.success(res.data.msg);
        } else {
          this.$message.error(res.data.msg);
        }
      }).finally(() => {
        this.handleSearch();
      })
    }
  }
};
</script>
