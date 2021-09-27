<template>
    <div class="back">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">

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
            const { userId, password, email, area } = payload
            axios.post('http://localhost:7777/member/register', {
                        userId, password, email, area
                    })
                    .then(res => {
                        alert('회원이 되신것을 환영합니다!' + res)
                        this.$router.push("/login")
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
         onJPATest () {
            axios.post('http://localhost:7777/member/test', {
                        userId: null, password: null, auth: null, email: null, area: null
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


<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;

}



</style>