<template>
    <div align="center">
        <v-container>
        <h2>공지사항 게시판 읽기</h2>
        <notice-read v-if="notice" :notice="notice"/>
        <p v-else>로딩중 ...... </p>

        <router-link :to="{ name: 'NoticeModifyPage', params: { noticeNo } }">
            공지사항 수정
        </router-link>

        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'NoticeListPage' }">
            공지사항 보기
        </router-link>
        </v-container>
    </div>
</template>

<script>
import NoticeRead from '@/components/notice/NoticeRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'NoticeReadPage',
    props: {
        noticeNo: {
            type: String,
            required: true
        }
    },
    components: {
        NoticeRead
    },
    computed: {
        ...mapState(['notice'])
    },
    created () {
        this.fetchNotice(this.noticeNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchNotice']),
        onDelete () {
            const { noticeNo } = this.notice
            axios.delete(`http://localhost:8888/vuenotice/${noticeNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'NoticeListPage'})
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>
