<template>
    <div>
            <table >
                <tr>
                    <th>등록번호</th>
                    <td>{{member.memberNo}}</td>
                </tr>
                <tr>
                    <th>회원이름</th>
                    <td>{{member.name}}</td>
                    
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>{{member.userid}}</td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td v-if="emailModify == 0">{{member.email}}</td>
                    <td v-if="emailModify == 1"><v-text-field v-model="email" :rules="emailRules"/></td>
                    <v-btn v-if="emailModify == 0" @click="emailModifyON">이메일수정</v-btn>
                    <v-btn v-if="emailModify == 1" @click="emailModifyOFF">취소</v-btn>
                    <v-btn v-if="emailModify == 1" @click="StartemailModify(member.memberNo)">완료</v-btn>
                </tr>
                <tr>
                    <th>주소</th>
                    <td v-if="addressModify == 0" >{{member.address}}</td>
                    <td v-if="addressModify == 1"><input v-model="address"/></td>
                    <v-btn v-if="addressModify == 0" @click="addressModifyON">주소변경</v-btn>
                    <v-btn v-if="addressModify == 1" @click="addressModifyOFF">취소</v-btn>
                    <v-btn v-if="addressModify == 1" @click="StartaddressModify(member.memberNo)">완료</v-btn>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td v-if="phoneNoModify == 0" >{{member.phoneNo}}</td>
                    <td v-if="phoneNoModify == 1"><input v-model="phoneNo"/></td>
                    <v-btn v-if="phoneNoModify == 0" @click="phoneNoModifyON">연락처변경</v-btn>
                    <v-btn v-if="phoneNoModify == 1" @click="phoneNoModifyOFF">취소</v-btn>
                    <v-btn v-if="phoneNoModify == 1" @click="StartphoneNoModify(member.memberNo)">완료</v-btn>
                </tr>
            </table>
            <tr>
                <td>
            <table style="margin-left:195px">
                
            <v-container style="max-width: 350px;">
           
            <!--
            <form @submit.prevent="StartpasswordModify(member)">
            
            <v-text-field v-if="passwordModify == 1" v-model="password" type="password" label="비밀번호">
            </v-text-field>
            <v-text-field v-if="passwordModify == 1" v-model="passwordcheck1" type="password" label="비밀번호확인"  :rules="passwordCheck">
            </v-text-field>
                <p>※주의비밀번호변경시 장바구니정보가 초기화됩니다.</p>
            <v-btn v-if="passwordModify == 1" type="submit">변경</v-btn>
            <v-btn v-if="passwordModify == 1" @click="PasswordModifyOFF">취소</v-btn>
            </form>
            -->
             <v-dialog  :retain-focus="false" v-model="dialog" persistent max-width="400" >
               <template v-slot:activator="{ on }">
               <v-btn    dark v-on="on">비밀번호 변경</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   비밀번호초기화시 장바구니정보초기화
               </v-card-title>
               <v-card-text>
                 <v-text-field v-model="password" type="password" label="비밀번호">
            </v-text-field>
            <v-text-field  v-model="passwordcheck1" type="password" label="비밀번호확인"  :rules="passwordCheck">
            </v-text-field>
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click.native="StartpasswordModify(member)" class="red">변경</v-btn>
               <v-btn @click.native="PasswordModifyOFF">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
           
           <v-dialog  :retain-focus="false" v-model="dialog2" persistent max-width="400" >
               <template v-slot:activator="{ on }">
               <v-btn    dark v-on="on">회원탈퇴</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                  정말회원탈퇴하시겟습니까?
               </v-card-title>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click.native="MemberEnd(member.memberNo)" class="red">예</v-btn>
               <v-btn @click.native="MemberEndCancle">아니오</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
            </v-container>
            </table>
                </td>
            </tr>
    
    </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'

Vue.use(cookies)
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'MyInformationDetailForm',
    
    computed:{
        ...mapState(['emailRules','member','loginMemberNo'])
    },
    data(){
        return{
            emailModify: 0,
            addressModify: 0,
            phoneNoModify: 0,
            passwordModify: 0,
            passwordcheck1: '',
            passwordCheck: [
            v => this.password ===v || '비밀번호가 일치하지않습니다'
            ],
            
            password: '',
            email: '',
            phoneNo: 0,
            address: '',
            dialog: false,
            dialog2: false,
            
        }
    },
    created(){
        this.fetchMember(this.loginMemberNo)
    },
    methods:{
        ...mapActions(['fetchMember']),
        emailModifyON() {
            this.emailModify =1
        },
        addressModifyON(){
            this.addressModify =1   
        },
        phoneNoModifyON() {
            this.phoneNoModify = 1
        },
        emailModifyOFF() {
            this.emailModify =0
        },
        addressModifyOFF(){
            this.addressModify =0
        },
        phoneNoModifyOFF() {
            this.phoneNoModify = 0
        },
        PasswordModifyON(){
            this.passwordModify = 1
        },
        PasswordModifyOFF(){
            this.dialog =false
        },
        MemberEndCancle(){
            this.dialog2 = false
        },
        
        StartemailModify(memberNo){
                const {email} =this
                axios.post(`http://localhost:9999/jpamemberManage/ModfiyEmail/${memberNo}`,{email})
                .then(() =>{
                    alert('수정이완료되었습니다.')
                    this.$router.go()
                })
        },
        StartphoneNoModify(memberNo){
                const {phoneNo} =this
                axios.post(`http://localhost:9999/jpamemberManage/ModfiyPhoneNo/${memberNo}`,{phoneNo})
                .then(() =>{
                    alert('수정이완료되었습니다.')
                    this.$router.go()
                })
        },
        StartaddressModify(memberNo){
                const {address} =this
                axios.post(`http://localhost:9999/jpamemberManage/ModfiyAddress/${memberNo}`,{address})
                .then(() =>{
                    alert('수정이완료되었습니다.')
                    this.$router.go()
                })
        },                                                                                       
        StartpasswordModify(member){
                const {name, userid, email, address, phoneNo,  gender,birthday,regDate} =member
                const {password} =this
            axios.post(`http://localhost:9999/jpamemberManage/ModifyMember/${this.member.memberNo}`,{name, userid, email, address, phoneNo,  gender,birthday,password,regDate})
            .then( ()=> {
                alert('비밀번호변경완료')
                this.$router.go()
            })
        },
        MemberEnd(memberNo){
            axios.delete(`http://localhost:9999/jpamemberManage/deleteMember/${memberNo}`)
            .then( ()=>{
                alert('회원탈퇴되었습니다.')
                this.$cookies.remove('user')
                this.$cookies.remove('memberNo')
                this.$cookies.remove('setter')
                this.$cookies.remove('coin')
                this.$store.state.isLogin = false
                this.$store.state.session =null
                this.$store.state.loginMemberNo =null
                this.sheet = false
                this.dialog2 = false
                this.$router.push({name: 'Home'})
                this.$router.go()
            })
               
            
        }
      
       


    }
}
</script>

<style scoped>

</style>