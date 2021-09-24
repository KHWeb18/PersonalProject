<template>
    <div>
        <v-container>
            <p>______</p>
            <p>목록</p>
        <v-data-table :headers="headerTitle" :items-per-page="10" :items="questions"
                    class="elevation-1" @click:row="handleClick">
                    <!-- 이건 데이터 테이블 아닌 그냥 테이블 양식
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="640">제목</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            -->
            <tr v-if="!questions || (Array.isArray(questions) && questions.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="question in questions" :key="question.questionNo">
                <td align="center">{{ question.questionNo }}</td>
                <td align="left">
                        {{ question.title }}
                </td>
                <td align="right">{{ question.writer }}</td>
                <td align="center">{{ question.regDate }}</td>
            </tr>
        </v-data-table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'QuestionList',
    props: {
        questions: {
            type: Array
        }
    },
    data () {
        return {
           headerTitle: [
                { text: '번호', value: 'questionNo', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '등록일자', value: 'regDate', width: "100px" }
            ],
        }
    },
    methods: {
        handleClick(question) {
            this.$router.push({
                name: 'QuestionReadPage',
                params: { questionNo: question.questionNo.toString() }
            })
        }
    }
}
</script>

<style>
/*
td, th {
  padding: 10px;
  border: 1px solid #ccc;
}
body {
  padding: 1rem;
}
*/
</style>