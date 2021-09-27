<template>
    <div align="center">
        <h2>로그인</h2>
        <member-login-form @submit="onSubmit"/>
    </div>
</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import { mapState } from 'vuex'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'

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
    mounted() {
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
        if (this.$store.state.session == null) {
            const {email, password } = payload
            axios.post('http://localhost:7777/member/login', { email, password })
                    .then(res => {
                         if (res.data != "") {
                            alert('로그인 성공! ')
                            this.isLogin = true;
                            this.$store.state.session = res.data
                            this.$cookies.set("user", res.data, '1h')
                            this.$router.push('main');
                            this.$router.go();
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert('아이디와 비밀번호를 확인해주세요! - ' +res)
                    })
 
            } else {
                alert('이미 로그인 되어 있습니다: ' + this.$store.state.session.email)
            }
        }
    }
}
</script>