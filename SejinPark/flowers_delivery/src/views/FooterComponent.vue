<template>
    <div>
        <v-footer dense  >
            
          
            <v-footer-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{ link.text }}
                </v-btn>
            </v-footer-items>
        </v-footer>
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
   name: 'Footer',
    data () {
        return {
             nav_drawer: false,
            group: false,
         
           
            links: [
                {
                    icon: 'customer_center', text: '고객센터', name: 'customer_center'
                },
                {
                    icon: 'faq', text: 'FAQ 페이지', name: 'faq', route: '/board'
                },
                {
                    icon: 'one_on_one', text: '1:1 문의', name: 'one_on_one', route: '/board/create'
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
div {
    color: #37474F;
} 

</style>