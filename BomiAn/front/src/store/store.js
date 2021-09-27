import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
      user: {
        nickname: '',
        no: 0,
        email: ''
      },
      isLogin: false
  },
  mutations: {
    user(state, data) {
      state.user = data;
    }

  },
  actions: {
  },
  modules: {
  }
})
