<template>
    <div>
        <h2>마이페이지 게시판 읽기</h2>
        <my-page-board-read-form v-if="myBoard" :myBoard="myBoard"/>
        <p v-else>로딩중....</p>
    </div>
</template>

<script>


import { mapState, mapActions } from 'vuex'
import MyPageBoardReadForm from '../../components/my/MyPageBoardReadForm.vue'



export default {
  components: { MyPageBoardReadForm },
    name: 'MyPageBoardDetail',

    data(){
        return {
            
        }
    },
    props:{
        boardNo:{
            type: Number,
            required: true
        }
    },

    computed:{ 
        ...mapState(['myBoard'])
    },

    created(){
        this.fetchMyBoard(this.boardNo)
            .catch(err =>{
                alert(err.response.data.message)
                this.$router.push()
            })
        
            
    },
    methods:{
        ...mapActions(['fetchMyBoard'])
    },

    
    
    
    
}
</script>