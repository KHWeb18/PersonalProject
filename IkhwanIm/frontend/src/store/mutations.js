import {
    FETCH_BOARD,
    FETCH_BOARD_LIST, FETCH_COMMENT, FETCH_COMMENT_LIST, FETCH_MEMBER, FETCH_REPLY, FETCH_REPLY_LIST,
    GET_RANDOM_BIKE, GET_RANDOM_CAR, GET_RANDOM_MOTORCYCLE, GET_RANDOM_WALK,
    SELECT_BIKE, SELECT_CAR, SELECT_MOTORCYCLE, SELECT_WALK
} from "./mutation-types";

export default {
    [GET_RANDOM_WALK] (state,payload) {
        state.selectedWalk = payload
    },
    [SELECT_WALK] (state,payload) {
        state.selectedWalk = payload
    },
    // Bike
    [GET_RANDOM_BIKE] (state,payload) {
        state.selectedBike = payload
    },
    [SELECT_BIKE] (state,payload) {
        state.selectedBike = payload
    },
    // Motorcycle
    [GET_RANDOM_MOTORCYCLE] (state,payload) {
        state.selectedMotorcycle = payload
    },
    [SELECT_MOTORCYCLE] (state,payload) {
        state.selectedMotorcycle = payload
    },
    // Car
    [GET_RANDOM_CAR] (state,payload) {
        state.selectedCar = payload
    },
    [SELECT_CAR] (state,payload) {
        state.selectedCar = payload
    },
    // Board
    [FETCH_BOARD_LIST] (state,boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    //comment
    [FETCH_COMMENT_LIST] (state,comments) {
        state.comments = comments;
    },
    [FETCH_COMMENT] (state,comment) {
        state.comment = comment;
    },
    [FETCH_REPLY_LIST] (state,replies) {
        state.replies = replies;
    },
    [FETCH_REPLY] (state,reply) {
        state.reply = reply
    },
    [FETCH_MEMBER] (state,member) {
        state.member = member;
    }
}
