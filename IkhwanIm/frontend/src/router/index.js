import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'

import Car from "../views/rides/Car";
import Walk from "../views/rides/Walk";
import Bike from "../views/rides/Bike";
import Motorcycle from "../views/rides/Motorcycle";
import BoardRegisterPage from "../views/board/BoardRegisterPage";
import BoardListPage from "../views/board/BoardListPage";
import BoardReadPage from "../views/board/BoardReadPage";
import BoardModifyPage from "../views/board/BoardModifyPage";
import TestPage from "../views/TestPage";
import MemberInfoPage from "../views/MemberInfoPage";
import MemberInfoChangePage from "../views/MemberInfoChangePage";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/walk',
    name: 'Walk',
    components: {
      default: Walk
    }
  },
  {
    path: '/bike',
    name: 'Bike',
    components: {
      default: Bike
    }
  },
  {
    path: '/motorcycle',
    name: 'Motorcycle',
    components: {
      default: Motorcycle
    }
  },
  {
    path: '/car',
    name: 'Car',
    components: {
      default: Car
    }
  },
  {
    path: '/test',
    name: 'TestPage',
    components: {
      default: TestPage
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
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
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
  {
    path: '/memberInfo',
    name: 'MemberInfoPage',
    components: {
      default: MemberInfoPage
    }
  },
  {
    path: '/memberInfoChange',
    name: 'MemberInfoChangePage',
    components: {
      default: MemberInfoChangePage
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
