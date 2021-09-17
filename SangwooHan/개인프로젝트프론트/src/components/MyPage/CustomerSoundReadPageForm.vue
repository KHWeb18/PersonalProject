<template>
<v-container >
    <div>
       
         <table>
              <tr>
                <th align="center">글번호[{{CustomerSound.boardNo}}]</th>
            </tr>
            <tr>
                <th align="center">제목[{{CustomerSound.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{CustomerSound.id}}</th>
            </tr>
        </table>
        <h4>{{CustomerSound.text}}</h4>
        <form @submit.prevent="OnSubmit" v-if="commentBox ==1 && this.$store.state.User !=null">
         <table >
             <tr>
                 <th>작성자</th>
                 <input v-model="ui" readonly/>
             </tr>
            <tr><th>댓글</th>
                <textarea v-model="comments"/>
                <button type="submit">등록</button>
            </tr>
        </table>
        <table >

              <tr v-for="(item, index) in CustomerSound.authList" :key="CustomerSound.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td v-if="Modify != item.customerSoundBoardNo">{{item.comments}}</td>
                  <td v-if="Modify == item.customerSoundBoardNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item.customerSoundBoardNo)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.customerSoundBoardNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui ==  User"   @click="ModifyON(item.customerSoundBoardNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
              </tr>
              
           
          </table>
        </form>
      
    </div>
</v-container>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'CustomerSoundReadPageForm',
    props:{
        CustomerSound: {
            type:Object,
            required : true
        }
    },
    data() {
        return{
            ui: this.$store.state.User,
            comments: '',

            commentBox: 1,
            Modify: null

        }
    },
    methods: {
        ModifyON(customerSoundBoardNo){
           
            
                this.Modify = customerSoundBoardNo
                this.commentBox = 1
                
        },
        ModifyOFF(){
            this.Modify = null
            this.commentBox = 1
        },
        OnSubmit() {
                const {ui, comments} =this
            axios.post(`http://localhost:9999/CustomerSound/comment/${this.CustomerSound.boardNo}`,{ui, comments})
            .then(()=> {
                    alert('댓글이 등록되었습니다 ')
                    this.$router.go()
            })
        },
        CommemtsModify(customerSoundBoardNo) {

                const {comments}  = this
                axios.post(`http://localhost:9999/CustomerSound/commentModify/${customerSoundBoardNo}`,{comments})
                .then( () => {
                    alert('댓글이 수정되었습니다.')
                    this.$router.go()
                })
        },
        deleteComment(customerSoundBoardNo) {
                const {comments}  = this
                axios.delete(`http://localhost:9999/CustomerSound/deleteComment/${customerSoundBoardNo}`,{comments})
                .then( () => {
                    alert('댓글이 삭제되었습니다.')
                    this.$router.go()
                })
        }
    },
    computed: {
        ...mapState(['User'])
    }
}
</script>

<style scoped>
table {
  font-weight: bold;
  background: #eee;
}
h4{
    width: 700px;
    height: 700px;
}

</style>