import {
    //크롤링
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

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    [CRAWL_START] (state, payload) {
        state.lists = payload
    },
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_FUNDING_LIST] (state, fundings) {
        state.fundings = fundings;
    },
    [FETCH_FUNDING] (state, funding) {
        state.funding = funding
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members;
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
}