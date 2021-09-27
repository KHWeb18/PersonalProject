<template>
    <div><v-container>
         <insect-museum-register-bar/>
        <dragonfly-register-form @submit="OnSumit"/>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import DragonflyRegisterForm from '../../../components/InsectMuseum/Dragonfly/DragonflyRegisterForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'
export default {
    name: 'DragonflyRegister',
    components: {
        DragonflyRegisterForm,
        InsectMuseumRegisterBar
 
    },
    methods: {
        OnSumit(payload) {
            const {id, text , title} = payload

            axios.post('http://localhost:9999/dragonfly/register', {id, text, title})
            .then( res=> {
                alert('등록성공 ' + res)
            }).catch(err=>{alert(err.response.data.message)})
        }
    }
}
</script>
        