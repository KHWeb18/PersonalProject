<template>
  <div>
    <div class="back">
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">

    <div id="board">
        <h2>후기 게시판</h2>
        <div class="d">
        <board-list :boards="boards"/>
                <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        </div>
    </div>

         
    </div>
  </div>
</template>

<script>

import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'BoardListPage',
   components: {
        BoardList
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}
</script>

<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;
}
h2{
  text-align: center;
  color: gray;
}
.d{
 font-size: 1.1em;
}


</style>
