<template>
    <div style="position: relative;min-height:1100px;">
        <v-spacer style="background-color: black;height: 90px;"></v-spacer>
        <v-container>
            <div class="title_image">
                <img src="@/assets/img/logo4.png" width="100" class="item"></div>
                <member-login-form @submit="onSubmit"/>
                <v-spacer></v-spacer>
            </v-container>
            <div class="bg">
                <div class="bg1"><img src="@/assets/img/background_login.png"></div>
            </div>         
        </div>
</template>


<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
import { mapState } from 'vuex'

Vue.use(cookies)// 쿠키 사용
Vue.$cookies.config("1d");// 쿠키 만료일 1일

export default {
    name: 'MemberLoginPage',
    components: {
        MemberLoginForm
    },
    data () {
        return {            
        }
    },
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.$store.state.isLogin = true
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        onSubmit (payload) {
            if (this.$store.state.session == null) {
            const { userId, password } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId: userId, password: password, auth: null, nickname: null })
                    .then(res => {
                        if (res.data != "") {
                            // alert('로그인 성공! - ' + res.data)
                            console.log(res.data)
                            this.$store.state.isLogin = true
                            if (res.data.auth == '운영자') {
                                this.$store.state.isAuth = true
                                alert('운영자 아이디로 로그인')
                            } else {
                                this.$store.state.isAuth = false
                            }

                            console.log('res.data.nickname : ' + res.data.nickname)
                            console.log('res.data.userId : ' + res.data.userId)
                            this.$store.state.yourNickname = res.data.nickname
                            this.$store.state.yourId = res.data.userId
                            
                            this.$store.state.session = res.data
                            this.$cookies.set("user", res.data, '1h')
                            this.$router.push('/')
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
            }else {
                alert('이미 로그인 중입니다. 접속중인 아이디: ' + this.$store.state.session.userId)
            }
        },
        // showSession () {
        //     if (this.$store.state.isLogin == true) {
        //         axios.post('http://localhost:7777/jpamember/needSession')
        //                 .then(res => {
        //                     if (res.data == true) {
        //                         alert('세션 정보 유지! - ' + res.data)
        //                     } else {
        //                         alert('세션 정보 유지 안되는 중! - ' + res.data)
        //                     }
        //                 })
        //                 .catch(res => {
        //                     alert(res.response.data.message)
        //                 })
        //     } else {
        //         alert('먼저 로그인부터 하세요!')
        //     }
        // },
        // removeSession () {
        //     axios.post('http://localhost:7777/jpamember/removeSession')
        //             .then(res => {
        //                 this.$store.state.isLogin = res.data
        //                 this.$store.state.isAuth = false
        //             })
        // },
        logout () {
            this.$cookies.remove("user")
            this.$store.state.isLogin = false
            this.$store.state.session = null
            this.$store.state.isAuth = false
        }
    }
}
</script>


<style scoped>
.background_image {
    background-repeat: no-repeat;
    background-position: 40% 0;
    background-size: auto;
}
.title_image {
    display: flex;
    justify-content: center;
    margin: 30px;
    margin-bottom: 0px;
    margin-top: 120px;
}
.board_title {
    text-align: center;
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
    margin-bottom: 60px;
}

.bg .bg1 {
    z-index: 0;
    position: fixed;
    top: 74vh;
    left: 70vw;
    opacity: 0.3;
}
</style>