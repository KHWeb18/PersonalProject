<template>
    <div>
        <!--
        <v-data-table
        :headers="headerTitle"
        :items="SkycowList"
        item-key="boardNo"
        :items-per-page="10"
       @click:row="handleClick">
        </v-data-table>
        -->
        <skycow-list-new-form :listArray="PageArray"/>
    </div>
</template>

<script>
import axios from 'axios'
import SkycowListNewForm from './SkycowListNewForm.vue'
export default {
  components: { SkycowListNewForm },
    name: 'SkycowListForm',
    props: {
        SkycowList: {
            type: Array
        }
    },
    methods: {
        
    },
    created(){
        
        axios.get('http://localhost:9999/skycow/SkycowList')
        .then( (res) => {
            this.PageArray = res.data
        })
    },
    data(){

        return{
             PageArray: []
        }
    }
}
</script>