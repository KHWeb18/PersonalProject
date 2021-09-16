import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

import 'materialize-css/dist/css/materialize.min.css'
import 'material-design-icons/iconfont/material-icons.css'
import '@morioh/v-lightbox/dist/lightbox.css'
import Lightbox from '@morioh/v-lightbox'
import Vuelidate from "vuelidate";
import 'url-search-params-polyfill';
import vueMoment from 'vue-moment' //날짜 출력


Vue.use(vueMoment) //날짜 출력
Vue.use(Lightbox)
Vue.use(Vuelidate);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  Vuelidate,
  render: h => h(App)
}).$mount('#app')

