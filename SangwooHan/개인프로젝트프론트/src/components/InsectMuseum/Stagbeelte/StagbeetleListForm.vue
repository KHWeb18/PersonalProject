<template>
    <div>
        <img src="@/assets/상우/한국사슴벌레.jpg"/>
        <!--
  <v-data-table :headers="headerTitle"  
                    :items="(StagbeetleList)" item-key="boardNo"
                    :items-per-page="10"
                    
                
                    @click:row="handleClick"> 
         </v-data-table>
         -->
         <stagbeetle-list-new-form :listArray="pageArray"/>
    </div>
</template>

<script>
import axios from 'axios'
import StagbeetleListNewForm from '../Stagbeelte/StagbeetleListNewForm.vue'
export default {
    name: 'StagbeetleListForm',
    components:{
                StagbeetleListNewForm
    },
    data(){ 
        return{
            headerTitle: [
                 {text: '번호', value: 'boardNo', width: '80px'},
                {text: '제목', value: 'title', width: '200px'},
                {text: '작성자', value: 'id', width: '150px'},
                {text: '조회수', value: 'vuecount', width: '100'},
                {text: '등록일자', value: 'createDate', width: '100'},
            ],
            pageArray: [],
        }
    },
    methods: {
        /*
        handleClick(value){
            console.log(value)
                    this.$router.push({ name: 'StagbeetleReadPage',params:{ boardNo: value.boardNo.toString()}})

                   axios.post(`http://localhost:9999/stagbeetle/vuecount/${value.boardNo}`)
                  .then( () => {

               })
        }
        */
       
    },
    created(){
        axios.get('http://localhost:9999/stagbeetle/stagbeetleList')
        .then( (res) => {
            this.pageArray = res.data
        })
    }
}
</script>