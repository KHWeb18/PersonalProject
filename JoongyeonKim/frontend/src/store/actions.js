import {
    // 크롤링
    CRAWL_START,

    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    // 프로젝트
    FETCH_FUNDING_LIST,
    FETCH_FUNDING,
    // 회원
    FETCH_MEMBER_LIST,
    FETCH_MEMBER
} from './mutation-types'

import axios from 'axios'
import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // 크롤링
    async crawlFind ({ commit }, category) {
    axios.get('http://localhost:7777/crawl/' + `${category}`)
            .then(({ data }) => {
                commit(CRAWL_START, data)

                if (window.location.pathname !== '/daumBlogCrawler') {
                    router.push('/daumBlogCrawler')
                }
            })
    },
    // 게시판
    fetchBoardList ({commit}) {
        return axios.get('http://localhost:7777/board/lists')
            .then((res) =>{
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
        .then((res) => {
            commit(FETCH_BOARD, res.data)
        })
    },
    // 프로젝트
    fetchFundingList ({commit}) {
        return axios.get('http://localhost:7777/funding/lists')
            .then((res) =>{
                commit(FETCH_FUNDING_LIST, res.data)
            })
    },
    fetchFunding({ commit }, fundingNo) {
        return axios.get(`http://localhost:7777/funding/${fundingNo}`)
        .then((res) => {
            commit(FETCH_FUNDING, res.data)
        })
    },
        // 프로젝트
        fetchMemberList ({commit}) {
            return axios.get('http://localhost:7777/member/lists')
                .then((res) =>{
                    commit(FETCH_MEMBER_LIST, res.data)
                })
        },
        fetchMember({ commit }, fundingNo) {
            return axios.get(`http://localhost:7777/member/${fundingNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
            })
        },
}