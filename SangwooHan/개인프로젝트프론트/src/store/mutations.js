import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    DAUM_NEWS,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_COMMENTS_LIST,
    FETCH_NOTICE_LIST,
    FETCH_NOTICE,
    FETCH_NOTICE_COMMENT_LIST,
    FECTH_STAGBEETLES_LIST,
    FECTH_STAGBEETLES,
    FECTH_STAGBEETLES_COMMENT_LIST,
    FETCH_BEETLE_LIST,
    FETCH_BEETLE,
    FETCH_BEETLE_COMMENT_LIST,
    FETCH_DRAGONFLY_LIST,
    FETCH_DRAGONFLY,
    FETCH_DRAGONFLY_COMMENT_LIST,
    //하늘소
    FETCH_SKYCOW_LIST,
    FETCH_SKYCOW,
    //나비/나방
    FETCH_BUTTERFLY_LIST,
    FETCH_BUTTERFLY,
    //쇼핑몰
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,
    FETCH_BASKET_LIST,
    //주문정보
    FETCH_ORDER_LIST,
    //마이페이지
    FETCH_CUSTOMER_SOUND_LIST,
    FETCH_CUSTOMER_SOUND,
    //
    FETCH_USER_ORDER_LIST
    

    
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members){
        state.members = members
    },
    [DAUM_NEWS] (state, payload) {
        state.lists = payload
    },
    [FETCH_BOARD_LIST] (state, boards){
        state.boards = boards
    },
    [FETCH_MEMBER] (state, member){
        state.member = member 
        console.log(member)
    },
    [FETCH_BOARD] (state, board ) {
        state.board = board
    },
    [FETCH_COMMENTS_LIST] (state, commentsList) {
        state.commentsList = commentsList
    },
    [FETCH_NOTICE_LIST] (state, notices) {
        state.notices = notices
    },
    [FETCH_NOTICE] (state, notice) {
        state.notice = notice
    },
    [FETCH_NOTICE_COMMENT_LIST] (state,NoticeCommentList) {
        state.NoticeCommentList = NoticeCommentList
    },
    [FECTH_STAGBEETLES_LIST] (state,StagbeetleList) {
        state.StagbeetleList = StagbeetleList
    },
    [FECTH_STAGBEETLES] (state,Stagbeetle) {
        state.Stagbeetle = Stagbeetle 
    },
    [FECTH_STAGBEETLES_COMMENT_LIST] (state, StagbeetleCommentList) {
        state.StagbeetleCommentList = StagbeetleCommentList 
    },
    [FETCH_BEETLE_LIST] (state, BeetleList) {
        state.BeetleList = BeetleList 
    },
    [FETCH_BEETLE] (state, Beetle) {
        state.Beetle = Beetle
    },
    [FETCH_BEETLE_COMMENT_LIST] (state,BeetleCommentList) {
        state.BeetleCommentList = BeetleCommentList
    },
    [FETCH_DRAGONFLY_LIST] (state, DragonflyList) {
        state.DragonflyList = DragonflyList
    },
    [FETCH_DRAGONFLY] (state, Dragonfly) {
        state.Dragonfly = Dragonfly
    },
    [FETCH_DRAGONFLY_COMMENT_LIST] (state, DragonflyComments){
        state.DragonflyComments =DragonflyComments 
    },
    [FETCH_SKYCOW_LIST] (state, SkycowList){
        state.SkycowList = SkycowList
    },
    [FETCH_SKYCOW] (state, Skycow){
            state.Skycow = Skycow 
    },
//나비/나방
    [FETCH_BUTTERFLY_LIST] (state, ButterflyList){
        state.ButterflyList = ButterflyList
    },
    [FETCH_BUTTERFLY] (state,Butterfly) {
        state.Butterfly = Butterfly
    },
//쇼핑몰
    [FETCH_PRODUCT_LIST] (state, ProductList) {
        state.ProductList = ProductList

    },
    [FETCH_PRODUCT] (state, Product) {
        state.Product = Product
    },
    [FETCH_BASKET_LIST] (state,BasketList) {
        state.BasketList = BasketList
    },
    //주문정보
    [FETCH_ORDER_LIST] (state, OrderList) {
        state.OrderList = OrderList
    },
    //고객의소리
    [FETCH_CUSTOMER_SOUND_LIST] (state, CustomerSoundList) {
        state.CustomerSoundList = CustomerSoundList 
    },
    [FETCH_CUSTOMER_SOUND] (state, CustomerSound) {
        state.CustomerSound = CustomerSound
    },
    [FETCH_USER_ORDER_LIST] (state,UserOrderList){
        state.UserOrderList = UserOrderList
    }
}

