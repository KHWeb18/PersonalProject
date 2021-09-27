import {
  // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,

  //크롤링
  CRAWL_START,
  //카트
  addToCart,
  incrementProductInventory,
  decrementProductInventory,
  removeFromCart,
  //세션
  FETCH_SESSION,
} from "./mutation-types";

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
  // 게시판
  [FETCH_BOARD_LIST](state, boards) {
    state.boards = boards;
  },
  [FETCH_BOARD](state, board) {
    state.board = board;
  },

  // 크롤링
  [CRAWL_START](state, payload) {
    state.lists = payload;
  },
  // 장바구니
  [addToCart](state, payload) {
    state.cart.push(Number(payload));
  },
  [removeFromCart](state, payload) {
    let indexToDelete = state.cart.indexOf(Number(payload));
    state.cart.splice(indexToDelete, 1);
  },
  [decrementProductInventory](state, payload) {
    let product = state.products.find(
      product => product.id === Number(payload)
    );
    product.quantity--;
  },
  [incrementProductInventory](state, payload) {
    let product = state.products.find(
      product => product.id === Number(payload)
    );
    product.quantity++;
  },
  //세션
  [FETCH_SESSION](state) {
    state.session = this.$cookies.get();
  },
};
