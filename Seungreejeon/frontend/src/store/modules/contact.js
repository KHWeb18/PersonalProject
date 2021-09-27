import axios from "axios"

const state = {
  employee: [],
  headers: {
    Depart: 'Department', Name: 'Name', Contact: 'Contact', Email: 'Email'
  }
}

const getters = {

}
const mutations  = {
  GET_SORT(state, value) {
    state.employee.sort((a,b) => a[value] < b[value] ? -1 : 1)
  },

  FETCH_CONTACT(state, payload) {
    state.employee = payload

  }


}
const actions = {

  getSort({ commit }, value) {
    commit('GET_SORT', value)
  },

  fetchContact({ commit }) {
    axios.get('http://localhost:7777/contact/fetch-contactList')
      .then(res => {
        commit('FETCH_CONTACT', res.data)
      })
  },
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
