<template>
    <div>
         <v-btn v-if="board.id == User" @click="Modifyfing">수정</v-btn>
        <v-container>
            <!--
      <v-btn v-if="board.id == User" @click="Modifyfing">수정</v-btn>
        <table border="1">
            <tr>
           <h4 style="text-align:left;">{{board.title}}</h4>
           <h6 align="left">{{board.id}} </h6>
           <p align="left">{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.vuecount}}</p>
            </tr>
            <tr>
                <pre align="left">{{board.text}}</pre>
            </tr>
        </table>
       -->
       
    <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{board.title}}</h4><br>
          <p align="left">[{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.vuecount}}]</p>
        <pre>{{board.text}}</pre>
      </v-col>
    </v-row>
  
        
        <form v-if="commentBox ==1 && this.$store.state.User !=null" @submit.prevent="OnSubmit">
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

              <tr v-for="(item, index) in board.authList" :key="board.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                 
                <td v-if="Modify == item.boardCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.boardCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.boardCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
        <!--
        <td>
         <v-btn @click="checkingman(item.boardCommentNo)">
             체크
        </v-btn>
        </td>
        -->
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment);
export default {
    name: 'CommunityReadForm',
    props:{
        board: {
            type: Object
        }
    },
    computed:{
       ...mapState(['User'])
    },
    created(){
         
    },
    methods: {
        check() {
            console.log(this.board)
           },

        ModifyOn(boardCommentNo){

                this.commentBox = 0
                this.Modify = boardCommentNo

                                },

        ModifyOFF(){

                this.commentBox = 1
                this.Modify = null

                   },

        OnSubmit() {

                const {ui , comments } = this
                axios.post(`http://localhost:9999/jpaBoard/comment/${this.board.boardNo}`, {ui, comments})
                .then( res => {
                    alert('등록성공' +res) 
                    this.$router.go()
                }).catch(err => {
                    alert(err.response.data.message)
                })

                  },

        CommemtsModify(item){

            console.log(item)
            const {boardCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaBoard/ModifyComments/${this.board.boardNo}`,{ui,boardCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                            },
        
        deleteComment(boardCommentNo){
            
               console.log(boardCommentNo)
            axios.delete(`http://localhost:9999/jpaBoard/deleteComment/${boardCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },

        checkingman(value) {
                console.log(value)
                          },
        Modifyfing(){
            this.$router.push({ name: 'CommunityModifyPage', params: {board: this.board}})
        },
          appendIconCallback () {},
      prependIconCallback () {},
    },
    data() {

        return {

            comments: '',
            ui: this.$store.state.User,
            Modify: '',
            commentBox: 1,
            text: ''

               }
           },

    
  
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&family=Noto+Serif+KR:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+SC:wght@300&display=swap');
pre{
    width: 1000px;
    height: 700px;
    border-block: 1px;
}
h4{
   font-family: 'Noto Serif KR', serif;
}

P{
    font-family: 'Oswald', sans-serif;
}
pre{
font-family: 'Noto Sans SC', sans-serif;
}
#input-usage .v-input__prepend-outer,
  #input-usage .v-input__append-outer,
  #input-usage .v-input__slot,
  #input-usage .v-messages {
    border: 1px dashed rgba(0,0,0, .4);
  }


</style>