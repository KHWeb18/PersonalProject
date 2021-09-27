<template>
    <div>
        <v-container>
        <insect-museum-register-bar/>
        <stagbeetle-register-form   @submit="OnSubmit"/>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'

import StagbeetleRegisterForm from '../../../components/InsectMuseum/Stagbeelte/StagbeetleRegisterForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'


export default {
    name: 'StagbeetleRegister',
    components:{
        StagbeetleRegisterForm,
        InsectMuseumRegisterBar,
   
       
    },

    methods: {
        OnSubmit(payload){
            const {id , title, text } = payload
            axios.post('http://localhost:9999/stagbeetle/register', {id, title, text })
            .then(res => {
                alert('등록성공' +res)
                
            })
            .catch( err => { 
                alert(err.response.data.message)
            })
        }
    }
}
</script>