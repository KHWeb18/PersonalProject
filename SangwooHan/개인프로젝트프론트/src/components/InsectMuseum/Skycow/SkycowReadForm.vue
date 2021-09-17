<template>
  <div>
         <v-btn v-if="Skycow.id == this.$store.state.User" @click="Modifyfing">수정</v-btn>
        <v-container>
        <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{Skycow.title}}</h4><br>
          <p align="left">[{{$moment(Skycow.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{Skycow.vuecount}}]</p>
         <img v-if="Skycow.title == '루리하늘소'" src="@/assets/상우/박물관/박물관[루리하늘소].jpg"/>
        <img v-if="Skycow.title == '고운산하늘소'" src="@/assets/상우/박물관/박물관[고운산하늘소].jpg"/>
        <img v-if="Skycow.title == '무늬소주홍하늘소'" src="@/assets/상우/박물관/박물관[무늬소주홍하늘소].jpg"/>
        <img v-if="Skycow.title == '애호랑하늘소'" src="@/assets/상우/박물관/박물관[애호랑하늘소].jpg"/>
        <img v-if="Skycow.title == '우리목하늘소'" src="@/assets/상우/박물관/박물관[우리목하늘소].jpg"/>
        <img v-if="Skycow.title == '노란팔점긴하늘소'" src="@/assets/상우/박물관/박물관[노란팔점긴하늘소1].jpg"/>
        <img v-if="Skycow.title == '노란팔점긴하늘소'" src="@/assets/상우/박물관/박물관[노란팔점긴하늘소2].jpg"/>
        <img v-if="Skycow.title == '봄산하늘소'" src="@/assets/상우/박물관/박물관[봄산하늘소].jpg"/>
        <img v-if="Skycow.title == '장수하늘소'" src="@/assets/상우/박물관/박물관[장수하늘소1].jpg"/>
        <img v-if="Skycow.title == '장수하늘소'" src="@/assets/상우/박물관/박물관[장수하늘소2].jpg"/>
        <pre>{{Skycow.text}}</pre>
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

              <tr v-for="(item, index) in Skycow.authList" :key="Skycow.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                 
                <td v-if="Modify == item.skycowCommentsNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.skycowCommentsNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.skycowCommentsNo)">
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
    name: 'SkycowReadForm',
    props:{
        Skycow: {
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
    methods:{
        Modifyfing(){
              this.$router.push({ name: 'SkycowModifyPage', params: {Skycow: this.Skycow}})
        },
        ModifyOn(skycowCommentsNo){
                this.commentBox = 0
                this.Modify = skycowCommentsNo
        },
        ModifyOFF(){
                this.commentBox = 1
                this.Modify = null
        },

                                CommemtsModify(item){

            console.log(item)
            const {skycowCommentsNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/skycow/ModifyComments/${this.Skycow.boardNo}`,{ui,skycowCommentsNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(skycowCommentsNo){
            
           
            axios.delete(`http://localhost:9999/skycow/deleteComment/${skycowCommentsNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },



        checking(){
                console.log(this.Skycow)
        },
        OnSubmit() {
            const {ui , comments} = this

            axios.post(`http://localhost:9999/skycow/comments/${this.Skycow.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
                this.$router.go()
            }).catch(err => {alert(err.response.data.message)})
        },
        
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