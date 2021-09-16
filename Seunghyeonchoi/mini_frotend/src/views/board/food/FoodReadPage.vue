<template>
    <div align="center">
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <food-read v-if="food" :food="food"/>
        <p v-else>로딩중 ......
        </p>
        <v-container fluid="fluid">
            <v-layout row="row" wrap="wrap">

                <v-flex class="item_list">
                <router-link :to="{ name: 'FoodListPage' }">
                    <v-btn color="light-blue lighten-1 text center" >
                        목록
                    </v-btn>
                </router-link>
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>

import FoodRead from '@/components/board/food/FoodRead.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'FoodReadPage',
    props: {
        foodNo: {
            type: String,
            required: true
        }
    },
    components: {
        FoodRead
    },
    computed: {
        ...mapState(['food'])
    },
    created () {
        this.fetchFood(this.$store.state.temp)
            .then(() => {
                    })
                .catch(err => {
                    console.log('err : ' + err)
                })
    },
    methods: {
        ...mapActions(['fetchFood'])
    }
}
</script>

<style scoped>
.item {
    font: 12pt;
    color: white;
    font-weight: 800;
}
.item_list {
    margin-top: 10px;
    display: flex;
}
.button_box {    
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
}
.v-btn {
    margin-right: 10px;
}
    
</style>