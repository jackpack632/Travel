<template>

  <el-form :model="ruleForm"  ref="ruleForm" label-width="90px" class="demo-ruleForm">
    <h3>提交投诉</h3>

    <el-form-item label="投诉内容" prop="desc">
      <el-input type="textarea"
                placeholder="请输入投诉内容"
                v-model="ruleForm.notion">
      </el-input>
    </el-form-item>
    <el-upload
    class="upload-demo"
    action="https://jsonplaceholder.typicode.com/posts/"
    :on-change="handleChange"
    :file-list="fileList">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传图片或视频文件，且不超过1GB</div>
    </el-upload>
    <el-form-item>
      <el-button type="primary" @click="submitForm()">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from '../../utils/Axios'

export default {
  data() {
    return {
      fileList: [],
      ruleForm: {
        notion: '',
        other: '',//暂时写死
        visitor_id:2,//暂时写死
        time: new Date(),
        state: '处理中',
        result:null,
        evaluate:null
      },
  }},
  methods: {
    submitForm() {
      axios.post("http://localhost:8081/ComplaintSystem",this.ruleForm).then((res)=>{
        if(res.data.code===200){
          this.$message.success("提交成功")
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch((err)=>{
        this.$message.error("提交失败，出现故障")
      })

    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },handleChange(file, fileList) {
      this.fileList = fileList.slice(-3);
    },
  },
}
</script>

<style scoped>
/* Your styles here */
</style>
