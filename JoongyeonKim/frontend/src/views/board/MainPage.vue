<template>
    <div align="center">
        <main-form :fundings="fundings"/>
    </div>
</template>

<script>

import MainForm from '@/components/board/MainForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'MainPage',
    components: {
        MainForm
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