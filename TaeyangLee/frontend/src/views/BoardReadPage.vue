<template>
    <div align="center">
        
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ...... </p>
      <div v-if="isAuth">
        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
       
        <button @click="onDelete">삭제</button>
      </div>
        <router-link :to="{ name: 'BoardListPage' }">
            목록
        </router-link>
      
    </div>
</template>

<script>
import BoardRead from '@/components/board/BoardRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            isAuth: false
        }
    },
    components: {
        BoardRead
    },
    computed: {
        ...mapState(['board'])
    },
    created () {
        
        this.fetchBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    beforeUpdate () {  
       
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session.auth == '관리자') {
            this.isAuth = true
        
    }
    
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            const { boardNo } = this.board
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                .then(() => {
                    alert("삭제 성공!")
                    this.$router.push({name: 'BoardListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        },
        onSubmit (payload) {
            const { nowfunding } = payload
            axios.put(`http://localhost:7777/vueboard/${this.boardNo}`, { nowfunding })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    
    
    
}
</script>