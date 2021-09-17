<template>
<div>
    <notice-register-form @submit="OnSubmit"/>
</div>
</template>

<script>
import axios from 'axios'
import NoticeRegisterForm from '../../components/Notice/NoticeRegisterForm.vue'


export default {
  components: { NoticeRegisterForm },
    name: 'NoticeRegisterPage',
    
    methods: {
        OnSubmit(payload) {
            const {id , title, text, type1 } = payload
            
            axios.post('http://localhost:9999/jpaNotice/register', {id, title, text, type1 })
            .then( res => {
                alert('등록성공' +res)
                this.$router.push({name: 'NoticeListPage'})
            })

        }
    }
}
</script>