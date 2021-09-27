<template>
    <div>
        <h3>공지사항 수정 아웃라인</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" :value="notice.noticeNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="notice.regDate" disabled></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" v-model="title"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" :value="notice.writer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'NoticeReadPage', params: { noticeNo: notice.noticeNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'NoticeModifyForm',
    props: {
        notice: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title, content })
        }
    },
    created () {
        this.title = this.notice.title
        this.content = this.notice.content
    }
}
</script>


<style scoped>
td, th {
  padding: 10px;
  border: 1px solid rgb(16, 209, 151);
}
body {
  padding: 0rem;
}
</style>