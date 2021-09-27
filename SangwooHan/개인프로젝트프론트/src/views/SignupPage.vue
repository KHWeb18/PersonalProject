<template>
    <div align="center">

        <signup-register-form @submit="onSubmit" :members="members"/>
       <p><img src="@/assets/상우/회원가입사진.png"/></p>
    </div>
    
</template>

<script>
import SignupRegisterForm from '../components/Signup/SignpupRegisterForm.vue'
import {mapActions, mapState} from 'vuex'
import axios from 'axios'
export default {
    name: 'SignupPage',
    components: {
        SignupRegisterForm,
     
    },
    methods: {
        onSubmit(payload){
                const {userid, password, name, email, birthday, gender, address, phoneNo} = payload
                axios.post('http://localhost:9999/jpamemberManage/register', {userid, password, name, email, birthday, gender, address, phoneNo})
                .then(res =>{
                    alert('회원가입 성공' + res)
                    this.$router.push({
                        name: 'Home'
                    }) 
                }).catch(res => {
                    alert(res.response.data.message)
                })
                
                
        },
        ...mapActions(['fetchMemberList']),
        
    },
    computed: {
        ...mapState(['members'])
    },
    mounted() {
        this.fetchMemberList()
    },

}
</script>

<style scoped>

</style>