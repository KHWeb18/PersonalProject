import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import router from './router'
import store from './store'
import './assets/css/login.css';
import './assets/css/main.css';
import './assets/css/reset.css';
import './assets/css/signup.css';
import Dayjs from 'dayjs';

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);
Vue.use(Dayjs);

Vue.config.productionTip = false


new Vue({
  vuetify,
  router,
  store,
  // beforeCreate() {
  //   this.$store.dispatch("getMemberInfo")
  // },
  render: h => h(App)
}).$mount('#app')
