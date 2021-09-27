
<template>
    <v-container>
        <form @submit.prevent="onSubmit">

            <table style="margin-left: auto; margin-right: auto; width:300px">
                <tr>
                    <td>이메일</td>
                    <td><input type="text" v-model="email"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="text" v-model="password"></td>
                </tr>
              <!--  <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="text" v-model="passwordpa"></td>
                </tr>-->
            </table>

            <div>
                <br/>
                 <v-btn style= "width:300px"
                depressed
                color= "black"
                 >
                <button type="submit" style= "background-color:black;
                color:white;">등록</button>
                </v-btn>
                <br/><br/>

                <v-btn style= "width:300px"
                depressed
                color= "gray"
                 >
                <button type="submit" style= "
                color:white">
                <router-link :to="{ name: 'SessionLoginPage' }">
                    로그인
                </router-link> </button>
                </v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'AccountRegisterForm',
    data () {
        return {
            email: '',
            password: '',
         //   passwordpa: '',
          //  name: ''
        }
    },
    methods: {
        onSubmit () {
            const { email, password, } = this
            this.$emit('submit', { email, password, })
        }
    }
}
</script>