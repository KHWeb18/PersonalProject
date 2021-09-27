<template>
    <div>
        <v-toolbar color="#003663"  >            
            <v-app-bar-nav-icon dense dark @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>            
            <img class="text-center" src="../assets/img/logo_transparent.png" style="max-height: 135px; cursor:pointer;" @click="logo_home" />   
            <v-toolbar-title>
                <!--<span class="font-weight-light">Atelier</span>                
                <v-btn color="#005663" :to="{name:'Home'}"><img src="../assets/img/logo_transparent.png" style="max-height: 100px" /></v-btn>
                -->
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn dense dark text v-for="link in links" :key="link.icon" :to="link.route" style="font-size:1.15em;">
                    {{ link.text }}
                </v-btn>
            </v-toolbar-items>            
            <v-col class="text-right"> 
                <v-btn v-if="!isLogin" color="#003663" dense dark class="material-icons" style="font-size: 30px" :to="{name:'MemberLoginPage'}">
                    person
                </v-btn>
                <v-btn v-if="isLogin" color="#003663" dense dark class="material-icons" style="font-size: 30px" :to="{name: 'MemberModifyPage'}" >
                    person_add
                </v-btn>
                <v-btn v-if="isLogin" @click="logout" color="#003663" dense dark class="material-icons" style="font-size: 30px" >
                    exit_to_app
                </v-btn>
                <!--:to="{name:'Home'}"-->

                <v-btn color="#003663" dense dark class="material-icons" style="font-size: 30px" :to="{name: 'AddedProductListPage'}">
                    local_grocery_store
                </v-btn> 
            </v-col>
            <!--
                 href="/memberLoginTest"
            <v-spacer />
            <div @submit="onSubmit" value="2" style="text-align:right">
                
            </div>            -->

        </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
                <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-action>
                            <v-icon left>{{ link.icon }}</v-icon>
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
//import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'
Vue.use(cookies)


export default {
    name: 'VuetifyAllInOneTestPage',
    data () {
        return {
            message: '환장',
            nav_drawer: false,
            group: false,           
            // https://materializecss.com/icons.html
            links: [
                //{ icon: 'home', text: 'Home', name: 'home', route: '/' },
                {
                    icon: 'filter', text: '판매작품', name: 'filter', route: '/product'
                },
                {
                    icon: 'info_outline', text: '정보', name: 'info_outline', route: '/daumNewsCrawler'
                }
            ]
        }
    },    
    
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.$store.state.isLogin = true
        }
    },
    computed: {        
        ...mapState(['isLogin']),
        ...mapState(['session'])
    },
    methods: {   
        /*
        removeSession () {
            axios.post('http://localhost:7777/member/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data
                    })       
        },*/     
        logout () {
            this.$cookies.remove("user")
            this.$store.state.isLogin = false
            this.$store.state.session = null
        },       
        logo_home () {            
            this.$router.push('/').catch(()=>{});
        },       
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    }
}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
/*
  .logo-image {
    padding-top: 300px;
    width: 80px;
  }
  */
</style> 