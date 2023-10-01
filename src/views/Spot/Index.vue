<template>
  <div>
    <el-container>
    <el-container>
      <el-aside width="200px" >
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

export default {
  components: {LeftMenu},
  data() {
    return {
      defaultActive: "1",
      menuItems: [
        {index:"1", title: "查询景区信息", icon: "el-icon-menu",path:"/Spot" },
      ]
    };
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
background-color: #D3DCE6;
color: #333;
text-align: center;
line-height: 200px;
  height: 91vh;
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