import {
    // 공지사항 게시판
    FETCH_NOTICE_LIST,
    FETCH_NOTICE,
    // 크롤링
    CRAWL_START,
    //질문 게시판
    FETCH_QUESTION_LIST,
    FETCH_QUESTION,
    // 세션
    FETCH_SESSION
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {
    //게사판
    fetchNoticeList ({ commit }) {
        return axios.get('http://localhost:8888/vuenotice/lists')
                .then((res) => {
                    commit(FETCH_NOTICE_LIST, res.data)
                })
    },
    fetchNotice ({ commit }, noticeNo) {
        return axios.get(`http://localhost:8888/vuenotice/${noticeNo}`)
                .then((res) => {
                    commit(FETCH_NOTICE, res.data)
                })
    },
    // 크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:8888/daumCrawler/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },
    fetchQuestionList ({ commit }) {
        return axios.get('http://localhost:8888/vuequestion/lists')
                .then((res) => {
                    commit(FETCH_QUESTION_LIST, res.data)
                })
    },
    fetchQuestion ({ commit }, questionNo) {
        return axios.get(`http://localhost:8888/vuequestion/${questionNo}`)
                .then((res) => {
                    commit(FETCH_QUESTION, res.data)
                })
    },
    // Session
    fetchSession ({ commit }) {
        commit(FETCH_SESSION)
    }
}
