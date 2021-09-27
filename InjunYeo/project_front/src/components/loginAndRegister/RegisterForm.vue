<template>
    <v-row class="fill-height">
        <v-col cols="12" md="4" class="orange lighten-4">
            <v-card-text class="white--text mt-12">
                <h1 class="text-center display-1">환영합니다!</h1>
                <h5 class="text-center">
                writer를 즐겨보세요! 
                </h5>
            </v-card-text>
            <div class="text-center">
                <v-btn rounded outlined dark @click="stepMinus">로그인</v-btn>
            </div>
        </v-col>

        <v-col cols="12" md="8">
            <v-card-text class="mt-12">
                <h1 class="text-center display-2 orange--text text--lighten-4">계정을 만드세요!</h1>
                    <div class="text-center mt-4">
                        <v-btn class="mx-2" fab color="white" outlined>
                            <v-icon color="#4267b2">mdi-facebook</v-icon>
                        </v-btn>
                    

                    <!--구글 아이콘-->
                
                        <v-btn class="mx-2" fab color="white" outlined>
                            <v-icon color="#db4437">mdi-google</v-icon>
                        </v-btn>
                    
                    <!--링크아이콘 아이콘-->
                    
                        <v-btn class="mx-2" fab color="white" outlined>
                            <v-icon color="#1da1f2">mdi-twitter</v-icon>
                        </v-btn>
                    </div>
                <v-form ref="form" lazy-validation>
                    <v-text-field 
                    label="*email"
                    v-model="userInfo.email" 
                    :rules="emailRules"
                    type="email"
                    >
                    </v-text-field>
                
                    <v-text-field 
                        label="*비밀번호" 
                        v-model="userInfo.pw"
                        type="password"
                        :rules="pwRules"
                    >
                    </v-text-field>

                    <v-text-field 
                        label="*비밀번호 확인" 
                        v-model="userInfo.pwcheck"
                        type="password"
                        :rules="pwCheckRules"
                        hide-details="auto" 
                        required>
                    </v-text-field>

                <v-text-field 
                    label="*이름"
                    v-model="userInfo.name" 
                    type="text"
                    :rules="nameRules" 
                    required 
                    placeholder>
                </v-text-field>

                </v-form>                                                
            </v-card-text>
            <div class="text-center mt-n5">
                <v-btn @click="btnRegister" rounded color="orange lighten-4" dark >회원가입</v-btn>
            </div>
        </v-col>
    </v-row>
</template>

<script>

import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)
export default {
    name:'TestOne',
    props:{
        isLogin:{
            type: Boolean,
            required: true
        }

    },
    data(){
        return{
            userInfo: {
                id:'',
                pw:'',
                pwcheck:'',
                name:''
            },
            emailRules:[
                v => !!v || '이메일은 필수 입력사항입니다!',
                v => /.+@.+\..+/.test(v) || '이메일 형식이 유효하지않습니다!',

            ],
            pwRules:[
                v => !!v || '비밀번호는 필수 입력사항입니다!',
                v => /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/.test(v) || '비밀번호는 특수문자, 영어 숫자의 형식의 6자리 숫자 이상이어야 합니다!' 
            ],
            pwCheckRules:[
                v => !!v || '비밀번호 확인을 해주세요!',
                v => v === this.userInfo.pw || '비밀번호가 일치하지 않습니다!'
            ],
            nameRules:[
                v => !!v || '이름은 필수 입력 사항입니다!',
                v => (v && v.length <= 10) || '이름을 확인해주세요!'

            ]

        }
        
    },
    methods:{
        btnRegister(){

            const validate = this.$refs.form.validate();
            if(validate){
                const{email,pw,name} = this.userInfo
                axios.post('http://localhost:9999/user-register/register',{email, pw,name})
                        .then(res=>{
                            if(res.data == true){
                                alert('회원가입 성공!'+ res)
                                this.$router.go()
                            }else{
                                alert('이미 사용중인 아이디입니다!')
                                this.userInfo.email=''
                                this.userInfo.pw=''
                                this.userInfo.pwcheck=''
                                this.userInfo.name=''
                            }    
                        })         
            }
            else{
                alert('가입정보를 확인하세요!')
            }
        },           
        removeSession(){
            axios.post('http://localhost:9999/user-login/removeSession')
            .then(res=>{
                this.$cookies.remove("user")
                this.isLogin = res.data
                this.$store.state.session = null
            })
        },
        stepMinus(){
            this.$emit('stepMinus')
        }
    }
        
}
</script>