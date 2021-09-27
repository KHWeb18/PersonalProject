<template>
    <v-container >
        <v-container>
            <feed-card @categoryChange="categoryChange"></feed-card>
            <feed-page :category="$route.query.category"></feed-page>
        </v-container>
    </v-container>
     
</template>

<script>


import FeedCard from '../../components/sub/FeedCard.vue'
import FeedPage from '../../components/sub/FeedPage.vue'

export default {
    name:'SubPage',
    components: {   FeedCard , FeedPage },
    data(){
        return{
            category:''
        }

    },
    mounted(){
        this.category = this.$route.query.category   
        
    },
    methods:{
        categoryChange(payload){
            this.$router.push({name:'SubPage', query:{category: payload }})
            this.$router.go()
        }
    }
    
}
</script>