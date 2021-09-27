<template>
    <div>
        <div class="back">
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">


        <div align="center">
            <h2>게시물 수정</h2>
            <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
            <p v-else>로딩중 .......</p>
        </div>

        </div>
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'BoardModifyPage',
    components: {
        BoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onSubmit (payload) {
            const {content } = payload
            axios.put(`http://localhost:7777/board/${this.boardNo}`, { content })
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
    created () {
        this.fetchBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
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