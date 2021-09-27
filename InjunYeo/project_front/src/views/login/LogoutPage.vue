<template>
    <div>
        
    </div>
</template>

<script>

import axios from 'axios'


export default {
    name:'LogoutPage',
    mounted(){
        if(this.$cookies.get('user') != null){
             axios.post('http://localhost:9999/user-login/removeSession')
            .then( ()=>{
                this.$cookies.remove("user")
                this.$store.state.session = null
                this.$router.go()
            })
        }
        else{
            this.$router.push({
                name:'MainPage'
            })
        }
    },

    
}
</script>