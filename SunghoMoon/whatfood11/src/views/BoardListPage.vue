<template>
    <div id="board">
        <br>
        <br>
        <img src="logo.png" width="300" height="150">
        <br>
        <br>
        <br>
        
      <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        <board-list :boards="boards"/>
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