<template>
    <div class="font" style="font-family" >
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">

        
        <v-toolbar flat color="green">
            
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer"></v-app-bar-nav-icon><v-spacer></v-spacer>
            <v-spacer></v-spacer>

                <v-toolbar-items v-if="$store.state.session == null">
                    <div class="imgBox" >
                        <a class href="/">
                            <img class="logo" src="@/assets/img/ZoWa1.jpg" width="50"  >
                        </a>
                    </div>
                </v-toolbar-items>
                
                
            
                <v-toolbar-items v-if="$store.state.session != null">
                    <div class="imgBox"  >
                        <a class href="/">
                            <img class="logo" src="@/assets/img/ZoWa1.jpg" width="50">
                        </a>
                    </div>
                </v-toolbar-items><v-spacer></v-spacer>
                <v-spacer></v-spacer>
       </v-toolbar>


            <v-navigation-drawer app v-model="nav_drawer" temporary>
                <v-list nav dense  v-if="$store.state.session == null">
                    <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                        <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                            <v-list-item-action>
                                <v-icon left>{{ link.icon }}</v-icon>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>{{ link.text }}</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
                <v-list nav dense  v-if="$store.state.session != null">
                    <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                        <v-list-item v-for="ulink in ulinks" :key="ulink.name" router :to="ulink.route">
                            <v-list-item-action>
                                <v-icon left>{{ ulink.icon }}</v-icon>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>{{ ulink.text }}</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-navigation-drawer>
    </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
Vue.use(cookies)


export default {
    name: 'NavBarComponent',
    data () {
        return {
            nav_drawer: false,
            group: false,
            
            links: [
                {
                    icon: 'mdi-account-outline', text: '로그인', name: 'login', route: '/login'
                },
                {
                    icon: 'store', text: '매장정보', name: 'store', route: '/store'
                },
                {
                    icon: 'question_answer', text: '후기게시판', name: 'board', route: '/board'
                },
                {
                    icon: 'mdi-newspaper-variant-outline', text: '소식', name: 'mdi-newspaper-variant-outline', route: '/news'
                }
            ],
             ulinks: [
                 {
                    icon: 'exit_to_app', text: '로그아웃', name: 'logout', route: '/logout'
                },
                {
                    icon: 'store', text: '매장정보', name: 'store', route: '/store'
                },
                {
                    icon: 'question_answer', text: '후기게시판', name: 'board', route: '/board'
                },
                {
                    icon: 'mdi-newspaper-variant-outline', text: '소식', name: 'mdi-newspaper-variant-outline', route: '/news'
                },
            ],
            session:[]
        }
    },
     watch: {
        group () {
            this.nav_drawer = false
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
                axios.post('http://localhost:3647/jpasession/sign-in', { email, password })
                        .then(res => {
                            if (res.data.hashcode != null) {
                                alert('로그인 성공! - ' + res.data)
                                this.isLogin = true
                                this.$store.state.session = res.data
                                this.$cookies.set("user", res.data, '10h')
                                
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
                axios.post('http://localhost:3647/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                        
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:3647/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }
    }
    
}
</script>

<style scoped>
.font {
    font-family: 'Do Hyeon', sans-serif;
    font-family: 'Jua', sans-serif;
}

</style>