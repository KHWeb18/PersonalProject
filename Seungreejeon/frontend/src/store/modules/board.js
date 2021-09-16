import axios from "axios"

const state = {
  headers: [
    { text: 'No', align: 'center', value: 'boardNo',},
    { text: 'Title', value: 'title' },
    { text: 'Writer', value: 'writer' },
    { text: 'Date', value: 'regDate' },
  ],

  boards: [],


}

const getters = {

}
const mutations  = {

  FETCH_BOARD(state, payload) {
    state.boards = payload

  },

}
const actions = {

  fetchBoard({ commit }) {
    axios.get('http://localhost:7777/board/fetch')
      .then(res => {
        commit("FETCH_BOARD", res.data)
      })
      .catch(err => {
        console.log(err.status)
      })
  },

  deleteBoard({ commit, dispatch }, boardNo) {
    axios.delete(`http://localhost:7777/board/modify/${boardNo}`)
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '삭제 ', color: 'black', location: 'bottom'
        }, { root: true } )

        commit('loading/SET_LOADING', {}, { root: true } )

        dispatch('fetchBoard')

      })
      .catch(err => {
        console.log(err)
        commit(`snackBar/SET_SNACKBAR ${err}`, {
          text: '오류 ', color: 'black', location: 'bottom'
        }, { root: true } )
      })

  },

  modifyBoard({commit, dispatch}, payload) {
    const { boardNo, title, content } = payload
    axios.put(`http://localhost:7777/board/modify/${boardNo}`,{content, title})
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '수정완료' , color: 'black', location: 'bottom'
        }, { root: true } )

        commit('loading/SET_LOADING', {}, { root: true } )

        dispatch('fetchBoard')
      })
      .catch(err => {
        console.log(err)
      })
  },
  post({ commit, dispatch }, payload ) {
    if (localStorage.getItem('name') != null) {
      const name = localStorage.getItem('name')
      const { title, content } = payload

      axios.post('http://localhost:7777/board/post', { title: title, content: content, writer: name })
        .then(res => {
          commit('snackBar/SET_SNACKBAR', {
            text: `등록완료 ${res.status}`, color: 'black', location: 'top'
          }, { root: true } )

          commit('loading/SET_LOADING', {}, { root: true } )
          
          dispatch('fetchBoard')

        })
        .catch(err => {
          console.log(err.status)
          alert("에러")
        })
    }
  },


}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
