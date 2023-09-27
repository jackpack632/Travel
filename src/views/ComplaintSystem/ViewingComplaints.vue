<template>
    <el-container>
      <el-main>
    <ComplaintList></ComplaintList>
      </el-main>
</el-container>
</template>

<script>
import ComplaintList from '@/components/complaint/ComplaintList.vue';

export default {
  components: {
    ComplaintList
  }
};
</script>

<style scoped>
</style>
