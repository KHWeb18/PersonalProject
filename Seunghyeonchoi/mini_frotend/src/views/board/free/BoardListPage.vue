<template>
    <div id="board_padding">
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <v-container>
            <board-list :boards="boards"/>
        </v-container>
    </div>
</template>

<script>

import BoardList from '@/components/board/free/BoardList.vue'
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
        this.fetchFreeBoardList()
    },
    methods: {
        ...mapActions(['fetchFreeBoardList'])
        
    }
}

</script>

<style scoped>
.board_title {
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
    margin-bottom: 60px;
    margin-top: 70px;
}
</style>