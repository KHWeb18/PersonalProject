import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue';
import SignUp from '../views/SignUp.vue';
import Home from "../views/Home";
import MyPage from "../views/MyPage";
import BoardList from "../views/community/List";
import BoardDetail from "../views/community/Detail";
import BoardModify from "../views/community/Modify";
import StoreList from "../views/Store";
import GalleryList from  "../views/gallery/List"
import GalleryModify from  "../views/gallery/Modify"
import GalleryDetail from  "../views/gallery/Detail"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: SignUp
  },
  {
    path: '/mypage',
    name: 'MyPage',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: MyPage
  },
  {
    path: '/community',
    name: 'BoardList',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: BoardList
  },
  {
    path: '/community/detail/:id',
    name: 'BoardDetail',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: BoardDetail
  },
  {
    path: '/community/create',
    name: 'BoardCreate',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: BoardModify
  },
  {
    path: '/community/modify/:id',
    name: 'BoardModify',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: BoardModify
  },
  {
    path: '/store',
    name: 'StoreList',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: StoreList
  },
  {
    path: '/gallery',
    name: 'GalleryList',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: GalleryList
  },
  {
    path: '/gallery/modify/:id',
    name: 'GalleryModify',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: GalleryModify,
  },
  {
    path: '/gallery/create',
    name: 'GalleryCreate',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: GalleryModify
  },
  {
    path: '/gallery/detail/:id',
    name: 'GalleryDetail',
    // component: () => import(/* webpackChunkName: "about" */ '../views/SignUp.vue')
    component: GalleryDetail
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
