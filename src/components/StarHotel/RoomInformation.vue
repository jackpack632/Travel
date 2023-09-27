<template>
  <div class="room-information">
    <h2>录入酒店房间实时预订信息</h2>
    <el-form :model="roomForm" :rules="roomRules" ref="roomForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="房间号" prop="roomNumber">
        <el-input v-model="roomForm.roomNumber"></el-input>
      </el-form-item>
      <el-form-item label="房间类型" prop="roomType">
        <el-select v-model="roomForm.roomType" placeholder="请选择房间类型">
          <el-option label="单人间" value="single"></el-option>
          <el-option label="双人间" value="double"></el-option>
          <!-- 其他房间类型选项 -->
        </el-select>
      </el-form-item>
      <el-form-item label="房间价格" prop="roomPrice">
        <el-input v-model="roomForm.roomPrice" type="number"></el-input>
      </el-form-item>
      <!-- 其他房间信息项 -->
      <el-form-item>
        <el-button type="primary" @click="submitRoomInfo">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'RoomInformation',
  data() {
    return {
      roomForm: {
        roomNumber: '',
        roomType: '',
        roomPrice: ''
        // 其他房间信息
      },
      roomRules: {
        // 编写房间信息的验证规则
        // 示例：返回一个包含验证规则的对象
      }
    };
  },
  methods: {
    submitRoomInfo() {
      // 这里可以调用后端API提交房间信息
      // 示例：this.saveRoomInformation();
    }
    // 示例：saveRoomInformation() {
    // 调用后端API保存房间信息
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
