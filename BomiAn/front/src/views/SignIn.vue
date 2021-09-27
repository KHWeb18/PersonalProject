<template>
  <v-container>
    <h2 class="pb-7">Sign In</h2>
    <v-form>
    <v-text-field
      v-model="user.email"
      label="E-mail"
      color="rgb(0, 255, 1)"
      required
    ></v-text-field>
    
    <v-text-field
      v-model="user.password"
      type="password"
      label="Password"
      color="rgb(0, 255, 1)"
      required
    ></v-text-field>

    <v-btn
      color="rgb(0, 255, 1)"
      class="btn mr-4 black--text"
      @click="signIn"
    >
      Signin
    </v-btn>

    <v-btn
      color="rgb(216, 32, 37)"
      class="btn mr-4 black--text"
      @click="cancel"
    >
      cancel
    </v-btn>
  </v-form>
  </v-container>
</template>


<script>
  export default {
    data: () => ({
      valid: true,
      user: {
        email: '', 
        password: ''
      },
    }),
    methods: {
      signIn () {
        this.$http.post('/api/signIn', {user:this.user})
            .then(res => {
              if(res.data.success == true) {
                alert(res.data.message)
                this.$store.commit("user", res.data.userInfo)
                this.$cookies.set("user", res.data.userInfo, '1h')
                this.$store.state.isLogin = true
                this.$router.push('/')
              } else {
                alert(res.data.message)
                this.user.email = ''
                this.user.password = '' 
              }
            })
      },
      cancel() {
        this.$router.push('/')
      }
    },
  }
</script>

<style scoped>
h2 {
  font-family: 'SpaceMono-Bold';
  color: rgb(0, 255, 1);
}

.btn {
  font-weight: 1000;
}
</style>