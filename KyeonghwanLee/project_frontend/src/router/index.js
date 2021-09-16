import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

// board
import BoardListPage from "@/views/board/BoardListPage.vue";
import BoardRegisterPage from "@/views/board/BoardRegisterPage.vue";
import BoardReadPage from "@/views/board/BoardReadPage.vue";
import BoardModifyPage from "@/views/board/BoardModifyPage.vue";

// product
import Product from "@/views/Product.vue";

//Cart
import Cart from "@/views/Cart.vue";
//crawl
import DaumNewsCrawlerPage from "@/views/news/DaumNewsCrawlerPage.vue";
//member
import MemberRegisterPage from "@/views/member/MemberRegisterPage.vue";
import MemberLoginPage from "@/views/member/MemberLoginPage.vue";

//slide
import AwesomeSwiperTestPage from "@/views/AwesomeSwiperTestPage.vue";
import BestProductPage from "@/views/BestProductPage.vue";
//카테고리 분류
import CategoryOverview from "@/views/CategoryOverview.vue";
import GenderOverview from "@/views/GenderOverview.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/products/:id",
    name: "product",
    component: Product,
    props: {
      default: true,
    },
  },
  {
    path: "/cart/",
    name: "cart",
    component: Cart,
  },

  {
    path: "/board",
    name: "BoardListPage",
    components: {
      default: BoardListPage,
    },
  },
  {
    path: "/board/create",
    name: "BoardRegisterPage",
    components: {
      default: BoardRegisterPage,
    },
  },
  {
    path: "/board/:boardNo",
    name: "BoardReadPage",
    components: {
      default: BoardReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/board/:boardNo/edit",
    name: "BoardModifyPage",
    components: {
      default: BoardModifyPage,
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true,
    },
  },
  {
    path: "/daumNewsCrawler",
    name: "DaumNewsCrawlerPage",
    components: {
      default: DaumNewsCrawlerPage,
    },
  },
  {
    path: "/member/create",
    name: "MemberRegisterPage",
    components: {
      default: MemberRegisterPage,
    },
  },
  {
    path: "/member/login",
    name: "MemberLoginPage",
    components: {
      default: MemberLoginPage,
    },
  },
  {
    path: "/awesomeSwiperTest",
    name: "AwesomeSwiperTestPage",
    components: {
      default: AwesomeSwiperTestPage,
    },
  },
  {
    path: "/BestProduct",
    name: "BestProductPage",
    components: {
      default: BestProductPage,
    },
  },
  {
    path: "/:category",
    name: "category-overview",
    components: {
      default: CategoryOverview,
    },
  },

  {
    path: "/:gender/",
    name: "gender-overview",
    components: {
      default: GenderOverview,
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
