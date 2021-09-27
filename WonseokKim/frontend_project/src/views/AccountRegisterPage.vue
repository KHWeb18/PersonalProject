<template>
    <div>
      <account-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import AccountRegisterForm from '@/components/account/AccountRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'AccountRegisterPage',
    components: {
        AccountRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, passwordCheck, userName, userEmail } = payload
            axios.post('http://localhost:8888/jpasession/register', {
                        userId, passwordCheck, userName, userEmail })
                    .then(res => {
                        alert('회원가입을 축하합니다! 로그인후 서비스 이용 가능합니다.' + res)
                        this.$router.push({
                            name: 'Home',
                            //params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>