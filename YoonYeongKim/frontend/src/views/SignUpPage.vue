<template>
    <div>
        <div class="회원가입상단" align="center">
          <h1 style="padding:50px; font-weight:bold">Sign Up</h1>
        </div>
        <sign-up-form @submit="onSubmit"/>
    </div>
</template>

<script>
import SignUpForm from '../components/SignUpForm.vue'
import axios from 'axios'

export default {
    name: 'SignUpPage',
    components: {
        SignUpForm
    },
    methods: {
        onSubmit (payload) {
            const { email, password } = payload
             axios.post('http://localhost:7777/jpasession/register', { email, password })
                    .then(res => {
                        alert('가입되었습니다.')
                        this.$router.push({
                            name: 'LoginPage'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}

</script> 

