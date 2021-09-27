<template>
<div class="font" style="font-family" >
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">

    <v-app id="inspire">
        <v-app-bar
                app
                clipped-right
                color="blue"
                dark>
            <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
            <v-spacer></v-spacer>
            <slot name="menubar"></slot>
        </v-app-bar>
        <v-navigation-drawer
                v-model="drawer"
                app>

        </v-navigation-drawer>
        <v-container>
            <v-content id="content">
                <slot name="content" class="font">
                </slot>
            </v-content>
        </v-container>
  
    </v-app>
</div>
</template>

<script>
import router from '@/router'
export default {
    data () {
        return {
            drawer: false,
            left: false
        }
    },
    methods: {
        home () {
            (window.location.pathname !== '/') ? router.push('/news') : router.go(0)
        },
        category () {
            (window.location.pathname !== '/daumNewsCrawler') ? router.push('/news') : router.go(0)
        }
    }
}
</script>