import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
//import './plugins/search'

import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'
//import 'side-effect'

import cookies from 'vue-cookies'

Vue.config.productionTip = false


  
  Vue.use(cookies)


new Vue({
  router,
  store,
  vuetify,
 // sideEffect,
  render: h => h(App)
}).$mount('#app')


