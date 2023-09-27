<template>
  <div class="room-info-entry">
    <h2>录入酒店房间信息</h2>
    <el-form :model="roomForm" :rules="roomRules" ref="roomForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="房间类型" prop="roomType">
        <el-input v-model="roomForm.roomType"></el-input>
      </el-form-item>
      <el-form-item label="可用房间数" prop="availableRooms">
        <el-input v-model="roomForm.availableRooms"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitRoomInfo">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'RoomInfoEntry',
  data() {
    return {
      roomForm: {
        roomType: '',
        availableRooms: ''
      },
      roomRules: {
        roomType: [{ required: true, message: '请输入房间类型', trigger: 'blur' }],
        availableRooms: [
          { required: true, message: '请输入可用房间数', trigger: 'blur' },
          { type: 'number', message: '请输入数字' }
        ]
      }
    };
  },
  methods: {
    submitRoomInfo() {
      // 这里可以调用后端API提交房间信息
      // 示例：this.saveRoomInfo();
    }
    // 示例：saveRoomInfo() {
    // 调用后端API保存房间信息
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
