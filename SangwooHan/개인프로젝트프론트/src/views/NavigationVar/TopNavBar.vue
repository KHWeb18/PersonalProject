<template>
<div>
    <!--로그아웃일때-->
   
    <v-toolbar  flat  v-if="this.$store.state.session == null">
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <!--
        <v-btn depressed route :to="{name: 'SignupPage'}">
            
            <v-icon>
                mdi-human-greeting
            </v-icon>
            회원가입
        </v-btn>
        -->
         <v-row justify="center">
    <v-dialog
      v-model="Signup"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn depressed
          height="76px"
          v-bind="attrs"
          v-on="on"
          
        >
          회원가입
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="text-h5">회원가입</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
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
            <v-select
            :items="selectgender"
            v-model="gender" label="성별">
            </v-select>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="Signup = false"
          >
            취소
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="SignupStart()"
          >
            가입
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>



         <v-dialog  v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn   depressed v-on="on">로그인</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   Login
               </v-card-title>
               <v-card-text>
                  <v-text-field label="아이디" v-model="id" type="text" flat solo>
              </v-text-field>
              <v-text-field label="비밀번호" v-model="pw" type="password"  flat solo>
              </v-text-field>
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn route @click.native="Logincancle" :to="{name: 'FindByPasswordPage'}">비밀번호찾기</v-btn>
                   <v-btn @click="OnSubmit">로그인</v-btn>
               <v-btn @click.native="Logincancle">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
     
    </v-toolbar-items>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar  flat  v-if="this.$store.state.session != null" >
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <!--
        <v-btn depressed route :to="{name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}}" >
            장바구니
        </v-btn>
        -->
        <!--
        <v-btn depressed @click="handleClick">
            <v-icon>mdi-logout</v-icon>
            로그아웃
        </v-btn>
        -->
        <v-bottom-sheet
      v-model="sheet"
      inset
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          depressed
          
          v-bind="attrs"
          v-on="on"
        >
          <v-icon>mdi-logout</v-icon>
            로그아웃
        </v-btn>
      </template>
      <v-sheet
        class="text-center"
        height="200px"
      >
        <v-btn
          class="mt-6"
          text
          color="error"
          @click="handleClick"
        >
          로그아웃
        </v-btn>
        <div >
          <p>GoodBye</p>
        </div>
      </v-sheet>
    </v-bottom-sheet>
        <v-btn depressed route :to="{name: 'MyPage'}">
            {{this.User}}님
        </v-btn>


        <v-btn depressed route :to="{name: 'NoticeListPage'}" >
            공지판
        </v-btn>
       
    </v-toolbar-items>
    </v-toolbar>
  
        </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'

Vue.use(cookies)
import { mapState } from 'vuex'
import axios from 'axios'

export default {
    computed: {
        ...mapState(['loginMemberNo','User','emailRules',
            'passwordRules',
            'nameRules',
            'loadingState',])
    },
    props:{
        members:{
            type:Array
        }
    },
    methods:{

            handleClick(value){
  this.$cookies.remove('user')
  this.$cookies.remove('memberNo')
  this.$cookies.remove('setter')
  this.$cookies.remove('coin')
            this.$store.state.isLogin = false
            this.$store.state.session =null
            this.$store.state.loginMemberNo =null
            this.sheet = false
            console.log(value.srcElement.baseURI)
      if(value.srcElement.baseURI == 'http://localhost:8080/'){
        this.$router.go()
      }else{
        this.$router.push({name: 'Home'})
        this.$router.go()
      }
                                },
                                 Logincancle(){
            this.dialog  =false
        },
        OnSubmit () {
            
           for(var i = 0; i < this.members.length; i++){
             if(this.members[i].userid == this.id){
                 
                 const {id ,pw } = this
                 this.$emit('submit' ,{ id , pw})

                 return {
                     SelectedUser: 1
                 }
             }
            
             }
             let SelectedUser = null
        this.members.forEach(user =>{
            if(user.userid === this.userid) SelectedUser = user})
        if(SelectedUser ===null)alert('등록된 회원정보가없습니다.')
             
           },
            SignupStart (){
                let coin = null;
                for(var i = 0 ; i < this.members.length ; i ++){

                      if(this.members[i].userid === this.userid){
                    alert('등록된 아이디가있습니다.')
                    return coin = 1;
                                                                 }
                
                                                                }
                if(coin === null){
                    
            const { userid, password, name, email, birthday, gender, address, phoneNo } = this
            axios.post('http://localhost:9999/jpamemberManage/register', {userid, password, name, email, birthday, gender, address, phoneNo})
                .then(res =>{
                    alert('회원가입 성공' + res)
                    this.$router.go()
                    this.Signup = false
                }).catch(res => {
                    alert(res.response.data.message)
                })
             
                }

                  }
    },
    data () {
        return {
            selectgender:[
                {text: '남자', value: '남자'},
                {text: '여자', value: '여자'}
            ],
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
            Signup: false,
            nav_drawer: false,
            group: false,
            dialog: false,
            id: '',
            pw: '',
            sheet: false,
            mypage: false,
            LogOutlinks: [
                {  
                    text: '회원가입',
                    name: '회원가입',
                    route: '/signuppage',
                },
                {
                    text: 'ㅣ공지판ㅣ',
                    name: '공지판',
                    route: '/noticeListPage',
                },
            ],
             LogInlinks: [
               {
                    text: 'ㅣ장바구니ㅣ',
                    name: '장바구니',
                    
                },
                  {
                    text: 'ㅣ공지판ㅣ',
                    name: '공지판',
                    route: '/noticeListPage',
                },
               
            ],
            LogInlinks2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                {
                     icon: 'mdi-login',
                    text: '로그인',
                    name: '로그인',
                    route: '/loginpage',
                },
                {
                     icon: 'mdi-account-child',
                    text: '회원가입',
                    name: '회원가입',
                    route: '/signuppage',
                },
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            LogOutlinks2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                 
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            ManageLinks: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                   {
                     
                    text: '곤충갤러리',  
                    name: '곤충갤러리(수정예정)',
                    route: '/Test/:Id',
                },
                {
                     
                    text: '곤충박물관',  
                    name: '곤충박물관(수정예정)',
                    route: '/insectmuseumpage',
                },
                 {
                     
                    text: '커뮤니티게시판',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                {
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
                },
            ]
            

        }
    },
   watch: {
       group () {
           this.nav_drawer =false
       }
   }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@900&display=swap');
#toolbar{
    border-style: none;
}
p{
    font-family: 'Roboto Slab', serif;
    font-size: 3.0em;
}
</style>