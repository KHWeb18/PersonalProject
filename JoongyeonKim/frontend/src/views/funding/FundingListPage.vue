<template>
    <div id="funding">
        <funding-list-form :fundings="fundings"/>
    </div>
</template>

<script>

import FundingListForm from '@/components/funding/FundingListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'FundingListPage',
    components: {
        FundingListForm
    },
    computed: {
        ...mapState(['fundings'])
    },
    mounted () {
        this.fetchFundingList()
    },
    methods: {
        ...mapActions(['fetchFundingList'])
        
    }
}

</script>