<template>
  <v-card color="grey lighten-5" max-width="95%" class="mx-auto" elevation="0">
    <div v-for="(item,idx) in replies" :key="idx">

      <!-- delete btn -->
      <v-btn @click="deleteReply(item)" v-if="item.writer === checkUser || checkUser === admin"
             v-show="item.content !== deleted" text class="right deleteBtn mt-1">
        <v-icon>close</v-icon>delete</v-btn>

      <v-card-title class="text-subtitle-1 font-weight-bold">{{ item.writer }}</v-card-title>
      <v-card-text class="grey--text mt-n5">{{ item.regDate }}</v-card-text>
      <v-card-text class="text-body-1 mt-n2 mb-1 font-weight-light black-text">{{ item.content }}</v-card-text>

      <v-divider></v-divider>

    </div>

  <v-card-actions>
    <v-textarea @focus="setWriter" solo auto-grow class="mt-8 ml-5 mr-10"
                rows="3" row-height="20" placeholder="Reply to Comment"
                v-model="content"></v-textarea>

    <v-btn @click="registerReply" v-show="content" text class="py-9">Submit</v-btn>
  </v-card-actions>

  </v-card>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";

export default {
  name: "CommentReply",
  props: {
    comment: {
      type: Object,
      required: true,
    },
    replies: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      content: '',
      writer: '',
      deleted : "삭제된 댓글입니다.",
      admin: 'admin',
    }
  },
  computed: {
    ...mapState(['session']),
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
  methods: {
    ...mapActions(["fetchReplies"]),
    registerReply() {
      const { writer, content } = this
      const { commentNo } = this.comment
      axios.post(`http://localhost:7777/reply/register/${commentNo}`, { writer, content })
          .then(() => {
            alert('reply complete')
            this.fetchReplies(this.comment.commentNo)
            this.content = ""
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    setWriter() {
      const temp = this.$store.state.session.member_id
      this.writer = temp
    },
    deleteReply(item) {
      //const { content } = this
      axios.put(`http://localhost:7777/reply/${item.replyNo}`,
          { writer : item.writer, content : "삭제된 댓글입니다."})
          .then(() => {
            alert('삭제 성공!')
            //window.location.reload();
            this.fetchReplies(this.comment.commentNo)
          })
          .catch(err => {
            alert(err.response.data.message)
          })
    },
  }
}
</script>

<style scoped>

</style>
