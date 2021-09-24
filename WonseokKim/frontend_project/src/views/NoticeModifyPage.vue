<template>
    <div align="center">
        <v-container>
        <h2>게시물 수정</h2>
        <notice-modify-form v-if="notice" :notice="notice" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
        </v-container>
    </div>
</template>

<script>

import NoticeModifyForm from '@/components/notice/NoticeModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'NoticeModifyPage',
    components: {
        NoticeModifyForm
    },
    props: {
        noticeNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['notice'])
    },
    methods: {
        ...mapActions(['fetchNotice']),
        onSubmit (payload) {
            const { title, content } = payload
            axios.put(`http://localhost:8888/vuenotice/${this.noticeNo}`, { title, content })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'NoticeReadPage',
                            params: { noticeNo: res.data.noticeNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchNotice(this.noticeNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>