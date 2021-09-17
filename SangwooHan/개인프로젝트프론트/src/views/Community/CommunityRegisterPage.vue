<template>
    <div>
        <v-container>
     <community-register-form @submit="OnSubmit"/>
        </v-container>
    </div>
</template>

<script>
import CommunityRegisterForm from '../../components/Community/CommunityRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'CommunityRegisterPage',
    components: {
        CommunityRegisterForm
    },
    methods:{
        OnSubmit (payload){
                const {id ,title , text} =payload
                axios.post('http://localhost:9999/jpaBoard/register', {id, title, text})
                .then(res => {
                    alert('등록완료' +res)
                    this.$router.push({ name: 'CommunityListPage'})
                }).catch(res =>{
                    alert(res.response.data.message)
                })
        }
    }
}
</script>