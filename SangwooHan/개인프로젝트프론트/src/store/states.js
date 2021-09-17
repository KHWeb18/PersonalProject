export default {
    //==========Rules=========//
    emailRules: [
        v => !! v || '이메일을 작성해주세요.',
        v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요',
        

    ],
    nameRules: [
        v => !!v || '이름을 작성해주세요',
        v => !/[~!@#$%^&*()_+{}]/.test(v) || '이름에는 특수문자를 넣을수없습니다.',
        v => !(v && v.length >= 20) || '이름은 20자를 넘길수없습니다.'

    ],
    passwordRules: [
        v => !! v || '비밀번호를 작성해주세요.',
        v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요'
    ],
    barithdayRules: [
         v => !! 1<= v <=6 || '6자리 이하입니다 6자리이상으로해주세요'   
    ],
    //다음뉴스
    lists:[],
    // 매니지먼트 회원리스트
    members: [],
    member: null,
    list: [],
    loginUser: null,
    User: null,
    //게시판
    boards: [],
    board: null,
    //댓글들
    commentsList: [],
    //공지글들
    notices: [],
    notice: null,
    NoticeCommentList: [],
    //곤충박물관
    StagbeetleList: [],
    Stagbeetle: null,
    StagbeetleCommentList: [],
    BeetleList: [],
    Beetle: null,
    BeetleCommentList: [],
    DragonflyList: [],
    Dragonfly: null,
    DragonflyComments: [],
    SkycowList: [],
    Skycow: null,
    //나방/나비
    ButterflyList:[],
    Butterfly: null,
    //세션
    session: [],
    isLogin: false,
    loginMemberNo: null,
    //쇼핑몰
    ProductList: [],
    Product: null,
    BasketList: [],
    //주문정보
    OrderList: [],
    //마이페이지.고객의소리
    CustomerSoundList:[],
    CustomerSound: null,
    //
    UserOrderList:[],
    PageArray: [],

    

    
   
  
    
}

