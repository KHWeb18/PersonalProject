import {
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_COMMENT_LIST,
    FETCH_COMMENT,
    FETCH_FOOD_LIST,
    FETCH_FOOD,
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    CRAWL_START

} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_COMMENT_LIST] (state, comments) {
        state.comments = comments;
    },
    [FETCH_COMMENT] (state, comment) {
        state.comment = comment
    },
    [FETCH_FOOD_LIST] (state, foods) {
        state.foods = foods;
    },
    [FETCH_FOOD] (state, food) {
        state.food = food
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members;
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    // 크롤링
    [CRAWL_START] (state, payload) {
        state.lists = payload
    }
}