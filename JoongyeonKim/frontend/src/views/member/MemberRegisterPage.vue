<template>
    <div align="center">
        <h2>회원가입</h2>
        <member-register-form @submit="onSubmit"/>
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
            const { email, userName, password, passwordConfirm, auth  } = payload
            axios.post('http://localhost:7777/member/register', { email, userName, password, passwordConfirm, auth })
                    .then(res => {
                        alert('회원가입이 완료되었습니다! - ' + res)
                        this.$router.push("login");
                        this.$router.go();
                    })
                    .catch(res => {
                        alert('이미 존재하는 이메일입니다!'+ res)
                    })
        }
    }
}
</script>