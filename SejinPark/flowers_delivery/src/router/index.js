import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// Image Gallery
import BouquetPage from '@/views/BouquetPage.vue'
import BasketPage from '@/views/BasketPage.vue'
// JPA Test Page
 import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'
 
// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'


import SessionLoginPage from '@/views/SessionLoginPage.vue'
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'

import Product1 from '@/views/Product1.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

 
  
  {
    path: '/bouquetPage',
    name: 'BouquetPage',
    components: {
      default: BouquetPage
    }
  },
  {
    path: '/basketPage',
    name: 'BasketPage',
    components: {
      default: BasketPage
    }
  },
   
  {
    path: '/memberRegister',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
    }
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
  
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/product1',
    name: 'Product1',
    components: {
      default: Product1
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
    path: '/accountRegister',
    name: 'AccountRegisterPage',
    components: {
      default: AccountRegisterPage
    }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router