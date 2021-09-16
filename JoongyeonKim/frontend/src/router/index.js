import Vue from 'vue'
import VueRouter from 'vue-router'


import Test from '../views/Test.vue'
//회원관리
import MemberRegisterPage from '@/views/member/MemberRegisterPage.vue'
import MemberLoginPage from '@/views/member/MemberLoginPage.vue'
import MemberListPage from '@/views/member/MemberListPage.vue'

//펀딩페이지
import FundingRegisterPage from '../views/funding/FundingRegisterPage.vue'
import FundingListPage from '../views/funding/FundingListPage.vue'
import FundingReadPage from '../views/funding/FundingReadPage.vue'
import FundingModifyPage from '../views/funding/FundingModifyPage.vue'
/*
import FundingDetail from '../views/funding/FundingDetail.vue'
import FundingUpdate from '../views/funding/FundingUpdate.vue'
import SalesList from '../views/funding/SalesList.vue'
import ImageInsert from '../views/funding/ImageInsert.vue'
*/

//메인페이지
import MainPage from '../views/board/MainPage.vue'

// 게시판
import BoardRegisterPage from '../views/board/BoardRegisterPage.vue'
import BoardListPage from '../views/board/BoardListPage.vue'

// 크롤링
import DaumBlogCrawlerPage from '../views/DaumBlogCrawlerPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/register',
    name: 'MemberRegisterPage',
    component: MemberRegisterPage
  },
  {
    path: '/login',
    name: 'MemberLoginPage',
    component: MemberLoginPage
  },
  {
    path: '/funding/login',
    name: 'MemberLoginPage',
    component: MemberLoginPage
  },
  {
    path: '/member',
    name: 'MemberListPage',
    component: MemberListPage
  },
  {
    path: '/basic',
    name: 'FundingRegisterPage',
    component: FundingRegisterPage
  },
  {
    path: '/boardRegister',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/daumBlogCrawler',
    name: 'DaumBlogCrawlerPage',
    component: DaumBlogCrawlerPage
  },
  {
    path: '/boardList',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/funding',
    name: 'FundingListPage',
    components: {
      default: FundingListPage
    }
  },
  {
    path: '/funding/:fundingNo',
    name: 'FundingReadPage',
    components: {
      default: FundingReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/product/:fundingNo/edit',
    name: 'FundingModifyPage',
    components: {
      default: FundingModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
