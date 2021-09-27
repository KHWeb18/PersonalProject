<template>
    <div>
        <form @submit.prevent="OnSubmit">
            <table>
                <tr>
                    <td>제목</td>
                    <input v-model="title"/>
                </tr>
                <tr>
                    <td>내용</td>
                    <textarea v-model="text"/>
                </tr>
                <v-btn type="submit">등록</v-btn>
            </table>


        </form>
    </div>
</template>

<script>
import axios from 'axios'
import {  mapState } from 'vuex'
export default {
    name: 'PersonalQusetionRegisterForm',
    computed: {
    ...mapState(['User'])
    },
    data() {
        return{
            title: '',
            text: '',
            
        }
    },
    methods:{
        OnSubmit(){
                const {title,text, User} = this 

                axios.post('http://localhost:9999/CustomerSound/register', {title, text, id:User})
                .then( () => {
                    alert('등록완료')
                    this.$router.go(-1)
                })


        }
    },
}
</script>

<style scoped>

table {
  font-weight: bold;
  background: #eee;
}
textarea {
  width: 700px;
  height: 700px;
 
}
</style>