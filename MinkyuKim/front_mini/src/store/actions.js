import {
    // 크롤링
    CRAWL_START,
    CRAWL_ADDRESS,    
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,
    FETCH_LOGIN,
    FETCH_SESSION,
    FETCH_MEMBER
    
    //FETCH_ID
    


   
} from './mutation-types'

import axios from 'axios'
import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // 크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:7777/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },
    async crawlAddress ({ commit }, address) {
        axios.get(`http://localhost:7777/` +`${address}`)
        .then(({ data }) => {
            commit(CRAWL_ADDRESS, data)

            if (window.location.pathname !== '/daumNewsCrawler') {
                router.push('/daumNewsCrawler')
            }
        })
    },
    // 상품
    fetchProductList ({ commit }) {
        return axios.get('http://localhost:7777/vueproduct/lists')
                .then((res) => {
                    commit(FETCH_PRODUCT_LIST, res.data)
                })
    },
    fetchProduct ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/vueproduct/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT, res.data)
                })
    },
  
    
    //로그인
    fetchLogin ({ commit }) {
        commit(FETCH_LOGIN)
    },
    fetchMember ({ commit }, userId) {
        return axios.get(`http://localhost:7777/member/${userId}`)
        //return axios.get(`http://localhost:7777/member/`, {params: { userId }})
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                    console.log('체크: ' + res.data.uesrId.toString())
                })
    },
    
    // Session
    fetchSession ({ commit }) {
        commit(FETCH_SESSION)
    },
    /*
    addCart1 ({state, commit}, product) {
        return axios.get(`http://localhost:7777/cart/${cartNo}`)
        .then((res) => {
            commit(FETCH_CART, res.data)
        })
},
addCart2 ({state, commit}, product) {
    const cart = ''
    const carts = []
    if (session != null ) {
        cart = product 파람 productNo
        carts = 

    } else {
        alert('로그인을 해주세요')
    }
    .then((res) => {
        commit(FETCH_CART, res.data)
    })
},
    

    addCart3 ({state, commit}, product) {
        //제품의 남은 수량이 있을 경우
        if ( product.inventory > 0 ) { 
            const productItem = state.products.find(item => item.id === product.id);
            const cartItem = state.cart.find(item => item.productId === product.id);
            if (!cartItem) {
                commit('pushProductToCart', productItem); //추가할 제품이 장바구니의 제품과 일치하지 않을 경우, 장바구니에 새로 추가
            } else {
                if( product.inventory > 0 ) {
                    commit('incrementItemQuantity', cartItem); //일치할 경우, 장바구니의 제품 수량을 증가}
                }
            }
            commit('decrementProductInventory', productItem); //남은 수량 -1
            commit('incrementItemTotalPrice', cartItem); //가격변경
        }
        //제품의 남은 수량이 없는 경우
        else {
            alert("남은수량 없음");
        }
    }*/
    
}