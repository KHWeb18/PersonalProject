<template>
    <v-row>
        <v-col cols="12" md="8">
            <v-card-text class="mt-12">
                <h1 
                    class="text-center display-2 orange--text text--lighten-4" >
                    Login!</h1>
                    <!--페이스북 아이콘-->
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
                        <v-text-field class="form-group" 
                        prepend-icon="person"
                        label="email" 
                        v-model="userInfo.email" 
                        type="email" 
                        :rules="emailRules"
                        required>
                        </v-text-field>
                    
                        <v-text-field class="form-group"
                        prepend-icon="lock"
                        label="비밀번호" 
                        v-model="userInfo.pw"
                        type="password"
                        required>
                        </v-text-field>                               
                    </v-form>
                    <h3 class="text-center mt-4 orange--text text--lighten-4">비밀번호를 잊어버리셨나요?</h3>
            </v-card-text>
            
            <div class="text-center mt-3">
                <v-btn rounded color="orange lighten-4" @click="btnLoginClick" dark>
                    로그인
                </v-btn>
            </div>
        </v-col>

        <!--cols=12로 설정후 md="4"로 오른쪽왼쪽 구역구분-->
        <v-col cols="12" md="4" class="orange lighten-4">
            <v-card-text class="white--text mt-12">
                <h1 class="text-center display-1">처음이신가요?</h1>
                <h5 class="text-center">빠르게 회원가입을 하세요!</h5>
            </v-card-text>
            <div class="text-center">
                <!--step 숫자의 다운업을 통해 페이지 이동-->
                <v-btn rounded outlined dark @click="stepPlus">
                    회원가입
                </v-btn>
            </div>
        </v-col>
    </v-row>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name:'LoginForm',
    props:{
        isLogin:{
            type: Boolean,
            required: true
        }

    },
    data(){
        return{
            userInfo: {
                email:'',
                pw:'',
            },
            emailRules: [
                v => !!v || '이메일 형식이 유효하지않습니다!',
                v => /.+@.+\..+/.test(v) || '이메일 형식이 유효하지않습니다!',
            ],    

        }
        
    },
    computed:{
        ...mapState(['session']),
        
    },
    mounted(){
        if(this.$cookies.get('user').email != null){
            this.$router.push({
                name:'MainPage'
            })
        }

    },
    methods:{
        btnLoginClick(){   
            if(this.isLogin == false){
                const validate = this.$refs.form.validate();

                if(validate){
                    const{email,pw} = this.userInfo
                    axios.post('http://localhost:9999/user-login/login',{email, pw})
                    .then(res => {
                        if(res.data == 1){
                            alert('이메일이 올바르지 않습니다!')
                        }
                        else if(res.data == 2){
                            alert('비밀번호가 다릅니다!')
                            this.pw =''

                        }
                        else if(res.data == 3){
                            axios.post('http://localhost:9999/user-login/needSession',{email,pw})   
                            .then(re=>{
                                alert('로그인 성공!')
                                this.isLogin = true
                                this.$store.state.session = re.data
                                this.$cookies.set("user",re.data,'1h')
                                this.$router.go()
                            })                        

                            /*
                            alert('로그인성공 ! 메인페이지로 이동!')
                            this.$router.push({
                                name: 'MainPage',
                                
                            })
                            */                            
                            
                        }
                            
                    })
                }
                else{
                    alert('이메일형식을 확인해주세요!')
                }  
            }else{
                alert('이미 로그인이 되어있습니다: ')
            }      
            
        },
        /*
        removeSession(){
            axios.post('http://localhost:9999/user-login/removeSession')
            .then(res=>{
                this.$cookies.remove("user")
                this.isLogin = res.data
                this.$store.state.session = null
            })
        },
        */
        stepPlus(){
            this.$emit('stepPlus')
        }
        

    }
}
</script>

