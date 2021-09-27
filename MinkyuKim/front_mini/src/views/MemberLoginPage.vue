<template>
    <div>
        <v-btn tile color="teal" @click="logout" v-if="isLogin">
            <v-icon left>
                ads_click
            </v-icon>
            로그 아웃
        </v-btn>
        <div v-else>
            <div align="center">
                <h2>로그인</h2>
            </div>
            <member-login-form @submit="onSubmit"/>
        </div>
        <!--
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="showSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 보기
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="removeSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 끊기
        </v-btn>-->
    </div>
</template>

<script>
import MemberLoginForm from '@/components/members/MemberLoginForm.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
Vue.use(cookies)

export default {
    name: 'MemberLoginPage',
    components: {
        MemberLoginForm
    },
    // 실제 프로젝트에서는 data가 아닌 state를 이용하여 처리. 매번 spring을 이용해 처리해야 하기 때문에(이벤트버스) state를 통한 처리를 해야한다.
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
        ...mapState(['isLogin']),
        ...mapState(['session'])
    },
    
    methods: {
        onSubmit (payload) {
            if (this.$store.state.session == null) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/member/login', { userId: id , password: pw, auth: null })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + res.data.userId)
                            this.$store.state.isLogin = true
                            this.$store.state.session = res.data
                            this.$cookies.set("user", res.data, '1h')
                            this.$router.push({ name: 'Home' })
                        } else {
                            alert('로그인 실패! - ' + res.data)
                            this.$store.state.isLogin = false
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
                alert('이미 로그인 되어 있습니다: ' + this.$store.state.session.userId)
            }
        },
        showSession () {
            if (this.$store.state.isLogin == true) {
                axios.post('http://localhost:7777/member/needSession')
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
            }
        },
        removeSession () {
            axios.post('http://localhost:7777/member/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data
                    })       
        },
        logout () {
            this.$cookies.remove("user")
            this.$store.state.isLogin = false
            this.$store.state.session = null
        }
    }
}
</script>