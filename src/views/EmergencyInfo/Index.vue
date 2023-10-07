<template>
  <div>
    <el-container>
      <el-container>
        <el-aside width="200px">
          <LeftMenu
              :defaultActive="defaultActive"
              :menuItems="menuItems"
          />
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import LeftMenu from "@/components/com/LeftMenu.vue";
import {checkAdminRole} from "@/utils/CheckAdmin";

export default {
  components: {LeftMenu},
  data() {
    return {
      defaultActive: "1",
      menuItems: [
        {index:"1", title: "查询旅游应急信息", icon: "el-icon-setting" ,path:"/EmergencyInfo"},
      ]
    };
  },
  methods: {
  }
  ,mounted() {
    if(checkAdminRole()==="admin"){//管理员
      this.menuItems.push({ index:"2", title: "旅游应急信息调整", icon: "el-icon-document",path:"/EmergencyInfo/2" });
    }
  }
};
</script>
<style scoped>
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  height: 91vh;
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>