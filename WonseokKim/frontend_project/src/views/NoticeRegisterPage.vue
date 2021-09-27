<template>
    <div align="center">
        <v-container>
        <h2>공지사항 작성</h2>
        <notice-register-form @submit="onSubmit"/>
        </v-container>
    </div>
</template>

<script>
// @는 src 자체를 의미 함
import NoticeRegisterForm from '@/components/notice/NoticeRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'NoticeRegisterPage',
    components: {
        NoticeRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:8888/vuenotice/register', { title, writer, content })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'NoticeListPage',
                            params: { noticeNo: res.data.noticeNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>