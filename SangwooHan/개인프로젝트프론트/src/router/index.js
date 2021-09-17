import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import SignupPage from '../views/SignupPage.vue'
import MemberList from '../views/Manage/MemberList.vue'
//로그인
//import LoginPage from '../views/login/LoginPage.vue'

//  커뮤니티 페이지
import CommunityRegisterPage from '../views/Community/CommunityRegisterPage.vue'

//params 활용 
import Test from '../views/Test.vue'
// 멤버 리드 페이지입니다.

//다음뉴스
import DaumNewsCrawlerPage  from '../views/DaumNews/DaumNewsCrawlerPage.vue'

//곤충박물관
import InsectMuseumPage from '../views/InsectMuseum/InsectMuseumPage.vue'
//커뮤니티
import CommunityListPage from '../views/Community/CommunityListPage'
import CommunityReadPage from '../views/Community/CommunityReadPage.vue'
import CommunityModifyPage from '../views/Community/CommunityModifyPage.vue'

//멤버리스트읽기페이지
import MemberListReadPage from '../views/Manage/MemberListReadPage.vue'
//멤버리스트 수정하기
import MemberModifyPage from '../views/Manage/MemberModifyPage.vue'

//공지판
import NoticeRegisterPage from '../views/Notice/NoticeRegisterPage.vue'
import NoticeListPage from '../views/Notice/NoticeListPage.vue'
import NoticeReadPage from '../views/Notice/NoticeReadPage.vue'

//곤충박물관
//사슴벌레
import InsectMuseumStagbeetle from '../views/InsectMuseum/Stagbeetle/InsectMuseumStagbeetle.vue'
import StagbeetleRegister from '../views/InsectMuseum/Stagbeetle/StagbeetleRegister'
import StagbeetleReadPage from '../views/InsectMuseum/Stagbeetle/StagbeetleReadPage'
import StagbeetleModifyPage from '../components/InsectMuseum/Stagbeelte/StagbeetleModifyPage'
//장수풍뎅이
import InsectMuseumbeetle from '../views/InsectMuseum/Beetle/InsectMuseumBeetle.vue'
import BeetleRegister from '../views/InsectMuseum/Beetle/BeetleRegister'
import BeetleReadPage from '../views/InsectMuseum/Beetle/BeetleReadPage'
import BeetleModifyPage from '../components/InsectMuseum/Beetle/BeetleModifyPage'
//잠자리
import InsectMuseumDragonfly from '../views/InsectMuseum/Dragonfly/InsectMuseumDragonfly'
import DragonflyRegister from '../views/InsectMuseum/Dragonfly/DragonflyRegister'
import DragonflyReadPage from '../views/InsectMuseum/Dragonfly/DragonflyReadPage'
import DragonflyModifyPage from '../components/InsectMuseum/Dragonfly/DragonflyModifyPage'
//하늘소
import InsectMuseumSkycow from '../views/InsectMuseum/Skycow/InsectMuseumSkycow'
import SkycowRegister from '../views/InsectMuseum/Skycow/SkycowRegister'
import SkycowReadPage from '../views/InsectMuseum/Skycow/SkycowReadPage'
import SkycowModifyPage from '../components/InsectMuseum/Skycow/SkycowModifyPage'

