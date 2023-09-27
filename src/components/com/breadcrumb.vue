<template>
  <el-breadcrumb
      separator-class="el-icon-arrow-right">
    <el-breadcrumb-item
        replace="true"
        v-for="(item, index) in items"
        :key="index"
        :to="item.to"
    >
      {{ item.label }}
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script>
export default {
  props: {
    items: {
      type: Array,
      required: true,
    },
  },
};
</script>
