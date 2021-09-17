<template>
    <div class="back">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">
    
            <member-login-form @submit="onSubmit"/>
            


 
    </div>
</template>

<script>

import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'

Vue.use(cookies)

export default {
    name: 'MemberLoginPage',
    components: {
        MemberLoginForm
    },
    data () {
        return {
            isLogin: false
        }
    },
    mounted () {
        //this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")

        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        onSubmit (payload) {
            if(this.$store.state.session == null) {
                const { userId, password } = payload
                axios.post('http://localhost:7777/member/login', {  userId, password, auth: null })
                        .then(res => {
                            if (res.data != "") {
                               alert('ZoWa에 오신것을 환영합니다')
                                this.isLogin = true;
                                this.$store.state.session = res.data
                                this.$cookies.set("user", res.data, '1h')
                                this.$router.push("/")
                            } else {
                                alert('아이디와 비밀번호를 확인해주세요!')
                                this.isLogin = false
                            }
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('이미 로그인 되어 있습니다: ' + this.$store.state.session.userId)
            }
        },
        showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:7777/member/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지!')
                            } else {
                                alert('세션 정보 유지 안되는 중!')
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
            axios.post('http://localhost:7777/member/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
            alert("로그아웃 되었습니다.")
        }
    }
}
</script>

<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;

}



</style>