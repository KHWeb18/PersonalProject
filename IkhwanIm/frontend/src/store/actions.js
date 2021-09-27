import {
    FETCH_BOARD,
    FETCH_BOARD_LIST, FETCH_COMMENT, FETCH_COMMENT_LIST, FETCH_MEMBER, FETCH_REPLY, FETCH_REPLY_LIST,
    GET_RANDOM_BIKE, GET_RANDOM_CAR, GET_RANDOM_MOTORCYCLE, GET_RANDOM_WALK,
    SELECT_BIKE, SELECT_CAR, SELECT_MOTORCYCLE, SELECT_WALK,
} from "./mutation-types";
import axios from "axios";



export default {
    // walk
    getRandomWalk({ commit, state }) {
        const data = state.walk
        const selected_city = Math.floor(Math.random() * data.length)
        const currentCity = data[selected_city]
         {
            commit(GET_RANDOM_WALK, currentCity)
        }
    },
    selectWalk({ commit }, selectedVideo) {
        commit(SELECT_WALK, selectedVideo)
    },
    // bike
    getRandomBike({ commit, state }) {
        const data = state.bike
        const selected_city = Math.floor(Math.random() * data.length)
        const currentCity = data[selected_city]
        {
            commit(GET_RANDOM_BIKE, currentCity)
        }
    },
    selectBike({ commit }, selectedVideo) {
        commit(SELECT_BIKE, selectedVideo)
    },
    // motorcycle
    getRandomMotorcycle({ commit, state }) {
        const data = state.motorcycle
        const selected_city = Math.floor(Math.random() * data.length)
        const currentCity = data[selected_city]
        {
            commit(GET_RANDOM_MOTORCYCLE, currentCity)
        }
    },
    selectMotorcycle({ commit }, selectedVideo) {
        commit(SELECT_MOTORCYCLE, selectedVideo)
    },
    // car
    getRandomCar({ commit, state }) {
        const data = state.car
        const selected_city = Math.floor(Math.random() * data.length)
        const currentCity = data[selected_city]
        {
            commit(GET_RANDOM_CAR, currentCity)
        }
    },
    selectCar({ commit }, selectedVideo) {
        commit(SELECT_CAR, selectedVideo)
    },
    // Board
    fetchBoardList ({ commit }) {
        return axios.get(`http://localhost:7777/board/lists`)
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
    fetchCommentList ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/comment/lists/${boardNo}`)
            .then((res) => {
                commit(FETCH_COMMENT_LIST, res.data)
            })
    },
    fetchComment ({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/comment/${commentNo}`)
            .then((res) => {
                commit(FETCH_COMMENT, res.data)
            })
    },
    fetchReplies({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/reply/lists/${commentNo}`)
            .then((res) => {
            commit(FETCH_REPLY_LIST, res.data)
        })
    },
    fetchReply({ commit }, replyNo) {
        return axios.get(`http://localhost:7777/reply/${replyNo}`)
            .then((res) => {
                commit(FETCH_REPLY, res.data)
            })
    },
    fetchMember ({ commit }, memberId) {
        return axios.get(`http://localhost:7777/member/read/${memberId}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
            })
    },
}
