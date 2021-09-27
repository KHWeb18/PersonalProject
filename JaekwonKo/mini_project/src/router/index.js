import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MemberLoginPage from '@/views/MemberLoginPage.vue'
import Logout from '@/views/Logout.vue'
import Store from '@/views/Store.vue'
import Market from '@/views/Market.vue'
import News from '@/views/News.vue'
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'





//import SearchPage from '@/views/SearchPage.vue'

Vue.use(VueRouter)


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'MemberLoginPage',
    components: {
      default: MemberLoginPage
    }
  },
  {
    path: '/logout',
    name: 'Logout',
    components: {
      default: Logout
    }
  },
  {
    path: '/store',
    name: 'Store',
    components: {
      default: Store
    }
  },
  {
    path: '/market',
    name: 'Market',
    components: {
      default: Market
    }
  },
  {
    path: '/news',
    name: 'News',
    components: {
      default: News
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
    path: '/membership',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
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
    }
  },
  
  
  
  
 // {
  //  path: '/search',
  //  name: 'SearchPage',
  //  components: {
  //    default: SearchPage
  //  }
 // },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
