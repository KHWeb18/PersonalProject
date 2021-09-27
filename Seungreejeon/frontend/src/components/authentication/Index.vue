<template>
  <v-app>
    <sign-in />
    <Snackbar />
    <loader />
  </v-app>
</template>

<script>

import SignIn from './Signin.vue'
import Snackbar from '@/components/layouts/default/snack/Snack.vue';
import Loader from '@/components/layouts/default/loader/Loader.vue';


export default {
  name: 'Authentication',
  components: {
    SignIn,
    Snackbar,
    Loader
  }
}
</script>


