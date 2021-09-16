<template>
	<header class="header">
  <div>
  <b-navbar type="light" variant="faded">
    <b-navbar-nav>
		<!-- <a class ="navbar-brand" href="#" style="padding:10px;">Logo</a> -->
    <b-nav-item>
		<b-navbar-brand class="mb-0" style="padding:5px 400px 0px 20px;">YOUMUSTHEAR1001</b-navbar-brand>
    </b-nav-item>

            

            <b-nav-item>
            <router-link style="text-decoration: none; color:black" 
            :to="{ name: 'Home' }">
            <b-nav-item href="http://localhost:8080/" style="font-weight:bold">Home</b-nav-item>
            </router-link>
            </b-nav-item>

            <b-nav-item>
            <b-nav-item-dropdown text="Recommend" right style="font-weight:bold">
              <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'Home2' }">
              <b-dropdown-item href="http://localhost:8080/">오늘의 추천</b-dropdown-item>
              </router-link>

              <!--
              <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'AlbumFilter' }">
              <b-dropdown-item href="http://localhost:8080/">취향 반영 추천</b-dropdown-item>
              </router-link>
              -->

            </b-nav-item-dropdown>
            </b-nav-item>

            <b-nav-item>
            <b-nav-item-dropdown text="Community" right style="font-weight:bold">
              <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'BoardListPage' }">
              <b-dropdown-item href="http://localhost:8080/">자유게시판</b-dropdown-item>
              </router-link>

              <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'NewsCrawl' }">
              <b-dropdown-item href="http://localhost:8080/">News</b-dropdown-item>
              </router-link>
              <!--
              <b-dropdown-item href="#">공지사항</b-dropdown-item>
              <b-dropdown-item href="#">Q&A</b-dropdown-item>
              -->
            </b-nav-item-dropdown>
            </b-nav-item>

            <div>
              <b-nav-item-dropdown size="ml"  variant="link" toggle-class="text-decoration-none" no-caret>
                <template #button-content>
                  <b-avatar size="40px"></b-avatar>
                </template>

                <!-- <b-dropdown-item href="http://localhost:8080/login">Login</b-dropdown-item> -->

                <!-- <b-dropdown-item-btn 
                @click="account" 
                v-if="isLogin">
                Account
                </b-dropdown-item-btn> -->

                <b-dropdown-item-btn 
                @click="logout" 
                v-if="isLogin">
                로그아웃
                </b-dropdown-item-btn>

              </b-nav-item-dropdown>
            </div>

        <b-navbar type="light">
          <b-nav-form>
          <b-form-input size="sm" placeholder="Search" style="width:150px;">
          </b-form-input>
          <!-- <b-button variant="outline-success" size="sm" class="my-2 my-sm-0" type="submit">Search</b-button> -->
          </b-nav-form>
        </b-navbar>

    </b-navbar-nav>
  </b-navbar>
</div>

	</header>
</template>

<script>

import { mapState, mapActions } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'

Vue.use(cookies)

export default {
    data () {
        return {
            isLogin: false
        }
    },
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        ...mapActions(['fetchSession']),
        onSubmit (payload) {
            if (this.$store.state.session == null) {
                const { email, password } = payload
            axios.post('http://localhost:7777/jpasession/sign-in', { email, password })
                    .then(res => {
                            if (res.data.hashcode != null) {
                                alert('로그인 성공! - ' + res.data)
                            this.isLogin = true;
                            this.$store.state.session = res.data
                            this.$cookies.set("user", res.data, '1h')
                            this.$router.push({
                            name: 'Home2'
                         })
                        } else {
                            alert('로그인 실패! - ' + res.data)
                            this.isLogin = false
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
                    } else {
                alert('이미 로그인 되어 있습니다 - 계정: ' + this.$store.state.session.email)
            }
        },
        showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:7777/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                            /*
                            this.$router.push({
                                name: 'Page'
                            })
                            */
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:7777/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        },
        /*
        logout () {
            alert('로그아웃됐습니다.')
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }, */

        logout () {
            var result = confirm('로그아웃 하시겠습니까?')
            if(result) {
              this.$cookies.remove("user")
              this.isLogin = false
              this.$store.state.session = null }
              alert('로그아웃 됐습니다.')
        },
        account () {
          this.isLogin = false
          this.$router.replace({
            name: 'MyPage'
          })
        }
  }
}
</script>

<style scoped>

</style>