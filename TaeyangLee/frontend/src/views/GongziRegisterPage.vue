<template>
    <div align="center">
        <h2>공지사항 작성</h2>
        <gongzi-register-form @submit="onSubmit"/>
    </div>
</template>


<script>
import GongziRegisterForm from '@/components/gongzi/GongziRegisterForm'
import axios from 'axios'


export default {
    name: 'GongziRegisterPage',
    components: {
        GongziRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, writer, content } = payload
            axios.post('http://localhost:7777/gongzi/register',{ title, writer, content })
            .then(res => {
                alert('등록 성공!' + res)
                this.$router.push({
                    name: 'GongziListPage'
                    //params: {boardNo: res.data.boardNo.toString() }
                })
                
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }

}
</script>