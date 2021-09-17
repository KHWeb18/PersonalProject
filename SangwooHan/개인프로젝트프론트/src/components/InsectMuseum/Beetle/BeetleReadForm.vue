<template>
<div>
     <v-btn v-if="Beetle.id == this.$store.state.User" @click="Modifyfing">수정</v-btn>
        <v-container>
        <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{Beetle.title}}</h4><br>
          <p align="left">[{{$moment(Beetle.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{Beetle.vuecount}}]</p>
          <img v-if="Beetle.title == '장수풍뎅이'" src="@/assets/상우/박물관/박물관[장수풍뎅이].jpg"/>
        <img v-if="Beetle.title == '외뿔장수풍뎅이'" src="@/assets/상우/박물관/박물관[외뿔장수풍뎅이].jpg"/>
        <img v-if="Beetle.title == '둥글장수풍뎅이'" src="@/assets/상우/박물관/박물관[둥글장수풍뎅이].jpg"/>
        <img v-if="Beetle.title == '장수풍뎅이유충암수구별법.'" src="@/assets/상우/박물관/박물관[장수암수구별법].jpg"/>
        <img v-if="Beetle.title == '장수풍뎅이의생태'" src="@/assets/상우/박물관/박물관[장수생태1].jpg"/>
        <img v-if="Beetle.title == '장수풍뎅이의생태'" src="@/assets/상우/박물관/박물관[장수생태2].jpg"/>
        <img v-if="Beetle.title == '장수풍뎅이의생태'" src="@/assets/상우/박물관/박물관[장수생태3].jpg"/>
        <pre>{{Beetle.text}}</pre>
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

              <tr v-for="(item, index) in Beetle.authList" :key="Beetle.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                 
                <td v-if="Modify == item.beetleCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.beetleCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.beetleCommentNo)">
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
    name: 'BeetleReadForm',
    props: {
        Beetle: {
            type: Object
        }
    },
    computed:{
    ...mapState(['User'])
    },
    data(){
        return{
            ui: this.$store.state.User,
            comments: '',
            Modify: '',
            commentBox: 1
        }
    },
    methods: {
        Modifyfing(){
              this.$router.push({ name: 'BeetleModifyPage', params: {Beetle: this.Beetle}})
        },
        ModifyOn(beetleCommentNo){
                    this.commentBox = 0
                this.Modify = beetleCommentNo               
        },
        ModifyOFF(){
                 this.commentBox = 1
                this.Modify = null
        },

                CommemtsModify(item){

            console.log(item)
            const {beetleCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/beetle/ModifyComments/${this.Beetle.boardNo}`,{ui,beetleCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                  deleteComment(beetleCommentNo){
            
               console.log(beetleCommentNo)
            axios.delete(`http://localhost:9999/beetle/deleteComment/${beetleCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                                },                   


        OnSubmit() {
                const {ui ,comments } = this
                axios.post(`http://localhost:9999/beetle/comments/${this.Beetle.boardNo}`, {ui, comments})
                .then( res=> {
                    alert('등록성공'+ res)
                    this.$router.go()
                }).catch(err=> {
                    alert(err.response.data.message)
                })
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