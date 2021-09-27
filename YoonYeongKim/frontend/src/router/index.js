import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import LoginPage from '@/views/LoginPage.vue'
import SignUpPage from '@/views/SignUpPage.vue'
import Home2 from '@/views/Home2.vue'
import AlbumDetail from '@/views/AlbumDetail.vue'
import AlbumFilter from '@/views/AlbumFilter.vue'
import NewsCrawl from '@/views/NewsCrawl.vue'

import AlbumListPage from '@/views/AlbumListPage.vue'
import AlbumRegisterPage from '@/views/AlbumRegisterPage.vue'
import AlbumReadPage from '@/views/AlbumReadPage.vue'
import AlbumModifyPage from '@/views/AlbumModifyPage.vue'

import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/today',
    name: 'Home2',
    component: Home2
  },
  {
    path: '/detail',
    name: 'AlbumDetail',
    component: AlbumDetail
  },
  {
    path: '/filter',
    name: 'AlbumFilter',
    component: AlbumFilter
  },
  {
    path: '/news',
    name: 'NewsCrawl',
    component: NewsCrawl
  },


  {
    path: '/album',
    name: 'AlbumListPage',
    components: {
      default: AlbumListPage
    }
  },
  {
    path: '/album/create',
    name: 'AlbumRegisterPage',
    components: {
      default: AlbumRegisterPage
    }
  },
  {
    path: '/album/:albumNo',
    name: 'AlbumReadPage',
    components: {
      default: AlbumReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/album/:albumNo/edit',
    name: 'AlbumModifyPage',
    components: {
      default: AlbumModifyPage
    },
    props: {
      default: true
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
