<template>
    <div align="center">
        <v-container>
        <h2>게시물 수정</h2>
        <question-modify-form v-if="question" :question="question" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
        </v-container>
    </div>
</template>

<script>

import QuestionModifyForm from '@/components/question/QuestionModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'QuestionModifyPage',
    components: {
        QuestionModifyForm
    },
    props: {
        questionNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['question'])
    },
    methods: {
        ...mapActions(['fetchQuestion']),
        onSubmit (payload) {
            const { title, content } = payload
            axios.put(`http://localhost:8888/vuequestion/${this.questionNo}`, { title, content })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'QuestionReadPage',
                            params: { questionNo: res.data.questionNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchQuestion(this.questionNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>