<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                  <tr>
                <td>회원번호</td>
                <td><input type="text" v-model="memberNo" readonly></td>
            </tr>

            <tr>
                  <td>아이디</td>
                <td><input type="text" v-model="userid" ></td>
            </tr>
            <tr>
                  <td>비밀번호</td>
                <td><input v-model="password"/></td>
            </tr>

            <tr>
                  <td>이름</td>
                <td><input type="text" v-model="name" readonly></td>
            </tr>

            <tr>
                  <td>이메일</td>
                <td><input type="text" v-model="email"></td>
            </tr>

            <tr>
                  <td>생년월일</td>
                <td>{{$moment(member.birthday).format('YYYY.MM.DD')}}</td>
            </tr>

            <tr>
                  <td>휴대전화</td>
                <td><input type="text" v-model="phoneNo"></td>
            </tr>

            <tr>
                  <td>성별</td>
                <td><input type="text" v-model="gender" readonly></td>
            </tr>

            <tr>
                  <td>주소</td>
                <td><input type="text" v-model="address"></td>
            </tr>

            <tr>
                  <td>생성일자</td>
                <td>{{$moment(member.regDate).format('YYYY.MM.DD')}}</td>
            </tr>
            </table>
            <v-btn type="submit">정보변경하기</v-btn>
            <v-dialog  v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn    dark v-on="on">회원삭제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   정말삭제하시겟습니까?
               </v-card-title>
               
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click="btn_click">확인</v-btn>
               <v-btn @click.native="cancle">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
        </form>
    </div>
</template>

<script>

import Vue from 'vue'
import VueMoment from 'vue-moment'
import axios from 'axios'
Vue.use(VueMoment)
export default {
    name: 'MemberModifyPageForm',
    props: {
        member: {
            type: Object,
            require: true
        }
    },
    data(){
        return{
            memberNo: this.member.memberNo,
            userid: this.member.userid,
            password: this.member.password,
            name: this.member.name,
            email: this.member.email,
            birthday: this.member.birthday,
            phoneNo: this.member.phoneNo,
            gender: this.member.gender,
            address: this.member.address,
            regDate: this.member.regDate,   
            dialog:false

        }
    },
    methods: {
            onSubmit() {

                const {memberNo, userid,password ,name, email , birthday, phoneNo ,gender,address, regDate} = this
                this.$emit('submit', {memberNo, userid,password ,name, email , birthday, phoneNo ,gender,address, regDate})
            },
            check(){
                console.log(this.memberNo)
            },
            btn_click (){
            
                    
                    const { memberNo} = this
                    axios.delete(`http://localhost:9999/jpamemberManage/${memberNo}`)
                    .then(() => {
                        alert('삭제완료')
                        this.$router.push({ name: 'MemberList'})
                    }).catch(err =>{ alert(err.response.data.message)})
                   
                
                
        },
        cancle(){this.dialog = false }
    },
    created () {
     

    }
    

}
</script>