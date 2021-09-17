<template>
     <div>
         
         <form @submit.prevent="onSubmit">
           <v-container id="LoginField" style="max-width:300px"> 
               
               <v-text-field type="text" label="아이디" v-model="id">
               </v-text-field>
               <v-text-field type="password" label="비밀번호" v-model="pw">
               </v-text-field>
               <v-btn  class="green" @click="onSubmit"><v-icon>mdi-login-variant</v-icon>로그인</v-btn>
               <v-btn route :to="{name: 'FindByPasswordPage'}">비밀번호찾기</v-btn>
               <!--
               <v-btn class="blue"  route :to="{ name: 'SignupPage' }">회원가입</v-btn>
               <v-btn class="red"  route :to="{ name: 'Home' }">취소</v-btn>
               -->
           </v-container>
           
         </form>
     </div>
</template>

<script>
export default {
    name: 'NewLoginPageForm',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    props: {
        members: {
            type: Array
        }
    },
    methods: {
        
        onSubmit () {
            
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
             
           }
           
            
         

    
        }
    }

</script>

<style scoped>
#LoginField{
    margin-left: 0px;
}
</style>