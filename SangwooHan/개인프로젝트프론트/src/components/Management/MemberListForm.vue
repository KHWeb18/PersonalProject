<template>
    <div>
        <h3 align="center">게시물 목록</h3>
        <body>
    
        <table border="2">
            <tr >
                <th align="center" width="50">번호</th>
                 <th align="center" width="100">아이디</th>
                 <th align="center" width="80">이름</th>
                 <th align="center" width="150">메일</th>
                 <th align="center" width="100">생일</th>
                 <th align="center" width="50">성별</th>
                  <th align="center" width="50">휴대전화</th>
                 <th align="center" width="300">주소</th>
                 <th align="center" width="60">가입일자</th>  
            </tr>
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)"> <td colspan="7"> 등록된회원없음.</td></tr>
            <tr v-else v-for="member in members" :key="member.memberNo" >
                <td align="center">{{ member.memberNo }}</td>  
                <td align="left">
                    <router-link :to="{ name: 'MemberListReadPage',
                                    params: { memberNo: member.memberNo.toString() } }"
                                    > 
                        {{ member.userid }}
                    </router-link>
                </td>
                    
                
                        <td align="center">{{ member.name}}</td>
                        <td align="center">{{ member.email}}</td>
                        <td>{{$moment(member.birthday).format('YYYY-MM-DD')}}</td>
                        <td align="center">{{ member.gender}}</td>
                        <td align="center">{{ member.phoneNo}}</td>
                        <td align="center">{{ member.address}}</td>
                        <td>{{$moment(member.regDate).format('YYYY-MM-DD')}}</td>
            </tr>
        </table>

        </body>
    </div>
</template>

<script>
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment);
export default {
    name: 'MemberListForm',
    props: {
        members: {
            type: Array
        }
    }
}
</script>

<style scoped>

</style>