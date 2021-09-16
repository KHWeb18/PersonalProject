import Vue from 'vue'
import VueRouter from 'vue-router'
import DefaultLayout from '../views/default/DefaultPage'



const isAuthenticated = (to, from, next) => {
  if (localStorage.getItem('email') !== null) {
    next()
  } else {
    next('/');
    alert('로그인이 필요합니다')
  }
};

Vue.use(VueRouter)


const routes = [
  {
    path: '/home',
    component: DefaultLayout,
    children:[
      {
        path: "/home",
        name: 'Home',
        component: () =>import('../views/Home'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )


      },
      {
        path: "/board",
        name: 'Board',
        component: () =>import('../views/Board'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )
        // to from은 어디서 어로 이동하는 표시 next는 안에함수를 실행하고
        // router를 어디로 이동시킬지 정해줌

      },
      {
        path: "/contact-list",
        name: 'ContactList',
        component: () =>import('../views/ContactList'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )
      },
      {
        path: "/schedule",
        name: 'Schedule',
        component: () =>import('../views/Schedule'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )
      },
      {
        path: "/commuting",
        name: 'Coummting',
        component: () =>import('../views/Coummting'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )
      },
      {
        path: "/plan",
        name: 'Plan',
        component: () =>import('../views/Plan'),
        beforeEnter: ( to, from, next ) => isAuthenticated( to, from ,next )
      }
    ]
  },
  {
    path: "/",
    name: 'Signin',
    component: () =>import('../views/authentication/Signin')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
