<template>
    <div>
        <v-app-bar
            style="z-index: 1;"
            absolute="absolute"
            color="transparent"
            shrink-on-scroll="shrink-on-scroll"
            prominent="prominent"
            elevate-on-scroll="elevate-on-scroll"
            scroll-target="#scrolling-techniques-7"
            scroll-threshold="700">
            <template v-if="this.$store.state.isAuth" v-slot:img="{ props }">
                <v-img
                    v-bind="props"
                    gradient="to top right, rgba(55,255,255,0), rgba(255,255,255,0)"></v-img>
            </template>

            <v-app-bar-nav-icon
                v-if="!this.$store.state.isAuth"
                disabled="disabled"
                style="color:white"
                @click="drawer = true"></v-app-bar-nav-icon>
            <v-app-bar-nav-icon
                v-if="this.$store.state.isAuth"
                color="white"
                @click="drawer = true"></v-app-bar-nav-icon>
            <v-toolbar-content>
                <ul class="menu1">
                    <li>
                        <router-link :to="{ name: 'MainPage' }">HOME</router-link>
                    </li>
                    <li>
                        <router-link :to="{ name: 'NoticeBoardListPage' }">NOTICE</router-link>
                    </li>
                    <li>
                        <router-link :to="{ name: 'FoodListPage' }">LIST</router-link>
                    </li>
                    <li>
                        <router-link :to="{ name: 'FoodRecommendPage' }">RECOMMEND</router-link>
                    </li>
                    <li>
                        <router-link :to="{ name: 'FreeBoardListPage' }">COMMUNITY</router-link>
                    </li>
                </ul>
            </v-toolbar-content>
            <div class="side_icon_box">
                <div class="abled_icon">
                    <v-btn v-if="!this.$store.state.session" icon="icon" class="take_place">
                        <router-link :to="{ name: 'MemberLogin' }">
                            <v-icon color="white">mdi-login</v-icon>
                        </router-link>
                    </v-btn>
                </div>
                <div class="disabled_icon">
                    <v-btn v-if="this.$store.state.session" icon="icon" class="take_place">
                        <v-icon disabled="disabled" class="disabled_icon">mdi-login</v-icon>
                    </v-btn>
                </div>
                <div class="disabled_icon">
                    <v-btn v-if="!this.$store.state.session" icon="icon" class="take_place">
                        <v-icon disabled="disabled">mdi-dots-vertical</v-icon>
                    </v-btn>
                </div>
                <div v-if="this.$store.state.session">
                    <v-row class="mdi_dots_vertical">
                        <v-menu bottom="bottom" min-width="200px" rounded="rounded" offset-y="offset-y">
                            <template v-slot:activator="{ on }">
                                <v-btn icon="icon" x-large="x-large" v-on="on">
                                    <v-icon color="white">mdi-dots-vertical</v-icon>
                                </v-btn>
                            </template>
                            <v-card class="profile_card">
                                <v-list-item-content class="justify-center">
                                    <div class="mx-auto text-center">
                                        <v-avatar color="black" size="100">
                                            <span class="white--text text-h5">
                                                <img :src="ImgRequest()" style="width:110px;height:110px;object-fit: cover"></span>
                                        </v-avatar>
                                        <h5 style="margin-top:10px;">{{ this.$store.state.yourNickname }}</h5>
                                        <v-divider class="my-3"></v-divider>
                                        <router-link :to="{ name: 'MemberProfilePage' }">
                                            <v-btn depressed="depressed" rounded="rounded" text="text">
                                                Edit Profile
                                            </v-btn>
                                        </router-link>
                                        <v-divider class="my-3"></v-divider>
                                        <v-btn depressed="depressed" rounded="rounded" text="text" @click="logout">
                                            Logout
                                        </v-btn>
                                    </div>
                                </v-list-item-content>
                            </v-card>
                        </v-menu>
                    </v-row>
                </div>
            </div>
        </v-app-bar>
        <v-navigation-drawer v-model="drawer" absolute="absolute" temporary="temporary">
            <v-list nav="nav" dense="dense">
                <v-list-item-group
                    v-model="group"
                    active-class="deep-purple--text text--accent-4">
                    <v-list-item>
                        <v-list-item-icon></v-list-item-icon>
                        <v-list-item-title style="font-size: 20px;">Administrator</v-list-item-title>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-icon>
                            <v-icon>mdi-food-apple</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title @click="routeFoodRegisterPage">Food Register</v-list-item-title>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-icon>
                            <v-icon>mdi-alarm-check</v-icon>
                        </v-list-item-icon>
                        <v-list-item-title @click="routeNoticeBoardRegisterPage">Something
                        </v-list-item-title>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import axios from 'axios'

