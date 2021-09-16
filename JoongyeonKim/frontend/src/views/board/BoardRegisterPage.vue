<template>
    <div align="center">
        <h2>게시글 등록</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { email, title, content } = payload
            axios.post('http://localhost:7777/board/register', { email, title, content })
                    .then(res => {
                        alert('게시글이 등록 되었습니다 - ' + res)
                        this.$router.push('boardList')
                    })
                    .catch(res => {
                        alert('게시글 등록이 실패하였습니다'+ res)
                    })
        },
    }
}
</script>