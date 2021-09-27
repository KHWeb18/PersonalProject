import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 회원가입 페이지
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'
import SessionLoginPage from '@/views/SessionLoginPage.vue'

// 홈페이지 소개
import IntroducePage from '@/views/IntroducePage.vue'
import NoticeListPage from '@/views/NoticeListPage.vue'
import NoticeRegisterPage from '@/views/NoticeRegisterPage.vue'
import NoticeReadPage from '@/views/NoticeReadPage.vue'
import NoticeModifyPage from '@/views/NoticeModifyPage.vue'
// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'
import QuestionListPage from '@/views/QuestionListPage.vue'
import QuestionRegisterPage from '@/views/QuestionRegisterPage.vue'
import QuestionReadPage from '@/views/QuestionReadPage.vue'
import QuestionModifyPage from '@/views/QuestionModifyPage.vue'

// photo 섹션
import NaturePhotoPage from '@/views/photo/NaturePhotoPage.vue'
import FoodPhotoPage from '@/views/photo/FoodPhotoPage.vue'
import PersonPhotoPage from '@/views/photo/PersonPhotoPage.vue'

// map
import MapPage from '@/views/MapPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    components: { 
      default: Home
    },
    props: {
      default: true
    }
  },
  {
    path: '/accountRegister',
    name: 'AccountRegisterPage',
    components: {
      default: AccountRegisterPage
    }
  },
  {
    path: '/sessionLogin',
    name: 'SessionLoginPage',
    components: {
      default: SessionLoginPage
    }
  },
  {
    path: '/intro',
    name: 'IntroducePage',
    components: {
      default: IntroducePage
    }
  },
  {
    path: '/notice',
    name: 'NoticeListPage',
    components: {
      default: NoticeListPage
    }
  },
  {
    path: '/notice/create',
    name: 'NoticeRegisterPage',
    components: {
      default: NoticeRegisterPage
    }
  },
  {
    path: '/notice/:noticeNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/notice/:noticeNo/edit',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/nature',
    name: 'NaturePhotoPage',
    components: {
      default: NaturePhotoPage
    }
  },
  {
    path: '/food',
    name: 'FoodPhotoPage',
    components: {
      default: FoodPhotoPage
    }
  },
  {
    path: '/person',
    name: 'PersonPhotoPage',
    components: {
      default: PersonPhotoPage
    }
  },
  {
    path: '/question',
    name: 'QuestionListPage',
    components: {
      default: QuestionListPage
    }
  },
  {
    path: '/question/create',
    name: 'QuestionRegisterPage',
    components: {
      default: QuestionRegisterPage
    }
  },
  {
    path: '/question/:questionNo',
    name: 'QuestionReadPage',
    components: {
      default: QuestionReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/question/:questionNo/edit',
    name: 'QuestionModifyPage',
    components: {
      default: QuestionModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/map',
    name: 'MapPage',
    components: {
      default: MapPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
