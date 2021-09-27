<template>
  <v-app>
    <v-container>
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
                </v-row>
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
    team: null,
  }),
  computed: {
    ...mapState('authentication', {
      items: 'items',
      roles: 'roles'
    }),
  },

  methods: {

    submit() {
      this.$refs.observer.validate().then(res => {
        if(res) {
          this.$store.dispatch('authentication/findAccount',
            {
              name: this.name,
              phoneNumber: this.phoneNumber,
            })
        }
        this.clear()
        this.$emit('change')
      })
    },

    clear() {
      this.name = null
      this.phoneNumber = null
      this.team = null
    }
  },

}
</script>

<style>

</style>
