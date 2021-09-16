import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'
import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage.vue'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import MemberLoginPage from '@/views/MemberLoginPage.vue'

import MemberModifyPage from '@/views/MemberModifyPage.vue'

// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

// 상품 게시판
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'

import AddedProductListPage from '@/views/AddedProductListPage.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
  {
    path: '/memberRegister',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/memberRegisterTest',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
    }
  },
  {
    path: '/memberLoginTest',
    name: 'MemberLoginPage',
    components: {
      default: MemberLoginPage
    }
  },
    //크롤링
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  // 상품목록 페이지
  {
    path: '/product',
    name: 'ProductListPage',
    components: {
      default: ProductListPage
    }
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components: {
      default: ProductRegisterPage
    }
  },
  { //가변처리
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }   
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함(true로 설정하면 데이터를 props로도 받음.)
      default: true
    }
  },
  {
    path: '/cart',
    name: 'AddedProductListPage',
    components: {
      default: AddedProductListPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함(true로 설정하면 데이터를 props로도 받음.)
      default: true
    }
  },
  {
    path: '/memberModify',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함(true로 설정하면 데이터를 props로도 받음.)
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