<template>
  <el-dialog
      :visible.sync="dialogVisibleProp"
      width="30%"
      @close="closeForm()"
      center>
    <div slot="title" class="custom-dialog-title">登录账号</div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0">
      <el-main>
        <el-form-item>
          <div class="prefix-container">
            <el-select v-model="prefix" class="prefix-selector">
              <el-option value="+86" label="+86"></el-option>
            </el-select>
            <el-input
                v-model="ruleForm.id"
                placeholder="请输入手机号"
                class="left-align input-with-prefix">
            </el-input>
          </div>
        </el-form-item>
        <el-form-item>
          <el-input
              v-model="ruleForm.password"
              type="password"
              placeholder="请输入密码"
              class="left-align input-with-prefix">
          </el-input>
        </el-form-item>
        <el-form-item class="login-button-item">
          <el-button style="width: 370px" type="primary" @click="submitForm('ruleForm')" class="input-with-prefix">登录</el-button>
        </el-form-item>
        <div class="footer-links">
          <div class="register-link">
            <el-button type="text" @click="register">没有账号？注册账号</el-button>
          </div>
          <div class="forgot-password">
            <a href="#">忘记密码? 找回密码</a>
          </div>
        </div>
      </el-main>
    </el-form>
  </el-dialog>
</template>

<style scoped>
.custom-dialog-title {
  font-weight: bold;
  font-family: "Arial Black";
  font-size: 25px;
}
.dialog-footer {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.el-button--primary {
  background-color: #007BFF;
  border-color: #007BFF;
}

.el-button--primary:hover {
  background-color: #0056b3;
  border-color: #0056b3;
}

.left-align .el-input__inner {
  text-align: left;
}

.prefix-container {
  display: flex;
  align-items: center;
}

.prefix-selector {
  width: 100px;
  margin-right: 5px;
}

.input-with-prefix .el-input__inner {
  padding-left: 70px;
}

.input-with-prefix .el-input-group__append {
  display: flex;
  align-items: center;
  border: 1px solid #ccc;
  padding: 0 5px;
}

.password-label {
  margin-right: 5px;
}

.login-button-item {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.footer-links {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
}

.register-link,
.forgot-password {
  color: #888;
  font-size: 14px;
}

.register-link el-button[type="text"] {
  color: #007BFF;
  text-decoration: underline;
}

.forgot-password a {
  color: #007BFF;
  text-decoration: underline;
}
</style>

<script>
export default {

  props: ['dialogVisibleProp'],
  data() {
    return {
      ruleForm: {
        id: '',
        password: ''
      },
      prefix: '+86',
      rules: {
        name: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    closeForm() {
      this.$emit('close', 'close');
    },
    register() {
      this.$emit('close', 'register');
    },
    submitForm(formName) {
      axios.post("http://"+this.$serverIP+":8081/Login",this.ruleForm).then((res)=>{
        if(res.data.code===200){
          this.$message.success("登录成功")
          localStorage.setItem('token', res.data.data);//将token存储在localStorage中
          this.$emit('close', 'close');
          this.$emit('login', 'login');
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch((err)=>{
        this.$message.error("登录失败，出现故障")
      })
    }
  }
};
</script>