//나비/나방
import ButterflyRegister from '../views/InsectMuseum/Butterfly/ButterflyRegister'
import InsectMuseumButterfly from '../views/InsectMuseum/Butterfly/InsectMuseumButterfly'
import ButterflyReadPage from '../views/InsectMuseum/Butterfly/ButterflyReadPage'
import ButterflyModifyPage from '../components/InsectMuseum/Butterfly/ButterflyModifyPage'
//페이지 리스팅
//쇼핑몰
import ProductRegister from '../views/ShoppingMall/ProductRegister'
import ShoppingMallpage from '../views/ShoppingMall/ShoppingMallpage'
import ProductReadPage from '../views/ShoppingMall/ProductReadPage'
import OrderListPage from '../views/ShoppingMall/OrderListPage'
//쇼핑몰 메뉴에따른 페이지
import InsectMallEggtree from '../views/ShoppingMall/ShoppingMenu/InsectMallEggtree'
import InsectMallInsect from '../views/ShoppingMall/ShoppingMenu/InsectMallInsect'
import InsectMallJelly from '../views/ShoppingMall/ShoppingMenu/InsectMallJelly'
import InsectMallMushroom from'../views/ShoppingMall/ShoppingMenu/InsectMallMushroom'
import InsectMallSawdust from '../views/ShoppingMall/ShoppingMenu/InsectMallSawdust'
import InsectMallSide from '../views/ShoppingMall/ShoppingMenu/InsectMallSide'
//파일 업로드
import Fileupload from '../views/Fileupload'
//마이페이지
import MyPage from '../views/MyPage/MyPage'
import MyInformationDetail from '../views/MyPage/MyInformationDetail'
import MyProductStatus from '../views/MyPage/MyProductStatus'
import BasketReadPage from '../views/MyPage/BasketReadPage'
import PersonalQuestionRegister from '../views/MyPage/PersonalQuestionRegister'
import CustomerSoundPage from '../views/MyPage/CustomerSoundPage'
//마이페이지.고객의소리
import CustomerSoundReadPage from '../views/MyPage/CustomerSoundReadPage'
//비밀번호찾기
import FindByPasswordPage from '../views/FindByPassword/FindByPasswordPage'
// 아디찾기
import FindByIdPage from '../views/FindById/FindByIdPage'
// 페이지네이션
import Pagenation from '../views/Pagenation'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/aboutpage',
    name: 'About',
    component: About
  },
  {
    path: '/signuppage',
    name: 'SignupPage',
    component: SignupPage
  },
  {
    path: '/memberlist',
    name: 'MemberList',
    component: MemberList
  },
  

  {
    path: '/communityregisterpage',
    name: 'CommunityRegisterPage',
    component: CommunityRegisterPage
  },
  {
    path: '/test/:UserId',
    name: 'Test',
    component: Test
  },
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/insectmuseumpage',
    name: 'InsectMuseumPage',
    components: {
      default: InsectMuseumPage
    }
  },
  {
    path: '/communityListpage',
    name: 'CommunityListPage',
    components: {
      default: CommunityListPage
    }
  },
  {
    path: '/communityReadPage:boardNo',
    name: 'CommunityReadPage',
    components: {
      default: CommunityReadPage
    },
    props: {
      default: true
    }
  },
  
  {
    path: '/memberListRead:memberNo',
    name: 'MemberListReadPage',
    components: {
      default: MemberListReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/membermodifypage',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/communitymodifyPage/',
    name: 'CommunityModifyPage',
    components: {
      default: CommunityModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeRegisterPage',
    name: 'NoticeRegisterPage',
    components: {
      default: NoticeRegisterPage
    }
  },
  {
    path: '/noticeListPage',
    name: 'NoticeListPage',
    components: {
      default: NoticeListPage
    }
  },
  {
    path: '/noticeReadPage/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMuseumStagbeetle',
    name: 'InsectMuseumStagbeetle',
    components: {
      default: InsectMuseumStagbeetle
    }
  },
  {
    path: '/insectMuseumbeetle',
    name: 'InsectMuseumbeetle',
    components: {
      default: InsectMuseumbeetle
    }
  },
  {
    path: '/insectMuseumDragonfly',
    name: 'InsectMuseumDragonfly',
    components: {
      default: InsectMuseumDragonfly
    }
  },
  {
    path: '/dragonflyRegister',
    name: 'DragonflyRegister',
    components: {
      default: DragonflyRegister
    }
  },
  {
    path: '/beetleRegister',
    name: 'BeetleRegister',
    components: {
      default: BeetleRegister
    }
  },
  {
    path: '/stagbeetleRegister/',
    name: 'StagbeetleRegister',
    components: {
      default: StagbeetleRegister
    },
  },
  {
    path: '/stagbeetleReadPage/:boardNo/',
    name: 'StagbeetleReadPage',
    components: {
      default: StagbeetleReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/beetleReadPage/:boardNo/',
    name: 'BeetleReadPage',
    components: {
      default: BeetleReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/dragonflyReadPage/:boardNo/',
    name: 'DragonflyReadPage',
    components: {
      default: DragonflyReadPage
    },
    props: {
      default: true
    }
  },
  //하늘소----------------------------------------
  {
    path: '/insectMuseumSkycow',
    name: 'InsectMuseumSkycow',
    components: {
      default: InsectMuseumSkycow
    }
  },
  {
    path: '/skycowRegister',
    name: 'SkycowRegister',
    components: {
      default: SkycowRegister
    }
  },
  {
    path: '/skycowReadPage/:boardNo/',
    name: 'SkycowReadPage',
    components: {
      default: SkycowReadPage
    },
    props: {
      default: true
    }
  },
  //나비나방=====================================
  {
    path: '/butterflyRegister',
    name: 'ButterflyRegister',
    components: {
      default: ButterflyRegister
    }
  },
  {
    path: '/insectMuseumButterfly',
    name: 'InsectMuseumButterfly',
    components: {
      default: InsectMuseumButterfly
    }
  },
  {
    path: '/butterflyReadPage/:boardNo/',
    name: 'ButterflyReadPage',
    components: {
      default: ButterflyReadPage
    },
    props: {
      default: true
    }
  },
  //쇼핑몰
  {
    path: '/productRegister',
    name: 'ProductRegister',
    components: {
      default: ProductRegister
    },
  },
  {
    path: '/shoppingMallpage',
    name: 'ShoppingMallpage',
    components: {
      default: ShoppingMallpage
    },
  },
  {
    path: '/productReadPage/:boardNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/orderListPage',
    name: 'OrderListPage',
    components: {
      default: OrderListPage
    },
  },
  //쇼핑몰 매뉴에따른 페이지들
  {
    path: '/insectMallEggtree/',
    name: 'InsectMallEggtree',
    components: {
      default: InsectMallEggtree
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMallInsect/',
    name: 'InsectMallInsect',
    components: {
      default: InsectMallInsect
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMallJelly/',
    name: 'InsectMallJelly',
    components: {
      default: InsectMallJelly
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMallSawdust/',
    name: 'InsectMallSawdust',
    components: {
      default: InsectMallSawdust
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMallMushroom/',
    name: 'InsectMallMushroom',
    components: {
      default: InsectMallMushroom
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMallSide/',
    name: 'InsectMallSide',
    components: {
      default: InsectMallSide
    },
    props: {
      default: true
    }
  },
  //파일업로드
  {
    path: '/fileupload',
    name: 'Fileupload',
    components: {
      default: Fileupload
    },
  },
  //마이페이지
  {
    path: '/myPage',
    name: 'MyPage',
    components: {
      default: MyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/myInformationDetail',
    name: 'MyInformationDetail',
    components: {
      default: MyInformationDetail
    },
  },
  {
    path: '/myProductStatus/:User',
    name: 'MyProductStatus',
    components: {
      default: MyProductStatus
    },
    props: {
      default: true
    }
  },
  {
    path: '/basketReadPage/:memberNo',
    name: 'BasketReadPage',
    components: {
      default: BasketReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/personalQuestionRegister',
    name: 'PersonalQuestionRegister',
    components: {
      default: PersonalQuestionRegister
    },
  },
  {
    path: '/customerSoundPage',
    name: 'CustomerSoundPage',
    components: {
      default: CustomerSoundPage
    },
  },
  {
    path: '/customerSoundReadPage/:boardNo',
    name: 'CustomerSoundReadPage',
    components: {
      default: CustomerSoundReadPage
    },
    props: {
      default: true
    }
  },

  {
    path: '/findByPasswordPage',
    name: 'FindByPasswordPage',
    components: {
      default: FindByPasswordPage
    },
  },
  {
    path: '/pagenation',
    name: 'Pagenation',
    components: {
      default: Pagenation
    },
  },
  //아디찾기 StagbeetleModifyPage SkycowModifyPage DragonflyModifyPage  ButterflyModifyPage BeetleModifyPage
  {
    path: '/findByIdPage',
    name: 'FindByIdPage',
    components: {
      default: FindByIdPage
    },
  },
  {
    path: '/stagbeetleModifyPage',
    name: 'StagbeetleModifyPage',
    components: {
      default: StagbeetleModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/skycowModifyPage',
    name: 'SkycowModifyPage',
    components: {
      default: SkycowModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/dragonflyModifyPage',
    name: 'DragonflyModifyPage',
    components: {
      default: DragonflyModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/butterflyModifyPage',
    name: 'ButterflyModifyPage',
    components: {
      default: ButterflyModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/beetleModifyPage',
    name: 'BeetleModifyPage',
    components: {
      default: BeetleModifyPage
    },
    props: {
      default: true
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
