<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <div class="로그인중하단" align="center">

        <b-form 
            style="width:400px" 
            @submit="onSubmit" 
        >

          <b-form-group
            id="input-group-1"
            label=""
            label-for="input-1"
            description="Please enter in email format."
          >
            <b-form-input
              id="input-1"
              v-model="email"
              type="email"
              placeholder="Enter email"
              required
              size="lg"
            ></b-form-input>
          </b-form-group>

          <br>

          <b-form-group 
            id="input-group-2" 
            label="" 
            label-for="input-2"
          >
            <b-form-input
              id="input-2"
              v-model="password"
              :state="passState"
              aria-describedby="input-live-feedback"
              type="password"
              placeholder="Enter password"
              required
              size="lg"
            ></b-form-input>

            <b-form-invalid-feedback id="input-live-feedback">
            Enter at least 8 letters
            </b-form-invalid-feedback>

          </b-form-group>

          <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
              id="checkboxes-4"
              :aria-describedby="ariaDescribedby"
            >
          </b-form-checkbox-group>
          </b-form-group>
<!-- 
            <br>
          <v-btn type="submit" dark block large>로그인</v-btn>
          <br>
          <br>
          <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'SignUpPage' }">
                  <h6>ID가 없으십니까? 지금 만드세요.</h6>
          </router-link>   -->
        </b-form>
        <br>
            <v-btn color="blue" dark type="submit" large style="width:400px">로그인</v-btn>
            <br>
            <br>
          <router-link style="text-decoration: none; color:black" 
              :to="{ name: 'SignUpPage' }">
                  <h6>ID가 없으십니까? 지금 만드세요.</h6>
          </router-link>  
      </div>
    </form>
  </v-container>
</template>

<script>
  export default {

    name: 'LoginForm',
    data () {
        return {
            email: '',
            password: ''
        }
    },
    computed: {
      passState() {
        return this.password.length >= 8 ? true : false
      }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            this.$emit('submit', { email, password })
        }
      }
  }
</script> 

<style scoped>
.로그인중하단 {
  padding:0px 0px 80px 0px;
}
</style>