<template>
    <div>
        <h3 align="center">Commnity</h3>
     <!--
             <v-data-table :headers="headerTitle"  
                    :items="boards" 
                    :items-per-page="10"
                    item-key="boardNo"
                
                   class="elevation-10" @click:row="handleClick"> 
         </v-data-table>-->
    <community-list-new-form :listArray="PageArray"/>
        
       
     
    </div>
</template>

<script>
import axios from 'axios'
import CommunityListNewForm from './CommunityListNewForm.vue'
export default {
    name: 'CommunityListForm',
    props: {
        boards: {
            type: Array
        }
    },
    components:{
        CommunityListNewForm
    },
    created(){

        axios.get('http://localhost:9999/jpaBoard/boardlists/')
        .then( (res) =>{
            this.PageArray = res.data
        })
    },
    data() {
        return{
            PageArray: [],

        }
    }
    
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+SC:wght@300;900&display=swap');
h3{
font-family: 'Noto Sans SC', sans-serif;
    
}
</style>