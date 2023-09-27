
<template>
    <el-dialog
        title="登录账号"
        :visible.sync="dialogVisible"
        width="30%"
        center>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="130px" class="demo-ruleForm">

        <el-main>
          <el-form-item label="用户名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
        </el-main>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
              <p>没有账号？<a href="">注册</a></p>
              <p>忘记密码?<a href="#">找回密码</a></p>
      </span>
    </el-dialog>
</template>

<style scoped>

</style>
<script>
export default {
  data() {
    return{
      dialogVisible: true,
      ruleForm: {
        name: '',
        password: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ]
      }
    }
  },methods: {
    closeForm() {
      /*
      * 子组件向父组件传值时用自定义事件
      * */
      this.$emit('close', false);
    }
  }
};
</script>