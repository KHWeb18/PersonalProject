<template>
    <div>
        <!--
         <v-data-table
        :headers="headerTitle"
        :items="ButterflyList"
        item-key="boardNo"
        :items-per-page="10"
       @click:row="handleClick">
        </v-data-table>
        -->
        <butterfly-list-new-form :listArray="PageArray"/>
    </div>
</template>

<script>
import axios from 'axios'
import ButterflyListNewForm from './ButterflyListNewForm.vue'
export default {
  components: { ButterflyListNewForm },
    name:'ButterflyListForm',
    props: {
        ButterflyList: {
            type:Array
        }
    },
    data() {
        return{
            PageArray: []
        }
    },
    methods: {
       
    },
    created() {

        axios.get('http://localhost:9999/butterfly/butterflyList')
        .then((res) =>{
            this.PageArray = res.data
        })
    }
}
</script>