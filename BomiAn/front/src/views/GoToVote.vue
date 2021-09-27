<template>
  <div>
    <vote-component v-bind:board="board"
                    v-on:voteOp1="voteOp1"
                    v-on:voteOp2="voteOp2"
    ></vote-component>
    <comment-component v-bind:comments="comments"
                      v-on:deleteComment="deleteComment"
                      v-on:insertComment="insertComment"

    ></comment-component>
  </div>
</template>

<script>
import VoteComponent from '../components/VoteComponent.vue'
import CommentComponent from '../components/CommentComponent.vue'
export default {
  components: {
    VoteComponent,
    CommentComponent,
  },
  data() {
    return {
      board: {},
      comments: [],
    }
  },
  created() {    
    this.getBoardDetail();
    this.getCommentsList();
  },
  mounted() {
      if(this.$store.state.user == null) {
      this.$router.push('/')
      alert('로그인 후 이용해주세요.')
    }
  },
  methods: {
    getBoardDetail() {
      const id = this.$route.params.id
      this.$http.get(`/api/getBoardDetail/${id}`)
          .then(res => {
            this.board = res.data 
          })
    },
    voteOp1(id) {
      let vote = {
        b_no: id,
        u_no: this.$store.state.user.no
      }
      this.$http.post('/api/vote/option1', {vote: vote})
          .then(res => {
            if(res.data.success == true) {
              alert(res.data.message)
              this.getBoardDetail();
            } else {
              alert(res.data.message)
            }
          })
    },
    voteOp2(id) {
      let vote = {
        b_no: id,
        u_no: this.$store.state.user.no
      }
      this.$http.post('/api/vote/option2', {vote: vote})
          .then(res => {
            if(res.data.success == true) {
              alert(res.data.message)
              this.getBoardDetail();
            } else {
              alert(res.data.message)
            }
          })
    },
    getCommentsList() {
       const id = this.$route.params.id
       this.$http.get(`/api/getCommentsList/${id}`)
            .then(res => {
              this.comments = res.data
              console.log(res.data);
            })
    },
    deleteComment(id) {
      this.$http.post(`/api/deleteComment/${id}`)
                .then(res => {
                  console.log(res.data);
                  alert('삭제가 완료되었습니다!')
                  this.getCommentsList();
                })
    },
    insertComment(comment) {
      this.$http.post('/api/insertComment', {comment: comment})
          .then(res => {
            console.log(res);
            this.getCommentsList();
          })
    }
  },
  
}
</script>