<template>
    <div align="center">
        <h3>회원 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="640">아이디</th>
                <th align="center" width="240">마지막 정보 수정일</th>
            </tr>
            <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <td colspan="4">
                현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="member in members" :key="member.memberNo">
                <td align="center">{{ member.memberNo }}</td>
                <td align="left">{{ member.email }}
                    <!--
                    <router-link :to="{ name: 'BoardReadPage',
                                    params: { memberNo: member.memberNo.toString() } }">
                        {{ board.title }}
                    </router-link> -->
                </td>
                <td align="center">{{ member.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MemberListForm',
    props: {
        members: {
            type: Array
        }
    }
}
</script>