<template>
  <div class="left">
    <el-menu
        :router="false"
        default-active="1"
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
    >
      <el-menu-item
          v-for="item in menuItems"
          :key="item.index"
          :index="item.index"
          @click="navigateToPage(item.path)"
      >
        <i :class="item.icon"></i>
        <span slot="title">{{ item.title }}</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "LeftMenu",
  props: {
    defaultActive: {
      type: String,
      default: "1"
    },
    menuItems: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    navigateToPage(path) {
      if (this.$route.path !== path) {
        this.$router.push(path);
      }
    }
  }
};
</script>

<style scoped>
.left {
  height: 508px;
}
</style>
