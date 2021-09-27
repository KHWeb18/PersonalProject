import {


    // 스프링 랜덤 데이터 통신
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    // 상품
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,

 
 

        // 세션
    FETCH_SESSION
} from './mutation-types'

import axios from 'axios'
//import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {

    // Spring과 랜덤 데이터 통신
    generateRandomNumber ({ commit }) {
        console.log(commit)

        // axios.get: GET 요청
        // axios.post: POST 요청
        // 특정 URL로 GET 혹은 POST, 그 외의 요청을 보낼 수 있음
        // 보내고 넘겨 받은 데이터는 .then((res)) 절로 수신함
        // .catch((res)) 절은 오류가 발생했을 경우임
        // 어찌 되었든 응답받은 데이터는 res가 가지고 있음
        axios.get('http://localhost:7777/random')
                .then((res) => {
                    commit(SUCCESS_GEN_RAND_NUM, parseInt(res.data.randNumber))
                })
                .catch((res) => {
                    commit(FAIL_GEN_RAND_NUM, res)
                })
    },
    // 게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/vueboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/vueboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
    // 상품
    fetchProductList ({ commit }) {
        return axios.get('http://localhost:7777/vueproduct/lists')
                .then((res) => {
                    commit(FETCH_PRODUCT_LIST, res.data)
                })
    },
    fetchProduct ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/vueproduct/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT, res.data)
                })
    },



    // Session
    fetchSession ({ commit }) {
        commit(FETCH_SESSION)
    }
}