import {   
    // 크롤링
    CRAWL_START,
    CRAWL_ADDRESS,
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,
    FETCH_LOGIN,
    FETCH_SESSION,
    FETCH_MEMBER,
    
    
    
    

} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    [CRAWL_START] (state, payload) {
        state.lists = payload
    },
    [CRAWL_ADDRESS] (state, address) {
        state.address = address
    },    
    // 상품
    [FETCH_PRODUCT_LIST] (state, products) {
        state.products = products
    },
    [FETCH_PRODUCT] (state, product) {
        state.product = product
    },
    
    [FETCH_LOGIN] (state, isLogin) {
        state.isLogin = isLogin
    },
    
    [FETCH_SESSION] (state) {
        state.session = this.$cookies.get("userSession")
    },    
    
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },
    //장바구니에 제품을 추가
    pushProductToCart(state, product) { 
        state.cart.push({            
            id: product.productNo,
            name: product.product_name,
            price: product.price,            
            itemtotalprice: product.price,
        });
    },
    
    
} 

