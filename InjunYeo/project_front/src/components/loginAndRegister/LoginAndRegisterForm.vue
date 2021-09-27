<!--회원가입페이지로 연결해주는것 만들어야함-->
<template>
    <v-app id="inspire">
        <v-content v-if="isLogin">
            <p>이미 로그인 되어있습니다!</p>
        </v-content>
        <v-content v-else> 
            <v-container class="fill-height" fluid>
                    <v-row align="center" justify="center">
                        <v-col cols="12" sm="8" md="8">
                            <v-card class="elevation-12">
                                <v-window v-model="step">
                                    <v-window-item :value="1">
                                        <!--step의 test-one컴포넌트에서 상위컴포넌트로 전송해야함-->
                                        <login-form :isLogin="isLogin" v-on:stepPlus="stepPlus"></login-form>
                                    </v-window-item>

                                    <!--v-window-item이 페이지 1,2를 정하는것같음-->
                                    <v-window-item :value="2">
                                        <register-form v-on:stepMinus="stepMinus"></register-form>
                                    </v-window-item>
                                </v-window>
                            </v-card>
                        </v-col>    
                    </v-row>
            
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'

import LoginForm from '../loginAndRegister/LoginForm.vue'
import RegisterForm from '../loginAndRegister/RegisterForm.vue'

Vue.use(cookies)

export default {
  components: { LoginForm,RegisterForm },
    name:'LoginAndRegisterForm',
    data(){
        return{
            isLogin:false,
            step:1        
        }
        
    },
    mounted(){
        this.$store.state.session = this.$cookies.get("user")

        if (this.$store.state.session != null){
            this.isLogin = true
        }
    },
    computed:{
        ...mapState(['session']),
        
    },
    methods:{
        stepPlus(){
            this.step++
        },
        stepMinus(){
            this.step--
        }

    }
}
</script>


