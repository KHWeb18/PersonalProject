import {
//다음뉴스
DAUM_NEWS,
//멤버 리스트
FETCH_MEMBER_LIST,
FETCH_MEMBER,
//게시판
FETCH_BOARD,
FETCH_BOARD_LIST,
//댓글
FETCH_COMMENTS_LIST,
//공지글
FETCH_NOTICE_LIST,
FETCH_NOTICE,
FETCH_NOTICE_COMMENT_LIST,
//곤충박물관
FECTH_STAGBEETLES_LIST,
FECTH_STAGBEETLES,
FECTH_STAGBEETLES_COMMENT_LIST,
FETCH_BEETLE_LIST,
FETCH_BEETLE,
FETCH_BEETLE_COMMENT_LIST,
FETCH_DRAGONFLY_LIST,
FETCH_DRAGONFLY,
FETCH_DRAGONFLY_COMMENT_LIST,
//하늘소
FETCH_SKYCOW_LIST,
FETCH_SKYCOW,
//나비/나방
FETCH_BUTTERFLY_LIST,
FETCH_BUTTERFLY,
//쇼핑몰
FETCH_PRODUCT_LIST,
FETCH_PRODUCT,
FETCH_BASKET_LIST,
//주문정보
FETCH_ORDER_LIST,
//마이페이지.고객의소리
FETCH_CUSTOMER_SOUND_LIST,
FETCH_CUSTOMER_SOUND,
//
FETCH_USER_ORDER_LIST



} from './mutation-types'

