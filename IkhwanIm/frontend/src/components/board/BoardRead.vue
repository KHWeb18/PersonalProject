<template>
  <div v-if="board">
    <v-card class="mx-auto mt-11"
            max-width="800" min-height="500">
      <v-btn text class="py-8 mb-n8" @click="goBack"><v-icon x-large>keyboard_arrow_left</v-icon></v-btn>
      <v-list-item two-line>
        <v-list-item-content>
          <v-list-item-title class="text-h2 mb-5 font-weight-regular center">
            {{board.title}}
          </v-list-item-title>
          <v-list-item-subtitle align="right">글 번호 : {{board.boardNo}}<br>
            작성일 : {{ board.regDate }}</v-list-item-subtitle>
          <v-list-item-subtitle class="mb-n4"><v-btn text @click="onDelete">delete</v-btn>
            <v-btn text @click="onModify">Edit</v-btn>
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-3" cols="12">
            <v-btn @click="goLink" text target="_blank" class="text-body-2 ml-n5 mt-n2">
              <v-icon>insert_link</v-icon>YouTube Link</v-btn>
            <div class="text-body-1 right">{{ board.link }}</div>
          </v-col>
        </v-row>
      </v-card-text>

      <v-list-item>
        <v-row>
          <v-col class="text-h5 mt-3" cols="12">
            <v-textarea readonly class="text-h6 font-weight-regular my-n2" solo auto-grow rows="4"
                        row-height="50" :value="board.content"></v-textarea>
          </v-col>
        </v-row>
      </v-list-item>

      <v-divider></v-divider>

      <!-- commentRegister if logged on -->

      <board-comment-list :board-no="boardNo"></board-comment-list>
      <v-divider class="mx-5"></v-divider>
      <board-comment-register :board = board></board-comment-register>


    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import {mapState} from "vuex";
import BoardCommentRegister from "./BoardCommentRegister";
import BoardCommentList from "./BoardCommentList";
export default {
  name: "BoardRead",
  components: {BoardCommentList, BoardCommentRegister},
  props: {
    boardNo: {
      type: String,
      required: true
    },
  },
  computed: {
    ...mapState(['board'])
  },
  data () {
    return {
      content: "",
    }
  },
  methods: {
    goLink () {
      if(this.board.link.includes("https://")){
        window.open(this.board.link, '_blank')
      } else {
        window.open("https://" + this.board.link, '_blank')
      }
    },
    onDelete () {
      var input = confirm('Do you want to Delete?');

      if(input) {
        const {boardNo} = this.board
        axios.delete(`http://localhost:7777/board/${boardNo}`)
            .then(() => {
              alert('삭제 성공!')
              this.$router.push({name: 'BoardListPage'})
            })
            .catch(err => {
              alert(err.response.data.message)
            })
      }
    },
    onModify() {
      var input = confirm('Do you want to edit?')
      if(input) {
        this.$router.push({name: 'BoardModifyPage', params: this.boardNo})
      }
    },
    goBack() {
      this.$router.push({ name: 'BoardListPage' })
    },
    comment () {
      const { content } = this
      const { writer, boardNo } = this.board
      axios.post(`http://localhost:7777/comment/register/${boardNo}`, { writer, content })
          .then(res => {
            alert('등록 성공! - ' + res)
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
  }
}
</script>

<style scoped>
.v-list-item{
  min-height: 200px;
}
</style>
