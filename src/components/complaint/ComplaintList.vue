<template>
  <div>
    <div id="complaintList">
      <h2>投诉列表</h2>
      <el-table :data="complaints" style="width: 100%">
        <el-table-column prop="thingid" label="投诉编号"></el-table-column>
        <el-table-column label="投诉时间">
          <template slot-scope="scope">
            {{ scope.row.time | formatDate }}
          </template>
        </el-table-column>
        <el-table-column show-overflow-tooltip="show-overflow-tooltip" prop="notion" label="内容"></el-table-column>
        <el-table-column prop="state" label="状态"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-row type="flex" justify="flex-start"> <!-- 使用 flex-start 控制左对齐 -->
              <el-col :span="6">
                <el-button size="small" type="primary" v-on:click="detail(scope.row.thingid)">详情</el-button>
              </el-col>
              <el-col :span="6">
                <el-button size="small" type="success" v-on:click="evaluate(scope.row.thingid)">评价</el-button>
              </el-col>
              <el-col :span="6">
                <el-button size="small" type="warning" v-on:click="approval(scope.row.thingid)">审核</el-button>
              </el-col>
              <el-col :span="6">
                <el-button size="small" type="danger" v-on:click="handling(scope.row.thingid)">处理</el-button>
              </el-col>
            </el-row>
          </template>
        </el-table-column>
        <!-- 添加一个空白列 -->
        <el-table-column label="" width="80"></el-table-column>

      </el-table>
    </div>
    <!-- 其他组件 -->
    <ComplaintReview  :complaintView="viewComplaint"></ComplaintReview>
    <ComplaintApproval :complaintApproval="viewComplaint"></ComplaintApproval>
    <ComplaintHandling :complaintHandling="viewComplaint"></ComplaintHandling>

  </div>
</template>

<script>
import axios from '../../utils/Axios'
import ComplaintReview from "@/components/complaint/ComplaintReview.vue";
import ComplaintApproval from "@/components/complaint/ComplaintApproval.vue";
import ComplaintHandling from "@/components/complaint/ComplaintHandling.vue";

export default {
  components: { ComplaintReview, ComplaintApproval, ComplaintHandling },
  data() {
    return {
      complaints: [], // 这里模拟投诉数据，实际应从后端获取
      viewComplaint: {
        thingid: "暂无数据",
        notion: "暂无数据",
        state: "暂无数据"
      } // 查看的投诉
    };
  },
  mounted() {
    // 这里可以调用后端API获取投诉列表数据
    // 示例：this.fetchComplaints();
    this.getAllComplaints();
  },
  methods: {
    getAllComplaints() {
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem").then((res) => {
        if (res.data.code === 200) {
          this.complaints = res.data.data;
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        this.$message.error("获取失败，出现故障");
      });
    },
    detail(id) {
      document.getElementById("complaintList").style.display = "none";
      document.getElementsByClassName("complaint-review")[0].style.display = "block";
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem/" + id).then((res) => {
        if (res.data.code === 200) {
          this.viewComplaint = res.data.data;
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        this.$message.error("获取失败，出现故障");
      });
    },
    evaluate(id) {
      document.getElementById("complaintList").style.display = "none";
      document.getElementsByClassName("complaint-review")[0].style.display = "block";
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem/" + id).then((res) => {
        if (res.data.code === 200) {
          this.viewComplaint = res.data.data;
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        this.$message.error("获取失败，出现故障");
      });
    },
    approval(id) {
      document.getElementById("complaintList").style.display = "none";
      document.getElementsByClassName("complaint-approval")[0].style.display = "block";
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem/" + id).then((res) => {
        if (res.data.code === 200) {
          this.viewComplaint = res.data.data;
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        this.$message.error("获取失败，出现故障");
      });
    },
    handling(id) {
      document.getElementById("complaintList").style.display = "none";
      document.getElementsByClassName("complaint-handling")[0].style.display = "block";
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem/" + id).then((res) => {
        if (res.data.code === 200) {
          this.viewComplaint = res.data.data;
        } else {
          this.$message.error(res.data.msg);
        }
      }).catch((err) => {
        this.$message.error("获取失败，出现故障");
      });
    }
  },
  filters: {
    formatDate(date) {
      // 格式化日期，你可以根据需要使用日期格式化库
      return new Date(date).toLocaleDateString();
    }
  }
}
</script>

<style scoped>
</style>
