const state = {
  // snack: null,
  // timeout: 2000,
  snack: {open: false, text: '', location: 'top',},

}

const getters = {


}
const mutations  = {

  SET_SNACKBAR(state, snackbar) {
    state.snack.open = true;
    state.snack.text = snackbar.text;
    state.snack.color = snackbar.color;
    state.snack.location = snackbar.location;
  }

}
const actions = {
  setSnack({commit}, payload) {
    commit('SET_SNACKBAR', payload)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
