<template>
      <div align="center">
        <funding-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import FundingRegisterForm from '@/components/funding/FundingRegisterForm.vue'
import axios from 'axios'

export default {
  name: 'FundingRegisterPage',
  components: {
    FundingRegisterForm
  },
  data() {
    return {
       
    }
  },
  methods: {
        onSubmit (payload) {
            const { writer, category, title, fundingEnd, content, summary, image, endMoney, nowMoney } = payload
            axios.post('http://localhost:7777/funding/basic', { writer, category, title, fundingEnd, content, summary, image, endMoney, nowMoney })
                    .then(res => {
                         alert('저장 성공! - ' + res)
                         this.$router.push("funding");
                        //console.log('저장한 펀딩 기본정보 번호: ' + res.data.fundingNo.toString())
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
    }
}
</script>

