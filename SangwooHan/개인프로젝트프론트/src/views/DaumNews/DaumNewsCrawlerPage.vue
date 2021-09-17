<template>
    <div>
        <v-container>
         <v-btn class="blue" @click="start('society')">최신정보받아오기</v-btn>
    <p>검색</p>
    <input v-model="search" />
            <ul>
                <li  v-for="i in lists " :key="i.newsNo">
                    <p v-if="i.title.includes(search)"> {{i.newsNo}}.{{i.title}} </p>
                </li>
            </ul>
        </v-container>
    </div>
</template>

<script>

import {  mapState } from 'vuex'
export default {
    data(){
        return{
                search: ''
        }
    },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            // action 수동 호출
            this.$store.dispatch('crawlFind', category)
        }
        
    },

}
</script>