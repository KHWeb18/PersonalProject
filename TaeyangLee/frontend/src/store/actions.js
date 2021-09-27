import {
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    
    FETCH_GONGZI_LIST,
    FETCH_GONGZI,
    CRAWL_START,
    

} from './mutation-types'

import axios from 'axios'
import router from '../router'


export default {
 
    // 게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/board/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/board/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    
    
    fetchGongziList ({ commit }) {
        return axios.get('http://localhost:7777/gongzi/lists')
                .then((res) => {
                    commit(FETCH_GONGZI_LIST, res.data)
                })
    },
    fetchGongzi ({ commit }, gongziNo) {
        return axios.get(`http://localhost:7777/gongzi/${gongziNo}`)
                .then((res) => {
                    commit(FETCH_GONGZI, res.data)
                })
    },
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/daumCrawler/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    }
    
    
}