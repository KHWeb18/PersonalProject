<template>
  <div>
      <h3 align="center">Recommend Us Videos</h3>
      <div align="right" class="mb-3 mr-2"><v-btn @click="recommend">Post Recommendation</v-btn></div>
    <!--<board-list :boards="boards"/>-->
    <board-list :boards="boards"></board-list>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import BoardList from "../../components/board/BoardList";
export default {
  name: 'BoardListPage',
  components: {
    BoardList,
    //BoardList
  },
  computed: {
    ...mapState(['boards', 'session'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList']),
    recommend() {
      if(this.session !== null) {
        this.$router.push('/board/create')
      }else{
        alert("로그인 바랍니다!")
      }
    }
  }
}
</script>
