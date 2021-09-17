<template>
    <div>
       
                <table >
            <tr>
                <td>회원번호</td>
                <td>{{member.memberNo}}</td>
            </tr>

            <tr>
                  <td>아이디</td>
                <td>{{member.userid}}</td>
            </tr>
             <tr>
                <td>비밀번호</td>
                <td>암호화되어있습니다.</td>
            </tr>

            <tr>
                  <td>이름</td>
                <td>{{member.name}}</td>
            </tr>

            <tr>
                  <td>이메일</td>
                <td>{{member.email}}</td>
            </tr>

            <tr>
                  <td>생년월일</td>
                <td>{{$moment(member.birthday).format('YYYY-MM-DD/hh:mm')}}</td>
            </tr>

            <tr>
                  <td>휴대전화</td>
                <td>{{member.phoneNo}}</td>
            </tr>

            <tr>
                  <td>성별</td>
                <td>{{member.gender}}</td>
            </tr>

            <tr>
                  <td>주소</td>
                <td>{{member.address}}</td>
            </tr>

            <tr>
                  <td>생성일자</td>
                <td>{{$moment(member.regDate).format('YYYY-MM-DD/hh:mm')}}</td>
            </tr>
        </table>
       
       
    </div>
</template>

<script>
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment)

export default {
    name: 'MemberListReadForm',
    props:{
        member:{
            type: Object,
            require: true
            
        }
    },
    methods: {
       
    }
}
</script>
<style scoped>


</style>