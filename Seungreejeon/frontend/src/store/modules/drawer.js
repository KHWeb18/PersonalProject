const state = {
  namespaced: true,
  drawer: false,
  items: [
    { title: 'Home', icon: 'mdi-home', to: '/home'},
    { title: 'T&A', icon: 'mdi-image', items:[
      { title: 'Schedule', icon: 'mdi-clock-outline', to: '/schedule'},
      { title: 'Calendar', icon: 'mdi-calendar-check', to: '/commuting'},
    ]},
    { title: 'Organization', icon: 'mdi-account-group', items:[
      { title: 'Employee Contact List', icon: 'mdi-card-account-phone', to: '/contact-list'},
      { title: 'Project Plan', icon: 'mdi-projector-screen', to: '/plan'},
    ]},
    { title: 'Board', icon: 'mdi-billboard', to: '/board'}
  ]

}

const getters = {
  getDrawer: state => state.drawer

}
const mutations  = {
  SET_DRAWER (state, data) {
    state.drawer = data
  }

}
const actions = {
  toggleDrawer ({ commit }, value) {
    commit('SET_DRAWER', value)
  }

}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
