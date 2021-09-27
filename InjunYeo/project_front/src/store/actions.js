import{
    //MYBOARD
    FETCH_MY_BOARD_LIST,
    FETCH_MY_BOARD,
    FETCH_FEED_BOARD_LIST

} from './mutation-types'

import axios from 'axios'


export default{

    //MyBoard
    fetchMyBoardList({commit},{email,category}){
        return axios.post('http://localhost:9999/user-my/my-page-board-list',{email,category})
                .then((res)=>{
                    commit(FETCH_MY_BOARD_LIST,res.data)
                })
    },
    //email 실어서보내기
    fetchMyBoard({commit},boardNo){
        return axios.get(`http://localhost:9999/user-my/my-page-board-detail/${boardNo}`)
                .then((res)=>{
                    commit(FETCH_MY_BOARD,res.data)
                })
    },
    fetchFeedBoardList({commit},{email,category}){
        return axios.post('http://localhost:9999/sub/feed-board-list',{email,category})
                .then((res)=>{
                    commit(FETCH_FEED_BOARD_LIST,res.data)
                })
    },



}