import axios from 'axios'
import router from '../router'
export default {
    fetchMemberList({ commit }) {
        return axios.get('http://localhost:9999/jpamemberManage/lists')
        .then((res) => {
            commit(FETCH_MEMBER_LIST, res.data)
        })
    },
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:9999/' + `${category}`)
                .then(({ data }) => {
                    commit(DAUM_NEWS, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },
    fetchBoardList({ commit }) {
        return axios.get('http://localhost:9999/jpaBoard/boardlists')
        .then((res) => {
            commit(FETCH_BOARD_LIST, res.data)
        })
    },
    fetchMember ({commit}, memberNo) {
            console.log('memberNo =' + memberNo)
        return axios.get(`http://localhost:9999/jpamemberManage/${memberNo}`)
        .then((res) => { 
                commit(FETCH_MEMBER, res.data ) 
                
        })
    },
    fetchBoard ({commit}, boardNo) {
        return axios.get(`http://localhost:9999/jpaBoard/${boardNo}`)
        .then((res) => {
                commit(FETCH_BOARD, res.data)
        })
    } ,

    fetchCommentsList( { commit }, boardNo ){
                  //  console.log('action의 작동 그리고 boardNo =' + boardNo )
        return axios.get(`http://localhost:9999/jpaBoard/Commentslist/${boardNo}`)
        .then((res) => { /*console.log("Spring에서 넘어온 comments정보 =" +res.data )*/
                commit(FETCH_COMMENTS_LIST, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    },
    fetchNoticeList({ commit }) {
        return axios.get('http://localhost:9999/jpaNotice/noticelist')
        .then((res) => {
            commit(FETCH_NOTICE_LIST, res.data)
        })
    },
    fetchNotice({ commit }, boardNo) {
        return axios.get(`http://localhost:9999/jpaNotice/${boardNo}`)
        .then((res) => {
            commit( FETCH_NOTICE, res.data)
        }).catch(err => {
                alert(err.response.data.message)
        })
    },
    fetchNoticeCommentList({ commit }, boardNo ) {
        return axios.get(`http://localhost:9999/jpaNotice/NoticeCommentList/${boardNo}`)
        .then((res) => {
            commit(FETCH_NOTICE_COMMENT_LIST, res.data)
        })
        .catch(err => {
            alert(err.response.data.message)
        })
        //사슴벌레
    },
    fetchStagbeetleList({ commit } ) {
        return axios.get('http://localhost:9999/stagbeetle/stagbeetleList')
        .then((res) => {
            commit(FECTH_STAGBEETLES_LIST, res.data)
        })
    },
    fetchStagbeetle( { commit },boardNo ) {
        return axios.get(`http://localhost:9999/stagbeetle/stagbeetle/${boardNo}`)
        .then((res) => {
            commit(FECTH_STAGBEETLES, res.data)
        })
        .catch(err => { err.response.data.message})
    },
    fetchStagbeetleCommentList( {commit}, boardNo) {

        return axios.get(`http://localhost:9999/stagbeetle/stagbeetleComment/${boardNo}`)
        .then((res) => {
            commit(FECTH_STAGBEETLES_COMMENT_LIST, res.data) 
        }).catch(err => {alert(err.response.data.message)})

    },
    //장수풍뎅이
    fetchBeetleList({ commit }) {

        return axios.get('http://localhost:9999/beetle/beetlelist')
        .then((res) => {
            commit(FETCH_BEETLE_LIST, res.data)
        })
        .catch(err =>{
            alert(err.response.data.message)
        })
    },
    fetchBeetle({ commit }, boardNo ) {
        return axios.get(`http://localhost:9999/beetle/beetle/${boardNo}`)
        .then((res) => {
            commit(FETCH_BEETLE, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    },
    fetchBeetleCommentList({ commit }, boardNo) {

        return axios.get(`http://localhost:9999/beetle/beetleCommentList/${boardNo}`)
        .then((res)=> {
            commit(FETCH_BEETLE_COMMENT_LIST, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    },
    fetchDragonflyList({ commit }) {
        
        return axios.get('http://localhost:9999/dragonfly/dragonflyList')
        .then((res) => {
            commit(FETCH_DRAGONFLY_LIST,res.data) 
        }).catch(err=> {alert(err.response.data.message)})
    },
    fetchDragonfly({ commit }, boardNo) {
        return axios.get(`http://localhost:9999/dragonfly/dragonfly/${boardNo}`)
        .then( (res) => {
            commit(FETCH_DRAGONFLY, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    fetchDragonflyCommentList({ commit }, boardNo) {
        return axios.get(`http://localhost:9999/dragonfly/commentList/${boardNo}`)
        .then ((res) => {
            commit(FETCH_DRAGONFLY_COMMENT_LIST, res.data) 
        }).catch(err=> {alert(err.response.data.message)})
    },
    //하늘소
    fetchSkycowList({commit}) {

        return axios.get('http://localhost:9999/skycow/SkycowList')
        .then((res) => {
            commit(FETCH_SKYCOW_LIST, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    fethchSkycow({commit}, boardNo) {

        return axios.get(`http://localhost:9999/skycow/skycow/${boardNo}`)
        .then( (res) => {
            commit(FETCH_SKYCOW, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    fetchButterflyList({commit}) {
            return axios.get('http://localhost:9999/butterfly/butterflyList')
            .then((res) => { 
                commit(FETCH_BUTTERFLY_LIST, res.data)
            }).catch(err=>{alert(err.response.data.message)})
    },
    fetchButterfly({commit}, boardNo){

        return axios.get(`http://localhost:9999/butterfly/butterfly/${boardNo}`)
        .then((res) => {
            commit(FETCH_BUTTERFLY,res.data)
        }).catch(err=>{
            alert(err.response.data.message)
        })
    },
    //쇼핑몰
    fetchProductList({ commit} ) {
        return axios.get('http://localhost:9999/jpaProduct/getProductList')
        .then( (res) => {
            commit(FETCH_PRODUCT_LIST, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    fetchProduct({ commit}, boardNo) {
            console.log(boardNo)
        return axios.get(`http://localhost:9999/jpaProduct/getProduct/${boardNo}`)
        .then( (res)=> {
            commit(FETCH_PRODUCT, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
   fetchBasketList({commit}, memberNo){ 
        return axios.get(`http://localhost:9999/jpamemberManage/getBasketList/${memberNo}`)
        .then((res) =>{ 

            commit(FETCH_BASKET_LIST,res.data)
        }).catch(err=>{alert(err.response.data)})
    },
    //주문정보
    fetchOrderList({ commit }) {

        return axios.get('http://localhost:9999/jpaOrder/getOrderList')
        .then((res) =>{
            commit(FETCH_ORDER_LIST, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    //마이페이지
    //고객소리 
    fetchCustomerSoundList ({commit }) {

        return axios.get('http://localhost:9999/CustomerSound/getSoundList')
        .then( (res) => {
            commit(FETCH_CUSTOMER_SOUND_LIST,res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    fetchCustomerSound({ commit }, boardNo) {

        return axios.get(`http://localhost:9999/CustomerSound/getSound/${boardNo}`)
        .then((res) =>{
            commit(FETCH_CUSTOMER_SOUND, res.data)
        }).catch(err=>{err.response.data.message})
    },
    fetchUserOrderList({commit},User) {
            console.log("action:"+User)
        return axios.post('http://localhost:9999/jpaOrder/getorderlist',{userid:User})
        .then((res)=>{
            commit(FETCH_USER_ORDER_LIST,res.data)
        })
    }

    
  

}