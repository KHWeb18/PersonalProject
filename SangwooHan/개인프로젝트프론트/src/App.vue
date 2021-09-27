  
<template>
<v-app>
    <body>
    <div class="header">
    <top-nav-bar @submit="onSubmit" :members="members"/>
 <header align="center" id="header"><img id="homebtn" @click="GoHome" src="@/assets/상우/홈로고.png"/></header> 
    </div>
    <nav-bar/>
    
   <!-- <v-btn width="80px" @click="check">로그인한사람</v-btn>-->
    
   <!-- <new-login-page-form v-if="this.$store.state.session ==null" @submit="onSubmit" :members="members"/> -->
     
   <!-- <v-btn  @click="logout" width="80px">로그아웃</v-btn>-->
    
    
<div class="section">
 <router-view/>
</div>

  <div class="footer" >
  <footer-component/>
   </div>
  
    
    </body>
</v-app>
</template>

<script>

import cookies from 'vue-cookies'
import Vue from 'vue'
import NavBar from './views/NavigationVar/NavBar.vue'
import TopNavBar from './views/NavigationVar/TopNavBar.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
//import NewLoginPageForm from '../src/components/Login/NewLoginPageForm.vue'
import FooterComponent from './components/footer/FooterComponent.vue'
Vue.use(cookies)

export default {
  name: 'App',
      components: {
       NavBar,
    TopNavBar ,
   // NewLoginPageForm,
    FooterComponent
    
    },
    computed: {
      ...mapState(['members','loginMemberNo'])
    },
   
                
    methods: {
      ...mapActions(['fetchMemberList']),
     // 홈로고 동작 로직 .. value값을 받아내어 직접 console.log로 baseURI를 받아내어  
     // if문을통해 홈페이지가 아니면 동작하게끔 하는로직.
      handleClick(value){
        console.log(value.srcElement.baseURI)
      if(value.srcElement.baseURI == 'http://localhost:8080/'){
        alert('홈페이지입니다.')
      }else{
        this.$router.push({name: 'Home'})
      }
},
GoHome(){
  this.$router.replace({name: 'Home'})
},
check(){
  console.log(this.$cookies.get('user'))
   console.log('로그인유무정보'+this.$store.state.isLogin)
   console.log(this.$store.state.User)
   console.log(this.$store.state.loginMemberNo)
  // console.log(this.$store.state.userid2)
},
onSubmit (payload) {
           if(this.$store.state.session ==null){
            const { id, pw } = payload
            axios.post('http://localhost:9999/jpamemberManage/login', { userid: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data != "") {
                             console.log(res.data)
                            alert('로그인 성공! - ' + res.data)

                            for(var i = 0 ; i <this.members.length ; i++){
                              
                               if(this.members[i].userid == id ){
                                 this.$store.state.loginMemberNo = this.members[i].memberNo
                               }
                                                                          }
                          //  this.$store.state.userid2 = res.data.userid
                            this.$cookies.set("memberNo",this.$store.state.loginMemberNo,'1h')
                            //this.$cookies.set("userid2",this.$store.state.userid2,'1h')
                            this.$store.state.isLogin = true;
                            this.$store.state.session = res.data;
                            this.$store.state.User = res.data.userid;
                            this.$cookies.set("user", res.data, '1h')
                            
                          this.$router.go()
                     
                            
                        } else {
                            alert('비밀번호가 틀렸습니다. - ' + res.data)
                        }
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
           } else{
                alert('이미로그인이 되어있습니다.' +this.$store.state.session.userid)
           }
},
logout() {
  this.$cookies.remove('user')
  this.$cookies.remove('memberNo')
  this.$cookies.remove('setter')
  this.$cookies.remove('coin')
 // this.$cookies.remove('userid2')
            this.$store.state.isLogin = false
            this.$store.state.session =null
            this.$store.state.loginMemberNo =null
        //    this.$store.state.userid2 =null
            this.$router.push({name: 'Home'})
}

    },
    mounted () {
          this.$store.state.session = this.$cookies.get('user')
          this.$store.state.loginUser = this.$cookies.get('user')
          this.$store.state.loginMemberNo =this.$cookies.get('memberNo')
       //   this.$store.state.userid2 = this.$cookies.get('userid2')
          
          if( this.$store.state.session != null) {
              this.$store.state.isLogin =true
          }
          if(this.$store.state.loginUser != null){
            this.$store.state.User = this.$store.state.loginUser.userid
         
          }
          this.fetchMemberList()
      },
}
</script>

<style>

/*
.footer {
   height: 200px;
  margin-top: 2000px;
  background-color: rgb(32, 32, 32);
  text-decoration-color: seashell;
}
*/
/*
table {
  font-weight: bold;
  background: #eee;
}
h4{
    width: 700px;
    height: 700px;
}
*/


</style>
