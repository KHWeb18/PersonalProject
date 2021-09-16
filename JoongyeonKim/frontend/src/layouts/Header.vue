<template>
    <div id="container">
        <v-banner>
            <v-toolbar dense white>
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon>
                <v-toolbar-items>
                    <v-btn color="primary" tile large
                        @click="fundingUpload" href="/basic" v-if="isLogin">
                        프로젝트 올리기
                    </v-btn>
                    <v-btn color="primary" tile large v-else @click="fundingUploadFail">
                        프로젝트 올리기
                    </v-btn>
                </v-toolbar-items>
                <div id="logo">
                    <a href="main">
                        <h1>Cloud</h1>
                    </a>
                </div>
                 <v-btn color="primary"  tile large @click="logout" v-if="isLogin">
                    로그아웃
                </v-btn>
                <div v-else>
                    <v-btn color="primary"  tile large text v-for="link in loginLinks" :key="link.icon" :to="link.route">
                            {{ link.text }}
                    </v-btn>
                </div>
            </v-toolbar>
            <v-navigation-drawer app v-model="nav_drawer" temporary>
                <v-list nav dense>
                    <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                        <v-list-item v-for="link in category" :key="link.name" router :to="link.route">
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
        </v-banner>
    </div>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
          isLogin: false,
          nav_drawer: false,
          group: false,
          loginLinks: [
                {
                text: '회원가입/로그인',
                name: 'MemberLoginPage',
                route: '/login'
                },
          ],
          category: [
                {
                icon: 'home',
                text: '메인페이지',
                name: 'main_page',
                route: '/main'
                },
                {
                icon: 'shopping_cart',
                text: '프로젝트 리스트',
                name: 'game_List',
                route: '/funding'
                },
                {
                icon: 'pageview',
                text: '뉴스',
                name: 'daum_Crawl',
                route: '/daumBlogCrawler'
                }
            ]
        }
    },
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    computed: {
        },
    methods: {
            logout () {
                this.$cookies.remove("user")
                this.isLogin = false
                this.$store.state.session = null
                alert('로그아웃 처리되었습니다 ')
                this.$router.go();
            },
            fundingUpload() {
                this.isLogin = true
            },
            fundingUploadFail() {
                this.isLogin = false
                alert('로그인이 필요합니다')
                this.$router.push("login")
            }
        },
    watch: {
        group () {
            this.nav_drawer = false
        }
    }    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Rampart+One&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1200px;
}

#logo {
    font-family: 'Rampart One', cursive;
    float: center;
    width: 900px;
    height: 100px;
    line-height: 100px;
    padding-left: 0px;
}

a {
    text-decoration: none;
}

h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>