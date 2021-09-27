<template>
     <div>
         <v-btn v-if="Stagbeetle.id == this.$store.state.User" @click="Modifyfing">수정</v-btn>
        <v-container>
        <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{Stagbeetle.title}}</h4><br>
          <p align="left">[{{$moment(Stagbeetle.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{Stagbeetle.vuecount}}]</p>
          <img v-if="Stagbeetle.title == '애사슴벌레'" src="@/assets/상우/박물관/박물관[애사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '털보왕사슴벌레'" src="@/assets/상우/박물관/박물관[털보왕사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '왕사슴벌레'" src="@/assets/상우/박물관/박물관[왕사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '넓적사슴벌레'" src="@/assets/상우/박물관/박물관[넓적사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '참넓적사슴벌레'" src="@/assets/상우/박물관/박물관[참넓적사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '홍다리사슴벌레'" src="@/assets/상우/박물관/박물관[홍다리사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '엷은털왕사슴벌레'" src="@/assets/상우/박물관/박물관[엷은털왕사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '사슴벌레'" src="@/assets/상우/박물관/박물관[사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '원표보라사슴벌레'" src="@/assets/상우/박물관/박물관[원표보라사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '두점박이사슴벌레'" src="@/assets/상우/박물관/박물관[두점박이사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '톱사슴벌레'" src="@/assets/상우/박물관/박물관[톱사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '꼬마넓적사슴벌레'" src="@/assets/상우/박물관/박물관[꼬마넓적사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '제주뿔꼬마사슴벌레'" src="@/assets/상우/박물관/박물관[제주뿔꼬마사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '길쭉꼬마사슴벌레'" src="@/assets/상우/박물관/박물관[길쭉꼬마사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '큰꼬마사슴벌레'" src="@/assets/상우/박물관/박물관[큰꼬마사슴벌레].jpg"/>
        <img v-if="Stagbeetle.title == '다우리아사슴벌레'" src="@/assets/상우/박물관/박물관[다우리아사슴벌레].jpg"/>
        <pre>{{Stagbeetle.text}}</pre>
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

              <tr v-for="(item, index) in Stagbeetle.authList" :key="Stagbeetle.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                 
                <td v-if="Modify == item.stagbeetleCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.stagbeetleCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.stagbeetleCommentNo)">
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
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment);
export default {
    name: 'StagbeetleReadForm',
    props: {
        Stagbeetle: {
            type: Object

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
    methods: {
        Modifyfing(){
              this.$router.push({ name: 'StagbeetleModifyPage', params: {Stagbeetle: this.Stagbeetle}})
        },
        check(){console.log(this.Stagbeetle)},
        ModifyOn(stagbeetleCommentNo){
             this.commentBox = 0
                this.Modify = stagbeetleCommentNo
        },
        ModifyOFF(){
                this.commentBox = 1
                this.Modify = null
        },   
                    CommemtsModify(item){

            console.log(item)
            const {stagbeetleCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/stagbeetle/ModifyComments/${this.Stagbeetle.boardNo}`,{ui,stagbeetleCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(stagbeetleCommentNo){
            
               console.log(stagbeetleCommentNo)
            axios.delete(`http://localhost:9999/stagbeetle/deleteComment/${stagbeetleCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },




        OnSubmit() {
            
            const { ui , comments} =this
            axios.post(`http://localhost:9999/stagbeetle/comments/${this.Stagbeetle.boardNo}`, {ui, comments})
            .then(() =>{
                alert('등록성공')
                this.$router.go()
            }).catch(err=>{alert(err.response.data.meessage)})
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