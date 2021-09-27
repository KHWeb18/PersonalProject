const state = {
  loading: { overlay: false },
}

const getters = {

}
const mutations  = {
  SET_LOADING(state) {
    state.loading.overlay = true;
  },
  END_LOADING(state) {
    state.loading.overlay = false;
  }
}
const actions = {


}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}
