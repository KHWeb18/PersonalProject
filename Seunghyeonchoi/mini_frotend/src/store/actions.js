import {
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_COMMENT_LIST,

    FETCH_FOOD_LIST,
    FETCH_FOOD,
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    CRAWL_START
} from './mutation-types'

import axios from 'axios'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // 공지게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/noticeboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/noticeboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    fetchCommentList ({ commit }, No) {
        return axios.get(`http://localhost:7777/noticeboard/comment/${No}`)
                .then((res) => {
                    commit(FETCH_COMMENT_LIST, res.data)
                })
    },
    // 자유게시판
    fetchFreeBoardList ({ commit }) {
        return axios.get('http://localhost:7777/freeboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchFreeBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/freeboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    fetchFreeCommentList ({ commit }, No) {
        return axios.get(`http://localhost:7777/freeboard/comment/${No}`)
                .then((res) => {
                    commit(FETCH_COMMENT_LIST, res.data)
                })
    },
    // 사료 목록 게시판
    fetchFoodList ({ commit }) {
        return axios.get('http://localhost:7777/foodboard/lists')
                .then((res) => {
                    commit(FETCH_FOOD_LIST, res.data)
                })
    },
    fetchFood ({ commit }, foodNo) {
        return axios.get(`http://localhost:7777/foodboard/${foodNo}`)
                .then((res) => {
                    commit(FETCH_FOOD, res.data)
                })
    },
    // 회원 목록 게시판
    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:7777/jpamember/mlists')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:7777/jpamember/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },
    // 크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/crawl/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)
                })
    }
}