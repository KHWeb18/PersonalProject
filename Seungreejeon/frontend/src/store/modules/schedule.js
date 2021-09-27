import axios from "axios"

const state = {

  timeone: [
    {time: "NAME"},
    {time: "8AM"},
    {time: "9AM"},
    {time: "10AM"},
    {time: "11AM"},
    {time: "12AM"},
    {time: "13AM"},
  ],

  timetwo: [
    {time: "14AM"},
    {time: "15AM"},
    {time: "16AM"},
    {time: "17AM"},
    {time: "18AM"},
    {time: "19AM"},
    {time: "20AM"},
  ],

  Indivisualone: [],

  modify: []

}

const getters = {
  //같은 부서 스케줄만
  getList: state => state.Indivisualone.filter(v => v.team == localStorage.getItem('team')),
  //같은 이메일의 스케줄이 있으면 스케줄 생성 못함
  getExist: state => state.Indivisualone.filter(v => v.email == localStorage.getItem('email')),
  //같은 이메일의 스케줄이 있으면 스케줄 생성 못함
  getModify: state => state.Indivisualone.filter(v => v.email == localStorage.getItem('email'))


}
const mutations  = {
  FETCH_SCHEDULE(state, payload) {
    state.Indivisualone = payload
  }

}

const actions = {

  addSchedule({ commit, dispatch }, payload) {
    axios.post('http://localhost:7777/schedule/add-schedule', payload)
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '등록완료' , color: 'black', location: 'bottom'
        }, { root: true } )
        dispatch('fetchSchedule')
      })
  },
  fetchSchedule({ commit }) {
    axios.get('http://localhost:7777/schedule/fetch-schedule')
      .then(res => {
        commit("FETCH_SCHEDULE", res.data)
        // alert(JSON.stringify(res.data))
      })
      .catch(err => {
        console.log(err.status)
      })
  },
  modifySchedule({ commit, dispatch }, payload) {
    const { scheduleNo, time8, time9, time10, time11, time12, time13
      ,time14, time15, time16, time17, time18, time19, time20 } = payload
    axios.put(`http://localhost:7777/schedule/modify/${scheduleNo}`,
      { time8, time9, time10, time11, time12, time13
        ,time14, time15, time16, time17, time18, time19, time20}
    )
      .then(res => {
        commit('snackBar/SET_SNACKBAR', {
          text: '등록완료' , color: 'black', location: 'bottom'
        }, { root: true } )
        dispatch('fetchSchedule')
      })
      .catch(err => {
        console.log(err)
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
