<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div class="회원가입중하단" align="center">
            
            <b-form 
                style="width:400px"
                @submit="onSubmit" 
            >

                <b-form-group
                    id="input-group-1"
                    label="ID:"
                    description="Please enter in email format."
                >
                    <b-form-input
                    v-model="email"
                    type="email"
                    placeholder="Enter email"
                    required
                    size="lg"
                    ></b-form-input>
                </b-form-group>

                <br>

                <b-form-group 
                label="Passord:">
                    <b-form-input
                    v-model="password"
                    :state="passState"
                    aria-describedby="input-live-feedback"
                    type="password"
                    placeholder="Enter Passord"
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

            <!-- <br>
            <v-btn type="submit" dark block large>가입하기</v-btn> -->
            
            </b-form>

            <br>
            <v-btn color="blue" dark type="submit" large style="width:400px">가입하기</v-btn>
            </div>
        </form>
    </v-container>
</template>

<script>

export default {
    name: 'SignUpForm',
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

.회원가입중하단 {
    padding:0px 0px 100px 0px;
}
</style>