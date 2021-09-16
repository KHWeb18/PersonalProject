<template>
  <div>
    <board-modify-form :board="board" :board-no="boardNo" @submit="onSubmit"/>
  </div>
</template>

<script>
import BoardModifyForm from '@/components/board/BoardModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
  name: 'BoardModifyPage',
  components: {
    BoardModifyForm
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions(['fetchBoard']),
    onSubmit (payload) {
      const { title, content, link } = payload
      axios.put(`http://localhost:7777/board/${this.boardNo}`, { title, content, link })
          .then(res => {
            alert('수정 성공!')
            console.log(res)
            this.$router.push({
              name: 'BoardListPage',
            })
          })
          .catch(err => {
            alert(err.response.data.message)
          })
    }
  },
  created () {
    this.fetchBoard(this.boardNo)
        .catch(err => {
          alert(err.response.data.message)
          this.$router.back()
        })
  }
}
</script>
