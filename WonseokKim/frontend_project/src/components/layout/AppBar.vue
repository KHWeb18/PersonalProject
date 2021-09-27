<template>
    <div>
        <v-app-bar app="app" color="green" dark="dark">
            <div class="d-flex align-center">
                <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                <v-img
                    alt="Life Of Moment Logo"
                    class="shrink mr-2"
                    contain="contain"
                    src="@/assets/img/logos.png"
                    transition="scale-transition"
                    width="130"/>
                </router-link>
            </div>
            <v-spacer></v-spacer>
            <v-spacer></v-spacer>
            <v-spacer></v-spacer>
            <div>
                <v-menu open-on-hover="open-on-hover" bottom="bottom" offset-y="offset-y">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn v-bind="attrs" v-on="on" text="text">
                            <span class="mr-4">Photo</span>
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item v-for="(photo, index) in photos" :key="index" :to="photo.route" @click="showSession">
                            <v-list-item-title>{{ photo.title }}</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>
            </div>
            <div>
                <v-menu open-on-hover="open-on-hover" bottom="bottom" offset-y="offset-y">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn v-bind="attrs" v-on="on" text="text">
                            <span class="mr-4">Service</span>
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item v-for="(service, index) in services" :key="index" :to="service.route">
                            <v-list-item-title>{{ service.title }}</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>
            </div>
            <div>
                <v-menu open-on-hover="open-on-hover" bottom="bottom" offset-y="offset-y">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn v-bind="attrs" v-on="on" text="text">
                            <span class="mr-4">About</span>
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item v-for="(about, index) in abouts" :key="index" :to="about.route">
                            <v-list-item-title>{{ about.title }}</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>
            </div>
            <v-btn text="text" color="white" @click="logout" v-if="isLogin">
                    <span class="mr-1">LogOut</span>
                </v-btn>
            <div v-if="isLogout">
                <router-link :to="{ name: 'SessionLoginPage' }"
                    class="nav-link"
                    active-class="active"
                    style="text-decoration: none;">
                <v-btn text="text" color="white">
                    <span class="mr-1">LOGIN</span>
                </v-btn>
                </router-link>
                <span>|</span>
                <router-link :to="{ name: 'AccountRegisterPage' }"
                    class="nav-link"
                    active-class="active"
                    style="text-decoration: none;">
                <v-btn text="text" color="white">
                    <span class="mr-1">Join</span>
                </v-btn>
                </router-link>
                <v-btn href="" target="_blank" text="text">
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>
            </div>
        </v-app-bar>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'

Vue.use(cookies)

export default {
  name: 'AppBar',
    
  data: () => ({
    photos: [
      { title: '인물', route: '/person' },
      { title: '여행지', route: '/nature' },
      { title: '음식', route: '/food' }
    ],
    services: [
      { title: '언론보도', route: '/daumNewsCrawler'},
      { title: '질문게시판', route: '/question' },
      { title: '오시는 길', route: '/map' },
    ],
    abouts: [
      { title: 'LoM 소개', route: '/intro' },
      { title: '공지사항', route: '/notice' },
    ],
    loginDialog: false,
    userInfo: {
        userId: '',
        passwordCheck: '',
    },
    isLogin: false,
    isLogout: true,
  }),
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
            this.isLogout = false
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        ...mapActions(['fetchSession']),
        onSubmit (payload) {
            if (this.$store.state.session == null) {
                const { userId, passwordCheck } = payload
                axios.post('http://localhost:8888/jpasession/sign-in', { userId, passwordCheck })
                        .then(res => {
                            if (res.data.hashcode != null) {
                                alert('로그인 성공! - ' + res.data)
                                this.isLogin = true
                                this.$store.state.session = res.data
                                this.$cookies.set("user", res.data, '1h')
                            } else {
                                alert('로그인 실패! - ' + res.data)
                                this.isLogin = false
                            }
                            this.$router.push({
                            name: 'Home',
                            //params: { boardNo: res.data.boardNo.toString() }
                            })

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
                axios.post('http://localhost:8888/jpasession/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
                this.$router.push({
                name: 'Home',
                //params: { boardNo: res.data.boardNo.toString() }
                })
            }
        },
        removeSession () {
            axios.post('http://localhost:7777/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
            alert('로그아웃 되셨습니다!')
            this.$router.push({
                name: 'Home',
                //params: { boardNo: res.data.boardNo.toString() }
                })
        }

    }
}
</script>

<style>

</style>