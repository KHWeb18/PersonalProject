<template>
  <v-app>
  <v-app-bar
  app
  color="black"
  dark
  >

  <template v-slot:extension>
  <v-spacer>
     <v-tabs

        color="dark"
        slider-color="blue-grey"
      >
        <!-- 으아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ-->
        <v-toolbar-items>
            <v-tab text v-for="link in links" :key="link.icon" :to="link.route">
                {{ link.text }}
                
            </v-tab>
        </v-toolbar-items>
      </v-tabs>
  </v-spacer>
  </template>

<!-- 맨위 상단-->
   <v-app-bar-nav-icon @click="drawer = !drawer" />
      <site-title :title="title"></site-title>
      <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> 
      <site-search/>
      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>

        


     <!--왼쪽 메뉴-->
    </v-app-bar>
    <v-navigation-drawer app v-model="drawer">
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="title">
            Menu
          </v-list-item-title>

        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>
      <site-menu></site-menu>
    </v-navigation-drawer>
    <v-main>
      <router-view/>
    </v-main>
    <site-footer :footer="footer"></site-footer>
  </v-app>

   
</template>



<script>
import SiteTitle from '@/views/site/title'
import SiteFooter from '@/views/site/footer'
import SiteMenu from '@/views/site/menu'
import SiteSearch from '@/views/site/search'
export default {
  components: { SiteTitle, SiteFooter, SiteMenu, SiteSearch  },
  name: 'App',
   data () {
        return {
          drawer: false,
          items: [],
          title: 'PHOTO BY',
      footer: '푸터입니다',
      links: [
                {
                    icon: 'home', text: 'Home', name: 'home', route: '/main'
                },
                {
                    icon: 'community', text: 'Community', name: 'community', route: '/board'
                },
                {
                    icon: 'market', text: 'Market', name: 'market', route: '/market'
                },
                {
                    icon: 'login', text: 'Login', name: 'login', route: '/sessionLogin'
                },
                {
                    icon: 'signup', text: 'Signup', name: 'signup', route: '/accountRegister'
                }  
            ]

    }
    
  },
  mounted () {
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
</style>