export default {
    name: 'NavBarComponet',
    data () {
        return {           
            drawer: false,
            group: null,
            userS: {
              initials: 'JD'
            },
        }
    },
    computed: {
        ...mapState(['session'])
    },
    mounted () {
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.$store.state.isLogin = true
        }
    },        
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
    methods: {
        logout () {
            this.$cookies.remove("user")
            this.$store.state.session = null
            this.$store.state.isAuth = false
            this.$store.state.isLogin = false
            console.log('로그아웃!')
            // console.log('this.$store.state.session' + this.$store.state.session)
            // console.log('this.$store.state.isAuth' + this.$store.state.isAuth)
            // console.log('this.$store.state.isLogin : ' + this.$store.state.isLogin)
            axios.post('http://localhost:7777/jpamember/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data
                        this.$store.state.isAuth = false
                    })
        },
        routeFoodRegisterPage () {
          this.$router.push('/admin/foodRegister')
        },
        routeMemberListPage () {
          this.$router.push('/memberListPage')
        },
        routeNoticeBoardRegisterPage () {
          this.$router.push('/noticeBoard/create')
        },
        ImgRequest() {
            try {
                return require(`../../../Mini/Images/profile/${this.$store.state.yourId}.gif`                
                )
            } catch (e) {
                return require(`@/assets/logo.png`)
            }
        }
    }
}
</script>

<style scoped>
.icon2 {
    margin-right: 20px;
    margin-top: 7px;
    display: flex;
    justify-content: center;
}
.navbar_content {
    display: flex;
    justify-content: row;
    overflow-y: hidden;
    max-height: 100%;
    transition: .2s ease;
}
.navbar_content_two {
    display: flex;
    justify-content: flex-end;
    overflow-y: hidden;
    max-height: 100%;
    transition: .2s ease;
}
.main-page-bar-menu {
    margin: 12px;    
    display: block; 
    opacity: 1;
    font-size: 15px;   
}
.item {
    margin: 6px;
}
@font-face {
  font-family: 'Recipekorea';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
  font-weight: normal;
  font-style: normal;
  
}
* {
  margin: 0;
  padding: 0;
}
a, a:link {
  text-decoration: none;
  font-family: 'Recipekorea';
}
ul {
  list-style: none;
  display: flex;
  justify-content: center;
}
ul li a {
  display: block;
  padding: 0.5vw 2vw 1vw;
  position: relative;
  /* font-size: 40px; */
}
ul li a::after {
  content: '';
  display: block;
  position: absolute;
}
.menu1 {
    font-size: 180%;
    width: 85.7vw;
    color: white;
}
.menu1 li a::after {
  width: 0;
  height: 0.7vw;
  background: #ffffff;
  left: 50%;
}
ul li a:hover::after {
  width: 100%;
  left: 0;
  transition: all .3s;
}
.v-application a {
    color:white;
}
.v-app-bar__nav-icon.v-btn.v-btn--icon.v-btn--round.theme--light.v-size--default {
    margin: 5px 1vw
}
.take_place {
    margin-right: 5px 0.3vw;
}
.disabled_icon {
  margin-top: 10px;
  opacity: 0;
  cursor: default;
}
.abled_icon {
  margin-top: 10px;
}
.side_icon_box {
  display: flex;
  justify-items: end;
  width: 30vw;
}
.mdi_dots_vertical {
  margin: 0px;
  padding: 0px;
  margin-top: 10px;
}
.profile_card {
  background-color: rgba(255, 255, 255, 0.7) !important;
}
</style> 