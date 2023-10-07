<template>
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
      </el-table>
      <!-- 添加/修改对话框 -->
      <el-dialog :visible.sync="dialogVisible" :title="dialogTitle" @close="handleDialogClose">
        <el-form :model="editedData">
          <el-form-item label="投诉编号："><!--仅展示-->
            {{ editedData.thingid}}
          </el-form-item>
          <el-form-item label="投诉时间："><!--仅展示-->
            {{ editedData.time | formatDate }}
          </el-form-item>
          <el-form-item label="投诉内容："><!--用户添加或修改-->
            <el-input :disabled="notionDisable" v-model="editedData.notion" type="textarea" :rows="3"></el-input>
          </el-form-item>

          <el-form-item label="投诉用户："><!--仅展示-->
            {{ editedData.userName}}
          </el-form-item>
          <el-form-item label="投诉状态："><!--需修改提交-->
            {{ editedData.state}}
          </el-form-item>
          <el-form-item label="投诉结果："><!--需修改提交-->
            <el-input :disabled="resultDisable" v-model="editedData.result" type="textarea" :rows="3"></el-input>

          </el-form-item>
          <el-form-item label="投诉评价："><!--用户评价-->
            <el-input :disabled="evaluateDisable" v-model="editedData.evaluate" type="textarea" :rows="3"></el-input>

          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="saveData">提交</el-button>
            <el-button @click="handleDialogClose">返回</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
    <!-- 其他组件 -->
</template>

<script>
import axios from '../../utils/Axios'
import {checkAdminRole} from "@/utils/CheckAdmin";

export default {
  data() {
    return {
      head: '用户个人投诉列表',
      buttonsToShow: 'user',
      complaints: [], // 这里模拟投诉数据，实际应从后端获取
      dialogVisible: false,
      dialogTitle: '',
      editedData: {},
      notionDisable:true,
      resultDisable:true,
      evaluateDisable:true,
      username: ''
    };
  },
  mounted() {
    //获取用户id
    this.username=checkAdminRole();
    if(this.username==="admin"){
      this.head="所有投诉列表";
      this.buttonsToShow="admin";
    }
    this.getUserComplaints();
  },
  methods: {
    getUserComplaints() {
      axios.get("http://"+this.$serverIP+":8081/ComplaintSystem/"+this.username).then((res) => {
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
    showEvaluateDialog(row) {
      this.notionDisable = true;
      this.resultDisable = true;
      if(row.state === "已评价") {
        //TODO:弹出不可修改的提示框，包含已评价的内容
        this.dialogTitle = '评价投诉';
        this.dialogVisible = true;
        this.editedData = { ...row };
      }else if(row.state === "处理完成") {
        //TODO:弹出评价框,可以评价
        this.dialogTitle = '评价投诉';
        this.dialogVisible = true;
        this.evaluateDisable = false;
        this.editedData = { ...row };
      }else {
        //显示需要等待处理完成才可以评价
        this.$message.error("请等待处理完成后再评价");
      }
    },showAddDialog() {
      this.dialogVisible = true;
      this.dialogTitle = '添加投诉';
      this.notionDisable = false;
      this.resultDisable = true;
      this.editedData = {
        other:'',
        userName:this.username,
        time:new Date(),
        state:'等待处理'
      }; // 清空编辑数据
    },
    showEditDialog(row) {
      if(row.state === "处理完成"||row.state === "已评价") {
        this.$message.error("已处理完成或已评价的投诉不可修改");
      }else {
        this.dialogVisible = true;
        this.dialogTitle = '修改投诉信息';
        this.notionDisable = false;
        this.resultDisable = true;
        this.editedData = { ...row };
      }
      },
    handleDialogClose() {
      this.dialogVisible = false;
      this.editedData = {}; // 清空编辑数据
    },handleComplaint(row){
      this.dialogVisible = true;
      this.dialogTitle = '处理投诉';
      this.resultDisable = false;
      this.editedData = { ...row };
    },deleteData(row) {
      // 删除数据的逻辑，可以根据需要发送请求到后端
      axios.delete("http://"+this.$serverIP+":8081/ComplaintSystem/"+row.thingid).then((res) => {
        if (res.data.code === 200) {
          this.$message.success(res.data.msg);
        } else {
          this.$message.error(res.data.msg);
        }
      }).finally(() => {
        this.getUserComplaints();
      })

    },saveData() {
      // 保存数据的逻辑，可以根据需要发送请求到后端
      if (this.dialogTitle === '添加投诉') {
        // 添加数据
        axios.post("http://"+this.$serverIP+":8081/ComplaintSystem",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        }).finally(() => {
          this.getUserComplaints();
        })
      } else if(this.dialogTitle === '修改投诉信息'){
        // 修改数据
        axios.put("http://"+this.$serverIP+":8081/ComplaintSystem",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        }).finally(() => {
          this.getUserComplaints();
        })
      }else if( this.dialogTitle === '评价投诉'){
        //评价数据
        this.editedData.state = "已评价";
        axios.put("http://"+this.$serverIP+":8081/ComplaintSystem",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        }).finally(() => {
          this.getUserComplaints();
        })
      }else if(this.dialogTitle === '处理投诉'){
        //处理数据
        this.editedData.state = "处理完成";
        axios.put("http://"+this.$serverIP+":8081/ComplaintSystem",this.editedData).then((res) => {
          if (res.data.code === 200) {
            this.$message.success(res.data.msg);
          } else {
            this.$message.error(res.data.msg);
          }
        }).finally(() => {
          this.getUserComplaints();
        })
      }
      this.notionDisable = true;
      this.resultDisable = true;
      this.evaluateDisable = true;
      this.dialogVisible = false;
      this.editedData = {}; // 清空编辑数据
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
