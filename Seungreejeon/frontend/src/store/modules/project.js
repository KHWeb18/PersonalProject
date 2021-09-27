import axios from "axios"

const state = {
  projects: [
  ],
  status: [
    { text:'complete' , value: 'complete' },
    { text:'ongoing' , value: 'ongoing' },
    { text:'overdue' , value: 'overdue' }
  ]
}

const getters = {
  getProject: state => state.projects.filter(v => v.team == localStorage.getItem('team')),


}
const mutations  = {
  GET_SORT(state, value) {
    state.projects.sort((a,b) => a[value] < b[value] ? -1 : 1)
  },
  FETCH_PROJECT(state, payload) {
    state.projects = payload
  }
}

const actions = {
  getSort({ commit }, value) {
    commit('GET_SORT', value)
  },
  addProject({ commit, dispatch }, payload) {
    axios.post('http://localhost:7777/project/add-project', payload)
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '등록완료' , color: 'black', location: 'bottom'
        }, { root: true } )
        
        dispatch('fetchProject')

      })
    commit('loading/SET_LOADING', {}, { root: true } )
    dispatch('fetchProject')
  },

  fetchProject({ commit }) {
    axios.get('http://localhost:7777/project/fetch-project')
      .then(res => {
        commit('FETCH_PROJECT', res.data)
      })
  },

  deleteProject({ commit, dispatch }, value ) {
    axios.delete(`http://localhost:7777/project/delete-project/${value}`)
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '삭제완료' , color: 'black', location: 'bottom'
        }, { root: true } )
        dispatch('fetchProject')
      })
    commit('loading/SET_LOADING', {}, { root: true } )

  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
