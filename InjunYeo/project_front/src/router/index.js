import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainPage from '../views/main/MainPage.vue'
//회원가입 페이지
import RegisterPage from '../views/register/RegisterPage.vue'

import LogoutPage from '../views/login/LogoutPage.vue'
import LoginAndRegisterPage from '../views/login/LoginAndRegisterPage.vue'
import SubPage from '../views/sub/SubPage.vue'
//마이페이지
import MyPageBoard from '../views/my/MyPageBoard.vue'
import MyPageBoardRegister from '../views/my/MyPageBoardRegister.vue'
import MyPageBoardDetail from '../views/my/MyPageBoardDetail.vue'
import MyPageBoardCategory from '../views/my/MyPageBoardCategory.vue'

//테스트 페이지
import Test from '../views/Test.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },
  //회원가입페이지
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },
  {
    path: '/logout',
    name: 'Logout',
    component: LogoutPage
  },

  {
    path: '/login-and-register',
    name: 'LoginAndRegisterPage',
    component: LoginAndRegisterPage
  },
  //서브페이지
  {
    path: '/sub',
    name: 'SubPage',
    components: {
      default:SubPage
    },
    props:{
      default: true
    }
  },
  //마이페이지
  {
    path: '/my-page',
    name: 'MyPageBoard',
    component: MyPageBoard
  },
  {
    path: '/my-page-board-category',
    name:'MyPageBoardCategory',
    components:{ 
      default: MyPageBoardCategory
    },
    props:{
      default: true
    }
  },
  
  {
    path: '/my-page-board-register',
    name:'MyPageBoardRegister',
    components:{ 
      default: MyPageBoardRegister
    },
    props:{
      default: true
    }
  },

  {
    path: '/my-page-board-detail/:boardNo',
    name: 'MyPageBoardDetail',
    components: {
      default: MyPageBoardDetail
    },
    props:{
      default: true
    }
  },
  

  {
    path: '/test',
    name: 'Test',
    component: Test
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
