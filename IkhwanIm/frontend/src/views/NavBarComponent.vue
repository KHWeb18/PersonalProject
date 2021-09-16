<template>
  <div class="nav-container" >
    <v-toolbar dense dark>
      <v-toolbar-title>
        <router-link to="/" class="white--text">
          <span class="font-weight-bold text-h4 hidden-sm-and-down">GoFor</span>
        </router-link>
      </v-toolbar-title>
      <!--hidden Mobile Home -->
      <router-link to="/" class="white--text font-weight-bold text-h3 ml-auto mr-n8 hidden-md-and-up">
        <span>GoFor</span>
      </router-link>
      <v-toolbar-items class="ml-auto hidden-sm-and-down">

        <!-- login button  -->
        <member-login-card @submit="onLogin" v-if="!isLogin"></member-login-card>
        <!-- sign up button -->
        <member-register-card @submit="onRegister" v-if="!isLogin">
        </member-register-card>
        <!-- if login true
        <v-btn class="btn-flat" v-if="isLogin" @click="logout">
          {{session.member_id}}
        </v-btn>
        -->
        <member-menu :session="session" v-if="isLogin" @logout="logout"></member-menu>
      </v-toolbar-items>

      <!-- nav icon -->
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" class="hidden-md-and-up ml-auto">
      </v-app-bar-nav-icon>
    </v-toolbar >

    <!-- drawer -->
    <v-navigation-drawer app v-model="nav_drawer" temporary right class="blue-grey darken-1">
      <v-list nav dense>
        <!-- X icon -->
        <v-subheader>
          <v-icon right @click="nav_drawer = !nav_drawer" style="cursor: pointer"
                  class="ml-auto pb-2">close</v-icon>
        </v-subheader>
        <div v-if="isLogin">
        <v-list-item-title class="ml-2"><v-icon x-large color="black" class="mt-n2">account_circle</v-icon>
          <span class="text-h4 ml-5">{{ session.member_id }}</span></v-list-item-title>
          <v-divider></v-divider>
          <v-list-item class="logout ml-3" @click="logout">
            <v-list-item-action>
              <v-icon>account_box</v-icon>
            </v-list-item-action>
            <v-list-item-content>로그아웃</v-list-item-content>
          </v-list-item>
        </div>
        <!--contents -->
        <div v-if="!isLogin">
          <v-list-item>
            <v-list-item-action>
              <v-icon>account_box</v-icon>
            </v-list-item-action>
            <member-login-card @submit="onLogin"></member-login-card>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-icon>person_add</v-icon>
            </v-list-item-action>
            <member-register-card @submit="onRegister"></member-register-card>
          </v-list-item>
        </div>

        <div>
          <v-list-item-action><v-icon></v-icon></v-list-item-action>
        </div>

      </v-list>
    </v-navigation-drawer>

  </div>
</template>

<script>
import MemberLoginCard from "../components/HomeContents/MemberLoginCard";
import MemberRegisterCard from "../components/HomeContents/MemberRegisterCard";
import Vue from "vue";
import axios from "axios";
import {mapState} from 'vuex'

import cookies from "vue-cookies";
import MemberMenu from "../components/HomeContents/MemberMenu";
Vue.use(cookies)
export default {
  name: 'NavBarComponent',
  components: {MemberMenu, MemberRegisterCard, MemberLoginCard},
  data () {
    return {
      nav_drawer: false,
      isLogin: false,
      show: false,
    }
  },
  computed: {
    ...mapState(["session"])
  },
  mounted() {
    this.$store.state.session = this.$cookies.get("user")
    if(this.$store.state.session != null) {
      this.isLogin = true
    }
  },
  methods: {
    onRegister (payload) {
      const { member_id, member_pw, name, email } = payload
      axios.post(`http://localhost:7777/member/register`, { member_id, member_pw, name, email })
          .then(() =>{
             alert('Sign Up Successful!')
            this.member_id = ''
            this.member_pw = ''
            this.name = ''
            this.email = ''
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    onLogin (payload) {
      if(this.$store.state.session == null) {
        const {member_id, member_pw} = payload
        const name = null
        axios.post('http://localhost:7777/member/login', {member_id, member_pw, name})
            .then(res => {
              if (res.data != "") {
                alert(res.data.member_id + "님 환영합니다.")
                window.location.reload();
                this.isLogin = true;
                this.$store.state.session = res.data
                this.$cookies.set("user", res.data, '1h')
              } else {
                alert('아이디와 비밀번호를 확인해주세요. ' + res.data)
              }
            })
            .catch(res => {
              console.log(res)
              alert('아이디와 비밀번호를 확인해주세요. ')
            })
      } else {
        alert("이미 로그인 되어 있습니다. 아이디 : " +this.$store.state.session.userId)
      }

    },
    removeSession () {
      axios.post('http://localhost:7777/member/removeSession')
          .then(res => {
            this.isLogin = res.data
            alert('로그아웃 되었습니다.')
          })
    },
    logout () {
      this.$cookies.remove('user')
      this.isLogin = false
      this.$store.state.session = null
      window.location.reload();
    }
  },
}
</script>

<style scoped>

span{
  user-select: none;
}
.logout{
  cursor: pointer;
}
</style>
