<template>
    <div>
        <v-container>
       <insect-museum-register-bar/>
        <butterfly-register-form @submit="OnSubmit"/>
        </v-container>
    </div>
</template>
<script>
import axios from 'axios'
import ButterflyRegisterForm from '../../../components/InsectMuseum/Butterfly/ButterflyRegisterForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'


export default {
    name:'ButterflyRegister',
    components: {
        ButterflyRegisterForm,
        InsectMuseumRegisterBar    
    },

    methods: {
        OnSubmit(payload) {
            const {id ,title, text} = payload

            axios.post('http://localhost:9999/butterfly/register', {id ,title, text})
            .then( res => {
                alert('등록완료' +res)
            }).catch(err=>{
                alert(err.response.data.message)
            })
        }
    }
    
}
</script>,
  
        