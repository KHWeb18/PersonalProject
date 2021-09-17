<template>
     <div>
         
         <form>
           <v-container style="max-width:600px"> 
               <h2>로그인페이지</h2>
               <v-text-field type="text" label="아이디" v-model="userid">
               </v-text-field>
               <v-text-field type="password" label="비밀번호" v-model="password">
               </v-text-field>
               <v-btn  class="green" @click="login">로그인</v-btn>
               <v-btn class="blue"  route :to="{ name: 'SignupPage' }">회원가입</v-btn>
               <v-btn class="red"  route :to="{ name: 'Home' }">취소</v-btn>
           </v-container>
           
         </form>
     </div>
</template>

<script>

export default {
    name: 'LoginPageForm',
    props: {
        members: {
            type: Array
        }
    },

   data() {

       return{
           userid: '',
           password: '',
          
           
           
       }
   },
   methods: {
       
      
      login(){
        let SelectedUser = null
        this.members.forEach(user =>{
            if(user.userid === this.userid) SelectedUser = user})
        if(SelectedUser ===null)alert('등록된 회원정보가없습니다.')
        else{
            if(SelectedUser.password !== this.password)
            alert('비밀번호가 일치하지않습니다.')
            else{
                alert('로그인이 완료되었습니다.')
                this.$router.push({
                    name: 'Home'
                })
            }
        }

        
            
      },
     
      
   }
    
}
</script>
