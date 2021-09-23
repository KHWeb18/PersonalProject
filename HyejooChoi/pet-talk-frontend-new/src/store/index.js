import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios"
import api from "../api/api";
import JwtDecode from "jwt-decode";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex)

const store = new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    token: null,
    isLogin: false,
    isLoginError: false,
    isSignUp: false,
  },
  mutations: {
    // 로그인 성공
    loginSuccess(state, payload) {
      state.isLogin = true
      state.isLoginError = false
      state.token = payload.token
      state.userInfo = payload.userInfo
    },
    // 로그인 실패
    loginError(state) {
      state.isLogin = false
      state.isLoginError = true
    },

    logout(state) {
      state.isLogin = false
      state.isLoginError = false
      state.userInfo = null
    },
    // 회원 가입 성공 여부 (false: 실패, true: 성공)
    signUpSuccess(state) {
      state.isSignUp = true;
    },
    signUpError(state) {
      state.isSignUp = false;
    }
  },

  actions: {
    // 로그인 시도
    // eslint-disable-next-line no-unused-vars
    async login({ commit }, loginObj) {

      // 로그인 -> 토큰반환
      await api.post("/user/login", loginObj)
        .then(res => {

          // axios를 통해서 아이디,비밀번호를 보내고 성공시 토큰이 돌아옴
          // 토큰을 헤더에 포함시켜서 유저정보를 요청
          console.log("==> res : ", res);
          let accessToken = res.data.data.accessToken
          const jwtObject = JwtDecode(accessToken);

          // localStorage.setItem("access_token", token)
          commit("loginSuccess", {
            token: accessToken,
            userInfo: { ...jwtObject }
          })
          // eslint-disable-next-line no-undef
        })
        .catch((e) => {
          console.log(e);
          alert('아이디와 비밀번호를 확인하세용.')
        })
    },

    logout({ commit }) {
      commit("logout")
      // localStorage.removeItem("access_token")
      localStorage.clear();
    },

    // eslint-disable-next-line no-unused-vars
    async signUp({ commit }, signUpObj) {
      await api.post("/user/signup", signUpObj)
        .then(res => {
          if (res.data.resultCode == "SUCCESS") {
            commit("signUpSuccess")
            alert("회원가입이 완료 되었습니다. 로그인 하세요.")
          } else {
            commit("signUpError")
            alert(res.data.message);
          }
        })
        .catch((e) => {
          commit("signUpError")
          alert(e.message);
        })
    },

    // eslint-disable-next-line no-unused-vars
    validateToken({ commit }) {
      // 로컬 스토리지에 저장되어 있는 토큰을 불러온다.
      let token = localStorage.getItem("access_token")
      let config = {
        headers: {
          "access-token": token
        }
      }
      // 토큰 -> 멤버 정보를 반환
      // 새로 고침 -> 토큰만 가지고 멤버정보

      // 토큰 ->멤버 정보를 반환
      axios
        .get("https://reqres.in/api/users/2", config) // 두번째 인자로 config가 들어감(보안과 관련된 옵션들)
        // eslint-disable-next-line no-unused-vars
        .then(response => {

        })
        // eslint-disable-next-line no-unused-vars
        .catch(() => {
          alert('이메일과 비밀번호를 확인하세요.')
        })
    }


    }

})

export default store

