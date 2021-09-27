<template>
    <div align="center">
        <h2>프로젝트 수정</h2>            
        <funding-modify-form v-if="funding" :funding="funding" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>                
    </div>
</template>

<script>

import FundingModifyForm from '@/components/funding/FundingModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'FundingModifyPage',
    components: {
        FundingModifyForm
    },
    props: {
        fundingNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['funding'])
    },
    methods: {
        ...mapActions(['fetchFunding']),
        onSubmit (payload) {
            const { writer, category, title, image,  content, summary, fundingEnd, endMoney, nowMoney } = payload
            axios.put(`http://localhost:7777/funding/${this.fundingNo}`, {  writer, category, title, image, content, summary, fundingEnd, endMoney, nowMoney })
            .then(res => {
                alert('수정 성공')
            this.$router.push({
              name: 'FundingReadPage',
              params: { fundingNo: res.data.fundingNo.toString() }
            })
          })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    },
    created () {
        this.fetchFunding(this.fundingNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>