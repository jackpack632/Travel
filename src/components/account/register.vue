<template>
  <el-dialog

      :visible.sync="dialogVisibleProp"
      width="30%"
      @close="closeForm()"
      center>
    <div slot="title" class="custom-dialog-title">注册账号</div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0" class="demo-ruleForm">
      <el-main>
        <el-form-item style="margin-bottom: 10px;">
          <el-input v-model="ruleForm.userName" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 10px;">
          <el-input v-model="ruleForm.e_mail" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 10px;">
          <el-input v-model="ruleForm.password" type="password" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 5px;">
          <el-input v-model="ruleForm.confirmPassword" type="password" placeholder="确认密码"></el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 10px;">
          <p>已有账号？<el-button type="text" @click="login()">登录账号</el-button></p>
        </el-form-item>
      </el-main>
    </el-form>
    <span slot="footer" class="dialog-footer" style="margin-top: 20px;">
      <div style="margin-top: -35px;">
        <el-button style="width: 370px" type="primary" @click="submitForm('ruleForm')">注册</el-button>
      </div>
    </span>
  </el-dialog>
</template>

<style scoped>
.custom-dialog-title {
  font-weight: bold;
  font-family: "Arial Black";
  font-size: 25px;
}
</style>

<script>
export default {
  props: ['dialogVisibleProp'],
  data() {
    return {
      RegisterVisible: false,
      ruleForm: {
        userName: '',
        password: '',
        confirmPassword: '',
        e_mail: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ],
        confirmPassword: [
          { required: true, message: '请再次输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ]
      }
    };
  },
  methods: {
    submitForm() {
      axios.post("http://"+this.$serverIP+":8081/register", this.ruleForm).then((res) => {
        if (res.data.code === 200) {
          this.$message({
            message: '注册成功',
            type: 'success'
          });
          this.closeForm();
        } else {
          this.$message({
            message: res.data.msg,
            type: 'error'
          });
        }
      }).catch((err) => {
        this.$message({
          message: '注册失败，系统出现问题',
          type: 'error'
        });
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    closeForm() {
      this.$emit('register', "close");//监听到点击关闭按钮，触发父组件的close事件
    },
    login() {
      this.$emit('register', "login");
    }
  },mounted() {
    this.ruleForm={
      userName: '',
      password: '',
      confirmPassword: '',
      e_mail: ''
    }
  }
}
</script>
