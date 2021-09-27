<template>
  <div>
      <v-app-bar
        color="white"
        elevate-on-scroll


      >
        <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer"></v-app-bar-nav-icon>
  
        <v-toolbar-title class="orange--text text--lighten-4">Writer</v-toolbar-title>
  
      </v-app-bar>
      <v-navigation-drawer v-if="isLogin" app v-model="nav_drawer" temporary>
        <v-list nav >
            <v-list-item-group active-class="deep-purple--text text--accent-4">
              <v-list-item v-for="link in isLogin_true" :key="link.name" router :to="link.route">
                  <v-list-item-action>
                      <v-icon left>{{ link.icon }}</v-icon>
                  </v-list-item-action>
                  <v-list-item-title>
                      <v-list-item-title>
                          {{ link.text }}
                      </v-list-item-title>
                  </v-list-item-title>
              </v-list-item>
            </v-list-item-group>
        </v-list>
      </v-navigation-drawer>

      <v-navigation-drawer v-else app v-model="nav_drawer" temporary>
        <v-list nav>
          <v-list-item-group active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link in isLogin_false" :key="link.name" router :to="link.route">
              
              <v-list-item-icon>
                <v-icon left>{{ link.icon }}</v-icon>
              </v-list-item-icon>
              
              <v-list-item-title>
                {{ link.text }}
              </v-list-item-title>
            </v-list-item>
          </v-list-item-group>
        </v-list>

      </v-navigation-drawer>

  </div>
</template>

<script>


export default {
  data(){
    return{
      isLogin : false,
      nav_drawer: false,
      isLogin_true:[               
              {
                
                  icon: 'mdi-home',
                  text: '메인페이지',
                  name: 'main',
                  route:'/main',

              },
              {
                  
                  icon: 'mdi-note-multiple',
                  text: '작업실',
                  name: 'MyPage',
                  route:'/my-page',

              },
              {
                  
                  icon: 'mdi-note-search',
                  text: '피드',
                  name: 'Subpage',
                  route:'/sub',

              },
              {
                  
                  icon: 'mdi-logout',
                  text: '로그아웃',
                  name: 'Logout',
                  route:'/logout',

              },
      ],
      isLogin_false:[               
              {
                
                  icon: 'mdi-home',
                  text: '메인페이지',
                  name: 'main',
                  route:'/main',

              },
              {
                  
                  icon: 'mdi-login',
                  text: '로그인',
                  name: 'Login',
                  route:'/login-and-register',

              },
      ],
    }
  },
  mounted(){
    if(this.$cookies.get('user').email != null){
      this.isLogin = true
    }else{
      this.isLogin = false
    }
  },

    
}
</script>