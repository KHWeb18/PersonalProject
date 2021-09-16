<template>
    <div>
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <v-container>
            <board-read v-if="board" :board="board"/>
            <p v-else>로딩중 ......</p>
            <v-container class="middle_btn_box">
                <router-link :to="{ name: 'FreeBoardListPage' }">
                        목록
                </router-link>                
                <b v-show="board.writer == this.$store.state.yourId || this.$store.state.isAuth">
                    <router-link :to="{ name: 'FreeBoardModifyPage', params: { boardNo } }">
                        |수정
                    </router-link>
                </b>               
                <b v-show="board.writer == this.$store.state.yourId || this.$store.state.isAuth" @click="snackbar = true" class="item">
                    |삭제
                </b>
                 <!-- 게시물 삭제 클릭시 알림창 -->
                <div class="text-center">            
                    <v-snackbar v-model="snackbar"
                    :timeout="-1" centered outlined>
                    게시물을 삭제하시겠습니까?
                        <template v-slot:action="{ attrs }">
                            <v-btn color="#424242" text v-bind="attrs" @click="[onDeletePost(), snackbar = false]">
                            확인</v-btn>
                            <v-btn color="red" text v-bind="attrs" @click="snackbar = false">
                            취소</v-btn>
                        </template>
                    </v-snackbar>
                </div>
            </v-container>
            <comment-list v-if="comments" :comments="comments" @submit="onSubmit"/>
            <p v-else>로딩중 ......</p>            
        </v-container>        
    </div>
</template>

<script>
import BoardRead from '@/components/board/free/BoardRead.vue'
import CommentList from '@/components/board/free/CommentList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        },
        boardNumber: null
    },
    data () {
        return {
            refreshCheck: 1,
            snackbar: false
        }
    },
    components: {
        BoardRead,
        CommentList
    },
    watch: {
        refreshCheck(newVal) {
            if(newVal >= 0) {
                // console.log('refreshCheck값은 : ' + this.refreshCheck)
            // console.log('댓글 입력 감지')
            this.fetchFreeCommentList(this.boardNo)
            this.refreshCheck = 1
            }
        }
    },
    computed: {
        ...mapState(['board']),
        ...mapState(['comments'])
    },    
    created () {
        this.fetchFreeBoard(this.boardNo)
         .then(() => {
                        // console.log('저장하기 전 store의 게시물 번호는 : ' + this.$store.state.boardNo)
                        // console.log('읽고있는 게시물 번호는 : ' + this.boardNo)
                    })
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    mounted () {
        this.fetchFreeCommentList(this.boardNo)  
    },
    methods: {
        ...mapActions(['fetchFreeBoard']),
        onDeletePost () {
                        const { boardNo } = this.board
            axios.delete(`http://localhost:7777/freeboard/${boardNo}`)
                    .then(() => {
                        this.$router.push({ name: 'FreeBoardListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)                                                
                    })
        },
        ...mapActions(['fetchFreeCommentList']),
        onSubmit (payload) {
            const refresh = payload
            this.refreshCheck = refresh
        }
    }
}
</script>

<style scoped>
.item_list {
    margin-top: 10px;
    display: flex;
}
.button_box {    
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
}
.v-btn {
    margin-right: 10px;
}
.middle_btn_box {    
    width:70vw;
    max-width: 1000px;
    text-align: center;
    margin: 0px;
    color: #757575 !important;
    font-weight: bold;
}
.v-application a {
    color: #757575 !important;
    font-weight: bold;
}
.item {
    cursor: pointer;
}
    
</style>