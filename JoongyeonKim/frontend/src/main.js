import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
//import VueSweetalert2 from 'vue-sweetalert2';

import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
//import 'sweetalert2/dist/sweetalert2.min.css';

import cookies from 'vue-cookies'

Vue.config.productionTip = false
Vue.use(cookies)

new Vue({
  router,
  store,
  vuetify,
  //VueSweetalert2,  //문제 생길수 있음
  render: h => h(App)
}).$mount('#app')
//window.Kakao.init("7181fd87e925d60bda53a6b1be251699");  //카카오에서 발급받은 앱키
