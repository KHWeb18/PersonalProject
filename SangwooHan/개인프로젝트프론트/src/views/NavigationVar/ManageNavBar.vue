<template>
<div>
    <!--로그아웃일떄-->
    <v-toolbar  dense dark >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
    <v-toolbar-items>
        <v-btn text v-for="link in LogOutlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
 <!--로그인일때 -->
 <v-toolbar  dense dark >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
    <v-toolbar-items>
        <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
 
    <v-navigation-drawer app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in links2" :key="link.name" router :to="link.route">
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
export default {
    data () {
        return {
            nav_drawer: false,
            group: false,

            LogOutlinks: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                
                
            ],
            LogInlinks: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                
                
            ],
            links2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },

            ],

        }
    },
   watch: {
       group () {
           this.nav_drawer =false
       }
   }
}
</script>