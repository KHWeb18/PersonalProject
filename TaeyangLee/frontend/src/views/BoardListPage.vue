<template>
    <div id="board">
       <v-spacer></v-spacer>
       <div v-if="isAuth">
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>  
       </div>
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
    data() {
        return {
            isAuth: false
        }
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    beforeUpdate () {  
       
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session.auth == '사업자') {
            this.isAuth = true
        
    }
    
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}
</script>