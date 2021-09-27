<template>
    <div>
        <h3>질문사항 읽기</h3>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" :value="question.questionNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="question.regDate" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" :value="question.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="question.writer" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" :value="question.content" readonly></textarea></td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'QuestionRead',
    props: {
        question: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style scoped>
td, th {
  padding: 10px;
  border: 1px solid rgb(233, 18, 233);
}
body {
  padding: 0rem;
}
</style>
