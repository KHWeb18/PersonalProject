import{

    //myPageBoard
    FETCH_MY_BOARD_LIST,
    FETCH_MY_BOARD,
    FETCH_FEED_BOARD_LIST,

    
} from './mutation-types'


export default{

    //myPageBoard
    [FETCH_MY_BOARD_LIST](state,payload){
        state.myBoardList = payload
    },
    [FETCH_MY_BOARD](state,myBoard){
        state.myBoard = myBoard
    },
    [FETCH_FEED_BOARD_LIST](state,payload){
        state.myBoardList = payload
    },


}