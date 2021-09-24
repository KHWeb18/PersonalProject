<template>
    <div align="center">
        <v-container>
        <h2>질문사항 작성</h2>
        <question-register-form @submit="onSubmit"/>
        </v-container>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import QuestionRegisterForm from '@/components/question/QuestionRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'QuestionRegisterPage',
    components: {
        QuestionRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:8888/vuequestion/register', { title, writer, content })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'QuestionListPage',
                            params: { questionNo: res.data.questionNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>