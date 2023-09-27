<template>
  <div class="emergency-publish">
    <h2>发布旅游应急信息</h2>
    <el-form :model="publishForm"  ref="publishForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="内容" prop="msg_notion">
        <el-input type="textarea" v-model="publishForm.msg_notion" rows="5"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="publishEmergencyInfo">发布信息</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'EmergencyInformationPublish',
  data() {
    return {
      publishForm: {
        msg_notion:"",
        msg_state:"未发布",
      },
    };
  },
  methods: {
    publishEmergencyInfo() {
      axios.post("http://localhost:8081/EmergencyInfo",this.publishForm).then((res)=>{
        if(res.data.code===200){
          this.$message.success("发布成功")
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch((err)=>{
        this.$message.error("发布失败，出现故障")
      })
    }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
