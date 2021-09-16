<template>
<div>
    댓글 <b style="color:#00897B">{{comments.length}}</b>
    <div class="comment_list">
        <div>
            <!-- 댓글 목록 -->
            <div class="post_list">
                <div class="post_card_box">
                    <div class="post_card" v-for="mob in paginatedData" :key="mob.commentNo">
                        <div class="thumbnail">
                            <v-avatar color="black" size="48" >
                                <span><img :src="ImgRequest(mob.writer)" style="width:60px;height:60px;object-fit: cover"></span></v-avatar>
                        </div>
                        <div class="post_box">
                            <div class="post_title">{{ mob.nickname }}</div>
                            <div class="post_reg_date">{{ $moment(mob.regDate).add(-9, 'hours').format('YY-MM-DD HH:mm') }}</div>
                            <div class="post_content">{{ mob.content }}</div>                        
                        </div>
                        <div v-show="mob.writer == writer || writer=='admin01'" class="delete_box"><img src="@/assets/delete-empty.png" 
                            @click="snackbar = true"></div>
                            <!-- 댓글 삭제 클릭시 알림창 -->
                            <div class="text-center">            
                                <v-snackbar v-model="snackbar"
                                :timeout="-1" centered outlined>
                                댓글을 삭제하시겠습니까?
                                    <template v-slot:action="{ attrs }">
                                        <v-btn color="#424242" text v-bind="attrs" @click="[isNameProblem(mob.commentNo), snackbar = false]">
                                        확인</v-btn>
                                        <v-btn color="red" text v-bind="attrs" @click="snackbar = false">
                                        취소</v-btn>
                                    </template>
                                </v-snackbar>
                            </div>
                    </div>
                </div>
                <v-container style="margin-top:20px;">
                    <div class="text-center">
                        <v-pagination class="btn_pagination" v-model="pageNum" :length="pageCount"></v-pagination>
                    </div>
                </v-container>
            </div>
            <!-- 댓글 입력창 -->
            <div class="comment_area">
                <tr>
                    <textarea class="comment_register_box"
                    v-model="content" placeholder="댓글을 입력해주세요" v-on:keyup.enter="submit"></textarea>
                </tr>
                <td class="comment_register_btn">
                    <v-btn color="blue-grey darken-1 white-text" @click="submit">댓글 등록</v-btn>
                </td>
            </div>
        </div>
        
        <!-- 하단 밑줄용 -->
        <v-container class="button_container"></v-container>


        
        </div>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'CommentList',
    data () {
        return {
            content: '',
            writer: this.$store.state.yourId,
            nickname: this.$store.state.yourNickname,
            boardNo: '',
            refresh: 1,
            pageNum: 1,
            pageNumS: 1,
            snackbar: false
        }
    },
    props: {
        comments: {
            type: Array
        },
        pageSize: {
            type: Number,
            required: false,
            default: 10
        }
    },
    computed: {
        pageCount() {
                let listLength = this.comments.length, // 길이
                    listSize = this.pageSize,
                    page = Math.floor(listLength / listSize);
                if (listLength % listSize > 0) 
                    page += 1;
                return page;
        },
        paginatedData() {
            const start = (this.pageNum - 1) * this.pageSize,
            end = start + this.pageSize;
            return this.comments.slice(start, end);
        }
    },
    methods: {
        submit () {
            this.boardNo = this.$store.state.boardNo
            console.log('저장하는 순간 store boardNo 값 : ' + this.boardNo)
            const { boardNo, content, writer, nickname } = this
            axios.post('http://localhost:7777/noticeboard/comment/register', { boardNo, content, writer, nickname } )
                    .then(res => {
                         console.log('코멘트 번호: ' + res.data.boardNo.toString())
                         this.content = ''

                         let listLength = this.comments.length, // 길이
                         listSize = this.pageSize,
                         page = Math.floor(listLength / listSize);
                         if (listLength % listSize >= 0)
                         page += 1;
                         if (page !== 1) {
                             this.pageNum = page
                         }
                         this.refresh += 1
                         const refresh = this.refresh
                         this.$emit('submit', refresh)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        isNameProblem (commentNumero) {
            let commentNo2 = commentNumero
            const commentNo = commentNo2
            axios.delete(`http://localhost:7777/noticeboard/comment/${commentNo}`)
                    .then(() => {
                        this.refresh += 1;
                        const refresh = this.refresh;
                        this.$emit('submit', refresh);                   
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        },
        nextPage() {
                this.pageNum += 1;
        },
        prevPage() {
            this.pageNum -= 1;
        },
        ImgRequest(data) {
            try {
                return require(`../../../../../Mini/Images/profile/${data}.gif`                
                )
            } catch (e) {
                return require(`@/assets/logo.png`)
            }
        }
    }
}

</script>

<style scoped>
.comment_list {
    width:70vw;
    max-width: 1000px;
    margin-top: 10px;
    border-top: #BDBDBD solid 1px;
    padding-top: 20px;
}
.post_list {
    width:70vw;
    max-width: 1000px;
}
.post_card {
    display: flex;
    justify-content: row;
    padding: 20 20 5 5;
    margin-bottom: 20px;
}
.thumbnail {
    margin: 10px 20px 0px 10px;
    height: 40px !important; 
    width: 40px !important; 
}
.thumbnail_img {
    width: 100%;
    height: 100%;
}
.post_box {
    display: flex;
    flex-direction: column;
    width: 60vw;
}
.post_tag {
    color: #0288D1;
    font-weight: bold;
    font-size: 13px;
}
.post_title {
    margin-top: 15px;
    font-size: 17px;
    font-weight: bold;
    color: #424242;
}
.post_content {
    font-size: 15px;
    color: #424242;
}
.post_reg_date {
    font-size: 11px;
    color: #757575;
}
.btn_pagination {
    transform: scale(0.6);
    background-color: transparent;
    box-shadow: none;
}
.v-application.primary {
    background-color: #757575 !important;
    border-color: #757575 !important;
}
.delete_box {
    margin-top: 30px;
    height: 100%;
    display: flex;
    cursor: pointer;
}
.comment_register_box {
    height:150px;
    width:65vw;
    max-width: 1000px;
    border: 1px solid #BDBDBD;    
    padding: 10px;
    margin-left: 20px;
}
.comment_register_btn {
    text-align: right;
    padding: 0px;
    padding-left: 20px;
}
::placeholder {
    font-size: 16px;
    letter-spacing: 0;
    color: #757575;    
}
.button_container {
    width:70vw;
    max-width: 1040px;
    border-top: 1px solid #BDBDBD;
    margin-top: 15px;
}
</style>