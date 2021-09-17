<template>
    <v-container>
        <login-and-register-form>
        </login-and-register-form>
    </v-container>
</template>


<script>

import LoginAndRegisterForm from '../../components/loginAndRegister/LoginAndRegisterForm.vue'

export default {
    name:'LoginAndRegisterPage',
    components:{

        LoginAndRegisterForm
    }


}
</script>