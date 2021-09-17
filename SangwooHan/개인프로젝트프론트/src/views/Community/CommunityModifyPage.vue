<template>
    <div>
        <v-container>
    <community-modify-page-form @submit="OnSubmit" v-if="board" :board="board"/>
        
     <p v-else> 공사중입니다</p>
     </v-container>
   <!-- <v-btn @click="checking">체킹boardNo</v-btn> -->

    
    </div>
</template>

<script>


import axios from 'axios'
import CommunityModifyPageForm from '../../components/Community/CommunityModifyPageForm.vue'
export default {
  components: { CommunityModifyPageForm },
    name: 'CommunityModifyPage',
    comments: {
     
    },
    props: {
        board: {
            type: Object,
           required: true
        }
    },
    data(){
        return{
         
        }
    },
    methods: {
       OnSubmit(payload) {
           const {text} = payload
           axios.post(`http://localhost:9999/jpaBoard/Modify/${this.board.boardNo}`, {text})
           .then(() => {
               alert('수정완료' ) 

               this.$router.back()
           }).catch(err =>{
                alert(err.response.data.message)
           })
       },
       checking() {
           console.log(this.board)
       }
       
       
       
    }
}
</script>