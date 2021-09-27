<template>
  <v-card max-width="95%" class="mx-auto" elevation="0">

    <div v-for="(item,idx) in comments" :key="idx">

      <!-- delete btn -->
      <v-btn @click="deleteComment(item)" v-if="item.writer === checkUser || checkUser === admin"
             v-show="item.content !== deleted" text class="right deleteBtn mt-1">
        <v-icon>close</v-icon>delete</v-btn>

      <v-card-title class="text-subtitle-1 font-weight-bold">{{ item.writer }}</v-card-title>
      <v-card-text class="grey--text mt-n5">{{ item.regDate }}</v-card-text>
      <v-card-text class="text-body-1 mt-n2 mb-1 font-weight-light black-text">{{ item.content }}</v-card-text>

      <v-btn text v-if="checkUser" @click="onReply(item.commentNo), showIt = !showIt">reply</v-btn>
      <v-divider></v-divider>
      <comment-reply :comment="item" :replies="replies" v-if="showIt && comment"
                     v-show="showReply(item.commentNo)"></comment-reply>
    </div>

  </v-card>
</template>

<script>
import {mapActions, mapState} from "vuex";
import axios from "axios";
import CommentReply from "./CommentReply";
export default {
  name: "BoardCommentList",
  components: {CommentReply},
  props: {
    boardNo: {
      type: String,
      required: true
    },
  },
  computed: {
    ...mapState(["comments","comment","board","session","replies"]),
    checkUser() {
      let temp
      if(this.session !== null) {
        temp = this.session.member_id
      } else {
        temp = null
      }
      return temp
    }
  },
  data () {
    return {
      memberCheck : false,
      content : "삭제된 댓글입니다",
      deleted : "삭제된 댓글입니다",
      admin : "admin",
      replyOn: false,
      showIt: false,
    }
  },
  mounted() {
    this.fetchCommentList(this.boardNo)
  },
  methods: {
    ...mapActions(["fetchCommentList","fetchComment","fetchReplies"]),
    deleteComment(item) {
      const { content } = this
      axios.put(`http://localhost:7777/comment/${item.commentNo}`, { writer : item.writer, content })
          .then(() => {
            alert('삭제 성공!')
            //window.location.reload();
            this.fetchCommentList(this.boardNo)
          })
          .catch(err => {
            alert(err.response.data.message)
          })
    },
    onReply(value) {
      this.fetchComment(value)
      this.fetchReplies(value)
    },
    showReply(value){
      if(this.comment.commentNo === value) {
        return true
      } else {
        return false
      }
    }
  }
}
</script>

<style scoped>
.v-list-item{
  min-height: 200px;
}
</style>
