<template>
  <v-container>
    <v-btn
      color="orange"
      dark
      icon
      @click.stop="dialog = true"
    >
      New Event
    </v-btn>
    <v-dialog
      v-model="dialog"
      max-width="500"
      v-bind="$attrs"
      v-on="$listeners"
    >
      <v-card>
        <v-container>
          <validation-observer
            v-slot="{ invalid }"
            ref="observer"
          >
            <v-form @submit.prevent="addEvent">
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                  max: 15
                }"
                name="event name"
              >
                <v-text-field
                  v-model="name"
                  type="text"
                  label="event name"
                  :error-messages="errors"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                  max: 50
                }"
                name="detail"
              >
                <v-text-field
                  v-model="details"
                  type="text"
                  label="detail"
                  :error-messages="errors"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                }"
                name="start Date"
              >
                <v-text-field
                  v-model="start"
                  type="date"
                  label="start"
                  :error-messages="errors"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                }"
                name="end Date"
              >
                <v-text-field
                  v-model="end"
                  type="date"
                  label="end"
                  :error-messages="errors"
                />
              </validation-provider>
              <validation-provider
                v-slot="{ errors }"
                :rules="{
                  required: true,
                }"
                name="color"
              >
                <v-text-field
                  v-model="color"
                  type="color"
                  label="color"
                  :error-messages="errors"
                />
              </validation-provider>
              <v-btn
                type="submit"
                color="primary"
                class="mr-4"
                :disabled="invalid"
                @click.stop="dialog = false"
              >
                Add Event
              </v-btn>
            </v-form>
          </validation-observer>
        </v-container>
      </v-card>
    </v-dialog>

    <v-dialog
      v-model="dialogDate"
      max-width="500"
      v-bind="$attrs"
      v-on="$listeners"
    >
      <v-card>
        <v-container>
          <v-form @submit.prevent="addEvent">
            <v-text-field
              v-model="name"
              type="text"
              label="event name (required)"
            />
            <v-text-field
              v-model="details"
              type="text"
              label="detail"
            />
            <v-text-field
              v-model="start"
              type="date"
              label="start (required)"
            />
            <v-text-field
              v-model="end"
              type="date"
              label="end (required)"
            />
            <v-text-field
              v-model="color"
              type="color"
              label="color"
            />
            <v-btn
              type="submit"
              color="primary"
              class="mr-4"
              @click.stop="dialog = false"
            >
              create event
            </v-btn>
            {{ details }}
          </v-form>
        </v-container>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  inheritAttrs: false,
  data: () => ({
    dialogDate: false,
    dialog: false,
    name: null,
    details: null,
    start: null,
    end: null,
    color: null,
  }),
  methods: {
    addEvent() {
      this.$store.dispatch('calendar/addEvent',
        {
          name: this.name,
          details:this.details,
          start: this.start,
          end: this.end,
          color: this.color,
          email: localStorage.getItem('email')
        })
    }
  }
}
</script>

<style>

</style>
