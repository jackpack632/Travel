
<template>
  <el-container class="el-container" >
    <el-header class="el-header">
    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item @click="handleMenuSelect('Home')">首页</el-menu-item>
      <el-menu-item @click="handleMenuSelect('ComplaintSystem')">投诉</el-menu-item>
      <el-menu-item @click="handleMenuSelect('EmergencyInfo')">旅游应急信息</el-menu-item>
      <el-menu-item @click="handleMenuSelect('HotelSystem')">星级酒店</el-menu-item>
      <el-menu-item @click="handleMenuSelect('NonStarHotelSystem')">非星级酒店及乡村旅游酒店</el-menu-item>
      <el-menu-item @click="handleMenuSelect('ScenicSystem')">旅游景区及线路查询</el-menu-item>
      <el-menu-item @click="handleMenuSelect('DiningEntertainmentSystem')">餐饮娱乐及演出团体</el-menu-item>
      <el-menu-item @click="handleMenuSelect('WeatherRoadSystem')">天气及路况</el-menu-item>

      <el-menu-item class="el-icon-user" @click="toggleLoginForm()">登录</el-menu-item>
      </el-menu>
    </el-header>
    <loginForm @close="ShowLoginForm" :dialogVisibleProp="LoginFormVisible"></loginForm>
    <register @register="ShowRegister" :dialogVisibleProp="RegisterVisible" ></register>
    <el-main class="el-main">
      <router-view></router-view></el-main>
  </el-container>

</template>
<style scoped>
.el-container{
  padding: 0;
}
.el-header{
 padding: 0;
}
.el-main{
  padding: 0;
}
.el-menu-demo {
  display: flex;
  justify-content: center;
}
.el-menu-item{
  color:#fff;
  font-size: 1rem;
  font-weight: bold;
  margin:0 .8rem;
}
</style>
<script>
import loginForm from '@/components/account/loginform.vue';
import register from "@/components/account/register.vue";
export default {
  created() {
    if (this.$route.path === '/Home') {
    }else {
      this.$router.push('/Home');
    }
  },
  components: {
    loginForm,
    register
  },
  data() {
    return {
      LoginFormVisible: false,
      RegisterVisible: false
    };
  },methods: {
    toggleLoginForm() {
      this.LoginFormVisible = true;

    },
    ShowLoginForm(flag) {
      if(flag==="close"){
        this.LoginFormVisible = false;
      }else if(flag==="register"){
        this.LoginFormVisible = false;
        this.RegisterVisible=true;
    }},ShowRegister(flag){
      if(flag==="close"){
        this.RegisterVisible = false;
      }else if(flag==="login"){
        this.LoginFormVisible = true;
        this.RegisterVisible=false;
    }},
    handleMenuSelect(index) {
      const route = `/${index}`; // 构造路由路径
      if (this.$route.path !== route) { // 检查是否已经在相同的路由上
        this.$router.push(route); // 跳转到指定路由
      }
    }
  }
};
</script>