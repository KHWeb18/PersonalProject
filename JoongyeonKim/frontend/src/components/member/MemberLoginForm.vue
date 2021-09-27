<template>
    <div id="container">
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" v-model="email" flat solo></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" v-model="password" flat solo></td>
                </tr>
            </table>
            <div>
                <v-btn class="mt-3" color="primary" button type="submit">로그인</v-btn>
            </div>     
        </form>
        <div>아직 계정이 없으신가요? <a href="register">가입하기</a></div>
    </div>
</template>

<script>
export default {
    name: 'MemberLoginForm',
    data () {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const {email, password } = this
            this.$emit('submit', {email, password })
        }
    }
}
</script> 

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1200px;
}
</style>