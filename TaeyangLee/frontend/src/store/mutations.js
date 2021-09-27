import {
 
    // 게시글
    FETCH_BOARD_LIST,
    FETCH_BOARD,
   
    //공지사항
    FETCH_GONGZI,
    FETCH_GONGZI_LIST,
    CRAWL_START
    
    
 
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    
    // 게시판
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
   
   
  

    [FETCH_GONGZI_LIST] (state, gongzis) {
        state.gongzis = gongzis;
    },
    [FETCH_GONGZI] (state, gongzi) {
        state.gongzi = gongzi
    },
    [CRAWL_START] (state, payload) {
        state.lists = payload
    }
   
}