<template>
    <div>
        <div align="center">
            <h2>회원 가입</h2>
        </div>
        <member-join-column-test-form @submit="onSubmit"/>
        
        <v-spacer></v-spacer>
       
            
     
    </div>
</template>

<script>
import MemberJoinColumnTestForm from '@/components/member/MemberJoinColumnTestForm.vue'
import axios from 'axios'
export default {
    name: 'MemberRegisterPage',
    components: {
        MemberJoinColumnTestForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, name, password, address, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', {
                        userId, name, password, address, auth
                    })
                    .then(res => {
                        alert('회원가입이 완료되었습니다' + res)
                        
                        this.$router.push({
                            name: 'Home'
                            
                        })
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>