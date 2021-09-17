<template>
    <div align="center">
    <login-page-form :members="members"/>
    </div>
</template>

<script>
import LoginPageForm from '../../components/Login/LoginPageForm.vue'
import {mapState, mapActions} from 'vuex'
export default {
    name: 'LoginPage',
    components: {
        LoginPageForm
      
    },
     computed: {
          ...mapState(['members'])
      },
      mounted () {
          this.fetchMemberList()
      },
      methods: {
          ...mapActions(['fetchMemberList'])
      }
}
</script>