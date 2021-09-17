<template>
    <div>
       
         <v-container style="margin-left:700px">
             <img src="@/assets/상우/궁금한사슴이.jpg"/>
             <p>비밀번호찾기</p>
        <!--
        <body>
           
     <v-container>
         <p>곤카 비밀번호 재설정</p>
         <p v-if="coin ==0">아이디</p>
    <input value="회원가입시 입력했던아이디" v-if="coin ==0" v-model="userid"/>
    <v-btn v-if="coin ==0" @click="OnSubmit">서버에제출</v-btn>
    <p v-if="coin ==1">생년월일</p>
    <v-text-field v-if="coin ==1" type="date" v-model="maybebirthday">
    </v-text-field>
    <v-btn v-if="coin ==1" @click="idMatchedBirthday">서버에제출</v-btn>

    <p v-if="coin == 2">비밀번호 재설정</p>
    <v-text-field  v-if="coin == 2" v-model="password" :rules="passwordRules">
    </v-text-field>
    <v-text-field  v-if="coin ==2" v-model="passwordchecking" :rules="passwordCheck">
    </v-text-field>
    <v-btn  v-if="coin == 2" @click="PasswordReset">서버에제출</v-btn>

        <router-link
        :to="{name: 'FindByIdPage'}">
        아이디가기억나지않으세요?
        </router-link>
        -->
    <!--
    <v-btn @click="checkMemberNo(memberNo,birthday,address,phoneNo,regDate,email)">멤버노 체크하기</v-btn>
    <v-btn @click="checkMemberWho(userid)">로그인후멤버확인</v-btn>
    -->
         <!--
     </v-container>
        </body>
 -->
       <v-stepper max-width="700px" v-model="e1">
    <v-stepper-header>
      <v-stepper-step :complete="e1 > 1" step="1">아이디 확인</v-stepper-step>

      <v-divider>

      </v-divider>

      <v-stepper-step :complete="e1 > 2" step="2">생년월일 확인</v-stepper-step>

    <v-divider>

    </v-divider>

      <v-stepper-step step="3">비밀번호 변경</v-stepper-step>

    <v-divider>
        
    </v-divider>

    </v-stepper-header>

    <v-stepper-items>
      <v-stepper-content step="1">
          <p >아이디입력</p>
       <input v-if="coin ==0" v-model="userid"/>

        <v-btn @click="OnSubmit">
          <v-icon>mdi-arrow-right-thick</v-icon>
        </v-btn>
        <router-link
        :to="{name: 'FindByIdPage'}">
        아이디가기억나지않으세요?
        </router-link>

       
      </v-stepper-content>

      <v-stepper-content step="2">
          <p >생년월일입력</p>
        <input style="width:350px" type="date" v-model="maybebirthday"/>
        <br>
        <v-btn @click="idMatchedBirthday" >
        <v-icon>mdi-arrow-right-thick</v-icon>
        </v-btn>

        
      </v-stepper-content>

      <v-stepper-content step="3">
       <p >비밀번호 재설정</p>
    <v-text-field  type="password" v-model="password" :rules="passwordRules">
    </v-text-field>
    <v-text-field type="password" v-model="passwordchecking" :rules="passwordCheck">
    </v-text-field>

        <v-btn @click="PasswordReset" >
        <v-icon>mdi-arrow-right-thick</v-icon>
        </v-btn>
      </v-stepper-content>
    </v-stepper-items>
  </v-stepper>
  </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
     computed:{
         ...mapState(['passwordRules'])
     },
    name: 'FindByPasswordPage',
    methods:{
            OnSubmit(){
                    const {userid} =this
                    axios.post('http://localhost:9999/jpamemberManage/FindByMemberNo',{userid})
                    .then((res)=>{
                        console.log( res.data)
                        if(res.data ==''){
                            alert('등록된아이디가없습니다.')
                            this.memberNo = null
                        }
                        else{
                            this.coin = 1
                            this.memberNo = res.data.memberNo
                            this.address = res.data.address
                            this.phoneNo = res.data.phoneNo
                            this.regDate = res.data.regDate
                            this.email = res.data.email
                            this.birthday = res.data.birthday
                            this.name = res.data.name
                            this.gender = res.data.gender
                            this.e1 = 2
                        }
                    })
            },
            idMatchedBirthday(){
                   
                /*
                if(this.maybebirthday == this.birthday) {

                    console.log('주민번호일치')
                    
                    this.coin = 2
                }else{
                    console.log(this.maybebirthday)
                    
                    alert('주민번호앞자리가 일치하지않습니다.')
                }
                */
                
               
               const {userid,maybebirthday} = this
               axios.post('http://localhost:9999/jpamemberManage/IdMatchedBirthday/',{userid,maybebirthday})
               .then( (res) => {
                   if(res.data == true){
                       this.e1 = 3
                   }
                   else{
                       alert('생년월일이 일치하지않습니다.')
                   }
               }) 
               

            },
            checkMemberNo(memberNo,birthday,address,phoneNo,regDate,email){
                console.log(memberNo)
                console.log(birthday)
                console.log(address)
                console.log(phoneNo)
                console.log(regDate)
                console.log(email)

            },
            checkMemberWho(userid){
                console.log(userid)
            },
            PasswordReset(){

                    const {memberNo, userid, name, birthday,address,phoneNo,email,password,regDate,gender } = this
                    axios.post(`http://localhost:9999/jpamemberManage/ModifyMember/${memberNo}`,{name, userid, email, address, phoneNo,  gender,birthday,password,regDate})
                    .then( () =>{
                        alert("수정완료")
                        this.$router.go()
                    })

            }
            
    },
    data() {
            return{
                userid: '',
                coin: 0,
                name: '',
                memberNo: null,
                birthday: '',
                address: '',
                phoneNo: '',
                gender: '',
                regDate: '',
                email: '',
                maybebirthday: '',
                password: '',
                passwordchecking: '',
                passwordCheck: [
            v => this.password ===v || '비밀번호가 일치하지않습니다'
           
            ],
            e1: 1,


            }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
p{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 2.5em;
}
</style>