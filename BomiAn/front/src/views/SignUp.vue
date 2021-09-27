<template>
  <v-container>
    <h2 class="pb-7">Sign Up</h2>
    <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="user.nickname"
      :counter="20"
      :rules="nameRules"
      label="Nickname"
      color="rgb(0, 255, 1)"
      required
    ></v-text-field>

    <v-text-field
      v-model="user.email"
      :rules="emailRules"
      label="E-mail"
      color="rgb(0, 255, 1)"
      required
    ></v-text-field>
    
    <v-text-field
      v-model="user.password"
      :rules="passwordRules"
      :counter="8"
      type="password"
      label="Password"
      color="rgb(0, 255, 1)"
      required
    ></v-text-field>


    <v-checkbox
      v-model="checkbox"
      :rules="[v => !!v || 'You must agree to continue!']"
      label="Do you agree?"
      required
    ></v-checkbox>

    <v-btn
      :disabled="!valid"
      color="rgb(0, 255, 1)"
      class="btn mr-4 black--text"
      @click="validate"
    >
      signup
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
        nickname: '',
        email: '', 
        password: ''
      },
      nameRules: [
        v => !!v || 'Nickname is required',
        v => (v && v.length <= 20) || 'Name must be less than 20 characters',
      ],
      passwordRules: [
        v => !!v || 'Password is required',
        v => (v && v.length >= 8) || 'Name must be more than 8 characters',
      ],
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      checkbox: false,
    }),

    methods: {
      validate () {
        this.$refs.form.validate()
        this.$http.post('/api/signUp', {user:this.user})
            .then(res => {
              if(res.data.success == true) {
                alert(res.data.message)
                this.$router.push('/signIn')
              } else {
                alert(res.data.message)
                this.$refs.form.reset()
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