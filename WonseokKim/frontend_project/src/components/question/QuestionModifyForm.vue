<template>
    <div>
        <h3>질문사항 수정 아웃라인</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" :value="question.questionNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="question.regDate" disabled></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" v-model="title"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" :value="question.writer" disabled></td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'QuestionReadPage', params: { questionNo: question.questionNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'QuestionModifyForm',
    props: {
        question: {
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
        this.title = this.question.title
        this.content = this.question.content
    }
}
</script>


<style scoped>
td, th {
  padding: 10px;
  border: 1px solid rgb(13, 78, 218);
}
body {
  padding: 0rem;
}
</style>