import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 유저 게시판
import FreeBoardListPage from '@/views/board/free/BoardListPage.vue'
import FreeBoardRegisterPage from '@/views/board/free/BoardRegisterPage.vue'
import FreeBoardReadPage from '@/views/board/free/BoardReadPage.vue'
import FreeBoardModifyPage from '@/views/board/free/BoardModifyPage.vue'
// 공지사항
import NoticeBoardListPage from '@/views/board/notice/BoardListPage.vue'
import NoticeBoardRegisterPage from '@/views/board/notice/BoardRegisterPage.vue'
import NoticeBoardReadPage from '@/views/board/notice/BoardReadPage.vue'
import NoticeBoardModifyPage from '@/views/board/notice/BoardModifyPage.vue'


// 사이트 정보 제공
import FoodListPage from '@/views/board/food/FoodListPage.vue'
import FoodReadPage from '@/views/board/food/FoodReadPage.vue'

// 관리자 게시판
import FoodRegisterPage from '@/views/board/operator/FoodRegisterPage.vue'
import FoodRecommendPage from '@/views/recommend/FoodRecommendPage.vue'


// 첫화면
import MainPage from '@/views/MainPage.vue'


//temp
import VuetifyAllOneTestPage from '@/views/VuetifyAllOneTestPage.vue'
// v-lazy image
import { VLazyImagePlugin } from 'v-lazy-image';
// member
import MemberJoinColumn from '@/views/member/MemberJoinColumn.vue'
import MemberLoginPage from '@/views/member/MemberLoginPage.vue';
import MemberProfilePage from '@/views/member/MemberProfilePage.vue';

Vue.use(VueRouter)
Vue.use(VLazyImagePlugin);

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(() => {
        return window.location.reload()
    })
};


const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/noticeBoard',
    name: 'NoticeBoardListPage',
    components: {
      default: NoticeBoardListPage
    }
  },
  {
    path: '/noticeBoard/create',
    name: 'NoticeBoardRegisterPage',
    components: {
      default: NoticeBoardRegisterPage
    }
  },
  {
    path: '/noticeBoard/:boardNo',
    name: 'NoticeBoardReadPage',
    components: {
      default: NoticeBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeBoard/:boardNo/edit',
    name: 'NoticeBoardModifyPage',
    components: {
      default: NoticeBoardModifyPage
    }
  },
  {
    path: '/freeBoard',
    name: 'FreeBoardListPage',
    components: {
      default: FreeBoardListPage
    }
  },
  {
    path: '/freeBoard/create',
    name: 'FreeBoardRegisterPage',
    components: {
      default: FreeBoardRegisterPage
    }
  },
  {
    path: '/freeBoard/:boardNo',
    name: 'FreeBoardReadPage',
    components: {
      default: FreeBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/freeBoard/:boardNo/edit',
    name: 'FreeBoardModifyPage',
    components: {
      default: FreeBoardModifyPage
  },
  props: {
    // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
    default: true
  }
  },
  {
    path: '/vuetifyAllOne',
    name: 'VuetifyAllOneTestPage',
    components: {
      default: VuetifyAllOneTestPage
    }
  },
  {
    path: '/',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/register',
    name: 'MemberJoinColumn',
    components: {
      default: MemberJoinColumn
    }
  },
  {
    path: '/login',
    name: 'MemberLogin',
    components: {
      default: MemberLoginPage
    }
  },
  {
    path: '/admin/foodRegister',
    name: 'FoodRegisterPage',
    components: {
      default: FoodRegisterPage
    }
  },
  {
    path: '/foodList',
    name: 'FoodListPage',
    components: {
      default: FoodListPage
    }
  },
  {
    path: '/foodRead/:foodNo',
    name: 'FoodReadPage',
    components: {
      default: FoodReadPage
    }
  },
  {
    path: '/FoodRecommendPage',
    name: 'FoodRecommendPage',
    components: {
      default: FoodRecommendPage
    }
  },
  {
    path: '/MemberProfilePage',
    name: 'MemberProfilePage',
    components: {
      default: MemberProfilePage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router