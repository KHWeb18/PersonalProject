<template>
  <v-app>
    <v-container>
      <!-- {{ check }} -->
      <v-card>
        <v-card-text>
          <validation-observer
            v-slot="{ invalid }"
            ref="observer"
          >
            <v-form @submit.prevent="submit">
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                  max: true|15,
                }"
                name="name"
              >
                <v-text-field
                  v-model="name"
                  label="Name"
                  :error-messages="errors"
                  :counter="15"
                />
              </validation-provider>

              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                  max: true|25,
                }"
                name="password"
              >
                <v-text-field
                  v-model="password"
                  label="Password"
                  :error-messages="errors"
                  :counter="25"
                  type="password"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  confirmed: 'password',
                  required: true,
                }"
                name="passwordConfirm"
              >
                <v-text-field
                  v-model="passwordConfirm"
                  label="passwordConfirm"
                  :error-messages="errors"
                  :counter="25"
                  type="password"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                  numeric: true,
                  digits: 11
                }"
                name="phoneNumber"
              >
                <v-text-field
                  v-model="phoneNumber"
                  label="PhoneNumber"
                  :error-messages="errors"
                  :counter="11"
                />
              </validation-provider>
              <v-row no-gutters>
                <v-col>
                  <validation-provider
                    v-slot="{ errors }"
                    :rules="{
                      required: true,
                      email: true
                    }"
                    name="email"
                  >
                    <v-text-field
                      v-model="email"
                      label="E-Mail"
                      name="email"
                      :error-messages="errors"
                    />
                  </validation-provider>
                </v-col>
                <v-col
                  align-self="center"
                  class="ml-3"
                >
                  <v-btn
                    class="mr-3"
                    :disabled="email == null"
                    text
                    @click="checkDuplicate"
                  >
                    중복검사
                  </v-btn>
                </v-col>
              </v-row>
              <validation-provider
                v-slot="{ errors }"
                label="Select"
                name="select"
                :rules="{
                  required: true
                }"
              >
                <v-row>
                  <v-col>
                    <v-select
                      v-model="team"
                      :error-messages="errors"
                      label="Team"
                      :items="items"
                    />
                  </v-col>
                  <v-col>
                    <v-select
                      v-model="auth"
                      :error-messages="errors"
                      label="Auth"
                      :items="roles"
                    />
                  </v-col>
                </v-row>
              </validation-provider>

              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true
                }"
                name="checkbox"
              >
                <v-checkbox
                  v-model="checkbox"
                  label="Agree"
                  name="checkbox"
                  :error-messages="errors"
                  value="1"
                />
              </validation-provider>

              <v-btn
                class="mr-3"
                :disabled="invalid"
                @click="submit"
              >
                submit
              </v-btn>
              <v-btn
                class="ml-3"
                @click="clear"
              >
                clear
              </v-btn>
            </v-form>
          </validation-observer>
        </v-card-text>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'Forms',

  data: ()=> ({
    name: null,
    phoneNumber: null,
    password: null,
    email: null,
    checkbox: null,
    team: null,
    auth: null,
    passwordConfirm: null

  }),
  computed: {
    ...mapState('authentication', {
      items: 'items',
      roles: 'roles'
    }),
    // check() {
    //   return this.checkSate()
    // }
  },

  methods: {
    checkSate() {
      if(this.$store.getters['authentication/getCheckDuplicate']) {
        this.email = null
      }
    },

    submit() {
      this.$refs.observer.validate().then(result => {
        if(result) {
          this.$store.dispatch('authentication/register',
            { name: this.name,
              phoneNumber: this.phoneNumber,
              password: this.password,
              email: this.email,
              team: this.team,
              auth: this.auth
            } )
        }
        this.clear()
        this.$emit('change')
      })
    },

    checkDuplicate() {
      this.$store.dispatch('authentication/checkDuplicate', {
        email: this.email
      })
    },

    clear() {
      this.name = null
      this.phoneNumber = null
      this.password = null
      this.passwordConfirm = null
      this.email = null
      this.checkbox = null
      this.team = null
      this.auth = null
    }
  },


}
</script>

<style>

</style>
