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

export default {
    //공지사항 게시판
    [FETCH_NOTICE_LIST] (state, notices) {
        state.notices = notices;
    },
    [FETCH_NOTICE] (state, notice) {
        state.notice = notice;
    },
    [CRAWL_START] (state, payload) {
        state.lists = payload
    },
    //질문 게시판
    [FETCH_QUESTION_LIST] (state, questions) {
        state.questions = questions;
    },
    [FETCH_QUESTION] (state, question) {
        state.question = question;
    },
    [FETCH_SESSION] (state) {
        state.session = this.$cookies.get(userSession)
    }
}