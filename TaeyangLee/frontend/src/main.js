import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import VueCookie from 'vue-cookie'


import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'



Vue.use(VueCookie);

Vue.config.productionTip = false



 

new Vue({
  router,
  store,
  vuetify,
  el:"#app",
  render: h => h(App)
}).$mount('#app')
