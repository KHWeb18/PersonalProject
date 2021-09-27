import{
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    CRAWL_START
} from './mutation-types'


export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [CRAWL_START] (state, payload) {
        state.lists = payload
    }    
}