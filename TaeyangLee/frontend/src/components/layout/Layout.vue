<template>
    <v-app id="inspire">
        
            
            <v-spacer></v-spacer>
                <slot name="menubar"></slot>
        
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
            (window.location.pathname !== '/') ? router.push('/') : router.go(0)
        },
        category() {
             (window.location.pathname !== '/daumNewsCrawler') ? router.push('/') : router.go(0)

        }
    }
}
</script>