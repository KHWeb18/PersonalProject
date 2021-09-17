<template>

    <div>
        <notice-list-form :notices="notices"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeListForm from '../../components/Notice/NoticeListForm.vue'
export default {
  components: { NoticeListForm },
    computed: {
        ...mapState(['notices'])
    },
    methods: {
        ...mapActions(['fetchNoticeList'])
    },
    mounted() {
        this.fetchNoticeList()
    },
}
</script>