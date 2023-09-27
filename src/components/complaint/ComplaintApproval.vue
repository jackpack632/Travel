<template>
  <div class="complaint-approval">
    <el-button type="primary" v-on:click="returnPage()">返回</el-button>
    <h2>投诉审批</h2>
    <el-card :header="complaintApproval.thingid">
      <div class="content">
        <p>{{ complaintApproval.notion }}</p>
        <el-form :model="approvalForm"  ref="approvalForm" label-width="80px">

          <el-form-item label="审批结果" prop="status">
            <el-radio-group v-model="approvalForm.status">
              <el-radio label="approved">通过</el-radio>
              <el-radio label="rejected">拒绝</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-button type="primary" @click="submitApproval">提交审批</el-button>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  props: {
    complaintApproval: {
      thingid: Number,
      notion: String
    }
  },
  data() {
    return {
      approvalForm: {
        comment: '',
        status: 'approved' // 默认通过审批
      }
    };
  },
  methods: {
    submitApproval() {
      // 这里可以调用后端API提交审批数据
      // 示例：this.submitApprovalData();
    },
    returnPage(){
      document.getElementsByClassName("complaint-approval")[0].style.display="none";
      document.getElementById("complaintList").style.display="block"
    }
  }
};
</script>

<style scoped>
.complaint-approval{
  display: none;
}
</style>
