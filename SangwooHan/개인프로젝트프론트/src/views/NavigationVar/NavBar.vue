<template>
<div>
    <!--로그아웃일때-->
 
    <v-toolbar  dark flat  v-if="this.$store.state.User == null"  >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
    
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items >
        <v-btn text v-for="link in LogOutlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
      
    </v-toolbar-items>
    <v-spacer></v-spacer>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar dark flat   v-if="this.$store.state.User != null"  >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
     <v-spacer></v-spacer>
    <v-toolbar-items>
        <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
      <v-spacer></v-spacer>
    </v-toolbar>
   
   
    
<!--로그인일때-->
    <v-navigation-drawer    v-if="this.$store.state.User == null" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in LogInlinks2" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
<!--로그아웃일때-->
     <v-navigation-drawer  v-if="this.$store.state.User != null" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in LogOutlinks2" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
    <!--관리자일때-->
    <v-navigation-drawer  v-if="this.$store.state.User == '관리자'" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in ManageLinks" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
        </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
    computed:{
        ...mapState(['User','loginMemberNo'])
    },
    data () {
        return {
            nav_drawer: false,
            group: false,

            LogOutlinks: [
               
                 {
                     
                    text: '커뮤니티',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                 {
                     
                    text: '곤충박물관',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/insectmuseumpage',
                },
                   {
                     
                    text: '쇼핑몰',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/shoppingMallPage',
                },
               
            ],
             LogInlinks: [
               
                {
                     
                    text: '커뮤니티',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                  {
                     
                    text: '곤충박물관',  
                    name: '곤충박물관',
                    route: '/insectmuseumpage',
                },
                   {
                     
                    text: '쇼핑몰',  
                    name: '곤충갤러리',
                    route: '/shoppingMallPage',
                },
               
                
            ],
            LogInlinks2: [
                
               
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            LogOutlinks2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                {
                    icon: 'mdi-account-circle',
                    text: '마이페이지',
                    name: '마이페이지',
                    route: '/myPage',params: {memberNo: this.$store.state.loginMemberNo}
                },
                 
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            ManageLinks: [
                {
                    icon: 'mdi-account-circle',
                    text: '마이페이지',
                    name: '마이페이지',
                    route: '/myPage',params: {memberNo: this.$store.state.loginMemberNo}
                },
                 {
                    icon: 'mdi-pencil-remove',
                    text: '박물관게시물작성',
                    name: '박물관게시물작성',
                    route: '/stagbeetleRegister'
                },
                {
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
                },
                {
                    icon: 'mdi-pencil-outline',
                    text: '공지게시',
                    name: '공지게시',
                    route: '/noticeRegisterPage',
                },
                {
                    icon: 'mdi-currency-usd',
                    text: '상품등록하기',
                    name: '상품등록',
                    route: '/productRegister',
                },
                {
                    icon: 'mdi-order-bool-descending-variant',
                    text: '주문현황',
                    name: '주문현황',
                    route: '/orderListPage',
                },
               
            ]
            

        }
    },
   watch: {
       group () {
           this.nav_drawer =false
       }
   }
}
</script>