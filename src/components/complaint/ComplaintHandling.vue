<template>
  <div class="complaint-handling">
    <el-button type="primary" v-on:click="returnPage()">返回</el-button>
    <h2>投诉处理</h2>
    <el-card :header="complaintHandling.thingid">
      <div class="content">
        <p>{{ complaintHandling.notion }}</p>
        <el-form :model="handlingForm" ref="handlingForm" label-width="80px">
          <el-form-item label="处理意见" prop="opinion">
            <el-input v-model="handlingForm.opinion" type="textarea" rows="4"></el-input>
          </el-form-item>
          <el-form-item label="上传附件" prop="attachments">
            <el-upload
                class="upload-demo"
                :action="uploadUrl"
                :on-success="handleUploadSuccess"
                :on-error="handleUploadError"
                :show-file-list="false"
            >
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitHandling">提交处理</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  props: {
    complaintHandling: {
      thingid: Number,
      notion: String,
      state: String
    }
  },
  data() {
    return {
      handlingForm: {
        opinion: '',
        attachments: ''
      },
      uploadUrl: '/upload' // 后端上传附件的接口地址
    };
  },
  methods: {
    submitHandling() {
      // 这里可以调用后端API提交处理数据
      // 示例：this.submitHandlingData();
    },
    handleUploadSuccess(response, file, fileList) {
      // 处理上传成功回调
    },
    handleUploadError(err, file, fileList) {
      // 处理上传失败回调
    },returnPage() {
      document.getElementsByClassName("complaint-handling")[0].style.display = "none";
      document.getElementById("complaintList").style.display = "block"
    }
  }
};
</script>

<style scoped>
.complaint-handling{
  display: none;
}
</style>
