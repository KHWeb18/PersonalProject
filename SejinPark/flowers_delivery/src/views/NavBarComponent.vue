<template>
    <div>
        <v-toolbar dense skyblue>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
          
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{ link.text }}
                </v-btn>
            </v-toolbar-items>
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
export default {
    name: 'nav',
    data () {
        return {
            
            nav_drawer: false,
            group: false,
             
            links: [
                {
                    icon: 'logo', text: 'Logo', name: 'logo', route: '/'
                },
                {
                    icon: 'bouquet', text: '꽃다발', name: 'bouquet', route: '/bouquetPage'
                },
                {
                    icon: 'flower_basket', text: '꽃바구니', name: 'flower_basket', route: '/basketPage'
                },
                {
                    icon: 'log_in', text: '로그인', name: 'log_in', route: '/sessionLogin'
                },
                {
                    icon: 'join', text: '회원가입', name: 'join', route: '/accountRegister'
                }
            ]
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
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
v-bottom-navigation {
    display: bottom;
}
</style>