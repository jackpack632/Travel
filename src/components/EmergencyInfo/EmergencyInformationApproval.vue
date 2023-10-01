<template>
  <div class="emergency-approval">
    <h2>审批旅游应急信息</h2>
    <el-table :data="approvalList" style="width: 100%">
      <el-table-column prop="title" label="信息分类"></el-table-column>
      <el-table-column prop="content" label="内容"></el-table-column>
      <el-table-column prop="validity" label="有效期">
        <template slot-scope="scope">
          {{ scope.row.validity | formatDate }}
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="approveInfo(scope.row)">通过</el-button>
          <el-button type="danger" @click="rejectInfo(scope.row)">驳回</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'EmergencyInformationApproval',
  data() {
    return {
      approvalList: [
        // 示例数据，待审批的应急信息列表
        { title: '紧急通知', content: '发现紧急情况，请大家注意安全。', validity: '2023-08-31' },
        { title: '天气预警', content: '预计本周末将有大雨，请做好准备。', validity: '2023-08-25' }
      ]
    };
  },
  methods: {
    approveInfo(info) {
      // 这里可以调用后端API进行信息审批通过操作
      // 示例：this.submitApproval('approve', info);
    },
    rejectInfo(info) {
      // 这里可以调用后端API进行信息驳回操作
      // 示例：this.submitApproval('reject', info);
    }
    // 示例：submitApproval(action, info) {
    // 调用后端API进行信息审批操作，传入操作类型（approve或reject）和信息对象
    // }
  },
  filters: {
    formatDate(date) {
      // 格式化日期，你可以根据需要使用日期格式化库
      return new Date(date).toLocaleDateString();
    }
  }
};
</script>

<style scoped>
/* Your styles here */
</style>
