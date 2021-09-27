<template>
    <div id="member">
        <h2>사이트 회원 목록</h2>
       <member-list-form :members="members"/>
    </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'
import MemberListForm from '@/components/member/MemberListForm.vue'

export default {
    name: 'MemberListPage',
    components: {
        MemberListForm
    },
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList()
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    }
}

</script>