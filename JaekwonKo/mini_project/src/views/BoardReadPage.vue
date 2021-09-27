<template>
    <div>
        <div class="back">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">



        <div align="center">
            <h2>후기 게시판</h2>
            <board-read v-if="board" :board="board"/>
            <p v-else>로딩중 ...... </p>

            <button @click="onDelete">삭제</button>
            <router-link :to="{ name: 'BoardListPage' }">
                게시물 보기
            </router-link>
        </div>
        </div>
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
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            const { boardNo } = this.board
            axios.delete(`http://localhost:7777/board/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'BoardListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>

<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;
}
h2{
  text-align: center;
    color: gray;
}


</style>