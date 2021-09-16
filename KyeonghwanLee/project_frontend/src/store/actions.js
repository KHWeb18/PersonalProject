import {
  // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,

  //크롤링
  CRAWL_START,
  //세션
  FETCH_SESSION,
} from "./mutation-types";

import axios from "axios";
import router from "../router";

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
  // 게시판
  fetchBoardList({ commit }) {
    return axios.get("http://localhost:7777/vueboard/lists").then(res => {
      commit(FETCH_BOARD_LIST, res.data);
    });
  },
  fetchBoard({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/vueboard/${boardNo}`).then(res => {
      commit(FETCH_BOARD, res.data);
    });
  },
  // 크롤링
  async crawlFind({ commit }, category) {
    axios.get("http://localhost:7777/" + `${category}`).then(({ data }) => {
      commit(CRAWL_START, data);

      if (window.location.pathname !== "/daumNewsCrawler") {
        router.push("/daumNewsCrawler");
      }
    });
  },
  // 장바구니 추가
  addToCart({ commit }, payload) {
    commit("addToCart", payload), commit("decrementProductInventory", payload);
  },
  // 장바구니 삭제
  removeFromCart({ commit }, payload) {
    commit("removeFromCart", payload);
    commit("incrementProductInventory", payload);
  },
  // Session
  fetchSession({ commit }) {
    commit(FETCH_SESSION);
  },
};

//commit 하면 mutation이 작동한다.
