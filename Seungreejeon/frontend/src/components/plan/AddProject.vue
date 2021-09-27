<template>
  <v-dialog
    v-model="dialog"
    max-width="600px"
  >
    <template v-slot:activator="{ on , attrs}">
      <v-btn
        slot="activator"
        text
        class="success"
        v-bind="attrs"
        width="100"
        v-on="on"
      >
        <h5>
          New Prject
        </h5>
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <h5>Add a New Project</h5>
      </v-card-title>
      <v-card-text>
        <validation-observer
          v-slot="{ invalid }"
          ref="observer"
        >
          <v-form
            ref="form"
            class="px-3"
          >
            <validation-provider
              v-slot="{ errors }"
              :rules="{
                required: true,
              }"
              name="title"
            >
              <v-text-field
                v-model="title"
                label="Title"
                prepend-icon="mdi-pencil"
                :error-messages="errors"
              />
            </validation-provider>

            <validation-provider
              v-slot="{ errors }"
              :rules="{
                required: true,
              }"
              name="status"
            >
              <v-select
                v-model="stat"
                :items="status"
                label="Status"
                prepend-icon="mdi-alarm-check"
                :error-messages="errors"
              />
            </validation-provider>

            <v-row>
              <v-col cols="6">
                <validation-provider
                  v-slot="{ errors }"
                  :rules="{
                    required: true,
                  }"
                >
                  <v-menu max-width="290">
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        slot="activator"
                        label="Due Date"
                        prepend-icon="mdi-calendar-range"
                        v-bind="attrs"
                        :value="due"
                        :error-messages="errors"
                        v-on="on"
                      />
                    </template>
                    <v-date-picker
                      v-model="due"
                    />
                  </v-menu>
                </validation-provider>
              </v-col>
            </v-row>

            <v-spacer />

            <v-btn
              class="success mx-0 mt-3"
              small
              :loading="loading"
              :disabled="invalid"
              @click="submit"
            >
              Add projcect
            </v-btn>
          </v-form>
        </validation-observer>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script>
import { mapState } from 'vuex'

export default {
  data: ()=> ({
    title: '',
    stat: '',
    due: null,
    loading: false,
    dialog: false
  }),
  computed: {
    ...mapState('project', {
      status: 'status'
    })
  },

  methods: {
    submit() {
      if (this.$refs.form.validate()) {
        this.loading = true;
        // after res false

        this.$store.dispatch('project/addProject',
          {
            title:this.title,
            due: this.due,
            person: localStorage.getItem('name'),
            status: this.stat,
            team: localStorage.getItem('team')
          })
      }
      // db에서 받게되면 수행할것
      this.dialog = false

    }
  }

}
</script>

<style>

</style>
