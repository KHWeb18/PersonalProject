<template>
    <div id="board">
        <h2>FAQ 페이지</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            <v-btn>게시물 작성하기</v-btn>
        </router-link>
        <!-- <board-list/> -->
        <board-list :boards="boards"/>
    </div>
</template>

<script>
// import { mapState, mapActions } from 'vuex'
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