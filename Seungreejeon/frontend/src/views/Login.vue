<template>
  <v-app>
    <v-container
      fluid
    >
      <v-card-title>
        Form resetValidation
      </v-card-title>

      <v-card-text>
        <validation-observer
          ref="observer"
          v-slot="{ invalid }"
        >
          <v-form @submit.prevent="submit">
            <validation-provider
              v-slot="{ errors }"
              name="이름칸 "
              :rules="{
                required: true,
                max:10
              }"
            >
              {{ errors }}
              <v-text-field
                v-model="name"
                label="name"
                :counter="20"
                :error-messages="errors"
              />
            </validation-provider>
            <validation-provider
              v-slot="{ errors }"
              name="phoneNumber"
              :rules="{
                required: true,
                numeric: true,
                digits: 11
              }"
            >
              <v-text-field
                v-model="phoneNumber"
                counter="11"
                label="phoneNumber"
                :error-messages="errors"
              />
            </validation-provider>
            <validation-provider
              v-slot="{ errors }"
              name="e-mail"
              :rules="{
                required: true,
                email: true
              }"
            >
              <v-text-field
                v-model="email"
                label="E-Mail"
                :error-messages="errors"
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
              <v-select
                v-model="select"
                :error-messages="errors"
                label="Select"
                :items="items"
              />
            </validation-provider>
            <validation-provider
              v-slot="{ errors }"
              name="checkbox"
              :rules="{
                required: true
              }"
            >
              <v-checkbox
                v-model="checkbox"
                :error-messages="errors"
                label="Checkbox"
                value="1"
              />
            </validation-provider>

            <v-btn
              type="submit"
              class="mr-3"
              color="primary"
              :disabled="invalid"
            >
              SUBMIT
            </v-btn>

            <v-btn
              class="ml-1"
            >
              CLEAR
            </v-btn>
          </v-form>
        </validation-observer>
      </v-card-text>
    </v-container>
  </v-app>
</template>

<script>

export default {
  name: 'Form',
  components: {
  },

  data: () => ({
    email: null,
    name: null,
    phoneNumber: null,
    checkbox: null,
    select: null,
    Customvalue: null,
    items: [
      {text: '아이템1', value: 1},
      {text: '아이템2', value: 2},
      {text: '아이템3', value: 3},
    ]
  }),
  methods: {
    submit() {
      this.$refs.observer.validate().then(result => {
        if(result) {
          alert('양식제출')
        }
      })

    }
  },
  clear() {
    this.name= null;
    this.phoneNumber= null;
    this.email= null;
    this.select= null;
    this.checkbox= null;
  },

}
</script>

<style>

</style>
