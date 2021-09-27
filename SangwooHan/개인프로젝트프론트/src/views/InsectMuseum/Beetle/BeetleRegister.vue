<template>
    <div>
        <v-container>
       <insect-museum-register-bar/>
      <beetle-register-form @submit="OnSubmit"/>
      </v-container>
    </div>
</template>

<script>
import axios from 'axios'


import BeetleRegisterForm from '../../../components/InsectMuseum/Beetle/BeetleRegisterForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'
export default {
    name: 'BeetleRegister',
    components: {
        BeetleRegisterForm,
        InsectMuseumRegisterBar,


    },
    methods: {
       
         OnSubmit (payload) {
                const {id , text , title} = payload
                axios.post('http://localhost:9999/beetle/register', {id, text,title})
                .then( res => {
                    alert('등록성공' + res) 
                }).catch(err=>{alert(err.response.data.message)})
        }
    }
}
</script>