<template>
    <div>
        <v-container>
       <!-- <v-btn @click="check">체크</v-btn> -->
        <v-btn v-if="this.$store.state.User =='관리자'" @click="deleteNotice(notice.boardNo)">삭제</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{notice.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{notice.id}}</th>
            </tr>
            <tr>
                <th aligen="center">분류:{{notice.type1}}</th>
            </tr>
        </table>
       





        <h4>{{notice.text}}</h4>
        <form @submit.prevent="OnSubmit" v-if="commentBox ==1 && this.$store.state.User !=null">
         <table >
          <tr>
              <p>댓글</p>
             <p>{{ui}}</p>
            <v-textarea height="10px" auto-grow outlined v-model="comments">
            </v-textarea>
            <v-btn depressed style="float:right" type="submit"><v-icon>mdi-comment</v-icon></v-btn>
          </tr>
        </table>
        </form>
         <table >

              <tr v-for="(item, index) in notice.authList" :key="notice.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                  <td v-if="Modify == item.noticeCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.noticeCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.noticeCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
    name: 'NoticeReadForm',
    props: {
        notice: {
            type: Object
        }
    },
    computed: {
        ...mapState(['User'])
              },
    methods:{
        ModifyOn(noticeCommentNo){
                    this.commentBox = 0
                this.Modify = noticeCommentNo
        },
        ModifyOFF() {
                 this.commentBox = 1
                this.Modify = null
        },
        check(){
            console.log(this.notice)
             },
        OnSubmit() {
             
             const {ui ,comments} =this
             axios.post(`http://localhost:9999/jpaNotice/noticeComments/${this.notice.boardNo}`, {ui , comments})
             .then( res => {
                 alert('등록성공' + res)
                 this.$router.go()
             }).catch( err => {
                 alert('에러' +  err.response.data.message)
             })
                   },
                  
        CommemtsModify(item){

            console.log(item)
            const {noticeCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaNotice/ModifyComments/${this.notice.boardNo}`,{ui,noticeCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },
        deleteComment(noticeCommentNo){
            
               console.log(noticeCommentNo)
            axios.delete(`http://localhost:9999/jpaNotice/deleteComment/${noticeCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },
        deleteNotice(boardNo){
            axios.delete(`http://localhost:9999/jpaNotice/deleteNotice/${boardNo}`)
            .then( () =>{
                alert('공지가삭제되었습니다.')
                this.$router.push({name: 'NoticeListPage'})
            })
            
        }                             
                              
           },
    data() {

        return{
             ui: this.$store.state.User,
             comments: '',
             Modify: '',
            commentBox: 1
             
        }
    }
}
</script>

<style scoped>
h4{
    height: 1000px;
}
</style>