<template>
    <form @submit.prevent="onSubmit">
        
        <v-container id="SignupForm" style="max-width:350px">
            <h3> 회원가입</h3>
    <div>
            <div class="row">
            </div>
            <v-text-field  class="pl-3 pr-3"  v-model="userid"
            label="아이디" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
             <v-text-field  class="pl-3 pr-3"  :rules="passwordRules" required  v-model="password"
            label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
            <v-text-field  class="pl-3 pr-3"  :rules="passwordCheck" required  v-model="passwordChecking"
            label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
              <v-text-field class="pl-3 pr-3" :rules="emailRules" required v-model="email"
            label="이메일" type="text" prepend-icon="mdi-email-multiple" flat solo>
            </v-text-field>
            <v-text-field class="pl-3 pr-3" :rules="nameRules"  required v-model="name"
            label="회원이름" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
            <v-text-field class="pl-3 pr-3"  required v-model="birthday"
            label="주민번호앞자리" type="date"  prepend-icon="mdi-cake" flat solo>
            </v-text-field>
           

             <v-text-field class="pl-3 pr-3"   required v-model="phoneNo"
            label="휴대전화" type="text" prepend-icon="mdi-phone" flat solo>
            </v-text-field>
             <v-text-field class="pl-3 pr-3"  required v-model="address"
            label="주소" type="text" prepend-icon="mdi-home-map-marker" flat solo>
            </v-text-field>
            <v-radio-group v-model="gender" row>
                    <v-radio label="남자" value="남자"></v-radio>
                    <v-radio label="여자" value="여자"></v-radio>
                </v-radio-group>   
             <v-btn class="blue" type="submit">회원가입</v-btn>
           <v-btn class="red" route :to="{ name: 'Home' }">취소</v-btn>
               
        </div>
         
        </v-container>
    
    </form>
    
</template>

<script>

import {mapState} from 'vuex'
export default {
    name: 'SignupRegisterForm',

    props: {
        members: {
            type: Array
        }

    },

    data () {
        return {
            userid: '',
            password: '',
            name: '',
            email: '',
            birthday: '',
            gender: '',
            address: '',
            phoneNo: '',
            passwordChecking: '',
            passwordCheck: [
            v => this.password ===v || '비밀번호가 일치하지않습니다'
    ],
        }
    },

    methods: {
        onSubmit (){
                let coin = null;
                for(var i = 0 ; i < this.members.length ; i ++){

                      if(this.members[i].userid === this.userid){
                    alert('등록된 아이디가있습니다.')
                    return coin = 1;
                                                                 }
                
                                                                }
                if(coin === null){
            const { userid, password, name, email, birthday, gender, address, phoneNo } = this
            
            this.$emit('submit', {userid, password, name, email, birthday, gender, address, phoneNo})
                }

                  }
        },

        Cancellation(){
            alert('취소합니다.')
        },

        btn_click($event){
            if($event.target.innerHTML == " 확인 "){
                alert('어서오십쇼~')
                this.dialog = false;
            }else{
                alert('z')
                this.dialog = false;
            }
        },
    

    computed: {
         ...mapState([
             'emailRules',
            'passwordRules',
            'nameRules',
            'loadingState',
            
         ])
    }
}
</script>

<style scoped>
h3 {
    font-size: 30px;
}
#SignupForm{
    margin-left: 35%;
}
</style>
