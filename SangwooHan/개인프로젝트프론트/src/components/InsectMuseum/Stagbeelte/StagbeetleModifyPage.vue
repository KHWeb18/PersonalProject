<template>
    <div>
          <form @submit.prevent="onSubmit">
              <v-container>
                <table>
                    <tr>
                        <td>조회수</td>
                        <td><input type="text" :value="vuecount" readonly/></td>
                    </tr>
                    <tr>
                        <td>게시글번호</td>
                        <td><input type="text" :value="boardNo" readonly/></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" v-model="id" readonly/></td> 
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" v-model="title" ></td> 
                    </tr>
                     <tr>
                        <td>내용</td>
                      <textarea  id="contentText" cols="30" rows="10" v-model="text" ></textarea>
                    </tr>
                </table>
               <!-- <v-btn @click="check">폼체크</v-btn>-->
                <v-btn type="submit">수정하기</v-btn>
              </v-container>
                </form>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'CommunityModifyPageForm',
    props: {
        Stagbeetle: {
            type: Object
        }
    },
    data(){
        return{
            id: this.Stagbeetle.id,
            title: this.Stagbeetle.title,
            text: this.Stagbeetle.text,
            createDate: this.Stagbeetle.createDate,
            boardNo: this.Stagbeetle.boardNo,
            vuecount: this.Stagbeetle.vuecount
        }
    },
    methods: {
      onSubmit() {
           
          const {text}= this
         axios.post(`http://localhost:9999/stagbeetle/Modify/${this.Stagbeetle.boardNo}`, {text})
           .then(() => {
               alert('수정완료' ) 

               this.$router.back()
           }).catch(err =>{
                alert(err.response.data.message)
           })
          
      },
      check() {
          console.log(this.boardNo)
      }

    }
}
</script>

<style scoped>
#contentText {
    border-style: ridge;
    border: 1px;
    width: 800px;
    height: 800px;
}
</style>