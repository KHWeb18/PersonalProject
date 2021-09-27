<template>
<div> 
      <v-btn v-if="Butterfly.id == this.$store.state.User" @click="Modifyfing">수정</v-btn>
        <v-container>
        <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{Butterfly.title}}</h4><br>
          <p align="left">[{{$moment(Butterfly.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{Butterfly.vuecount}}]</p>
         <img v-if="Butterfly.title == '눈나비'" src="@/assets/상우/박물관/박물관[눈나비].jpg"/>
        <img v-if="Butterfly.title == '여름어리표범나비'" src="@/assets/상우/박물관/박물관[여름어리표범나비].jpg"/>
        <img v-if="Butterfly.title == '홍줄나비'" src="@/assets/상우/박물관/박물관[홍줄나비].jpg"/>
        <img v-if="Butterfly.title == '상제나비'" src="@/assets/상우/박물관/박물관[상제나비].jpg"/>
        <img v-if="Butterfly.title == '푸른부전나비'" src="@/assets/상우/박물관/박물관[푸른부전나비].jpg"/>
        <img v-if="Butterfly.title == '들신선나비'" src="@/assets/상우/박물관/박물관[들신선나비1].jpg"/>
        <img v-if="Butterfly.title == '들신선나비'" src="@/assets/상우/박물관/박물관[들신선나비2].jpg"/>
        <img v-if="Butterfly.title == '남방제비나비'" src="@/assets/상우/박물관/박물관[남방제비나비].jpg"/>
        <img v-if="Butterfly.title == '담색긴꼬리나비'" src="@/assets/상우/박물관/박물관[담색긴꼬리나비].jpg"/>
        <img v-if="Butterfly.title == '사향제비나비'" src="@/assets/상우/박물관/박물관[사향제비나비].jpg"/>
        <img v-if="Butterfly.title == '작은녹색부전나비'" src="@/assets/상우/박물관/박물관[작은녹색부전나비].jpg"/>
        <img v-if="Butterfly.title == '산녹색부전나비'" src="@/assets/상우/박물관/박물관[산녹색부전나비].jpg"/>
        <img v-if="Butterfly.title == '작은주홍부전나비'" src="@/assets/상우/박물관/박물관[작은주홍부전나비].jpg"/>
        <img v-if="Butterfly.title == '왕나비'" src="@/assets/상우/박물관/박물관[왕나비].jpg"/>
        <img v-if="Butterfly.title == '호랑나비'" src="@/assets/상우/박물관/박물관[호랑나비].jpg"/>
        <pre>{{Butterfly.text}}</pre>
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

              <tr v-for="(item, index) in Butterfly.authList" :key="Butterfly.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                 
                <td v-if="Modify == item.butterflyCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.butterflyCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.butterflyCommentNo)">
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
    name: 'ButterflyReadPage',
    props: {
        Butterfly: {
            type: Object,

        }
    },
    computed:{
       
        ...mapState(['User'])
    },
    data() {
        return{
            ui: this.$store.state.User,
            comments: '',
            Modify: '',
            commentBox: 1
        }
    },
    methods:{
         Modifyfing(){
              this.$router.push({ name: 'ButterflyModifyPage', params: {Butterfly: this.Butterfly}})
        },
        check(){
                console.log(this.Butterfly)
        },
        ModifyOn(butterflyCommentNo){
                  this.commentBox = 0
                this.Modify = butterflyCommentNo   
        },
        ModifyOFF(){
                this.commentBox = 1
                this.Modify = null
        },
                        CommemtsModify(item){

            console.log(item)
            const {butterflyCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/butterfly/ModifyComments/${this.Butterfly.boardNo}`,{ui,butterflyCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },


                              deleteComment(butterflyCommentNo){
            
              
            axios.delete(`http://localhost:9999/butterfly/deleteComment/${butterflyCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },




        OnSubmit() {
            const {ui , comments} = this

            axios.post(`http://localhost:9999/butterfly/comments/${this.Butterfly.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
                this.$router.go()
            }).catch(err => {alert(err.response.data.message)})
        }
    }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&family=Noto+Serif+KR:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+SC:wght@300&display=swap');

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