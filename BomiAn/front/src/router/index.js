import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SignUp from '../views/SignUp.vue'
import SignIn from '../views/SignIn.vue'
import GoToVote from '../views/GoToVote.vue'
import MyAccount from '../views/MyAccount.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signUp',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/signIn',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/goToVote/:id',
    name: 'GoToVote',
    component: GoToVote
  },
  {
    path: '/myAccount',
    name: 'MyAccount',
    component: MyAccount
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
