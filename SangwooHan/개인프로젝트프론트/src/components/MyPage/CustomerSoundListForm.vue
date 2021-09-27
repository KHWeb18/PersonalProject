<template>

    <div style="max-width:1300px;">
        <v-data-table
        :headers="headerTitle"
        :items="CustomerSoundList"
        item-key="boardNo"
         :items-per-page="10"
        @click:row="handleClick">
        </v-data-table>
    </div>

</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'CustomerSoundListForm',
    computed:{
        ...mapState(['CustomerSoundList'])
    },
    methods:{
        ...mapActions(['fetchCustomerSoundList']),
        handleClick(value) {
               this.$router.push({ name: 'CustomerSoundReadPage',params: {boardNo: value.boardNo}})

               axios.post(`http://localhost:9999/CustomerSound/vuecount/${value.boardNo}`)
               .then(() =>{

               })
        }
    },
    mounted(){
        this.fetchCustomerSoundList()
    },
    data() {

        return{
            headerTitle: [
                  {text: '번호', value: 'boardNo', width: '80px'},
                {text: '제목', value: 'title', width: '200px'},
                {text: '작성자', value: 'id', width: '150px'},
                {text: '조회수', value: 'vuecount', width: '100'},
                {text: '등록일자', value: 'createDate', width: '100'},
            ]
        }
    }
}
</script>

<style scoped>
div{
  
}
</style>