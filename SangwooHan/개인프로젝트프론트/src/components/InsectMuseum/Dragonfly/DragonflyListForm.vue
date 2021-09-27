<template>
    <div>
        <!--
        <v-data-table
        :headers="headerTitle"
        :items="DragonflyList"
        item-key="boardNo"
        :items-per-page="10"
       @click:row="handleClick">
        </v-data-table>
        -->
        <dragonfly-list-new-form :listArray="PageArray"/>
    </div>
</template>
<script>
import axios from 'axios'
import DragonflyListNewForm from './DragonflyListNewForm.vue'

export default {
  components: { DragonflyListNewForm },
        name: 'DragonflyListForm',
        props: {
            DragonflyList:{
                type: Array
            }
        } ,
        data() {
            return{
                PageArray: []
            }
        },
        methods: {
            

        },
        created(){

            axios.get('http://localhost:9999/dragonfly/dragonflyList')
            .then( (res)=>{
                this.PageArray =res.data
            })
        }
}
</script>