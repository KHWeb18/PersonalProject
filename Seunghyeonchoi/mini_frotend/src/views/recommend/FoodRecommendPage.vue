<template>
    <div >
        <v-spacer style="background-color: black;height: 90px;"></v-spacer>
        <div class="container1">
            <food-recommend-form :foods="foods"/>
        </div>
    </div>
</template>

<script>

import FoodRecommendForm from '@/components/recommend/FoodRecommendForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'FoodRecommendPage',
    components: {
        FoodRecommendForm
    },
    computed: {
        ...mapState(['foods'])
    },
    mounted () {
        this.fetchFoodList()
    },
    methods: {
        ...mapActions(['fetchFoodList'])
    }
}
</script>

<style scoped>
.container1 {
    display: flex;
    justify-content: center;
    min-height: 708px;
}
</style>