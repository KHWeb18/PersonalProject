<template>
        <div id="notice" align="center">
            <v-container>
                <h1>공지사항</h1>
                <div align="right">
                <router-link :to="{ name: 'NoticeRegisterPage' }">
                    공지사항 작성
                </router-link>
                </div>
                <notice-list :notices="notices"></notice-list>
            </v-container>
        </div>
</template>

<script>

import NoticeList from '@/components/notice/NoticeList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'NoticePage',
    components: {
        NoticeList
    },
    computed: {
        ...mapState(['notices'])
    },
    mounted () {
        this.fetchNoticeList()
    },
    methods: {
        ...mapActions(['fetchNoticeList'])
    }
}
</script>