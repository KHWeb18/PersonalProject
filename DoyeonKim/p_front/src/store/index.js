import Vue from 'vue'
import Vuex from 'vuex'

//import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    sb: {
			show: false,
			msg: '',
			color: '',
		},
    editable: false,
    fireUser: null,
    user: null,
    boardTypeList: localStorage.getItem('boardTypeList') === 'true',
    searchText: ''
    },
    
  mutations,
  actions,
  getters
})