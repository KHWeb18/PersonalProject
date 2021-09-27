<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <table style="margin-left: auto; margin-right: auto; width:300px">
                <tr>
                    <td>아이디</td>
                    <td><input type="text" v-model="email"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" v-model="password"></td>
                </tr>
            </table>

<br/>
            <div>
                 <v-btn style= "width:300px"
                depressed
                color= "black"
                 >
                <button type="submit" style= "background-color:black;
                color:white;">로그인</button>
                </v-btn>
                <br/><br/>
                 <v-btn style= "width:300px"
                depressed
                color= "gray"
                 >
                <button type="submit" style= "
                color:white">
                <router-link :to="{ name: 'AccountRegisterPage' }">
                    회원가입
                </router-link> </button>
                 </v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'SessionLoginForm',
    data () {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            this.$emit('submit', { email, password })
        }
    }
}
</script>