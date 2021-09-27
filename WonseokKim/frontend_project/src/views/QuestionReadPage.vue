<template>
    <div align="center">
        <v-container>
        <h2>질문사항 게시판 읽기</h2>
        <question-read v-if="question" :question="question"/>
        <p v-else>로딩중 ...... </p>

        <router-link :to="{ name: 'QuestionModifyPage', params: { questionNo } }">
            질문사항 수정
        </router-link>

        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'QuestionListPage' }">
            질문사항 보기
        </router-link>
        </v-container>
    </div>
</template>

<script>
import QuestionRead from '@/components/question/QuestionRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'QuestionReadPage',
    props: {
        questionNo: {
            type: String,
            required: true
        }
    },
    components: {
        QuestionRead
    },
    computed: {
        ...mapState(['question'])
    },
    created () {
        this.fetchQuestion(this.questionNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchQuestion']),
        onDelete () {
            const { questionNo } = this.question
            axios.delete(`http://localhost:8888/vuequestion/${questionNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'QuestionListPage'})
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>
