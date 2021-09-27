<template>
    <div>
        <img src="@/assets/상우/한국장수풍뎅이.jpg"/>
        <!--
            <v-data-table
            :headers="headerTitles"
            :items="BeetleList"
            item-key="boardNo"
            :items-per-page="10"
             @click:row="handleClick">
            </v-data-table>
            -->
            <beetle-list-new-form :listArray="pageArray"/>
    </div>
</template>

<script>
import axios from 'axios'
import BeetleListNewForm from './BeetleListNewForm.vue'
export default {
  components: { BeetleListNewForm },
    name: 'BeetleListForm',
    props: {
        BeetleList: {
            tpye: Object
        }
    },
    data() {
        return{
            pageArray:[]
        }
    },
    methods: {
        
    },
    created(){

        axios.get('http://localhost:9999/beetle/beetlelist')
        .then((res) =>{
            this.pageArray = res.data
        })
    }
}
</script>