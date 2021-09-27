import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import { VueMasonryPlugin } from "vue-masonry"
import CoolLightBox from 'vue-cool-lightbox'
import 'vue-cool-lightbox/dist/vue-cool-lightbox.min.css'

import cookies from 'vue-cookies'

Vue.config.productionTip = false

Vue.use(VueMasonryPlugin);
Vue.use(CoolLightBox);

Vue.use(cookies)
//Kakao.init('a31ea0a88f90369a63ae977fde35e829');

new Vue({
  router,
  store,
  vuetify,
  CoolLightBox,
  render: h => h(App)
}).$mount('#app')
