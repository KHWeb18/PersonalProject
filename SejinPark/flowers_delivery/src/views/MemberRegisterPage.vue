<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <member-register-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
         
    </div>
</template>

<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'MemberRegisterPage',
    components: {
        MemberRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password,address, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', {
                        userId, password,address, auth
                    })
                    .then(res => {
                        alert('등록 성공! - ' + res)
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
        },
        onJPATest () {
            axios.post('http://localhost:7777/jpamember/test', {
                        userId: null, password: null,address: null, auth: null
                    })
                    .then(res => {
                        alert('테스트 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>