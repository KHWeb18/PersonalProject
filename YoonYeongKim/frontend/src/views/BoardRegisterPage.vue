<template>
    <div align="center">
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
            const { title, content, writer, regDate } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content, regDate })
                    .then(res => {
                        // alert('등록 성공! - ' + res)
                        console.log('게시물 번호 : ' + res.data.boardNo.toString())

                        this.$router.push({
                            name: 'BoardListPage',
                           // params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>