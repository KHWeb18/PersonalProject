import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

import MemberRegisterPage from '@/views/MemberRegisterPage.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'

import GongziListPage from '@/views/GongziListPage.vue'
import GongziRegisterPage from '@/views/GongziRegisterPage.vue'
import GongziReadPage from '@/views/GongziReadPage.vue'
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'
//import GongziModifyPage from '@/views/GongziModifyPage.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  //게시글
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
    path: '/member/create',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/logintest',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },

  //공지사항
  {
    path: '/gongzi',
    name: 'GongziListPage',
    components: {
      default: GongziListPage
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
    path: '/gongzi/create',
    name: 'GongziRegisterPage',
    components: {
      default: GongziRegisterPage
    }
  },
  {
    path: '/gongzi/:gonziNo',
    name: 'GongziReadPage',
    components: {
      default: GongziReadPage
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
