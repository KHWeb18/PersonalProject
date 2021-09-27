<template>
    <div>
        <notice-read-form v-if="notice" :notice="notice"/>
        <p v-else>공지조회에 실패하였습니다.</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeReadForm from '../../components/Notice/NoticeReadForm.vue'
export default {
  components: { NoticeReadForm },
    name: 'NoticeReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['notice'])
    },
    methods: {
        ...mapActions(['fetchNotice'])
    },
    created(){
        this.fetchNotice(this.boardNo)
    }
}
</script>