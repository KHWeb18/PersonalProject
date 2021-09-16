<template>
    <div align="center">
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <v-container>
        <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
        </v-container>
    </div>
</template>

<script>
import BoardModifyForm from '@/components/board/notice/BoardModifyForm'
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
            const { title, content } = payload
            axios.put(`http://localhost:7777/noticeboard/${this.$store.state.temp}`, { title, content })
                    .then(res => {
                        // alert('수정 성공!')
                        this.$router.push({
                            name: 'NoticeBoardListPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message + '제출실패')
                    })
        }
    },
    created () {
        this.fetchBoard(this.$store.state.temp)
                .catch(err => {
                    // alert('this.boardNo 값 :  : ' + this.boardNo)
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script> 