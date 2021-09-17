<template>
    <v-form ref="form" lazy-validation>
    <v-container>
        <h3>회원가입</h3>
        <v-layout>
            <v-flex>
                <v-text-field 
                    label="*email"
                    v-model="userInfo.email" 
                    :rules="emailRules"
                    type="email"
                >
                </v-text-field>              
            </v-flex>
            <v-flex>
                <v-text-field 
                    label="*비밀번호" 
                    v-model="userInfo.pw"
                    type="password"
                    :rules="pwRules"
                >
                </v-text-field>
            </v-flex>
            <v-flex>
                <v-text-field 
                    label="*비밀번호 확인" 
                    v-model="userInfo.pwcheck"
                    type="password"
                    :rules="pwCheckRules"
                    hide-details="auto" 
                    required>
                </v-text-field>
            </v-flex>
            <v-flex>
                <v-text-field flat label="*이름"
                    v-model="userInfo.name" 
                    type="text"
                    :rules="nameRules" 
                    required 
                    placeholder>
                </v-text-field>
            </v-flex>
        </v-layout>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                취소
            </v-btn>
            <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                회원가입
            </v-btn>
    </v-container>
    </v-form>
</template>

<script>



import axios from 'axios'
//import { mapState } from 'vuex'

export default {



    name:'RegisterForm',
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
    computed:{
        
    },
    methods:{
        btnLoginClick($event){
            if($event.target.innerHTML == " 회원가입 "){
                const validate = this.$refs.form.validate();
                if(validate){
                    const{email,pw,name} = this.userInfo
                    axios.post('http://localhost:9999/user-register/register',{email, pw,name})
                            .then(res=>{
                                if(res.data == true){
                                    alert('회원가입 성공!'+ res)
                                    this.$router.push({
                                        name: 'ClearPage'
                                    })
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
            }           
            else if($event.target.innerHTML == " 취소 "){
                alert('취소')
                this.userInfo.pw=''
                this.userInfo.pwcheck=''
            }

        },

    }   
}
</script>