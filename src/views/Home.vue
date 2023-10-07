<script >
export default {
  data() {
    return {
      images: ['1.jpg', '2.jpg', '3.jpg', '4.jpg'] // 替换成你的图片文件名
    };
  }
}
</script>

<template>
  <div >
      <section class="home" id="home">
        <div class="content">
          <h3>旅游是一种信仰</h3>
          <h3>和我们一起去远方,寻找诗和梦想</h3>
        </div></section>
    <el-carousel  style="position:relative;z-index:0" height="650px" :interval="5000" arrow="always">
      <el-carousel-item v-for="image in images" :key="image">
        <img :src="require('@/assets/' + image)" alt="Carousel Image" />
      </el-carousel-item>
    </el-carousel></div>
</template>
<style scoped>
.center{
  align-items: center;
}
.btn{
  display: inline-block;
  margin-top: 1rem;
  background:#ffa500;
  color:#fff;
  padding:.8rem 3rem;
  border:.2rem solid #ffa500;
  cursor: pointer;
  font-size: 1.5rem;
}

.btn:hover{
  background:rgba(255, 165, 0,.2);
  color:#ffa500;
}

/* 主页的视频播放区 */

.home{
  top: 30%;
  left: 35%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  position: absolute;
  z-index: 1;
}

.home .content{
  text-align: center;
}

.home .content h3{
  font-size: 2rem;
  color:#fff;
  text-transform: uppercase;
  text-shadow: 0 .3rem .5rem rgba(0,0,0,.1);
}
.el-carousel__item img {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  height: 650px;
  width: 100%;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

</style>