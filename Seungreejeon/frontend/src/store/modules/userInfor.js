import axios from "axios"
import router from "../../router"

const state = {
  infor: [
    { title: 'Modify' },
    { title: 'Sign out' },
  ],
}

const getters = {

}
const mutations  = {

}

// module 위치 변경할것
// POST(state, payload) {
//   state
//   if (localStorage.getItem('name') != null) {
//     const name = localStorage.getItem('name')
//     const { title, content } = payload

//     axios.post('http://localhost:7777/board/post', { title: title, content: content, writer: name })
//       .then(res => {
//         console.log(res.status)
//         alert("등록성공")
//       })
//       .catch(err => {
//         console.log(err.status)
//         alert("에러")
//       })
//   }
// }
const actions = {
  // post({ commit }, payload ) {
  //   commit('POST', payload)
  // },

  modifyUserInfor({ commit }, payload) {
    const { email, password } = payload
    axios.post('http://localhost:7777/userInfo/modify', { email, password })
      .then(res => {

        commit('snackBar/SET_SNACKBAR', {
          text: `수정완료 ${res.status}`, color: 'black', location: 'bottom'
        }, { root: true } )

      })
  },
  deleteAcoount({ commit }, payload) {
    axios.post('http://localhost:7777/authenticate/delete-account', payload)

      .then(res => {

        commit('snackBar/SET_SNACKBAR', {
          text: `탈퇴완료 ${res.status}`, color: 'black', location: 'bottom'
        }, { root: true } )
        router.push('/')
      })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
