<template>
  <div class="emergency-edit">
    <h2>修改旅游应急信息</h2>
    <el-form :model="form" :rules="rules" ref="form" label-width="80px" class="demo-ruleForm">
      <el-form-item label="标题" prop="title">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input type="textarea" v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item label="有效期" prop="validity">
        <el-date-picker v-model="form.validity" type="date" value-format="yyyy-MM-dd" :picker-options="pickerOptions"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveChanges">保存</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'EmergencyInformationEdit',
  data() {
    return {
      form: {
        title: '',
        content: '',
        validity: ''
      },
      rules: {
        title: [{ required: true, message: '请输入标题', trigger: 'blur' }],
        content: [{ required: true, message: '请输入内容', trigger: 'blur' }],
        validity: [{ required: true, message: '请选择有效期', trigger: 'change' }]
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() < Date.now();
        }
      }
    };
  },
  methods: {
    saveChanges() {
      // 这里可以调用后端API保存修改后的信息
      // 示例：this.submitChanges();
    },
    cancel() {
      // 取消编辑，可以返回上一页或其他操作
      this.$router.back();
    }
    // 示例：submitChanges() {
    // 调用后端API保存修改后的信息
    // }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
