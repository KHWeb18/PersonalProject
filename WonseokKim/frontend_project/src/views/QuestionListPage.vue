<template>
        <div id="question" align="center">
            <v-container>
                <h1>질문사항</h1>
                <div align="right" @click="showSession">
                <router-link :to="{ name: 'QuestionRegisterPage' }">
                    질문사항 작성
                </router-link>
                </div>
                <question-list :questions="questions"></question-list>
            </v-container>
        </div>
</template>

<script>

import Vue from 'vue'
import QuestionList from '@/components/question/QuestionList.vue'
import { mapState, mapActions } from 'vuex'
import cookies from 'vue-cookies'
import axios from 'axios'

Vue.use(cookies)
export default {
    name: 'QuestionListPage',
    components: {
        QuestionList
    },
    computed: {
        ...mapState(['questions']),
        ...mapState(['session'])
    },
    mounted () {
        this.fetchQuestionList()
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
            this.isLogout = false
        }
    },
    methods: {
        ...mapActions(['fetchQuestionList']),
        ...mapActions(['fetchSession']),
        showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:8888/jpasession/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
                this.$router.push({
                name: 'QuestionListPage',
                //params: { boardNo: res.data.boardNo.toString() }
                })
            }
        }
    }
}
</script>