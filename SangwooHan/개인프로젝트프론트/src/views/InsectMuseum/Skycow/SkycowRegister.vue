<template>
    <div><v-container>
        <insect-museum-register-bar/>
       <skycow-register-form @submit="OnSubmit"/>
       </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import SkycowRegisterForm from '../../../components/InsectMuseum/Skycow/SkycowRegisterForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'

export default {
  components: {InsectMuseumRegisterBar ,SkycowRegisterForm },
  methods: {
      OnSubmit(payload){
            const {id , title, text } =payload

            axios.post('http://localhost:9999/skycow/register',{id , title, text })
            .then(res =>{
                alert("등록완료" +res) 
            }).catch(err =>{err.response.message})
      }
  }
    
}
</script>
    