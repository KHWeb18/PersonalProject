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
import BoardModifyForm from '@/components/board/free/BoardModifyForm'
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
        ...mapActions(['fetchFreeBoard']),
        onSubmit (payload) {
            const { title, content } = payload
            axios.put(`http://localhost:7777/freeboard/${this.boardNo}`, { title, content })
                    .then(res => {
                        this.$router.push({
                            name: 'FreeBoardListPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchFreeBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script> 