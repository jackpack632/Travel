import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false
Vue.prototype.$serverIP = '192.168.40.42'
Vue.use(ElementUI)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
